<%@page import="java.util.ArrayList"%>
<%@page import="com.jac.web.model.Book"%>
<jsp:include page="header.jsp"></jsp:include>

<h3 class="mt-5 mb-3 text-center">Books</h3>

<% String username = (String)session.getAttribute("username");
if(username != null && username.equals("teacher")){%>

<a href="newBook.jsp" class="btn btn-primary mb-3">New Book</a>
<%} %>

<% ArrayList<Book> books = (ArrayList<Book>)request.getAttribute("books");
	if(books == null){
%>
	<h1> There are no book in the library.</h1>
<%}else{ %>
	<form action="Library" method="post">
		<input type="hidden" id="command" name="command" value="search">
		<div class="row">
			<div class="input-group mb-3 col col-sm-2">
			  <div class="input-group-prepend">
			    <label class="input-group-text" for="inputGroupSelect01">Options</label>
			  </div>
			  <select class="custom-select" id="option" name="option">
			    <option value="1">Title</option>
			    <option value="2">Author</option>
			  </select>
			</div>
			<div class="form-group col col-sm-10">
		      <input type="text" class="form-control" id="keyword" name="keyword" placeholder="Book Title for Search">
		    </div>
		</div>
	</form>	
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Book Id</th>
	      <th scope="col">Name</th>
	      <th scope="col">Author</th>
	      <th scope="col"></th>
	      <th scope="col"></th>
	    </tr>
	  </thead>
	  <tbody>

	<%for(Book book : books){ %>	  
	    <tr>
	      <td><%=book.getId() %></td>
	      <td><%=book.getName() %></td>
	      <td><%=book.getAuthor() %></td>
	      <% if(username != null && username.equals("teacher")){ %>
				<td scope="col" style="text-align:right">
					<form action="Library" method="post">
					    <input type="hidden" id="command" name="command" value="delete" />								
						<input type="hidden" id="bId" name="bId" value="<%= book.getId() %>">
						<button type="submit" class="btn btn-sm btn-Danger">Delete</button>
					</form>
				</td>
				<td scope="col" style="text-align:right">
					<form action="Library" method="post">
					    <input type="hidden" id="command" name="command" value="update" />								
						<input type="hidden" id="bId" name="bId" value="<%= book.getId() %>">
						<button type="submit" class="btn btn-sm btn-Danger">Modify</button>
					</form>
				</td>
		  <%} %>
	    </tr>
    <%} %>
	  </tbody>
	</table>
<%} %>
<jsp:include page="footer.jsp"></jsp:include>