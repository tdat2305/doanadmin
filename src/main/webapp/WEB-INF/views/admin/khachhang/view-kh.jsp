<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<sp:url value="/khachhang" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin khách hàng</title>
</head>
<body>
	<b style="color: red; font-size: 25px; font-weight: bold;">${msg}</b>
	<h1>Thông tin khách hàng</h1>
	<hr>
	<a href="${rootpath}/quan-ly-khach-hang">Quản lý khách hàng</a> ||
	<a href="${rootpath}/them-khach-hang">Thêm khách hàng</a> 
	<hr>
	<fieldset>
		<legend>
			<h2>Thông tin nhà cung cấp</h2>
		</legend>
		<table>
			<tr>
				<th>Họ</th>
				<td>${kh.ho}</td>
			</tr>
			<tr>
				<th>Tên</th>
				<td>${kh.ten}</td>
			</tr>
			<tr>
				<th>Giới tính</th>
				<td>${kh.gioi_tinh}</td>
			</tr>
			<tr>
				<th>Ngày sinh</th>
				<td>${kh.ngay_sinh}</td>
			</tr>
			<tr>
				<th>SDT</th>
				<td>${kh.sdt}</td>
			</tr>
			<tr>
				<th>Địa chỉ</th>
				<td>${kh.dia_chi}</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${kh.email}</td>
			</tr>
			<tr>
				<th>Ngày tạo</th>
				<td>${kh.ngay_tao}</td>
			</tr>
			<tr>
				<th>Ngày cập nhật</th>
				<td>${kh.ngay_cap_nhat}</td>
			</tr>
			<tr>
				<th>Trạng thái</th>
				<td>${kh.trang_thai}</td>
			</tr>
		</table>
	</fieldset>
</body>
</html>