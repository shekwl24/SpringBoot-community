<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>

<div class="container">
	<table class="table table-hover">
		<thead>
		<tr align="center">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="board" items="${boards.content}">
			<tr>
				<td align="center">${board.id}</td>
				<td width=650px style="table-layout: fixed">
					<a style="color: #000000" href="/board/${board.id}">${board.title} </a>
					<a href="/board/${board.id}">
						<span style="color: #25710A; font-weight:bold">[${board.replysCount}]</span>			
					</a>
				</td>
				<td align="center">${board.user.username}</td>
				<td align="center">${fn:substring(board.createDate,0,10)}</td>
				<td align="center">${board.count}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<a class="btn btn-primary float-right" href="/board/saveForm"">글쓰기</a>
	<br />
	<br />
	<br />
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${boards.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${boards.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>
	</ul>

</div>
<%@ include file="layout/footer.jsp"%>