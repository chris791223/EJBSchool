<jsp:include page="header.jsp"></jsp:include>

<h3 class="mt-5 mb-3 text-center">Students</h3>
<a href="newStudent.jsp" class="btn btn-primary mb-3">New Student</a>
<table class="table">
	<thead>
		<tr>
			<th scope="col">User name</th>
			<th scope="col">Password</th>
			<th scope="col">First Name</th>
			<th scope="col">Last Name</th>
			<th scope="col">City</th>
			<th scope="col">Postal Code</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<tbody>
	
	<!-- This zone is for foreach loop -->
	
		<tr>
			<td>Username1</td>
			<td>Password1</td>
			<td>FN1</td>
			<td>LN1</td>
			<td>City1</td>
			<td>Code1</td>
			<td>
				<a href="#">Details</a> | 
				<a href="#">Delete</a> |
				<a href="#">Modify</a>
			</td>
		</tr>
		<tr>
			<td>Username2</td>
			<td>Password2</td>
			<td>FN2</td>
			<td>LN2</td>
			<td>City2</td>
			<td>Code2</td>
			<td>
				<a href="#">Details</a> |
				<a href="#">Delete</a> |
				<a href="#">Modify</a>
			</td>
		</tr>
		<tr>
			<td>Username3</td>
			<td>Password3</td>
			<td>FN3</td>
			<td>LN3</td>
			<td>City3</td>
			<td>Code3</td>
			<td>
				<a href="#">Details</a> |
				<a href="#">Delete</a> |
				<a href="#">Modify</a>
			</td>
		</tr>
	</tbody>
</table>

<jsp:include page="footer.jsp"></jsp:include>