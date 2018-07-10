<%@ page import = "com.jac.web.model.Teacher" %>
<jsp:include page="header.jsp"></jsp:include>

<!-- getAttribute -->
<% if(session.getAttribute("user") == null){
	response.sendRedirect("index.jsp");
}
%>

<div class="row">
	<% if(session.getAttribute("user") instanceof Teacher) {%>
	<div class="col-sm-6 mt-5">
		<a href="Student" type="button" class="btn-block btn-primary btn-lg text-center">Students</a>
	</div>
	<%} %>
	<div class="col-sm-6 mt-5">
		<a href="Library" type="button" class="btn-block btn-secondary btn-lg text-center">Books</a>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>