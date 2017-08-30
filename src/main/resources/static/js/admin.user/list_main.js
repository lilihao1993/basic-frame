require(['layer1',
    'common/util',
    'common/http',
    'component/dataTable',
    'mydate',
    'laypage'], function (layer, util, http, dataTable) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        //初始化dataTable
        _initDataTable();
        //事件绑定
        _bind();
    }

    //查询参数声明
    var searchParams;
    var table;

    /**
     * 初始化dataTable
     * @private
     */
    function _initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#item-table',
            ajax: {
                url: '/admin/system/user/page',
                data: function (data) {
                    console.log(searchParams);
                    data.condition = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            // showIndex: true,
            scrollX: true,
            columns: [
                {data: null, defaultContent: '', width: '5%'},
                {data: 'userName', width: '10%'},
                {data: 'sex', width: '5%'},
                {data: 'mobile', width: '15%'},
                {data: 'mail', width: '20%'},
                {data: 'address', width: '15%'},
                {data: 'createTime', width: '20%'},
                {data: null, defaultContent: '', width: '10%'}
            ],
            columnDefs: [
                {
                    targets: 0,
                    render: function (data, type, row, meta) {
                        return '<input type="checkbox" class="checkbox"/>';
                    }
                }, {
                    targets: 2,
                    render: function (data, type, row, meta) {
                        return data == '0' ? '女' : '男';
                    }
                },
                {
                    targets: 7,
                    render: function (data, type, row, meta) {
                        return '<input type="button" class="js-modify btn btn-secondary size-S radius" value="修改" data-id="' + data.id + '" />&nbsp' +
                            '<input type="button" data-id="' + data.id + '" class="js-del btn btn-danger size-S radius" value="删除" />';
                    }
                }
            ]
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
                parent.layer.open({
                    type: 2,
                    title: ['新增用户', 'font-size:18px;color:#07538f;background:#e4f6fb;'],
                    area: ['60%', '70%'],
                    content: ['/admin/system/user/add'],
                    callback: function () {
                        table.ajax.reload();
                    }
                });
            }
        }, {
            el: '.js-edit',
            event: 'click',
            handler: function () {
                var id = $(this).data('id');
                layer.dialog({
                    type: 2,
                    title: ['修改采集项', 'font-size:18px;color:#07538f;background:#e4f6fb;'],
                    area: ['560px', '300px'],
                    content: ['/admin/system/user/modify' + id, 'no'],
                    callback: function () {
                        table.ajax.reload();
                    }
                });
            }
        }, {
            el: '.js-del',
            event: 'click',
            handler: function () {
                var id = $(this).data('id');
                layer.confirm("确认删除吗？", {icon: 3}, function () {
                    _delete(id);
                });
            }
        }, {
            el: '#selected',
            event: 'click',
            handler: function () {
                //复选框全选全不选
                $(".checkbox").prop("checked", this.checked);
            }
        }, {
            el: '.checkbox',
            event: 'click',
            handler: function () {
                //一个复选框未选，则全选复选框不勾选
                debugger;
                if ($(".checkbox:not(:checked)").length > 0) {
                    $('#selected').attr("checked", false);
                } else {
                    $('#selected')[0].checked = true;
                }
            }
        }
        ]);
    }

    /**
     * 删除用户
     * @param id
     * @private
     */
    function _delete(id) {
        http.httpRequest({
            url: '/admin/collect/item/delete/' + id,
            type: "post",
            success: function (data) {
                if (data.status == 'success') {
                    layer.closeAll();
                    table.ajax.reload();
                } else {
                    layer.alert(data.msg);
                }
            },
            error: function () {
                layer.alert('错误');
            }
        });
    }

});