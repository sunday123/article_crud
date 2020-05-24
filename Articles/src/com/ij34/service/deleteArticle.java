package com.ij34.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ij34.dao.ArticleDao;

public class deleteArticle extends HttpServlet{

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
		String idStr=req.getParameter("id");
		if(idStr!=null&&!idStr.equals("")){
			int id=Integer.valueOf(idStr);
			ArticleDao ad=new ArticleDao();
			ad.deleteArticle(id);
		}
		req.getRequestDispatcher("showArticle").forward(req, resp);
	}

}
