<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">아이디</label>
			<input type="text" name="username" class="form-control" placeholder="Enter ID" id="username">
		</div>
		
		<div class="form-group">
			<label for="pwd">패스워드</label> 
			<input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<button id="btn-login" class="btn btn-primary">로그인완료</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp"%>