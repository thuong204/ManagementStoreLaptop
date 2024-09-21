package view;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Dao.TaiKhoanDao;
import Helper.AccountValidation;
import Helper.CheckPasswordTrue;
import Helper.Datavalidator;
import Helper.MessageDialogHelper;
import model.TaiKhoan;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTK;
	private JPasswordField passwordField;
	private JPasswordField passwordField_NhapLaiMK;

	public RegisterView() {
		setForeground(new Color(192, 192, 192));
		this.setTitle("REGISTER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 427);
		
		getContentPane().setBackground(new Color(255, 128, 0));
		getContentPane().setForeground(new Color(64, 128, 128));
		setForeground(new Color(64, 128, 128));
		getContentPane().setLayout(null);
		
		JLabel labelTaiKhoan = new JLabel("Tài khoản");
		labelTaiKhoan.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Administrator-icon.png"));
		labelTaiKhoan.setForeground(Color.BLACK);
		labelTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelTaiKhoan.setBounds(36, 122, 158, 35);
		getContentPane().add(labelTaiKhoan);
		
		textFieldTK = new JTextField();
		textFieldTK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTK.setColumns(10);
		textFieldTK.setBounds(241, 123, 215, 33);
		getContentPane().add(textFieldTK);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Lock-Lock-icon.png"));
		lblMatKhau.setForeground(Color.BLACK);
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMatKhau.setBounds(33, 168, 128, 33);
		getContentPane().add(lblMatKhau);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(241, 168, 215, 33);
		getContentPane().add(passwordField);
		
		JLabel lblNhpLiMt = new JLabel("Nhập lại mật khẩu");
		lblNhpLiMt.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Lock-Lock-icon.png"));
		lblNhpLiMt.setForeground(Color.BLACK);
		lblNhpLiMt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNhpLiMt.setBounds(33, 212, 221, 33);
		getContentPane().add(lblNhpLiMt);
		
		passwordField_NhapLaiMK = new JPasswordField();
		passwordField_NhapLaiMK.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField_NhapLaiMK.setBounds(241, 212, 215, 33);
		getContentPane().add(passwordField_NhapLaiMK);
		
		JButton btnNewButtonDangKy = new JButton("Đăng ký");
		btnNewButtonDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			StringBuilder sb = new StringBuilder();
			Datavalidator.validateEmpty(textFieldTK, sb, "Tên đăng nhập không được để trống");
			Datavalidator.validateEmpty(passwordField, sb,"Mật khẩu không được để trống");	
			if(sb.length()>0) {
				MessageDialogHelper.showErrorDialog(null, sb.toString(), "Lỗi");
				return;
			}
			TaiKhoanDao dao = new  TaiKhoanDao();
			AccountValidation ac = new AccountValidation();
			try{
				Boolean kt = ac.validate(textFieldTK.getText());
				Boolean kt2 = ac.validate(String.valueOf(passwordField.getPassword()));
				if(!kt2) {
					MessageDialogHelper.showErrorDialog(null,"Mật khẩu cần phải có chữ và số và ít nhất 10 kí tự", "Lỗi");
					return;
				}
				if(!kt) {
					MessageDialogHelper.showErrorDialog(null,"Tên đăng nhập cần phải có chữ và số và ít nhất 10 kí tự", "Lỗi");
					return;
				}
				
				CheckPasswordTrue check = new CheckPasswordTrue();
				if(!check.checkPass(passwordField.getPassword(),passwordField_NhapLaiMK.getPassword())) {
					MessageDialogHelper.showErrorDialog(null, "Mật khẩu nhập chưa chính xác!Vui lòng nhập lại", "Lỗi");
					return;
				}
				
				TaiKhoan tk  = dao.register(textFieldTK.getText(), new String(passwordField.getPassword()));
				
				if(tk==null) {
						MessageDialogHelper.showErrorDialog(null,"Đăng kí không thành công","Lỗi");
				}
				else { 
					 MessageDialogHelper.showMessageDialog(null, "Đăng kí thành công","Thành công");
					 RegisterView.this.dispose();
					 LoginView lgView = new LoginView();
					 lgView.setVisible(true);
					}
			}
			catch(Exception ex) {
				ex.printStackTrace();
				MessageDialogHelper.showErrorDialog(null,ex.getMessage(), "Lỗi");
			}
		}
});
		btnNewButtonDangKy.setBackground(new Color(255, 255, 255));
		btnNewButtonDangKy.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Pictogrammers-Material-Account.32.png"));
		btnNewButtonDangKy.setToolTipText("");
		btnNewButtonDangKy.setForeground(Color.BLACK);
		btnNewButtonDangKy.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButtonDangKy.setBounds(318, 270, 141, 33);
		getContentPane().add(btnNewButtonDangKy);
		
		JLabel lblNewLabel_TK = new JLabel("Bạn đã có có tài khoản?");
		lblNewLabel_TK.setForeground(Color.WHITE);
		lblNewLabel_TK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_TK.setBounds(36, 333, 240, 32);
		getContentPane().add(lblNewLabel_TK);
		
		JButton btnNewButtonDangNhap = new JButton("Đăng nhập ngay");
		btnNewButtonDangNhap.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\corrrect.png"));
		btnNewButtonDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterView.this.setVisible(false);
				LoginView lg = new LoginView();
				lg.setVisible(true);
			}
		});
		btnNewButtonDangNhap.setToolTipText("");
		btnNewButtonDangNhap.setForeground(Color.BLACK);
		btnNewButtonDangNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButtonDangNhap.setBounds(250, 333, 206, 33);
		getContentPane().add(btnNewButtonDangNhap);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG KÍ TÀI KHOẢN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(119, 38, 378, 63);
		getContentPane().add(lblNewLabel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
}

