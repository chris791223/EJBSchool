<%@page import="com.jac.web.model.Student"%>
<jsp:include page="header.jsp"></jsp:include>

<div class="row">
	<div class="col-sm-3"></div>
	<div class="col-sm-6">
<%
	Student student = (Student)request.getAttribute("student");

	// existing check has been done in the servlet 
	if (student != null) {
%>
		<h1 class="h3 mt-3 mb-3 font-weight-normal">
			Delete Student:
			<%=student.getFullName() %>
		</h1>

		<h4>&nbsp;</h4>

		<h3>
			Are you sure to delete this student?
		</h3>
		<ul>
			<li>Student ID: <%=student.getStudentId() %></li>
			<li>Username: <%=student.getUserName() %></li>
			<li>Full Name: <%=student.getFullName() %></li>
			<li>City: <%=student.getCity() %></li>
			<li>Postal Code: <%=student.getPostalCode() %></li>
		</ul>

		<br />

		<form action="DeleteStudent" method="post">
			<!-- Hidden input for the product id -->
			<input type="hidden" name="studentId" value="<%=student.getStudentId()%>">

			<button class="btn btn-lg btn-primary" type="submit">Delete</button>
			| <a href='Student'>Return to Student List</a>
		</form>
<%
	}
%>

	</div>

	<div class="col-sm-3"></div>
</div>


<jsp:include page="footer.jsp"></jsp:include>