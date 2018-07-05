<jsp:include page="header.jsp"></jsp:include>

<h3 class="mt-5 mb-3 text-center">Books</h3>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Book Id</th>
      <th scope="col">Name</th>
      <th scope="col">Author</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  
  <!-- This zone is for foreach loop --> 
    <tr>
      <td>Id1</td>
      <td>Name1</td>
      <td>Author1</td>
      <td>
			<a href="#">Add</a> |
			<a href="#">Details</a> |
			<a href="#">Delete</a> |
			<a href="#">Modify</a>
		</td>
    </tr>
    <tr>
      <td>Id2</td>
      <td>Name2</td>
      <td>Author2</td>
      <td>
			<a href="#">Add</a> |
			<a href="#">Details</a> |
			<a href="#">Delete</a> |
			<a href="#">Modify</a>
		</td>
    </tr>
    <tr>
      <td>Id3</td>
      <td>Name3</td>
      <td>Author3</td>
      <td>
		<a href="#">Add</a> |
		<a href="#">Details</a> |
		<a href="#">Delete</a> |
		<a href="#">Modify</a>
	  </td>
    </tr>
  </tbody>
</table>

<jsp:include page="footer.jsp"></jsp:include>