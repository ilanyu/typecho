<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<!-- content start -->
<div class="admin-content">

    <div class="am-cf am-padding">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">后台管理</strong> /
            <small>评论</small>
        </div>
    </div>
    <div class="am-u-sm-12">
        <h2 class="am-header">评论设置</h2>

        <div class="am-container">
            <div class="am-u-sm-centered">
                <div class="am-form">
                    <div class="am-form-group">
                        <label for="short_name" class="am-form-label">多说short_name</label>
                        <input id="short_name" type="text" name="short_name" placeholder="${short_name}"
                               value="${short_name}"/>
                    </div>
                    <div class="am-form-group">
                        <button class="am-btn am-btn-block am-btn-default" onclick="optionsDiscussion()">更新评论设置</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="am-container">
            <div class="am-u-sm-centered">
                <p class="am-comment">获取short_name及管理评论，请前往<a href="http://www.duoshuo.com/">http://www.duoshuo.com/</a>.
                </p>
            </div>
        </div>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </div>

</div>

<a href="#" class="am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}">
    <span class="am-icon-btn am-icon-th-list"></span>
</a>

<%@include file="footer.jsp" %>
