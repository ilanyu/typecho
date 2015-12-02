<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<!-- content start -->
<div class="admin-content">

    <div class="am-cf am-padding">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">后台管理</strong> /
            <small>个人设置</small>
        </div>
    </div>
    <div class="am-g">
        <div class="am-u-sm-12">
            <h2 class="am-header">个人资料</h2>
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

            <h2 class="am-header">密码修改</h2>

            <div class="am-container">
                <div class="am-g am-u-sm-centered">
                    <div class="am-form">
                        <div class="am-form-group">
                            <label for="password-0-4" class="am-form-label">用户密码</label>
                            <input id="password-0-4" type="password" name="password"/>
                        </div>
                        <div class="am-form-group">
                            <label for="confirm-0-5" class="am-form-label">用户密码确认</label>
                            <input id="confirm-0-5" type="password" name="confirm"/>
                        </div>
                        <div class="am-form-group">
                            <button class="am-btn am-btn-block am-btn-default" onclick="usersPassword()">更新密码</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<a href="#" class="am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}">
    <span class="am-icon-btn am-icon-th-list"></span>
</a>

<%@include file="footer.jsp" %>
