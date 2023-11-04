package com.hibernate;

import java.util.List;

import com.entity.SanPham;

public interface ISanPhamHibernate {
	public List<SanPham> selectAll();
	
	public List<SanPham> search(String search);

	public SanPham selectById(int id);

	public boolean insert(SanPham sp);

	public boolean update(SanPham sp);

	public boolean delete(int id);
}
