package com.zhuang.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.zhuang.database.ConnectDatabase;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LoadingBlogContent {
	private String blog_id;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
//	JSONArray jsonArray = new JSONArray();
	JSONObject json = null;

	public String getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}

	public LoadingBlogContent(String blog_id) {
		this.blog_id = blog_id;
	}
	
	public JSONObject loadingContent() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ConnectDatabase connectDatabase = new ConnectDatabase();
		connectDatabase.setDatadbname("blog_system");
		try {
			connectDatabase.ConnectDb();
			connection = connectDatabase.getConnection();
			
			String sql = "select * from blog where blog_id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, blog_id);
			
			if(preparedStatement.execute()) {
				resultSet = preparedStatement.getResultSet();
				while(resultSet.next()) {
					json = new JSONObject();
					json.put("blog_people_id", resultSet.getInt("blog_people_id"));
					json.put("blog_title", resultSet.getString("blog_title"));
					json.put("blog_content", resultSet.getString("blog_content"));
					json.put("blog_time", format.format(resultSet.getTimestamp("blog_time")).toString());
				}
			}
			
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			connectDatabase.CloseConn();
		}
		return json;
	}
	
}
