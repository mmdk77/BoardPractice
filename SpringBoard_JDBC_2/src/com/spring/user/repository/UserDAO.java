package com.spring.user.repository;

import com.spring.user.domain.UserVO;

public interface UserDAO {
	public UserVO getUser(UserVO vo);
}
