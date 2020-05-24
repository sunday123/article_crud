package com.ij34.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ij34.dao.ArticleDao;
import com.ij34.model.article;

public class showArticle extends HttpServlet{

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
		ArticleDao ad=new ArticleDao();
		List<article> list=ad.getfindAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("show.jsp").forward(req, resp);
	}
   
}
