require(['component/iframeLayer',
    'component/dataTable',
    'common/util',
    'common/http',
    'jquery.serialize'], function (layer, dataTable, util, http) {

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
            el: '#js-add',
            event: 'click',
            handler: function () {
                $(this).blur();
                layer.dialog({
                    type: 2,
                    title: ['新增用户', 'font-size:18px;color:#07538f;background:#e4f6fb;'],
                    area: ['560px', '320px'],
                    content: ['/user/toadd', 'no'],
                    callback: function () {
                        location.reload();
                    }
                });
            }
        }, {
            el: '#js-edit',
            event: 'click',
            handler: function () {
                var id = $(this).data('id');
                layer.dialog({
                    type: 2,
                    title: ['修改用户', 'font-size:18px;color:#07538f;background:#e4f6fb;'],
                    area: ['560px', '320px'],
                    content: ['/user/toedit/' + id, 'no'],
                    callback: function () {
                        location.reload();
                    }
                });
            }
        }, {
            el: '#js-delete',
            event: 'click',
            handler: function () {
                var id = $(this).data('id');
                layer.confirm("确认删除吗？", {icon: 3}, function () {
                    _delete(id);
                });
            }
        }, {
            el: '#js-add-score',
            event: 'click',
            handler: function () {
                var id = $(this).data('id');
                layer.confirm("确认为该用户加分？", {icon: 3}, function () {
                    _addScore(id);
                });
            }
        }
        ]);
    }

    /**
     * 描述：删除用户
     * @private
     */
    function _delete(id) {
        http.httpRequest({
            url: '/user/delete/' + id,
            type: "post",
            success: function () {
                parent.layer.closeAll();
                location.reload();
            },
            error: function () {
                layer.alert('错误')
            }
        });
    }

    /**
     * 描述：增加用户分数
     * @param id
     * @private
     */
    function _addScore(id) {
        http.httpRequest({
            url: '/user/sign/' + id,
            type: "post",
            success: function (data) {
                if (data.msg == 'error') {
                    layer.msg('加分失败！');
                } else {
                    location.reload();
                }
            },
            error: function () {
                layer.alert('错误')
            }
        });
    }
});
