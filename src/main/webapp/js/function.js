function getUrlParam(name){
    //构造一个含有目标参数的正则表达式对象
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    //匹配目标参数
    var r = window.location.search.substr(1).match(reg);
    //返回参数值
    if (r!=null) return unescape(r[2]);
    return null;
}
function getPageList() {
    $.getJSON("./getPageList","", function (data) {
        var count = data.length;
        for (var i = 0; i < count ; i++) {
            if (data[i]["cid"] == getUrlParam("cid")) {
                $('#nav').append("<li class='am-active'><a href='/page?cid=" + data[i]["cid"] + "'>" + data[i]["title"] + "</a></li>");
                $('#index').removeClass("am-active");
            } else {
                $('#nav').append("<li><a href='/page?cid=" + data[i]["cid"] + "'>" + data[i]["title"] + "</a></li>");
            }
        }
    });
}
function getIndexBlog(start,limit) {
    var count = 0;
    $.ajaxSettings.async = false;
    $.getJSON("./getIndexBlog",{"start":start,"limit":limit}, function (data) {
        count = data.length;
        for (var i = 0; i < count ; i++) {
            var offset = data[i]["content"].indexOf("<!--more-->");
            if (offset == -1) {
                $('#article').append('<article class="blog-main"><h3 class="am-article-title blog-title"><a href="/blog?cid=' + data[i]["cid"] + '">' + data[i]["title"] + '</a></h3><h4 class="am-article-meta blog-meta">by <a href="/author?uid=' + data[i]["authorId"] + '">' + data[i]["author"] + '</a> posted on ' + data[i]["date"] + ' under <a href="' + data[i]["categorySlug"] + '">' + data[i]["category"] + '</a></h4><div class="am-g blog-content">' + data[i]["content"] + '</div></article>');
            } else {
                $('#article').append('<article class="blog-main"><h3 class="am-article-title blog-title"><a href="/blog?cid=' + data[i]["cid"] + '">' + data[i]["title"] + '</a></h3><h4 class="am-article-meta blog-meta">by <a href="/author?uid=' + data[i]["authorId"] + '">' + data[i]["author"] + '</a> posted on ' + data[i]["date"] + ' under <a href="' + data[i]["categorySlug"] + '">' + data[i]["category"] + '</a></h4><div class="am-g blog-content">' + (data[i]["content"]).substring(0, data[i]["content"].indexOf("<!--more-->")) + '<a href="/blog?cid=' + data[i]["cid"] + '"><button type="button" class="am-btn am-btn-primary am-btn-block">点击查看更多内容</button></a></div></article>');
            }
            $('#article').append('<hr class="am-article-divider blog-hr">');
        }
    });
    $.ajaxSettings.async = true;
    return count;
}
function getNewBlogList() {
    var count = 0;
    $.getJSON("./getNewBlogList",{"limit":"10"}, function (data) {
        count = data.length;
        for (var i = 0 ; i < count ; i++) {
            $('#newArticle').append('<li><a href="/blog?cid=' + data[i]["cid"] + '">' + data[i]["title"] + '</a></li>');
        }
    });
    return count;
}
function getBlog() {
    var cid = getUrlParam("cid");
    $.getJSON("/getBlog/" + cid , "", function (data) {
        $('#article').append('<article class="blog-main"><h3 class="am-article-title blog-title">' + data["title"] + '</h3><h4 class="am-article-meta blog-meta">by <a href="/author?uid=' + data["authorId"] + '">' + data["author"] + '</a> posted on ' + data["date"] + ' under <a href="' + data["categorySlug"] + '">' + data["category"] + '</a></h4><div class="am-g blog-content">' + data["content"] + '</div></article>');
    });
}
function getPage() {
    var cid = getUrlParam("cid");
    $.getJSON("/getPage/" + cid , "", function (data) {
        $('#article').append('<article class="blog-main"><h3 class="am-article-title blog-title">' + data["title"] + '</h3><div class="am-g blog-content">' + data["content"] + '</div></article>');
    });
}
