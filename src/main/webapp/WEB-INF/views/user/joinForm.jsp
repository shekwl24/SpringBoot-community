<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<label for="username">아이디</label> 
			<input type="text" class="form-control" placeholder="Enter ID" id="username" >
		</div>
		<p id="usernameMsg" style="color:#ff0000; display:none">이미 사용중인 아이디입니다.</p>
		<div class="form-group">
			<label for="password">패스워드</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		
		<div class="form-group">
			<label for="email">이메일</label> 
			<input type="email" class="form-control" placeholder="Enter email" id="email">
		</div>
	</form>
	<button type="submit" id="btn-save" class="btn btn-primary">회원가입완료</button>
</div>

<script src="/js/joinRule.js"></script>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>