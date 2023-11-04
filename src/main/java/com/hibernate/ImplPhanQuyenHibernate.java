package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.PhanQuyen;

public class ImplPhanQuyenHibernate implements IPhanQuyenHibernate {
	
	private SessionFactory sf;
	
	public ImplPhanQuyenHibernate() {
		sf = HibernateUtils.getSessionFactory();
	}
	@Override
	public List<PhanQuyen> selectAll() {
		Session ss = sf.openSession();
		List<PhanQuyen> lstpq = new ArrayList<PhanQuyen>();
		
		try {
			ss.beginTransaction();
			lstpq = ss.createQuery("from PhanQuyen").list();
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			e.printStackTrace();
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return lstpq;
	}
	@Override
	public PhanQuyen selectById(int id) {
		Session ss = sf.openSession();
		PhanQuyen pq = null;
		
		try {
			ss.beginTransaction();
			pq = (PhanQuyen) ss.createQuery("from PhanQuyen where ID = :mapq").setParameter("mspq", id).getSingleResult();
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			e.printStackTrace();
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return pq;
	}

}
