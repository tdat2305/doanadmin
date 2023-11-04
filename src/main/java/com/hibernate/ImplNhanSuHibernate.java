package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.NhanSu;

public class ImplNhanSuHibernate implements INhanSuHibernate {

	private SessionFactory sf;

	public ImplNhanSuHibernate() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public List<NhanSu> selectAll() {
		Session ss = sf.openSession(); // mở kết nối
		List<NhanSu> lstns = new ArrayList<NhanSu>();
		try {
			// mở phiên làm việc
			ss.beginTransaction();
			// thực hiện lệnh
			lstns = ss.createQuery("from NhanSu order by id").list();
			//xác nhận
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback(); // hoàn toác lệnh
		} finally {
			ss.close(); // đóng kết nối
		}
		return lstns;
	}

	@Override
	public NhanSu selectById(int id) {
		Session ss = sf.openSession(); // mở kết nối
		NhanSu ns = null;
		try {
			// mở phiên làm việc
			ss.beginTransaction();
			// thực hiện lệnh
			ns = (NhanSu) ss.createQuery("from NhanSu where id = : mans").setParameter("mans", id).getSingleResult();
			//xác nhận
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback(); // hoàn toác lệnh
		} finally {
			ss.close(); // đóng kết nối
		}
		return ns;
	}

	@Override
	public boolean insert(NhanSu ns) {
		Session ss = sf.openSession(); // mở kết nối
		boolean isOk = false;
		try {
			// mở phiên làm việc
			ss.beginTransaction();
			// thực hiện lệnh lưu đối tượng vào csdl
			ss.save(ns);
			//xác nhận
			ss.getTransaction().commit();
			isOk = true;
		} catch (Exception e) {
			System.out.println("Lỗi insert " + e.getMessage());
			ss.getTransaction().rollback(); // hoàn toác lệnh
			isOk = false;
		} finally {
			ss.close(); // đóng kết nối
		}
		return isOk;
	}

	@Override
	public boolean update(NhanSu ns) {
		Session ss = sf.openSession(); // mở kết nối
		boolean isOk = false;
		try {
			// mở phiên làm việc
			ss.beginTransaction();
			// thực hiện lệnh lưu đối tượng vào csdl
			ss.update(ns);
			//xác nhận
			ss.getTransaction().commit();
			isOk = true;
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback(); // hoàn toác lệnh
			isOk = false;
		} finally {
			ss.close(); // đóng kết nối
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
			NhanSu ns = ss.get(NhanSu.class, id);
			// thực hiện lệnh lưu đối tượng vào csdl
			ss.delete(ns);
			//xác nhận
			ss.getTransaction().commit();
			isOk = true;
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback(); // hoàn toác lệnh
			isOk = false;
		} finally {
			ss.close(); // đóng kết nối
		}
		return isOk;
	}

	@Override
	public List<NhanSu> search(String search) {
		Session ss = sf.openSession(); // mở kết nối
		List<NhanSu> lstns = new ArrayList<NhanSu>();
		try {
			// mở phiên làm việc
			ss.beginTransaction();
			// thực hiện lệnh
			lstns = ss.createQuery("from NhanSu where ho_va_ten LIKE :search order by id").setParameter("search", "%" + search + "%").list();
			//xác nhận
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback(); // hoàn toác lệnh
		} finally {
			ss.close(); // đóng kết nối
		}
		return lstns;
	}

}
