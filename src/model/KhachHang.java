package model;

public class KhachHang {
	private int maKH;
	private String tenKH;
	private String diaChiKH;
	private String soDienThoaiKH;
	private String emailKH;
	public KhachHang() {
	}
	public KhachHang(int maKH, String tenKH, String diaChiKH, String soDienThoaiKH, String emailKH) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChiKH = diaChiKH;
		this.soDienThoaiKH = soDienThoaiKH;
		this.emailKH = emailKH;
	}
	public int getMaKH() {
		return maKH;
	}
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChiKH() {
		return diaChiKH;
	}
	public void setDiaChiKH(String diaChiKH) {
		this.diaChiKH = diaChiKH;
	}
	public String getSoDienThoaiKH() {
		return soDienThoaiKH;
	}
	public void setSoDienThoaiKH(String soDienThoaiKH) {
		this.soDienThoaiKH = soDienThoaiKH;
	}
	public String getEmailKH() {
		return emailKH;
	}
	public void setEmailKH(String emailKH) {
		this.emailKH = emailKH;
	}
	
	
	
	

}
