package com.hibernate;

import java.util.List;

import com.entity.KhachHang;
import com.entity.SanPham;

public interface IKhachHangHibernate {
	public List<KhachHang> selectAll();
	
	public List<KhachHang> search(String search);
	
	public KhachHang selectById(int id);
	
	public boolean insert(KhachHang kh);

	public boolean update(KhachHang kh);

	public boolean delete(int id); 
}
