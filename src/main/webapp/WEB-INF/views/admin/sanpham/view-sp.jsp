<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<sp:url value="/sanpham" var="rootpath"></sp:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin hàng hóa</title>
</head>
<body>
	<b style="color: red; font-size: 25px; font-weight: bold;">${msg}</b>
	<h1>Thông tin hàng hóa</h1>
	<hr>
	<a href="${rootpath}/quan-ly-san-pham">Quản lý hàng hóa</a>||
	<a href="${rootpath}/them-sp">Thêm hàng hóa</a>
	<hr>
	<fieldset>
		<legend>
			<h2>Thông tin sản phẩm</h2>
		</legend>
		<table>
			<tr>
				<th>Mã vạch</th>
				<td>${sp.ma_vach}</td>
			</tr>
			<tr>
				<th>Tên hàng hóa</th>
				<td>${sp.ten_hang_hoa}</td>
			</tr>
			<tr>
				<th>Chủng loại</th>
				<td>${sp.id_chung_loai}</td>
			</tr>
			<tr>
				<th>Đơn vị tính</th>
				<td>${sp.id_dv_tinh}</td>
			</tr>
			<tr>
				<th>Nhà cung cấp</th>
				<td>${sp.id_nha_cc}</td>
			</tr>
			<tr>
				<th>Số lượng</th>
				<td>${sp.so_luong}</td>
			</tr>
			<tr>
				<th>Giá nhập</th>
				<td>${sp.gia_nhap}</td>
			</tr>
			<tr>
				<th>Giá xuất</th>
				<td>${sp.gia_xuat}</td>
			</tr>
			<tr>
				<th>Ngày tạo</th>
				<td>${sp.ngay_tao}</td>
			</tr>
			<tr>
				<th>Ngày cập nhật</th>
				<td>${sp.ngay_cap_nhat}</td>
			</tr>
			<tr>
				<th>Ghi chú</th>
				<td>${sp.ghi_chu}</td>
			</tr>
		</table>
	</fieldset>
</body>
</html>