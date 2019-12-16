package com.zhuang.database;

/*import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;

public class ConnectDatabase {
//	private final String driver = "com.mysql.jdbc.Driver";
	private Connection connection = null;
	private String datadbname;
	
	public void setDatadbname(String datadbname) {
		this.datadbname = datadbname;
	}

	public ConnectDatabase() {
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void ConnectDb() throws SQLException {
		try {
			/*Class.forName(driver);
			Properties properties = new Properties();
			FileInputStream fileInputStream = null;
			try {
				fileInputStream = new FileInputStream("mysql.properties");
				properties.load(fileInputStream);
				connection = DriverManager.getConnection(properties.getProperty("url"),
						properties.getProperty("user"), properties.getProperty("password"));
			} catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e){
				e.printStackTrace();
			}*/
			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/usercomment?user=root&password=root";
			String url = "jdbc:mysql://localhost:3306/"+datadbname+"?characterEncoding=utf-8";
			connection = DriverManager.getConnection(url,"root","root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NullPointerException e){
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void CloseConn() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
