<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String header = "<link rel=\"stylesheet\" href=\"./admin/css/normalize.css?v="
            + application.getAttribute("suffixVersion") + "\">"
            + "<link rel=\"stylesheet\" href=\"./admin/css/grid.css?v="
            + application.getAttribute("suffixVersion") + "\"><link rel=\"stylesheet\" href=\"./admin/css/style.css?v="
            + application.getAttribute("suffixVersion") + "\"><!--[if lt IE 9]>" +
            "<script src=\"./admin/js/html5shiv.js?v=" + application.getAttribute("suffixVersion") + "\"></script>" +
            "<script src=\"./admin/js/respond.js?v=" + application.getAttribute("suffixVersion") + "\"></script>" +
            "<![endif]-->";
%>
<!DOCTYPE HTML>
<html class="no-js">
<head>
    <meta charset="${applicationScope.charset}">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${applicationScope.menutitle} - ${applicationScope.title} - Powered by Typecho</title>
    <meta name="robots" content="noindex, nofollow">
    <%=header%>
</head>
<body>
<!--[if lt IE 9]>
<div class="message error browsehappy" role="dialog">
    当前网页 <strong>不支持</strong>你正在使用的浏览器. 为了正常的访问,
    请 <a href="http://browsehappy.com/">升级你的浏览器</a>.
</div>
<![endif]-->
