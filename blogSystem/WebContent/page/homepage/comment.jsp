<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("path", basePath);
%>
<head>
	<meta charset="UTF-8">
    <title>留言</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta name="viewport" content="width=device-width"/>
    <!-- <link rel="stylesheet" href="../../css/home/comment.css">
    <link rel="stylesheet" href="../../css/home/bootstrap.css"> -->
    <link rel="stylesheet" type="text/css" href="${path}css/home/comment.css">
    <link rel="stylesheet" type="text/css" href="${path}css/home/bootstrap.css">
    <script src="${path}js/zhuang/ajax.js"></script>
    <script src="${path}js/jquery-3.4.1.min.js"></script>
    <script src="${path}js/zhuang/refresh_comment.js"></script>
    <script src="${path}js/zhuang/refresh_blog_content.js"></script>
    <script src="${path}js/zhuang/submit_comment.js"></script>
    <style>
        .test{
            height: auto;
            margin: 0 15%;
        }
    </style>
</head>
<body onload="blog_content_init()" onpageshow="comment_init()">
<div class="header">
    <div class="logo">
        <img src="${path}image/img/homepage/科技图标.png" alt="logo" width="40px" height="40px">
    </div>
    <div class="theme">
        <h1>Blog System</h1>
    </div>
</div>
<div class="left">
    <div class="sidebar">
        <div class="list-group">
            <a href="#" class="list-group-item">博客主页</a>
            <a href="#" class="list-group-item">文章主页</a>
            <a href="#" class="list-group-item">个人主页</a>
        </div>
    </div>
    <div class="backtop" id="topAnchor">
        <a href="#topAnchor" style="position:fixed;right:0;bottom:0">回到文章</a>
    </div>
</div>
<div class="right">
    <div class="article">
        <div class="title_part">
            <div class="title">
                <a1 id="blog_title"></a1>
            </div>
        <div class="writter">
            <a3 id="blog_people_id"></a3>
        </div>
        <div class="date">
            <a3 id="blog_time"></a3>
        </div>
        </div>
        <div class="content">
            <a2 id="blog_content"></a2>
        </div>
    </div>
    <div class="test">
        <div class="comment">
        <div lang="en-US" class="gitment-container gitment-editor-container">
            <div class="gitment-editor-main">
                <div class="gitment-editor-header">
                    <nav class="gitment-editor-tabs">
                        <button class="gitment-editor-tab gitment-selected">评论</button>
                    </nav>
                </div>
                <div class="gitment-editor-body">
                    <div class="gitment-editor-write-field" id="comment_content">
                        <textarea id="user_comment_content" placeholder="你想说些什么" title="Login to Comment" onfocus="user_comment_init()"></textarea>
                    </div>
                    <div class="gitment-editor-preview-field gitment-hidden">
                        <div class="gitment-editor-preview gitment-markdown"></div>
                    </div>
                </div>
            </div>
            <div class="gitment-editor-footer">
                <button class="gitment-editor-submit" title="Login to Comment" onclick="user_comment_request()">评论</button>
            </div>
        </div>
        <div lang="en-US" class="gitment-container gitment-comments-container">
            <ul class="gitment-comments-list">
                <li class="gitment-comment">
                    <a class="gitment-comment-avatar">
                        <!--
                            这里放头像
                        -->
                        <img class="gitment-comment-avatar" src="${path}image/logo.png" alt="avator">
                    </a>
                    <div id="usercomment" class="gitment-comment-main">
                        <!-- <div class="gitment-comment-header">
                            <a class="gitment-comment-name">
                               
                                你大爷
                            </a>
                            <span>2019.12.12</span>
                        </div>
                        <div class="gitment-comment-body gitment-markdown"><p>这里是内容</p></div>   -->
                    </div>
                </li>
            </ul>
        </div>
        </div>
    </div>
</div>
</body>

<script>
    document.getElementById("topAnchor").onclick = function(){
        document.body.scrollTop = document.documentElement.scrollTop = 0;
    }
</script>
</html>