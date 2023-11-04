package com.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tblNhaCungCap")

public class NhaCC {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "ten_nha_cc")
	@javax.validation.constraints.NotEmpty(message = "Không để trống")
	private String ten_nha_cc;
	@Column(name = "dia_chi")
	@javax.validation.constraints.NotEmpty(message = "Không để trống")
	private String dia_chi;
	@Column(name = "sdt1")
	@javax.validation.constraints.NotEmpty(message = "Không để trống")
	private String sdt1;
	@Column(name = "sdt2")
	private String sdt2;
	@Column(name = "fax")
	private String fax;
	@Column(name = "email")
	private String email;
	@Column(name = "website")
	@javax.validation.constraints.NotEmpty(message = "Không để trống")
	private String website;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_tao")
	private LocalDate ngay_tao;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_cap_nhat")
	private LocalDate ngay_cap_nhat;
	@Column(name = "taxcode")
	private String taxcode;
	@Column(name = "ghi_chu")
	private String ghi_chu;
	@Column(name = "trang_thai")
	private Short trang_thai;

	@OneToMany(mappedBy = "nhacc", fetch = FetchType.EAGER)
	private List<SanPham> lstsp;
	
	public NhaCC() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * select
	 * 
	 * @param id
	 * @param ten_nha_cc
	 * @param dia_chi
	 * @param sdt1
	 * @param sdt2
	 * @param fax
	 * @param email
	 * @param website
	 * @param ngay_tao
	 * @param ngay_cap_nhat
	 * @param taxcode
	 * @param ghi_chu
	 * @param trang_thai
	 */
	public NhaCC(int id, String ten_nha_cc, String dia_chi, String sdt1, String sdt2, String fax, String email,
			String website, LocalDate ngay_tao, LocalDate ngay_cap_nhat, String taxcode, String ghi_chu, Short trang_thai) {
		super();
		this.id = id;
		this.ten_nha_cc = ten_nha_cc;
		this.dia_chi = dia_chi;
		this.sdt1 = sdt1;
		this.sdt2 = sdt2;
		this.fax = fax;
		this.email = email;
		this.website = website;
		this.ngay_tao = ngay_tao;
		this.ngay_cap_nhat = ngay_cap_nhat;
		this.taxcode = taxcode;
		this.ghi_chu = ghi_chu;
		this.trang_thai = trang_thai;
	}

	/**
	 * insert
	 * 
	 * @param ten_nha_cc
	 * @param dia_chi
	 * @param sdt1
	 * @param sdt2
	 * @param fax
	 * @param email
	 * @param website
	 * @param ngay_tao
	 * @param ngay_cap_nhat
	 * @param taxcode
	 * @param ghi_chu
	 * @param trang_thai
	 */

	public NhaCC(String ten_nha_cc, String dia_chi, String sdt1, String sdt2, String fax, String email, String website,
			LocalDate ngay_tao, LocalDate ngay_cap_nhat, String taxcode, String ghi_chu, Short trang_thai) {
		super();
		this.ten_nha_cc = ten_nha_cc;
		this.dia_chi = dia_chi;
		this.sdt1 = sdt1;
		this.sdt2 = sdt2;
		this.fax = fax;
		this.email = email;
		this.website = website;
		this.ngay_tao = ngay_tao;
		this.ngay_cap_nhat = ngay_cap_nhat;
		this.taxcode = taxcode;
		this.ghi_chu = ghi_chu;
		this.trang_thai = trang_thai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen_nha_cc() {
		return ten_nha_cc;
	}

	public void setTen_nha_cc(String ten_nha_cc) {
		this.ten_nha_cc = ten_nha_cc;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public String getSdt1() {
		return sdt1;
	}

	public void setSdt1(String sdt1) {
		this.sdt1 = sdt1;
	}

	public String getSdt2() {
		return sdt2;
	}

	public void setSdt2(String sdt2) {
		this.sdt2 = sdt2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public LocalDate getNgay_tao() {
		return ngay_tao;
	}

	public void setNgay_tao(LocalDate ngay_tao) {
		this.ngay_tao = ngay_tao;
	}

	public LocalDate getNgay_cap_nhat() {
		return ngay_cap_nhat;
	}

	public void setNgay_cap_nhat(LocalDate ngay_cap_nhat) {
		this.ngay_cap_nhat = ngay_cap_nhat;
	}

	public String getTaxcode() {
		return taxcode;
	}

	public void setTaxcode(String taxcode) {
		this.taxcode = taxcode;
	}

	public String getGhi_chu() {
		return ghi_chu;
	}

	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}

	public Short getTrang_thai() {
		return trang_thai;
	}

	public void setTrang_thai(Short trang_thai) {
		this.trang_thai = trang_thai;
	}

	public List<SanPham> getLstsp() {
		return lstsp;
	}

	public void setLstsp(List<SanPham> lstsp) {
		this.lstsp = lstsp;
	}
	

}
