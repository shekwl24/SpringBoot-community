<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<aside class="col-md-4 offset-md-4">
		<div class="card">
			<article class="card-body">
				<h4 class="card-title text-center mb-4 mt-1">Login</h4>
				<hr>
				<p class="text-danger text-center">${failMsg}</p>
				<form action="/auth/loginProc" method="post">
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
							<input id="password" name="password" class="form-control" placeholder="******" type="password">
						</div>
					</div>
					<div class="form-group">
						<button id="btn-login" class="btn btn-primary btn-block">Login</button>
					</div>
				</form>
			</article>
		</div>
	</aside>
</div>

<%@ include file="../layout/footer.jsp"%>