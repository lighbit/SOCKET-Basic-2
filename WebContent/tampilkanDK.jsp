<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<body>
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
					<th>ID</th>
					<th>Nama</th>
					<th>Tanggal masuk</th>
					<!-- <th>ID Golongan</th>  -->
					<th>Golongan</th>
					<th>Nama Golongan</th>
					<th>Gaji Golongan</th>
					<th>Insentif</th>
				</tr>
				<c:forEach items="${requestScope.empList}" var="emp">
					<tr>
						<td><c:out value="${emp.idKaryawan}"></c:out></td>
						<td><c:out value="${emp.nama}"></c:out></td>
						<td><c:out value="${emp.tanggal}"></c:out></td>
						<!-- <td><c:out value="${emp.idGolongan}"></c:out></td>  -->
						<td><c:out value="${emp.golongan}"></c:out></td>
						<td><c:out value="${emp.namaGolongan}"></c:out></td>
						<td><c:out value="${emp.gajiGolongan}"></c:out></td>
						<td><a
							href='InsentifKaryawan?namaGolongan=${emp.namaGolongan}&nama=${emp.nama}'>Calculate</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</center>

	<br>
	<br>

	<center>
		<h1>
			<font size='7' face='Georgia, Arial' color='maroon'>T</font>able <font
				size='7' face='Georgia, Arial' color='maroon'>K</font>aryawan
		</h1>
	</center>
	<hr />
	<center>
		<table border="1" cellpadding="10" cellspacing="1">
			<tbody>
				<tr>
					<th>Nama Golongan</th>
					<th>Jumlah Karyawan</th>
					<th>Karyawan</th>
					<th>Jumlah Gaji</th>
				</tr>
				<c:forEach items="${requestScope.empListJumlah}" var="emp">
					<tr>
						<td><c:out value="${emp.namaGolongan}"></c:out></td>
						<td><c:out value="${emp.jumlahKaryawan}"></c:out></td>
						<td><c:out value="${emp.kelompokKaryawan}"></c:out></td>
						<td><c:out value="${emp.jumlahGajiRP}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>