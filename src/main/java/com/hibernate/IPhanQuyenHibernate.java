package com.hibernate;

import java.util.List;

import com.entity.PhanQuyen;

public interface IPhanQuyenHibernate {
	public List<PhanQuyen> selectAll();
	
	public PhanQuyen selectById(int id);
}
