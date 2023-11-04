<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<sp:url value="/khachhang" var="rootpath"></sp:url>
<sp:url value="/" var="root"></sp:url>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý khách hàng</title>
<script type="text/javascript">
	function delKH(name, id){
	let isDel = confirm("Bạn có chắc chắn muốn xóa [" + name + "] có id là: [" + id + "]")
	if (isDel) {
		window.location = "${root}khachhang/delete-kh/" + id;
	}
		}
</script>
</head>
<body>
	<h1>Quản lý khách hàng</h1>
	<span style="color:red"">${msgTrue}</span>
	<span style="color:red">${msgFalse}</span>
	<hr>
	<a href="${root}admin">Trang chủ</a> ||
	<a href="${rootpath}/them-khach-hang">Thêm khách hàng</a>
	<hr>
	<form action="${rootpath}/search" method="post">
		<input type="text" placeholder="Tìm kiếm ..." name="txtSearch"/>
		<input type="submit" value="Tìm kiếm"/>  
		
	</form>
	<hr>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Họ</th>
			<th>Tên</th>
			<th>Giới tính</th>
			<th>Ngày sinh</th>
			<th>SDT</th>
			<th>Địa chỉ</th>
			<th>Email</th>
			<th>Ngày tạo</th>
			<th>Ngày cập nhật</th>
			<th>Trạng thái</th>
			<th>Cập nhật</th>
			<th>Xóa</th>
		</tr>
		<c:forEach items="${lstkh}" var="kh">
			<tr>
				<td>${kh.id}</td>
				<td>${kh.ho}</td>
				<td>${kh.ten}</td>
				<td>${kh.gioi_tinh == 1? "Nam" : "Nữ"}</td>
				<td><fmt:formatDate value="${kh.ngay_sinh}" type="DATE"
						dateStyle="SHORT" /></td>
				<td>${kh.sdt}</td>
				<td>${kh.dia_chi}</td>
				<td>${kh.email}</td>
				<td>${kh.ngay_tao}</td>
				<td>${kh.ngay_cap_nhat}</td>
				<td>${kh.trang_thai == 1? "Hoạt động" : "Nghỉ"}</td>
				<td>
					<a href="${rootpath}/update-kh/${kh.id}">
						<img alt="Update" src="${root}resource/img/update.png">
					</a>
				</td>
				<td>
					<img alt="Delete" src="${root}resource/img/delete.png" onclick="delKH('${kh.ten}', ${kh.id})">	
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>