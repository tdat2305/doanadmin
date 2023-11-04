package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.DonViTinh;

public class ImplDonViTinhHibernate implements IDonViTinhHibernate {
	 
	SessionFactory sf;
	
	public ImplDonViTinhHibernate() {
		sf = HibernateUtils.getSessionFactory();
	}
	
	@Override
	public List<DonViTinh> selectAll() {
		Session ss = sf.openSession();
		List<DonViTinh> lstdvt = new ArrayList<DonViTinh>();
		try {
			ss.beginTransaction();
			
			lstdvt = ss.createQuery("from DonViTinh").list();
			
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: "+ e.getMessage());
			e.getStackTrace();
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return lstdvt;
	}

	@Override
	public DonViTinh selectById(int id) {
		Session ss = sf.openSession();
		DonViTinh dvt = null;
		try {
			ss.beginTransaction();
			
			dvt = (DonViTinh) ss.createQuery("from DonViTinh where id: madvt").setParameter("madvt", id).getSingleResult();
			
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: "+ e.getMessage());
			e.getStackTrace();
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return dvt;
	}

}
