package com.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tblNhanVien")

public class NhanSu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="ho_va_ten")
	@NotEmpty(message = "Không để trống")
	private String ho_va_ten;
	@Column(name="gioi_tinh")
	private Short gioi_tinh;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="ngay_sinh")
	private Date ngay_sinh;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="ngay_vao_lam")
	private LocalDate ngay_vao_lam;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="ngay_cap_nhat")
	private LocalDate ngay_cap_nhat;
	@Column(name="sdt")
	@NotEmpty(message = "Không để trống")
	private String sdt;
	@Column(name="sdt_gd")
	private String sdt_gd;
	@Column(name="email")
	private String email;
	@Column(name="dia_chi")
	private String dia_chi;
	@Column(name="id_phan_quyen")
	
	@Transient
	private int id_phan_quyen;
	
	@Column(name="luong_co_ban")
	private float luong_co_ban;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="ghi_chu")
	private String ghi_chu;
	@Column(name="trang_thai")
	private Short trang_thai;
	
	@ManyToOne
	@JoinColumn(name = "id_phan_quyen", referencedColumnName = "ID")
	private PhanQuyen pq;
	
	public NhanSu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhanQuyen getPq() {
		return pq;
	}
	public void setPq(PhanQuyen pq) {
		this.pq = pq;
	}
	/**
	 * SELECT
	 * @param id
	 * @param ho_va_ten
	 * @param gioi_tinh
	 * @param ngay_sinh
	 * @param ngay_vao_lam
	 * @param ngay_cap_nhat
	 * @param sdt
	 * @param sdt_gd
	 * @param email
	 * @param dia_chi
	 * @param id_phan_quyen
	 * @param luong_co_ban
	 * @param username
	 * @param password
	 * @param ghi_chu
	 * @param trang_thai
	 */
	public NhanSu(int id, String ho_va_ten, Short gioi_tinh, Date ngay_sinh, LocalDate ngay_vao_lam, LocalDate ngay_cap_nhat,
			String sdt, String sdt_gd, String email, String dia_chi, int id_phan_quyen, float luong_co_ban,
			String username, String password, String ghi_chu, Short trang_thai) {
		super();
		this.id = id;
		this.ho_va_ten = ho_va_ten;
		this.gioi_tinh = gioi_tinh;
		this.ngay_sinh = ngay_sinh;
		this.ngay_vao_lam = ngay_vao_lam;
		this.ngay_cap_nhat = ngay_cap_nhat;
		this.sdt = sdt;
		this.sdt_gd = sdt_gd;
		this.email = email;
		this.dia_chi = dia_chi;
		this.id_phan_quyen = id_phan_quyen;
		this.luong_co_ban = luong_co_ban;
		this.username = username;
		this.password = password;
		this.ghi_chu = ghi_chu;
		this.trang_thai = trang_thai;
	}
	/**
	 * INSERT
	 * @param ho_va_ten
	 * @param gioi_tinh
	 * @param ngay_sinh
	 * @param ngay_vao_lam
	 * @param ngay_cap_nhat
	 * @param sdt
	 * @param sdt_gd
	 * @param email
	 * @param dia_chi
	 * @param id_phan_quyen
	 * @param luong_co_ban
	 * @param username
	 * @param password
	 * @param ghi_chu
	 * @param trang_thai
	 */
	public NhanSu(String ho_va_ten, Short gioi_tinh, Date ngay_sinh, LocalDate ngay_vao_lam, LocalDate ngay_cap_nhat,
			String sdt, String sdt_gd, String email, String dia_chi, int id_phan_quyen, float luong_co_ban,
			String username, String password, String ghi_chu, Short trang_thai) {
		super();
		this.ho_va_ten = ho_va_ten;
		this.gioi_tinh = gioi_tinh;
		this.ngay_sinh = ngay_sinh;
		this.ngay_vao_lam = ngay_vao_lam;
		this.ngay_cap_nhat = ngay_cap_nhat;
		this.sdt = sdt;
		this.sdt_gd = sdt_gd;
		this.email = email;
		this.dia_chi = dia_chi;
		this.id_phan_quyen = id_phan_quyen;
		this.luong_co_ban = luong_co_ban;
		this.username = username;
		this.password = password;
		this.ghi_chu = ghi_chu;
		this.trang_thai = trang_thai;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHo_va_ten() {
		return ho_va_ten;
	}
	public void setHo_va_ten(String ho_va_ten) {
		this.ho_va_ten = ho_va_ten;
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
	public LocalDate getNgay_vao_lam() {
		return ngay_vao_lam;
	}
	public void setNgay_vao_lam(LocalDate ngay_vao_lam) {
		this.ngay_vao_lam = ngay_vao_lam;
	}
	public LocalDate getNgay_cap_nhat() {
		return ngay_cap_nhat;
	}
	public void setNgay_cap_nhat(LocalDate ngay_cap_nhat) {
		this.ngay_cap_nhat = ngay_cap_nhat;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getSdt_gd() {
		return sdt_gd;
	}
	public void setSdt_gd(String sdt_gd) {
		this.sdt_gd = sdt_gd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public int getId_phan_quyen() {
		return id_phan_quyen;
	}
	public void setId_phan_quyen(int id_phan_quyen) {
		this.id_phan_quyen = id_phan_quyen;
	}
	public float getLuong_co_ban() {
		return luong_co_ban;
	}
	public void setLuong_co_ban(float luong_co_ban) {
		this.luong_co_ban = luong_co_ban;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	
	
}
