package com.hibernate;

import java.util.List;

import com.entity.ChungLoai;
import com.entity.DonViTinh;
import com.entity.PhanQuyen;
import com.entity.SanPham;

public class Test {

	public static void main(String[] args) {
//		// lấy dữ liệu chủng loại
//		IChungLoaiHibernate cl = new ImplChungLoaiHibernate();
//		List<ChungLoai> lstcl = cl.selectAll();
//		for (ChungLoai chl : lstcl) {
//			System.out.println(chl.getID() + ". " + chl.getTEN());
//		}
		// lấy dữ liệu dvt
		IDonViTinhHibernate dvt = new ImplDonViTinhHibernate();
		List<DonViTinh> lstdvt = dvt.selectAll();
		for (DonViTinh dv : lstdvt) {
			System.out.println(dv.getID() + ". " + dv.getTEN_DON_VI());
		}
//		// lấy giữ liệu phân quyền
//		IPhanQuyenHibernate pqHbn = new ImplPhanQuyenHibernate();
//		List<PhanQuyen> lstpq = pqHbn.selectAll();
//		for (PhanQuyen pq : lstpq) {
//			System.out.println(pq.getID() + ". " + pq.getVI_TRI());
//		}
//		
//		
//		// lấy dữ liệu sản phẩm
//		ISanPhamHibernate spHbn = new ImplSanPhamHibernate();
//		List<SanPham> lst = spHbn.selectAll();
//		for (SanPham sp : lst) {
//			System.out.println(sp.getId() + ". " + sp.getTen_hang_hoa());
//		}

	}

}
