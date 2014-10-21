<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tambah Customer</title>
</head>
<body>
	<form action="save" method="post">
		<input type="hidden" name="action" value="create" />
		<table>
			<tr>
				<td>Input First Name</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Input Last Name</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>Input Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Input Tanggal Lahir</td>
				<td><input type="text" name="birthday"></td>
			</tr>

			<tr>
				<td>Input Home Phone</td>
				<td><input type="text" name="homePhone"></td>
			</tr>

			<tr>
				<td>Input Mobile Phone</td>
				<td><input type="text" name="mobilePhone"></td>
			</tr>
			<tr>
				<td>Input Password</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>Input Kota</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>Input Kode Pos</td>
				<td><input type="text" name="postalCode"></td>
			</tr>
			<tr>
				<td>Input Jalan</td>
				<td><input type="text" name="street"></td>
			</tr>
		</table>

		<button type="submit">Kirim</button>

	</form>
</body>
</html>