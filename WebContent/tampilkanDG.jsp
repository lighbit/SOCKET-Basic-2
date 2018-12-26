<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selamat Datang di Data Golongan</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<body>
	<div
		style="background-color: maroon; border: 1px solid black; padding: 7px; width: auto;">
		<!-- Mempercantik Tampilan -->
		<marquee>
			<span style="color: white;">
				<tr>
					<td>Data Kamu Saat ini :</td>
				</tr> <c:forEach items="${requestScope.empList4}" var="emp">

					<tr>
						<td><c:out value="${emp.golongan}"></c:out></td>
						<td><c:out value="${emp.namaGolongan}"></c:out></td>
						<td><c:out value="Rp. ${emp.gajiGolongan}"></c:out></td>
						<td>---</td>
				</c:forEach>
			</span>
		</marquee>
		<!-- Mempercantik Tampilan -->
	</div>

	<br>
	<br>
	<center>
		<h1>
			<font size='7' face='Georgia, Arial' color='maroon'>T</font>able <font
				size='7' face='Georgia, Arial' color='maroon'>G</font>olongan
		</h1>
	</center>
	<hr />

	<center>
		<table border="1" cellpadding="10" cellspacing="1">
			<tbody>
				<tr>
					<!-- <th>ID Golongan</th>  -->
					<th>Golongan</th>
					<th>Nama Golongan</th>
					<th>Gaji Golongan</th>
					<th>Option Section</th>
					<!-- <th>Status</th>  -->
				</tr>

				<c:forEach items="${requestScope.empList4}" var="emp">
					<tr>
						<!-- <td><c:out value="${emp.idGolongan}"></c:out></td>  -->
						<td><c:out value="${emp.golongan}"></c:out></td>
						<td><c:out value="${emp.namaGolongan}"></c:out></td>
						<td><c:out value="Rp. ${emp.gajiGolongan}"></c:out></td>
						<td><a href='PerbaharuiDG?idGol=${emp.idGolongan}'>Update</a>
							| | <a href='HapusDG?idGol=${emp.idGolongan}'>Delete</a></td>
						<!-- <td><c:out value="${emp.statusGolongan}"></c:out></td>  -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
	<center>
		<p>*ini adalah tabel golongan yang sudah dibuat sebelumnya
	</center>
</body>
</html>