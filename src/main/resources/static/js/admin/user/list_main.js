require(['layer1',
    'common/util',
    'common/http',
    'datatables',
    'mydate'], function (layer, util, http, dataTable) {

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
        table = $('#item-table').DataTable({
            //需要初始化dataTable的dom元素
            ajax: {
                url: '/admin/system/user/page',
                data: function (data) {
                    console.log(searchParams);
                    data.condition = searchParams;
                }
            },
            ordering: false,//禁止排序
            showIndex: true,
            scrollX: true,
            columns: [
                {data: null, defaultContent: '', width: '5%'},
                {data: 'userName', width: '10%'},
                {data: 'sex', width: '5%'},
                {data: 'mobile', width: '10%'},
                {data: 'mail', width: '15%'},
                {data: 'address', width: '10%'},
                {data: 'status', width: '5%'},
                {data: 'createTime', width: '15%'},
                {data: null, defaultContent: '', width: '15%'}
            ],
            columnDefs: [
                {
                    targets: 0,
                    render: function (data, type, row, meta) {
                        return '<input type="checkbox" data-id="' + data.id + '" class="checkbox"/>';
                    }
                }, {
                    targets: 2,
                    render: function (data, type, row, meta) {
                        return data == '0' ? '女' : '男';
                    }
                }, {
                    targets: 6,
                    render: function (data, type, row, meta) {
                        return data == '1' ? '正常' : '禁用';
                    }
                },
                {
                    targets: 8,
                    render: function (data, type, row, meta) {
                        return '<input type="button" class="js-modify btn btn-secondary size-S radius" value="修改" data-id="' + data.id + '" />&nbsp' +
                            '<input type="button" data-id="' + data.id + '" data-status="' + data.status + '" class="js-status btn btn-secondary size-S radius" value="更改状态" />&nbsp' +
                            '<input type="button" data-id="' + data.id + '" class="js-del btn btn-danger size-S radius" value="删除" />&nbsp';
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
                parent.layer.open({
                    type: 2,
                    title: ['新增用户', 'font-size:18px;color:#07538f;background:#e4f6fb;'],
                    area: ['65%', '80%'],
                    content: ['/admin/system/user/add'],
                    end: function () {
                        table.ajax.reload();
                    }
                });
            }
        }, {
            el: '.js-modify',
            event: 'click',
            handler: function () {
                var id = $(this).data('id');
                parent.layer.open({
                    type: 2,
                    title: ['修改用户', 'font-size:18px;color:#07538f;background:#e4f6fb;'],
                    area: ['65%', '80%'],
                    content: ['/admin/system/user/modify/' + id],
                    end: function () {
                        table.ajax.reload();
                    }
                });
            }
        }, {
            el: '.js-del',
            event: 'click',
            handler: function () {
                var id = $(this).data('id');
                parent.layer.confirm("确认删除吗？", {icon: 3}, function () {
                    _del(id);
                });
            }
        }, {
            el: '.js-status',
            event: 'click',
            handler: function () {
                var id = $(this).data('id');
                var statusName = $(this).data('status') == 1 ? '禁用' : '正常';
                var status = $(this).data('status') == 1 ? '2' : '1';
                parent.layer.confirm("确认要更改该用户状态为" + statusName + "吗？", {icon: 0}, function () {
                    _modifyUserStatus(id, status);
                });
            }
        }, {
            el: '#js-batch-del',
            event: 'click',
            handler: function () {
                //1.获取选中的所有用户id
                var ids = new Array()
                $('tbody :checked').each(function () {
                    ids.push($(this).data('id'));
                });
                //2.批量删除
                parent.layer.confirm("确认删除所选用户吗？", {icon: 3}, function () {
                    _batchDel(ids);
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
    function _del(id) {
        http.httpRequest({
            url: '/admin/system/user/delete/' + id,
            type: "post",
            success: function (data) {
                if (data.status == 'success') {
                    parent.layer.closeAll();
                    table.ajax.reload();
                } else {
                    parent.layer.alert(data.msg);
                }
            },
            error: function () {
                parent.layer.alert('错误');
            }
        });
    }

    /**
     * 批量删除用户
     * @private
     */
    function _batchDel(ids) {
        http.httpRequest({
            url: '/admin/system/user/batch_del',
            type: "post",
            data: {ids: ids},
            success: function (data) {
                if (data.status == 'success') {
                    parent.layer.closeAll();
                    table.ajax.reload();
                } else {
                    parent.layer.alert(data.msg);
                }
            },
            error: function () {
                parent.layer.alert('错误');
            }
        });
    }

    /**
     * 更改用户状态
     * @private
     */
    function _modifyUserStatus(id, status) {
        http.httpRequest({
            url: '/admin/system/user/modify_status/' + id + '/' + status,
            type: "post",
            success: function (data) {
                if (data.status == 'success') {
                    parent.layer.closeAll();
                    table.ajax.reload();
                } else {
                    parent.layer.alert(data.msg);
                }
            },
            error: function () {
                parent.layer.alert('错误');
            }
        });
    }

});