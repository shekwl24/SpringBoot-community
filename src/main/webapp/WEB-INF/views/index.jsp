<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="now" class="java.util.Date" />

<fmt:formatDate var="today" value="${now}" pattern="yyyy-MM-dd" />
<fmt:parseNumber var ="tmp" integerOnly="true" value ="${boards.number / 10}"/>
<fmt:parseNumber var ="first_page" integerOnly="true" value ="${tmp * 10}"/>

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
		
		<%-- 글 목록 --%>
		<c:forEach var="board" items="${boards.content}">
			<fmt:parseNumber var="board_id" integerOnly="true" value ="${(board.id / 10) + 1}"/>
			<tr>
				<td align="center">${board_id}</td>
				<td width=650px style="table-layout: fixed">
					<a style="color: #000000" href="/board/${board.id}">${board.title} </a>
					<a href="/board/${board.id}">
						<span style="color: #25710A; font-weight:bold">[${fn:length(board.replys)}]</span>			
					</a>
				</td>
				<td align="center">${board.user.username}</td>
				<c:choose>
					<%-- 오늘날짜와 작성일 날짜가 같다면 --%>
					<c:when test="${today == fn:substring(board.createDate,0,10)}">
						<%-- HH:mm 형식으로 표시 --%>
						<td align="center">${fn:substring(board.createDate,11,16)}</td>
					</c:when>
					
					<%-- 작성일 날짜가 오늘 날짜 이전이라면 --%>
					<c:otherwise>
						<%-- yyyy-MM-DD 형식으로 표시 --%>
						<td align="center">${fn:substring(board.createDate,0,10)}</td>
					</c:otherwise>
				</c:choose>
				
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
		<%-- Previous 버튼 --%>
		<c:choose>
			<%-- 현재 페이지가 첫번째 페이지라면 --%>
			<c:when test="${boards.first}">
				<%-- Previous 버튼 숨김 --%>
				<li class="page-item prev" style="display:none"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item prev"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>
		
		<%-- 페이지 버튼 --%>
		<%-- 페이지 번호는 10개단위 --%>
        <c:forEach var="counter" begin="${first_page}" end="${first_page+9}">
	    	<c:if test="${counter <= boards.totalElements / 10}">
	    		<%-- 현재 페이지에 해당되는 버튼이라면 --%>
	        	<c:if test="${counter == boards.number}">
	        		<%-- active 클래스 활성화 --%>
	        		<li class="page-item active"><a class="page-link" href="?page=${counter}">${counter + 1}</a></li>
	        	</c:if>
	        	<c:if test="${counter != boards.number}">
	        		<li class="page-item"><a class="page-link" href="?page=${counter}">${counter + 1}</a></li>
	        	</c:if>
	        </c:if>
      	</c:forEach>

		<%-- Next 버튼 --%>
		<c:choose>
			<%-- 현재 페이지가 마지막 페이지라면 --%>
			<c:when test="${boards.last}">
				<%-- Next 버튼 숨김 --%>
				<li class="page-item next" style="display:none"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			</c:when> 
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>
	</ul>

</div>
<%@ include file="layout/footer.jsp"%>