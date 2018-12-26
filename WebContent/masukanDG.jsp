<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Masukan Data Golongan</title>
<div
	style="background-color: maroon; border: 1px solid black; padding: 7px; width: auto;">
	<!-- Mempercantik Tampilan -->
	<marquee>
		<span style="color: white;">hint: Tolong Masukan Golongan baru sesuai Database
									anda. example: 1,2,3,4,. . </span>
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
				size="7" face="Georgia, Arial" color="maroon">G</font>olongan
		</h1>
	</center>
	<br>
	<hr />
	<form method="GET" action="MasukanDG">
		<!-- 
		ID Golongan	: <br>
			<input type="number" name="idGolongan"><br><br>-->
		<center>
			<tr>
				<td>Golongan :</td>
				<td><input type="text" name="golongan"> |</td>

				<td>Nama Golongan :</td>
				<td><input type="text" name="namaGolongan"> |</td>

				<td>Gaji Golongan :</td>
				<td><input type="text" name="gajiGolongan"> |</td>

				<td><input type="submit" value="Submit"></td>
			</tr>
	</form>
	<br>
	<br>
	<center><p>*Selalu cek Database anda</center>
</body>
</html>