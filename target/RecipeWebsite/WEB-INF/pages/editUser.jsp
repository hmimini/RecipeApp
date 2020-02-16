<%@taglib uri="http://www.springframework.org/tags/form" prefix= "form"%>

<h2>Edit User Form</h2>
<form:form method= "POST" modelAttribute= "user" action= "editUser">
	<table>
		
	<tr>
		<td><form:label path="firstName">First Name:</form:label>
		<td><form:input path="firstName" value="${user.firstName}"/><form:errors path="firstName"/></td>
	</tr>
	
	<tr>
		<td><form:label path="lastName">Last Name:</form:label>
		<td><form:input path="lastName" value="${user.lastName}"/><form:errors path="lastName"/></td>
	</tr>
	
	<tr>
		<td><form:label path="email">Email:</form:label>
		<td><form:input path="email" value="${user.email}"/><form:errors path="email"/></td>
	</tr>
	
	<tr>
		<td><form:label path="phoneNumber">Phone Number:</form:label>
		<td><form:input path="phoneNumber" value="${user.phoneNumber}"/><form:errors path="phoneNumber"/></td>
	</tr>
	
	<tr>
		<td><form:label path="credentials.userName">User Name:</form:label>
		<td><form:input path="credentials.userName" value="${user.credentials.userName}"/><form:errors path="credentials.userName"/></td>
	</tr>
	
	<tr>
		<td><form:label path="credentials.password">Password:</form:label>
		<td><form:password path="credentials.password" value="${user.credentials.password}"/><form:errors path="credentials.password"/></td>
	</tr>
		
	<tr>
		<td colspan= "2">
		<input type= "submit" value= "Save Changes">
		</td>
	</tr>
		
	</table>
	<br/>
	
</form:form>