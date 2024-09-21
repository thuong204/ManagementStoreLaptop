package view;

import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import Dao.HoaDonDao;
import Dao.KhachHangDao;
import Dao.NhanVienDao;
import Dao.SanPhamDao;
import Dao.ThongKeDao;
import Helper.Datavalidator;
import Helper.InHoaDon;
import Helper.MessageDialogHelper;
import model.HoaDon;
import model.KhachHang;
import model.NhanVien;
import model.SanPham;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SpinnerDateModel;

import javax.swing.JFormattedTextField.AbstractFormatter;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class HomeView extends JFrame {

	private JPanel contentPane;
	private JTable tableHoaDon;
	private JTextField textFieldMaHD;
	private JTextField textFieldMaNV;
	private JTextField textField_MaKH;
	public static JTextField textField_TenSP;
	public static JTextField textField_SoLuong;
	private JTextField textField_TimKiem;
	private JTextField textFieldDonGia;
	private ArrayList<HoaDon> listHoaDon;
	private ArrayList<SanPham> listSP;
	private ArrayList<NhanVien> listNV;
	private ArrayList<KhachHang> listKH;
	public int countThayDoi = 0;
	
	private DefaultTableModel modelTHoaDon;
	public static DefaultTableModel modelSanPham;
	private DefaultTableModel modelNhanVien;
	private DefaultTableModel modelKhachHang;
	
	private JSpinner spinnerNgayDatHang;
	private JFreeChart gt;
	private JPanel panel_ThongKe;
	private ChartPanel chartPanel_1;
	private JTabbedPane tabbedPane;
	private JTable tableSanPham;
	private JTextField textFieldSP;
	private JTextField textFieldDonGiaSP;
	private JTextField textFieldNganhHang;
	private JTextField textFieldSoLuongSP;
	private JTextField textFieldMauSac;
	private JTextField textFieldCauHinh;
	private JTextField textFieldTimKiemSP;
	private JTable tableNhanVien;
	private JTextField textFieldManv;
	private JTextField textFieldHotenNV;
	private JTextField textFieldNgaySinh;
	private JTextField textFieldDiaChi;
	private JTextField textFieldSoDT;
	private JTextField textFieldEmail;
	private JTextField textFieldChucVu;
	private JTextField textFieldTimKiemNV;
	private JTextField textFieldTimKiemKH;
	private JTextField textFieldMaKH;
	private JTextField textFieldTenKH;
	private JTextField textFieldDiaChiKh;
	private JTextField textFieldSDTKH;
	private JTextField textFieldEmailKH;
	private JTable tableKhachHang;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView frame = new HomeView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public HomeView() throws Exception {
		this.setTitle("Trang chủ quản lí Cửa hàng Bán Đồ điện tử");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1295, 659);
		this.setExtendedState(MAXIMIZED_BOTH);
		tabbedPane = new JTabbedPane();
		tabbedPane.setBorder(new CompoundBorder());
	    JPanel panel_NV = new JPanel();
	    panel_NV.setBackground(new Color(192, 192, 192));
	    panel_NV.setForeground(new Color(128, 128, 128));
	    JPanel panel_KH = new JPanel();
	    panel_KH.setBackground(new Color(192, 192, 192));
	    panel_KH.setForeground(new Color(128, 128, 128));
	    panel_ThongKe = new JPanel();
	   
	    JPanel panel_SP = new JPanel();
	    panel_SP.setBackground(new Color(192, 192, 192));
	    
	    tabbedPane.addTab("Sản Phẩm", panel_SP);
	    tabbedPane.setIconAt(0, new ImageIcon("D:\\Icon\\iclap.png"));
	    panel_SP.setLayout(null);
	    JScrollPane scrollPaneSP = new JScrollPane();
	    scrollPaneSP.setBounds(59, 94, 1046, 202);
	    panel_SP.add(scrollPaneSP);
	    
	    
	    
	    tableSanPham = new JTable();
	    tableSanPham.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		int row = tableSanPham.getSelectedRow();
				TableModel model = tableSanPham.getModel();
				textFieldSP.setText(modelSanPham.getValueAt(row, 0)+"");
				textFieldSP.setEditable(false);
				textFieldDonGiaSP.setText(modelSanPham.getValueAt(row, 1)+"");
				textFieldSoLuongSP.setText(modelSanPham.getValueAt(row, 2)+"");
				textFieldNganhHang.setText(modelSanPham.getValueAt(row, 3)+"");
				textFieldMauSac.setText(modelSanPham.getValueAt(row, 4)+"");
				textFieldCauHinh.setText(modelSanPham.getValueAt(row, 5)+"");
	    	}
	    });
	    tableSanPham.setModel(new DefaultTableModel(
	    	new Object[][] {
	    	},
	    	new String[] {
	    		"T\u00EAn S\u1EA3n Ph\u1EA9m", "\u0110\u01A1n Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng", "Ng\u00E0nh H\u00E0ng", "M\u00E0u S\u1EAFc", "C\u1EA5u H\u00ECnh"
	    	}
	    ) {
	    	boolean[] columnEditables = new boolean[] {
	    		false, false, false, false, false, false
	    	};
	    	public boolean isCellEditable(int row, int column) {
	    		return columnEditables[column];
	    	}
	    });
	    tableSanPham.getColumnModel().getColumn(0).setPreferredWidth(309);
	    tableSanPham.getColumnModel().getColumn(2).setResizable(false);
	    tableSanPham.getColumnModel().getColumn(3).setPreferredWidth(202);
	    tableSanPham.getColumnModel().getColumn(4).setPreferredWidth(90);
	    tableSanPham.getColumnModel().getColumn(5).setPreferredWidth(275);
	    scrollPaneSP.setViewportView(tableSanPham);
	    
	    JLabel lblNewLabel_ThongTinHD_1 = new JLabel("THÔNG TIN SẢN PHẨM");
	    lblNewLabel_ThongTinHD_1.setForeground(new Color(128, 128, 0));
	    lblNewLabel_ThongTinHD_1.setFont(new Font("Tahoma", Font.BOLD, 30));
	    lblNewLabel_ThongTinHD_1.setBounds(363, 11, 383, 72);
	    panel_SP.add(lblNewLabel_ThongTinHD_1);
	    
	    JPanel panel_ChucNang = new JPanel();
	    panel_ChucNang.setLayout(null);
	    panel_ChucNang.setBackground(new Color(0, 128, 192));
	    panel_ChucNang.setBounds(906, 331, 186, 215);
	    panel_SP.add(panel_ChucNang);
	    
	    JButton btnNewButtonLuuSP = new JButton("Lưu");
	    btnNewButtonLuuSP.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
	    		StringBuilder sb = new StringBuilder();
				Datavalidator.validateEmpty(textFieldSP, sb, "Tên sản phẩm không được để trống");
				Datavalidator.validateEmpty(textFieldDonGiaSP, sb, "Đơn giá không được để trống");
				Datavalidator.validateEmpty(textFieldSoLuongSP, sb, "Số lượng không được để trống");
				Datavalidator.validateEmpty(textFieldCauHinh, sb, "Cấu hình không được trống");
				Datavalidator.validateEmpty(textFieldMauSac, sb, "Màu sắc không được trống");
				Datavalidator.validateEmpty(textFieldNganhHang, sb, "Ngành hàng không được để trống");
				
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, "Bạn cần điền đầy đủ thông tin", "Lỗi");
					return;
				}
				try {
					SanPham sp = new SanPham();
					sp.setTenSP(textFieldSP.getText());
					sp.setSoLuong(Integer.parseInt(textFieldSoLuongSP.getText()));
					sp.setDonGia(Float.parseFloat(textFieldDonGiaSP.getText()));
					sp.setCauHinh(textFieldCauHinh.getText());
					sp.setMauSac(textFieldMauSac.getText());
					sp.setNganhHang(textFieldNganhHang.getText());
					
					SanPhamDao spDao = new SanPhamDao();
					if(spDao.checkExist(textFieldSP.getText())) {
						MessageDialogHelper.showMessageDialog(null,"Tên sản phẩm đã tồn tại","Thông báo");
						return;
					}
					if(spDao.insert(sp)) {
						MessageDialogHelper.showMessageDialog(null,"Sản phẩm đã được lưu", "Thông báo");
						listSP.add(sp);
						
					}
					else {
						MessageDialogHelper.showConfirmDialog(null, "Sản phẩm chưa được lưu","Cảnh báo");
					}
					showResultSanPham();
				}
			catch(Exception ex) {
				ex.printStackTrace();
				MessageDialogHelper.showErrorDialog(null,ex.getMessage(),"Lỗi" );
				}				
			}	
	    		
	    });
	    btnNewButtonLuuSP.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Save-as-icon.png"));
	    btnNewButtonLuuSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonLuuSP.setBackground(Color.WHITE);
	    btnNewButtonLuuSP.setBounds(27, 70, 129, 33);
	    panel_ChucNang.add(btnNewButtonLuuSP);
	    
	    JButton btnNewButtonCapNhatSP = new JButton("Cập nhật");
	    btnNewButtonCapNhatSP.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {

	    		StringBuilder sb = new StringBuilder();
				Datavalidator.validateEmpty(textFieldSP, sb, "Tên sản phẩm  không được để trống");
				Datavalidator.validateEmpty(textFieldDonGiaSP, sb, "Đơn giá không được để trống");
				Datavalidator.validateEmpty(textFieldSoLuongSP, sb, "Số lương sản phẩm không được để trống");
				Datavalidator.validateEmpty(textFieldCauHinh, sb, "Cấu hình không được trống");
				Datavalidator.validateEmpty(textFieldMauSac, sb, "Màu sắc không được trống");
				Datavalidator.validateEmpty(textFieldNganhHang, sb, "Ngành hàng không được để trống");
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, "Bạn cần điền đầy đủ thông tin", "Lỗi");
					return;
				}
				if(MessageDialogHelper.showConfirmDialog(null, "Bạn có muốn cập nhật sản phẩm hay không?", "Hỏi")==JOptionPane.NO_OPTION){
					return;
				}
				try {
					int selectedIndex =tableSanPham.getSelectedRow();
					if(selectedIndex<0) {
						MessageDialogHelper.showErrorDialog(null, "Vui lòng chọn vị trí cập nhật trên bảng", "Lỗi");
						return;
					}
					listSP.remove(selectedIndex);
					SanPham sp = new SanPham();
					sp.setTenSP(textFieldSP.getText());
					sp.setSoLuong(Integer.parseInt(textFieldSoLuongSP.getText()));
					sp.setDonGia(Float.parseFloat(textFieldDonGiaSP.getText()));
					sp.setCauHinh(textFieldCauHinh.getText());
					sp.setMauSac(textFieldMauSac.getText());
					sp.setNganhHang(textFieldNganhHang.getText());
					
					SanPhamDao spDao = new SanPhamDao();
					
					if(spDao.update(sp)) {
						MessageDialogHelper.showMessageDialog(null,"Sản phẩm đã được cập nhật", "Thông báo");
						listSP.add(sp);
						showResultSanPham();//show lại bảng sau khi thêm
					}
					else {
						MessageDialogHelper.showConfirmDialog(null, "Sản phẩm chưa được cập nhật","Cảnh báo");
					}
				}
			catch(Exception ex) {
				ex.printStackTrace();
				MessageDialogHelper.showErrorDialog(null,ex.getMessage(),"Lỗi" );
				}				
			}			
	    });
	    btnNewButtonCapNhatSP.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Document-write-icon (1).png"));
	    btnNewButtonCapNhatSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonCapNhatSP.setBackground(Color.WHITE);
	    btnNewButtonCapNhatSP.setBounds(27, 114, 129, 33);
	    panel_ChucNang.add(btnNewButtonCapNhatSP);
	    
	    JButton btnNewButtonXoaSP = new JButton("Xóa");
	    btnNewButtonXoaSP.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		StringBuilder sb = new StringBuilder();
				Datavalidator.validateEmpty(textFieldSP, sb, "Tên sản phẩm không được để trống");
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, sb.toString(), "Lỗi");
					return;
				}
				if(MessageDialogHelper.showConfirmDialog(null, "Bạn có muốn xóa sản phẩm hay không?", "Hỏi")==JOptionPane.NO_OPTION){
					return;
				}
					try {
						
						SanPhamDao spDao = new SanPhamDao();
						if(spDao.checkExistSanPham(textFieldSP.getText())) {
							MessageDialogHelper.showErrorDialog(null, "Sản phẩm không được xóa do đã tồn tại trên Hóa đơn", "Thông báo");
							return;
						}
						
						if(spDao.delete(textFieldSP.getText())) {
							int selectedIndex = tableSanPham.getSelectedRow();
							listSP.remove(selectedIndex);
							showDataSanPham();
							MessageDialogHelper.showMessageDialog(null, "Sản phâm đã được xóa", "Thông báo");
						}
						else {
							MessageDialogHelper.showMessageDialog(null, "Sản phẩm không được xóa do không tồn tại","Cảnh báo");
						}
				}
				catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showErrorDialog(null,ex.getMessage(),"Lỗi" );
					}				
	    	}
	    });
	    btnNewButtonXoaSP.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Delete-icon (1).png"));
	    btnNewButtonXoaSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonXoaSP.setBackground(Color.WHITE);
	    btnNewButtonXoaSP.setBounds(27, 158, 129, 33);
	    panel_ChucNang.add(btnNewButtonXoaSP);
	    
	    JButton btnNewButtonTaoMoiSp = new JButton("Tạo mới");
	    btnNewButtonTaoMoiSp.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\New-file-icon.png"));
	    btnNewButtonTaoMoiSp.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		textFieldSP.setText("");
	    		textFieldSP.setEditable(true);
				textFieldSoLuongSP.setText("");
				textFieldMauSac.setText("");
				textFieldNganhHang.setText("");
				textFieldDonGiaSP.setText("");
				textFieldCauHinh.setText("");
	    	}
	    });
	    
	    listSP= new SanPhamDao().getListSanPham();
	    modelSanPham= (DefaultTableModel) tableSanPham.getModel();
	    showTableSanPham();
	    
	    
	    btnNewButtonTaoMoiSp.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonTaoMoiSp.setBackground(Color.WHITE);
	    btnNewButtonTaoMoiSp.setBounds(27, 24, 129, 33);
	    panel_ChucNang.add(btnNewButtonTaoMoiSp);
	    
	    JLabel lblNewLabeltenSP = new JLabel("Tên Sản Phẩm");
	    lblNewLabeltenSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabeltenSP.setBounds(70, 323, 122, 47);
	    panel_SP.add(lblNewLabeltenSP);
	    
	    textFieldSP = new JTextField();
	    textFieldSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldSP.setColumns(10);
	    textFieldSP.setBackground(Color.WHITE);
	    textFieldSP.setBounds(220, 331, 348, 29);
	    panel_SP.add(textFieldSP);
	    
	    JLabel lblNewLabelDonGia = new JLabel("Đơn Giá");
	    lblNewLabelDonGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabelDonGia.setBounds(637, 367, 122, 47);
	    panel_SP.add(lblNewLabelDonGia);
	    
	    textFieldDonGiaSP = new JTextField();
	    textFieldDonGiaSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldDonGiaSP.setColumns(10);
	    textFieldDonGiaSP.setBackground(Color.WHITE);
	    textFieldDonGiaSP.setBounds(725, 376, 100, 29);
	    panel_SP.add(textFieldDonGiaSP);
	    
	    JLabel lblNewLabeltenSP_1_1 = new JLabel("Ngành Hàng");
	    lblNewLabeltenSP_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabeltenSP_1_1.setBounds(70, 367, 122, 47);
	    panel_SP.add(lblNewLabeltenSP_1_1);
	    
	    textFieldNganhHang = new JTextField();
	    textFieldNganhHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldNganhHang.setColumns(10);
	    textFieldNganhHang.setBackground(Color.WHITE);
	    textFieldNganhHang.setBounds(220, 376, 348, 29);
	    panel_SP.add(textFieldNganhHang);
	    
	    JLabel lblNewLabeltenSP_1_1_1 = new JLabel("Số Lượng");
	    lblNewLabeltenSP_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabeltenSP_1_1_1.setBounds(637, 416, 122, 47);
	    panel_SP.add(lblNewLabeltenSP_1_1_1);
	    
	    textFieldSoLuongSP = new JTextField();
	    textFieldSoLuongSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldSoLuongSP.setColumns(10);
	    textFieldSoLuongSP.setBackground(Color.WHITE);
	    textFieldSoLuongSP.setBounds(725, 425, 100, 29);
	    panel_SP.add(textFieldSoLuongSP);
	    
	    JLabel lblNewLabelMauSac = new JLabel("Màu Sắc");
	    lblNewLabelMauSac.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabelMauSac.setBounds(637, 323, 122, 47);
	    panel_SP.add(lblNewLabelMauSac);
	    
	    textFieldMauSac = new JTextField();
	    textFieldMauSac.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldMauSac.setColumns(10);
	    textFieldMauSac.setBackground(Color.WHITE);
	    textFieldMauSac.setBounds(725, 332, 100, 29);
	    panel_SP.add(textFieldMauSac);
	    
	    JLabel lblNewLabelCauHinh = new JLabel("Cấu Hình");
	    lblNewLabelCauHinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabelCauHinh.setBounds(70, 416, 122, 47);
	    panel_SP.add(lblNewLabelCauHinh);
	    
	    textFieldCauHinh = new JTextField();
	    textFieldCauHinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldCauHinh.setColumns(10);
	    textFieldCauHinh.setBackground(Color.WHITE);
	    textFieldCauHinh.setBounds(219, 425, 348, 29);
	    panel_SP.add(textFieldCauHinh);
	    
	    textFieldTimKiemSP = new JTextField();
	    textFieldTimKiemSP.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyReleased(KeyEvent e) {
	    		String str = textFieldTimKiemSP.getText();
				DefaultTableModel model =(DefaultTableModel) tableSanPham.getModel();
				TableRowSorter<DefaultTableModel> rts = new TableRowSorter<DefaultTableModel>(model);
				tableSanPham.setRowSorter(rts);
				rts.setRowFilter(RowFilter.regexFilter(str));
	    	}
	    });
	    textFieldTimKiemSP.setColumns(10);
	    textFieldTimKiemSP.setBounds(218, 506, 203, 43);
	    panel_SP.add(textFieldTimKiemSP);
	    
	    JLabel lblNewLabelTimKiem = new JLabel("Tìm kiếm");
	    lblNewLabelTimKiem.setForeground(Color.RED);
	    lblNewLabelTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblNewLabelTimKiem.setBackground(Color.BLACK);
	    lblNewLabelTimKiem.setBounds(68, 503, 113, 47);
	    panel_SP.add(lblNewLabelTimKiem);
	    
	    JButton btnNewButtonRefresh = new JButton("REFRESH");
	    btnNewButtonRefresh.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
					new HomeView();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
	    btnNewButtonRefresh.setForeground(new Color(255, 0, 0));
	    btnNewButtonRefresh.setBounds(622, 516, 110, 33);
	    panel_SP.add(btnNewButtonRefresh);

	    tabbedPane.addTab("Nhân Viên", panel_NV);
	    panel_NV.setLayout(null);
	    
	    JScrollPane scrollPaneNhanVien = new JScrollPane();
	    scrollPaneNhanVien.setBounds(56, 118, 1046, 202);
	    panel_NV.add(scrollPaneNhanVien);
	    
	    tableNhanVien = new JTable();
	    tableNhanVien.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		int row = tableNhanVien.getSelectedRow();
				TableModel model = tableNhanVien.getModel();
				textFieldManv.setText(modelNhanVien.getValueAt(row, 0)+"");
				textFieldManv.setEditable(false);
				textFieldHotenNV.setText(modelNhanVien.getValueAt(row, 1)+"");
				textFieldNgaySinh.setText(modelNhanVien.getValueAt(row, 2)+"");
				textFieldDiaChi.setText(modelNhanVien.getValueAt(row, 3)+"");
				textFieldSoDT.setText(modelNhanVien.getValueAt(row, 4)+"");
				textFieldEmail.setText(modelNhanVien.getValueAt(row, 5)+"");
				textFieldChucVu.setText(modelNhanVien.getValueAt(row, 6)+"");
	    	}
	    });
	    tableNhanVien.setModel(new DefaultTableModel(
	    	new Object[][] {
	    	},
	    	new String[] {
	    		"M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "Ng\u00E0y sinh", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Email", "Ch\u1EE9c v\u1EE5"
	    	}
	    ) {
	    	boolean[] columnEditables = new boolean[] {
	    		false, false, false, false, false, false, false
	    	};
	    	public boolean isCellEditable(int row, int column) {
	    		return columnEditables[column];
	    	}
	    });
	    tableNhanVien.getColumnModel().getColumn(0).setResizable(false);
	    tableNhanVien.getColumnModel().getColumn(0).setPreferredWidth(80);
	    tableNhanVien.getColumnModel().getColumn(1).setResizable(false);
	    tableNhanVien.getColumnModel().getColumn(1).setPreferredWidth(114);
	    tableNhanVien.getColumnModel().getColumn(2).setResizable(false);
	    tableNhanVien.getColumnModel().getColumn(2).setPreferredWidth(97);
	    tableNhanVien.getColumnModel().getColumn(3).setResizable(false);
	    tableNhanVien.getColumnModel().getColumn(3).setPreferredWidth(203);
	    tableNhanVien.getColumnModel().getColumn(4).setResizable(false);
	    tableNhanVien.getColumnModel().getColumn(4).setPreferredWidth(88);
	    tableNhanVien.getColumnModel().getColumn(5).setResizable(false);
	    tableNhanVien.getColumnModel().getColumn(5).setPreferredWidth(153);
	    tableNhanVien.getColumnModel().getColumn(6).setResizable(false);
	    tableNhanVien.getColumnModel().getColumn(6).setPreferredWidth(180);
	    scrollPaneNhanVien.setViewportView(tableNhanVien);
	    
	    JLabel lblNewLabelMaNV = new JLabel("Mã Nhân Viên");
	    lblNewLabelMaNV.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblNewLabelMaNV.setToolTipText("");
	    lblNewLabelMaNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabelMaNV.setBounds(56, 362, 122, 47);
	    panel_NV.add(lblNewLabelMaNV);
	    
	    textFieldManv = new JTextField();
	    textFieldManv.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldManv.setColumns(10);
	    textFieldManv.setBackground(Color.WHITE);
	    textFieldManv.setBounds(206, 370, 203, 29);
	    panel_NV.add(textFieldManv);
	    
	    JLabel lblNewLabelHoten = new JLabel("Họ và tên");
	    lblNewLabelHoten.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblNewLabelHoten.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabelHoten.setBounds(56, 410, 122, 47);
	    panel_NV.add(lblNewLabelHoten);
	    
	    textFieldHotenNV = new JTextField();
	    textFieldHotenNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldHotenNV.setColumns(10);
	    textFieldHotenNV.setBackground(Color.WHITE);
	    textFieldHotenNV.setBounds(206, 418, 203, 29);
	    panel_NV.add(textFieldHotenNV);
	    
	    JLabel lblNgaySinh = new JLabel("Ngày sinh");
	    lblNgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNgaySinh.setBounds(56, 458, 122, 47);
	    panel_NV.add(lblNgaySinh);
	    
	    textFieldNgaySinh = new JTextField();
	    textFieldNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldNgaySinh.setColumns(10);
	    textFieldNgaySinh.setBackground(Color.WHITE);
	    textFieldNgaySinh.setBounds(206, 466, 203, 29);
	    panel_NV.add(textFieldNgaySinh);
	    
	    JLabel lblDiaChi = new JLabel("Địa chỉ");
	    lblDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblDiaChi.setBounds(56, 506, 122, 47);
	    panel_NV.add(lblDiaChi);
	    
	    textFieldDiaChi = new JTextField();
	    textFieldDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldDiaChi.setColumns(10);
	    textFieldDiaChi.setBackground(Color.WHITE);
	    textFieldDiaChi.setBounds(206, 514, 398, 29);
	    panel_NV.add(textFieldDiaChi);
	    
	    JLabel lblSDT = new JLabel("Số điện thoại");
	    lblSDT.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblSDT.setBounds(482, 362, 122, 47);
	    panel_NV.add(lblSDT);
	    
	    textFieldSoDT = new JTextField();
	    textFieldSoDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldSoDT.setColumns(10);
	    textFieldSoDT.setBackground(Color.WHITE);
	    textFieldSoDT.setBounds(632, 370, 203, 29);
	    panel_NV.add(textFieldSoDT);
	    
	    JLabel lblNewLabelEmail = new JLabel("Email");
	    lblNewLabelEmail.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblNewLabelEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabelEmail.setBounds(482, 410, 122, 47);
	    panel_NV.add(lblNewLabelEmail);
	    
	    textFieldEmail = new JTextField();
	    textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldEmail.setColumns(10);
	    textFieldEmail.setBackground(Color.WHITE);
	    textFieldEmail.setBounds(632, 418, 203, 29);
	    panel_NV.add(textFieldEmail);
	    
	    JLabel lblNewLabelChucVu = new JLabel("Chức vụ");
	    lblNewLabelChucVu.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblNewLabelChucVu.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabelChucVu.setBounds(482, 458, 122, 47);
	    panel_NV.add(lblNewLabelChucVu);
	    
	    textFieldChucVu = new JTextField();
	    textFieldChucVu.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldChucVu.setColumns(10);
	    textFieldChucVu.setBackground(Color.WHITE);
	    textFieldChucVu.setBounds(632, 466, 203, 29);
	    panel_NV.add(textFieldChucVu);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setLayout(null);
	    panel_1.setBackground(new Color(0, 128, 192));
	    panel_1.setBounds(936, 362, 146, 173);
	    panel_NV.add(panel_1);
	    
	    JButton btnNewButtonLuuNV = new JButton("Lưu");
	    btnNewButtonLuuNV.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		StringBuilder sb = new StringBuilder();
				Datavalidator.validateEmpty(textFieldManv, sb, "Mã nhân viên không được để trống");
				Datavalidator.validateEmpty(textFieldHotenNV, sb, "Họ và tên không được để trống");
				Datavalidator.validateEmpty(textFieldNgaySinh, sb, "Ngày sinh không được để trống");
				Datavalidator.validateEmpty(textFieldDiaChi, sb, "Địa chỉ không được trống");
				Datavalidator.validateEmpty(textFieldSoDT, sb, "Số điện thoại không được trống");
				Datavalidator.validateEmpty(textFieldEmail, sb, "Email không được để trống");
				Datavalidator.validateEmpty(textFieldChucVu, sb, "Chức vụ không được để trống");
				
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, "Bạn cần điền đầy đủ thông tin", "Lỗi");
					return;
				}
				try {
					NhanVien nv = new NhanVien();
					nv.setMaNV(Integer.parseInt(textFieldManv.getText()));
					nv.setHoten(textFieldHotenNV.getText());
					SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
					Date date = inputDateFormat.parse(textFieldNgaySinh.getText());
					nv.setNgaySinh(date);
					nv.setDiaChi(textFieldDiaChi.getText());
					nv.setSoDienThoai(textFieldSoDT.getText());
					nv.setEmail(textFieldEmail.getText());
					nv.setChucVu(textFieldChucVu.getText());
					
					NhanVienDao nvDao = new NhanVienDao();
					if(!nvDao.isGmailAddress(textFieldEmail.getText())) {
						MessageDialogHelper.showErrorDialog(null,"Email không đúng định dạng", "Lỗi");
						return;
					}
					if(!nvDao.isPhoneNumber(textFieldSoDT.getText())) {
						MessageDialogHelper.showErrorDialog(null,"Số điện thoại không đúng định dạng", "Lỗi");
						return;
					}
					
					if(nvDao.checkExist(textFieldManv.getText())) {
						MessageDialogHelper.showMessageDialog(null,"Mã nhân viên tồn tại","Thông báo");
						return;
					}
					if(nvDao.insert(nv)) {
						MessageDialogHelper.showMessageDialog(null,"Nhân viên đã được lưu", "Thông báo");
						listNV.add(nv);
						
					}
					else {
						MessageDialogHelper.showConfirmDialog(null, "Nhân viên chưa được lưu","Cảnh báo");
					}
					showResultNhanVien();
				}
			catch(Exception ex) {
				ex.printStackTrace();
				MessageDialogHelper.showErrorDialog(null,ex.getMessage(),"Lỗi" );
				}				
	    	}
	    });
	    btnNewButtonLuuNV.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Save-as-icon.png"));
	    btnNewButtonLuuNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonLuuNV.setBackground(Color.WHITE);
	    btnNewButtonLuuNV.setBounds(10, 50, 126, 28);
	    panel_1.add(btnNewButtonLuuNV);
	    
	    JButton btnNewButtonCapNhatNV = new JButton("Cập nhật");
	    btnNewButtonCapNhatNV.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		StringBuilder sb = new StringBuilder();
				Datavalidator.validateEmpty(textFieldManv, sb, "Mã nhân viên không được để trống");
				Datavalidator.validateEmpty(textFieldHotenNV, sb, "Họ và tên không được để trống");
				Datavalidator.validateEmpty(textFieldNgaySinh, sb, "Ngày sinh không được để trống");
				Datavalidator.validateEmpty(textFieldDiaChi, sb, "Địa chỉ không được trống");
				Datavalidator.validateEmpty(textFieldSoDT, sb, "Số điện thoại không được trống");
				Datavalidator.validateEmpty(textFieldEmail, sb, "Email không được để trống");
				Datavalidator.validateEmpty(textFieldChucVu, sb, "Chức vụ không được để trống");
	    		
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, "Bạn cần điền đầy đủ thông tin", "Lỗi");
					return;
				}
				if(MessageDialogHelper.showConfirmDialog(null, "Bạn có muốn cập nhật thông tin nhân viên hay không?", "Hỏi")==JOptionPane.NO_OPTION){
					return;
				}
				try {
					int selectedIndex =tableNhanVien.getSelectedRow();
					if(selectedIndex<0) {
						MessageDialogHelper.showErrorDialog(null, "Vui lòng chọn vị trí cập nhật trên bảng", "Lỗi");
						return;
					}
					listNV.remove(selectedIndex);
					NhanVien nv = new NhanVien();
					nv.setMaNV(Integer.parseInt(textFieldManv.getText()));
					nv.setHoten(textFieldHotenNV.getText());
					SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
					Date date = inputDateFormat.parse(textFieldNgaySinh.getText());
					nv.setNgaySinh(date);
					nv.setDiaChi(textFieldDiaChi.getText());
					nv.setSoDienThoai(textFieldSoDT.getText());
					nv.setEmail(textFieldEmail.getText());
					nv.setChucVu(textFieldChucVu.getText());
					
				    NhanVienDao  nvDao = new NhanVienDao();
				    
				    if(!nvDao.isGmailAddress(textFieldEmail.getText())) {
						MessageDialogHelper.showErrorDialog(null,"Email không đúng định dạng", "Lỗi");
						return;
					}
					if(!nvDao.isPhoneNumber(textFieldSoDT.getText())) {
						MessageDialogHelper.showErrorDialog(null,"Số điện thoại không đúng định dạng", "Lỗi");
						return;
					}
					
					if(nvDao.update(nv)) {
						MessageDialogHelper.showMessageDialog(null,"Thông tin nhân viên đã được cập nhật", "Thông báo");
						listNV.add(nv);
						showResultNhanVien();//show lại bảng sau khi thêm
					}
					else {
						MessageDialogHelper.showConfirmDialog(null, "Thông tin nhân viên chưa được cập nhật","Cảnh báo");
					}
				}
			catch(Exception ex) {
				ex.printStackTrace();
				MessageDialogHelper.showErrorDialog(null,ex.getMessage(),"Lỗi" );
				}				
	    	}
	    });
	    btnNewButtonCapNhatNV.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Document-write-icon (1).png"));
	    btnNewButtonCapNhatNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonCapNhatNV.setBackground(Color.WHITE);
	    btnNewButtonCapNhatNV.setBounds(10, 89, 126, 28);
	    panel_1.add(btnNewButtonCapNhatNV);
	    
	    JButton btnNewButtonXoaNV = new JButton("Xóa");
	    btnNewButtonXoaNV.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		StringBuilder sb = new StringBuilder();
				Datavalidator.validateEmpty(textFieldManv, sb, "Mã nhân viên không được để trống");
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, sb.toString(), "Lỗi");
					return;
				}
				if(MessageDialogHelper.showConfirmDialog(null, "Bạn có muốn xóa nhân viên hay không?", "Hỏi")==JOptionPane.NO_OPTION){
					return;
				}
					try {
						
						NhanVienDao nvDao = new NhanVienDao();
						if(nvDao.checkExistNhanVien(textFieldManv.getText())) {
							MessageDialogHelper.showErrorDialog(null, "Nhân viên không được xóa vì đã có thông tin trên Hóa đơn", "Thông báo");
							return;
						}
						
						if(nvDao.delete(textFieldManv.getText())) {
							int selectedIndex = tableNhanVien.getSelectedRow();
							listNV.remove(selectedIndex);
							showDataNhanVien();
							MessageDialogHelper.showMessageDialog(null, "Nhân viên đã được xóa", "Thông báo");
						}
						else {
							MessageDialogHelper.showMessageDialog(null, "Nhân viên không được xóa do không tồn tại","Cảnh báo");
						}
				}
				catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showErrorDialog(null,ex.getMessage(),"Lỗi" );
					}				
	    	}
	    });
	    btnNewButtonXoaNV.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Delete-icon (1).png"));
	    btnNewButtonXoaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonXoaNV.setBackground(Color.WHITE);
	    btnNewButtonXoaNV.setBounds(10, 128, 126, 28);
	    panel_1.add(btnNewButtonXoaNV);
	    
	    JButton btnNewButtonThemMoiNV = new JButton("Thêm mới");
	    btnNewButtonThemMoiNV.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	textFieldManv.setText("");
	    	textFieldManv.setEditable(true);
			textFieldHotenNV.setText("");
			textFieldNgaySinh.setText("");
			textFieldDiaChi.setText("");
			textFieldSoDT.setText("");
			textFieldEmail.setText("");
			textFieldChucVu.setText("");
	    	}
	    });
	    
	    listNV = new NhanVienDao().getListNhanVien();
		modelNhanVien= (DefaultTableModel) tableNhanVien.getModel();
		showTableNhanVien();
	    
	    btnNewButtonThemMoiNV.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\New-file-icon.png"));
	    btnNewButtonThemMoiNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonThemMoiNV.setBackground(Color.WHITE);
	    btnNewButtonThemMoiNV.setBounds(10, 11, 126, 28);
	    panel_1.add(btnNewButtonThemMoiNV);
	    
	    JLabel lblNewLabelQuanliNhanVien = new JLabel("QUẢN LÍ NHÂN VIÊN");
	    lblNewLabelQuanliNhanVien.setForeground(new Color(255, 0, 0));
	    lblNewLabelQuanliNhanVien.setFont(new Font("Tahoma", Font.BOLD, 30));
	    lblNewLabelQuanliNhanVien.setBounds(368, 21, 383, 72);
	    panel_NV.add(lblNewLabelQuanliNhanVien);
	    
	    JLabel lblNewLabelTimKiemNV = new JLabel("Tìm kiếm");
	    lblNewLabelTimKiemNV.setForeground(Color.RED);
	    lblNewLabelTimKiemNV.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblNewLabelTimKiemNV.setBackground(Color.BLACK);
	    lblNewLabelTimKiemNV.setBounds(749, 34, 113, 47);
	    panel_NV.add(lblNewLabelTimKiemNV);
	    
	    textFieldTimKiemNV = new JTextField();
	    textFieldTimKiemNV.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyReleased(KeyEvent e) {
	    		String str = textFieldTimKiemNV.getText();
				DefaultTableModel model =(DefaultTableModel) tableNhanVien.getModel();
				TableRowSorter<DefaultTableModel> rts = new TableRowSorter<DefaultTableModel>(model);
				tableNhanVien.setRowSorter(rts);
				rts.setRowFilter(RowFilter.regexFilter(str));
	    	}
	    });
	    textFieldTimKiemNV.setColumns(10);
	    textFieldTimKiemNV.setBounds(899, 37, 203, 43);
	    panel_NV.add(textFieldTimKiemNV);
	    tabbedPane.setIconAt(1, new ImageIcon("D:\\Icon\\innv.png"));
	    
	    
	    tabbedPane.addTab("Khách Hàng", panel_KH);
	    panel_KH.setLayout(null);
	    
	    JLabel lblNewLabelQuanliKhachHang = new JLabel("QUẢN LÍ KHÁCH HÀNG");
	    lblNewLabelQuanliKhachHang.setForeground(Color.RED);
	    lblNewLabelQuanliKhachHang.setFont(new Font("Tahoma", Font.BOLD, 30));
	    lblNewLabelQuanliKhachHang.setBounds(349, 53, 383, 72);
	    panel_KH.add(lblNewLabelQuanliKhachHang);
	    
	    JLabel lblNewLabelTimKiemKH = new JLabel("Tìm kiếm");
	    lblNewLabelTimKiemKH.setForeground(Color.RED);
	    lblNewLabelTimKiemKH.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblNewLabelTimKiemKH.setBackground(Color.BLACK);
	    lblNewLabelTimKiemKH.setBounds(730, 66, 113, 47);
	    panel_KH.add(lblNewLabelTimKiemKH);
	    
	    textFieldTimKiemKH = new JTextField();
	    textFieldTimKiemKH.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyReleased(KeyEvent e) {
	    		String str = textFieldTimKiemKH.getText();
				DefaultTableModel model =(DefaultTableModel) tableKhachHang.getModel();
				TableRowSorter<DefaultTableModel> rts = new TableRowSorter<DefaultTableModel>(model);
				tableKhachHang.setRowSorter(rts);
				rts.setRowFilter(RowFilter.regexFilter(str));
	    	}
	    });
	    textFieldTimKiemKH.setColumns(10);
	    textFieldTimKiemKH.setBounds(880, 69, 203, 43);
	    panel_KH.add(textFieldTimKiemKH);
	    
	    JScrollPane scrollPaneKhachHang = new JScrollPane();
	    scrollPaneKhachHang.setBounds(37, 150, 1046, 202);
	    panel_KH.add(scrollPaneKhachHang);
	    
	    tableKhachHang = new JTable();
	    tableKhachHang.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		int row = tableKhachHang.getSelectedRow();
				TableModel model = tableKhachHang.getModel();
				textFieldMaKH.setText(modelKhachHang.getValueAt(row, 0)+"");
				textFieldMaKH.setEditable(false);
				textFieldTenKH.setText(modelKhachHang.getValueAt(row, 1)+"");
				textFieldDiaChiKh.setText(modelKhachHang.getValueAt(row, 2)+"");
				textFieldSDTKH.setText(modelKhachHang.getValueAt(row, 3)+"");
				textFieldEmailKH.setText(modelKhachHang.getValueAt(row, 4)+"");
	    	}
	    });
	    tableKhachHang.setModel(new DefaultTableModel(
	    	new Object[][] {
	    	},
	    	new String[] {
	    		"M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Email"
	    	}
	    ) {
	    	boolean[] columnEditables = new boolean[] {
	    		false, false, false, false, false
	    	};
	    	public boolean isCellEditable(int row, int column) {
	    		return columnEditables[column];
	    	}
	    });
	    tableKhachHang.getColumnModel().getColumn(0).setResizable(false);
	    tableKhachHang.getColumnModel().getColumn(0).setPreferredWidth(87);
	    tableKhachHang.getColumnModel().getColumn(1).setResizable(false);
	    tableKhachHang.getColumnModel().getColumn(1).setPreferredWidth(160);
	    tableKhachHang.getColumnModel().getColumn(2).setResizable(false);
	    tableKhachHang.getColumnModel().getColumn(2).setPreferredWidth(198);
	    tableKhachHang.getColumnModel().getColumn(3).setResizable(false);
	    tableKhachHang.getColumnModel().getColumn(3).setPreferredWidth(93);
	    tableKhachHang.getColumnModel().getColumn(4).setResizable(false);
	    tableKhachHang.getColumnModel().getColumn(4).setPreferredWidth(123);
	    scrollPaneKhachHang.setViewportView(tableKhachHang);
	    
	    JLabel lblNewLabelMaKhachHang = new JLabel("Mã khách hàng");
	    lblNewLabelMaKhachHang.setToolTipText("");
	    lblNewLabelMaKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblNewLabelMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabelMaKhachHang.setBounds(37, 394, 122, 47);
	    panel_KH.add(lblNewLabelMaKhachHang);
	    
	    textFieldMaKH = new JTextField();
	    textFieldMaKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldMaKH.setColumns(10);
	    textFieldMaKH.setBackground(Color.WHITE);
	    textFieldMaKH.setBounds(187, 402, 203, 29);
	    panel_KH.add(textFieldMaKH);
	    
	    JLabel lblNewLabelHotenKH = new JLabel("Tên khách hàng");
	    lblNewLabelHotenKH.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblNewLabelHotenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabelHotenKH.setBounds(10, 442, 149, 47);
	    panel_KH.add(lblNewLabelHotenKH);
	    
	    textFieldTenKH = new JTextField();
	    textFieldTenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldTenKH.setColumns(10);
	    textFieldTenKH.setBackground(Color.WHITE);
	    textFieldTenKH.setBounds(187, 450, 203, 29);
	    panel_KH.add(textFieldTenKH);
	    
	    JLabel lblaDiaCHi = new JLabel("Địa chỉ");
	    lblaDiaCHi.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblaDiaCHi.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblaDiaCHi.setBounds(37, 490, 122, 47);
	    panel_KH.add(lblaDiaCHi);
	    
	    textFieldDiaChiKh = new JTextField();
	    textFieldDiaChiKh.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldDiaChiKh.setColumns(10);
	    textFieldDiaChiKh.setBackground(Color.WHITE);
	    textFieldDiaChiKh.setBounds(187, 498, 291, 29);
	    panel_KH.add(textFieldDiaChiKh);
	    
	    JLabel lblSDTKH = new JLabel("Số điện thoại");
	    lblSDTKH.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblSDTKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblSDTKH.setBounds(463, 394, 122, 47);
	    panel_KH.add(lblSDTKH);
	    
	    textFieldSDTKH = new JTextField();
	    textFieldSDTKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldSDTKH.setColumns(10);
	    textFieldSDTKH.setBackground(Color.WHITE);
	    textFieldSDTKH.setBounds(613, 402, 203, 29);
	    panel_KH.add(textFieldSDTKH);
	    
	    textFieldEmailKH = new JTextField();
	    textFieldEmailKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldEmailKH.setColumns(10);
	    textFieldEmailKH.setBackground(Color.WHITE);
	    textFieldEmailKH.setBounds(613, 450, 203, 29);
	    panel_KH.add(textFieldEmailKH);
	    
	    JLabel lblEmail = new JLabel("Email");
	    lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblEmail.setBounds(463, 442, 122, 47);
	    panel_KH.add(lblEmail);
	    
	    JPanel panel_1_1 = new JPanel();
	    panel_1_1.setLayout(null);
	    panel_1_1.setBackground(new Color(0, 128, 192));
	    panel_1_1.setBounds(917, 394, 146, 173);
	    panel_KH.add(panel_1_1);
	    
	    JButton btnNewButtonLuuKH = new JButton("Lưu");
	    btnNewButtonLuuKH.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		StringBuilder sb = new StringBuilder();
				Datavalidator.validateEmpty(textFieldMaKH, sb, "Mã khách hàng không được để trống");
				Datavalidator.validateEmpty(textFieldTenKH, sb, "Tên khách hàng không được để trống");
				Datavalidator.validateEmpty(textFieldDiaChiKh, sb, "Địa chỉ khách hàng không được trống");
				Datavalidator.validateEmpty(textFieldSDTKH, sb, "Số điện thoại không được trống");
				Datavalidator.validateEmpty(textFieldEmailKH, sb, "Email không được để trống");
				
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, "Bạn cần điền đầy đủ thông tin", "Lỗi");
					return;
				}
				try {
					KhachHang kh = new KhachHang();
					kh.setMaKH(Integer.parseInt(textFieldMaKH.getText()));
					kh.setTenKH(textFieldTenKH.getText());
					kh.setDiaChiKH(textFieldDiaChiKh.getText());
					kh.setSoDienThoaiKH(textFieldSDTKH.getText());
					kh.setEmailKH(textFieldEmailKH.getText());
					
					KhachHangDao khDao = new KhachHangDao();
					if(!khDao.isGmailAddress(textFieldEmailKH.getText())) {
						MessageDialogHelper.showErrorDialog(null,"Email không đúng định dạng", "Lỗi");
						return;
					}
					if(!khDao.isPhoneNumber(textFieldSDTKH.getText())) {
						MessageDialogHelper.showErrorDialog(null,"Số điện thoại không đúng định dạng", "Lỗi");
						return;
					}
					
					if(khDao.checkExist(textFieldMaKH.getText())) {
						MessageDialogHelper.showMessageDialog(null,"Mã khách hàng tồn tại","Thông báo");
						return;
					}
					if(khDao.insert(kh)) {
						MessageDialogHelper.showMessageDialog(null,"Khách hàng đã được lưu", "Thông báo");
						listKH.add(kh);
						
					}
					else {
						MessageDialogHelper.showConfirmDialog(null, "Khách hàng chưa được lưu","Cảnh báo");
					}
					showResultKhachHang();
				}
			catch(Exception ex) {
				ex.printStackTrace();
				MessageDialogHelper.showErrorDialog(null,ex.getMessage(),"Lỗi" );
				}				
	    		
	    	}
	    });
	    btnNewButtonLuuKH.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Save-as-icon.png"));
	    btnNewButtonLuuKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonLuuKH.setBackground(Color.WHITE);
	    btnNewButtonLuuKH.setBounds(10, 50, 126, 28);
	    panel_1_1.add(btnNewButtonLuuKH);
	    
	    JButton btnNewButtonCapNhatKH = new JButton("Cập nhật");
	    btnNewButtonCapNhatKH.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		StringBuilder sb = new StringBuilder();
				Datavalidator.validateEmpty(textFieldMaKH, sb, "Mã khách hàng không được để trống");
				Datavalidator.validateEmpty(textFieldTenKH, sb, "Tên khách hàng không được để trống");
				Datavalidator.validateEmpty(textFieldDiaChiKh, sb, "Địa chỉ khách hàng không được trống");
				Datavalidator.validateEmpty(textFieldSDTKH, sb, "Số điện thoại không được trống");
				Datavalidator.validateEmpty(textFieldEmailKH, sb, "Email không được để trống");
	    		
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, "Bạn cần điền đầy đủ thông tin", "Lỗi");
					return;
				}
				if(MessageDialogHelper.showConfirmDialog(null, "Bạn có muốn cập nhật thông tin khách hàng hay không?", "Hỏi")==JOptionPane.NO_OPTION){
					return;
				}
				try {
					int selectedIndex =tableKhachHang.getSelectedRow();
					if(selectedIndex<0) {
						MessageDialogHelper.showErrorDialog(null, "Vui lòng chọn vị trí cập nhật trên bảng", "Lỗi");
						return;
					}
					listKH.remove(selectedIndex);
					KhachHang kh = new KhachHang();
					kh.setMaKH(Integer.parseInt(textFieldMaKH.getText()));
					kh.setTenKH(textFieldTenKH.getText());
					kh.setDiaChiKH(textFieldDiaChiKh.getText());
					kh.setSoDienThoaiKH(textFieldSDTKH.getText());
					kh.setEmailKH(textFieldEmailKH.getText());
					
					
				    KhachHangDao  khDao = new KhachHangDao();
				    if(!khDao.isGmailAddress(textFieldEmailKH.getText())) {
						MessageDialogHelper.showErrorDialog(null,"Email không đúng định dạng", "Lỗi");
						return;
					}
				    if(!khDao.isPhoneNumber(textFieldSDTKH.getText())) {
						MessageDialogHelper.showErrorDialog(null,"Số điện thoại không đúng định dạng", "Lỗi");
						return;
					}
					if(khDao.update(kh)) {
						MessageDialogHelper.showMessageDialog(null,"Thông tin khách hàng đã được cập nhật", "Thông báo");
						listKH.add(kh);
						showResultKhachHang();//show lại bảng sau khi thêm
					}
					else {
						MessageDialogHelper.showConfirmDialog(null, "Thông tin khách hàng chưa được cập nhật","Cảnh báo");
					}
				}
			catch(Exception ex) {
				ex.printStackTrace();
				MessageDialogHelper.showErrorDialog(null,ex.getMessage(),"Lỗi" );
				}			
	    		
	    	}
	    });
	    btnNewButtonCapNhatKH.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Document-write-icon (1).png"));
	    btnNewButtonCapNhatKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonCapNhatKH.setBackground(Color.WHITE);
	    btnNewButtonCapNhatKH.setBounds(10, 89, 126, 28);
	    panel_1_1.add(btnNewButtonCapNhatKH);
	    
	    JButton btnNewButtonXoaKH = new JButton("Xóa");
	    btnNewButtonXoaKH.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		StringBuilder sb = new StringBuilder();
				Datavalidator.validateEmpty(textFieldMaKH, sb, "Mã khách hàng không được để trống");
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, sb.toString(), "Lỗi");
					return;
				}
				if(MessageDialogHelper.showConfirmDialog(null, "Bạn có muốn xóa khách hàng hay không?", "Hỏi")==JOptionPane.NO_OPTION){
					return;
				}
					try {
						
						KhachHangDao khDao = new KhachHangDao();
						if(khDao.checkExistKhachHang(textFieldMaKH.getText())) {
							MessageDialogHelper.showErrorDialog(null, "Khách hàng không được xóa vì đã có thông tin trên Hóa đơn", "Thông báo");
							return;
						}
						
						
						if(khDao.delete(textFieldMaKH.getText())) {
							int selectedIndex = tableKhachHang.getSelectedRow();
							listKH.remove(selectedIndex);
							showDataKhachHang();
							MessageDialogHelper.showMessageDialog(null, "Khách hàng đã được xóa", "Thông báo");
						}
						else {
							MessageDialogHelper.showMessageDialog(null, "Khách hàng không được xóa do không tồn tại","Cảnh báo");
						}
				}
				catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showErrorDialog(null,ex.getMessage(),"Lỗi" );
					}				
	    	}
	    });
	    btnNewButtonXoaKH.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Delete-icon (1).png"));
	    btnNewButtonXoaKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonXoaKH.setBackground(Color.WHITE);
	    btnNewButtonXoaKH.setBounds(10, 128, 126, 28);
	    panel_1_1.add(btnNewButtonXoaKH);
	    
	    JButton btnNewButtonThemMoiKH = new JButton("Thêm mới");
	    btnNewButtonThemMoiKH.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		textFieldMaKH.setText("");
	    		textFieldMaKH.setEditable(true);
				textFieldTenKH.setText("");
				textFieldNgaySinh.setText("");
				textFieldDiaChiKh.setText("");
				textFieldSDTKH.setText("");
				textFieldEmailKH.setText("");
	    	}
	    });
	    
	    
	    
	    listKH = new KhachHangDao().getListKhachHang();
		modelKhachHang= (DefaultTableModel) tableKhachHang.getModel();
		showTableKhachHang();

	    
	    
	    btnNewButtonThemMoiKH.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\New-file-icon.png"));
	    btnNewButtonThemMoiKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonThemMoiKH.setBackground(Color.WHITE);
	    btnNewButtonThemMoiKH.setBounds(10, 11, 126, 28);
	    panel_1_1.add(btnNewButtonThemMoiKH);
	    tabbedPane.setIconAt(2, new ImageIcon("D:\\Icon\\ickh.png"));
	    JPanel panel_HoaDon = new JPanel();
	    panel_HoaDon.setBackground(new Color(192, 192, 192));
	    
	    
	    //View Hóa ĐƠn
	    tabbedPane.addTab("Hóa Đơn", panel_HoaDon);
	    tabbedPane.setIconAt(3, new ImageIcon("D:\\Icon\\ichd.png"));
	    panel_HoaDon.setLayout(null);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(59, 94, 1046, 202);
	    panel_HoaDon.add(scrollPane);
	    	    
	    tableHoaDon = new JTable();
	    tableHoaDon.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		int row = tableHoaDon.getSelectedRow();
				TableModel model = tableHoaDon.getModel();
				textFieldMaHD.setText(modelTHoaDon.getValueAt(row, 0)+"");
				textFieldMaHD.setEditable(false);
				textFieldMaNV.setText(modelTHoaDon.getValueAt(row, 1)+"");
				textField_MaKH.setText(modelTHoaDon.getValueAt(row, 2)+"");
				textField_TenSP.setText(model.getValueAt(row, 3)+"");
				textField_SoLuong.setText(modelTHoaDon.getValueAt(row, 4)+"");
				textFieldDonGia.setText(modelTHoaDon.getValueAt(row, 5)+"");
				LocalDateTime localDateTime = (LocalDateTime) modelTHoaDon.getValueAt(row, 6);
				Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
				SpinnerDateModel spinnerModel = new SpinnerDateModel(date, null, null, Calendar.DAY_OF_MONTH);
				spinnerNgayDatHang.setModel(spinnerModel);
	    	}
	    });
	    tableHoaDon.setBorder(new EmptyBorder(0, 0, 0, 0));
	    tableHoaDon.setBackground(new Color(255, 255, 255));
	    tableHoaDon.setModel(new DefaultTableModel(
	    	new Object[][] {
	    	},
	    	new String[] {
	    		"M\u00E3 H\u00F3a \u0110\u01A1n", "M\u00E3 Nh\u00E2n Vi\u00EAn", "M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "\u0110\u01A1n Gi\u00E1", "Ng\u00E0y \u0110\u1EB7t H\u00E0ng", "T\u1ED5ng Ti\u1EC1n"
	    	}
	    ) {
	    	boolean[] columnEditables = new boolean[] {
	    		false, false, false, false, false, false, false, false
	    	};
	    	public boolean isCellEditable(int row, int column) {
	    		return columnEditables[column];
	    	}
	    });
	    tableHoaDon.getColumnModel().getColumn(0).setResizable(false);
	    tableHoaDon.getColumnModel().getColumn(1).setResizable(false);
	    tableHoaDon.getColumnModel().getColumn(1).setPreferredWidth(93);
	    tableHoaDon.getColumnModel().getColumn(2).setResizable(false);
	    tableHoaDon.getColumnModel().getColumn(2).setPreferredWidth(105);
	    tableHoaDon.getColumnModel().getColumn(3).setResizable(false);
	    tableHoaDon.getColumnModel().getColumn(3).setPreferredWidth(322);
	    tableHoaDon.getColumnModel().getColumn(4).setResizable(false);
	    tableHoaDon.getColumnModel().getColumn(5).setResizable(false);
	    tableHoaDon.getColumnModel().getColumn(5).setPreferredWidth(86);
	    tableHoaDon.getColumnModel().getColumn(6).setResizable(false);
	    tableHoaDon.getColumnModel().getColumn(6).setPreferredWidth(139);
	    tableHoaDon.getColumnModel().getColumn(7).setResizable(false);
	    tableHoaDon.getColumnModel().getColumn(7).setPreferredWidth(94);
	    scrollPane.setViewportView(tableHoaDon);
	    
	    JLabel lblNewLabel_ThongTinHD = new JLabel("THÔNG TIN HÓA ĐƠN");
	    lblNewLabel_ThongTinHD.setForeground(new Color(128, 128, 0));
	    lblNewLabel_ThongTinHD.setFont(new Font("Tahoma", Font.BOLD, 30));
	    lblNewLabel_ThongTinHD.setBounds(385, 11, 383, 72);
	    panel_HoaDon.add(lblNewLabel_ThongTinHD);
	    
	    JLabel lblNewLabeHOADONl = new JLabel("Mã Hóa Đơn");
	    lblNewLabeHOADONl.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabeHOADONl.setBounds(59, 335, 122, 47);
	    panel_HoaDon.add(lblNewLabeHOADONl);
	    
	    textFieldMaHD = new JTextField();
	    textFieldMaHD.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldMaHD.setBackground(new Color(255, 255, 255));
	    textFieldMaHD.setBounds(209, 343, 203, 29);
	    panel_HoaDon.add(textFieldMaHD);
	    textFieldMaHD.setColumns(10);
	    
	    JLabel lblNewLabeMaNV = new JLabel("Mã Nhân Viên");
	    lblNewLabeMaNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabeMaNV.setBounds(59, 383, 122, 47);
	    panel_HoaDon.add(lblNewLabeMaNV);
	    
	    textFieldMaNV = new JTextField();
	    textFieldMaNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldMaNV.setColumns(10);
	    textFieldMaNV.setBounds(209, 393, 203, 29);
	    panel_HoaDon.add(textFieldMaNV);
	    
	    JLabel lblNewLabeMaKH = new JLabel("Mã Khách Hàng");
	    lblNewLabeMaKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabeMaKH.setBounds(59, 433, 146, 47);
	    panel_HoaDon.add(lblNewLabeMaKH);
	    
	    textField_MaKH = new JTextField();
	    textField_MaKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textField_MaKH.setColumns(10);
	    textField_MaKH.setBounds(209, 441, 203, 29);
	    panel_HoaDon.add(textField_MaKH);
	    
	    JLabel lblNewLabelTenSp = new JLabel("Tên Sản Phẩm");
	    lblNewLabelTenSp.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabelTenSp.setBounds(458, 335, 122, 47);
	    panel_HoaDon.add(lblNewLabelTenSp);
	    
	    textField_TenSP = new JTextField();
	    textField_TenSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textField_TenSP.setColumns(10);
	    textField_TenSP.setBounds(594, 343, 300, 29);
	    panel_HoaDon.add(textField_TenSP);
	    
	    JLabel lblNewLabeMaNV_1_1_1 = new JLabel("Số Lượng");
	    lblNewLabeMaNV_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabeMaNV_1_1_1.setBounds(458, 383, 122, 47);
	    panel_HoaDon.add(lblNewLabeMaNV_1_1_1);
	    
	    textField_SoLuong = new JTextField();
	    textField_SoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textField_SoLuong.setColumns(10);
	    textField_SoLuong.setBounds(594, 393, 72, 29);
	    panel_HoaDon.add(textField_SoLuong);
	    
	    JLabel lblNewLabelNgayDH = new JLabel("Ngày Đặt Hàng");
	    lblNewLabelNgayDH.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabelNgayDH.setBounds(458, 433, 122, 47);
	    panel_HoaDon.add(lblNewLabelNgayDH);
	    
	    Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        SpinnerDateModel model = new SpinnerDateModel(today, null, null, Calendar.DAY_OF_MONTH);
        spinnerNgayDatHang = new JSpinner(model);
        spinnerNgayDatHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
        spinnerNgayDatHang.setBounds(594, 441, 174, 29);
	    
	    
	    panel_HoaDon.add(spinnerNgayDatHang);
	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(0, 128, 192));
	    panel.setBounds(959, 343, 146, 173);
	    panel_HoaDon.add(panel);
	    panel.setLayout(null);
	    
	    JButton btnNewButtonLuu = new JButton("Lưu");
	    btnNewButtonLuu.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Save-as-icon.png"));
	    btnNewButtonLuu.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		StringBuilder sb = new StringBuilder();
				Datavalidator.validateEmpty(textFieldMaHD, sb, "Mã hóa đơn không được để trống");
				Datavalidator.validateEmpty(textFieldMaNV, sb, "Mã nhân viên không được để trống");
				Datavalidator.validateEmpty(textField_MaKH, sb, "Mã khách hàng không được để trống");
				Datavalidator.validateEmpty(textField_SoLuong, sb, "Số lượng trống");
				Datavalidator.validateEmpty(textFieldDonGia, sb, "Đơn giá trống");
				Datavalidator.validateEmpty(textField_TenSP, sb, "Tên sản phẩm  không được để trống");
				
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, "Bạn cần điền đầy đủ thông tin", "Lỗi");
					return;
				}
				try {
					HoaDon hd = new HoaDon();
					hd.setMaHoaDon(Integer.parseInt(textFieldMaHD.getText()));
					hd.setMaNhanVien(Integer.parseInt(textFieldMaNV.getText()));
					hd.setMaKhachHang(Integer.parseInt(textField_MaKH.getText()));
					hd.setTenSP(textField_TenSP.getText());
					hd.setSoLuong(Integer.parseInt(textField_SoLuong.getText()));
					hd.setDonGia(Long.parseLong(textFieldDonGia.getText()));
					Object obj = spinnerNgayDatHang.getValue(); // Đối tượng ngày giờ
					Instant instant = ((Date) obj).toInstant(); // Chuyển đổi thành Instant
					LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); // Chuyển đổi thành LocalDateTime
					hd.setNgayDatHang(localDateTime);
					hd.setTongTien(Long.parseLong(textField_SoLuong.getText())* Long.parseLong(textFieldDonGia.getText()));
					
					
					String tenSp= textField_TenSP.getText();
					int rowCount = modelSanPham.getRowCount();
					int ColumnIndex =-1;
					for (int i = 0; i < rowCount; i++) {
			            String rowName = modelSanPham.getValueAt(i, 0).toString();
			            if (rowName.equals(tenSp)) {
			                ColumnIndex = i;
			                break;
			            }
			        }
					
					
					HoaDonDao hdDao = new HoaDonDao();
					if(hdDao.insert(hd)) {
						MessageDialogHelper.showMessageDialog(null,"Hóa đơn đã được lưu", "Thông báo");
						hdDao.updateSoLuong();
						listHoaDon.add(hd);
						
					}
					else {
						MessageDialogHelper.showConfirmDialog(null, "Hóa đơn chưa được lưu","Cảnh báo");
					}
					showResultHoaDon();
				}
			catch(Exception ex) {
				ex.printStackTrace();
				MessageDialogHelper.showErrorDialog(null,ex.getMessage(),"Lỗi" );
				}				
			}	
	    });
	    btnNewButtonLuu.setBounds(10, 50, 126, 28);
	    panel.add(btnNewButtonLuu);
	    btnNewButtonLuu.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonLuu.setBackground(new Color(255, 255, 255));
	    
	    
	    
	    JButton btnNewButtonCapNhat = new JButton("Cập nhật");
	    btnNewButtonCapNhat.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Document-write-icon (1).png"));
	    btnNewButtonCapNhat.setBounds(10, 89, 126, 28);
	    panel.add(btnNewButtonCapNhat);
	    btnNewButtonCapNhat.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		StringBuilder sb = new StringBuilder();
				Datavalidator.validateEmpty(textFieldMaHD, sb, "Mã hóa đơn không được để trống");
				Datavalidator.validateEmpty(textFieldMaNV, sb, "Mã nhân viên không được để trống");
				Datavalidator.validateEmpty(textField_MaKH, sb, "Mã khách hàng không được để trống");
				Datavalidator.validateEmpty(textField_SoLuong, sb, "Số lượng trống");
				Datavalidator.validateEmpty(textFieldDonGia, sb, "Đơn giá trống");
				Datavalidator.validateEmpty(textField_TenSP, sb, "Tên sản phẩm  không được để trống");
				
				
				
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, "Bạn cần điền đầy đủ thông tin", "Lỗi");
					return;
				}
				if(MessageDialogHelper.showConfirmDialog(null, "Bạn có muốn cập nhật hóa đơn hay không?", "Hỏi")==JOptionPane.NO_OPTION){
					return;
				}
				try {
					int selectedIndex =tableHoaDon.getSelectedRow();
					if(selectedIndex<0) {
						MessageDialogHelper.showErrorDialog(null, "Vui lòng chọn vị trí cập nhật trên bảng", "Lỗi");
						return;
					}
					listHoaDon.remove(selectedIndex);
					
					HoaDon hd = new HoaDon();
					hd.setMaHoaDon(Integer.parseInt(textFieldMaHD.getText()));
					hd.setMaNhanVien(Integer.parseInt(textFieldMaNV.getText()));
					hd.setMaKhachHang(Integer.parseInt(textField_MaKH.getText()));
					hd.setTenSP(textField_TenSP.getText());
					hd.setSoLuong(Integer.parseInt(textField_SoLuong.getText()));
					hd.setDonGia(Long.parseLong(textFieldDonGia.getText()));
					Object obj = spinnerNgayDatHang.getValue(); // Đối tượng ngày giờ
					Instant instant = ((Date) obj).toInstant(); // Chuyển đổi thành Instant
					LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); // Chuyển đổi thành LocalDateTime
					hd.setNgayDatHang(localDateTime);
					hd.setTongTien(Long.parseLong(textField_SoLuong.getText())* Long.parseLong(textFieldDonGia.getText()));		
					HoaDonDao hdDao = new HoaDonDao();
					hdDao.updateSoLuong();
					
					if(hdDao.update(hd)) {
						MessageDialogHelper.showMessageDialog(null,"Hóa đơn đã được cập nhật", "Thông báo");
						listHoaDon.add(hd);
						showResultHoaDon();//show lại bảng sau khi thêm
					}
					else {
						MessageDialogHelper.showConfirmDialog(null, "Hóa đơn chưa được cập nhật","Cảnh báo");
					}
				}
			catch(Exception ex) {
				ex.printStackTrace();
				MessageDialogHelper.showErrorDialog(null,ex.getMessage(),"Lỗi" );
				}				
			}			
	    });
	    btnNewButtonCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonCapNhat.setBackground(Color.WHITE);
	    
	    JButton btnNewButtonXoa = new JButton("Xóa");
	    btnNewButtonXoa.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Delete-icon (1).png"));
	    btnNewButtonXoa.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		StringBuilder sb = new StringBuilder();
				Datavalidator.validateEmpty(textFieldMaHD, sb, "Mã hóa đơn không được để trống");
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, sb.toString(), "Lỗi");
					return;
				}
				if(MessageDialogHelper.showConfirmDialog(null, "Bạn có muốn xóa hóa đơn hay không?", "Hỏi")==JOptionPane.NO_OPTION){
					return;
				}
					try {
						
						HoaDonDao hdDao = new HoaDonDao();
						if(hdDao.delete(Integer.parseInt(textFieldMaHD.getText()))) {
							int selectedIndex = tableHoaDon.getSelectedRow();
							listHoaDon.remove(selectedIndex);
							showDataHoaDon();
							
							MessageDialogHelper.showMessageDialog(null, "Hóa Đơn đã được xóa", "Thông báo");
						}
						else {
							MessageDialogHelper.showMessageDialog(null, "Hóa đơn không được xóa do không tồn tại","Cảnh báo");
						}
				}
				catch(Exception ex) {
					ex.printStackTrace();
					MessageDialogHelper.showErrorDialog(null,ex.getMessage(),"Lỗi" );
					}				
			}	
	    });
	    
	    listHoaDon = new HoaDonDao().getListHoaDon();
		modelTHoaDon= (DefaultTableModel) tableHoaDon.getModel();
		showTableHoaDon();

	    
	    
	    btnNewButtonXoa.setBounds(10, 128, 126, 28);
	    panel.add(btnNewButtonXoa);
	    btnNewButtonXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonXoa.setBackground(Color.WHITE);
	    
	    JButton btnNewButtonThemMoi = new JButton("Thêm mới");
	    btnNewButtonThemMoi.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				textFieldMaHD.setText(null);
				textFieldMaHD.setEditable(true);
				textFieldMaNV.setText(null);
				textField_MaKH.setText(null);
				textField_TenSP.setText(null);
				textField_SoLuong.setText(null);
				textFieldDonGia.setText(null);
			    Calendar calendar = Calendar.getInstance();
		        Date today = calendar.getTime();
		        SpinnerDateModel model = new SpinnerDateModel(today, null, null, Calendar.DAY_OF_MONTH);
				spinnerNgayDatHang.setModel(model);
	    	}
	    });
	    btnNewButtonThemMoi.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\New-file-icon.png"));
	    btnNewButtonThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnNewButtonThemMoi.setBackground(Color.WHITE);
	    btnNewButtonThemMoi.setBounds(10, 11, 126, 28);
	    panel.add(btnNewButtonThemMoi);
	    
	    JButton btnNewButtonPrint = new JButton("IN HÓA ĐƠN");
	    

	    
	    
	    
	    btnNewButtonPrint.setForeground(new Color(0, 0, 0));
	    btnNewButtonPrint.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Designbolts-Free-Multimedia-Printer.32.png"));
	    btnNewButtonPrint.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		StringBuilder sb = new StringBuilder();
				Datavalidator.validateEmpty(textFieldMaHD, sb, "Mã hóa đơn không được để trống");
				Datavalidator.validateEmpty(textFieldMaNV, sb, "Mã nhân viên không được để trống");
				Datavalidator.validateEmpty(textField_MaKH, sb, "Mã khách hàng không được để trống");
				Datavalidator.validateEmpty(textField_SoLuong, sb, "Số lượng trống");
				Datavalidator.validateEmpty(textFieldDonGia, sb, "Đơn giá trống");
				Datavalidator.validateEmpty(textField_TenSP, sb, "Tên sản phẩm  không được để trống");
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(null, "Bạn cần điền đầy đủ thông tin", "Lỗi");
					return;
				}
				if(MessageDialogHelper.showConfirmDialog(null, "Bạn có muốn in hóa đơn hay không?", "Hỏi")==JOptionPane.NO_OPTION){
					return;
				}
				try {
					HoaDon hd = new HoaDon();
					hd.setMaHoaDon(Integer.parseInt(textFieldMaHD.getText()));
					hd.setMaNhanVien(Integer.parseInt(textFieldMaNV.getText()));
					hd.setMaKhachHang(Integer.parseInt(textField_MaKH.getText()));
					hd.setTenSP(textField_TenSP.getText());
					hd.setSoLuong(Integer.parseInt(textField_SoLuong.getText()));
					hd.setDonGia(Long.parseLong(textFieldDonGia.getText()));
					Object obj = spinnerNgayDatHang.getValue(); // Đối tượng ngày giờ
					Instant instant = ((Date) obj).toInstant(); // Chuyển đổi thành Instant
					LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); // Chuyển đổi thành LocalDateTime
					hd.setNgayDatHang(localDateTime);
					
					
					DecimalFormat df2 = new DecimalFormat("#.##");
					String formattedValue2 = df2.format(Float.parseFloat(textField_SoLuong.getText())* Float.parseFloat(textFieldDonGia.getText()));
					hd.setTongTien(Integer.parseInt(formattedValue2));	
					
					String generateInvoice = InHoaDon.generateInvoice(hd);
					
					
					FileWriter writer = new FileWriter("hoadon.txt");
			        writer.write(generateInvoice);
			        writer.close();
			        MessageDialogHelper.showMessageDialog(null, "Hóa đơn đã được in","Thông báo");
