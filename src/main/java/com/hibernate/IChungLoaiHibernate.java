package com.hibernate;

import java.util.List;

import com.entity.ChungLoai;

public interface IChungLoaiHibernate {
	public List<ChungLoai> selectAll();
	
	public ChungLoai selectById(int id);
}
