package com.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tblKhachHang")

public class KhachHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "ho")
	@NotEmpty(message = "Không để trống")
	private String ho;
	@Column(name = "ten")
	@NotEmpty(message = "Không để trống")
	private String ten;
	@Column(name = "gioi_tinh")
	private Short gioi_tinh;
	@Column(name = "ngay_sinh")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngay_sinh;
	@Column(name = "sdt")
	@NotEmpty(message = "Không để trống")
	private String sdt;
	@Column(name = "dia_chi")
	private String dia_chi;
	@Column(name = "email")
	@NotEmpty(message = "Không để trống")
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_tao")
	private LocalDate ngay_tao;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_cap_nhat")
	private LocalDate ngay_cap_nhat;
	@Column(name = "trang_thai")
	private Short trang_thai;
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**select
	 * 
	 * @param id
	 * @param ho
	 * @param ten
	 * @param gioi_tinh
	 * @param ngay_sinh
	 * @param sdt
	 * @param dia_chi
	 * @param email
	 * @param ngay_tao
	 * @param ngay_cap_nhat
	 * @param trang_thai
	 */
	public KhachHang(int id, String ho, String ten, Short gioi_tinh, Date ngay_sinh, String sdt, String dia_chi,
			String email, LocalDate ngay_tao, LocalDate ngay_cap_nhat, Short trang_thai) {
		super();
		this.id = id;
		this.ho = ho;
		this.ten = ten;
		this.gioi_tinh = gioi_tinh;
		this.ngay_sinh = ngay_sinh;
		this.sdt = sdt;
		this.dia_chi = dia_chi;
		this.email = email;
		this.ngay_tao = ngay_tao;
		this.ngay_cap_nhat = ngay_cap_nhat;
		this.trang_thai = trang_thai;
	}
	/**insert
	 * 
	 * @param ho
	 * @param ten
	 * @param gioi_tinh
	 * @param ngay_sinh
	 * @param sdt
	 * @param dia_chi
	 * @param email
	 * @param ngay_tao
	 * @param ngay_cap_nhat
	 * @param trang_thai
	 */

	public KhachHang(String ho, String ten, Short gioi_tinh, Date ngay_sinh, String sdt, String dia_chi, String email,
			LocalDate ngay_tao, LocalDate ngay_cap_nhat, Short trang_thai) {
		super();
		this.ho = ho;
		this.ten = ten;
		this.gioi_tinh = gioi_tinh;
		this.ngay_sinh = ngay_sinh;
		this.sdt = sdt;
		this.dia_chi = dia_chi;
		this.email = email;
		this.ngay_tao = ngay_tao;
		this.ngay_cap_nhat = ngay_cap_nhat;
		this.trang_thai = trang_thai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Short getGioi_tinh() {
		return gioi_tinh;
	}

	public void setGioi_tinh(Short gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}

	public Date getNgay_sinh() {
		return ngay_sinh;
	}

	public void setNgay_sinh(Date ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Short getTrang_thai() {
		return trang_thai;
	}

	public void setTrang_thai(Short trang_thai) {
		this.trang_thai = trang_thai;
	}
	
	
	
	
}
