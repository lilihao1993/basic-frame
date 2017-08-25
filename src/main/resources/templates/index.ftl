<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>基础框架</title>
    <link rel="shortcut icon" href="/static/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/static/css/vendor/layout-default-latest.css">
    <link rel="stylesheet" href="/static/css/wechat.css">
</head>
<body style="overflow: hidden; position: relative">
<#include "common/header.ftl">
<div id="container">
    <div class="pane ui-layout-center">
        <div id="page-wrapper">
            <div id="content-main" class="J_mainContent">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="/admin/material/page"
                        frameborder="0"></iframe>
            </div>
            <div class="footer">
                ©&nbsp;&nbsp;2017&nbsp;浙江汇信科技有限公司&nbsp;版权所有
            </div>
        </div>
    </div>

    <div class="pane ui-layout-west">
        <div class="nano">
            <div class="nano-content">
                <div class="sidebar">
                    <div class="sidebar-nav">
                        <ul id="side-menu" class="metismenu">
                            <li class="list-item">
                                <p class="center"><span class="scene-icon active"></span></p>
                                <a href="javascript:void(0)">
                                    <span class="nav-label">服务管理</span>
                                </a>
                                <ul class="nav-second-level">

                                    <li>
                                        <a class="J_menuItem cur" href="<c:url value='/admin/material/page'/>">
                                            素材
                                        </a>
                                    </li>
                                    <li>
                                        <a class="J_menuItem js-menu" href="<c:url value='/admin/menu/page'/>">
                                            菜单
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 通用页面 -->
<#include "common/common.ftl">
<script src="/static/js/index/index_main.js"></script>
</body>
</html>