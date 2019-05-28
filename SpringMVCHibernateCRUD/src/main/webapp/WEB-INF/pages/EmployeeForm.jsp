<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>

</head>
<body>
    <div align="center">
        <h1>Add Employee</h1>
        <form:form action="saveEmployee" method="post" modelAttribute="employee">
        <table>
            <form:hidden path="id" />
            <tr>
                <td>UserName:</td>
                <td><form:input path="name" /></td>
                <td><form:errors path="name" cssClass = "error"></form:errors></td>
            </tr>
           
            <tr>
                <td>Password</td>
                <td><form:input path="password" type="password" /></td>
                  <td><form:errors path="password" cssClass = "error"></form:errors></td>
            </tr>
            
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
                <td> <form:errors path="email" cssClass = "error"></form:errors></td>
            </tr>
            
             <tr>
                  <td>Date Of Birth</td>
                <td><form:input type="text" 										
				path="dateOfBirth"
				placeholder="Date of Birth" /></td>
				 <td> <form:errors path="dateOfBirth" cssClass = "error"></form:errors></td>
<%-- 										<form:errors path"src/main/webapp/WEB-INF/pages/EmployeeForm.jsp"="dateOfBirth" cssClass="error" /> --%>
               
            </tr>
            
            <tr>
                <td>Country:</td>
                <td><select name="country">
                <option value="India">India</option>
          <option value="France">France</option>
          <option value="America">America</option>
          <option value="U.K">U.K</option></select>
          
      </td>
            </tr>
            <tr>
               <td><form:label path = "gender">Gender</form:label></td>
               <td>
                  <form:radiobutton path = "gender" value = "Male" label = "Male" />
                  <form:radiobutton path = "gender" value = "Female" label = "Female" />
                  <form:radiobutton path = "gender" value = "Other" label = "Other" />
                  
               </td>
            </tr> 
            
            <tr>
    		  
      			 <td>Age</td>
                <td><form:input path="age" /></td>
               <td>  <form:errors path="age" cssClass = "error"></form:errors></td>
               
 			 </tr>
            
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
       
	
        </form:form>
    </div>
     <!-- <script>
		$(function() {
		$('#dateOfBirthInput').datepicker();
	});
		</script> -->
</body>
</html>