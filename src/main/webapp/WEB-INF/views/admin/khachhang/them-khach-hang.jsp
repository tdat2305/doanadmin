<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<sp:url value="/khachhang" var="rootpath"></sp:url>
<sp:url value="/" var="root"></sp:url>
<%@taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới khách hàng</title>
<style type="text/css">
	.box-err{
		color: red;
		font-weight: bold;
	}
</style>
</head>
<body>
	<h1>Thêm mới khách hàng</h1>
	<hr>
	<a href="${rootpath}/quan-ly-khach-hang">Quản lý khách hàng</a>
	<hr>
	<spf:form action="${rootpath}/view-kh" method="post"
		modelAttribute="kh">
		<fieldset>
			<legend><h2>Thêm mới khách hàng</h2></legend>
			<table>
				<tr>
					<th>Họ: </th>
					<td>
					<spf:input path="ho" type="text" />
					<spf:errors cssClass="box-err" path="ho" />
					</td>
				</tr>

				<tr>
					<th>Tên: </th>
					<td>
					<spf:input path="ten" type="text" />
					<spf:errors cssClass="box-err" path="ten" />
					</td>
				</tr>

				<tr>
					<th>Giới tính: </th>
					<td>
						<spf:radiobutton path="gioi_tinh" value="1" />Nam
						<spf:radiobutton path="gioi_tinh" value="2" />Nữ
					</td>
				</tr>

				<tr>
					<th>Ngày sinh:</th>
					<td><spf:input path="ngay_sinh" type="date" /></td>
				</tr>

				<tr>
					<th>SDT:</th>
					<td>
					<spf:input path="sdt" type="text" />
					<spf:errors cssClass="box-err" path="sdt" />
					</td>
				</tr>

				<tr>
					<th>Địa chỉ:</th>
					<td><spf:input path="dia_chi" type="text" /></td>
				</tr>

				<tr>
					<th>Email:</th>
					<td>
					<spf:input path="email" type="email" />
					<spf:errors cssClass="box-err" path="email" />
					</td>
				</tr>

				<tr>
					<th>Ngày tạo:</th>
					<td><spf:input path="ngay_tao" type="date" /></td>
				</tr>

				<tr>
					<th>Ngày cập nhật:</th>
					<td><spf:input path="ngay_cap_nhat" type="date" /></td>
				</tr>

				<tr>
					<th>Trạng thái:</th>
					<td><spf:checkbox value="1" path="trang_thai" /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="Thêm mới"></td>
				</tr>
				
			</table>
		</fieldset>
	</spf:form>
</body>
</html>