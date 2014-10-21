<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
</head>
<body>
	<form action="save" method="post">
		<input type="hidden" name="action" value="edit" />
		<table>
		<%String idC=request.getParameter("idCus"); 
      String fName=request.getParameter("firstName");
      String lName=request.getParameter("lastName");
      String ema=request.getParameter("email");
      String hPhone=request.getParameter("homePhone");
      String mPhone=request.getParameter("mobilePhone");
      String p=request.getParameter("password");
      String bDate=request.getParameter("birthday");
      String st=request.getParameter("street");
      String ci=request.getParameter("city");
      String pCode=request.getParameter("postalCode");
    %>
			<tr>
				<td>Input Id Customer</td>
				<td><input type="text" name="idCus" value="<%=idC%>"></td>
			</tr>
			<tr>
				<td>Input First Name</td>
				<td><input type="text" name="firstName" value="<%=fName%>"></td>
			</tr>
			<tr>
				<td>Input Last Name</td>
				<td><input type="text" name="lastName" value="<%=lName%>"></td>
			</tr>
			<tr>
				<td>Input Email</td>
				<td><input type="text" name="email" value="<%=ema%>"></td>
			</tr>
			<tr>
				<td>Input Tanggal Lahir</td>
				<td><input type="text" name="birthday" value="<%=bDate%>"></td>
			</tr>

			<tr>
				<td>Input Home Phone</td>
				<td><input type="text" name="homePhone" value="<%=hPhone%>"></td>
			</tr>

			<tr>
				<td>Input Mobile Phone</td>
				<td><input type="text" name="mobilePhone" value="<%=mPhone%>"></td>
			</tr>
			<tr>
				<td>Input Password</td>
				<td><input type="text" name="password" value="<%=p%>"></td>
			</tr>
			<tr>
				<td>Input Kota</td>
				<td><input type="text" name="city" value="<%=ci%>"></td>
			</tr>
			<tr>
				<td>Input Kode Pos</td>
				<td><input type="text" name="postalCode" value="<%=pCode%>"></td>
			</tr>
			<tr>
				<td>Input Jalan</td>
				<td><input type="text" name="street" value="<%=st%>"></td>
			</tr>
		</table>

		<button type="submit">Edit</button>

	</form>
</body>
</html>