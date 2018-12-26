package com.socket;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.Datakaryawan.Datakaryawan;
import com.Koneksi.Koneksi;
import com.opencsv.CSVReader;

public class SendCSVtoDatabase {
	public static void main(String[] args) {
		readCsv();
		readCsv1();
		readCsv2();
		readCsv3();
		readCsvUsingLoad();
		readCsvUsingLoad1();
		readCsvUsingLoad2();
		readCsvUsingLoad3();
	}

	// ==================================================================================================================
	// TODO: READ CSV dan READCSVUSING LOAD
	public static void readCsv1() {
		Koneksi db = new Koneksi();
		Connection conn = db.getKoneksi();

		Datakaryawan ambil = new Datakaryawan();

		try (CSVReader reader = new CSVReader(new FileReader("D:\\zTesting_Socket\\zServer\\Task2.csv"), ',');) {
			String insertQuery = "INSERT INTO `karyawaninsentif`.`karyawan` (`idkaryawan`, `nama_karyawan`, `tgl_masuk_karyawan`, `golongan_id_golongan`) VALUES (?, ?, ?, ?);";
			PreparedStatement preparedStmt = conn.prepareStatement(insertQuery);

			preparedStmt.setInt(1, ambil.getIdKaryawan());
			preparedStmt.setString(2, ambil.getNama());
			preparedStmt.setString(3, ambil.getTanggal());
			preparedStmt.setInt(4, ambil.getIdGolongan());

			System.out.println("sukses");

			// execute the preparedstatement
			preparedStmt.execute();
			conn.close();
		} catch (Exception e) {
		}

	}

	public static void readCsvUsingLoad1() {
		Koneksi db = new Koneksi();
		Connection conn = db.getKoneksi();
		try {

			String loadQuery = "LOAD DATA LOCAL INFILE '" + "D://zTesting_Socket//zServer//Task2.csv"
					+ "' INTO TABLE karyawan FIELDS TERMINATED BY ','"
					+ " LINES TERMINATED BY '\n' (idkaryawan,nama_karyawan, tgl_masuk_karyawan, golongan_id_golongan) ";
			// System.out.println(loadQuery);
			Statement stmt = conn.createStatement();
			stmt.execute(loadQuery);
		} catch (Exception e) {
		}
	}
	//===================================================================================================================
	
	// ==================================================================================================================
		// TODO: READ CSV1 dan READCSVUSING LOAD1
		public static void readCsv2() {
			Koneksi db = new Koneksi();
			Connection conn = db.getKoneksi();

			Datakaryawan ambil = new Datakaryawan();

			try (CSVReader reader = new CSVReader(new FileReader("D:\\zTesting_Socket\\zServer\\Task2(1).csv"), ',');) {
				String insertQuery = "INSERT INTO `karyawaninsentif`.`karyawan` (`idkaryawan`, `nama_karyawan`, `tgl_masuk_karyawan`, `golongan_id_golongan`) VALUES (?, ?, ?, ?);";
				PreparedStatement preparedStmt = conn.prepareStatement(insertQuery);

				preparedStmt.setInt(1, ambil.getIdKaryawan());
				preparedStmt.setString(2, ambil.getNama());
				preparedStmt.setString(3, ambil.getTanggal());
				preparedStmt.setInt(4, ambil.getIdGolongan());

				System.out.println("sukses");

				// execute the preparedstatement
				preparedStmt.execute();
				conn.close();
			} catch (Exception e) {
			}

		}

		public static void readCsvUsingLoad2() {
			Koneksi db = new Koneksi();
			Connection conn = db.getKoneksi();
			try {

				String loadQuery = "LOAD DATA LOCAL INFILE '" + "D://zTesting_Socket//zServer//Task2(1).csv"
						+ "' INTO TABLE karyawan FIELDS TERMINATED BY ','"
						+ " LINES TERMINATED BY '\n' (idkaryawan,nama_karyawan, tgl_masuk_karyawan, golongan_id_golongan) ";
				// System.out.println(loadQuery);
				Statement stmt = conn.createStatement();
				stmt.execute(loadQuery);
			} catch (Exception e) {
			}
		}
		//===================================================================================================================
		
