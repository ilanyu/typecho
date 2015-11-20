<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>管理员登录</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <script src="http://lib.sinaapp.com/js/jquery/2.0.3/jquery-2.0.3.js"></script>
    <script src="http://cdn.amazeui.org/amazeui/2.4.2/js/amazeui.js"></script>
    <link rel="stylesheet" href="http://cdn.amazeui.org/amazeui/2.4.2/css/amazeui.css"/>
    <style>
        .header ,.footer {
            text-align: center;
        }

        .header h1 {
            font-size: 200%;
            color: #333;
            margin-top: 30px;
        }

        .header p ,.footer p {
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="am-g">
        <h1>Typecho</h1>
    </div>
    <hr/>
</div>
<div class="am-g">
    <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
        <div class="am-form">
            <div class="am-form-group">
                <label for="username">用户名</label>
                <input type="text" class="" id="username" placeholder="用户名" />
            </div>
            <div class="am-form-group">
                <label for="password">密码</label>
                <input type="password" class="" id="password" placeholder="密码" />
            </div>
            <div class="am-form-group">
                <button type="button" class="am-btn am-btn-default am-radius am-u-center" onclick="login()">登录</button>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <br />
    <hr />
    <div class="am-g">
        <p><a href="http://www.lanyus.com/">ilanyu</a></p>
    </div>
</div>
<div class="am-modal am-modal-no-btn" tabindex="-1" id="error">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">错误
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-bd">
            用户名或密码错误
        </div>
    </div>
</div>
<script>
    function login() {
        var username = $('#username').val();
        var password = $('#password').val();
        $.post("./login/login",{"name":username,"password":password},function (data) {
            data = JSON.parse(data);
            if (data.status == "error") {
                $('#error').modal();
            } else {
                window.location = "/admin";
            }
        });
    }
</script>
</body>
</html>
