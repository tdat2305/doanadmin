<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<sp:url value="/nhaCC" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin nhà cung cấp</title>
</head>
<body>
	<b style="color: red; font-size: 25px; font-weight: bold;">${msg}</b>
	<h1>Thông tin nhà cung cấp</h1>
	<hr>
	<a href="${rootpath}/quan-ly-nha-cc">Quản lý nhà cung cấp</a> ||
	<a href="${rootpath}/them-nhaCC">Thêm nhà cung cấp</a>
	<hr>
	<fieldset>
		<legend>
			<h2>Thông tin nhà cung cấp</h2>
		</legend>
		<table>
			<tr>
				<th>Tên nhà cung cấp</th>
				<td>${cc.ten_nha_cc}</td>
			</tr>
			<tr>
				<th>Địa chỉ</th>
				<td>${cc.dia_chi}</td>
			</tr>
			<tr>
				<th>SDT1</th>
				<td>${cc.sdt1}</td>
			</tr>
			<tr>
				<th>SDT2</th>
				<td>${cc.sdt2}</td>
			</tr>
			<tr>
				<th>Fax</th>
				<td>${cc.fax}</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${cc.email}</td>
			</tr>
			<tr>
				<th>Website</th>
				<td>${cc.website}</td>
			</tr>
			<tr>
				<th>Ngày tạo</th>
				<td>${cc.ngay_tao}</td>
			</tr>
			<tr>
				<th>Ngày cập nhật</th>
				<td>${cc.ngay_cap_nhat}</td>
			</tr>
			<tr>
				<th>Taxcode</th>
				<td>${cc.taxcode}</td>
			</tr>
			<tr>
				<th>Ghi chú</th>
				<td>${cc.ghi_chu}</td>
			</tr>
			<tr>
				<th>Trạng thái</th>
				<td>${cc.trang_thai}</td>
			</tr>
		</table>
	</fieldset>
</body>
</html>