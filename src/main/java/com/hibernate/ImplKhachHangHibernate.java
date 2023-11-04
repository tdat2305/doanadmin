package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.KhachHang;
import com.entity.NhanSu;
import com.entity.SanPham;

public class ImplKhachHangHibernate implements IKhachHangHibernate {
	private SessionFactory sf;

	public ImplKhachHangHibernate() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public List<KhachHang> selectAll() {
		Session ss = sf.openSession(); // mở kết nối
		List<KhachHang> lstkh = new ArrayList<KhachHang>();
		try {
			// mở phiên làm việc
			ss.beginTransaction();
			// thực hiện lệnh
			lstkh = ss.createQuery("from KhachHang order by id").list();
			//xác nhận
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback(); // hoàn toác lệnh
		} finally {
			ss.close(); // đóng kết nối
		}
		return lstkh;
	}

	@Override
	public KhachHang selectById(int id) {
		Session ss = sf.openSession(); // mở kết nối
		KhachHang kh = null;
		try {
			// mở phiên làm việc
			ss.beginTransaction();
			// thực hiện lệnh
			kh = (KhachHang) ss.createQuery("from KhachHang where id = : makh").setParameter("makh", id).getSingleResult();
			//xác nhận
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback(); // hoàn toác lệnh
		} finally {
			ss.close(); // đóng kết nối
		}
		return kh;
	}

	@Override
	public boolean insert(KhachHang kh) {
		Session ss = sf.openSession(); // mở kết nối
		boolean isOk = false;
		try {
			// mở phiên làm việc
			ss.beginTransaction();

			// thực hiện lệnh lưu đối tượng vao cơ sở dữ liệu
			ss.save(kh);
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
	public boolean update(KhachHang kh) {
		Session ss = sf.openSession(); // mở kết nối
		boolean isOk = false;
		try {
			// mở phiên làm việc
			ss.beginTransaction();

			// thực hiện lệnh lưu đối tượng vao cơ sở dữ liệu
			ss.update(kh);
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
			KhachHang kh = ss.get(KhachHang.class, id);
			// thực hiện lệnh lưu đối tượng vao cơ sở dữ liệu
			ss.delete(kh);
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
	public List<KhachHang> search(String search) {
		Session ss = sf.openSession(); // mở kết nối
		List<KhachHang> lstkh = new ArrayList<KhachHang>();
		try {
			// mở phiên làm việc
			ss.beginTransaction();
			// thực hiện lệnh
			lstkh = ss.createQuery("from KhachHang where ten LIKE :search order by id").setParameter("search", "%" + search + "%").list();
			//xác nhận
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback(); // hoàn toác lệnh
		} finally {
			ss.close(); // đóng kết nối
		}
		return lstkh;
	}

}
