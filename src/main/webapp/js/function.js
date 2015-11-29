function getUrlParam(name){
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    var r = window.location.search.substr(1).match(reg);
    if (r!=null) return (r[2]); return null;
}
function getPageList() {
    $.get("./getPageList","", function (data) {
        data = eval(data);
        var count = data.length;
        for (var i = 0; i < count ; i++) {
            if (data[i]["cid"] == getUrlParam("cid")) {
                $('#nav').append("<li class='am-active'><a href='./page?cid=" + data[i]["cid"] + "'>" + data[i]["title"] + "</a></li>");
                $('#index').removeClass("am-active");
            } else {
                $('#nav').append("<li><a href='./page?cid=" + data[i]["cid"] + "'>" + data[i]["title"] + "</a></li>");
            }
        }
    });
}
function getIndexBlog(start,limit) {
    $.get("./getIndexBlog",{"start":start,"limit":limit}, function (data) {
        data = eval(data);
        var count = data.length;
        for (var i = 0; i < count ; i++) {
            var offset = data[i]["content"].indexOf("<!--more-->");
            var content = marked(data[i]["content"], {breaks: true});
            if (offset == -1) {
                $('#article').append('<article class="blog-main"><h3 class="am-article-title blog-title"><a href="./blog?cid=' + data[i]["cid"] + '">' + data[i]["title"] + '</a></h3><h4 class="am-article-meta blog-meta">by <a href="/author?uid=' + data[i]["authorId"] + '">' + data[i]["author"] + '</a> posted on ' + data[i]["date"] + ' under <a href="' + data[i]["categorySlug"] + '">' + data[i]["category"] + '</a></h4><div class="am-g blog-content">' + content + '</div></article>');
            } else {
                $('#article').append('<article class="blog-main"><h3 class="am-article-title blog-title"><a href="./blog?cid=' + data[i]["cid"] + '">' + data[i]["title"] + '</a></h3><h4 class="am-article-meta blog-meta">by <a href="/author?uid=' + data[i]["authorId"] + '">' + data[i]["author"] + '</a> posted on ' + data[i]["date"] + ' under <a href="' + data[i]["categorySlug"] + '">' + data[i]["category"] + '</a></h4><div class="am-g blog-content">' + (content).substring(0, content.indexOf("<!--more-->")) + '<a href="/blog?cid=' + data[i]["cid"] + '"><button type="button" class="am-btn am-btn-primary am-btn-block">点击查看详细内容</button></a></div></article>');
            }
            $('#article').append('<hr class="am-article-divider blog-hr">');
        }
    });
}
function getNewBlogList() {
    var count = 0;
    $.get("./getNewBlogList",{"limit":"10"}, function (data) {
        data = eval(data);
        count = data.length;
        for (var i = 0 ; i < count ; i++) {
            $('#newArticle').append('<li><a href="./blog?cid=' + data[i]["cid"] + '">' + data[i]["title"] + '</a></li>');
        }
    });
    return count;
}
function getBlog() {
    var cid = getUrlParam("cid");
    $.getJSON("./getBlog/" + cid , "", function (data) {
        $('#article').append('<article class="blog-main"><h3 class="am-article-title blog-title">' + data["title"] + '</h3><h4 class="am-article-meta blog-meta">by <a href="./author?uid=' + data["authorId"] + '">' + data["author"] + '</a> posted on ' + data["date"] + ' under <a href="./categorySlug?slug=' + data["categorySlug"] + '">' + data["category"] + '</a></h4><div class="am-g blog-content">' + marked(data["content"], {breaks: true}) + '</div></article>');
        if (data["allowComment"] == "1") {
            $('#article').append('<div class="ds-thread" data-thread-key="' + $.md5(window.location.href) + '" data-title="' + data["title"] + '" data-url="' + window.location.href + '"></div>');
            (function() {
                var ds = document.createElement('script');
                ds.type = 'text/javascript';ds.async = true;
                ds.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') + '//static.duoshuo.com/embed.js';
                ds.charset = 'UTF-8';
                (document.getElementsByTagName('head')[0]
                || document.getElementsByTagName('body')[0]).appendChild(ds);
            })();
        }
    });
}
function getPage() {
    var cid = getUrlParam("cid");
    $.getJSON("./getPage/" + cid , "", function (data) {
        $('#article').prepend('<article class="blog-main"><h3 class="am-article-title blog-title">' + data["title"] + '</h3><div class="am-g blog-content">' + marked(data["content"], {breaks: true}) + '</div></article>');
        if (data["allowComment"] == "1") {
            $('#article').append('<div class="ds-thread" data-thread-key="' + $.md5(window.location.href) + '" data-title="' + data["title"] + '" data-url="' + window.location.href + '"></div>');
            (function() {
                var ds = document.createElement('script');
                ds.type = 'text/javascript';ds.async = true;
                ds.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') + '//static.duoshuo.com/embed.js';
                ds.charset = 'UTF-8';
                (document.getElementsByTagName('head')[0]
                || document.getElementsByTagName('body')[0]).appendChild(ds);
            })();
        }
    });
}

