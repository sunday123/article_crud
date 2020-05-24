package com.ij34.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ij34.dao.ArticleDao;
import com.ij34.model.article;

public class addArticle extends HttpServlet{

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
		article art=new article();
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		art.setTitle(new String(title.getBytes("ISO-8859-1"),"UTF-8"));
		art.setContent(new String(content.getBytes("ISO-8859-1"),"UTF-8"));
		ArticleDao ad=new ArticleDao();
		ad.addArticle(art);
		req.getRequestDispatcher("showArticle").forward(req, resp);
	}
   
}
