package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblPhanQuyen")
public class PhanQuyen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer ID;
	@Column(name = "VI_TRI")
	private String VI_TRI;
	
	@OneToMany(mappedBy = "pq", fetch = FetchType.EAGER)
	List<NhanSu> lstNhanSu;
	
	public PhanQuyen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhanQuyen(Integer iD, String vI_TRI) {
		super();
		ID = iD;
		VI_TRI = vI_TRI;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getVI_TRI() {
		return VI_TRI;
	}
	public void setVI_TRI(String vI_TRI) {
		VI_TRI = vI_TRI;
	}
	
}
