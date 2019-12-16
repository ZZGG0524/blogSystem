<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>欢迎登录Blog_System</title>
        <link type="text/css" rel="stylesheet" href="../../css/login.css">
		<script type="text/javascript">
   	 		function regist() {
      		window.location.href='regist.jsp';
    	}
		</script>
</head>
	<body>
	<div class="block">
		<div class="login_block">
			<p id="#login_logo"><img src="../../image/logo.png" width="70px" height="48.3px"></p>
			<form action="/Blog_System/Login_verify" method="POST">
			<span id="msg" style="margin-left: 18%;color: red"></span>
				<p id="#user_logo"><img src="../../image/img/register/user.png" alt="username" width="30px" height="30px">
				<label class="lable_input">账号：</label>
					<input type="text" name="user_name" id="username" class="text_input" placeholder="请输入您的账号" required><br/></p>
				<p id="#pwd_logo"><img src="../../image/img/register/pwd.png" alt="password" width="30px" height="30px">
				<label class="lable_input">密码：</label>
					<input type="password" name="user_password" id="password" class="text_input" placeholder="请输入您的密码" required><br/></p>
				<div id="login_control">
					<input type="submit" value="登录" id="submit">
					<input type="button" value="注册"  onclick="regist()"/>
					<a href="mail_login.jsp" id="mail_login">邮箱登录</a><br>
					<a href="forget_pwd.jsp" id="forget_pwd">忘记密码</a>
				</div>
			</form>
		</div>
	</div>
	</body>
</html>