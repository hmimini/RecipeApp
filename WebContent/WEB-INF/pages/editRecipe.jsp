<%@taglib uri="http://www.springframework.org/tags/form" prefix= "form"%>

 <!-- 
 Hermes Mimini and Bryce Schmisseur
 CST-341-TF300
 CLC Final Project
 Page fragment for displaying the user the login form page
  -->
<h2>Edit Blog</h2>
<form:form method= "POST" modelAttribute= "recipe" action= "editRecipePost">
	<table>
	<tr>
		<td><form:label path="name">Recipe Name:</form:label>
		<td><form:input path="name" value="${recipe.name}"/><form:errors path="name"/></td>
	</tr>
	<tr>
		<td><form:label path="ingredients">Ingredients</form:label><br>
		<td><form:textarea path="ingredients" value="${recipe.ingredients}"></form:textarea><form:errors path="ingredients"/></td>
	</tr>
	<tr>
		<td><form:label path="nutritionalInformation">Nutritional Information</form:label><br>
		<td><form:textarea path="nutritionalInformation" value="${recipe.nutritionalInformation}"></form:textarea><form:errors path="nutritionalInformation"/></td>
	</tr>
	<tr>
		<td><form:label path="price">Price</form:label><br>
		<td><form:textarea path="price" value="${recipe.price}"></form:textarea><form:errors path="price"/></td>
	</tr>
	<tr>
		<td><form:label path="description">Description</form:label><br>
		<td><form:textarea path="description" value="${recipe.description}"></form:textarea><form:errors path="description"/></td>
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