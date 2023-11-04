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
@Table(name = "TBLDONVITINH")
public class DonViTinh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer ID;
	@Column(name = "TEN_DON_VI")
	private String TEN_DON_VI;
	
	@OneToMany(mappedBy = "dvtinh", fetch = FetchType.EAGER)
	private List<SanPham> lstsp;

	public DonViTinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonViTinh(Integer iD, String tEN_DON_VI) {
		super();
		ID = iD;
		TEN_DON_VI = tEN_DON_VI;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getTEN_DON_VI() {
		return TEN_DON_VI;
	}

	public void setTEN_DON_VI(String tEN_DON_VI) {
		TEN_DON_VI = tEN_DON_VI;
	}

	public List<SanPham> getLstsp() {
		return lstsp;
	}

	public void setLstsp(List<SanPham> lstsp) {
		this.lstsp = lstsp;
	}
	
	
}
