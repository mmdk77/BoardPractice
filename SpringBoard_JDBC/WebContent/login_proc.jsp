<%@ page import="com.srping.user.repository.UserDAO"%>
<%@ page import="com.spring.user.domain.UserVO"%>

<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");

	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);

	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);

	if (user != null) {
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>