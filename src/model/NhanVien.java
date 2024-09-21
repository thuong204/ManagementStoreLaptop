package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NhanVien {
	private int maNV;
	private String hoten;
	private Date ngaySinh;
	private String diaChi;
	private String soDienThoai;
	private String email;
	private String chucVu;
	public NhanVien() {
	}
	public NhanVien(int maNV, String hoten, Date ngaySinh, String diaChi, String soDienThoai, String email,
			String chucVu) {
		super();
		this.maNV = maNV;
		this.hoten = hoten;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.chucVu = chucVu;
	}
	public int getMaNV() {
		return maNV;
	}
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date date) {
		this.ngaySinh = date;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
}

