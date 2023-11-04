package com.hibernate;

import java.util.List;

import com.entity.NhanSu;

public interface INhanSuHibernate {
	public List<NhanSu> selectAll();
	
	public List<NhanSu> search(String search);

	public NhanSu selectById(int id);

	public boolean insert(NhanSu ns);

	public boolean update(NhanSu ns);

	public boolean delete(int id);
}
