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
        var action = ( form.attr("action").indexOf("?") != -1 ? (form.attr("action") + "&") : (form.attr("action") + "?")) + "dt=" + new Date().getTime();
        //表单提交
        $.ajax({
            url: contextPath + action,
            type: 'POST',
            data: form.serialize(),
            success: function (result) {
                if (result) {
                    if (result.success) {
                        window.wxc.xcConfirm(result.message ? result.message : "提交成功", window.wxc.xcConfirm.typeEnum.success, {
                            title: '提示'
                            , onOk: function () {
                                if (!result || !result.backUrl) {
                                    if(action.indexOf("editPwd")>=0||action.indexOf("editBasicInfo")>=0){
                                        if(result.backUrl!=null){
                                            window.location.href = 'index?backUrl='+$.cookie('backUrl');
                                        }else {
                                            window.location.href = 'index';
                                        }
                                    }else{
                                        window.location.href = 'index';
                                    }
                                } else {
                                    window.location.href = 'index?backUrl='+result.backUrl;
                                }
                            }
                        });
                    } else {
                        window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.error);
                    }
                }
                return false;
            }
        });
    }
})(jQuery);

/**
 * 获取表单验证规则
 * @param form
 */
function getFormValidateRules(form) {
    var rules = {};
    form.find("div[class='form-group']").each(function (i, n) {
        var name = $(n).find("input").attr("name");
        var validate = $(n).find("input").attr("validate");
        if (validate != undefined && validate != "undefined" && name != undefined) {
            rules[name] = eval("(" + validate + ")");
        }

        var selectName = $(n).find("select").attr("name");
        var selectValidate = $(n).find("select").attr("validate");
        if (selectValidate != null && selectValidate != undefined && selectName != undefined) {
            rules[selectName] = eval("(" + selectValidate + ")");
        }
    });

    return rules;
}

$(document).ready(function () {
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
                icon.removeClass('fa-check').addClass("fa-warning");
                icon.attr("data-original-title", error.text()).tooltip({'container': 'body'});
            },
            highlight: function (element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').removeClass("has-success").addClass('has-error'); // set error class to the control group
            },
            unhighlight: function (element) { // revert the change done by hightlight
                $(element)
                    .closest('.form-group').removeClass("has-error").addClass('has-success'); // set error class to the control group
            },
            submitHandler: function () {
                //提交
                form.submitForm();
            }
        });
    }));
});