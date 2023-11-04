package com.hibernate;

import java.util.List;

import com.entity.NhaCC;
import com.entity.SanPham;

public interface INhaCCHibernate {
	public List<NhaCC> selectAll();
	
	public List<NhaCC> search(String search);
	
	public NhaCC selectById(int id);
	
	public boolean insert(NhaCC cc);

	public boolean update(NhaCC cc);

	public boolean delete(int id);
}
