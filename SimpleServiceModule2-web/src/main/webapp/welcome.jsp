<%@page import="com.orgn.ui.vo.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Employee Details</title>
</head>
<body>
	<%
	    Employee employee=(Employee)request.getAttribute("emp");
	%>
	<table align="center" bgcolor="#FFFFCC" border="1" width="70%">
	    <tr>
	        <td colspan="2" align="center"><%="Welcome "+employee.getName()+" . Your details are as below.." %></td>
	    </tr>
	    <tr>
	        <td>EmpID </td>
	        <td><%=employee.getEmpId() %></td>
	    </tr> 
	    <tr>
	        <td>Name </td>
	        <td><%=employee.getName()%></td>
	    </tr>
	    <tr>
	        <td>Message from EJB Service </td>
	        <td><%=employee.getMessage()%></td>
	    </tr>
	</table>
</body>
</html>