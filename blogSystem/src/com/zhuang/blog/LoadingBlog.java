package com.zhuang.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.zhuang.database.ConnectDatabase;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LoadingBlog {
	private Connection connection = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	JSONArray jsonArray = new JSONArray();
		
	public LoadingBlog() {
	}
	
	public JSONArray getBlog() {
		ConnectDatabase connectDatabase = new ConnectDatabase();
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			connectDatabase.setDatadbname("blog_system");
			connectDatabase.ConnectDb();
			JSONObject json = null;
			
			String sql = "select * from blog order by blog_time desc";
//			String sql = "select * from blog";
			connection = connectDatabase.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			if(preparedStatement.execute()) {
				resultSet = preparedStatement.getResultSet();
				while(resultSet.next()){
					json = new JSONObject();
					json.put("blog_id", resultSet.getInt("blog_id"));
					json.put("blog_title", resultSet.getString("blog_title"));
					json.put("blog_content", resultSet.getString("blog_content"));
					json.put("blog_time", format.format(resultSet.getTimestamp("blog_time")).toString());
					jsonArray.add(json);
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
		return jsonArray;
	}
}
