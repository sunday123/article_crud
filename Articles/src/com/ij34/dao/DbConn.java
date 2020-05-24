package com.ij34.dao;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;



public class DbConn {
    private static String username="root";
    private static String password="123456";
    private static String url="jdbc:mysql://localhost:3306/testdb?useUnicode=true&characterEncoding=UTF-8";
    private static Connection conn=null;
    
    public static Connection getConnection(){
		if(conn==null){
		    try {
				Class.forName("com.mysql.jdbc.Driver");
				conn=(Connection) DriverManager.getConnection(url, username, password);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return conn;
	}
     
    //test connection
    public static void main(String[] args) {
    	DbConn db=new DbConn();
		System.out.println(db.toString());
	}
}
