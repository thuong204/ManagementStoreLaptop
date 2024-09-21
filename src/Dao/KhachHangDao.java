package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Helper.Connect;
import model.KhachHang;
import model.NhanVien;

public class KhachHangDao {
	public boolean insert(KhachHang kh ) 
			throws Exception{
	
				String sql = "INSERT INTO dbo.KhachHang(MaKhachHang,HoTen,DiaChi,SoDienThoai,Email)\r\n"
						+ "VALUES(?,?,?,?,?)";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setInt(1,kh.getMaKH());
					pstmt.setString(2,kh.getTenKH());
					pstmt.setString(3,kh.getDiaChiKH());
					pstmt.setString(4,kh.getSoDienThoaiKH());
					pstmt.setString(5, kh.getEmailKH());
		return pstmt.executeUpdate()>0;
		}	
	}
	public boolean update(KhachHang kh ) 
			throws Exception{
		
	
				String sql = "UPDATE dbo.KhachHang"
						+ "				   SET HoTen=?,DiaChi=?,SoDienThoai=?,Email=? "+" where MaKhachHang=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,kh.getTenKH());
					pstmt.setString(2,kh.getDiaChiKH());
					pstmt.setString(3,kh.getSoDienThoaiKH());
					pstmt.setString(4, kh.getEmailKH());
					pstmt.setInt(5,kh.getMaKH());
		return pstmt.executeUpdate()>0;
		}	
	}
	public boolean delete(String maKh) 
			throws Exception{
				String sql = "delete from KhachHang "+"where MaKhachHang=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,maKh);
		return pstmt.executeUpdate()>0;
		}	
	}
	public boolean checkExist(String maKH) 
			throws Exception{
				String sql = "select *  from KhachHang "+"where MaKhachHang=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,maKH);
					ResultSet rs = pstmt.executeQuery();
		return rs.next();
		}	
	}
	public boolean checkExistKhachHang(String maKH) 
			throws Exception{
				String sql = "select *  from HoaDon "+"where MaKhachHang=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,maKH);
					ResultSet rs = pstmt.executeQuery();
		return rs.next();
		}	
	}
	public ArrayList<KhachHang> getListKhachHang(){
		ArrayList<KhachHang> list = new ArrayList<>();
		String sql = "SELECT * FROM KhachHang";
		try {
			Connection connection = Connect.openConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				KhachHang kh = new KhachHang();
				kh.setMaKH(rs.getInt(1));
				kh.setTenKH(rs.getString(2));
				kh.setDiaChiKH(rs.getString(3));
				kh.setSoDienThoaiKH(rs.getString(4));
			    kh.setEmailKH(rs.getString(5));
				list.add(kh);
			}			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		}   
	
	public static boolean isGmailAddress(String email) {
        String regex = "\\b[A-Za-z0-9._%+-]+@gmail\\.com\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
	 public static boolean isPhoneNumber(String phoneNumber) {
	        String regex = "^\\d{10}$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(phoneNumber);
	        return matcher.matches();
	    }

}
