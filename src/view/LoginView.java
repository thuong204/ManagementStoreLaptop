package view;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import Dao.TaiKhoanDao;
import Helper.Datavalidator;
import Helper.MessageDialogHelper;
import model.TaiKhoan;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTaiKhoan;
	private JPasswordField jTextFieldmatKhau;
	public LoginView() {
		    setForeground(new Color(192, 192, 192));
			this.setTitle("LOGIN");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 800, 488);
			contentPane = new JPanel();
			contentPane.setForeground(new Color(0, 255, 0));
			contentPane.setBackground(new Color(64, 128, 128));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				
			this.setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel labelTaiKhoan = new JLabel("Tài khoản");
			labelTaiKhoan.setForeground(new Color(0, 0, 0));
			labelTaiKhoan.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Administrator-icon.png"));
			labelTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 16));
			labelTaiKhoan.setBounds(404, 77, 193, 35);
			contentPane.add(labelTaiKhoan);
			
			textFieldTaiKhoan = new JTextField();
			textFieldTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textFieldTaiKhoan.setBounds(404, 123, 341, 33);
			contentPane.add(textFieldTaiKhoan);
			textFieldTaiKhoan.setColumns(10);
			
			JLabel lblMatKhau = new JLabel("Mật khẩu");
			lblMatKhau.setForeground(new Color(0, 0, 0));
			lblMatKhau.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Lock-Lock-icon.png"));
			lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblMatKhau.setBounds(404, 167, 129, 33);
			contentPane.add(lblMatKhau);
			
			JButton btnNewButtonDangNhap = new JButton("Đăng nhập");
			btnNewButtonDangNhap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					StringBuilder sb = new StringBuilder();
					Datavalidator.validateEmpty(textFieldTaiKhoan, sb, "Tên đăng nhập không được để trống");
					Datavalidator.validateEmpty(jTextFieldmatKhau, sb,"Mật khẩu không được để trống");
				
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, sb.toString(),"Lỗi");
					return;
				}
				TaiKhoanDao dao = new  TaiKhoanDao();
				try{
					TaiKhoan tk  = dao.checkLogin(textFieldTaiKhoan.getText(), new String(jTextFieldmatKhau.getPassword()));
				
					if(tk==null) {
							MessageDialogHelper.showErrorDialog(null,"Tên đăng nhập hoặc mật khẩu sai","Lỗi");
					}
					else { 
						 MessageDialogHelper.showMessageDialog(null, "Đăng nhập thành công","Thành công");
						 LoginView.this.dispose();
						 HomeView homeView = new HomeView();
						 homeView.setVisible(true);
						}
				}
				catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showErrorDialog(null,ex.getMessage(), "Lỗi");
				}
			}
	     }
	);
			btnNewButtonDangNhap.setForeground(new Color(0, 0, 0));

			btnNewButtonDangNhap.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\corrrect.png"));
	        btnNewButtonDangNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButtonDangNhap.setToolTipText("");
			btnNewButtonDangNhap.setBounds(404, 316, 159, 33);
			contentPane.add(btnNewButtonDangNhap);
				
			JButton btnThoat = new JButton("Thoát");
			btnThoat.setForeground(new Color(0, 0, 0));
			btnThoat.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
			});
			btnThoat.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\exit.png"));
			btnThoat.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnThoat.setBounds(589, 316, 159, 33);
			contentPane.add(btnThoat);
			
			jTextFieldmatKhau = new JPasswordField();
			jTextFieldmatKhau.setFont(new Font("Tahoma", Font.BOLD, 14));
			jTextFieldmatKhau.setBounds(404, 211, 341, 33);
			contentPane.add(jTextFieldmatKhau);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(399, 278, 346, 2);
			contentPane.add(separator);
			
			JLabel lblNewLabel_KYTHI = new JLabel("QUẢN LÍ  CỬA HÀNG BÁN ĐỒ ĐIỆN TỬ ");
			lblNewLabel_KYTHI.setForeground(new Color(0, 255, 64));
			lblNewLabel_KYTHI.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel_KYTHI.setBounds(108, -13, 595, 97);
			contentPane.add(lblNewLabel_KYTHI);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBackground(new Color(128, 128, 0));
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Prasilarts-Claire-Monitor-13-Computer-Blue-Ring.256.png"));
			lblNewLabel.setBounds(52, 95, 287, 272);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_TechNo = new JLabel("TECHNOLOGY");
			lblNewLabel_TechNo.setForeground(new Color(255, 128, 64));
			lblNewLabel_TechNo.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 44));
			lblNewLabel_TechNo.setBounds(28, 330, 366, 97);
			contentPane.add(lblNewLabel_TechNo);
			
			JLabel lblNewLabel_ChuaCo = new JLabel("Bạn chưa có tài khoản?");
			lblNewLabel_ChuaCo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_ChuaCo.setForeground(new Color(255, 255, 255));
			lblNewLabel_ChuaCo.setBounds(404, 394, 164, 32);
			contentPane.add(lblNewLabel_ChuaCo);
			
			JButton btnNewButtonDangKy = new JButton("Đăng ký");
			btnNewButtonDangKy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoginView.this.setVisible(false);
					RegisterView rg = new RegisterView();
					rg.setVisible(true);
				}
			});
			btnNewButtonDangKy.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Pictogrammers-Material-Account.32.png"));
			btnNewButtonDangKy.setToolTipText("");
			btnNewButtonDangKy.setForeground(Color.BLACK);
			btnNewButtonDangKy.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButtonDangKy.setBounds(586, 394, 144, 33);
			contentPane.add(btnNewButtonDangKy);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						LoginView frame = new LoginView();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

