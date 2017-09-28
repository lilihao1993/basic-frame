<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="/static/css/h-ui/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="/static/css/h-admin/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="/static/js/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/static/css/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="/static/css/h-admin/style.css" />
    <title>用户管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
    <div class="text-c"> 日期范围：
        <input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px;">
        -
        <input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px;">
        <input type="text" class="input-text" style="width:250px" placeholder="输入会员名称、电话、邮箱" id="" name=""><button type="submit" class="btn btn-success" id="" name=""><i class="icon-search"></i> 搜用户</button>

    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
    <span class="l"><a href="javascript:;" id="js-batch-del" class="btn btn-danger radius"><i class="icon-trash"></i> 批量删除</a>
    <a href="javascript:;" id="js-add"  class="btn btn-primary radius"><i class="icon-plus"></i> 添加用户</a></span>
        <span class="r">共有数据：<strong>${count!''}</strong> 条</span>
    </div>
    <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive" border="0" cellspacing="0" cellpadding="0" id="item-table" width="100%">
        <thead>
        <tr class="text-c">
            <th><input type="checkbox" id="selected"/></th>
            <th>用户名</th>
            <th>性别</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>地址</th>
            <th>状态</th>
            <th>加入时间</th>
            <th>操作</th>
        </tr>
        </thead>
    </table>
    <div id="pageNav" class="pageNav"></div>
</div>
<!--_footer 作为公共模版分离出去-->
<#include "../../common/common.ftl">
<!--/_footer 作为公共模版分离出去-->

<script src="/static/js/admin/user/list_main.js"></script>

</body>
</html>