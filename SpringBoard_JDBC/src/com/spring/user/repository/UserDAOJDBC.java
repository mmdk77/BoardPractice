package com.spring.user.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.user.domain.UserVO;

@Repository("userDAOJdbc")
public class UserDAOJDBC {

	@Autowired
	private JdbcTemplate template;
	
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	private static final String USER_GET = "select * from users where id=? and password=?";

	public UserVO getUser(UserVO vo) {

		vo=template.queryForObject(USER_GET, new RowMapper<UserVO>() {
			@Override
			public UserVO mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				UserVO vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				System.out.println(vo);
				return vo;
			}

		},vo);
		System.out.println(vo);
		return vo;
	}
}
