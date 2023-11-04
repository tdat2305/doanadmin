 package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.NhanSu;
import com.entity.SanPham;

public class ImplSanPhamHibernate implements ISanPhamHibernate {

	private SessionFactory sf;

	public ImplSanPhamHibernate() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public List<SanPham> selectAll() {

		Session ss = sf.openSession(); // mở kết nối db
		List<SanPham> lstsp = new ArrayList<SanPham>();
		try {
			// mở phiên làm việc
			ss.beginTransaction();
			// thực hiện lệnh
			lstsp = ss.createQuery("from SanPham order by id").list();

			// xác nhận
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi:" + e.getMessage());
			ss.getTransaction().rollback(); // hoàn tác lệnh
		} finally {
			ss.close();
		}

		return lstsp;
	}

	@Override
	public SanPham selectById(int id) {
		Session ss = sf.openSession(); // mở kết nối
		SanPham sp = null;
		try {
			// mở phiên làm việc
			ss.beginTransaction();

			// thực hiện lệnh
			sp = (SanPham) ss.createQuery("from SanPham where id = :masp").setParameter("masp", id).getSingleResult();
			System.out.println("Select By id: " + sp.toString());
			// xác nhận lệnh
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return sp;
	}

	@Override
	public boolean insert(SanPham sp) {
		Session ss = sf.openSession(); // mở kết nối
		boolean isOk = false;
		try {
			// mở phiên làm việc
			ss.beginTransaction();

			// thực hiện lệnh lưu đối tượng vao cơ sở dữ liệu
			ss.save(sp);
			// xác nhận lệnh
			ss.getTransaction().commit();
			isOk = true;
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback();
			isOk = false;
		} finally {
			ss.close();
		}
		return isOk;
	}

	@Override
	public boolean update(SanPham sp) {
		Session ss = sf.openSession(); // mở kết nối
		boolean isOk = false;
		try {
			// mở phiên làm việc
			ss.beginTransaction();

			// thực hiện lệnh lưu đối tượng vao cơ sở dữ liệu
			ss.update(sp);
			// xác nhận lệnh
			ss.getTransaction().commit();
			isOk = true;
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback();
			isOk = false;
		} finally {
			ss.close();
		}
		return isOk;
	}

	@Override
	public boolean delete(int id) {
		Session ss = sf.openSession(); // mở kết nối
		boolean isOk = false;
		try {
			// mở phiên làm việc
			ss.beginTransaction();
			SanPham sp = ss.get(SanPham.class, id);
			// thực hiện lệnh lưu đối tượng vao cơ sở dữ liệu
			ss.delete(sp);
			// xác nhận lệnh
			ss.getTransaction().commit();
			isOk = true;
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback();
			isOk = false;
		} finally {
			ss.close();
		}
		return isOk;
	}

	@Override
	public List<SanPham> search(String search) {
		Session ss = sf.openSession(); // mở kết nối
		List<SanPham> lstsp = new ArrayList<SanPham>();
		try {
			// mở phiên làm việc
			ss.beginTransaction();
			// thực hiện lệnh
			lstsp = ss.createQuery("from SanPham where ten_hang_hoa LIKE :search order by id").setParameter("search", "%" + search + "%").list();
			//xác nhận
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback(); // hoàn toác lệnh
		} finally {
			ss.close(); // đóng kết nối
		}
		return lstsp;
	}

}
