package view;

import model.HoaDon;

public class InHoaDon {
	public static String generateInvoice(HoaDon hd) {
		 String invoice = "Hóa đơn điện tử\n";
	        invoice += "\nNgày đặt hàng: "+ hd.getNgayDatHang();
	        invoice += "\nMã hóa đơn: " +hd.getMaHoaDon();
	        invoice += "\nMã khách hàng: " +hd.getMaKhachHang();
	        invoice += "\nMã nhân viên: " +hd.getMaNhanVien();
	        invoice += "\nTên sản phẩm: "+hd.getTenSP();
	        invoice += "\nSố lượng: "+hd.getSoLuong();
	        invoice += "\nĐơn giá: "+hd.getDonGia();
	        invoice += "\nTổng cộng: "+ hd.getTongTien();
	        return invoice;
	    }
	}

