package com.entity;

import java.time.LocalDate;

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
@Table(name = "tblHangHoa")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "ma_vach")
	@NotEmpty(message = "Không để trống")
	private String ma_vach;
	@Column(name = "ten_hang_hoa")
	@NotEmpty(message = "Không để trống")
	private String ten_hang_hoa;
	@Column(name = "id_chung_loai")
	
	@Transient
	private int id_chung_loai;
	@Column(name = "id_dv_tinh")
	
	@Transient
	private int id_dv_tinh;
	@Column(name = "id_nha_cc")
	
	@Transient
	private int id_nha_cc;
	@Column(name = "so_luong")
	private float so_luong;
	@Column(name = "gia_nhap")
	private float gia_nhap;
	@Column(name = "gia_xuat")
	private float gia_xuat;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_tao")
	private LocalDate ngay_tao;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_cap_nhat")
	private LocalDate ngay_cap_nhat;
	@Column(name = "ghi_chu")
	private String ghi_chu;
	
	@ManyToOne
	@JoinColumn(name = "id_chung_loai", referencedColumnName = "id")
	private ChungLoai chungloai;
	
	@ManyToOne
	@JoinColumn(name = "id_dv_tinh", referencedColumnName = "id")
	private DonViTinh dvtinh;
	
	@ManyToOne
	@JoinColumn(name = "id_nha_cc", referencedColumnName = "id")
	private NhaCC nhacc;
	
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * select
	 * 
	 * @param id
	 * @param ma_vach
	 * @param ten_hang_hoa
	 * @param id_chung_loai
	 * @param id_dv_tinh
	 * @param id_nha_cc
	 * @param so_luong
	 * @param gia_nhap
	 * @param gia_xuat
	 * @param ngay_tao
	 * @param ngay_cap_nhat
	 * @param ghi_chu
	 */
	public SanPham(int id, String ma_vach, String ten_hang_hoa, int id_chung_loai, int id_dv_tinh, int id_nha_cc,
			float so_luong, float gia_nhap, float gia_xuat, LocalDate ngay_tao, LocalDate ngay_cap_nhat, String ghi_chu) {
		super();
		this.id = id;
		this.ma_vach = ma_vach;
		this.ten_hang_hoa = ten_hang_hoa;
		this.id_chung_loai = id_chung_loai;
		this.id_dv_tinh = id_dv_tinh;
		this.id_nha_cc = id_nha_cc;
		this.so_luong = so_luong;
		this.gia_nhap = gia_nhap;
		this.gia_xuat = gia_xuat;
		this.ngay_tao = ngay_tao;
		this.ngay_cap_nhat = ngay_cap_nhat;
		this.ghi_chu = ghi_chu;
	}

	/**
	 * insert
	 * 
	 * @param ma_vach
	 * @param ten_hang_hoa
	 * @param id_chung_loai
	 * @param id_dv_tinh
	 * @param id_nha_cc
	 * @param so_luong
	 * @param gia_nhap
	 * @param gia_xuat
	 * @param ngay_tao
	 * @param ngay_cap_nhat
	 * @param ghi_chu
	 */
	public SanPham(String ma_vach, String ten_hang_hoa, int id_chung_loai, int id_dv_tinh, int id_nha_cc,
			float so_luong, float gia_nhap, float gia_xuat, LocalDate ngay_tao, LocalDate ngay_cap_nhat, String ghi_chu) {
		super();
		this.ma_vach = ma_vach;
		this.ten_hang_hoa = ten_hang_hoa;
		this.id_chung_loai = id_chung_loai;
		this.id_dv_tinh = id_dv_tinh;
		this.id_nha_cc = id_nha_cc;
		this.so_luong = so_luong;
		this.gia_nhap = gia_nhap;
		this.gia_xuat = gia_xuat;
		this.ngay_tao = ngay_tao;
		this.ngay_cap_nhat = ngay_cap_nhat;
		this.ghi_chu = ghi_chu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMa_vach() {
		return ma_vach;
	}

	public void setMa_vach(String ma_vach) {
		this.ma_vach = ma_vach;
	}

	public String getTen_hang_hoa() {
		return ten_hang_hoa;
	}

	public void setTen_hang_hoa(String ten_hang_hoa) {
		this.ten_hang_hoa = ten_hang_hoa;
	}

	public int getId_chung_loai() {
		return id_chung_loai;
	}

	public void setId_chung_loai(int id_chung_loai) {
		this.id_chung_loai = id_chung_loai;
	}

	public int getId_dv_tinh() {
		return id_dv_tinh;
	}

	public void setId_dv_tinh(int id_dv_tinh) {
		this.id_dv_tinh = id_dv_tinh;
	}

	public int getId_nha_cc() {
		return id_nha_cc;
	}

	public void setId_nha_cc(int id_nha_cc) {
		this.id_nha_cc = id_nha_cc;
	}

	public float getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(float so_luong) {
		this.so_luong = so_luong;
	}

	public float getGia_nhap() {
		return gia_nhap;
	}

	public void setGia_nhap(float gia_nhap) {
		this.gia_nhap = gia_nhap;
	}

	public float getGia_xuat() {
		return gia_xuat;
	}

	public void setGia_xuat(float gia_xuat) {
		this.gia_xuat = gia_xuat;
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

	public String getGhi_chu() {
		return ghi_chu;
	}

	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}

	public ChungLoai getChungloai() {
		return chungloai;
	}

	public void setChungloai(ChungLoai chungloai) {
		this.chungloai = chungloai;
	}

	public DonViTinh getDvtinh() {
		return dvtinh;
	}

	public void setDvtinh(DonViTinh dvtinh) {
		this.dvtinh = dvtinh;
	}

	public NhaCC getNhacc() {
		return nhacc;
	}

	public void setNhacc(NhaCC nhacc) {
		this.nhacc = nhacc;
	}

	@Override
	public String toString() {
		return "SanPham [id=" + id + ", ma_vach=" + ma_vach + ", ten_hang_hoa=" + ten_hang_hoa + ", id_chung_loai="
				+ id_chung_loai + ", id_dv_tinh=" + id_dv_tinh + ", id_nha_cc=" + id_nha_cc + ", so_luong=" + so_luong
				+ ", gia_nhap=" + gia_nhap + ", gia_xuat=" + gia_xuat + ", ngay_tao=" + ngay_tao + ", ngay_cap_nhat="
				+ ngay_cap_nhat + ", ghi_chu=" + ghi_chu + ", chungloai=" + chungloai + ", dvtinh=" + dvtinh
				+ ", nhacc=" + nhacc + "]";
	}
	
	

}
