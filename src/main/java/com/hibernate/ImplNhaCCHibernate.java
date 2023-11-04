package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.KhachHang;
import com.entity.NhaCC;
import com.entity.SanPham;

public class ImplNhaCCHibernate implements INhaCCHibernate {
	private SessionFactory sf;
	
	public ImplNhaCCHibernate() {
		sf = HibernateUtils.getSessionFactory();
	}
	@Override
	public List<NhaCC> selectAll() {
		Session ss = sf.openSession(); // mở kết nối
		List<NhaCC> lstcc = new ArrayList<NhaCC>();
		try {
			// mở phiên làm việc
			ss.beginTransaction();
			// thực hiện lệnh
			lstcc = ss.createQuery("from NhaCC order by id").list();
			//xác nhận
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback(); // hoàn toác lệnh
		} finally {
			ss.close(); // đóng kết nối
		}
		return lstcc;
	}

	@Override
	public NhaCC selectById(int id) {
		Session ss = sf.openSession(); // mở kết nối
		NhaCC cc = null;
		try {
			// mở phiên làm việc
			ss.beginTransaction();
			// thực hiện lệnh
			cc = (NhaCC) ss.createQuery("from NhaCC where id = : macc").setParameter("macc", id).getSingleResult();
			//xác nhận
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback(); // hoàn toác lệnh
		} finally {
			ss.close(); // đóng kết nối
		}
		return cc;
	}
	@Override
	public boolean insert(NhaCC cc) {
		Session ss = sf.openSession(); // mở kết nối
		boolean isOk = false;
		try {
			// mở phiên làm việc
			ss.beginTransaction();

			// thực hiện lệnh lưu đối tượng vao cơ sở dữ liệu
			ss.save(cc);
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
	public boolean update(NhaCC cc) {
		Session ss = sf.openSession(); // mở kết nối
		boolean isOk = false;
		try {
			// mở phiên làm việc
			ss.beginTransaction();

			// thực hiện lệnh lưu đối tượng vao cơ sở dữ liệu
			ss.update(cc);
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
			NhaCC cc = ss.get(NhaCC.class, id);
			// thực hiện lệnh lưu đối tượng vao cơ sở dữ liệu
			ss.delete(cc);
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
	public List<NhaCC> search(String search) {
		Session ss = sf.openSession(); // mở kết nối
		List<NhaCC> lstcc = new ArrayList<NhaCC>();
		try {
			// mở phiên làm việc
			ss.beginTransaction();
			// thực hiện lệnh
			lstcc = ss.createQuery("from NhaCC where ten_nha_cc LIKE :search order by id").setParameter("search", "%" + search + "%").list();
			//xác nhận
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback(); // hoàn toác lệnh
		} finally {
			ss.close(); // đóng kết nối
		}
		return lstcc;
	}

}
