package com.zhuang.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.zhuang.database.ConnectDatabase;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetCommentFromDb {
	private String blog_id;
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	JSONArray jsonArray = new JSONArray();

	public GetCommentFromDb(String blog_id) {
		this.blog_id = blog_id;
	}
	
	public JSONArray GetComment() {
		ConnectDatabase connectDatabase = new ConnectDatabase();
		JSONObject json = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		connectDatabase.setDatadbname("blog_system");
		try {
			connectDatabase.ConnectDb();
			connection = connectDatabase.getConnection();
			String sql = "select * from comment where comment_blog_id= ? order by comment_time desc";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, blog_id);
			if(preparedStatement.execute()) {
				resultSet = preparedStatement.getResultSet();
				while(resultSet.next()){
					json = new JSONObject();
					json.put("comment_id", resultSet.getString("comment_id"));
					json.put("comment_content", resultSet.getString("comment_content"));
					json.put("comment_time", format.format(resultSet.getTimestamp("comment_time")).toString());
					jsonArray.add(json);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO: handle exception
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
