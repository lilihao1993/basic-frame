require(['component/iframeLayer',
    'common/util',
    'common/http',
    'laydate',
    'icheck',
    'jquery.validate',
    'common/validateRules'], function (layer, util, http, laydate) {


    init();

    /**
     * 初始化函数集合
     */
    function init() {
        _formValid();
        //事件绑定
        _bind();
        _other();
    }

    /**
     * 表单验证
     * @private
     */
    function _formValid() {
        $.validator.setDefaults({
            submitHandler: function () {
                //1.判断验证码是否验证成功
                _verificationCode($("#checkCode").val());

            }
        });

        $('#loginForm').validate({
            rules: {
                userName: {
                    isNotBlank: true,
                    maxlength: 50
                },
                phone: {
                    isNotBlank: true,
                    maxlength: 11
                },
                email: {
                    isNotBlank: true,
                    maxlength: 11
                },
                wechat: {
                    isNotBlank: true,
                    maxlength: 11
                },
                dirthday: {
                    isNotBlank: true,
                    maxlength: 11
                }
            },

            messages: {
                userName: {
                    isNotBlank: '用户名不可为空',
                    maxlength: '用户名长度在50字符内'
                },
                phone: {
                    isNotBlank: '密码不可为空',
                    maxlength: '密码长度在50字符内'
                },
                email: {
                    isNotBlank: '验证码不可为空',
                    maxlength: '验证码长度在50字符内'
                },
                wechat: {
                    isNotBlank: '验证码不可为空',
                    maxlength: '验证码长度在50字符内'
                },
                dirthday: {
                    isNotBlank: '验证码不可为空',
                    maxlength: '验证码长度在50字符内'
                }
            },

            showErrors: function (errorMap, errorList) {
                for (var i in errorList) {
                    $(errorList[i].element).parents('.ipt-box').addClass('error');
                    $('.error-box').html(errorList[i].message);
                    break;
                }
            },
            onkeyup: function () {
                if ($(this.lastActive).valid()) {
                    $('.error-box').html('');
                    $(this.lastActive).parents('.ipt-box').removeClass('error');
                }
            },
            onfocusout: false
        });
    }

    /**
     * 事件绑定
     * @private
     */
    function _bind() {
        util.bindEvents([{
            el: '#js-add',
            event: 'click',
            handler: function () {
                $(this).blur();
                layer.dialog({
                    type: 2,
                    title: ['新增用户', 'font-size:18px;color:#07538f;background:#e4f6fb;'],
                    area: ['560px', '300px'],
                    content: ['/admin/system/user/add', 'no'],
                    callback: function () {
                        table.ajax.reload();
                    }
                });
            }
        }]);
    }

    /**
     * 描述：其他
     * @private
     */
    function _other() {
        //1.单选框事件
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        //2.时间
        laydate.render({
            elem: '#dirthday' //指定元素
        });

    }
});