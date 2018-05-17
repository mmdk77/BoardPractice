package com.spring.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.user.domain.UserVO;
import com.spring.user.repository.UserDAOJDBC;

@Service("userService")
public class UserSeviceImpl implements UserService {

	@Autowired
	private UserDAOJDBC userDAOJdbc;
	
	@Override
	public UserVO getUser(UserVO vo) {
		// TODO Auto-generated method stub
		System.out.println("###################"+vo.toString());
		return userDAOJdbc.getUser(vo);
	}

}
