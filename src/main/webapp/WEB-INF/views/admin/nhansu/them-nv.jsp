<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="sp" uri="http://www.springframework.org/tags" %>
    <sp:url value="/nhansu" var="rootpath"></sp:url>
    <sp:url value="/" var="root"></sp:url>
    <%@taglib prefix="spf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới nhân viên</title>
<style type="text/css">
	.box-err{
		color: red;
		font-weight: bold;
	}
</style>
</head>
<body>
	<h1>Thêm mới nhân viên</h1>
	<hr>
	<a href="${rootpath}/quan-ly-nhan-su">Quản lý nhân viên</a>
	<hr>
	<spf:form action="${rootpath}/view-ns" method="post" modelAttribute="ns">
		<fieldset>
			<legend><h2>Thêm nhân viên</h2></legend>
			<table>
				<tr>
					<th>Họ và tên</th>
					<td>
					<spf:input type="text" path="ho_va_ten"/>
					<spf:errors cssClass="box-err" path="ho_va_ten" />
					</td>
				</tr>
				
				<tr>
					<th>Giới tính</th>
					<td>
						<spf:radiobutton path="gioi_tinh" value="1" />Nam
						<spf:radiobutton path="gioi_tinh" value="2"/>Nữ
					</td>
				</tr>
				
				<tr>
					<th>Ngày sinh</th>
					<td>
					<spf:input type="date" path="ngay_sinh"/>
					</td>
				</tr>
				
				<tr>
					<th>Ngày vào làm</th>
					<td><spf:input type="date" path="ngay_vao_lam"/></td>
				</tr>
				
				<tr>
					<th>Ngày cập nhật</th>
					<td><spf:input type="date" path="ngay_cap_nhat"/></td>
				</tr>
				
				<tr>
					<th>SDT</th>
					<td>
					<spf:input type="text" path="sdt"/>
					<spf:errors cssClass="box-err" path="sdt" />
					</td>
				</tr>
				
				<tr>
					<th>SDT gia đình</th>
					<td><spf:input type="text" path="sdt_gd"/></td>
				</tr>
				
				<tr>
					<th>Email</th>
					<td><spf:input type="email" path="email"/></td>
				</tr>
				
				<tr>
					<th>Địa chỉ</th>
					<td><spf:input type="text" path="dia_chi"/></td>
				</tr>
				
				<tr>
					<th>Phân quyền</th>
					<td>
					<spf:select path="pq.ID">
						<spf:options items="${lstpq}" itemLabel="VI_TRI" itemValue="ID"/>
					</spf:select>
					</td>
				</tr>
				
				<tr>
					<th>Lương cơ bản</th>
					<td><spf:input type="number" step="1000" path="luong_co_ban"/></td>
				</tr>
				
				<tr>
					<th>Tên đăng nhập</th>
					<td><spf:input type="text" path="username"/></td>
				</tr>
				
				<tr>
					<th>Mật khẩu</th>
					<td><spf:input type="password" path="password"/></td>
				</tr>
				
				<tr>
					<th>Ghi chú</th>
					<td><spf:input type="text" path="ghi_chu"/></td>
				</tr>
				
				<tr>
					<th>Trạng thái</th>
					<td><spf:checkbox value="1" path="trang_thai"/></td>
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