<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="/static/images/favicon.ico">
    <link rel="Shortcut Icon" href="/static/images/favicon.ico"/>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="/static/css/h-ui/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/h-admin/style.css"/>
    <![endif]-->
    <title>H-ui.admin v3.1</title>
    <meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<#if Session.SESSION_USER_INFO?exists>
<div class="cl pd-20" style=" background-color:#5bacb6">
    <img class="avatar size-XL l" src="/static/images/ucnter/avatar-default.jpg">
    <dl style="margin-left:80px; color:#fff">
        <dt>
            <span class="f-18">${Session.SESSION_USER_INFO.name!''}</span>
            <span class="pl-10 f-12">余额：40</span>
        </dt>
        <dd class="pt-10 f-12" style="margin-left:0">${(Session.SESSION_USER_INFO.sketch !='')?string(Session.SESSION_USER_INFO.sketch,'这家伙很懒，什么也没有留下')}</dd>
    </dl>
</div>
<div class="pd-20">


    <table class="table">
        <tbody>
        <tr>
            <th class="text-r" width="80">性别：</th>
            <td>${(Session.SESSION_USER_INFO.sex == '0')?string('女','男')}</td>
        </tr>
        <tr>
            <th class="text-r">手机：</th>
            <td>${Session.SESSION_USER_INFO.mobile!''}</td>
        </tr>
        <tr>
            <th class="text-r">邮箱：</th>
            <td>${Session.SESSION_USER_INFO.mail!''}</td>
        </tr>
        <tr>
            <th class="text-r">地址：</th>
            <td>${Session.SESSION_USER_INFO.address!''}</td>
        </tr>
        <tr>
            <th class="text-r">注册时间：</th>
            <td>${Session.SESSION_USER_INFO.createTime?string("yyyy-MM-dd")}</td>
        </tr>
        <tr>
            <th class="text-r">积分：</th>
            <td>330</td>
        </tr>
        </tbody>
    </table>
<#else>
    <h1>用户信息获取失败!</h1>
</#if>
</div>

</body>
</html>

