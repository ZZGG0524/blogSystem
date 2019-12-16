var comment_xhr = null;

function comment_init() {
	comment_xhr = GetXMlHttpRequest();
	if(comment_xhr) {
		comment_xhr.onreadystatechange = comment_response;
		comment_xhr.open('get','getComment.action',true);
		comment_xhr.send(null);
	}else {
		alert("你的浏览器不支持AJAX，推荐使用firefoxs或者chrome浏览器");
	}
}

function comment_response() {
	// if(comment_xhr.readyState <= 3) {
	// 	document.getElementById("usercomment").innerHTML = "loading...";
	// }
	if(comment_xhr.readyState == 4) {
		if(comment_xhr.status == 200) {
			document.getElementById("usercomment").innerHTML = "";
			var comment = comment_xhr.responseText;
			var json_comment = JSON.parse(comment);

			var parent_div = document.getElementById("usercomment");
			for(var i = 0; i < json_comment.length; i++) {
				var div = document.createElement("div");
				var cpdiv = document.createElement("div");

				div.setAttribute("id", json_comment[i].comment_id);

				var username_div = document.createElement("a");
				var username = document.createTextNode("匿名用户：");
				username_div.appendChild(username);
				username_div.className="gitment-comment-name";
				username_div.setAttribute("href","#");				
				
				var comment_time_div = document.createElement("span");
				var comment_time = document.createTextNode("评论时间:"+json_comment[i].comment_time);
				comment_time_div.appendChild(comment_time);

				cpdiv.appendChild(username_div);
				cpdiv.appendChild(comment_time_div);
				cpdiv.className="gitment-comment-header";


				var comment_content_div = document.createElement("div");
				var comment_content = document.createTextNode("评论内容:"+json_comment[i].comment_content);
				comment_content_div.appendChild(comment_content);
				comment_content_div.className="gitment-comment-body gitment-markdown";

				div.appendChild(cpdiv);
				div.appendChild(comment_content_div);

				parent_div.appendChild(div);
			}
		}
	}
}