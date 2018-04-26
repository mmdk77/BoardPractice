package com.spring.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.user.domain.UserVO;
import com.spring.user.repository.UserDAO;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	public UserDAO userDAO;
	

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserVO getUser(UserVO vo) {
		// TODO Auto-generated method stub
		return userDAO.getUser(vo);
	}

}
