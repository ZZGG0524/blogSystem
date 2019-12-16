package com.zhuang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhuang.blog.LoadingBlogContent;

public class LoadingBlogContentServlet extends HttpServlet {

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
		PrintWriter out = resp.getWriter();
		
		String blog_id = (String) session.getAttribute("blog");
		
		LoadingBlogContent loadingBlogContent = new LoadingBlogContent(blog_id);
		out.println(loadingBlogContent.loadingContent());
		
		out.flush();
		out.close();
	}

}
