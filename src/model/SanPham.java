package model;

public class SanPham {
	private String tenSP;
	private Float donGia;
	private int soLuong;
	private String nganhHang;
	private String mauSac;
	private String cauHinh;
	public SanPham() {
	}
	public SanPham(String tenSP, Float donGia, int soLuong, String nganhHang, String mauSac, String cauHinh) {
        this.tenSP = tenSP;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.nganhHang = nganhHang;
		this.mauSac = mauSac;
		this.cauHinh = cauHinh;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public Float getDonGia() {
		return donGia;
	}
	public void setDonGia(Float donGia) {
		this.donGia = donGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getNganhHang() {
		return nganhHang;
	}
	public void setNganhHang(String nganhHang) {
		this.nganhHang = nganhHang;
	}
	public String getMauSac() {
		return mauSac;
	}
	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}
	public String getCauHinh() {
		return cauHinh;
	}
	public void setCauHinh(String cauHinh) {
		this.cauHinh = cauHinh;
	}
}
