package com.spring.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","java_jdbc","java_jdbc");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(PreparedStatement pstmt, Connection con){
		if(pstmt!=null){
			try {
				if(!pstmt.isClosed()) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				pstmt=null;
			}
		}
		
		if(con!=null){
			try {
				if(!con.isClosed())con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				con=null;
			}
		}
		
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con){
		if(rs!=null){
			try {
				if(!rs.isClosed())rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				rs =null;
			}
		}
		
		if(pstmt!=null){
			try {
				if(!pstmt.isClosed()) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				pstmt=null;
			}
		}
		
		if(con!=null){
			try {
				if(!con.isClosed())con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				con=null;
			}
		}
	
	}
}
