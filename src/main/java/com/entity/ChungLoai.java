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
@Table(name = "TBLCHUNGLOAI")
public class ChungLoai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer ID;
	@Column(name = "TEN")
	private String TEN;
	
	@OneToMany(mappedBy = "chungloai", fetch = FetchType.EAGER)
	private List<SanPham> lstsp;
	
	public ChungLoai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChungLoai(Integer iD, String tEN) {
		super();
		ID = iD;
		TEN = tEN;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getTEN() {
		return TEN;
	}
	public void setTEN(String tEN) {
		TEN = tEN;
	}
	public List<SanPham> getLstsp() {
		return lstsp;
	}
	public void setLstsp(List<SanPham> lstsp) {
		this.lstsp = lstsp;
	}
	
	
}
