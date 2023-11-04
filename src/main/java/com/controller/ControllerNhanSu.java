package com.controller;

import java.time.LocalDate;
import java.util.Date;
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

import com.entity.NhaCC;
import com.entity.NhanSu;
import com.entity.PhanQuyen;
import com.entity.SanPham;
import com.hibernate.INhaCCHibernate;
import com.hibernate.INhanSuHibernate;
import com.hibernate.IPhanQuyenHibernate;
import com.hibernate.ISanPhamHibernate;
import com.hibernate.ImplNhaCCHibernate;
import com.hibernate.ImplNhanSuHibernate;
import com.hibernate.ImplPhanQuyenHibernate;
import com.hibernate.ImplSanPhamHibernate;

@Controller
@RequestMapping("/nhansu")
public class ControllerNhanSu {
	@RequestMapping(value = "/them-nv", method = RequestMethod.GET)
	public String ThemNV(Model m) {
		IPhanQuyenHibernate pqHbn = new ImplPhanQuyenHibernate();
		List<PhanQuyen> lstpq = pqHbn.selectAll();

		NhanSu ns = new NhanSu();
		ns.setGioi_tinh((short) 1);
		ns.setNgay_cap_nhat(LocalDate.now());
		ns.setNgay_vao_lam(LocalDate.now());

		m.addAttribute("ns", ns);
		m.addAttribute("lstpq", lstpq);
		return "admin/nhansu/them-nv";
	}

	@RequestMapping(value = "/view-ns", method = RequestMethod.POST)
	public String View(@Valid @ModelAttribute(value = "ns") NhanSu emp, BindingResult result, Model m) {
		INhanSuHibernate nsHbn = new ImplNhanSuHibernate();
		IPhanQuyenHibernate pqHbn = new ImplPhanQuyenHibernate();
		List<PhanQuyen> lstpq = pqHbn.selectAll();

		boolean isOk = nsHbn.insert(emp);
		if (isOk) {
			m.addAttribute("msgOk", "Thêm mới thành công");
		} else {
			m.addAttribute("msgErr", "Thêm mới thất bại");
		}

		m.addAttribute("lstpq", lstpq);
		m.addAttribute("ns", emp);
		if (result.hasErrors()) {
			return "admin/nhansu/them-nv";
		} else {
			m.addAttribute("msg", "Thêm mới thành công");
			return "admin/nhansu/view-ns";
		}
	}

	@RequestMapping("/quan-ly-nhan-su")
	public String QLNS(Model m) {
		INhanSuHibernate nsHbn = new ImplNhanSuHibernate();
		List<NhanSu> lstns = nsHbn.selectAll();

		m.addAttribute("lstns", lstns);
		return "admin/nhansu/quan-ly-nhan-su";
	}

	@RequestMapping("/quan-tri-he-thong")
	public String TrangChu() {

		return "admin/quan-tri-he-thong";
	}

	@RequestMapping(value = "/update-nv/{id}", method = RequestMethod.GET)
	public String update(@PathVariable(value = "id", required = true) Integer id, Model m) {

		INhanSuHibernate nsHbn = new ImplNhanSuHibernate();
		NhanSu ns = nsHbn.selectById(id);
		IPhanQuyenHibernate pqHbn = new ImplPhanQuyenHibernate();
		List<PhanQuyen> lstpq = pqHbn.selectAll();

		m.addAttribute("ns", ns);
		m.addAttribute("lstpq", lstpq);

		return "admin/nhansu/update-nv";
	}
	
	@RequestMapping(value = "/update-nv", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "ns") NhanSu emp, Model m) {
		INhanSuHibernate nsHbn = new ImplNhanSuHibernate();
		
		boolean isOk = nsHbn.update(emp);
		if (isOk) {
			m.addAttribute("msgOk", "Cập nhật thành công !!!");
		} else {
			m.addAttribute("msgErr", "Cập nhật thất bại !!!");
		}
		
		return "admin/nhansu/update-nv";
	}

	@RequestMapping(value = "/delete-ns/{id}")
	public String DelNS(@PathVariable(value = "id") Integer id, Model m) {
		INhanSuHibernate nsHbn = new ImplNhanSuHibernate();
		boolean isOk = nsHbn.delete(id);
		if (isOk) {
			m.addAttribute("msgTrue", "Xóa thành công !!!");
		} else {
			m.addAttribute("msgFalse", "Xóa thất bại !!!");
		}

		List<NhanSu> lstns = nsHbn.selectAll();

		m.addAttribute("lstns", lstns);
		return "admin/nhansu/quan-ly-nhan-su";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String Search(@RequestParam(value = "txtSearch", required = true) String search, Model m) {
		
		INhanSuHibernate nsHbn = new ImplNhanSuHibernate();
		List<NhanSu> lstns = nsHbn.search(search);

		m.addAttribute("lstns", lstns);
		
		return "admin/nhansu/quan-ly-nhan-su";
	}
}