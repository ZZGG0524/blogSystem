var blog_xhr = null;

function blog_init() {
	blog_xhr = GetXMlHttpRequest();
	if(blog_xhr) {
		blog_xhr.onreadystatechange = blog_response;
		blog_xhr.open('get','../../getBlog.action',true);
		blog_xhr.send(null);
	}else {
		alert("你的浏览器不支持AJAX，推荐使用firefoxs或者chrome浏览器");
	}
}

function blog_response() {
	if(blog_xhr.readyState == 4) {
		if(blog_xhr.status == 200) {
			var blog = blog_xhr.responseText;
			// var json_blog = eval('('+ blog + ')');
			var json_blog = JSON.parse(blog);
			// document.getElementById("blog").innerHTML = blog_xhr.responseText;
			var parent_div = document.getElementById("blog");
			for(var i = 0; i < json_blog.length; i++) {
				// var div = null;
				// var blog_time_div = null;
				// var blog_time_div = null;
				var div = document.createElement("div");

				// var blog_id_div = document.createElement("div");
				// div.setAttribute("id", json_blog[i].blog_id);


				//博客标题
				var blog_title_div = document.createElement("a");
				var blog_title_content = document.createTextNode("标题:"+json_blog[i].blog_title);
				blog_title_div.appendChild(blog_title_content);

				// blog_title_div.onclick(function(){
					
				// });

				blog_title_div.setAttribute("id", json_blog[i].blog_id);

				blog_title_div.setAttribute("onclick","postwith(this.id)");

				// blog_title_div.setAttribute("href","javascript:postwith(this.id)");getBlogContent.action
				blog_title_div.setAttribute("href","#");

				//博客内容
				var blog_content_div = document.createElement("div");
				var blog_content = document.createTextNode("博客内容:"+json_blog[i].blog_content);
				blog_content_div.appendChild(blog_content);

				//博客发布时间
				var blog_time_div = document.createElement("div");
				var blog_time = document.createTextNode("发布时间:"+json_blog[i].blog_time);
				blog_time_div.appendChild(blog_time);

				div.appendChild(blog_title_div);
				div.appendChild(blog_content_div);
				div.appendChild(blog_time_div);

				var br = document.createElement("br");

				parent_div.appendChild(div);
				parent_div.appendChild(br);
			}
		}
	}
}


//将a标签的id值以post方式上传到服务器，需要重新查询数据库
//此处也可将json对象再上传回服务器，这样服务器就不必再次在数据库中查找数据
function postwith(id) {
	var myForm = document.createElement("form");
	myForm.method = "post";
	myForm.action = "../../getBLogContent.action";
	var blog_id = id;
	var myInput = document.createElement("input");
	myInput.setAttribute("name", "blog_id");
	myInput.setAttribute("value", blog_id);
	myForm.appendChild(myInput);
	document.body.appendChild(myForm);
	myForm.submit();
	document.body.removeChild(myForm);
}