var blog_content_xhr = null;

function blog_content_init() {
	blog_content_xhr = GetXMlHttpRequest();
	if(blog_content_xhr) {
		blog_content_xhr.onreadystatechange = blog_content_response;
		blog_content_xhr.open('get','loadingBlogContent.action',true);
		blog_content_xhr.send(null);
	}else {
		alert("你的浏览器不支持AJAX，推荐使用firefoxs或者chrome浏览器");
	}
}

function blog_content_response() {
	if(blog_content_xhr.readyState == 4) {
		if(blog_content_xhr.status == 200) {
			var blog_content = blog_content_xhr.responseText;
			// var json_blog = eval('('+ blog + ')');
            var json_blog = JSON.parse(blog_content);
            
            document.getElementById("blog_title").innerHTML = json_blog.blog_title;
            document.getElementById("blog_people_id").innerHTML = json_blog.blog_people_id;
            document.getElementById("blog_time").innerHTML = json_blog.blog_time;
            document.getElementById("blog_content").innerHTML = json_blog.blog_content;

			// document.getElementById("content").innerHTML = blog_content_xhr.responseText;
			// var parent_div = document.getElementById("blog");
			// for(var i = 0; i < json_blog.length; i++) {
			// 	// var div = null;
			// 	// var blog_time_div = null;
			// 	// var blog_time_div = null;
			// 	var div = document.createElement("div");

			// 	// var blog_id_div = document.createElement("div");
			// 	// div.setAttribute("id", json_blog[i].blog_id);


			// 	//博客标题
			// 	var blog_title_div = document.createElement("a");
			// 	var blog_title_content = document.createTextNode("标题:"+json_blog[i].blog_title);
			// 	blog_title_div.appendChild(blog_title_content);

			// 	// blog_title_div.onclick(function(){
					
			// 	// });

			// 	blog_title_div.setAttribute("id", json_blog[i].blog_id);

			// 	blog_title_div.setAttribute("onclick","postwith(this.id)");

			// 	// blog_title_div.setAttribute("href","javascript:postwith(this.id)");getBlogContent.action
			// 	blog_title_div.setAttribute("href","#");

			// 	//博客内容
			// 	var blog_content_div = document.createElement("div");
			// 	var blog_content = document.createTextNode("博客内容:"+json_blog[i].blog_content);
			// 	blog_content_div.appendChild(blog_content);

			// 	//博客发布时间
			// 	var blog_time_div = document.createElement("div");
			// 	var blog_time = document.createTextNode("发布时间:"+json_blog[i].blog_time);
			// 	blog_time_div.appendChild(blog_time);

			// 	div.appendChild(blog_title_div);
			// 	div.appendChild(blog_content_div);
			// 	div.appendChild(blog_time_div);

			// 	var br = document.createElement("br");

			// 	parent_div.appendChild(div);
			// 	parent_div.appendChild(br);
			// }
		}
	}
}