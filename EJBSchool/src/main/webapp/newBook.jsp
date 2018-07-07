<jsp:include page="header.jsp"></jsp:include>

<div class="row">
	<div class=col-md-4></div>
	<div class="text-center col-md-4">
		<form action="" method="post" class="form-signin">
			<h1 class="h3 mt-3 mb-3 font-weight-normal">Create New Book</h1>
			<label for="name" class="sr-only">Name</label>
			<input type="text" name="name" class="form-control mb-2" placeholder="Name"
				required autofocus>
				
			<label for="author" class="sr-only">Author</label>
			<input type="text" name="author" class="form-control mb-2" placeholder="Author"
				required>
				 
			<button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>
		</form>
	</div>
	<div class=col-md-4></div>
</div>

<jsp:include page="footer.jsp"></jsp:include>