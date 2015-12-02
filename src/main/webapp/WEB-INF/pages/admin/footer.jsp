<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer>
    <hr>
    <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
</footer>

<div class="am-modal am-modal-no-btn" tabindex="-1" id="updateSuccess">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">提示
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-bd">
            更新成功!
        </div>
    </div>
</div>

<div class="am-modal am-modal-no-btn" tabindex="-1" id="updateFailed">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">提示
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-bd">
            更新失败!
        </div>
    </div>
</div>

<!--[if lt IE 9]>
<script src="//lib.sinaapp.com/js/jquery/1.10/jquery-1.10.0.min.js"></script>
<script src="//cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="${pageContext.request.contextPath}/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="//lib.sinaapp.com/js/jquery/2.0.3/jquery-2.0.3.js"></script>
<!--<![endif]-->
<script src="//cdn.amazeui.org/amazeui/2.4.2/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>
</body>
</html>
