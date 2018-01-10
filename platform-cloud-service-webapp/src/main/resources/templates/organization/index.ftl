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
            <a href="#">组织结构管理</a>
            <i class="fa fa-sitemap"></i>
        </li>

    </ul>
</div>
<div class="page-content">
    <div class="row">
        <div class="col-md-12 ">
            <!-- BEGIN EXAMPLE TABLE PORTLET-->
            <div class="portlet box grey-cascade">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-sitemap"></i>菜单管理
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
                                        <i class="fa fa-plus"></i> 添加机构 <i class="fa fa-angle-down"></i>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li>
                                            <a id="addCompanyButton" href="javascript:;">
                                                <i class="fa fa-bank font-green"></i> 添加公司 </a>
                                        </li>
                                        <li>
                                            <a id="addDeptButton" href="javascript:;">
                                              <i class="fa fa-sitemap font-green"></i>  添加部门 </a>
                                        </li>
                                    </ul>
                                </div>
                                <button id="editButton" class="btn blue" >
                                    <i class="fa fa-edit "></i> 编辑机构
                                </button>
                                <button id="deleteButton" class="btn red" >
                                    <i class="glyphicon glyphicon-trash "></i> 删除机构
                                </button>
                            </div>
                        </div>
                        <table id="orgTreeTable" class="table table-striped table-bordered table-hover dataTable treetable col-md-12">
                            <thead>
                            <tr>
                                <th column="text"><label>机构名称</label></th>
                                <th column="code"><label>机构代码</label></th>
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
            </div>
            <!-- END EXAMPLE TABLE PORTLET-->
        </div>
    </div>
</div>

</body>
<script>
    $(document).ready(function () {
        function init() {
            $("#orgTreeTable").loadTreeTable({
                url:contextPath+'/umplatform/organization/getOrgTree',
                checkBox:false,
                expandable: true
            });
        }

        //初始化
        init();



        $("#addCompanyButton").click(function () {
            location.href = "add";
        });

        $("#addDeptButton").click(function () {
            var selectNode =  $("#orgTreeTable").getSingleSelectedNode();
            if(selectNode.id){
                location.href = "add?parentId=" + selectNode.id;
            }else{
                window.wxc.xcConfirm("您必须先选择一个机构才能添加部门", window.wxc.xcConfirm.typeEnum.error);
            }


        });

        $("#editButton").click(function () {
            var selectNode =  $("#orgTreeTable").getSingleSelectedNode();
            if(selectNode.id){
                location.href = "edit?id=" + selectNode.id;
            }else{
                window.wxc.xcConfirm("请选择要编辑的机构，", window.wxc.xcConfirm.typeEnum.error);
            }

        });
        $("#deleteButton").click(function () {
            var selectNode =  $("#orgTreeTable").getSingleSelectedNode();
            if(selectNode.id){
                window.wxc.xcConfirm('确定要删除选中的机构吗?', window.wxc.xcConfirm.typeEnum.confirm, {
                    title: '提示'
                    , onOk: function () {
                        $.ajax({
                            url: "delete?id="+ selectNode.id +"&dt=" + new Date().getTime(),
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
    });

</script>
</html>


