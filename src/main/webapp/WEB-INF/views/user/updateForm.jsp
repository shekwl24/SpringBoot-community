<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<input type="hidden" id="id" value="${principal.user.id}"/>
		<div class="form-group">
			<label for="username">Username</label>
			<input type="text" value="${principal.user.username}"class="form-control" placeholder="Enter Username" id="username" readonly>
		</div>
		
		<div class="form-group">
			<label for="password">Change Password</label> 
			<input type="password" class="form-control" placeholder="Enter Password" id="password">
		</div>
		
		<div class="form-group">
			<label for="email">Change Email</label> 
			<input type="email" value="${principal.user.email}"class="form-control" placeholder="Enter email" id="email">
		</div>	
	</form>
	
	<button id="btn-update" class="btn btn-primary">회원수정완료</button>
	<button id="btn-withdraw" class="btn btn-danger">회원 탈퇴</button>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>