<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<aside class="col-md-4 offset-md-4">
		<div class="card">
			<article class="card-body">
				<h4 class="card-title text-center mb-4 mt-1">Create Account</h4>
				<hr>
				<p id="usernameMsg" class="text-danger text-center"></p>
				<form>
					<input type="hidden" id="isPossibleUsername" value="false"/>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i class="fa fa-user"></i>
								</span>
							</div>
							<input id="username" name="username" class="form-control" placeholder="Enter username" type="text" autofocus>
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i class="fa fa-lock"></i>
								</span>
							</div>
							<input id="password" name="password" class="form-control" placeholder="Enter Password" type="password">
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i class="fa fa-envelope"></i>
								</span>
							</div>
							<input id="email" name="email" class="form-control" placeholder="Email address" type="email">
						</div>
					</div>
				</form>
				<button type="submit" id="btn-save" class="btn btn-primary btn-block">Create Account</button>
			</article>
		</div>
	</aside>
</div>

<script src="/js/joinRule.js"></script>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>