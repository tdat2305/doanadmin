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
import com.entity.NhaCC;
import com.entity.NhanSu;
import com.entity.SanPham;
import com.hibernate.IChungLoaiHibernate;
import com.hibernate.IDonViTinhHibernate;
import com.hibernate.INhaCCHibernate;
import com.hibernate.INhanSuHibernate;
import com.hibernate.ISanPhamHibernate;
import com.hibernate.ImplChungLoaiHibernate;
import com.hibernate.ImplDonViTinhHibernate;
import com.hibernate.ImplNhaCCHibernate;
import com.hibernate.ImplNhanSuHibernate;
import com.hibernate.ImplSanPhamHibernate;

@Controller
@RequestMapping("/sanpham")
public class ControllerSanPham {
	@RequestMapping(value = "/them-sp", method = RequestMethod.GET)
	public String ThemSP(Model m) {

		IChungLoaiHibernate clHbn = new ImplChungLoaiHibernate();
		List<ChungLoai> lstcl = clHbn.selectAll();
		IDonViTinhHibernate dvtHbn = new ImplDonViTinhHibernate();
		List<DonViTinh> lstdvt = dvtHbn.selectAll();
		INhaCCHibernate ccHbn = new ImplNhaCCHibernate();
		List<NhaCC> lstcc = ccHbn.selectAll();

		SanPham sp = new SanPham();
		sp.setNgay_cap_nhat(LocalDate.now());
		sp.setNgay_tao(LocalDate.now());

		m.addAttribute("sp", sp);
		m.addAttribute("lstcl", lstcl);
		m.addAttribute("lstdvt", lstdvt);
		m.addAttribute("lstcc", lstcc);
		return "admin/sanpham/them-sp";
	}

	@RequestMapping(value = "/view-sp", method = RequestMethod.POST)
	public String View(@Valid @ModelAttribute(value = "sp") SanPham prd, BindingResult result, Model m) {

		ISanPhamHibernate spHbn = new ImplSanPhamHibernate();
		IChungLoaiHibernate clHbn = new ImplChungLoaiHibernate();
		List<ChungLoai> lstcl = clHbn.selectAll();
		IDonViTinhHibernate dvtHbn = new ImplDonViTinhHibernate();
		List<DonViTinh> lstdvt = dvtHbn.selectAll();
		INhaCCHibernate ccHbn = new ImplNhaCCHibernate();
		List<NhaCC> lstcc = ccHbn.selectAll();
		boolean isOk = spHbn.insert(prd);
		if (isOk) {
			m.addAttribute("msgOk", "Thêm mới thành công");
		} else {
			m.addAttribute("msgErr", "Thêm mới thất bại");
		}
		m.addAttribute("lstcl", lstcl);
		m.addAttribute("lstdvt", lstdvt);
		m.addAttribute("lstcc", lstcc);
		m.addAttribute("sp", prd);
		if (result.hasErrors()) {
			return "admin/sanpham/them-sp";
		} else {
			m.addAttribute("msg", "Thêm mới thành công");
			return "admin/sanpham/view-sp";
		}
	}

	@RequestMapping(value = "/quan-ly-san-pham")
	public String QLSP(Model m) {

		ISanPhamHibernate spHbn = new ImplSanPhamHibernate();
		List<SanPham> lstsp = spHbn.selectAll();
		System.out.println("SỐ lượng sp là: " + lstsp.size());
		m.addAttribute("lstsp", lstsp);

		return "admin/sanpham/quan-ly-san-pham";
	}

	@RequestMapping("/quan-tri-he-thong")
	public String TrangChu() {

		return "admin/quan-tri-he-thong";
	}
	@RequestMapping(value = "/update-sp/{id}", method = RequestMethod.GET)
	public String UpdateSP(@PathVariable(value = "id", required = true) Integer id, Model m) {
		ISanPhamHibernate spHbn = new ImplSanPhamHibernate();
		SanPham sp = spHbn.selectById(id);
		IChungLoaiHibernate clHbn = new ImplChungLoaiHibernate();
		List<ChungLoai> lstcl = clHbn.selectAll();
		IDonViTinhHibernate dvtHbn = new ImplDonViTinhHibernate();
		List<DonViTinh> lstdvt = dvtHbn.selectAll();
		INhaCCHibernate ccHbn = new ImplNhaCCHibernate();
		List<NhaCC> lstcc = ccHbn.selectAll();
		
		m.addAttribute("sp", sp);
		m.addAttribute("lstcl", lstcl);
		m.addAttribute("lstdvt", lstdvt);
		m.addAttribute("lstcc", lstcc);
		return "admin/sanpham/update-sp";
	}
	@RequestMapping(value = "/update-sp", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "sp") SanPham prd, Model m) {
		ISanPhamHibernate spHbn = new ImplSanPhamHibernate();
		IChungLoaiHibernate clHbn = new ImplChungLoaiHibernate();
		List<ChungLoai> lstcl = clHbn.selectAll();
		IDonViTinhHibernate dvtHbn = new ImplDonViTinhHibernate();
		List<DonViTinh> lstdvt = dvtHbn.selectAll();
		INhaCCHibernate ccHbn = new ImplNhaCCHibernate();
		List<NhaCC> lstcc = ccHbn.selectAll();
		
		m.addAttribute("lstcl", lstcl);
		m.addAttribute("lstdvt", lstdvt);
		m.addAttribute("lstcc", lstcc);
		
		boolean isOk = spHbn.update(prd);
		if (isOk) {
			m.addAttribute("msgOk", "Cập nhật thành công !!!");
		} else {
			m.addAttribute("msgErr", "Cập nhật thất bại !!!");
		}
		
		return "admin/sanpham/update-sp";
	}
	
	@RequestMapping(value = "/delete-sp/{id}")
	public String DelSp(@PathVariable(value = "id") Integer id, Model m) {
		ISanPhamHibernate spHbn = new ImplSanPhamHibernate();
		boolean isOk = spHbn.delete(id);
		if (isOk) {
			m.addAttribute("msgTrue", "Xóa thành công !!!");
		} else {
			m.addAttribute("msgFalse", "Xóa thất bại !!!");
		}
		
		List<SanPham> lstsp = spHbn.selectAll();
		m.addAttribute("lstsp", lstsp);
		return "admin/sanpham/quan-ly-san-pham";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String Search(@RequestParam(value = "txtSearch", required = true) String search, Model m) {
		
		ISanPhamHibernate spHbn = new ImplSanPhamHibernate();
		List<SanPham> lstsp = spHbn.search(search);

		m.addAttribute("lstsp", lstsp);
		
		return "admin/sanpham/quan-ly-san-pham";
	}
	
}
