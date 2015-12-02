<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<!-- content start -->
<div class="admin-content">

    <div class="am-cf am-padding">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">后台管理</strong> /
            <small>网站概要</small>
        </div>
    </div>
    <div class="am-g">
        <div class="am-u-sm-12">
            <div class="am-container">
                <div class="am-g am-u-sm-centered">
                    <div class="am-form">
                        <div class="am-form-group">
                            <label for="screenName-0-1" class="am-form-label">昵称</label>
                            <input id="screenName-0-1" type="text" name="screenName" placeholder="${screenName}"/>
                        </div>
                        <div class="am-form-group">
                            <label for="url-0-2"  class="am-form-label">个人主页地址</label>
                            <input id="url-0-2" type="url" name="url" placeholder="${url}">
                        </div>
                        <div class="am-form-group">
                            <label for="mail-0-3" class="am-form-label">电子邮箱地址 *</label>
                            <input id="mail-0-3" type="email" name="mail" placeholder="${mail}">
                        </div>
                        <div class="am-form-group">
                            <button class="am-btn am-btn-block am-btn-default" onclick="usersProfile()">更新我的档案</button>
                        </div>
                    </div>
                </div>
            </div>
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
    </div>

</div>

<a href="#" class="am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}">
    <span class="am-icon-btn am-icon-th-list"></span>
</a>

<%@include file="footer.jsp" %>
