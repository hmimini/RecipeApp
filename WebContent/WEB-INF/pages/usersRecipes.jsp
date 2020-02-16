<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix= "form"%>

	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"></link>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>

<h2>My Recipes</h2>

<input type="hidden" id="userID" value="${userID}">

<table style="width:60%" border="1">
	<tr>
		<th><label>Name</label></th>
		<th><label>Nutritional Information</label></th>
		<th><label>Price</label></th>
		<th><label>View More</label></th>
	</tr>
	
	<c:forEach var="recipe" items="${recipes}">
		<tr>
			<td><label>${recipe.name}</label></td>
			<td><label>${recipe.nutritionalInformation}</label></td>
			<td><label>${recipe.price}</label></td>
			<td>
			<form:form method= "POST" action="/RecipeWebsite/recipe/fullRecipePost">
				<input type="hidden" name="recipeName" value="${recipe.name}">
				<input type="hidden" name="recipeDescription" value="${recipe.description}">
				<input type="hidden" name="recipeNutritionalInformation" value="${recipe.nutritionalInformation}">
				<input type="hidden" name="recipePrice" value="${recipe.price}">
				<input type="hidden" name="recipeIngredients" value="${recipe.ingredients}">
				<input type= "submit" value= "View Post">
			</form:form>
			</td>
		</tr>
	</c:forEach>
</table>
<br><br>
