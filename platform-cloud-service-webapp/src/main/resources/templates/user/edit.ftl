<!DOCTYPE html>
<html>
<head>
<#import '../common/common.ftl' as commonMacro>
<@commonMacro.commonStyle />
<@commonMacro.commonScript />

</head>
<body class="page-content">

<div class="page-bar">
    <ul class="page-breadcrumb">
        <li>
            <i class="fa fa-home"></i>
            <a href="/welcome">首页</a>
            <i class="fa fa-angle-right"></i>
        </li>
        <li>
            <a href="#">用户管理</a>
            <i class="icon-credit-card"></i>
            <i class="fa fa-angle-right"></i>
        </li>
        <li class=" active">
            <a href="#">修改用户表单</a>
            <i class="fa fa-tasks text-yellow"></i>
        </li>
    </ul>
</div>
<div class="tab-content">
    <div class="tab-pane active" id="tab_0">
        <div class="portlet box grey-cascade">
            <div class="portlet-title">
                <div class="caption">
                    <i class="fa fa-gift"></i>修改用户表单
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
                <form action="put" id="form1" class="form-horizontal">
                    <input type="hidden" name="id" id="id" value="${(userInfo.id)!''}">
                    <div class="form-body">
                        <div class="form-group">
                            <label class="control-label col-md-3">用 户 名</label>
                            <div class="col-md-4">
                                <div class="input-group">
                                    <span class="input-group-addon input-circle-left">
                                    <i class="fa fa-font"></i>
                                    </span>
                                    <input type="text" class="form-control" maxlength="20" name="userName"
                                           value="${(userInfo.userName)!''}"
                                           id="username2_input"
                                           validate='{"minlength": 2,"required": true}' readonly>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">真实姓名</label>
                            <div class="col-md-4">
                                <div class="input-group">
                                    <span class="input-group-addon input-circle-left">
                                    <i class="fa fa-font"></i>
                                    </span>
                                    <input type="text" class="form-control" maxlength="10" name="realName"
                                           value="${(userInfo.realName)!''}"
                                           id="maxlength_defaultconfig" validate='{"minlength": 2,"required": true}'>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">用户密码</label>
                            <div class="col-md-4">
                                <div class="input-group">
                                    <span class="input-group-addon input-circle-left">
                                    <i class="fa fa-user"></i>
                                    </span>
                                    <input type="password" name="password" class="form-control"
                                           placeholder="Password" value="${(userInfo.password)!''}"
                                           validate='{"minlength": 10,"required": true}'>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">用户邮箱</label>
                            <div class="col-md-4">
                                <div class="input-group">
                                    <span class="input-group-addon input-circle-left">
                                    <i class="fa fa-envelope"></i>
                                    </span>
                                    <input name="email" type="text" class="form-control"
                                           placeholder="Email Address" validate='{"minlength": 3,"email": true}'
                                           value="${(userInfo.email)!''}">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">手机号码 <span class="required">
										* </span>
                            </label>
                            <div class="col-md-4">
                                <div class="input-group">
                                    <span class="input-group-addon input-circle-left">
                                    <i class="fa fa-mobile"></i>
                                    </span>
                                    <input name="mobileNo" type="text" class="form-control" maxlength="11"
                                           id="mobileNo"
                                           validate='{"minlength": 11,"required": true,"mobilephone": true}'
                                           value="${(userInfo.mobileNo)!''}"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">固定电话 <span class="required">
										* </span>
                            </label>
                            <div class="col-md-4">
                                <div class="input-group">
                                    <span class="input-group-addon input-circle-left">
                                    <i class="fa fa-phone"></i>
                                    </span>
                                    <input name="phoneNo" type="text" class="form-control" maxlength="20"
                                           value="${(userInfo.phoneNo)!''}"
                                           id="phoneNo" validate='{"immobilityphone": true}'/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">添加角色</label>
                            <div class="col-md-4">
                                <div class="input-group">
                                    <span class="input-group-addon input-circle-left">
                                    <i class="fa fa-user"></i>
                                    </span>
                                    <select name="roles" class="form-control select2_sample1" multiple="multiple" validate='{"required": true}'>

                                        <#list roleList as p>
                                            <#assign isSuccess=true>
                                            <#if userInfo.roles?exists>
                                            <#assign str1=(userInfo.roles)?split(",")>
                                                <#list str1 as s>
                                                    <#if s == p.id>
                                                        <#assign isSuccess=false>
                                                        <option value="${p.id}" selected="true">${p.roleName}</option>
                                                    </#if>
                                                </#list>
                                            </#if>
                                            <#if isSuccess == true>
                                                <option value="${p.id}">${p.roleName}</option>
                                            </#if>
                                        </#list>


                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">选择机构</label>
                            <div class="col-md-4">
                                <div class="portlet-body">
                                    <input type="hidden" id="organizationId" name="organizationId">
                                    <p>
                                        <a class="btn" id="orgName" data-toggle="modal" style="display: none"></a>
                                        <a class="btn red" id="selectBtn" data-toggle="modal" href="#basic">
                                            点击选择 </a>
                                    </p>
                                    <!-------------------------------- 弹出begin -------------------------------->
                                    <div class="modal fade" id="basic" tabindex="-1" role="basic" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal"
                                                            aria-hidden="true"></button>
                                                    <h4 class="modal-title">选择部门</h4>
                                                </div>
                                                <!------------------------------------------------------------>
                                                <div class="modal-body" style="height:380px; overflow:auto">
                                                    <table id="organizationTreeTable"
                                                           class="table table-striped table-bordered table-hover dataTable treetable col-md-12">
                                                        <thead>
                                                        <tr>
                                                            <th column="text"><label>组织名称</label></th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <!------------------------------------------------------------>
                                                <div class="modal-footer">
                                                    <button type="button" id="closebtn" class="btn default"
                                                            data-dismiss="modal">
                                                        关闭
                                                    </button>
                                                    <button type="button" class="btn blue" onclick="getSelectedOrg();">
                                                        确定
                                                    </button>
                                                </div>
                                            </div>
                                            <!-- /.modal-content -->
                                        </div>
                                        <!-- /.modal-dialog -->
                                    </div>
                                    <!-------------------------------- 弹出end -------------------------------->
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-actions">
                        <div class="row">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit" class="btn green">提交</button>
                                <button type="button" class="btn default"
                                        onclick="location.href='../user/index'">取消
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
                <!-- END FORM-->
            </div>
        </div>
    </div>
