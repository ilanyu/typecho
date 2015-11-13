<%
    if ((Boolean) session.getAttribute("hasLogin")) {
        response.setHeader("Location", (String) application.getAttribute("adminUrl"));
    }
%>
<%@include file="header.jsp" %>
<div class="typecho-login-wrap">
    <div class="typecho-login">
        <h1><a href="http://typecho.org" class="i-logo">Typecho</a></h1>

        <form action="admin/login" method="post" name="login" role="form">
            <p>
                <label for="name" class="sr-only">用户名</label>
                <input type="text" id="name" name="name" value="${applicationScope.rememberName}" placeholder="用户名"
                       class="text-l w-100"
                       autofocus/>
            </p>

            <p>
                <label for="password" class="sr-only">密码</label>
                <input type="password" id="password" name="password" class="text-l w-100" placeholder="密码"/>
            </p>

            <p class="submit">
                <button type="submit" class="btn btn-l w-100 primary">登录</button>
                <input type="hidden" name="referer" value="<%=request.getHeader("referer")%>"/>
            </p>
            <p>
                <label for="remember"><input type="checkbox" name="remember" class="checkbox" value="1" id="remember"/>
                    下次自动登录</label>
            </p>
        </form>

        <p class="more-link">
            <a href="${applicationScope.siteUrl}">返回首页</a>
            <% if ((Boolean) application.getAttribute("allowRegister")) { %>
            &bull;
            <a href="${applicationScope.registerUrl}">用户注册</a>
            <%}%>
        </p>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#name').focus();
    });
</script>
<%@include file="footer.jsp" %>
