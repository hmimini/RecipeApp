<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix= "form"%>

	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"></link>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>

<script>

function getBlogs()
{	
	var blog;
	var userID  = document.getElementById("userID").value;
	var table;
	$.ajax(
		{
			type: "GET",
			url: "/v1/userBlogs?userID=".concat(userID),
			dataType: "json",
						
			success: function(data)
			{
				table = $('#usersPostTable').dataTable({
					"data": data,
					"columns": [{"data": "blogTitle"}, {"data": "blogBody"}]
				});		
			},
			
			error: function (xhr, ajaxOptions, thrownError) 
			{
				alert(xhr.status);
				alert(thrownError);
			}
		})
}

$(document).ready(getBlogs);
</script>

<h2>My Blog Post</h2>

<input type="hidden" id="userID" value="${userID}">

<table style="width:60%" border="1">
	<tr>
		<th><label>Blog Title</label></th>
		<th><label>Blog Body</label></th>
		<th><label>View Post</label></th>
	</tr>
	
	<c:forEach var="blog" items="${blogs}">
		<tr>
			<td><label>${blog.blogTitle}</label></td>
			<td><label>${blog.blogBody}</label></td>
			<td>
			<form:form method= "POST" action="/blog/fullBlogPost">
				<input type="hidden" name="blogTitle" value="${blog.blogTitle}">
				<input type="hidden" name="blogBody" value="${blog.blogBody}">
				<input type= "submit" value= "View Post">
			</form:form>
			</td>
		</tr>
	</c:forEach>
</table>
<br><br>
