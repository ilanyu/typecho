<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Blog | Amaze UI Example</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="//cdn.amazeui.org/amazeui/2.4.2/css/amazeui.css"/>
    <script src="//lib.sinaapp.com/js/jquery/2.0.3/jquery-2.0.3.min.js"></script>
    <script src="//cdn.amazeui.org/amazeui/2.4.2/js/amazeui.min.js"></script>

    <style>
        @media only screen and (min-width: 1200px) {
            .blog-g-fixed {
                max-width: 1200px;
            }
        }

        @media only screen and (min-width: 641px) {
            .blog-sidebar {
                font-size: 1.4rem;
            }
        }

        .blog-main {
            padding: 20px 0;
        }

        .blog-title {
            margin: 10px 0 20px 0;
        }

        .blog-meta {
            font-size: 14px;
            margin: 10px 0 20px 0;
            color: #222;
        }

        .blog-meta a {
            color: #27ae60;
        }

        .blog-pagination a {
            font-size: 1.4rem;
        }

        .blog-team li {
            padding: 4px;
        }

        .blog-team img {
            margin-bottom: 0;
        }

        .blog-content img,
        .blog-team img {
            max-width: 100%;
            height: auto;
        }

        .blog-footer {
            padding: 10px 0;
            text-align: center;
        }
    </style>
</head>
<body>

<header class="am-topbar">
    <h1 class="am-topbar-brand">
        <a href="#">blog</a>
    </h1>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#doc-topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav" id="nav">
            <li class="am-active"><a href="/">首页</a></li>
        </ul>

        <form class="am-topbar-form am-topbar-left am-form-inline am-topbar-right" role="search">
            <div class="am-form-group">
                <input type="text" class="am-form-field am-input-sm" placeholder="搜索文章">
            </div>
            <button type="submit" class="am-btn am-btn-default am-btn-sm">搜索</button>
        </form>

    </div>
</header>

<div class="am-g am-g-fixed blog-g-fixed">
    <div class="am-u-md-8" id="article">
        <button type="button" style="position:absolute;bottom:5px;" class="am-btn am-btn-primary am-btn-block" onclick="loadMoreBlog()" id="loadMore">点击加载更多内容</button>
    </div>

    <div class="am-u-md-4 blog-sidebar">
        <div class="am-panel-group">
            <section class="am-panel am-panel-default">
                <div class="am-panel-hd">捐赠</div>
                <div class="am-panel-bd">
                    <div class="am-u-sm-centered"><img src="http://blog.lanyus.com/alipay.png" /></div>
                </div>
            </section>
            <section class="am-panel am-panel-default">
                <div class="am-panel-hd">最新文章</div>
                <ul class="am-list blog-list" id="newArticle">
                </ul>
            </section>

            <section class="am-panel am-panel-default">
                <div class="am-panel-hd">其他</div>
                <ul class="am-list blog-list">
                    <li><a href="/admin">后台管理</a></li>
                    <li><a href="/feed/">文章 RSS</a></li>
                    <li><a href="/feed/comments/">评论 RSS</a></li>
                    <li><a href="http://typecho.org/">Typecho</a></li>
                    <li><a href="http://blog.lanyus.com/">ilanyu</a></li>
                </ul>
            </section>
        </div>
    </div>

</div>

<script>
    nowBlogCount = 0;
    function getPageList() {
        $.getJSON("./getPageList","", function (data) {
            var count = data.length;
            for (var i = 0; i < count ; i++) {
                $('#nav').append("<li><a href='/page?cid=" + data[i]["cid"] + "'>" + data[i]["title"] + "</a></li>");
            }
        });
    }
    function getIndexBlog(start,limit) {
        var count = 0;
        $.ajaxSettings.async = false;
        $.getJSON("./getIndexBlog",{"start":start,"limit":limit}, function (data) {
            count = data.length;
            for (var i = 0; i < count ; i++) {
                $('#article').append('<article class="blog-main"><h3 class="am-article-title blog-title"><a href="/blog?cid=' + data[i]["cid"] + '">' + data[i]["title"] + '</a></h3><h4 class="am-article-meta blog-meta">by <a href="/author?uid=' + data[i]["authorId"] + '">' + data[i]["author"] + '</a> posted on ' + data[i]["date"] + ' under <a href="' + data[i]["categorySlug"] + '">' + data[i]["category"] + '</a></h4><div class="am-g blog-content">' + data[i]["content"] + '</div></article>');
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
    function loadMoreBlog() {
        var BlogCount = getIndexBlog(nowBlogCount,5);
        if (BlogCount == 0) {
            $('#loadMore').hide();
        } else {
            nowBlogCount += 5;
        }
    }
    function getPage() {
        var cid = getUrlParam("cid");
        $.getJSON("/getBlog/" + cid , "", function (data) {
            $('#article').append('<article class="blog-main"><h3 class="am-article-title blog-title">' + data["title"] + '</h3><h4 class="am-article-meta blog-meta">by <a href="/author?uid=' + data["authorId"] + '">' + data["author"] + '</a> posted on ' + data["date"] + ' under <a href="' + data["categorySlug"] + '">' + data["category"] + '</a></h4><div class="am-g blog-content">' + data["content"] + '</div></article>');
        });
    }
    $(document).ready(function () {
        getPageList();

        getNewBlogList();
    });
</script>
</body>
</html>
