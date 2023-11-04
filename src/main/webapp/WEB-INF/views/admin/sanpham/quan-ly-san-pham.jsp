<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<sp:url value="/sanpham" var="rootpath"></sp:url>
<sp:url value="/" var="root"></sp:url>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý sản phẩm</title>
<script type="text/javascript">
	function delSP(name, id){
// 		${root}sanpham/delete-sp/${sp.id}
	let isDel = confirm("Bạn có chắc chắn muốn xóa [" + name + "] có id là: [" + id + "]")
	if (isDel) {
		window.location = "${root}sanpham/delete-sp/" + id;
	}
		}
</script>
</head>
<body>
	<h1>Quản lý sản phẩm</h1>
	<span style="color:red"">${msgTrue}</span>
	<span style="color:red">${msgFalse}</span>
	<hr>
	<a href="${root}admin">Trang chủ</a> ||
	<a href="${rootpath}/them-sp">Thêm sản phẩm</a>
	<hr>
	<form action="${rootpath}/search" method="post">
		<input type="text" placeholder="Tìm kiếm ..." name="txtSearch"/>
		<input type="submit" value="Tìm kiếm"/>  
		
	</form>
	<hr>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Mã vạch</th>
			<th>Tên hàng hóa</th>
			<th>Chủng loại</th>
			<th>Đơn vị tính</th>
			<th>Nhà cung cấp</th>
			<th>Số lượng</th>
			<th>Giá nhập</th>
			<th>Giá xuất</th>
			<th>Ngày tạo</th>
			<th>Ngày cập nhật</th>
			<th>Ghi chú</th>
			<th>Cập nhật</th>
			<th>Xóa</th>
		</tr>
		<c:forEach items="${lstsp}" var="sp">
			<tr>
				<td>${sp.id}</td>
				<td>${sp.ma_vach}</td>
				<td>${sp.ten_hang_hoa}</td>
				<td>${sp.chungloai.TEN}</td>
				<td>${sp.dvtinh.TEN_DON_VI}</td>
				<td>${sp.nhacc.ten_nha_cc}</td>
				<td>${sp.so_luong}</td>
				<td><fmt:formatNumber value="${sp.gia_nhap}" type="currency" /></td>
				<td><fmt:formatNumber value="${sp.gia_xuat}" type="currency" /></td>
				<td>${sp.ngay_tao}</td>
				<td>${sp.ngay_cap_nhat}</td>
				<td>${sp.ghi_chu}</td>
				<td>
					<a href="${root}sanpham/update-sp/${sp.id}">
						<img alt="Update" src="${root}resource/img/update.png">	
					</a>			
				</td>
				<td>
						<img alt="Delete" src="${root}resource/img/delete.png" onclick="delSP('${sp.ten_hang_hoa}', ${sp.id})">				
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>