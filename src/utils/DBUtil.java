package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {


	public static String url = "jdbc:mysql://localhost:3306/jsp_book_shop?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	public static String username = "root";
	public static String password = "4814650zyy";

	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	public DBUtil(){
		try {
			dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
			dataSource.setJdbcUrl(url);
			dataSource.setUser(username);
			dataSource.setPassword(password);
			dataSource.setInitialPoolSize(3);
			dataSource.setMaxPoolSize(10);
			dataSource.setMinPoolSize(3);
			dataSource.setAcquireIncrement(3);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取Connection连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		new DBUtil();
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static ComboPooledDataSource getDataSource() {
		new DBUtil();
		return dataSource;
	}
	public static void setDataSource(ComboPooledDataSource dataSource) {
		DBUtil.dataSource = dataSource;
	}
	public static void main(String[] args) {
		new DBUtil().getConnection();
	}

}
