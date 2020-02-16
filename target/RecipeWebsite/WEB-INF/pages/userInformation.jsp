<%@taglib uri="http://www.springframework.org/tags/form" prefix= "form"%>

 <!-- 
 Hermes Mimini and Bryce Schmisseur
 CST-341-TF300
 CLC Final Project
 Page fragment for displaying the user the login form page
  -->

<h2>User Information</h2>

First Name: ${user.firstName}<br>
Last Name: ${user.lastName}<br>
Email: ${user.email}<br>
Phone Number: ${user.phoneNumber}<br>
User Name: ${user.credentials.userName}<br>

<table>
	<tr>
		<form:form method= "GET" action="/loginRegistration/editUserForm">
			<input type= "submit" value= "Edit">
		</form:form>
	</tr>
	<tr>
		<form:form method= "GET" action="/loginRegistration/deleteUser">
			<input type= "submit" value= "Delete User">
		</form:form>
	</tr>
</table>

<br/>
