package com.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.ChungLoai;
import com.entity.DonViTinh;
import com.entity.KhachHang;
import com.entity.NhaCC;
import com.entity.NhanSu;
import com.entity.SanPham;
import com.hibernate.IChungLoaiHibernate;
import com.hibernate.IDonViTinhHibernate;
import com.hibernate.IKhachHangHibernate;
import com.hibernate.INhaCCHibernate;
import com.hibernate.ISanPhamHibernate;
import com.hibernate.ImplChungLoaiHibernate;
import com.hibernate.ImplDonViTinhHibernate;
import com.hibernate.ImplKhachHangHibernate;
import com.hibernate.ImplNhaCCHibernate;
import com.hibernate.ImplSanPhamHibernate;

@Controller
@RequestMapping("/khachhang")
public class ControllerKhachHang {
	@RequestMapping(value = "/them-khach-hang", method = RequestMethod.GET)
	public String themKH(Model m) {
		KhachHang kh = new KhachHang();
		kh.setGioi_tinh((short) 1);
		kh.setNgay_cap_nhat(LocalDate.now());
		kh.setNgay_tao(LocalDate.now());

		m.addAttribute("kh", kh);
		return "admin/khachhang/them-khach-hang";
	}

	@RequestMapping(value = "/view-kh", method = RequestMethod.POST)
	public String ViewKH(@Valid @ModelAttribute(value = "kh") KhachHang khh, BindingResult result, Model m) {
		IKhachHangHibernate khHbn = new ImplKhachHangHibernate();
		List<KhachHang> lstkh = khHbn.selectAll();
		boolean isOk = khHbn.insert(khh);
		if (isOk) {
			m.addAttribute("msgOk", "Thêm mới thành công");
		} else {
			m.addAttribute("msgErr", "Thêm mới thất bại");
		}

		m.addAttribute("kh", khh);
		if (result.hasErrors()) {
			System.out.println("Lỗi");
			return "admin/khachhang/them-khach-hang";
		} else {
			m.addAttribute("msg", "Thêm mới thành công");
			return "admin/khachhang/view-kh";
		}

	}

	@RequestMapping(value = "/quan-ly-khach-hang")
	public String QLKH(Model m) {
		IKhachHangHibernate khHbn = new ImplKhachHangHibernate();
		List<KhachHang> lstkh = khHbn.selectAll();
		System.out.println("SỐ lượng kh là: " + lstkh.size());

		m.addAttribute("lstkh", lstkh);
		return "admin/khachhang/quan-ly-khach-hang";
	}

	@RequestMapping("/quan-tri-he-thong")
	public String TrangChu() {

		return "admin/quan-tri-he-thong";
	}

	@RequestMapping(value = "/update-kh/{id}", method = RequestMethod.GET)
	public String UpdateKH(@PathVariable(value = "id", required = true) Integer id, Model m) {
		IKhachHangHibernate khHbn = new ImplKhachHangHibernate();
		KhachHang kh = khHbn.selectById(id);

		m.addAttribute("kh", kh);
		return "admin/khachhang/update-kh";
	}
	@RequestMapping(value = "/update-kh", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "kh") KhachHang khh, Model m) {
		IKhachHangHibernate khHbn = new ImplKhachHangHibernate();
		
		boolean isOk = khHbn.update(khh);
		if (isOk) {
			m.addAttribute("msgOk", "Cập nhật thành công !!!");
		} else {
			m.addAttribute("msgErr", "Cập nhật thất bại !!!");
		}
		
		return "admin/khachhang/update-kh";
	}

	@RequestMapping(value = "/delete-kh/{id}")
	public String DelKH(@PathVariable(value = "id") Integer id, Model m) {
		IKhachHangHibernate khHbn = new ImplKhachHangHibernate();
		boolean isOk = khHbn.delete(id);
		if (isOk) {
			m.addAttribute("msgTrue", "Xóa thành công !!!");
		} else {
			m.addAttribute("msgFalse", "Xóa thất bại !!!");
		}

		List<KhachHang> lstkh = khHbn.selectAll();

		m.addAttribute("lstkh", lstkh);
		return "admin/khachhang/quan-ly-khach-hang";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String Search(@RequestParam(value = "txtSearch", required = true) String search, Model m) {
		
		IKhachHangHibernate khHbn = new ImplKhachHangHibernate();
		List<KhachHang> lstkh = khHbn.search(search);

		m.addAttribute("lstkh", lstkh);
		
		return "admin/khachhang/quan-ly-khach-hang";
	}
}
