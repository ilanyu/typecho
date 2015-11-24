<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<div class="am-g am-g-fixed blog-g-fixed">
    <div class="am-u-md-8" id="article">
    </div>
    <%@include file="sidebar.jsp"%>
</div>

<script src="${pageContext.request.contextPath}/js/function.js"></script>
<script>
    $(document).ready(function () {
        getPageList();
        getNewBlogList();
        getBlog();
    });
</script>
</body>
</html>
