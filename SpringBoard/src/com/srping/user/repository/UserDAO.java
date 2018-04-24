package com.srping.user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.spring.common.JDBCUtil;
import com.spring.user.domain.UserVO;

@Repository("userDAO")
public class UserDAO {

	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	private final String USER_GET ="select * from users where id=? and password=?";
	
	public UserVO getUser(UserVO vo){
		UserVO user = null;
		System.out.println("===>JDBC getUser() 기능 처리");
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()){
				user=new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, pstmt, con);
		}
		return user;
	}
}
