<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<div class="am-g am-g-fixed blog-g-fixed">
    <div class="am-u-md-8" id="article">
        <%--<button type="button" style="position: absolute;bottom: 10px;display: none" class="am-btn am-btn-primary am-btn-block" onclick="loadMoreBlog()" id="loadMore">点击加载更多内容</button>--%>
    </div>
    <%@include file="sidebar.jsp"%>
</div>

<script src="${pageContext.request.contextPath}/js/function.js"></script>
<script>
//    nowBlogCount = 0;
//    function loadMoreBlog() {
//        getIndexBlog(nowBlogCount,2);
//        nowBlogCount += 2;
//    }
    $(document).ready(function () {
        getPageList();
        getNewBlogList();
        $.ajaxSettings.async = false;
        getAuthor();
        $.ajaxSettings.async = true;
//        nowBlogCount += 2;
//        $('#loadMore').show();
    });
</script>
<%@include file="footer.jsp"%>