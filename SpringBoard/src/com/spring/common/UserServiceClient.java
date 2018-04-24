package com.spring.common;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.user.domain.UserVO;
import com.srping.user.service.UserService;

public class UserServiceClient {
	
	public static void main(String[] args){
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("com/spring/common/applicationContext.xml");
		UserService userService = (UserService)container.getBean("userService");
		UserVO vo=new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		
		UserVO user = userService.getUser(vo);
		if(user!=null){
			System.out.println(user.getName()+"�� ȯ���մϴ�.");
		}else{
			System.out.println("�α��� ����");
		}
		
		container.close();
		
	}

}
