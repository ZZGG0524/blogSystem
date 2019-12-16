var submit_blog_xhr = null;

function submit_blog_init() {
    submit_blog_xhr = GetXMlHttpRequest();
	if(submit_blog_xhr) {
		submit_blog_xhr.onreadystatechange = user_blog_response;
	}else {
		alert("你的浏览器不支持AJAX，推荐使用firefoxs或者chrome浏览器");
	}
}

function submit_blog_request() {
	if(submit_blog_xhr) {
		// var content = document.getElementById("comment_content").value;
		// var content = document.getElementById("comment_content").innerHTML;
        var title = $("#blog_title").val();
        var content = $("#blog_content").val();
        if(content == "" && title == "" ) {
            alert("内容为空");
        }else {
            // "{\"2\":\"efg\",\"1\":\"abc\"}";
            // "{\"2\":\"efg\",\"1\":\"abc\"}";
            var json = "{\'title\':"+"'"+title+"'"+",\'content\':"+"'"+content+"'"+"}";
            submit_blog_xhr.open('post','../../insertBlog.action',true);
            submit_blog_xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
            submit_blog_xhr.send('json='+json);
        }
	}
}

function user_blog_response() {
	if(submit_blog_xhr.readyState == 4) {
		if(submit_blog_xhr.status == 200) {
            blog_init();
			cleartextarea();
		}
	}
}

function cleartextarea() {
	document.getElementById("blog_title").value="";
	document.getElementById("blog_content").value="";
}