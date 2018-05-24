<%@page import="com.spring.board.common.PagingBean"%>
<%@page import="com.spring.board.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! PagingBean pb=new PagingBean();%>
<%

	List<Board> list = (List<Board>) request.getAttribute("list");
	out.print(list.size()+"개");
	pb.initPage(list.size(), request);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	form
</script>
<center>
	<h1>게시판 목록</h1>
	<hr>
	<table>
		<thead>
			<tr>
				<th>#</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>날짜</th>
				<th>추천수</th>
			</tr>
		</thead>
		<tbody>
			<%
				int num=pb.getNum();
				int curPos = pb.getCurPos();
			%>
			<%for(int a=1; a<pb.getPageSize(); a++) {%>
			<%if(num<1)break; %>
			<%Board board = list.get(curPos++); %>
			<tr align="center" height="50px">
				<td width="50"><%=num--%></td>
				<td width="300"><a href="/board/<%=board.getBoard_seq()%>"><%=board.getTitle()%></a></td>
				<td width="100"><%=board.getWriter()%></td>
				<td width="100"><%=board.getRegdate().substring(0, 10) %></td>
				<td width="50"><%=board.getCnt() %></td>
			</tr>
			<%} %>
			<tr>
				<td height="1" colspan="5" align="center">
					<%if(pb.getFirstPage()-1<1){ %>
						<a href="javascript:alert('이전페이지가 없습니다.')">◀</a>
					<%}else{%>
						<a href="/board/list?currentPage=<%=pb.getFirstPage()-1%>">◀</a>
					<% }%>
					
					<%for(int i=pb.getFirstPage();i<=pb.getLastPage();i++){ %>
						<%if(pb.getTotalPage()<i) break;%>
							<a <%if(pb.getCurrentPage()==i){%> <%} %>href="/board/list?currentPage=<%=i%>">[<%=i %>]</a>
					<%} %>	
					<%if(pb.getLastPage()+1>=pb.getTotalPage()){ %>	
						<a href="javascript:alert('다음페이지가 없습니다.')">▶</a>
					<%}else{ %>
						<a href="/board/list?currentPge=<%=pb.getLastPage()+1%>">▶</a>
					<%} %>
				</td>
			</tr>
		</tbody>
	</table>
	<hr>
	
	<select>
			<option>제목</option>
			<option>작성자</option>
	</select>
	<input type="text" name="select">
	<input type="submit" value="검색">
	
	<form action="/board/writeForm" method="post">
		<input type ="submit" value="글쓰기">
	</form>
	<hr>
	
</center>


</body>
</html>