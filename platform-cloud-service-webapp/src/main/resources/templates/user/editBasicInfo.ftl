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
            <a href="#">修改资料</a>
            <i class="fa fa-tasks text-yellow"></i>
        </li>
    </ul>
</div>
<div class="tab-content">
    <div class="tab-pane active" id="tab_0">
        <div class="portlet box grey-cascade">
            <div class="portlet-title">
                <div class="caption">
                    <i class="fa fa-gift"></i>修改资料
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
                <form action="editBasicInfo" id="form1" class="form-horizontal">
                    <input type="hidden" name="id" id="id" value="${(userInfo.id)!''}" />
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
                        <input type="hidden" name="password"  value="${(userInfo.password)!''}">
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
                                           id="phoneNo" validate='{"phoneNo": true}'/>
                                </div>
                            </div>
                        </div>

                        <input type="hidden" id="organizationId" name="organizationId" value="${(userInfo.organizationId)!''}">
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
        //$("#orgName").show();
        //$("#orgName").text('${userInfo.organizationName}');
        //$("#selectBtn").text("点击修改");
        //$("#closebtn").click();
        //$("#organizationTreeTable").loadTreeTable({
        //    url: contextPath + '/umplatform/organization/getOrgTree',
        //   checkBox: false,
        //   expandable: true
        //});
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


