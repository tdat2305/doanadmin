<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<sp:url value="/sanpham" var="rootpath"></sp:url>
<%@taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật sản phẩm</title>
</head>
<body>
	<h1>Cập nhật sản phẩm</h1>
	<spf:form action="${rootpath}/update-sp" method="post"
		modelAttribute="sp">
		<hr>
			<a href="${rootpath}/quan-ly-san-pham">Quản lý sản phẩm</a>
		<hr>
		<span style="color:red">${msgOk}</span>
		<span style="color:red">${msgErr}</span>
		<fieldset>
			<legend>
				<h2>Cập nhật sản phẩm</h2>
			</legend>
			<table>
				<tr>
					<th>ID</th>
					<td><spf:input type="text" path="id" readonly="true" /></td>

				</tr>
				<tr>
					<th>Mã vạch</th>
					<td><spf:input type="text" path="ma_vach" /> <spf:errors
							cssClass="box-err" path="ma_vach" /></td>

				</tr>

				<tr>
					<th>Tên hàng hóa</th>
					<td><spf:input type="text" path="ten_hang_hoa" /> <spf:errors
							cssClass="box-err" path="ten_hang_hoa" /></td>
				</tr>

				<tr>
					<th>Chủng loại</th>
					<td><spf:select path="chungloai.ID">
							<spf:options items="${lstcl}" itemLabel="TEN" itemValue="ID" />
						</spf:select></td>
				</tr>

				<tr>
					<th>Đơn vị tính</th>
					<td><spf:select path="dvtinh.ID">
							<spf:options items="${lstdvt}" itemLabel="TEN_DON_VI"
								itemValue="ID" />
						</spf:select></td>
				</tr>

				<tr>
					<th>Nhà cung cấp</th>
					<td><spf:select path="nhacc.id">
							<spf:options items="${lstcc}" itemLabel="ten_nha_cc"
								itemValue="id" />
						</spf:select></td>
				</tr>

				<tr>
					<th>Số lượng</th>
					<td><spf:input type="number" step="1" path="so_luong" /></td>
				</tr>

				<tr>
					<th>Giá nhập</th>
					<td><spf:input type="number" step="1000" path="gia_nhap" /></td>
				</tr>

				<tr>
					<th>Giá xuất</th>
					<td><spf:input type="number" step="1000" path="gia_xuat" /></td>
				</tr>

				<tr>
					<th>Ngày tạo</th>
					<td><spf:input type="date" path="ngay_tao" /></td>
				</tr>

				<tr>
					<th>Ngày cập nhật</th>
					<td><spf:input type="date" path="ngay_cap_nhat" /></td>
				</tr>

				<tr>
					<th>Ghi chú</th>
					<td><spf:input type="text" path="ghi_chu" /></td>
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