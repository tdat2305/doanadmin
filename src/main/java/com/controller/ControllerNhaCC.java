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

import com.entity.KhachHang;
import com.entity.NhaCC;
import com.entity.NhanSu;
import com.entity.SanPham;
import com.hibernate.IKhachHangHibernate;
import com.hibernate.INhaCCHibernate;
import com.hibernate.INhanSuHibernate;
import com.hibernate.ISanPhamHibernate;
import com.hibernate.ImplKhachHangHibernate;
import com.hibernate.ImplNhaCCHibernate;
import com.hibernate.ImplNhanSuHibernate;
import com.hibernate.ImplSanPhamHibernate;

@Controller
@RequestMapping("/nhaCC")
public class ControllerNhaCC {
	@RequestMapping(value = "/them-nhaCC", method = RequestMethod.GET)
	public String ThemNhaCC(Model m) {
		NhaCC cc = new NhaCC();
		cc.setNgay_cap_nhat(LocalDate.now());
		cc.setNgay_tao(LocalDate.now());

		m.addAttribute("cc", cc);
		return "admin/nhaCC/them-nhaCC";
	}

	@RequestMapping(value = "/view-nha-cc", method = RequestMethod.POST)
	public String View(@Valid @ModelAttribute(value = "cc") NhaCC ncc, BindingResult result, Model m) {
		INhaCCHibernate ccHbn = new ImplNhaCCHibernate();
		boolean isOk = ccHbn.insert(ncc);
		if (isOk) {
			m.addAttribute("msgOk", "Thêm mới thành công");
		} else {
			m.addAttribute("msgErr", "Thêm mới thất bại");
		}
		m.addAttribute("cc", ncc);
		if (result.hasErrors()) {
			return "admin/nhaCC/them-nhaCC";
		} else {
			m.addAttribute("msg", "Thêm mới thành công");
			return "admin/nhaCC/view-nha-cc";
		}

	}

	@RequestMapping(value = "/quan-ly-nha-cc")
	public String QLNCC(Model m) {
		INhaCCHibernate ccHbn = new ImplNhaCCHibernate();
		List<NhaCC> lstcc = ccHbn.selectAll();
		System.out.println("SỐ lượng ns là: " + lstcc.size());

		m.addAttribute("lstcc", lstcc);
		return "admin/nhaCC/quan-ly-nha-cc";
	}

	@RequestMapping("/quan-tri-he-thong")
	public String TrangChu() {

		return "admin/quan-tri-he-thong";
	}
	
	@RequestMapping(value = "/update-ncc/{id}", method = RequestMethod.GET)
	public String update(@PathVariable(value = "id", required = true) Integer id, Model m) {
		
		INhaCCHibernate ccHbn = new ImplNhaCCHibernate();
		NhaCC cc = ccHbn.selectById(id);
		
		m.addAttribute("cc", cc);
		
		return "admin/nhaCC/update-ncc";
	}
	@RequestMapping(value = "/update-ncc", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "cc") NhaCC ncc, Model m) {
		INhaCCHibernate ccHbn = new ImplNhaCCHibernate();
		
		boolean isOk = ccHbn.update(ncc);
		if (isOk) {
			m.addAttribute("msgOk", "Cập nhật thành công !!!");
		} else {
			m.addAttribute("msgErr", "Cập nhật thất bại !!!");
		}
		
		return "admin/nhaCC/update-ncc";
	}
	
	@RequestMapping(value = "/delete-ncc/{id}")
	public String DelSp(@PathVariable(value = "id") Integer id, Model m) {
		INhaCCHibernate ccHbn = new ImplNhaCCHibernate();
		boolean isOk = ccHbn.delete(id);
		if (isOk) {
			m.addAttribute("msgTrue", "Xóa thành công !!!");
		} else {
			m.addAttribute("msgFalse", "Xóa thất bại !!!");
		}
		
		List<NhaCC> lstcc = ccHbn.selectAll();
		m.addAttribute("lstcc", lstcc);
		return "admin/nhaCC/quan-ly-nha-cc";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String Search(@RequestParam(value = "txtSearch", required = true) String search, Model m) {
		
		INhaCCHibernate ccHbn = new ImplNhaCCHibernate();
		List<NhaCC> lstcc = ccHbn.search(search);

		m.addAttribute("lstcc", lstcc);
		
		return "admin/nhaCC/quan-ly-nha-cc";
	}
}
