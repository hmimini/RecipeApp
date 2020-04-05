<%@taglib uri="http://www.springframework.org/tags/form" prefix= "form"%>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css" rel="stylesheet"></link>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

<script>
function ConfirmDialog(message) {
    $('<div></div>').appendTo('body')
        .html('<div><h6>' + message + '?</h6></div>')
        .dialog({
        modal: true,
        title: 'Delete Confirmation',
        zIndex: 10000,
        autoOpen: true,
        width: 375,
        height: 230,
        resizable: true,
        buttons: {
            Yes: function() {

            $("#deleteForm").submit();

            $(this).dialog("close");
            },
            No: function() {
            $(this).dialog("close");
            }
        },
        close: function(event, ui) {
            $(this).remove();
        }
        });
    };
</script>

 <!-- 
 Hermes Mimini and Bryce Schmisseur
 CST-341-TF300
 CLC Final Project
 Page fragment for displaying the user the login form page
  -->

<h2>Full Recipe</h2>
<p> Name: ${recipe.name} </p>
<p> Ingredients: ${recipe.ingredients}</p>
<p> Price: ${recipe.price}</p>
<p> Nutritional Information: ${recipe.nutritionalInformation}</p>
<p> Description: ${recipe.description}</p>

<table>
	<tr>
		<form:form method= "GET" action="/recipe/editRecipeForm">
			<input type= "submit" value= "Edit">
		</form:form>
	</tr>
	<tr>
		<input type= "submit" value= "Delete" onclick='ConfirmDialog("Are you sure")'>
		<form:form method= "POST" action="/recipe/deleteRecipe" id="deleteForm">
		</form:form>
	</tr>
</table>

<br/>
