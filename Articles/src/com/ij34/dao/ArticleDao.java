package com.ij34.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ij34.model.article;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ArticleDao {
   
	public List<article> getfindAll(){  //查All，返回list
		List<article> list=new ArrayList<article>();
		String sql="select * from article";
		Connection conn=DbConn.getConnection();
		try {
			PreparedStatement pstm=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				article art=new article();
				art.setId(rs.getInt("id"));
				art.setTitle(rs.getString("title"));
				art.setContent(rs.getString("content"));
				list.add(art);
			}
			rs.close();
			pstm.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
		
	}
	
	public boolean addArticle(article art){ //增
		String sql="insert into article(title,content)values(?,?)";
		Connection conn=DbConn.getConnection();
		try {
			PreparedStatement pstm=(PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, art.getTitle());
			pstm.setString(2, art.getContent());
			int count=pstm.executeUpdate();
			pstm.close();
			if(count>0) return true;
			else return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean updateArticle(article art){ //修改
		String sql="update article set title=?,content=? where id=?";
		Connection conn=DbConn.getConnection();
		try {
			PreparedStatement pstm=(PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, art.getTitle());
			pstm.setString(2, art.getContent());
			pstm.setInt(3, art.getId());
			int count=pstm.executeUpdate();
			pstm.close();
			if(count>0) return true;
			else return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean deleteArticle(int id){  //删除，根据id
		String sql="delete from article where id=?";
		Connection conn=DbConn.getConnection();
		try {
			PreparedStatement pstm=(PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);  //id不可以写在上面sql上
			int count=pstm.executeUpdate();
			pstm.close();
			if(count>0) return true;
			else return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public article selectById(int id){//根据id查找
		String sql="select * from article where id="+id;
		Connection conn=DbConn.getConnection();
		article art=null;
		try {
			PreparedStatement pstm=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				art=new article();
				art.setId(rs.getInt("id"));
				art.setTitle(rs.getString("title"));
				art.setContent(rs.getString("content"));
			}
			rs.close();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return art;
	}
}
