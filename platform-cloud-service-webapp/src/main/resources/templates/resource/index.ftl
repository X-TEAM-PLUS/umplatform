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
            <a href="#">系统菜单管理</a>
            <i class="fa  fa-list-ul"></i>
        </li>

    </ul>
</div>
<div class="page-content">
    <!-- END PAGE HEADER-->
    <!-- BEGIN PAGE CONTENT-->
    <div class="row">
    <div class="col-md-12 ">
        <!-- BEGIN EXAMPLE TABLE PORTLET-->
        <div class="portlet box grey-cascade">
            <div class="portlet-title">
                <div class="caption">
                    <i class="fa  fa-list-ul"></i>系统菜单管理
                </div>
                <div class="tools">
                    <a href="javascript:;" class="collapse">
                    </a>
                    <a href="#portlet-config" data-toggle="modal" class="config">
                    </a>
                    <a href="javascript:;" class="reload">
                    </a>
                </div>
            </div>
            <div class="table portlet-body">
                <div class="table-toolbar">
                    <div class="row">
                        <div class="col-md-10">
                            <div class="btn-group">
                                <button  class="btn green dropdown-toggle"  data-toggle="dropdown">
                                    <i class="fa fa-plus"></i> 添加资源 <i class="fa fa-angle-down"></i>
                                </button>
                                <ul class="dropdown-menu" role="menu">
                                    <li>
                                        <a id="addApplicationButton" href="javascript:;">
                                           <i class="fa fa-adn font-green"></i> 添加应用 </a>
                                    </li>
                                    <li>
                                        <a id="addResourceButton"  href="javascript:;">
                                            <i class="fa  fa-list-ul font-green"></i> 添加菜单或按钮 </a>
                                    </li>
                                </ul>
                            </div>
                            <button id="editButton" class="btn blue">
                                <i class="fa fa-edit "></i> 编辑资源
                            </button>
                            <button id="deleteButton" class="btn red" >
                                <i class="glyphicon glyphicon-trash "></i> 删除资源
                            </button>
                        </div>
                    </div>

                </div>
                <table id="resourceTreeTable" class="table table-striped table-bordered table-hover dataTable">
                    <thead>
                    <tr>
                        <th column="text"><label>资源名称</label></th>
                        <th column="type"><label>资源类型</label></th>
                        <th column="remark"><label>描述</label></th>
                        <th column="created"><label>创建时间</label></th>
                        <th column="updated"><label>更新时间</label></th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- END EXAMPLE TABLE PORTLET-->
    </div>
</div>
</div>

</body>
<script>
$(document).ready(function () {
    $("#addApplicationButton").click(function () {
        location.href = "/umplatform/application/add";
    });

    $("#addResourceButton").click(function () {
        var selectNode =  $("#resourceTreeTable").getSingleSelectedNode();
        if(selectNode.id){
            if(selectNode.parentId){
                location.href = "add?parentId=" + selectNode.id;
            }else{
                location.href = "add?appId=" + selectNode.id;
            }
        }else{
            window.wxc.xcConfirm("您必须先选择要添加资源的位置", window.wxc.xcConfirm.typeEnum.error);
        }
    });

    $("#editButton").click(function () {
        var selectNode =  $("#resourceTreeTable").getSingleSelectedNode();
        if(selectNode.id){
            if(!selectNode.parentId){
                location.href = "/umplatform/application/edit?id=" + selectNode.id;
            }else{
                location.href = "edit?id=" + selectNode.id;
            }
        }else{
            window.wxc.xcConfirm("请选译要编辑的资源", window.wxc.xcConfirm.typeEnum.error);
        }
    });

    $("#deleteButton").click(function () {
        var selectNode =  $("#resourceTreeTable").getSingleSelectedNode();
        if(selectNode.id){
            var actionUrl = "delete";
            var resourceName = "资源";
            if(!selectNode.parentId){
                actionUrl = "/umplatform/application/delete";
                resourceName = "应用";
            }
            window.wxc.xcConfirm('确定要删除选中的'+ resourceName +'吗?', window.wxc.xcConfirm.typeEnum.confirm, {
                title: '提示'
                , onOk: function () {
                    $.ajax({
                        url: contextPath + actionUrl +"?id="+ selectNode.id +"&dt=" + new Date().getTime(),
                        type: 'GET',
                        success: function (result) {
                            var success = result.success;
                            if (success) {
                                window.wxc.xcConfirm("删除成功。", window.wxc.xcConfirm.typeEnum.info);
                                init();
                            } else {
                                window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.error);
                            }
                        }
                    });
                },
            });

        }else{
            window.wxc.xcConfirm("请选择要删除的机构，", window.wxc.xcConfirm.typeEnum.error);
        }
    });


    function init() {
        $("#resourceTreeTable").loadTreeTable({
            url:contextPath+'/umplatform/resource/getResourceTree',
            checkBox:false,
            expandable: true
        });
    }
    //初始化
    init();
});
</script>
</html>