		// ==================================================================================================================
		// TODO: READ CSV2 dan READCSVUSING LOAD2
		public static void readCsv3() {
			Koneksi db = new Koneksi();
			Connection conn = db.getKoneksi();

			Datakaryawan ambil = new Datakaryawan();

			try (CSVReader reader = new CSVReader(new FileReader("D:\\zTesting_Socket\\zServer\\Task2(2).csv"), ',');) {
				String insertQuery = "INSERT INTO `karyawaninsentif`.`karyawan` (`idkaryawan`, `nama_karyawan`, `tgl_masuk_karyawan`, `golongan_id_golongan`) VALUES (?, ?, ?, ?);";
				PreparedStatement preparedStmt = conn.prepareStatement(insertQuery);

				preparedStmt.setInt(1, ambil.getIdKaryawan());
				preparedStmt.setString(2, ambil.getNama());
				preparedStmt.setString(3, ambil.getTanggal());
				preparedStmt.setInt(4, ambil.getIdGolongan());

				System.out.println("sukses");

				// execute the preparedstatement
				preparedStmt.execute();
				conn.close();
			} catch (Exception e) {
			}

		}

		public static void readCsvUsingLoad3() {
			Koneksi db = new Koneksi();
			Connection conn = db.getKoneksi();
			try {

				String loadQuery = "LOAD DATA LOCAL INFILE '" + "D://zTesting_Socket//zServer//Task2(2).csv"
						+ "' INTO TABLE karyawan FIELDS TERMINATED BY ','"
						+ " LINES TERMINATED BY '\n' (idkaryawan,nama_karyawan, tgl_masuk_karyawan, golongan_id_golongan) ";
				// System.out.println(loadQuery);
				Statement stmt = conn.createStatement();
				stmt.execute(loadQuery);
			} catch (Exception e) {
			}
		}
		//===================================================================================================================
		
		// ==================================================================================================================
		// TODO: READ CSV3 dan READCSVUSING LOAD3
		public static void readCsv() {
			Koneksi db = new Koneksi();
			Connection conn = db.getKoneksi();

			Datakaryawan ambil = new Datakaryawan();

			try (CSVReader reader = new CSVReader(new FileReader("D:\\zTesting_Socket\\zServer\\Task2(3).csv"), ',');) {
				String insertQuery = "INSERT INTO `karyawaninsentif`.`karyawan` (`idkaryawan`, `nama_karyawan`, `tgl_masuk_karyawan`, `golongan_id_golongan`) VALUES (?, ?, ?, ?);";
				PreparedStatement preparedStmt = conn.prepareStatement(insertQuery);

				preparedStmt.setInt(1, ambil.getIdKaryawan());
				preparedStmt.setString(2, ambil.getNama());
				preparedStmt.setString(3, ambil.getTanggal());
				preparedStmt.setInt(4, ambil.getIdGolongan());

				System.out.println("sukses");

				// execute the preparedstatement
				preparedStmt.execute();
				conn.close();
			} catch (Exception e) {
			}

		}

		public static void readCsvUsingLoad() {
			Koneksi db = new Koneksi();
			Connection conn = db.getKoneksi();
			try {

				String loadQuery = "LOAD DATA LOCAL INFILE '" + "D://zTesting_Socket//zServer//Task2(3).csv"
						+ "' INTO TABLE karyawan FIELDS TERMINATED BY ','"
						+ " LINES TERMINATED BY '\n' (idkaryawan,nama_karyawan, tgl_masuk_karyawan, golongan_id_golongan) ";
				// System.out.println(loadQuery);
				Statement stmt = conn.createStatement();
				stmt.execute(loadQuery);
			} catch (Exception e) {
			}
		}
		//===================================================================================================================
}
