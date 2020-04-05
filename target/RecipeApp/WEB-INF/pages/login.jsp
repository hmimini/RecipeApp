<%@taglib uri="http://www.springframework.org/tags/form" prefix= "form"%>

 <!-- 
 Hermes Mimini
 Page fragment for displaying the user the login form page 
 -->
  

<div class="midPage">
<h2>Login Form</h2>
<form:form method= "POST" modelAttribute= "user" action= "loginUser" class="was-validated">
	<table>
	<tr>
		<td>   
			<div class="form-group">
				<label for="username">Username: </label>
				<form:input path="username" class="form-control" placeholder="Enter username" required="required"/>
				<div class="invalid-feedback"><form:errors path="username"/></div>
			</div>
    	</td>
	</tr>
	
	<tr>
		<td>
			<div class="form-group">
				<label for="password">Password: </label>
				<form:password path="password" class="form-control" placeholder="Enter password" required="required"/>
				<div class="invalid-feedback"><form:errors path="password"/></div>
			</div>
		</td>
	</tr>
		
	<tr>
		<td colspan= "2">
		<div align="center">
		<input type= "submit" value= "Login" class="btn btn-primary">
		</div>
		</td>
	</tr>	
	</table>
	<br/>
</form:form>
${message}
</div>
<br/>