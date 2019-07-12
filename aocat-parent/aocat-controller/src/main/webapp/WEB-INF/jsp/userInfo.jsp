<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-expand-lg navbar-light bg-light static-top">
				 
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="navbar-toggler-icon"></span>
				</button> <a class="navbar-brand" href="toGoods">首页</a>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="navbar-nav">
						<li class="nav-item active">
							 <a class="nav-link" href="#">Link <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item">
							 <a class="nav-link" href="#">Link</a>
						</li>
						<li class="nav-item dropdown">
							 <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">Dropdown link</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
								 <a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> <a class="dropdown-item" href="#">Something else here</a>
								<div class="dropdown-divider">
								</div> <a class="dropdown-item" href="#">Separated link</a>
							</div>
						</li>
					</ul>
					<form class="form-inline">
						<input class="form-control mr-sm-2" type="text" /> 
						<button class="btn btn-primary my-2 my-sm-0" type="submit">
							Search
						</button>
					</form>
					<ul class="navbar-nav ml-md-auto">
						<li class="nav-item active">
							 <a class="nav-link" href="#">Link <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item dropdown">
							 <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">Dropdown link</a>
							<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
								 <a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> <a class="dropdown-item" href="#">Something else here</a>
								<div class="dropdown-divider">
								</div> <a class="dropdown-item" href="#">Separated link</a>
							</div>
						</li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 offset-md-4">
			<form role="form" action="updateUserInfo">
				<div class="form-group">
					 
					<label for="userid">
					</label>
					<input type="hidden" class="form-control" id="userId"  name="id" value="${id }"/>
				</div>
				<div class="form-group">
					 
					<label for="username">
						用户名：
					</label>
					<input type="text" class="form-control" id="userName" name="name" value="${name }"/>
					
				</div>
				<div class="form-group">
					<label for="useraddress">
						用户地址：
					</label>
					<input type="text" class="form-control" id="userAddress" name="address" value="${address }"/>
				</div>
				<div class="form-group">
					<label for="userphone">
						用户电话：
					</label>
					<input type="text" class="form-control" id="userPhone" name="phone" value="${phone }"/>
				</div>
				<button type="submit" class="btn btn-primary">
					更改
				</button>
			</form>
		</div>
		<div class="col-md-6">
		</div>
	</div>
</div>

<script src="../static/jquery/jquery-3.4.1.min.js"></script>
<script src="../static/popper/popper.min.js"></script>
<script src="../static/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>