<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>Employee List</h1>
		
		<table border="1">

			<th>UserName</th>
			<th>Password</th>
			<th>Email</th>
			<th>Date Of Birth</th>
			<th>Country</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Action</th>

			<c:forEach var="employee" items="${listEmployee}">
				<tr>

					<td>${employee.name}</td>
					<td>${employee.password}</td>
					<td>${employee.email}</td>
					 <td>${employee.dateOfBirth}</td>
					<td>${employee.country}</td>
					<td>${employee.gender}</td>
					<td>${employee.age}</td>
					
					<td><a href="editEmployee?id=${employee.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteEmployee?id=${employee.id}" onclick="if (!(confirm('Are you sure want to delete this Employee permanently?')))
            return false">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Employee Register <a href="newEmployee">here</a><br><br>
			New Employee Login <a href="newlogin">here</a>
		</h4>
	</div>
</body>
</html>