package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Helper.Connect;
import model.TaiKhoan;

public class TaiKhoanDao {
	public TaiKhoan checkLogin(String tenDangNhap, String matKhau ) 
			throws Exception{
				String sql = "Select username,password from Login where username=? and password=?";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1, tenDangNhap);
					pstmt.setString(2, matKhau);
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()){
						TaiKhoan tk = new TaiKhoan();
						tk.setUsername(tenDangNhap);
						return tk;
					}
				}
			}
		return null;
		}	
	
	public TaiKhoan register(String username, String password) 
		throws Exception{
			String sql = "INSERT INTO Login(username,password) "
					   + "VALUES(?,?)";
			try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
					pstmt.setString(1, username);
					pstmt.setString(2, password);
					pstmt.executeUpdate();
					TaiKhoan tk = new TaiKhoan();
					tk.setUsername(username);
					return tk;
		}
	}

}

