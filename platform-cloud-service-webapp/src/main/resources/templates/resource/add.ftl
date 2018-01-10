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
            <i class="fa fa-plus "></i>
            <a href="#">添加资源</a>
        </li>
    </ul>
</div>
<div class="tab-content">
    <div class="tab-pane active" id="tab_0">
        <div class="portlet box grey-cascade">
            <div class="portlet-title">
                <div class="caption">
                    <i class="fa fa-plus"></i>添加资源
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
                <form action="post" id="form1" class="form-horizontal">
                    <input type="hidden" name="parentId" id="parentId" value="${(parentId)!''}">
                    <input type="hidden" name="appId" id="appId" value="${(appId)!''}">
                    <div class="form-body">
                        <div class="form-group">
                            <label class="col-md-3 control-label">资源名称
                                <span class="required">* </span>
                            </label>
                            <div class="col-md-5">
                                <div class="input-group">
                                    <span class="input-group-addon input-circle-left">
                                        <i class="fa   fa-font"></i>
                                    </span>
                                    <input type="text" name="name" id="name" class="form-control" placeholder="资源名称" validate="{minlength: 2,maxlength:10,required: true}">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-3 control-label">资源地址
                                <span class="required">* </span>
                            </label>
                            <div class="col-md-5">
                                <div class="input-group">
                                    <span class="input-group-addon input-circle-left">
                                        <i class="fa   fa-link"></i>
                                    </span>
                                    <input type="text" name="url" id="url" class="form-control" placeholder="资源地址" validate="{minlength: 2,maxlength:100,required: true}">
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
                                    <input type="text" name="icon" id="icon" class="form-control" placeholder="资源图标" validate="{minlength: 2,maxlength:100,required: true}">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-3 control-label">资源类型
                                <span class="required">* </span>
                            </label>
                            <div class="col-md-5">
                                <div class="input-group ">
                                    <div class="md-radio-inline">
                                        <div class="md-radio">
                                            <input type="radio" name="resourceType" id="resourceType1" value="1" class="md-radiobtn"  checked>
                                            <label for="resourceType1">
                                                <span class="check"></span>
                                                <span class="box"></span>
                                                菜单
                                            </label>
                                        </div>
                                        <div class="md-radio">
                                            <input type="radio" name="resourceType" id="resourceType2" value="2" class="md-radiobtn" >
                                            <label  for="resourceType2">
                                                <span class="check"></span>
                                                <span class="box"></span>
                                                按钮
                                            </label>
                                        </div>
                                    </div>
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
                               placeholder="非必填"></textarea>
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


