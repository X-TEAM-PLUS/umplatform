<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <%@ include file="../common/head.jsp" %>
</head>
<body class="page-content">
  <div class="page-bar">
    <ul class="page-breadcrumb">
      <li>
        <i class="fa fa-home"></i>
        <a href="index.html">首页</a>
        <i class="fa fa-angle-right"></i>
      </li>
      <li>
        <i class="fa fa-sitemap"></i>
        <a href="#">组织机构管理</a>
        <i class="fa fa-angle-right"></i>
      </li>
      <li>
        <i class="fa fa-edit"></i>
        <a href="#"> 编辑组织结构</a>
      </li>
    </ul>
  </div>
  <div class="row">
    <div class="col-md-12">
      <!-- BEGIN VALIDATION STATES-->
      <div class="portlet box grey-cascade">
        <div class="portlet-title">
          <div class="caption">
            <i class="fa fa-sitemap"></i>编辑组织
          </div>
          <div class="tools">
            <a href="javascript:;" class="collapse">
            </a>
            <a href="#portlet-config" data-toggle="modal" class="config">
            </a>
            <a href="javascript:;" class="reload">
            </a>
            <a href="javascript:;" class="remove">
            </a>
          </div>
        </div>
        <div class="portlet-body form">
          <!-- BEGIN FORM-->
          <form action="/umplatform/organization/put"  id="form_sample_3" class="form-horizontal">
            <input type="hidden" name="id" id="id" value="${organization.id}">
            <input type="hidden" class="form-control" id="parentId" name="parentId"  value="${organization.parentId}"/>
            <div class="form-body ">
              <div class="form-group">
                <label class="control-label col-md-3">${organizationLable}名称 <span class="required">* </span>
                </label>
                <div class="col-md-5">
                  <div class="input-group">
                    <span class="input-group-addon input-circle-left">
                        <i class="fa fa-font"></i>
                    </span>
                    <input type="text" id="name" name="name" placeholder="${organizationLable}名称" data-required="1" class="form-control" value="${organization.name}" validate="{required: true}"/>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-md-3 control-label">${organizationLable}编码
                  <span class="required">* </span>
                </label>
                <div class="col-md-5">
                  <div class="input-group">
                    <span class="input-group-addon input-circle-left">
                     <i class="fa   fa-qrcode"></i>
                    </span>
                    <input type="text" name="code" id="code" class="form-control" placeholder="${organizationLable}编号" value="${organization.code}" validate="{required: true}">
                  </div>
                </div>
              </div>

              <div class="form-group last">
                <label class="control-label col-md-3">${organizationLable}描述：</label>
                <div class="col-md-5">
                  <div class="input-group">
                       <span class="input-group-addon input-circle-left">
                          <i class="fa fa-comment"></i>
                        </span>
                      <textarea class="form-control" id="remark" name="remark" rows="5" placeholder="非必填"> ${organization.remark}</textarea>
                   </div>
                </div>
              </div>

            </div>
            <div class="form-actions right">
              <button type="button" class="btn default" onclick="history.go(-1)"><i class="fa fa-rotate-left"></i> 取消</button>
              <button type="submit" class="btn green"><i class="fa fa-check"></i> 保存</button>
            </div>
          </form>
          <!-- END FORM-->
        </div>
        <!-- END VALIDATION STATES-->
      </div>
    </div>
  </div>
</div>
  <%@ include file="../common/library.jsp" %>
</body>
</html>


