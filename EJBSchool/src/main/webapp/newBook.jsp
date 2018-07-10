<%@page import="com.jac.web.model.Book"%>
<jsp:include page="header.jsp"></jsp:include>

<%String username = (String)session.getAttribute("username");
if(username == null || !username.equals("teacher")){%>
	<h1>You don't have the authority to add products.  Sorry</h1><br/><br/>
	<a href="<%=request.getContextPath() %>/Library" class="btn btn-primary"> Go back to books list</a>
<%}else{
	Book book = (Book)request.getAttribute("book");
	if(book == null){
		book = new Book();
		book.setId(0);
		book.setName("");
		book.setAuthor("");
	}
%>
<br/><br>
<div class="row">
	<div class=col-md-4></div>
	<div class="col-md-4">
		<form action="Library" method="post">
			<input type="hidden" id="command" name="command" value="edit">
			<input type="hidden" id="bId" name="bId" value="<%=book.getId() %>">
			<h1 class="h3 mt-3 mb-3 font-weight-normal">
			<%if(book.getId() <= 0){ %>
			Create New Book
			<%}else{ %>Modify Book <%} %>
			</h1>
			
			<% String error = (String)request.getAttribute("error");
			if(error != null && error != ""){%>
				<p class="text-danger"><%= error %></p>
			<% }%>
			
			<label for="name">Title</label>
			<input type="text" name="name" class="form-control mb-2" value="<%=book.getName() %>" placeholder="Titile"
				required autofocus>
						
				
			<label for="author">Author</label>
			<input type="text" name="author" class="form-control mb-2" value="<%=book.getAuthor() %>" placeholder="Author"
				required>
				 
			<br><br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">
			<% if(book.getId() <= 0){ %>Create<%}else{ %>Update<%} %>
			</button>
		</form>
	</div>
	<div class=col-md-4></div>
</div>
<%} %>
<jsp:include page="footer.jsp"></jsp:include>