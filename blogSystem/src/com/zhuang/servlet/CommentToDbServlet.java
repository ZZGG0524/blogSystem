package com.zhuang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhuang.comment.InsertCommentToDb;

public class CommentToDbServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setHeader("content-type","text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		HttpSession session = req.getSession();
		
		String content = (String) req.getParameter("content");
		String user_id = (String) session.getAttribute("user");
		String blog_id = (String) session.getAttribute("blog");
		
		InsertCommentToDb insertCommentToDb = new InsertCommentToDb(user_id, blog_id, content);
		try {
			insertCommentToDb.InsertData();
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
