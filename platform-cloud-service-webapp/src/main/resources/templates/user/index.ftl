<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
<#import '../common/common.ftl' as commonMacro>
<@commonMacro.commonStyle />
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
            <a href="#">用户管理</a>
            <i class="icon-user"></i>
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
                        <i class="icon-user"></i>用户管理
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
                <div class="portlet-body" id="userTable">
                    <div class="table-toolbar">
                        <div class="row">
                            <div class="col-md-10">
                                <div class="btn-group">
                                    <button id="newUserButton" class="btn green" onclick="location.href = 'add';">
                                        添加用户 <i class="fa fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                            <div class="col-md-2 pull-right">
                                <form id="userTableForm" onsubmit="init();return false;">
                                    <div class="input-group">
                                        <div class="input-icon">
                                            <i class="icon-magnifier"></i>
                                            <input class="form-control" type="text" name="userName" placeholder="用户名"/>
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
                    <table class="table table-striped table-bordered table-hover ">
                        <thead>
                        <tr>
                            <th column="userName">用户名称</th>
                            <th column="realName">真实姓名</th>
                            <th column="created">创建时间</th>
                            <th column="loginCount">登录次数</th>
                            <th column="locked">状态</th>
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
<@commonMacro.commonScript />
<script>
    function init() {
        $("#userTable").pagingGrid(
                {
                    dataUrl: '/umplatform/user/list'
                    , pageSize: 10
                    , scroll: false
                    , dockedItems: [
                    {
                        name: '修改'
                        , xtype: 'button'
                        , iconClass: 'fa fa-edit'
                        , action: '/umplatform/user/edit'
                        , confirm: true
                        , parmaName: 'id'
                        , column: 'id'
                    },{
                        name: '删除'
                        , xtype: 'button'
                        , iconClass: 'glyphicon glyphicon-trash'
                        , action: '/umplatform/user/delete'
                        , ajax: true
                        , confirm: true
                        , parmaName: 'id'
                        , column: 'id'
                    }
                ], pagingtoolbar: {
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


