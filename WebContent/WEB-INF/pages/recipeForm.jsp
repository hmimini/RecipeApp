<%@taglib uri="http://www.springframework.org/tags/form" prefix= "form"%>

 <!-- 
 Hermes Mimini
 Page fragment for displaying the user the login form page
  -->

<h2>Add Recipe</h2>
<form:form method= "POST" modelAttribute= "recipe" action= "postRecipe">
	<table>
	<tr>
		<td><form:label path="name">Recipe Name:</form:label>
		<td><form:input path="name" /><form:errors path="name"/></td>
	</tr>
	<tr>
		<td><form:label path="ingredients">Ingredients</form:label><br>
		<td><form:textarea path="ingredients"></form:textarea><form:errors path="ingredients"/></td>
	</tr>
	<tr>
		<td><form:label path="nutritionalInformation">Nutritional Information</form:label><br>
		<td><form:textarea path="nutritionalInformation"></form:textarea><form:errors path="nutritionalInformation"/></td>
	</tr>
	<tr>
		<td><form:label path="price">Price</form:label><br>
		<td><form:textarea path="price"></form:textarea><form:errors path="price"/></td>
	</tr>
	<tr>
		<td><form:label path="description">Description</form:label><br>
		<td><form:textarea path="description"></form:textarea><form:errors path="description"/></td>
	</tr>
		
	<tr>
		<td colspan= "2">
		<div align="center">
		<input type= "submit" value= "Post">
		</div>
		</td>
	</tr>	
	</table>
	<br/>
</form:form>
${message}
<br/>