require(['component/iframeLayer',
    'common/util',
    'common/http',
    'laydate',
    'icheck',
    'city',
    'cityData',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize'], function (layer, util, http, laydate) {


    init();

    /**
     * 初始化函数集合
     */
    function init() {
        $("#province").ProvinceCity();
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
                //1.编辑用户
                _editUser();

            }
        });

        $('#form-user-edit').validate({
            rules: {
                userName: {
                    isNotBlank: true,
                    maxlength: 50
                }, name: {
                    isNotBlank: true,
                    maxlength: 50
                }, password: {
                    isNotBlank: true,
                    maxlength: 50
                },
                mobile: {
                    isNotBlank: true,
                    isPhone: true
                },
                mail: {
                    isNotBlank: true,
                    maxlength: 50,
                    email: true
                },
                wechat: {
                    isNotBlank: true,
                    maxlength: 20
                },
                dirthday: {
                    isNotBlank: true
                }
            },

            messages: {
                userName: {
                    isNotBlank: '用户名不可为空',
                    maxlength: '用户名长度在50字符内'
                }, name: {
                    isNotBlank: '姓名不可为空',
                    maxlength: '姓名长度在50字符内'
                }, password: {
                    isNotBlank: '密码不可为空',
                    maxlength: '密码长度在50字符内'
                },
                mobile: {
                    isNotBlank: '手机号不可为空',
                    isPhone: '请输入正确的手机号'
                },
                mail: {
                    isNotBlank: '邮箱不可为空',
                    maxlength: '邮箱长度在50字符内',
                    email: '您输入的邮箱有误'
                },
                wechat: {
                    isNotBlank: '微信号不可为空',
                    maxlength: '微信号长度在20字符内'
                },
                dirthday: {
                    isNotBlank: '生日不可为空'
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

    /**
     * 描述：编辑用户
     * @private
     */
    function _editUser() {
        http.httpRequest({
            url: '/admin/system/user/edit',
            type: "post",
            data: $('#form-user-edit').serialize(),
            success: function (data) {
                if (data.status == 'success') {
                    parent.layer.closeAll();
                } else {
                    layer.alert('用户编辑失败!');
                }
            },
            error: function () {
                layer.alert('错误');
            }
        });
    }

});