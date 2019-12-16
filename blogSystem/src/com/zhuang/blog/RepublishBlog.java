package com.zhuang.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zhuang.database.ConnectDatabase;

public class RepublishBlog {
	private String user_id;
	private String title;
	private String content;
	private Connection connection= null;

	public RepublishBlog(String user_id, String title, String content) {
		this.user_id = user_id;
		this.title = title;
		this.content = content;
	}

	//连接数据库，插入数据
	public void InsertData() {
		PreparedStatement preparestatement = null;
		ConnectDatabase conndb = new ConnectDatabase();
		conndb.setDatadbname("blog_system");
		
		try {
			conndb.ConnectDb();
			String sql = "insert into blog(blog_people_id, blog_title, blog_content, blog_time) values(?, ?, ?, now())";
			connection = conndb.getConnection();
			preparestatement = connection.prepareStatement(sql);
			preparestatement.setString(1, user_id);
			preparestatement.setString(2, title);
			preparestatement.setString(3, content);
			
			preparestatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e){
			e.printStackTrace();
		} finally {
			try {
				preparestatement.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (NullPointerException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			conndb.CloseConn();
		}
	}
}
