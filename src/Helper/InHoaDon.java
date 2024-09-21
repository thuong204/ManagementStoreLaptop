package Helper;

import java.io.FileWriter;
import java.io.IOException;

import model.HoaDon;

public class InHoaDon {

	public static String generateInvoice(HoaDon hd) {
		 String invoice = "---------------HÓA ĐƠN ĐIỆN TỬ-----------------\n";
	        invoice += "\n- Mã hóa đơn: " +hd.getMaHoaDon();
	        invoice += "\n- Mã khách hàng: " +hd.getMaKhachHang();
	        invoice += "\n- Mã nhân viên: " +hd.getMaNhanVien();
	        invoice += "\n- Tên sản phẩm: "+hd.getTenSP();
	        invoice += "\n- Ngày đặt hàng: "+ hd.getNgayDatHang();
	        invoice += "\n- Số lượng: "+hd.getSoLuong();
	        invoice += "\n- Đơn giá: "+hd.getDonGia();
	        invoice += "\n- Tổng cộng: "+ hd.getSoLuong()*hd.getDonGia();
	        invoice += "\n--------------------------------------------------";
	        return invoice;
	    }
	}

