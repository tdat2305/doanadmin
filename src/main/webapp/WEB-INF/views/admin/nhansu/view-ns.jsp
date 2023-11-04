<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<sp:url value="/nhansu" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin nhân viên</title>
</head>
<body>
	<b style="color: red; font-size: 25px; font-weight: bold;">${msg}</b>
	<h1>Thông tin nhân viên</h1>
	<hr>
	<a href="${rootpath}/quan-ly-nhan-su">Quản lý nhân sự</a>||
	<a href="${rootpath}/them-nv">Thêm nhân viên</a>
	<hr>
	<fieldset>
		<legend>
			<h2>Thông tin nhân viên</h2>
		</legend>
		<table>
			<tr>
				<th>Họ và tên</th>
				<td>${ns.ho_va_ten}</td>
			</tr>
			<tr>
				<th>Giới tính</th>
				<td>${ns.gioi_tinh}</td>
			</tr>
			<tr>
				<th>Ngày sinh</th>
				<td>${ns.ngay_sinh}</td>
			</tr>
			<tr>
				<th>Ngày vào làm</th>
				<td>${ns.ngay_vao_lam}</td>
			</tr>
			<tr>
				<th>Ngày cập nhật</th>
				<td>${ns.ngay_cap_nhat}</td>
			</tr>
			<tr>
				<th>SDT</th>
				<td>${ns.sdt}</td>
			</tr>
			<tr>
				<th>SDT gia đình</th>
				<td>${ns.sdt_gd}</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${ns.email}</td>
			</tr>
			<tr>
				<th>Địa chỉ</th>
				<td>${ns.dia_chi}</td>
			</tr>
			<tr>
				<th>ID phân quyền</th>
				<td>${ns.id_phan_quyen}</td>
			</tr>
			<tr>
				<th>Lương cơ bản</th>
				<td>${ns.luong_co_ban}</td>
			</tr>
			<tr>
				<th>Tên đăng nhập</th>
				<td>${ns.username}</td>
			</tr>
			<tr>
				<th>Mật khẩu</th>
				<td>${ns.password}</td>
			</tr>
			<tr>
				<th>Ghi chú</th>
				<td>${ns.ghi_chu}</td>
			</tr>
			<tr>
				<th>Trạng thái</th>
				<td>${ns.trang_thai}</td>
			</tr>

		</table>
	</fieldset>
</body>
</html>