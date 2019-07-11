<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>商品列表</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">

					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="navbar-toggler-icon"></span>
					</button>
					<a class="navbar-brand" href="#">Brand</a>
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="navbar-nav">
							<li class="nav-item active"><a class="nav-link" href="#">Link <span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
							<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">Dropdown link</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
									<a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> <a class="dropdown-item" href="#">Something else here</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="#">Separated link</a>
								</div></li>
						</ul>
						<form class="form-inline">
							<input class="form-control mr-sm-2" type="text" />
							<button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
						</form>
						<ul class="navbar-nav ml-md-auto">
							<li class="nav-item active"><a class="nav-link" href="#">Link <span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">Dropdown link</a>
								<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
									<a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> <a class="dropdown-item" href="#">Something else here</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="#">Separated link</a>
								</div></li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-sm table-hover table-bordered">
					<thead>
						<tr>
							<th>#</th>
							<th>名字</th>
							<th>价格</th>
							<th>数量</th>
							<th>图片</th>
							<th>类型</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list.list }" var="goods">
							<tr>
								<td>${goods.id }</td>
								<td>${goods.name }</td>
								<td>${goods.price }</td>
								<td>${goods.num }</td>
								<td><img alt="" src=""></td>
								<td>${goods.type }</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="6">
								<nav aria-label="...">
									<ul  class="pagination">
										<c:choose>
											<c:when test="${list.isFirstPage }">
												<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a></li>
											</c:when>
											<c:otherwise>
												<li class="page-item"><a class="page-link" href="goods?pageNum=${list.pageNum-1}" tabindex="-1" aria-disabled="true">Previous</a></li>
											</c:otherwise>
										</c:choose>
										<c:forEach begin="1" end="${list.pages}" var="i">
											<c:choose>
												<c:when test="${list.pageNum==i }">
													<li class="page-item active" aria-current="page"><a class="page-link" href="goods?pageNum=${i}">${i} <span class="sr-only">(current)</span></a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link" href="goods?pageNum=${i}">${i }</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<c:choose>
											<c:when test="${list.isLastPage }">
												<li class="page-item  disabled"><a class="page-link" href="#">Next</a></li>
											</c:when>
											<c:otherwise>
												<li class="page-item "><a class="page-link" href="goods?pageNum=${list.pageNum+1}">Next</a></li>
											</c:otherwise>
										</c:choose>
									</ul>
								</nav>

							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<dl>
					<dt>Description lists</dt>
					<dd>A description list is perfect for defining terms.</dd>
					<dt>Euismod</dt>
					<dd>Vestibulum id ligula porta felis euismod semper eget lacinia odio sem nec elit.</dd>
					<dd>Donec id elit non mi porta gravida at eget metus.</dd>
					<dt>Malesuada porta</dt>
					<dd>Etiam porta sem malesuada magna mollis euismod.</dd>
					<dt>Felis euismod semper eget lacinia</dt>
					<dd>Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</dd>
				</dl>
			</div>
		</div>
	</div>
	<script src="static/jquery/jquery-3.4.1.min.js"></script>
	<script src="static/popper/popper.min.js"></script>
	<script src="static/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>