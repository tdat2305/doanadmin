<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<sp:url value="/nhaCC" var="rootpath"></sp:url>
<sp:url value="/" var="root"></sp:url>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý nhà cung cấp</title>
<script type="text/javascript">
	function delNCC(name, id){
// 		${root}sanpham/delete-sp/${sp.id}
	let isDel = confirm("Bạn có chắc chắn muốn xóa [" + name + "] có id là: [" + id + "]")
	if (isDel) {
		window.location = "${root}nhaCC/delete-ncc/" + id;
	}
		}
</script>
</head>
<body>
	<h1>Quản lý nhà cung cấp</h1>
	<span style="color:red"">${msgTrue}</span>
	<span style="color:red">${msgFalse}</span>
	<hr>
	<a href="${root}admin">Trang chủ</a> ||
	<a href="${rootpath}/them-nhaCC">Thêm nhà cung cấp</a>
	<hr>
	<form action="${rootpath}/search" method="post">
		<input type="text" placeholder="Tìm kiếm ..." name="txtSearch"/>
		<input type="submit" value="Tìm kiếm"/>  
		
	</form>
	<hr>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Tên nhà cung cấp</th>
			<th>Địa chỉ</th>
			<th>SDT1</th>
			<th>SDT2</th>
			<th>Fax</th>
			<th>Email</th>
			<th>Website</th>
			<th>Ngày tạo</th>
			<th>Ngày cập nhật</th>
			<th>Taxcode</th>
			<th>Ghi chú</th>
			<th>Trạng thái</th>
			<th>Cập nhật</th>
			<th>Xóa</th>
		</tr>
		<c:forEach items="${lstcc}" var="cc">
			<tr>
				<td>${cc.id}</td>
				<td>${cc.ten_nha_cc}</td>
				<td>${cc.dia_chi}</td>
				<td>${cc.sdt1}</td>
				<td>${cc.sdt2}</td>
				<td>${cc.fax}</td>
				<td>${cc.email}</td>
				<td>${cc.website}</td>
				<td>${cc.ngay_tao}</td>
				<td>${cc.ngay_cap_nhat}</td>
				<td>${cc.taxcode}</td>
				<td>${cc.ghi_chu}</td>
				<td>${cc.trang_thai== 1? "Hoạt động" : "Nghỉ"}</td>
				<td>
					<a href="${rootpath}/update-ncc/${cc.id}">
						<img alt="Update" src="${root}resource/img/update.png">
					</a>
				</td>
				<td>
					<img alt="Delete" src="${root}resource/img/delete.png" onclick="delNCC('${cc.ten_nha_cc}', ${cc.id})">	
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>