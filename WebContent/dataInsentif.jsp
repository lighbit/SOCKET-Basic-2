<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data Insentif</title>
<div
	style="background-color: maroon; border: 1px solid black; padding: 7px; width: auto;">
	<!-- Mempercantik Tampilan -->
	<marquee>
		<span style="color: white;">Ini adalah gaji insentif yang
			didapat dari hasil perkalian </span>
	</marquee>
	<!-- Mempercantik Tampilan -->

</div>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<body>
	<center>
		<br>
		<h1>
			<font size="7" face="Georgia, Arial" color="maroon">H</font>asil <font
				size="7" face="Georgia, Arial" color="maroon">G</font>aji <font
				size="7" face="Georgia, Arial" color="maroon">I</font>nsentif
		</h1>
	</center>
	<hr />
	<center>
		<table border="1" cellpadding="10" cellspacing="1">
			<tbody>
				<tr>
					<!-- <th>ID Golongan</th>  -->
					<th>Nama</th>
					<th>Golongan</th>
					<th>Nama Golongan</th>
					<th>Insentif Gaji</th>
				</tr>

				<c:forEach items="${requestScope.empList}" var="emp">
					<tr>
						<td><c:out value="${emp.nama}"></c:out></td>

						<td><c:out value="${emp.golongan}"></c:out></td>

						<td><c:out value="${emp.namaGolongan}"></c:out></td>

						<td><c:out value="${emp.insentifGaji}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<center><p>*insentif gaji didapat dari gaji x insentif</center>
</body>
</html>