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
            <a href="#">地市信息</a>
            <i class="icon-paper-plane"></i>
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
                        <i class="icon-paper-plane"></i>地市信息
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
                <div class="portlet-body">
                    <div class="table-toolbar">
                        <div class="row">
                            <div class="col-md-10">
                                <div class="btn-group">
                                    <button id="newRole" class="btn green">
                                        Add New<i class="fa fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                            <div class="col-md-2 pull-right">
                                <form id="areaTableForm" onsubmit="goPage('areaTable',1);return false;">
                                <div class="input-group">
                                    <div class="input-icon">
                                        <i class="icon-magnifier"></i>
                                        <input class="form-control" type="text" name="name" placeholder="地区名称"/>
                                    </div>
												<span class="input-group-btn">
												<button class="btn btn-success" type="submit" ><i class="fa fa-arrow-left fa-fw"/></i> 搜索</button>
												</span>

                                </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="table-toolbar">
                        <table id="areaTreeTable" class="gtreetable table table-hover table-light col-md-12">
                            <thead>
                            <tr>
                                <th column="text"><label>地区名称</label></th>
                                <th column="id"><label>地区代码</label></th>
                                <th column="type"><label>类别</label></th>
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

<script>
    $("#areaTreeTable").loadTreeTable({
        url:'/umplatform/area/getTree',
        expandable: true
    });
</script>


</body>
</html>


