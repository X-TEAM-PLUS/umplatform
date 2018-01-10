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
            <i class="fa fa-tasks"></i>
            <a href="index">系统菜单管理</a>
            <i class="fa fa-angle-right"></i>
        </li>
        <li class=" active">
            <i class="fa fa-edit "></i>
            <a href="#">编辑应用</a>
        </li>
    </ul>
</div>
<div class="tab-content">
    <div class="tab-pane active" id="tab_0">
        <div class="portlet box grey-cascade">
            <div class="portlet-title">
                <div class="caption">
                    <i class="fa fa-adn"></i>编辑应用
                </div>
                <div class="tools">
                    <a href="javascript:;" class="collapse">
                    </a>
                    <a href="#portlet-config" data-toggle="modal" class="config">
                    </a>
                    <a href="javascript:;" class="reload">
                    </a>
                    <a href="javascript:;" class="remove" data-original-title="" title="">
                    </a>
                </div>
            </div>
            <div class="portlet-body form">
                <!-- BEGIN FORM-->
                <form action="/umplatform/application/put" class="form-horizontal">
                    <input type="hidden" name="id" id="id" value="${application.id}">
                    <div class="form-body">
                        <div class="form-group">
                            <label class="col-md-3 control-label">应用名称
                                <span class="required">* </span>
                            </label>
                            <div class="col-md-5">
                                <div class="input-group">
                                    <span class="input-group-addon input-circle-left">
                                        <i class="fa   fa-font"></i>
                                    </span>
                                    <input type="text" name="name" id="name" class="form-control" placeholder="资源名称" validate="{minlength: 2,maxlength:10,required: true}"  value="${application.name}">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-3 control-label">应用地址
                                <span class="required">* </span>
                            </label>
                            <div class="col-md-5">
                                <div class="input-group">
                                    <span class="input-group-addon input-circle-left">
                                        <i class="fa   fa-link"></i>
                                    </span>
                                    <input type="text" name="url" id="url" class="form-control" placeholder="应用地址" validate="{minlength: 2,maxlength:100,required: true}"  value="${application.url}">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-3 control-label">退出地址
                                <span class="required">* </span>
                            </label>
                            <div class="col-md-5">
                                <div class="input-group">
                                    <span class="input-group-addon input-circle-left">
                                        <i class="fa   fa-link"></i>
                                    </span>
                                    <input type="text" name="logoutUrl" id="logoutUrl" class="form-control" placeholder="退出地址" validate="{minlength: 2,maxlength:100,required: true}"  value="${application.logoutUrl}">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-3 control-label">图标
                                <span class="required">* </span>
                            </label>
                            <div class="col-md-5">
                                <div class="input-group ">
                                    <span class="input-group-addon input-circle-left">
                                        <i class="fa   fa-image"></i>
                                    </span>
                                    <input type="text" name="icon" id="icon" class="form-control" placeholder="应用图标" validate="{minlength: 2,maxlength:100,required: true}"  value="${application.icon}">
                                </div>
                            </div>
                        </div>

                        <div class="form-group last">
                            <label class="control-label col-md-3">描述：</label>
                            <div class="col-md-5">
                                <div class="input-group">
                     <span class="input-group-addon input-circle-left">
                          <i class="fa fa-comment"></i>
                        </span>
                     <textarea class="form-control" id="remark" name="remark" rows="5"
                               placeholder="非必填"> ${(application.remark)!''}</textarea>
                                </div>

                            </div>
                        </div>

                    </div>
                    <div class="form-actions right">
                        <button type="button" class="btn default" onclick="history.go(-1)"><i class="fa fa-rotate-left"></i> 取消</button>
                        <button type="submit" class="btn green"><i class="fa fa-check"></i> 保存</button>
                    </div>
                </form>
                <!-- END FORM-->
            </div>
        </div>
    </div>
</div>
</body>
</html>