</div>

<script language="javascript">
    $(".select2_sample1").select2({
        placeholder: "添加选择角色",
        allowClear: true
    });


    // 自定义验证
    $.validator.addMethod("mobilephone", function (value, element, params) {
        var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if (!myreg.test(value)) {
            return false;
        }
        return true;
    }, "非法的手机号码");
    $.validator.addMethod("immobilityphone", function (value, element, params) {
        var myreg = new RegExp(/\d{3}-\d{8}|\d{4}-\d{7}/);
        if (!myreg.test(value)) {
            return false;
        }
        return true;
    }, "请填写合法的固定座机号码");

    $(document).ready(function () {
        // 默认初始值
        $("#organizationId").val('${userInfo.organizationId}');
        $("#orgName").show();
        $("#orgName").text('${userInfo.organizationName}');
        $("#selectBtn").text("点击修改");
        $("#closebtn").click();
        $("#organizationTreeTable").loadTreeTable({
            url: contextPath + '/umplatform/organization/getOrgTree',
            checkBox: false,
            expandable: true
        });
    });
    function getSelectedOrg() {
        var selectNode = $("#organizationTreeTable").getSingleSelectedNode();
        if (selectNode.id) {
            $("#organizationId").val(selectNode.id);
            $("#orgName").show();
            $("#orgName").text(selectNode.text);
            $("#selectBtn").text("点击修改");
            $("#closebtn").click();
        } else {
            window.wxc.xcConfirm("请选择所属部门", window.wxc.xcConfirm.typeEnum.error);
        }
    }
</SCRIPT>

</body>
</html>


