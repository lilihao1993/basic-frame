require.config({
    baseUrl: '/static/js',
    paths: {
        'jquery': 'lib/jquery/jquery-1.12.3.min',
        'handlebars': 'lib/handlebars-1.0.0',
        'layer1': 'lib/layer/layer',
        'laydate': 'lib/laydate/laydate',
        'pagination': 'lib/pagination/jquery.pagination',
        'jquery.validate': 'lib/validate/jquery.validate.min',
        'jquery.layout': 'lib/layout/jquery.layout-latest',
        'jquery.dataTables': 'lib/datatable/jquery.dataTables.min',
        'dataTables.bootstrap': 'lib/datatable/dataTables.bootstrap.min',
        'ztree': 'lib/ztree/jquery.ztree.core.min',
        'ztreeCheck': 'lib/ztree/jquery.ztree.excheck.min',
        'dataTables.fixedHeader': 'lib/datatable/dataTables.fixedHeader.min',
        'dataTables.select': 'lib/datatable/dataTables.select.min',
        'dataTables.buttons': 'lib/datatable/dataTables.buttons.min',
        'buttons.print': 'lib/datatable/buttons.print.min',
        'buttons.flash': 'lib/datatable/buttons.flash.min',
        'buttons.html5': 'lib/datatable/buttons.html5.min',
        'jszip': 'lib/datatable/jszip.min',
        'bootstrap': 'lib/bootstrap/js/bootstrap.min',
        'html5shiv.min': 'lib/bootstrap/js/html5shiv.min',
        'respond.min': 'lib/bootstrap/js/respond.min',
        'jquery.serialize': 'lib/jquery/jquery.serialize-object.min',
        'metisMenu': 'lib/metisMenu',
        'contabs': 'lib/contabs.min',
        'pace': 'lib/pace/pace.min',
        'select2': 'lib/select2/select2.min',
        'jquery.nanoscroller': 'lib/jquery/jquery.nanoscroller.min',
        'mydate': 'lib/mydate97/WdatePicker',
        'h-admin': 'lib/h-admin/H-ui.admin',
        'h-ui': 'lib/h-ui/H-ui.min.js',
        'jquery.contextmenu': 'lib/jquery.contextmenu/jquery.contextmenu.r2',
        'h-jquery': 'lib/jquery/jquery-1.12.3.min',
        'laypage': 'lib/laypage/1.2/laypage',
        'icheck':'lib/icheck/jquery.icheck.min'
    },
    shim: {
        'bootstrap': {
            deps: ['jquery']
        },
        'layer1': {
            deps: ['jquery']
        },
        'pagination': {
            deps: ['jquery']
        },
        'laydate': {
            deps: ['jquery']
        },
        'jquery.layout': {
            deps: ['jquery']
        },
        'dataTables.fixedHeader': {
            deps: ['jquery.dataTables']
        },
        'dataTables.bootstrap': {
            deps: ['jquery.dataTables']
        },
        'dataTables.buttons': {
            deps: ['jquery.dataTables']
        },
        'buttons.print': {
            deps: ['jquery.dataTables', 'dataTables.buttons']
        },
        'buttons.flash': {
            deps: ['jquery.dataTables', 'dataTables.buttons']
        },
        'buttons.html5': {
            deps: ['jquery.dataTables', 'dataTables.buttons']
        },
        'ztree': {
            deps: ['jquery']
        },
        'ztreeCheck': {
            deps: ['jquery', 'ztree']
        },
        'metisMenu': {
            deps: ['jquery']
        },
        'contabs': {
            deps: ['jquery']
        },
        'select2': {
            deps: ['jquery']
        },
        'h-admin': {
            deps: ['h-jquery']
        },
        'h-ui': {
            deps: ['h-jquery']
        }, 'jquery.contextmenu': {
            deps: ['h-jquery']
        }, 'icheck': {
            deps: ['jquery']
        }
    },
    waitSeconds: 0
});