<jsp:include page="header.jsp"></jsp:include>

<form action="Login" method="post">
	<table>
		<tr>
			<td>User name:</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password"><br></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Login"></td>
		</tr>
	</table>
</form>
<hr>

<jsp:include page="footer.jsp"></jsp:include>