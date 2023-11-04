package com.hibernate;

import java.util.List;

import com.entity.DonViTinh;

public interface IDonViTinhHibernate {
	public List<DonViTinh> selectAll(); 
	
	public DonViTinh selectById(int id);
}
