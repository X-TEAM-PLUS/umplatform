<script src="/static/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<div class="page-header navbar navbar-fixed-top">
    <!-- BEGIN HEADER INNER -->
    <div class="page-header-inner">
        <!-- BEGIN LOGO -->
        <div class="page-logo ">
            <span  class="logo-default font-white " style="font-size: 22px;position:absolute;top:-10px;"><i class="glyphicon glyphicon-th font-red"></i> <strong>早安云-管理</strong></span>
            <div class="menu-toggler sidebar-toggler">
            </div>
        </div>

        <!-- END LOGO -->

        <!-- BEGIN RESPONSIVE MENU TOGGLER -->
        <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
        </a>
        <!-- END RESPONSIVE MENU TOGGLER -->
        <!-- BEGIN TOP NAVIGATION MENU -->
        <div class="top-menu">
            <ul class="nav navbar-nav pull-right">
                <!-- BEGIN USER LOGIN DROPDOWN -->
                <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                <li class="dropdown dropdown-user">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                        <img alt="" class="img-circle" src="/static/assets/admin/layout/img/user.png"/>
					<span class="username username-hide-on-mobile" id="userNameSpan">
					Nick </span>
                        <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-default">
                        <li>
                            <a href="" id="editUserInfoId">
                                <i class="icon-user"></i> 修改资料 </a>
                        </li>
                        <li>
                            <a href="" id="editPwdId">
                                <i class="icon-calendar"></i> 修改密码 </a>
                        </li>
                    </ul>
                </li>
                <!-- END USER LOGIN DROPDOWN -->
                <!-- BEGIN QUICK SIDEBAR TOGGLER -->
                <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                <li>
                    <a href="#" data-toggle="control-sidebar" title="退出系统" onclick="window.location.href='/logout'"><i class="fa  fa-power-off"></i>退出</a>
                </li>
                <!-- END QUICK SIDEBAR TOGGLER -->
            </ul>
        </div>
        <!-- END TOP NAVIGATION MENU -->
    </div>
    <!-- END HEADER INNER -->
</div>
<script>
    $(document).ready(function () {
        jQuery.ajax({
            type: "post",
            async: true,
            url: contextPath + "/umplatform/user/getUserInfoFormCookie",
            success: function(result){
                $("#userNameSpan").text(result.data.userName);
                $("#editUserInfoId").attr("href","/umplatform/user/toEditBasicInfo?id="+result.data.id);
                $("#editPwdId").attr("href","/umplatform/user/toEditPsw?id="+result.data.id);

            }
        });
    });
</script>