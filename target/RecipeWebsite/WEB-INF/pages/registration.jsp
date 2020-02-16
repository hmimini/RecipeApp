<%@taglib uri="http://www.springframework.org/tags/form" prefix= "form"%>

 <!-- 
 Hermes Mimini and Bryce Schmisseur
 CST-341-TF300
 CLC Final Project
 Page fragment for displaying the user the registration form page
  -->

<div class="midPage" style="padding-top: 10px; padding-bottom: 10px; height: 65%">
<h2>Registration Form</h2><br>
<form:form method= "POST" modelAttribute= "user" action= "registerUser" class="was-validated">
	<table>
	<tr>
		<td>
			<div class="form-group">
				<label for="firstName">First Name: </label>
				<form:input path="firstName" class="form-control" placeholder="Enter First Name" required="required"/>
				<div class="invalid-feedback"><form:errors path="firstName"/></div>
			</div>		
		</td>
	</tr>
	<tr>
		<td>
			<div class="form-group">
				<label for="lastName">Last Name: </label>
				<form:input path="lastName" class="form-control" placeholder="Enter Last Name" required="required"/>
				<div class="invalid-feedback"><form:errors path="lastName"/></div>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div class="form-group">
				<label for="email">Email: </label>
				<form:input type="email" path="email" class="form-control" placeholder="Enter Email" required="required"/>
				<div class="invalid-feedback"><form:errors path="email"/></div>
			</div>			
		</td>
	</tr>
	<tr>
		<td>
			<div class="form-group">
				<label for="phoneNumber">Phone Number: </label>
				<form:input path="phoneNumber" class="form-control" placeholder="Enter Phone Number" required="required"/>
				<div class="invalid-feedback"><form:errors path="phoneNumber"/></div>
			</div>			
		</td>
	</tr>
	<tr>
		<td>
			<div class="form-group">
				<label for="credentials.userName">Username: </label>
				<form:input path="credentials.userName" class="form-control" placeholder="Enter Username" required="required"/>
				<div class="invalid-feedback"><form:errors path="credentials.userName"/></div>
			</div>		
		</td>
	</tr>
	<tr>
		<td>
			<div class="form-group">
				<label for="credentials.password">Password: </label>
				<form:password path="credentials.password" class="form-control" placeholder="Enter password" required="required"/>
				<div class="invalid-feedback"><form:errors path="credentials.password"/></div>
			</div>
		</td>
	</tr>	
	<tr>
		<td colspan= "2">
		<input type= "submit" value= "Register" class="btn btn-primary">
		</td>
	</tr>
		
	</table>	
	${message} 
	
</form:form>
</div>