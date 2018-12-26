<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Masukan Data Karyawan</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div
	style="background-color: maroon; border: 1px solid black; padding: 7px; width: auto;">
	<!-- Mempercantik Tampilan -->
	<marquee>
		<span style="color: white;">Masukan id golongan yang telah
			disediakan. . </span>
	</marquee>
	<!-- Mempercantik Tampilan -->

</div>
</head>
<body>
	<center>
		<br>
		<h1>
			<font size="7" face="Georgia, Arial" color="maroon">M</font>asukan <font
				size="7" face="Georgia, Arial" color="maroon">D</font>ata <font
				size="7" face="Georgia, Arial" color="maroon">K</font>aryawan
		</h1>
	</center>
	<br>
	<hr />
	<form action="MasukanDK" method="GET" enctype="multipart/form-data">
		<center>
			<tr>
				<td>ID Karyawan :</td>
				<td><input type="text" name="idKaryawan"> |</td>
				
				<td>Nama Karyawan :</td>
				<td><input type="text" name="nama"> |</td>
				
				<td>Tanggal Masuk :</td>
				<td><input type="date" name="tanggal"> |</td>
				
				<td>ID Golongan :</td>
				<td><select name="idGolongan">
						<c:forEach items="${requestScope.empList}" var="emp">
							<td><option value="${emp.golongan}">${emp.golongan}
									- ${emp.namaGolongan}</option></td>
						</c:forEach>
				</select> | </td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</center>
	</form>
</body>
</html>