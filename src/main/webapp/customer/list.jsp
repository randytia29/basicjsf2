<%@ page import="java.util.List"%>
<%@ page import="id.co.skyforce.basicjsf.domain.Customer"%>
<%@ page import="org.hibernate.Query"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="id.co.skyforce.basicjsf.HibernateUtil"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Data</title>
</head>
<body>

	<h3>Customer Management</h3>

	<table border="1">
		<%
			List<Customer> custom = (List<Customer>) request
					.getAttribute("customers");
		%>
		<tr>
			<td><center>ID</center></td>
			<td><center>Name</center></td>
			<td><center>Email</center></td>
			<td><center>Birth Date</center></td>
			<td colspan="2"><center>Action</center></td>
		</tr>
		<tr>
			<%
				for (Customer cus : custom) {
			%>
			<td>
				<%
					out.print(cus.getId());
				%>
			</td>
			<td>
				<%
					out.print(cus.getFirstName() + " " + cus.getLastName());
				%>
			</td>
			<td>
				<%
					out.print(cus.getEmail());
				%>
			</td>
			<td>
				<%
					out.print(cus.getBirthDate());
				%>
			</td>
			<form action="edit.jsp" method="post">
				<input type="hidden" name="idCus" value="<%=cus.getId()%>">
				<input type="hidden" name="firstName" value="<%=cus.getFirstName()%>">
				<input type="hidden" name="lastName" value="<%=cus.getLastName()%>">
				<input type="hidden" name="email" value="<%=cus.getEmail()%>">
				<input type="hidden" name="birthday" value="<%=cus.getBirthDate()%>">
				<input type="hidden" name="homePhone" value="<%=cus.getHomePhone()%>">
				<input type="hidden" name="mobilePhone" value="<%=cus.getMobileNo()%>">
				<input type="hidden" name="password" value="<%=cus.getPassword()%>">
				<input type="hidden" name="city" value="<%=cus.getAddress().getCity()%>">
				<input type="hidden" name="postalCode" value="<%=cus.getAddress().getPostalCode()%>">
				<input type="hidden" name="street" value="<%=cus.getAddress().getStreet()%>">
			<td><input type="submit" value="Edit"></td>
			</form>

			<form action="save" method="post">
				<input type="hidden" name="idCus" value="<%=cus.getId()%>">
				<input type="hidden" name="action" value="hapus">
				<td><input type="submit" value="Hapus"></td>

			</form>

		</tr>

		<%
			}
		%>
	</table>
	<a href="create.jsp">New Customer</a>
</body>
</html>