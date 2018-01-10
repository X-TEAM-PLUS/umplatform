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
            <a href="#">修改密码</a>
            <i class="fa fa-tasks text-yellow"></i>
        </li>
    </ul>
</div>
<div class="tab-content">
    <div class="tab-pane active" id="tab_0">
        <div class="portlet box grey-cascade">
            <div class="portlet-title">
                <div class="caption">
                    <i class="fa fa-gift"></i>修改密码
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
                <form action="editPwd" id="form1" class="form-horizontal">
                    <input type="hidden" name="id" id="id" value="${userInfo.id}" />
                    <div class="form-body">
                        <div class="form-group">
                        <label class="col-md-3 control-label">原始密码<span class="required"> *</span></label>
                        <div class="col-md-4">
                            <div class="input-group">
                                <span class="input-group-addon input-circle-left">
                                <i class="fa fa-font"></i>
                                </span>
                                <input type="password" name="password" id="password" class="form-control"
                                       placeholder="Password" value=""
                                       validate='{"required": true,"isRight":true}'>

                            </div>
                        </div>
                    </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">新登录密码<span class="required"> *</span></label>
                            <div class="col-md-4">
                                <div class="input-group">
                                    <span class="input-group-addon input-circle-left">
                                    <i class="fa fa-user"></i>
                                    </span>
                                    <input type="password" name="newPassword" id="newPassword" class="form-control"
                                           placeholder="Password" value=""
                                           validate='{"minlength": 10,"required": true,"newPassword":true}'>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">确认新登录密码<span class="required"> *</span></label>
                            <div class="col-md-4">
                                <div class="input-group">
                                    <span class="input-group-addon input-circle-left">
                                     <i class="fa fa-user"></i>
                                    </span>
                                    <input type="password" name="rePassword" id="rePassword" class="form-control"
                                           placeholder="Password" value=""
                                           validate='{"minlength": 10,"required": true,"rePassword":true}'>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="form-actions">
                        <div class="row">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit" class="btn green">提交</button>
                                <button type="button" class="btn default"
                                        onclick="history.go(-1)">取消
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
    //验证原始密码是否正确
    $.validator.addMethod("isRight", function (value, element, params) {
        var flag=0;
        jQuery.ajax({
            type: "post",
            async: false,
            url: "/umplatform/user/checkPassword",
            data: {id:$("#id").val(),password:$("#password").val()},
            success: function(result){
                if (result.success) {
                    flag=1;
                } else {
                    flag=0;
                }
            }
        });
        if(flag==0){
            return false;
        }else{
            return true;
        }
    }, "原始密码不正确");
    // 验证新密码是否和原始密码相同
    $.validator.addMethod("newPassword", function (value, element, params) {
        if(value==$("#password").val()){
            return false;
        }
        return true;
    }, "新密码不能和原始密码相同");
    //验证两次新密码是否一致
    $.validator.addMethod("rePassword", function (value, element, params) {
        if(value!=$("#newPassword").val()){
            return false;
        }
        return true;
    }, "两次密码输入不一致");
    $(document).ready(function () {
        // 默认初始值
        $("#organizationId").val('${userInfo.organizationId}');
        $("#orgName").show();
        $("#orgName").text('${userInfo.organizationName}');
        $("#selectBtn").text("点击修改");
        $("#closebtn").click();
    });
</SCRIPT>

</body>
</html>


