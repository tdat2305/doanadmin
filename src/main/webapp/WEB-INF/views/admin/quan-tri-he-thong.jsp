<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="sp" uri="http://www.springframework.org/tags" %>
    <sp:url value="/" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản trị hệ thống</title>
</head>
<style>
*{
	margin: 0;
	padding: 0;
}
.header{
	width: 100%;
	height: 80px;
	background-color: red;
	position: relative;
}
.header-text{
	display: inline-block;
}
.header-text p{
	font-size: 32px;
	color: white;
	line-height: 80px;
	margin-left: 150px;
	font-weight: bold;
}
.header-search{
	float: right;
	line-height: 80px;
	margin-right: 150px;
}
</style>
<body>
	<div class = "header">
		<div class = "header-text">
			<p>Hệ thống quản lý</p>
		</div>
		<div class="header-search">
			<input type="text" placeholder="Tìm kiếm..."/> 
			<input type="submit" value="Tìm kiếm">
		</div>
	</div>
	<a href="${rootpath}nhansu/quan-ly-nhan-su">Quản lý nhân sự</a> ||
	<a href="${rootpath}sanpham/quan-ly-san-pham">Quản lý sản phẩm</a> ||
	<a href="${rootpath}nhaCC/quan-ly-nha-cc">Quản lý nhà cung cấp</a> ||
	<a href="${rootpath}khachhang/quan-ly-khach-hang">Quản lý khách hàng</a>
</body>
</html>