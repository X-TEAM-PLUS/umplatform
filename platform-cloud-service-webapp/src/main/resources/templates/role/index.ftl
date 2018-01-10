<!DOCTYPE html>

<html>
<head>
<#import '../common/common.ftl' as commonMacro>
<@commonMacro.commonStyle />
<@commonMacro.commonScript />
</head>
<body class="page-content">
<!-- BEGIN PAGE HEADER-->
<div class="page-bar">
    <ul class="page-breadcrumb">
        <li>
            <i class="fa fa-home"></i>
            <a href="/welcome">首页</a>
            <i class="fa fa-angle-right"></i>
        </li>
        <li>
            <a href="#">角色管理</a>
            <i class="icon-users"></i>
        </li>

    </ul>
</div>
<div class="page-content">
    <!-- END PAGE HEADER-->
    <!-- BEGIN PAGE CONTENT-->
    <div class="row">
        <div class="col-md-12">
            <!-- BEGIN EXAMPLE TABLE PORTLET-->
            <div class="portlet box grey-cascade">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="icon-users"></i>角色管理
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
                <div class="table portlet-body" id="roleTable">
                    <div class="table-toolbar">
                        <div class="row">
                            <div class="col-md-10">
                                <div class="btn-group">
                                    <button id="newRole" class="btn green" onclick="location.href = 'add';">
                                        新建角色 <i class="fa fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                            <div class="col-md-2 pull-right">
                                <form id="roleTableForm" onsubmit="init();return false;">
                                    <div class="input-group">
                                        <div class="input-icon">
                                            <i class="icon-magnifier"></i>
                                            <input class="form-control" type="text" name="roleName" id="roleName"
                                                   placeholder="角色名称"/>
                                        </div>
												<span class="input-group-btn">
												<button class="btn btn-success" type="submit"><i
                                                        class="fa fa-arrow-left fa-fw"/></i> 搜索
                                                </button>
												</span>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-bordered table-hover dataTable" >
                        <thead>
                        <tr>

                            <th column="roleName">角色名称</th>
                            <th column="created">创建时间</th>
                            <th column="updated">更新时间</th>
                            <th column="remark">备注</th>
                            <th type="action">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                    <div class="table-toolbar pagination-toolbar">
                    </div>
                </div>
            </div>
            <!-- END EXAMPLE TABLE PORTLET-->
        </div>
    </div>
</div>
<script>
    function init() {
        $("#roleTable").pagingGrid(
                {
                    dataUrl: '/umplatform/role/list'
                    ,pageSize: 10
                    , scroll: false
                    ,dockedItems: [
                    {
                        name: '修改'
                        , xtype: 'button'
                        , iconClass: 'fa fa-edit'
                        , action: '/umplatform/role/edit'
                        , confirm: true
                        , parmaName: 'id'
                        , column: 'id'
                    }
                    , {
                        name: '删除'
                        , xtype: 'button'
                        , iconClass: 'glyphicon glyphicon-trash'
                        , action: '/umplatform/role/delete'
                        , ajax: true
                        , confirm: true
                        , parmaName: 'id'
                        , column: 'id'
                    }
                ]
                    , pagingtoolbar: {
                    displayInfo: true
                }
                }
        );
    }
    //初始化
    init();
</script>
</body>
</html>


