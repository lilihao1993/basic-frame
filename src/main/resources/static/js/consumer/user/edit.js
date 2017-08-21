require(['component/iframeLayer',
    'common/util',
    'common/http',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize'], function (layer, util, http) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        //表单验证
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
                _edit();
            }
        });

        $('#js-form').validate({
            rules: {
                username: {
                    isNotBlank: true,
                    maxlength: 50
                },
                age: {
                    digits: true,
                    min: 0
                }
            },

            messages: {
                username: {
                    isNotBlank: '用户名不能为空',
                    maxlength: '用户名长度在50字符内'
                },
                age: {
                    digits: '请输入正确的年龄',
                    min: '请输入正确的年龄'
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
        util.bindEvents([
            {
                el: '#js-cancel',
                event: 'click',
                handler: function () {
                    parent.layer.closeAll();
                }
            }
        ])
    }

    /**
     * 修改用户
     * @private
     */
    function _edit() {
        http.httpRequest({
            url: '/user/edit',
            type: "post",
            data: $('#js-form').serialize(),
            success: function () {
                parent.layer.closeAll();
            },
            error: function () {
                layer.alert('错误');
            }
        });
    }

});
