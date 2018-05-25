<%@page import="com.spring.common.paging.PagingBean"%>
<%@page import="com.spring.board.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!PagingBean pm = new PagingBean();%>

<%
	List<Board> list = (List) request.getAttribute("list");
	pm.init(list.size(), request);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>글 목록</h1>
		<hr>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>추천</th>
				</tr>
			</thead>
			<tbody>
				<%
					int num = pm.getNum();
					int curPos = pm.getCurPos();
				%>
				<%
					for (int i = 1; i < pm.getPageSize(); i++) {
						if (num < 1)
							break;
						Board board = list.get(curPos++);
				%>

				<tr align="center" height="30px">
					<td width="30px"><%=num--%></td>
					<td width="500px"><a href="/board/<%=board.getBoard_seq()%>"><%=board.getTitle()%></a></td>
					<td width="90px"><%=board.getWriter()%></td>
					<td width="100px"><%=board.getRegdate().substring(0, 10)%></td>
					<td width="60px"><%=board.getCnt()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
			<tfoot>
				<tr>

					<td colspan="5" align="center">
						<%
							for (int i = pm.getFirstPage(); i <= pm.getLastPage(); i++) {
								if (pm.getTotalPage() < i)
									break;
						%>
							 <a href="/board/list?currentPage=<%=i%>">[<%=i%>]</a>
						<%
							}
						%>
					</td>
					
				</tr>

			</tfoot>
		</table>
	</center>
</body>
</html>