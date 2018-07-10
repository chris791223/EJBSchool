<%@page import="com.jac.web.model.Teacher"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.jac.web.model.Student"%>
<jsp:include page="header.jsp"></jsp:include>

<h3 class="mt-5 mb-3 text-center">Students</h3>

<%
if (session.getAttribute("user") instanceof Teacher){
%>
	<a href="StudentForm.jsp" class="btn btn-primary mb-3">New Student</a>
<%
}
%>

<table class="table">
	<thead>
		<tr>
			<th scope="col">Student ID</th>
			<th scope="col">Username</th>
			<th scope="col">Full Name</th>
			<th scope="col">City</th>
			<th scope="col">Postal Code</th>
			<%
			if (session.getAttribute("user") instanceof Teacher){
			%>	
				<th scope="col"></th>
			<%
			}	
			%>
			
		</tr>
	</thead>
	<tbody>

		<!-- This zone is for foreach loop -->
	<%
	List<Student> stdList = (ArrayList<Student>) request.getAttribute("studentList");

	if (stdList != null) {
		for (Student s : stdList) {
	%>
		<tr>
			<td><%=s.getStudentId() %></td>
			<td><%=s.getUserName() %></td>
			<td><%=s.getFullName() %></td>
			<td><%=s.getCity() %></td>
			<td><%=s.getPostalCode() %></td>
			
		<%
		if (session.getAttribute("user") instanceof Teacher){
		%>	
			<td>
				<a href="EditStudent?id=<%=s.getStudentId() %>">Edit</a> | 
				<a href="DeleteStudent?id=<%=s.getStudentId() %>">Delete</a> 
			</td>
		<%
		}	
		%>
			
		</tr>
	<%
		}
	}
	%>
	</tbody>
</table>

<jsp:include page="footer.jsp"></jsp:include>