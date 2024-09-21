package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import Helper.Connect;
import model.TaiKhoan;

public class ThongKeDao {
	private static double doanhThu;
	private static int thang;
	private static int i;
	private static String tenSanPham;
	private static int soLuong;

	public static DefaultCategoryDataset getDataset() 
			throws Exception{
		        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				String sql = "SELECT MONTH(NgayDatHang) AS Thang,SUM(TongTien) AS TongDoanhThu \r\n"
						+ "  FROM HoaDon\r\n"
						+ " group BY MONTH(NgayDatHang)";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				try(ResultSet rs = pstmt.executeQuery();){
					while (rs.next()) {
					    thang = rs.getInt("Thang");
					    doanhThu = rs.getDouble("TongDoanhThu")/1000000;
					    dataset.addValue(doanhThu, "Doanh thu", String.valueOf(thang));    
					}
				}
			}
			return dataset;
				
		}	
	public static DefaultPieDataset getDataset2() 
			throws Exception{
		        DefaultPieDataset dataset2 = new DefaultPieDataset();
				String sql =  " select TenSanPham, SUM(SoLuong) AS 'SoLuong' from HoaDon group by TenSanPham";
				try (
					Connection con = Connect.openConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				try(ResultSet rs = pstmt.executeQuery();){
					while (rs.next()) {
					    tenSanPham = rs.getString("TenSanPham");
					    soLuong = rs.getInt("SoLuong");
					    dataset2.setValue(String.valueOf(tenSanPham),soLuong);    
					}
				}
			}
			return dataset2;
				
		}
	public static JFreeChart getChart() throws Exception {
		DefaultCategoryDataset dataset = getDataset();
        JFreeChart chart = ChartFactory.createBarChart(
            "Biểu đồ doanh thu theo tháng",
            "Tháng",
            "Doanh thu",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
        return chart;
	}
	public static JFreeChart getChart2() throws Exception {
		DefaultPieDataset dataset2 = getDataset2();
        JFreeChart chart = ChartFactory.createPieChart("Top Selling Products",dataset2,true,true,false);
        return chart;
	}
	

}
