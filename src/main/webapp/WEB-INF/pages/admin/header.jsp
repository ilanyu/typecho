<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>后台管理</title>
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.css"/>
    <link rel="stylesheet" href="//cdn.amazeui.org/amazeui/2.5.0/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">
    <div class="am-topbar-brand">
        <strong>Typecho</strong> <small>后台管理</small>
    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
            <li class="am-dropdown" data-am-dropdown>
                <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                    <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="${pageContext.request.contextPath}/logout"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
            <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
        </ul>
    </div>
</header>

<div class="am-cf admin-main">
    <!-- sidebar start -->
    <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
        <div class="am-offcanvas-bar admin-offcanvas-bar">
            <ul class="am-list admin-sidebar-list">
                <li><a href="${pageContext.request.contextPath}/"><span class="am-icon-home"></span> 首页</a></li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#admin'}"><span class="am-icon-tachometer"></span> 控制台 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub" id="admin">
                        <li><a href="${pageContext.request.contextPath}/admin/" class="am-cf"><span class="am-icon-tachometer"></span> 概要</a></li>
                        <li><a href="${pageContext.request.contextPath}/admin/profile"><span class="am-icon-wrench"></span> 个人设置</a></li>
                    </ul>
                </li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#write-post'}"><span class="am-icon-pencil-square-o"></span> 撰写 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub" id="write-post">
                        <li><a href="${pageContext.request.contextPath}/admin/write-post" class="am-cf"><span class="am-icon-pencil-square-o"></span> 撰写文章</a></li>
                        <li><a href="${pageContext.request.contextPath}/admin/write-page"><span class="am-icon-plus-square"></span> 创建页面</a></li>
                    </ul>
                </li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#manage-posts'}"><span class="am-icon-folder-open"></span> 管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub" id="manage-posts">
                        <li><a href="${pageContext.request.contextPath}/admin/manage-posts" class="am-cf"><span class="am-icon-folder-open"></span> 文章</a></li>
                        <li><a href="${pageContext.request.contextPath}/admin/manage-pages"><span class="am-icon-newspaper-o"></span> 独立页面</a></li>
                        <li><a href="${pageContext.request.contextPath}/admin/manage-categories"><span class="am-icon-envelope"></span> 分类</a></li>
                        <li><a href="${pageContext.request.contextPath}/admin/manage-tags"><span class="am-icon-bookmark-o"></span> 标签</a></li>
                        <li><a href="${pageContext.request.contextPath}/admin/manage-medias"><span class="am-icon-file"></span> 文件</a></li>
                        <li><a href="${pageContext.request.contextPath}/admin/manage-users"><span class="am-icon-user-md"></span> 用户</a></li>
                    </ul>
                </li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#options-general'}"><span class="am-icon-wrench"></span> 设置 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub" id="options-general">
                        <li><a href="${pageContext.request.contextPath}/admin/options-general" class="am-cf"><span class="am-icon-wrench"></span> 基本</a></li>
                        <li><a href="${pageContext.request.contextPath}/admin/options-discussion"><span class="am-icon-comment"></span> 评论</a></li>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath}/logout"><span class="am-icon-sign-out"></span> 注销</a></li>
            </ul>

            <div class="am-panel am-panel-default admin-sidebar-panel">
                <div class="am-panel-bd">
                    <p><span class="am-icon-bookmark"></span> 公告</p>
                    <p>时光静好，与君语；细水流年，与君同。—— Amaze UI</p>
                </div>
            </div>

            <div class="am-panel am-panel-default admin-sidebar-panel">
                <div class="am-panel-bd">
                    <p><span class="am-icon-tag"></span> wiki</p>
                    <p>Welcome to the Amaze UI wiki!</p>
                </div>
            </div>
        </div>
    </div>
    <!-- sidebar end -->
