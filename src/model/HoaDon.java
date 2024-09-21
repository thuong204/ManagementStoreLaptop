package model;

import java.sql.Date;
import java.time.LocalDateTime;

public class HoaDon {
	private int maHoaDon;
	private int maNhanVien;
	private int maKhachHang;
	private String tenSP;
	private int soLuong;
	private long donGia;
	private LocalDateTime ngayDatHang;
	private long tongTien;
	
	public HoaDon() {
	}

	public HoaDon(int maHoaDon, int maNhanVien, int maKhachHang, String tenSP, int soLuong,long donGia, LocalDateTime ngayDatHang,
			long tongTien) {
		this.maHoaDon = maHoaDon;
		this.maNhanVien = maNhanVien;
		this.maKhachHang = maKhachHang;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGia =donGia;
		this.ngayDatHang = ngayDatHang;
		this.tongTien = tongTien;
	}

	public long getDonGia() {
		return donGia;
	}

	public void setDonGia(long donGia) {
		this.donGia = donGia;
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public LocalDateTime getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(LocalDateTime ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public long getTongTien() {
		return tongTien;
	}

	public void setTongTien(long tongTien) {
		this.tongTien = tongTien;
	}
	
	

}
