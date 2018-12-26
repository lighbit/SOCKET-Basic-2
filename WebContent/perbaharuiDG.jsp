<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perbaharui Data Golongan</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div
	style="background-color: maroon; border: 1px solid black; padding: 7px; width: auto;">
	<!-- Mempercantik Tampilan -->
	<marquee>
		<span style="color: white;">Data Sebelum Update: <c:forEach
				items="${requestScope.empList}" var="emp">
				<tr>
					<td>id Golongan: </td>
					<td><c:out value="${emp.idGolongan}"></c:out></td>
					<td>|</td>
					<td> Golongan: </td>
					<td><c:out value="${emp.golongan}"></c:out></td>
					<td>|</td>
					<td> Nama golongan: </td>
					<td><c:out value="${emp.namaGolongan}"></c:out></td>
					<td>|</td>
					<td> Gaji golongan: </td>
					<td><c:out value="${emp.gajiGolongan}"></c:out>
					<td>-|-</td>
			</c:forEach></span>
	</marquee>
	<!-- Mempercantik Tampilan -->

</div>
</head>
<body>
	<center>
		<br>
		<h1>
			<font size="7" face="Georgia, Arial" color="maroon">U</font>pdate <font
				size="7" face="Georgia, Arial" color="maroon">D</font>ata <font
				size="7" face="Georgia, Arial" color="maroon">G</font>olongan
		</h1>
	</center>
	<br>
	<hr />
	<c:forEach items="${requestScope.empList}" var="emp">
		<form method="POST" action="PerbaharuiDG">
		<center><tr>
			<td>ID Golongan : </td>
			<td><input type="text" name="idGolongan" value="${emp.idGolongan}"> | </td>
			<td>Golongan : </td>
			<td><input type="text" name="golongan" value="${emp.golongan}"> | </td>
			<td>Nama Golongan : </td> 
			<td><input type="text" name="namaGolongan" value="${emp.namaGolongan}"> | </td>
			<td>Gaji Golongan : </td>
			<td><input type="text" name="gajiGolongan" value="Rp. ${emp.gajiGolongan}"> | </td>
			<td><input type="submit" value="Submit"></td>
		</tr></center>
		</form>
	</c:forEach>
	<br>
	<center><p>*Jika data tidak tampil ada yang salah di Update Data Manipulasi</p></center>
</body>
</html>