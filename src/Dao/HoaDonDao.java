package Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import Helper.Connect;
import model.HoaDon;
import model.SanPham;
import view.HomeView;

public class HoaDonDao {
	public boolean insert(HoaDon hd ) 
			throws Exception{
	
				String sql = "INSERT INTO dbo.HoaDon(MaHoaDon,MaNhanVien,MaKhachHang,TenSanPham,SoLuong,DonGia,NgayDatHang,TongTien)\r\n"
						+ "VALUES(?,?,?,?,?,?,?,?)";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setInt(1,hd.getMaHoaDon());
					pstmt.setInt(2,hd.getMaNhanVien());
					pstmt.setInt(3,hd.getMaKhachHang());
					pstmt.setString(4,hd.getTenSP());
					pstmt.setInt(5,hd.getSoLuong());
					pstmt.setFloat(6, hd.getDonGia());
					pstmt.setObject(7,hd.getNgayDatHang());
					pstmt.setFloat(8,hd.getTongTien());
					
		return pstmt.executeUpdate()>0;
		}	
	}
	public boolean updateSoLuong() throws Exception {
		SanPham sp = new SanPham();
		int slhoadon = Integer.parseInt(HomeView.textField_SoLuong.getText());
		System.out.println(slhoadon);
		String tenSp= HomeView.textField_TenSP.getText();
		System.out.println(tenSp);
		int ColumnIndex =-1;
		int rowCount = HomeView.modelSanPham.getRowCount();
		for (int i = 0; i < rowCount; i++) {
            String rowName = HomeView.modelSanPham.getValueAt(i, 0).toString();
            if (rowName.equals(tenSp)) {
                ColumnIndex = i;
                break;
            }
        }
		System.out.println(ColumnIndex);
		int slSp = Integer.parseInt(HomeView.modelSanPham.getValueAt(ColumnIndex, 2).toString());
		String sql = "UPDATE  dbo.SanPham set SoLuong=? where TenSanpham =?\r\n";
		
		try (
				Connection con = Connect.openConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
				pstmt.setInt(1,slSp-slhoadon);
				pstmt.setString(2,tenSp);
		return pstmt.executeUpdate()>0;
		}
		
	}
	public boolean update(HoaDon hd ) 
			throws Exception{
		
	
				String sql = "UPDATE dbo.HoaDon"
						+ "				   SET MaNhanVien=?,MaKhachHang=?,TenSanPham=?,SoLuong=?,DonGia=?,NgayDatHang=?,TongTien=? "+" where MaHoaDon=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setInt(1,hd.getMaNhanVien());
					pstmt.setInt(2,hd.getMaKhachHang());
					pstmt.setString(3,hd.getTenSP());
					pstmt.setInt(4,hd.getSoLuong());
					pstmt.setFloat(5, hd.getDonGia());
					pstmt.setObject(6,hd.getNgayDatHang());
					pstmt.setFloat(7,hd.getTongTien());
					pstmt.setInt(8,hd.getMaHoaDon());
					
		return pstmt.executeUpdate()>0;
		}	
	}
	public boolean delete(Integer maHoaDon ) 
			throws Exception{
		
	
				String sql = "delete from HoaDon "+"where MaHoaDon=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setInt(1,maHoaDon);
					
		return pstmt.executeUpdate()>0;
		}	
	}
	public ArrayList<HoaDon> getListHoaDon(){
		ArrayList<HoaDon> list = new ArrayList<>();
		String sql = "SELECT * FROM HoaDon";
		try {
			Connection connection = Connect.openConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				HoaDon hd = new HoaDon();
				hd.setMaHoaDon(rs.getInt(1));
				hd.setMaNhanVien(rs.getInt(2));
				hd.setMaKhachHang(rs.getInt(3));
				hd.setTenSP(rs.getString(4));
				hd.setSoLuong(rs.getInt(5));
				hd.setDonGia(rs.getInt(6));
				Object obj = rs.getObject(7); // Đối tượng ngày giờ
				Instant instant = ((Date) obj).toInstant(); // Chuyển đổi thành Instant
				LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); // Chuyển đổi thành LocalDateTime
				hd.setNgayDatHang(localDateTime);
				hd.setTongTien(rs.getLong(5)*rs.getLong(6));
				list.add(hd);
			}			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		}   
	

}
