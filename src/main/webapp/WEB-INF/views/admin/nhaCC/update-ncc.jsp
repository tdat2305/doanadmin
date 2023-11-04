<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="sp" uri="http://www.springframework.org/tags" %>
    <sp:url value="/nhaCC" var="rootpath"></sp:url>
    <%@taglib prefix="spf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật nhà cung cấp</title>
<style type="text/css">
	.box-err{
		color: red;
		font-weight: bold;
	}
</style>
</head>
<body>
	<h1>Cập nhật nhà cung cấp</h1>
	<spf:form action="${rootpath}/update-ncc" method="post" modelAttribute="cc">
	<hr>
			<a href="${rootpath}/quan-ly-nha-cc">Quản lý sản phẩm</a>
		<hr>
		<span style="color:red">${msgOk}</span>
		<span style="color:red">${msgErr}</span>
		<fieldset>
			<legend><h2>Cập nhật nhà cung cấp</h2></legend>
			<table>
				<tr>
					<th>ID</th>
					<td><spf:input type="text" path="id" readonly="true"/>
					</td>
				</tr>
				<tr>
					<th>Tên nhà cung cấp</th>
					<td><spf:input type="text" path="ten_nha_cc"/>
						<spf:errors cssClass="box-err" path="ten_nha_cc" />
					</td>
				</tr>
				<tr>
					<th>Địa chỉ</th>
					<td><spf:input type="text" path="dia_chi"/>
						<spf:errors cssClass="box-err" path="dia_chi" />
					</td>
				</tr>
				<tr>
					<th>SDT1</th>
					<td><spf:input type="text" path="sdt1"/>
						<spf:errors cssClass="box-err" path="sdt1" />
					</td>
				</tr>
				<tr>
					<th>SDT2</th>
					<td><spf:input type="text" path="sdt2"/></td>
				</tr>
				<tr>
					<th>Fax</th>
					<td><spf:input type="text" path="fax"/></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><spf:input type="email" path="email"/></td>
				</tr>
				<tr>
					<th>Website</th>
					<td><spf:input type="text" path="website"/>
						<spf:errors cssClass="box-err" path="website" />
					</td>
				</tr>
				<tr>
					<th>Ngày tạo</th>
					<td><spf:input type="date" path="ngay_tao"/></td>
				</tr>
				<tr>
					<th>Ngày cập nhật</th>
					<td><spf:input type="date" path="ngay_cap_nhat"/></td>
				</tr>
				<tr>
					<th>Taxcode</th>
					<td><spf:input type="text" path="taxcode"/></td>
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
					<td><input type="submit" value="Cập nhật"></td>
				</tr>
			</table>
		</fieldset>
	</spf:form>
</body>
</html>