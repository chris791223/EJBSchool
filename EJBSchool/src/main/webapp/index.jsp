<jsp:include page="header.jsp"></jsp:include>
<div class="row">
	<div class=col-md-3></div>
	<div class="text-center col-md-6">
		<form action="LoginController" method="post" class="form-signin">
			<p style="color:red;"><% 
				if(request.getAttribute("error") != null)
				out.print(request.getAttribute("error"));%>
			</p>
			<h1 class="h3 mt-3 mb-3 font-weight-normal">Please sign in</h1>
			<label for="inputEmail" class="sr-only">User name</label> 
			<input type="text" class="form-control mb-2" name="username" placeholder="Username"
				required autofocus /> 
			<label for="password" class="sr-only">Password</label>
			<input type="password" class="form-control mb-2" name="password"
				placeholder="Password" required>
			<input type="hidden" name="command" value="login"/>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form>
	</div>
</div>
<div class=col-md-3></div>
<jsp:include page="footer.jsp"></jsp:include>