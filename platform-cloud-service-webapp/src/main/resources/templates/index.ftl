<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
<#import 'common/common.ftl' as commonMacro>
<@commonMacro.commonStyle />
    <base target="mainWindow" />
</head>
<script>
    var contextPath = "${request.contextPath}";
</script>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo page-container-bg-solid">
<!-- BEGIN HEADER -->
<!-- END HEADER -->
<#include "common/top.ftl">
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
    <!-- BEGIN SIDEBAR -->
    <!-- END SIDEBAR -->
    <#include "common/menu.ftl">
    <!-- BEGIN CONTENT -->
    <div class="page-content-wrapper">
                <div  class="page-content">
                     <iframe  name="mainWindow"  id="mainWindow"  width="100%"  src="/welcome" height="100%" frameborder="0"  scrolling="no"  marginwidth="0" marginheight="0" border="0"   onload="this.height=document.body.scrollHeight-100;setBackUrl(this);"></iframe>
                </div>
    </div>
    <!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<script src="/static/assets/global/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="/static/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="/static/assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
        type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
        type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"
        type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="/static/assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js"
        type="text/javascript"></script>
<script src="/static/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js"
        type="text/javascript"></script>
<script src="/static/assets/global/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery.pulsate.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/bootstrap-daterangepicker/moment.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/bootstrap-daterangepicker/daterangepicker.js"
        type="text/javascript"></script>
<!-- IMPORTANT! fullcalendar depends on jquery-ui.min.js for drag & drop support -->
<script src="/static/assets/global/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js"
        type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="/static/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="/static/assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="/static/assets/admin/pages/scripts/index.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/xcConfirm/js/xcConfirm.js"></script>
<!-- validate -->
<script type="text/javascript"
        src="/static/assets/global/plugins/jquery-validation/js/jquery.validate.min.js"></script>
<script src="/static/js/Menu.js" type="text/javascript"></script>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>

<!-- END PAGE LEVEL SCRIPTS -->

<script>
    jQuery(document).ready(function() {
        Layout.init(); // init layout
    });
    function setBackUrl(obj){
        var backUrl=obj.contentWindow.location.href;
        if(backUrl.indexOf("toEditBasicInfo")<=0&&backUrl.indexOf("toEditPsw")<=0) {
            $.cookie('backUrl', backUrl);
        }

    }
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>

