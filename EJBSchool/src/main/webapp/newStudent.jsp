<jsp:include page="header.jsp"></jsp:include>

<div class="row">
	<div class=col-md-4></div>
	<div class="text-center col-md-4">
		<form action="" method="post" class="form-signin">
			<h1 class="h3 mt-3 mb-3 font-weight-normal">Create New Student</h1>
			<label for="username" class="sr-only">User Name</label>
			<input type="text" name="username" class="form-control mb-2" placeholder="User name"
				required autofocus>
				
			<label for="password" class="sr-only">Password</label>
			<input type="password" name="password" class="form-control mb-2" placeholder="Password"
				required>
				 
			<label for="firstname" class="sr-only">First Name</label>
			<input type="text" name="firstname" class="form-control mb-2"
				placeholder="First Name" required>
				
			<label for="lastname" class="sr-only">Last Name</label>
			<input type="text" name="lastname" class="form-control mb-2"
				placeholder="Last Name" required>
				
			<label for="city" class="sr-only">City</label>
			<input type="text" name="city" class="form-control mb-2"
				placeholder="City">
				
			<label for="postalCode" class="sr-only">Code Postal</label>
			<input type="text" name="postalCode" class="form-control mb-2"
				placeholder="Code Postal">
				
			<button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>
		</form>
	</div>
	<div class=col-md-4></div>
</div>

<jsp:include page="footer.jsp"></jsp:include>