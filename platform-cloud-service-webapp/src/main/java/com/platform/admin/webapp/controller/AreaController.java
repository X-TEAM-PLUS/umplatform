package com.platform.admin.webapp.controller;

import com.platform.admin.api.AreaService;
import com.platform.admin.api.vo.AreaVO;
import com.platform.admin.common.result.JsonResult;
import com.platform.admin.api.vo.tree.ExtTreeNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:50
 * 功能:T_MANAGE_AREA表控制器
 */

@Controller
@RequestMapping("/umplatform/area")
public class AreaController {
    private static final Log log = LogFactory.getLog(AreaController.class);

    @javax.annotation.Resource
    private AreaService areaServiceImpl;


    @RequestMapping(value = "/index")
    public String index() {
        return "/area/index";
    }

    /**
     * 查询列表页
     *
     * @param area
     * @return
     */
    @RequestMapping(value = "/getTree")
    @ResponseBody
    public List<ExtTreeNode> getTree(AreaVO area) {
        try {
            if (area != null
                    && area.getName() != null
                    && !"".equalsIgnoreCase(area.getName())) {
                area.setName(new String(area.getName().getBytes("ISO-8859-1"), "UTF-8"));
            }
        } catch (Exception e) {
            log.error("查询异常", e);
        }

        return areaServiceImpl.getTree(area);
    }

    /**
     * 查询列表页
     *
     * @param area
     * @return
     */
    @RequestMapping(value = "/getAll")
    @ResponseBody
    public JsonResult getAll(AreaVO area) {
        JsonResult result = new JsonResult();
        try {
            List<AreaVO> data = areaServiceImpl.queryAll();
            // 设置结果集
            result.put("list", data);
            result.put("rowCount", data.size());
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("查询异常", e);
            result.setMessage("查询异常");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 新增记录
     *
     * @param area
     * @return
     */
    @RequestMapping(value = "/post")
    @ResponseBody
    public JsonResult post(AreaVO area) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //保存
            areaServiceImpl.insert(area);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("提交数据异常", e);
            result.setMessage("提交数据异常");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 删除记录
     *
     * @param area
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public JsonResult delete(AreaVO area) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //删除记录
            areaServiceImpl.delete(area);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("删除数据异常", e);
            result.setMessage("删除数据异常");
            result.setSuccess(false);
        }
        return result;
    }


    /**
     * 更新记录
     *
     * @param area
     * @return
     */
    @RequestMapping(value = "/put")
    @ResponseBody
    public JsonResult put(AreaVO area) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //更新记录
            areaServiceImpl.update(area);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 记录详情
     *
     * @param area
     * @return
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public JsonResult get(AreaVO area) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //更新记录
            areaServiceImpl.get(area);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
    }
}
