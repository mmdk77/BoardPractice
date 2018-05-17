package com.spring.user.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.user.domain.UserVO;

@Repository("userDAOJDBC")
public class UserDAOJDBC implements UserDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	private final String USER_GET = "select * from users where id=? and password=?";

	@Override
	public UserVO getUser(UserVO vo) {
		// TODO Auto-generated method stub
		
		System.out.println("@@@@@@@@@@@@@@@"+vo.toString());
		
		
		UserVO user=template.queryForObject(USER_GET, new RowMapper<UserVO>() {

			@Override
			public UserVO mapRow(ResultSet rs, int rows) throws SQLException {
				// TODO Auto-generated method stub
				UserVO user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				
				System.out.println(user.toString());
				return user;
			}
		},vo.getId(),vo.getPassword());
		System.out.println("%%%%%%%%%%%%%%%%%%%"+vo.toString());
		
		return user;
	}
	

	
}
