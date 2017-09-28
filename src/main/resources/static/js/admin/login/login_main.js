require(['component/iframeLayer',
    'common/util',
    'common/http',
    'jquery.validate',
    'common/validateRules'], function (layer, util, http) {
    init();

    /**
     * 初始化函数集合
     */
    function init() {
        _formValid();
        //事件绑定
        _bind();
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
                password: {
                    isNotBlank: true,
                    maxlength: 50
                },
                checkCode: {
                    isNotBlank: true,
                    maxlength: 50
                }
            },

            messages: {
                userName: {
                    isNotBlank: '用户名不可为空',
                    maxlength: '用户名长度在50字符内'
                },
                password: {
                    isNotBlank: '密码不可为空',
                    maxlength: '密码长度在50字符内'
                },
                checkCode: {
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
            el: '#kanbuq',
            event: 'click',
            handler: function () {
                $('#verify').attr('src', '/verify?' + Math.random());

            }
        }, {
            el: '#login',
            event: 'click',
            handler: function () {


            }
        }
        ]);
    }


    /**
     * 判断验证码是否验证成功
     * @param code 用户输入的验证码
     * @private success：失败，fail 成功
     */
    function _verificationCode(code) {
        var userName = $('userName').val();
        http.httpRequest({
            url: '/verify/validate',
            type: "get",
            data: {verifyCode: code},
            success: function (data) {
                if (data.status == 'success') {
                    _login($('#userName').val(), $('#password').val());
                } else {
                    $('#verify').attr('src', '/verify?' + Math.random());
                    layer.alert("请输入正确的验证码！",{icon: 2});
                }
            },
            error: function () {
                layer.alert('错误');
            }
        });

    }

    /**
     *用户登录
     */
    function _login(userName, password) {
        http.httpRequest({
            url: '/login',
            type: "post",
            data: {userName: userName, password: password},
            success: function (data) {
                if (data.status == 'success') {
                    //登录成功跳转到后台页
                    top.location = "/admin/index";
                } else {
                    //弹出提示框
                    layer.alert(data.msg,{icon: 2});
                }
            },
            error: function () {
                layer.alert('错误');
            }
        });
    }

});
