package com.platform.admin.service.convert;

/**
 * Created by songxinlei on 2016/4/11.
 */
public interface ConvertCommon<V, P> {
    /**
     * PO 转 VO
     *
     * @param p 数据库对象
     * @return v 页面展现对象
     */
    public V toVO(P p);


    /**
     * VO 转 PO
     *
     * @param v 页面展现对象
     * @return p 数据库对象
     */
    public P toPO(V v);
}
