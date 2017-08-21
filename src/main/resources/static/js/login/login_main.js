require(['component/iframeLayer'], function (layer) {


    /**
     * 初始化函数集合
     */
    function init() {

        if ($("#js-noauth").val() == 1) {
            layer.alert('您暂无权限登录本平台！', {icon: 0,closeBtn: 0}, function () {
                window.location.href = window.__LPSP_ANALYSE__.root_url;
            })
        }

    }

    init();
});
