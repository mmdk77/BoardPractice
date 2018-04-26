<%@page import="com.spring.board.repository.BoardDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.spring.board.repository.BoardDAOJDBC"%>
<%@page import="com.spring.board.domain.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


<%
	BoardVO vo = new BoardVO();
	BoardDAOJDBC boardDAO = new BoardDAOJDBC();
	List<BoardVO> boardList = boardDAO.getBoardList(vo);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>�۸��</h1>
		<h3>
			�׽�Ʈ�� ȯ���մϴ�...<a href="logout_proc.jsp">�α׾ƿ�</a>
		</h3>

		<form action="getBoardList.jsp" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
						<select name="searchCondition">
							<option value="title">����
							<option value="content">����
						</select>
						<input name="searchKeyword" type="text">
						<input type="submit" value="�˻�">
					</td>
				</tr>
			</table>
		</form>
		
		
		<table border="1"	cellpadding="0" cellspacing="0" width="700">
		<tr>
			<th width="700">��ȣ</th>
			<th width="700">����</th>
			<th width="700">�ۼ���</th>
			<th width="700">�����</th>
			<th width="700">��ȸ��</th>

		</tr>
		<% for(BoardVO board:boardList){ %>
		<tr>
			<td><%=board.getBoard_seq() %></td>
			<td align="left"><a href="getBoard.jsp?seq=<%=board.getBoard_seq()%>"><%=board.getTitle() %></a></td>
			<td><%=board.getWriter() %></td>
			<td><%=board.getContent() %></td>
			<td><%=board.getRegdate() %></td>
			<td><%=board.getCnt() %></td>
	
		</tr>
		<%} %>
		</table>
		<br>
		<a href="insertBoard.jsp">�۾���</a>
	</center>



</body>
</html>