<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<sp:url value="/nhansu" var="rootpath"></sp:url>
<sp:url value="/" var="root"></sp:url>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý nhân sự</title>
<script type="text/javascript">
	function delNS(name, id){
	let isDel = confirm("Bạn có chắc chắn muốn xóa [" + name + "] có id là: [" + id + "]")
	if (isDel) {
		window.location = "${root}nhansu/delete-ns/" + id;
	}
		}
</script>
</head>
<body>
	<h1>Quản lý nhân sự</h1>
	<hr>
	<a href="${root}admin">Trang chủ</a> ||
	<a href="${rootpath}/them-nv">Thêm nhân viên</a>
	<hr>
	<form action="${rootpath}/search" method="post">
		<input type="text" placeholder="Tìm kiếm ..." name="txtSearch"/>
		<input type="submit" value="Tìm kiếm"/>  
		
	</form>
	<hr>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Họ và tên</th>
			<th>Giới tính</th>
			<th>Ngày sinh</th>
			<th>Ngày vào làm</th>
			<th>Ngày cập nhật</th>
			<th>SDT</th>
			<th>SDT gia đình</th>
			<th>Email</th>
			<th>Địa chỉ</th>
			<th>Phân quyền</th>
			<th>Lương cơ bản</th>
			<th>Tên đăng nhập</th>
			<th>Mật khẩu</th>
			<th>Ghi chú</th>
			<th>Trạng thái</th>
			<th>Cập nhật</th>
			<th>Xóa</th>
		</tr>
		<c:forEach items="${lstns}" var="ns">
			<tr>
				<td>${ns.id}</td>
				<td>${ns.ho_va_ten}</td>
				<td>${ns.gioi_tinh == 1? "Nam" : "Nữ"}</td>
				<td><fmt:formatDate value="${ns.ngay_sinh}" type="DATE"
						dateStyle="SHORT" /></td>
				<td>${ns.ngay_vao_lam}</td>
				<td>${ns.ngay_cap_nhat}</td>
				<td>${ns.sdt}</td>
				<td>${ns.sdt_gd}</td>
				<td>${ns.email}</td>
				<td>${ns.dia_chi}</td>
				<td>${ns.pq.VI_TRI}</td>
				<td><fmt:formatNumber value="${ns.luong_co_ban}"
						type="currency" /></td>
				<td>${ns.username}</td>
				<td>${ns.password}</td>
				<td>${ns.ghi_chu}</td>
				<td>${ns.trang_thai == 1? "Hoạt động" : "Nghỉ"}</td>
				<td align="center">
					<a href="${rootpath}/update-nv/${ns.id}">
					<img alt="Update" src="${root}resource/img/update.png">
					</a>
				</td>
				<td align="center">
					
					<img alt="Delete" src="${root}resource/img/delete.png" onclick="delNS('${ns.ho_va_ten}', ${ns.id})">		
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>