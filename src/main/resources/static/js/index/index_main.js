require(['component/iframeLayer',
    'common/util',
    'common/http',
    'jquery.validate',
    'common/validateRules', 'h-ui', 'h-admin'], function (layer, util, http) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        $("body").Huitab({
            tabBar:".navbar-wrapper .navbar-levelone",
            tabCon:".Hui-aside .menu_dropdown",
            className:"current",
            index:0,
        });
    }

});
