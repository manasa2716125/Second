<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	</br></br></br></br>
	<h2 align="center">
	<% if(request.getAttribute("msg2") != null) { %>
		<p style="color: red">
			<%= request.getAttribute("msg2") %>
		</p>
	<% } %>
	</h2>
	<div align="center">
		<form action="userRegistration" method="post">
		<table>
			<p>
				<tr>
					<td colspan="2" align="center"><b>User Registration</b></td>
				</tr></p>
				<p>
				<tr>
					<td>Username :</td>
					<td><input type="text" name="username" required></td>
				</tr></p>
				<p><tr>
					<td>Password :</td>
					<td><input type="password" name="password" required></td>
				</tr></p>
				<p><tr>
					<td>Conform Password :</td>
					<td><input type="password" name="confPassword" required></td>
				</tr></p>
				<p><tr>
					<td>First Name :</td>
					<td><input type="text" name="firstName" required></td>
				</tr></p>
				<p><tr>
					<td>Last Name :</td>
					<td><input type="text" name="lastName" required></td>
				</tr></p>
				<p><tr>
					<td>Date of Birth :</td>
					<td><input type="date" name="dob" required></td>
				</tr></p>
				<p><tr>
					<td>Mobile Number :</td>
					<td><input type="number" name="mobileNo"></td>
				</tr></p>
				<p><tr>
					<td>Email Id :</td>
					<td><input type="email" name="emailId"></td>
				</tr></p>
				<p><tr>
					<td align="center"><input type="submit" value="Register User"></td>
					<td align="center"><input type="reset" name="Reset Form"></td>
				</tr></p>
				</table>
			
		</form>
	</div>
</body>
</html>