/**
 * Created by yankun on 2016/3/4 0004.
 */
(function ($) {
    //提交表单
    $.fn.submitForm = function submitForm() {
        var form = $(this);
        if (!form.attr("action")) {
            return;
        }
        $.bootstrapLoading.start({loadingTips: "正在提交数据到服务器，请稍候..."});
        var action = ( form.attr("action").indexOf("?") != -1 ? (form.attr("action") + "&") : (form.attr("action") + "?")) + "dt=" + new Date().getTime();
        //表单提交
        $.ajax({
            url: contextPath + action,
            type: 'POST',
            data: form.serialize(),
            success: function (result) {
                $.bootstrapLoading.end();
                if (result) {
                    if (result.success) {
                        if (result.message) {
                            window.wxc.xcConfirm(result.message ? result.message : "提交成功", window.wxc.xcConfirm.typeEnum.success, {
                                title: '提示'
                                , onOk: function () {
                                    if (!result || !result.backUrl) {
                                        window.location.href = 'index';
                                    } else {
                                        window.location.href = contextPath + result.backUrl;
                                    }
                                }
                            });
                        } else {
                            if (!result || !result.backUrl) {
                                window.location.href = 'index';
                            } else {
                                window.location.href = contextPath + result.backUrl;
                            }
                        }
                    } else {
                        window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.error);
                    }
                }
                return false;
            }
            , error: function (textStatus, errorThrown) {
                $.bootstrapLoading.end();
                window.wxc.xcConfirm("服务端响应异常:[statusCode:" + textStatus.status + "]", window.wxc.xcConfirm.typeEnum.error);
            }
        });
    }

    $.fn.ajaxSubmitForm = function (options) {
        //默认参数
        var defaultParams = {};
        var formData = new FormData();
        if (options.formData != undefined) {
            formData = options.formData;
        }
        //表单验证
        if ($(this).valid()) {
            var opts = $.extend({}, defaultParams, options);
            var selector = $(this).selector;

            var formItems = $(selector).find('input, select');
            if (formItems) {
                //添加所有非文件类型的
                var appendMap = new Map();
                $.each(formItems, function (index, rowValue) {
                    if (rowValue.name && rowValue.name != ''){
                        var rowObj;
                        if (rowValue.name.indexOf(".") > -1){
                            rowObj = $("[id='"+rowValue.name+"']").val();
                        }else{
                            rowObj = $("#" + rowValue.id).val();
                        }
                        if ('file' != formItems[index].type && rowObj != ''){
                            formData.append(rowValue.name, rowObj);
                        } else if ('file' == formItems[index].type) {
                            if (!appendMap.get(rowValue.name)) {
                                $(selector).find(" input[name=" + rowValue.name + "]").each(function (i, n) {
                                    for (var fileIndex = 0; fileIndex < $(n)[i].files.length; fileIndex++) {
                                        formData.append(rowValue.name, $(n)[i].files[fileIndex]);
                                    }
                                });
                                appendMap.put(rowValue.name, rowValue.name);
                            }
                        }
                    }

                });

            }
            $.ajax({
                url: opts.url,
                type: 'POST',
                cache: false,
                data: formData,
                processData: false,
                contentType: false
            }).done(function (result) {
                if (opts.success) {
                    opts.success(result);
                }

            }).fail(function (result) {
                if (opts.error) {
                    opts.error(result);
                }
            });
        }

    }

})(jQuery);

/**
 * 获取表单验证规则
 * @param form
 */
function getFormValidateRules(form) {
    var elementClass = "input ,select";
    var rules = {};
    form.find(elementClass).each(function (i, n) {
        var id = $(n).attr("id");
        //如果没有设置ID
        if (id == undefined || id == "undefined") {
            id = UUID.generate();
            $(n).attr("id", id);
        }
        var validate = $(n).attr("validate");
        if (validate != undefined && validate != "undefined" && name != undefined) {
            rules[$(n).attr("name")] = eval("(" + validate + ")");
        }
    });

    return rules;
}

/**
 * 初始化验证
 */
function initValidate() {
    if ($.validator) {
        $.validator.prototype.elements = function () {
            var validator = this,
                rulesCache = {};
            // Select all valid inputs inside the form (no submit or reset buttons)
            return $(this.currentForm)
                .find("input, select, textarea, [contenteditable]")
                .not(":submit, :reset, :image, :disabled")
                .not(this.settings.ignore)
                .filter(function () {
                    var name = this.id || this.name || $(this).attr("name"); // For contenteditable
                    if (!name && validator.settings.debug && window.console) {
                        console.error("%o has no name assigned", this);
                    }
                    // Set form expando on contenteditable
                    if (this.hasAttribute("contenteditable")) {
                        this.form = $(this).closest("form")[0];
                    }
                    // Select only the first element for each name, and only those with rules specified
                    if (name in rulesCache || !validator.objectLength($(this).rules())) {
                        return false;
                    }
                    rulesCache[name] = true;
                    return true;
                });
        }
    }

    $.each(document.forms, (function () {
        var form = $(this);
        form.validate({
            errorElement: 'em', //default input error message container
            errorClass: 'help-block help-block-error', // default input error message class
            focusInvalid: true, // do not focus the last invalid input
            ignore: "",  // validate all fields including form hidden input
            rules: getFormValidateRules(form),
            errorPlacement: function (error, element) { // render error placement for each input type
                var icon = $(element).parent('.input-icon').children('i');
                icon.removeClass('fa-check').removeClass("green-meadow").addClass("fa-warning").addClass("red");
                icon.attr("data-original-title", error.text()).tooltip({'container': 'body'});
            },
            highlight: function (element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').removeClass("has-success").addClass('has-error'); // set error class to the control group
                var icon = $(element).parent('.input-icon').children('i');
                icon.removeClass('fa-check').removeClass("green-meadow").addClass("fa-warning").addClass("red");
            },
            unhighlight: function (element) { // revert the change done by hightlight
                $(element)
                    .closest('.form-group').removeClass("has-error").addClass('has-success'); // set error class to the control group
                var icon = $(element).parent('.input-icon').children('i');
                icon.removeClass('fa-warning').removeClass("red").addClass("fa-check").addClass("green-meadow");
            },
            submitHandler: function () {
                //提交
                form.submitForm();
            }
        });
    }));
}

/**
 * 重新初始化验证
 */
function reInitValidate() {
    //清除原先的验证
    $.each(document.forms, (function () {
        var form = $(this);
        form.data('bootstrapValidator', null);
    }));

    //初始化验证
    initValidate();
}
$(document).ready(function () {
    initValidate();
});