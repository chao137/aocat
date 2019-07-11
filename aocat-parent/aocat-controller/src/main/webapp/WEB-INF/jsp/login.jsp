<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>登录</title>
</head>
<body>
	<div class="container">
		<form class="form-signin" action="login" method="post">
			${msg }
			<h2 class="form-signin-heading">请登录</h2>
			<label for="inputName" class="sr-only">用户名</label> <input type="text"
				id="inputName" name="name" class="form-control" placeholder="用户名"
				required autofocus value="${name }"> <br /> <br /> <label
				for="inputPass" class="sr-only">密码</label> <input type="password"
				id="inputPass" name="pass" class="form-control" placeholder="密码"
				required> <br /> <br />
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>
	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="static/bootstrap/js/bootstrap.min.js"></script>
	<script src="static/jquery/jquery-3.4.1.min.js"></script>
</body>
</html>