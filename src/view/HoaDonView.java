package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.HoaDon;

import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import java.awt.SystemColor;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JSpinner;
import javax.swing.DropMode;
import javax.swing.JButton;

public class HoaDonView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMaHD;
	private JTextField textField_MaKH;
	private JTextField textField_MaNV;
	private JTextField textField_TenSP;
	private JTextField textField_SoLuong;
	private JTextField textField_DonGia;
	private JTextField textFieldThanhTien;
	private JSpinner spinnerNgayDatHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDonView frame = new HoaDonView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HoaDonView() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 489);
		this.setLocationRelativeTo(null);
		this.setTitle("Hóa Đơn");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label labelHoaDon = new Label("HÓA ĐƠN BÁN HÀNG");
		labelHoaDon.setForeground(new Color(255, 0, 0));
		labelHoaDon.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelHoaDon.setBounds(167, 11, 440, 47);
		contentPane.add(labelHoaDon);
		
		JLabel lblNewLabel_DiaChi = new JLabel("Địa Chỉ: Phường Hòa Quý, quận Ngũ Hành Sơn, Đà Nẵng");
		lblNewLabel_DiaChi.setForeground(new Color(0, 0, 0));
		lblNewLabel_DiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_DiaChi.setBounds(89, 64, 519, 42);
		contentPane.add(lblNewLabel_DiaChi);
		
		JLabel lblNewSDT = new JLabel("Số điện thoại: 0123456789     Email: rgb@gmail.com");
		lblNewSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewSDT.setBounds(89, 101, 417, 34);
		contentPane.add(lblNewSDT);
		
		Panel panel = new Panel();
		panel.setBounds(76, 141, 448, 301);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_MaHoaDon = new JLabel("Mã Hóa Đơn");
		lblNewLabel_MaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_MaHoaDon.setBounds(10, 25, 84, 19);
		panel.add(lblNewLabel_MaHoaDon);
		
		JLabel lblNewLabel_MaKH = new JLabel("Mã Khách Hàng");
		lblNewLabel_MaKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_MaKH.setBounds(10, 57, 107, 19);
		panel.add(lblNewLabel_MaKH);
		
		JLabel lblNewLabel_MaNV = new JLabel("Mã Nhân Viên");
		lblNewLabel_MaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_MaNV.setBounds(10, 87, 94, 19);
		panel.add(lblNewLabel_MaNV);
		
		JLabel lblNewLabelTenSP = new JLabel("Tên Sản Phẩm");
		lblNewLabelTenSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabelTenSP.setBounds(10, 121, 98, 19);
		panel.add(lblNewLabelTenSP);
		
		JLabel lblNewLabelSoLuong = new JLabel("Số Lượng");
		lblNewLabelSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabelSoLuong.setBounds(10, 151, 64, 19);
		panel.add(lblNewLabelSoLuong);
		
		JLabel lblNewLabelDonGia = new JLabel("Đơn giá");
		lblNewLabelDonGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabelDonGia.setBounds(10, 187, 53, 19);
		panel.add(lblNewLabelDonGia);
		
		JLabel lblNewLabel_ThanhTien = new JLabel("Thành tiền");
		lblNewLabel_ThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_ThanhTien.setBounds(10, 266, 128, 25);
		panel.add(lblNewLabel_ThanhTien);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 253, 428, 2);
		panel.add(separator);
		
		textFieldMaHD = new JTextField();
		textFieldMaHD.setEditable(false);
		textFieldMaHD.setBackground(SystemColor.menu);
		textFieldMaHD.setBounds(134, 26, 96, 20);
		panel.add(textFieldMaHD);
		textFieldMaHD.setColumns(10);
		
		textField_MaKH = new JTextField();
		textField_MaKH.setEditable(false);
		textField_MaKH.setColumns(10);
		textField_MaKH.setBackground(SystemColor.menu);
		textField_MaKH.setBounds(134, 58, 96, 20);
		panel.add(textField_MaKH);
		
		textField_MaNV = new JTextField();
		textField_MaNV.setEditable(false);
		textField_MaNV.setColumns(10);
		textField_MaNV.setBackground(SystemColor.menu);
		textField_MaNV.setBounds(134, 88, 96, 20);
		panel.add(textField_MaNV);
		
		textField_TenSP = new JTextField();
		textField_TenSP.setEditable(false);
		textField_TenSP.setColumns(10);
		textField_TenSP.setBackground(SystemColor.menu);
		textField_TenSP.setBounds(134, 120, 304, 20);
		panel.add(textField_TenSP);
		
		textField_SoLuong = new JTextField();
		textField_SoLuong.setEditable(false);
		textField_SoLuong.setColumns(10);
		textField_SoLuong.setBackground(SystemColor.menu);
		textField_SoLuong.setBounds(134, 152, 96, 20);
		panel.add(textField_SoLuong);
		
		textField_DonGia = new JTextField();
		textField_DonGia.setEditable(false);
		textField_DonGia.setColumns(10);
		textField_DonGia.setBackground(SystemColor.menu);
		textField_DonGia.setBounds(134, 188, 96, 20);
		panel.add(textField_DonGia);
		
		textFieldThanhTien = new JTextField();
		textFieldThanhTien.setEditable(false);
		textFieldThanhTien.setBounds(134, 270, 169, 20);
		panel.add(textFieldThanhTien);
		textFieldThanhTien.setColumns(10);
		
		JLabel lblNewLabelNgayDatHang = new JLabel("Ngày Đặt Hàng");
		lblNewLabelNgayDatHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabelNgayDatHang.setBounds(10, 218, 107, 19);
		panel.add(lblNewLabelNgayDatHang);
		
		Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        SpinnerDateModel model = new SpinnerDateModel(today, null, null, Calendar.DAY_OF_MONTH);
        spinnerNgayDatHang = new JSpinner(model);
		
		
		spinnerNgayDatHang.setBackground(SystemColor.menu);
		spinnerNgayDatHang.setBounds(134, 219, 128, 25);
		panel.add(spinnerNgayDatHang);
		
		JButton btnNewButtonprint = new JButton("Print");
		btnNewButtonprint.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButtonprint.setBackground(new Color(255, 0, 0));
		btnNewButtonprint.setForeground(new Color(0, 0, 0));
		btnNewButtonprint.setBounds(349, 260, 89, 32);
		panel.add(btnNewButtonprint);
	}
	public void inHoaDon(HoaDon hd) {
		textFieldMaHD.setText(Integer.toString(hd.getMaHoaDon()));
		textField_MaNV.setText(Integer.toString(hd.getMaNhanVien()));
		textField_MaKH.setText(Integer.toString(hd.getMaKhachHang()));
		textField_TenSP.setText(hd.getTenSP());
		textField_SoLuong.setText(Integer.toString(hd.getSoLuong()));
		textField_DonGia.setText(Double.toString(hd.getDonGia()));
		LocalDateTime localDateTime = hd.getNgayDatHang();
		Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

		SpinnerDateModel spinnerModel = new SpinnerDateModel(date, null, null, Calendar.DAY_OF_MONTH);
		spinnerNgayDatHang.setModel(spinnerModel);
		
		textFieldThanhTien.setText(Double.toString(hd.getTongTien()));
	}
}