function search() {
	var searchBox = $('#searchBox').val();
    window.location.href = "./search?wd=" + encodeURIComponent(searchBox);
}

function getSearch() {
    var wd = getUrlParam("wd");
    $.get("./getSearch/" + wd,"", function (data) {
        data = eval(data);
        var count = data.length;
        for (var i = 0; i < count ; i++) {
            var offset = data[i]["content"].indexOf("<!--more-->");
            var content = marked(data[i]["content"], {breaks: true});
            if (offset == -1) {
                $('#article').append('<article class="blog-main"><h3 class="am-article-title blog-title"><a href="./blog?cid=' + data[i]["cid"] + '">' + data[i]["title"] + '</a></h3><h4 class="am-article-meta blog-meta">by <a href="./author?uid=' + data[i]["authorId"] + '">' + data[i]["author"] + '</a> posted on ' + data[i]["date"] + ' under <a href="./categorySlug?slug=' + data[i]["categorySlug"] + '">' + data[i]["category"] + '</a></h4><div class="am-g blog-content">' + content + '</div></article>');
            } else {
                $('#article').append('<article class="blog-main"><h3 class="am-article-title blog-title"><a href="./blog?cid=' + data[i]["cid"] + '">' + data[i]["title"] + '</a></h3><h4 class="am-article-meta blog-meta">by <a href="./author?uid=' + data[i]["authorId"] + '">' + data[i]["author"] + '</a> posted on ' + data[i]["date"] + ' under <a href="./categorySlug?slug=' + data[i]["categorySlug"] + '">' + data[i]["category"] + '</a></h4><div class="am-g blog-content">' + (content).substring(0, content.indexOf("<!--more-->")) + '<a href="./blog?cid=' + data[i]["cid"] + '"><button type="button" class="am-btn am-btn-primary am-btn-block">点击查看详细内容</button></a></div></article>');
            }
            $('#article').append('<hr class="am-article-divider blog-hr">');
        }
    });
}

function getAuthor() {
    var uid = getUrlParam("uid");
    $.get("./getAuthor/" + uid,"", function (data) {
        data = eval(data);
        var count = data.length;
        for (var i = 0; i < count ; i++) {
            var offset = data[i]["content"].indexOf("<!--more-->");
            var content = marked(data[i]["content"], {breaks: true});
            if (offset == -1) {
                $('#article').append('<article class="blog-main"><h3 class="am-article-title blog-title"><a href="./blog?cid=' + data[i]["cid"] + '">' + data[i]["title"] + '</a></h3><h4 class="am-article-meta blog-meta">by <a href="./author?uid=' + data[i]["authorId"] + '">' + data[i]["author"] + '</a> posted on ' + data[i]["date"] + ' under <a href="' + data[i]["categorySlug"] + '">' + data[i]["category"] + '</a></h4><div class="am-g blog-content">' + content + '</div></article>');
            } else {
                $('#article').append('<article class="blog-main"><h3 class="am-article-title blog-title"><a href="./blog?cid=' + data[i]["cid"] + '">' + data[i]["title"] + '</a></h3><h4 class="am-article-meta blog-meta">by <a href="./author?uid=' + data[i]["authorId"] + '">' + data[i]["author"] + '</a> posted on ' + data[i]["date"] + ' under <a href="' + data[i]["categorySlug"] + '">' + data[i]["category"] + '</a></h4><div class="am-g blog-content">' + (content).substring(0, content.indexOf("<!--more-->")) + '<a href="/blog?cid=' + data[i]["cid"] + '"><button type="button" class="am-btn am-btn-primary am-btn-block">点击查看详细内容</button></a></div></article>');
            }
            $('#article').append('<hr class="am-article-divider blog-hr">');
        }
    });
}