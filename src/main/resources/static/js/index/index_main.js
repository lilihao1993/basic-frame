require(['component/iframeLayer',
    'common/util',
    'common/http'], function (layer, util, http) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        //事件绑定
        _bind();
    }

    /**
     * 事件绑定
     * @private
     */
    function _bind() {
        util.bindEvents([{
            el: '#info',
            event: 'click',
            handler: function () {
                layer.dialog({
                    type: 2,
                    title: ['个人信息页', 'font-size:18px;color:#07538f;background:#e4f6fb;'],
                    area: ['40%', '60%'],
                    content: ['/admin/system/user/user_info', 'no'],
                    callback: function () {
                    }
                });

            }
        }, {
            el: '#logOut',
            event: 'click',
            handler: function () {
                layer.confirm('确定要退出登录吗?', {icon: 3, title: '提示'}, function () {
                    location.assign('/admin/cat_user');
                })

            }
        }
        ]);
    }

});
