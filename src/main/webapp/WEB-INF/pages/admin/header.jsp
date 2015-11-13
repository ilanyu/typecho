<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String header = "<link rel=\"stylesheet\" href=\"./usr/css/admin/normalize.css\">"
            + "<link rel=\"stylesheet\" href=\"./usr/css/admin/grid.css\">"
            + "<link rel=\"stylesheet\" href=\"./usr/css/admin/style.css\">"
            + "<!--[if lt IE 9]>"
            + "<script src=\"./usr/js/admin/html5shiv.js\"></script>"
            + "<script src=\"./usr/js/admin/respond.js\"></script>"
            + "<![endif]-->";
%>v
<!DOCTYPE HTML>
<html class="no-js">
<head>
    <meta charset="UTF-8">
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
