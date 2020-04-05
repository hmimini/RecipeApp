<%@taglib uri="http://www.springframework.org/tags/form" prefix= "form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

 <!-- 
 Hermes Mimini
 Page fragment for displaying the user the login form page
  -->
<spring:url value="/resources/pictures/ErrorImage.png" var="errorImage" />
  
<div class="errorPage">
<table>
	<tr>
		<td width="300"><h2>Recipe Website</h2></td>
		<td rowspan=2> <img src="${errorImage}" alt="Error Image" height="75" width="75"> </td>
	</tr>
	<tr>
		<td><p>We have seem to run into a problem processing your request! Please go back and try again!</p></td>
		<td>${e.printStackTrace()}</td>
	</tr>
</table>
</div>