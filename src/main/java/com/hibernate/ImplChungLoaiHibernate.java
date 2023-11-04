package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.ChungLoai;

public class ImplChungLoaiHibernate implements IChungLoaiHibernate {

	SessionFactory sf;

	public ImplChungLoaiHibernate() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public List<ChungLoai> selectAll() {
		Session ss = sf.openSession();
		List<ChungLoai> lstcl = new ArrayList<ChungLoai>();
		try {
			ss.beginTransaction();

			lstcl = ss.createQuery("from ChungLoai").list();

			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			e.printStackTrace();
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return lstcl;
	}

	@Override
	public ChungLoai selectById(int id) {
		Session ss = sf.openSession();
		ChungLoai cl = null;
		try {
			ss.beginTransaction();

			cl = (ChungLoai) ss.createQuery("from ChungLoai where id: macl").setParameter("macl", id).getSingleResult();

			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			e.printStackTrace();
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return cl;
	}

}
