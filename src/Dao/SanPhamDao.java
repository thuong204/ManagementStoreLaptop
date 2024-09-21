package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import Helper.Connect;
import model.HoaDon;
import model.SanPham;

public class SanPhamDao {
	public boolean insert(SanPham sp ) 
			throws Exception{
	
				String sql = "INSERT INTO dbo.SanPham(TenSanPham,DonGia,SoLuong,NganhHang,MauSac,CauHinh)\r\n"
						+ "VALUES(?,?,?,?,?,?)";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,sp.getTenSP());
					pstmt.setFloat(2,sp.getDonGia());
					pstmt.setInt(3,sp.getSoLuong());
					pstmt.setString(4,sp.getNganhHang());
					pstmt.setString(5,sp.getMauSac());
					pstmt.setString(6, sp.getCauHinh());				
		return pstmt.executeUpdate()>0;
		}	
	}
	public boolean update(SanPham sp ) 
			throws Exception{
		
	
				String sql = "UPDATE dbo.SanPham"
						+ "				   SET DonGia=?,SoLuong=?,	NganhHang=?,MauSac=?,CauHinh=?"+" where TenSanPham=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setFloat(1,sp.getDonGia());
					pstmt.setInt(2,sp.getSoLuong());
					pstmt.setString(3,sp.getNganhHang());
					pstmt.setString(4,sp.getMauSac());
					pstmt.setString(5, sp.getCauHinh());
					pstmt.setString(6,sp.getTenSP());
					
		return pstmt.executeUpdate()>0;
		}	
	}
	public boolean delete(String tenSP ) 
			throws Exception{
				String sql = "delete from SanPham "+"where TenSanPham=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,tenSP);
		return pstmt.executeUpdate()>0;
		}	
	}
	public boolean checkExist(String tenSP) 
			throws Exception{
				String sql = "select *  from SanPham "+"where TenSanPham=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,tenSP);
					ResultSet rs = pstmt.executeQuery();
		return rs.next();
		}	
	}
	public boolean checkExistSanPham(String tenSP) 
			throws Exception{
				String sql = "select *  from HoaDon "+"where TenSanPham=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,tenSP);
					ResultSet rs = pstmt.executeQuery();
		return rs.next();
		}	
	}
	public ArrayList<SanPham> getListSanPham(){
		ArrayList<SanPham> list = new ArrayList<>();
		String sql = "SELECT * FROM SanPham";
		try {
			Connection connection = Connect.openConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SanPham sp = new SanPham();
				sp.setTenSP(rs.getString(1));
				sp.setDonGia(rs.getFloat(2));
				sp.setSoLuong(rs.getInt(3));
				sp.setNganhHang(rs.getString(4));
				sp.setMauSac(rs.getString(5));
				sp.setCauHinh(rs.getString(6));
				list.add(sp);
			}			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		}   

}
