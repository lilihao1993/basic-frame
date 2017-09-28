<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="/favicon.ico" >
    <link rel="Shortcut Icon" href="/favicon.ico" />
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="/static/css/h-ui/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="/static/css/h-admin/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="/static/js/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/static/css/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="/static/css/h-admin/style.css" />
    <link rel="stylesheet" type="text/css" href="/static/js/lib/icheck/icheck.css" />
    <link rel="stylesheet" type="text/css" href="/static/js/lib/laydate/theme/default/laydate.css" />


    <![endif]-->
    <!--/meta 作为公共模版分离出去-->
    <title>添加用户 - H-ui.admin v3.1</title>
    <meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
    <form action="" class="form form-horizontal" id="form-user-edit">
        <div class="row c1">
            <div class="col-xs-3"></div>
            <div class="col-xs-8">
                <input type="hidden" name="id" value="<#if user??>${user.id!''}</#if>">
                <div class="error-box"></div>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-3 "><span class="c-red">*</span>用户名：</label>
            <div class="formControls col-xs-8">
                <input type="text" class="input-text" maxlength="20" value="<#if user??>${user.userName!''}</#if>" placeholder="" id="username" name="userName">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-3 "><span class="c-red">*</span>真实姓名：</label>
            <div class="formControls col-xs-8">
                <input type="text" class="input-text" maxlength="20" value="<#if user??>${user.Name!''}</#if>" placeholder="" id="name" name="name">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-3 "><span class="c-red">*</span>密码：</label>
            <div class="formControls col-xs-8">
                <input type="password" class="input-text" maxlength="20" value="<#if user??>${user.password!''}</#if>" placeholder="" id="password" name="password">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-3 "><span class="c-red">*</span>性别：</label>
            <div class="formControls col-xs-8 skin-minimal">
                <div class="radio-box">
                    <input name="sex" type="radio" value="1"  id="sex-1" <#if user??>${(user.sex == '1')?string('checked','')}<#else> checked </#if> >
                    <label for="sex-1">男</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="sex-2" value="0" name="sex" <#if user??>${(user.sex == '0')?string('checked','')}</#if>>
                    <label for="sex-2">女</label>
                </div>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-3 "><span class="c-red">*</span>手机：</label>
            <div class="formControls col-xs-8">
                <input type="text" class="input-text" maxlength="11" value="<#if user??>${user.mobile!''}</#if>" placeholder="" id="mobile" name="mobile">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-3 "><span class="c-red">*</span>邮箱：</label>
            <div class="formControls col-xs-8">
                <input type="text" class="input-text" maxlength="50" placeholder="@" name="mail" value="<#if user??>${user.mail!''}</#if>" id="mail">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-3 "><span class="c-red">*</span>微信号：</label>
            <div class="formControls col-xs-8">
                <input type="text" class="input-text" maxlength="20" name="wechat" value="<#if user??>${user.wechat!''}</#if>" id="wechat">
            </div>
        </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-3 "><span class="c-red">*</span>生日：</label>
            <div class="formControls col-xs-8">
                <input type="text" name="dirthday" value="<#if user??>${user.dirthday?string('yyyy-MM-dd')}</#if>" id="dirthday" class="input-text Wdate" style="width:120px;">
            </div>
        </div>

        <#--&lt;#&ndash;<div class="row cl">&ndash;&gt;-->
            <#--&lt;#&ndash;<label class="form-label col-xs-3 col-sm-3">附件：</label>&ndash;&gt;-->
            <#--&lt;#&ndash;<div class="formControls col-xs-8col-sm-9"> <span class="btn-upload form-group">&ndash;&gt;-->
				<#--&lt;#&ndash;<input class="input-text upload-url" type="text" name="uploadfile" id="uploadfile" readonly nullmsg="请添加附件！" style="width:200px">&ndash;&gt;-->
				<#--&lt;#&ndash;<a href="javascript:void();" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>&ndash;&gt;-->
				<#--&lt;#&ndash;<input type="file" multiple name="file-2" class="input-file">&ndash;&gt;-->
				<#--&lt;#&ndash;</span> </div>&ndash;&gt;-->
        <#--&lt;#&ndash;</div>&ndash;&gt;-->
        <#--<div class="row cl">-->
            <#--<label class="form-label col-xs-3 col-sm-3">所在城市：</label>-->
            <#--<div class="formControls col-xs-8col-sm-9"> <span class="select-box">-->
				<#--<select class="select" size="1" name="city">-->
					<#--<option value="" selected>请选择城市</option>-->
					<#--<option value="1">北京</option>-->
					<#--<option value="2">上海</option>-->
					<#--<option value="3">广州</option>-->
				<#--</select>-->
				<#--</span> </div>-->
        <#--</div>-->
        <div class="row cl">
            <label class="form-label col-xs-3 ">所在地区：</label>
            <div class="formControls  col-xs-8">
                <div id="province"></div>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-3 ">备注：</label>
            <div class="formControls  col-xs-8">
                <textarea name="sketch" cols="" maxlength="300"  rows="" class="textarea"  placeholder="说点什么...最少输入10个字符"><#if user??>${user.sketch!''}</#if></textarea>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-xs-offset-4 ">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>
<script type="text/javascript" src="/static/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/static/js/lib/h-ui/H-ui.min.js"></script>
<script type="text/javascript" src="/static/js/lib/h-admin/H-ui.admin.js"></script>
<#include "../../common/common.ftl">
<script src="/static/js/admin/user/edit_main.js"></script>
</body>
</html>