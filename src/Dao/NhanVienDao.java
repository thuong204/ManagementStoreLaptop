package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Helper.Connect;
import model.NhanVien;
import model.SanPham;

public class NhanVienDao {
	public boolean insert(NhanVien nv ) 
			throws Exception{
	
				String sql = "INSERT INTO dbo.NhanVien(MaNhanVien,HoTen,NgaySinh,DiaChi,SoDienThoai,Email,ChucVu)\r\n"
						+ "VALUES(?,?,?,?,?,?,?)";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setInt(1,nv.getMaNV());
					pstmt.setString(2,nv.getHoten());
					pstmt.setObject(3,nv.getNgaySinh());
					pstmt.setString(4,nv.getDiaChi());
					pstmt.setString(5,nv.getSoDienThoai());
					pstmt.setString(6, nv.getEmail());
					pstmt.setString(7, nv.getChucVu());
		return pstmt.executeUpdate()>0;
		}	
	}
	public boolean update(NhanVien nv ) 
			throws Exception{
		
	
				String sql = "UPDATE dbo.NhanVien"
						+ "				   SET HoTen=?,NgaySinh=?,DiaChi=?,SoDienThoai=?,Email=?,ChucVu=? "+" where MaNhanVien=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,nv.getHoten());
					pstmt.setObject(2,nv.getNgaySinh());
					pstmt.setString(3,nv.getDiaChi());
					pstmt.setString(4,nv.getSoDienThoai());
					pstmt.setString(5, nv.getEmail());
					pstmt.setString(6, nv.getChucVu());
					pstmt.setInt(7, nv.getMaNV());
		return pstmt.executeUpdate()>0;
		}	
	}
	public boolean delete(String maNV) 
			throws Exception{
				String sql = "delete from NhanVien "+"where MaNhanVien=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,maNV);
		return pstmt.executeUpdate()>0;
		}	
	}
	public boolean checkExist(String maNV) 
			throws Exception{
				String sql = "select *  from NhanVien "+"where MaNhanVien=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,maNV);
					ResultSet rs = pstmt.executeQuery();
		return rs.next();
		}	
	}
	public boolean checkExistNhanVien(String maNV) 
			throws Exception{
				String sql = "select *  from HoaDon "+"where MaNhanVien=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1,maNV);
					ResultSet rs = pstmt.executeQuery();
		return rs.next();
		}	
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
	
	
	public ArrayList<NhanVien> getListNhanVien(){
		ArrayList<NhanVien> list = new ArrayList<>();
		String sql = "SELECT * FROM NhanVien";
		try {
			Connection connection = Connect.openConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setMaNV(rs.getInt(1));
				nv.setHoten(rs.getString(2));
				nv.setNgaySinh(rs.getDate(3));
				nv.setDiaChi(rs.getString(4));
				nv.setSoDienThoai(rs.getString(5));
			nv.setEmail(rs.getString(6));
				nv.setChucVu(rs.getString(7));
				list.add(nv);
			}			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		}   


}
