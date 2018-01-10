<!DOCTYPE html>
<html>
<head>
<#import '../common/common.ftl' as commonMacro>
<@commonMacro.commonStyle />
<@commonMacro.commonScript />

</head>
<body>
<div class="page-bar">
    <ul class="page-breadcrumb">
        <li>
            <i class="fa fa-home"></i>
            <a href="/welcome">首页</a>
            <i class="fa fa-angle-right"></i>
        </li>
        <li>
            <i class="icon-users"></i>
            <a href="index">角色管理</a>
            <i class="fa fa-angle-right"></i>
        </li>
        <li>
            <a href="javascript:;">编辑角色</a>
            <i class="fa fa-plus"></i>
        </li>
    </ul>
</div>
<div class="portlet box grey-cascade">
    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-plus"></i>编辑角色
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse" data-original-title="" title="">
            </a>
            <a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title="">
            </a>
            <a href="javascript:;" class="reload" data-original-title="" title="">
            </a>
            <a href="javascript:;" class="remove" data-original-title="" title="">
            </a>
        </div>
    </div>
    <div class="portlet-body form">
    <!-- BEGIN FORM-->
    <form action="/umplatform/role/put"  class="horizontal-form">

        <div class="form-body">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label">角色名称<span class="required">
										* </span>
                        </label>
                        <div class="input-group">
                            <span class="input-group-addon input-circle-left">
							    <i class="fa fa-font"></i>
							</span>
                            <div class="input-icon right">
                                <i class="fa"></i>
                            <input type="text" id="roleName" name="roleName" class="form-control required" placeholder="角色名称" value="${(role.roleName)!''}" validate="{required: true}">
                            </div>
                        </div>
                    </div>
                </div>
                <input type="hidden" name="id"  value="${role.id}" >
                <input type="hidden" name="resourceIds" id="resourceIds" value="${(role.resourceIds)!''}" >
                <!--/span-->
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label">角色图标<span class="required">
										* </span>
                        </label>
                        <div class="input-group">
                            <span class="input-group-addon input-circle-left">
							    <i class="fa fa-image"></i>
							</span>
                            <input type="text" id="icon" name="icon" class="form-control required" placeholder="角色图标" value="${(role.icon)!''}" validate="{required: true}">
                        </div>
                    </div>
                </div>
                <!--/span-->
            </div>
            <!--/row-->
            <div class="row">
                <div class="col-md-12 ">
                    <div class="form-group">
                        <label class="control-label">角色描述</label>
                        <div class="input-group">
                            <span class="input-group-addon input-circle-left">
							    <i class="fa   fa-info-circle"></i>
							</span>
                            <input type="text" id="remark" name="remark" class="form-control" placeholder="角色描述" value="${(role.remark)!''}" validate="{required: true}">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 ">
                        <label class="control-label">权限列表</label>
                            <table id="resourceTreeTable" class="gtreetable table table-hover table-light col-md-12">
                                <thead>
                                <tr>
                                    <th column="text"><label>资源名称</label></th>
                                    <th column="type"><label>资源类型</label></th>
                                    <th column="remark"><label>描述</label></th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
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
</div>
<SCRIPT>
    $(document).ready(function () {
        $("#resourceTreeTable").loadTreeTable({
            url:contextPath+'/umplatform/resource/getTreeWithRoleId?roleId=' +"${role.id}",
            checkBox:true,
            expandable: true
            ,parmaName:'resourceIds'
        });
    });

</SCRIPT>
</body>
</html>


