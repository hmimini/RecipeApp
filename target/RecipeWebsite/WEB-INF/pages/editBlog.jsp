<%@taglib uri="http://www.springframework.org/tags/form" prefix= "form"%>

 <!-- 
 Hermes Mimini and Bryce Schmisseur
 CST-341-TF300
 CLC Final Project
 Page fragment for displaying the user the login form page
  -->
<h2>Edit Blog</h2>
<form:form method= "POST" modelAttribute= "blog" action= "editBlogPost">
	<table>
	<tr>
		<td><form:label path="blogTitle">Blog Title:</form:label></td>
		<td><form:input path="blogTitle" value="${blog.blogTitle}"/><form:errors path="blogTitle"/></td>
	</tr>
	
	<tr>
		<td><form:label path="blogBody">Blog Body</form:label></td>
		<td> <br><form:textarea path="blogBody" value="${blog.blogBody}"/><form:errors path="blogBody"/></td>
	</tr>
		
	<tr>
		<td colspan= "2">
		<div align="center">
		<input type= "submit" value= "Save Changes">
		</div>
		</td>
	</tr>	
	</table>
	<br/>
</form:form>
${message}
<br/>