<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8"/>
    <title>早安云-管理</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="/static/assets/global/plugins/googleapis/googleapis.css" rel="stylesheet"
          type="text/css"/>
    <link href="/static/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="/static/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="/static/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="/static/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link href="/static/assets/admin/pages/css/login.css" rel="stylesheet" type="text/css"/>
    <!-- END PAGE LEVEL SCRIPTS -->
    <!-- BEGIN THEME STYLES -->
    <link href="/static/assets/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
    <link href="/static/assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
    <link href="/static/assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
    <link href="/static/assets/admin/layout/css/themes/darkblue.css" rel="stylesheet" type="text/css"
          id="style_color"/>
    <link href="/static/assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>

    <!-- END THEME STYLES -->
    <script>
        var contextPath = "<#assign ctx=request.getContextPath()>";
    </script>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login">
<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
<div class="menu-toggler sidebar-toggler">
</div>
<!-- END SIDEBAR TOGGLER BUTTON -->
<!-- BEGIN LOGO -->
<div class="logo logo-lg ">
    <H1 class="text-primary"><b>早安云-后台管理</b></H1>
</div>
<!-- END LOGO -->
<!-- BEGIN LOGIN -->
<div class="content">
    <!-- BEGIN LOGIN FORM -->
    <form class="login-form" id = "loginForm" action="/authenticate">
        <h3 class="form-title">用户登录认证</h3>
        <div class="alert alert-danger display-hide">
            <button class="close" data-close="alert"></button>
			<span>
			请输入用户和密码</span>
        </div>
        <div class="form-group">
            <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
            <div class="input-group col-lg-12">
                <div class="input-icon">
                    <i class="icon-user"></i>
                    <input type="text" name="userName" class="form-control" placeholder="用户名" validate="{required: true}">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="input-group col-lg-12">
                <div class="input-icon">
                    <i class="icon-key"></i>
                    <input type="password" name="password" class="form-control" placeholder="密码" validate="{required: true}">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-icon">
                    <i class="fa   fa-qrcode"></i>
                    <input type="text" name="imagecode"  class="form-control " placeholder="图形验证码" validate="{required: true}">
                </div>
												<span class="input-group-btn">
												 <img src="/imageCode" width="110px" height="40px" border="0"
                                                      onclick="this.src='/imageCode?'+Math.random()" class="handle"/>
												</span>
            </div>
        </div>
        <div class="form-group">
            <div class="form-actions">
                <button type="submit" class="btn btn-success uppercase"><li class="  icon-arrow-right"></li> 登录</button>
                <label class="rememberme check">
                    <input type="checkbox" name="remember" value="1"/>记住 </label>
                <a href="javascript:;" id="forget-password" class="forget-password">忘记密码</a>
            </div>
        </div>
        <div class="create-account">
            <p></p>
        </div>
    </form>
    <!-- END LOGIN FORM -->
</div>
<div class="copyright">
    <strong>Copyright &copy; 2016-2020 X-Team-Plus.</strong> All rights reserved.
</div>
<!-- END LOGIN -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="/static/assets/global/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="/static/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="/static/assets/global/plugins/jquery-validation/js/jquery.validate.min.js"
        type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="/static/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="/static/assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="/static/js/SubmitForm.js"></script>
<link rel="stylesheet" href="/static/assets/global/plugins/xcConfirm/css/xcConfirm.css">
<script src="/static/assets/global/plugins/xcConfirm/js/xcConfirm.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>


