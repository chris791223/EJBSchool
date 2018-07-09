<%@page import="com.jac.web.model.Student"%>
<jsp:include page="header.jsp"></jsp:include>

<div class="row">
	<div class=col-md-4></div>
	<div class="col-md-4">
		
	<%
		Student student = (Student)request.getAttribute("student");
				
		// CASE: CREATE A NEW STUDENT
		if (student == null) {
			
			student = new Student();
					
	%>
			<h1 class="h3 mt-3 mb-3 font-weight-normal">Create New Student</h1>
	<%	
		} 
		// EDIT STUDENT
		else {
	%>
			<h1 class="h3 mt-3 mb-3 font-weight-normal">Edit Student: <%=student.getFullName() %></h1>
	<%
		}
	%>
		

		<form action="Student" method="post" class="form-signin">
			
			<!-- Hidden input for the student id -->
			<input type="hidden" name="studentId" value="<%=student.getStudentId() %>">

			<div class="form-group">
				<label for="name">Username:</label> 
				<input type="text" id="userName" name="userName" required="required"
					class="form-control" value="<%=student.getUserName() == null ? "" : student.getUserName() %>"
					placeholder="Please choose a username for login">
			</div>
			
			<div class="form-group">
				<label for="name">Password:</label> 
				<input type="password" id="password" name="password" required="required"
					class="form-control" value="<%=student.getPassword() == null ? "" : student.getPassword() %>"
					placeholder="Please enter Password">
			</div>
			
			<div class="form-group">
				<label for="name">First Name:</label> 
				<input type="text" id="firstName" name="firstName" required="required"
					class="form-control" value="<%=student.getFirstName() == null ? "" : student.getFirstName() %>"
					placeholder="Smith">
			</div>
			
			<div class="form-group">
				<label for="name">Last Name:</label> 
				<input type="text" id="lastName" name="lastName" required="required"
					class="form-control" value="<%=student.getLastName() == null ? "" : student.getLastName() %>"
					placeholder="White">
			</div>
			
			<div class="form-group">
				<label for="name">City:</label> 
				<input type="text" id="city" name="city" required="required"
					class="form-control" value="<%=student.getCity() == null ? "" : student.getCity() %>"
					placeholder="Please enter City">
			</div>
			
			<div class="form-group">
				<label for="name">Postal Code:</label> 
				<input type="text" id="postalCode" name="postalCode" required="required"
					class="form-control" value="<%=student.getPostalCode() == null ? "" : student.getPostalCode() %>"
					placeholder="A1B 2C3">
			</div>
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
		</form>
	</div>
	<div class=col-md-4></div>
</div>

<jsp:include page="footer.jsp"></jsp:include>