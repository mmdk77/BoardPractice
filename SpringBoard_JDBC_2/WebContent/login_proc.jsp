<%@page import="com.spring.user.repository.UserDAOJDBC"%>
<%@ page import="com.spring.user.repository.UserDAO"%>
<%@ page import="com.spring.user.domain.UserVO"%>
<%@page contentType="text/html; charset=EUC-KR" %>

<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");

	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);

	UserDAOJDBC userDAO = new UserDAOJDBC();
	UserVO user = userDAO.getUser(vo);

	if (user != null) {
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>