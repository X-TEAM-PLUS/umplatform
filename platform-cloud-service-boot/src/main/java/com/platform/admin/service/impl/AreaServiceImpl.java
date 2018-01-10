package com.platform.admin.service.impl;

import com.platform.admin.api.vo.AreaVO;
import com.platform.admin.api.vo.tree.ExtTreeNode;
import com.platform.admin.dao.AreaDao;
import com.platform.admin.domain.Area;
import com.platform.admin.service.convert.AreaConvert;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:50
 * 功能:T_MANAGE_AREA表Service接口实现类
 */

@RestController
@RequestMapping("/platform/areaService")
public class AreaServiceImpl extends AbstractServiceProvider{
    private final static Log log = LogFactory.getLog(AreaServiceImpl.class);

    private AreaConvert myAreaConvert = new AreaConvert();

    @javax.annotation.Resource
    private AreaDao areaDao;

    @RequestMapping("/get")
    public AreaVO get(@RequestBody AreaVO area) throws Exception {
        Area areaPO = areaDao.get(myAreaConvert.toPO(area));
        return myAreaConvert.toVO(areaPO);
    }


    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/insert")
    public int insert(@RequestBody AreaVO area) throws Exception {
        return areaDao.insert(myAreaConvert.toPO(area));
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/delete")
    public int delete(@RequestBody AreaVO area) throws Exception {
        return areaDao.delete(myAreaConvert.toPO(area));
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/update")
    public int update(@RequestBody AreaVO area) throws Exception {
        return areaDao.update(myAreaConvert.toPO(area));
    }


    @RequestMapping("/queryAll")
    public List<AreaVO> queryAll() throws Exception {
        List<AreaVO> returnValue = new ArrayList();
        List<Area> areaList = areaDao.queryAll();
        for (Area temp : areaList)
            returnValue.add(myAreaConvert.toVO(temp));
        return returnValue;
    }

    @RequestMapping("/query")
    public List<AreaVO> query(@RequestBody AreaVO area) throws Exception {
        List<AreaVO> returnValue = new ArrayList();
        List<Area> areaList = areaDao.query(myAreaConvert.toPO(area));
        for (Area temp : areaList)
            returnValue.add(myAreaConvert.toVO(temp));
        return returnValue;
    }

    @RequestMapping("/getTree")
    public List<ExtTreeNode> getTree(@RequestBody AreaVO areaDto) {
        List<ExtTreeNode> nodes = new ArrayList<ExtTreeNode>();
        try {

            List<AreaVO> returnValue = new ArrayList();
            List<Area> areaList = areaDao.query(myAreaConvert.toPO(areaDto));
            for (Area temp : areaList)
                returnValue.add(myAreaConvert.toVO(temp));

            Map<String, String> usedMap = new HashMap<String, String>();
            for (AreaVO area : returnValue) {
                //避免重复
                if (usedMap.get(area.getCode().toString()) == null) {
                    ExtTreeNode node = from(returnValue, area, usedMap);
                    nodes.add(node);
                }
            }

        } catch (Exception e) {
            log.error("获取区域树异常", e);
        }

        return nodes;
    }

    private ExtTreeNode from(List<AreaVO> list, AreaVO area, Map<String, String> usedMap) {
        usedMap.put(area.getCode().toString(), "");
        //做标识，避免重复遍历
        ExtTreeNode node = new ExtTreeNode();
        //节点ID
        node.setId(area.getCode().toString());
        //名称
        node.setText(area.getName());
        //父节点id
        node.setParentId(area.getParentCode() == null ? null : area.getParentCode().toString());
        //设置子节点
        //   if(area.getAreaType()<3) {
        node.setChildren(getChilds(list, node.getId(), usedMap));
        //}
        //是否为叶子节点
        if (node.getChildren() != null && node.getChildren().size() > 0) {
            node.setLeaf(false);
        } else {
            node.setLeaf(true);
            node.setChildren(null);
        }

        //other信息
        node.setCreated(area.getCreated());
        node.setUpdated(area.getUpdated());
        node.setOperator(area.getOperator());
        node.setType(area.getAreaType().toString());
        if (area.getAreaType() > 0) {
            node.setExpanded(false);
        }
        return node;
    }


    /**
     * 获取子节点
     *
     * @param list
     * @param id
     * @return
     */
    private List getChilds(List<AreaVO> list, String id, Map<String, String> usedMap) {
        List<ExtTreeNode> nodes = new ArrayList<ExtTreeNode>();
        for (AreaVO dto : list) {
            if (id.equalsIgnoreCase(dto.getParentCode().toString())) {
                ExtTreeNode node = from(list, dto, usedMap);
                nodes.add(node);
            }
        }
        return nodes;
    }
}