//					HoaDonView hdView = new HoaDonView();
//					hdView.inHoaDon(hd);
//					hdView.setVisible(true);
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
	    	}
	    });
	    btnNewButtonPrint.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    btnNewButtonPrint.setBackground(new Color(255, 0, 0));
	    btnNewButtonPrint.setBounds(594, 526, 185, 47);
	    panel_HoaDon.add(btnNewButtonPrint);
	    
	    JLabel lblNewLabeMaTimKiem = new JLabel("Tìm kiếm");
	    lblNewLabeMaTimKiem.setForeground(new Color(255, 0, 0));
	    lblNewLabeMaTimKiem.setBackground(new Color(0, 0, 0));
	    lblNewLabeMaTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    lblNewLabeMaTimKiem.setBounds(59, 523, 113, 47);
	    panel_HoaDon.add(lblNewLabeMaTimKiem);
	    
	    textField_TimKiem = new JTextField();
	    textField_TimKiem.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyReleased(KeyEvent e) {
	    		String str = textField_TimKiem.getText();
				DefaultTableModel model =(DefaultTableModel) tableHoaDon.getModel();
				TableRowSorter<DefaultTableModel> rts = new TableRowSorter<DefaultTableModel>(model);
				tableHoaDon.setRowSorter(rts);
				rts.setRowFilter(RowFilter.regexFilter(str));
	    	}
	    });
	    textField_TimKiem.setColumns(10);
	    textField_TimKiem.setBounds(209, 526, 203, 43);
	    panel_HoaDon.add(textField_TimKiem);
	    
	    JLabel lblNewLabeDonGia = new JLabel("Đơn Giá");
	    lblNewLabeDonGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNewLabeDonGia.setBounds(676, 383, 122, 47);
	    panel_HoaDon.add(lblNewLabeDonGia);
	    
	    textFieldDonGia = new JTextField();
	    textFieldDonGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    textFieldDonGia.setColumns(10);
	    textFieldDonGia.setBounds(749, 393, 145, 29);
	    panel_HoaDon.add(textFieldDonGia);    
	        
	    tabbedPane.addTab("Thống Kê", panel_ThongKe);
	    panel_ThongKe.setLayout(null);
	    chartPanel_1 = new ChartPanel(ThongKeDao.getChart());
	    chartPanel_1.setBounds(98, 22, 1024, 544);
	    panel_ThongKe.add(chartPanel_1);
	    tabbedPane.setIconAt(4, new ImageIcon("D:\\Icon\\ictk.png"));
	    
	    CategoryPlot plot = ThongKeDao.getChart().getCategoryPlot();
	    NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
	    rangeAxis.setNumberFormatOverride(new DecimalFormat("#,### Triệu Đồng")); 
	        
	    Font font = new Font("Arial", Font.PLAIN, 20);
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            tabbedPane.setFont(font);
        }
	    JPanel panel_TroGiup = new JPanel();
	    
	    	    	    
	    	    tabbedPane.addTab("Trợ Giúp", panel_TroGiup);
	    	    tabbedPane.setIconAt(5, new ImageIcon("D:\\Icon\\ichelp.png"));
	    	    panel_TroGiup.setLayout(null);
	    	    JLabel lblNewLabel = new JLabel("Giới thiệu về phần mềm");
	    	    lblNewLabel.setForeground(new Color(0, 0, 255));
	    	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
	    	    lblNewLabel.setBounds(30, 11, 388, 37);
	    	    panel_TroGiup.add(lblNewLabel);
	    	    
	    	    JTextArea jTextAreaGioiThieu = new JTextArea("1.Xin cảm ơn vì đã tin tưởng và đồng hành cùng ứng dụng \n"
	    	    		                                 +   "2.Giới thiệu ứng dụng quản lí cửa hàng bán Máy Tính \n"
	    	    		                                 +   "    Ứng dụng cho phép người dùng quản lí thông tin về Sản phẩm, Nhân Viên và Khách Hàng\n"
	    	    		                                 +   "    Ứng dụng cho phép in ra thông tin hóa đơn cho từng Sản phẩm mà khách hàng đặt \n"
	    	    		                                 +   "    Ứng dụng cho phép thống kê lại doanh thu lợi nhuận của cửa hàng trong từng tháng\n"
	    	    		                                 +   "3.Xin chào và hẹn gặp lại."+"\n \n \n"
	    	    		                                 +   "1.Thank you for trusting and accompanying the application\n"
	    	    		                                 +   "2.Introducing the computer store management application \n"
	    	    		                                 +   "    The application allows users to manage information about Products, Employees and Customers\n"
	    	    		                                 +   "    The application allows to print out invoice information for each Product that customers order \n"
	    	    		                                 +   "    The application allows to re-statistical sales and profits of the store in each month\n"
	    	    		                                 +   "3.Thank you and see you soon.");
	    	    jTextAreaGioiThieu.setEditable(false);
	    	    jTextAreaGioiThieu.setFont(new Font("Monospaced", Font.ITALIC, 16));
	    	    jTextAreaGioiThieu.setBackground(new Color(255, 255, 255)); 
	    	    jTextAreaGioiThieu.setForeground(new Color(0, 0, 0));
	    	    jTextAreaGioiThieu.setBounds(91, 80, 948, 390);
	    	    panel_TroGiup.add(jTextAreaGioiThieu);
	    
	    
	    JPanel panel_SanPhamBanChay = new JPanel();
	    tabbedPane.addTab("Top selling",panel_SanPhamBanChay);
	    panel_SanPhamBanChay.setLayout(null);
	    
	    ChartPanel chartPanel2 = new ChartPanel(ThongKeDao.getChart2());
	    chartPanel2.setBounds(98,22, 1024, 544);
        panel_SanPhamBanChay.add(chartPanel2);
        
        
        tabbedPane.setIconAt(6, new ImageIcon("D:\\Icon\\ictk.png"));
        	    
        	    
        getContentPane().add(tabbedPane, BorderLayout.CENTER); 
        
        this.setVisible(true);
	}
	
	
	
	
	
	
	
	private void showTableSanPham() {
		// TODO Auto-generated method stub
		for (SanPham sp : listSP) {
			DecimalFormat df = new DecimalFormat("#.##");
			String formattedValue = df.format(sp.getDonGia());
			modelSanPham.addRow(new Object[] {
					 sp.getTenSP(),formattedValue,sp.getSoLuong(),sp.getNganhHang(),sp.getMauSac(),sp.getCauHinh()
			});
		}
			
	}
	public void showResultSanPham() {
		SanPham sp = listSP.get(listSP.size()-1);
		DecimalFormat df = new DecimalFormat("#.##");
		String formattedValue = df.format(sp.getDonGia());
		modelSanPham.addRow(new Object[] {
				 sp.getTenSP(),formattedValue,sp.getSoLuong(),sp.getNganhHang(),sp.getMauSac(),sp.getCauHinh()
			
		});
		showDataSanPham();
	}
	public void showDataSanPham() {
		modelSanPham.setRowCount(0);
		
		for (SanPham sp : listSP) {
			DecimalFormat df = new DecimalFormat("#.##");
			String formattedValue = df.format(sp.getDonGia());
			modelSanPham.addRow(new Object[] {
					sp.getTenSP(),formattedValue,sp.getSoLuong(),sp.getNganhHang(),sp.getMauSac(),sp.getCauHinh()
			});
		}
	}
	
	private void showTableNhanVien() {
		// TODO Auto-generated method stub
		for (NhanVien nv : listNV) {
			modelNhanVien.addRow(new Object[] {
					 nv.getMaNV(),nv.getHoten(),nv.getNgaySinh(),nv.getDiaChi(),nv.getSoDienThoai(),nv.getEmail(),nv.getChucVu()
			});
		}
			
	}
	public void showResultNhanVien() {
		NhanVien nv = listNV.get(listNV.size()-1);
		Date date = nv.getNgaySinh();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	    String strDate = formatter.format(date);
		modelSanPham.addRow(new Object[] {
				 nv.getMaNV(),nv.getHoten(),strDate,nv.getDiaChi(),nv.getSoDienThoai(),nv.getEmail(),nv.getChucVu()	
		});
		showDataNhanVien();
	}
	public void showDataNhanVien() {
		modelNhanVien.setRowCount(0);
		
		for (NhanVien nv : listNV) {
			Date date = nv.getNgaySinh();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		    String strDate = formatter.format(date);
			modelNhanVien.addRow(new Object[] {
					nv.getMaNV(),nv.getHoten(),strDate,nv.getDiaChi(),nv.getSoDienThoai(),nv.getEmail(),nv.getChucVu()
			});
		}
	}
	
	
	private void showTableKhachHang() {
		// TODO Auto-generated method stub
		for (KhachHang kh : listKH) {
			modelKhachHang.addRow(new Object[] {
					 kh.getMaKH(),kh.getTenKH(),kh.getDiaChiKH(),kh.getSoDienThoaiKH(),kh.getEmailKH()
			});
		}
			
	}
	public void showResultKhachHang() {
		KhachHang kh = listKH.get(listKH.size()-1);
		modelKhachHang.addRow(new Object[] {
				 kh.getMaKH(),kh.getTenKH(),kh.getDiaChiKH(),kh.getSoDienThoaiKH(),kh.getEmailKH()
			});
		showDataKhachHang();
	}
	public void showDataKhachHang() {
		modelKhachHang.setRowCount(0);
		
		for (KhachHang kh : listKH) {
			modelKhachHang.addRow(new Object[] {
					kh.getMaKH(),kh.getTenKH(),kh.getDiaChiKH(),kh.getSoDienThoaiKH(),kh.getEmailKH()
			});
		}
	}
	
	
	
	
	
	//Hiện thị bảng HoaDOn khi chạy chương trình
		public void showTableHoaDon() {
			for (HoaDon hd : listHoaDon) {
				DecimalFormat df = new DecimalFormat("#.##");
				String formattedValue = df.format(hd.getDonGia());
				DecimalFormat df2 = new DecimalFormat("#.##");
				String formattedValue2 = df2.format(hd.getTongTien());
				modelTHoaDon.addRow(new Object[] {
						 hd.getMaHoaDon(),hd.getMaNhanVien(),hd.getMaKhachHang(),hd.getTenSP(),hd.getSoLuong(),formattedValue,hd.getNgayDatHang(),formattedValue2
				});
			}
		}
		
		//Cập nhật bảng dđiểm  esau khi thực hiện chức năng
		public void showResultHoaDon() {
			HoaDon hd = listHoaDon.get(listHoaDon.size()-1);
			DecimalFormat df = new DecimalFormat("#.##");
			String formattedValue = df.format(hd.getDonGia());
			DecimalFormat df2 = new DecimalFormat("#.##");
			String formattedValue2 = df2.format(hd.getTongTien());
			modelTHoaDon.addRow(new Object[] {
					hd.getMaHoaDon(),hd.getMaNhanVien(),hd.getMaKhachHang(),hd.getTenSP(),hd.getSoLuong(),formattedValue,hd.getNgayDatHang(),formattedValue2
				
			});
			showDataHoaDon();
		}
		
		//Cập nhật bảng điểm sau khi thực hiện chức năng
		public void showDataHoaDon() {
			modelTHoaDon.setRowCount(0);
			for (HoaDon hd : listHoaDon) {
				DecimalFormat df = new DecimalFormat("#.##");
				String formattedValue = df.format(hd.getDonGia());
				DecimalFormat df2 = new DecimalFormat("#.##");
				String formattedValue2 = df2.format(hd.getTongTien());
				modelTHoaDon.addRow(new Object[] {
						hd.getMaHoaDon(),hd.getMaNhanVien(),hd.getMaKhachHang(),hd.getTenSP(),hd.getSoLuong(),formattedValue,hd.getNgayDatHang(),formattedValue2
				});
			}
		}
}
