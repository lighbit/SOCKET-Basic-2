package com.Model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.Datakaryawan.Datakaryawan;
import com.Koneksi.Koneksi;

public class Manipulasi {

	/**
	 * @author zulkarnaen
	 */

	private Connection conn = null;

	public Manipulasi() {

		// Memanggil Koneksi sebagai variable conn
		conn = new Koneksi().getKoneksi();
	}

	// =================================================================================================================

	// Membuat List Datakaryawan untuk ambil Datagolongan
	public static List<Datakaryawan> ambilDataGolongan(int id) {
		List<Datakaryawan> karyawanlist = new ArrayList<Datakaryawan>();

		Statement statement = null;
		ResultSet resultSet = null;

		Koneksi db = new Koneksi();
		Connection conn = db.getKoneksi();

		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT id_golongan, golongan, nama_golongan, gaji_golongan FROM golongan WHERE id_golongan=" + id;

		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while (resultSet.next()) {
				Datakaryawan emp1 = new Datakaryawan();

				emp1.setIdGolongan(resultSet.getInt("id_golongan"));
				emp1.setGolongan(resultSet.getString("golongan"));
				emp1.setNamaGolongan(resultSet.getString("nama_golongan"));
				emp1.setGajiGolongan(resultSet.getInt("gaji_golongan"));

				karyawanlist.add(emp1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return karyawanlist;
	}

	// =================================================================================================================

	// Membuat List Datakaryawan untuk ambil opsiDataGolongan
	public static List<Datakaryawan> OpsiDataGolongan() {
		List<Datakaryawan> empList = new ArrayList<Datakaryawan>();

		Statement statement = null;
		ResultSet resultSet = null;

		Koneksi db = new Koneksi();
		Connection conn = db.getKoneksi();

		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT golongan, nama_golongan FROM golongan WHERE STATUS='AKTIF'";

		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while (resultSet.next()) {
				Datakaryawan emp1 = new Datakaryawan();

				emp1.setGolongan(resultSet.getString("golongan"));
				emp1.setNamaGolongan(resultSet.getString("nama_golongan"));

				empList.add(emp1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empList;
	}
//====================================================================================================================
	// Membuat List Datakaryawan untuk ambil Datainsentif
	public static List<Datakaryawan> ambilDataInsentif(String nama, String insentif) throws IOException {
		List<Datakaryawan> empList = new ArrayList<Datakaryawan>();

		Statement statement = null;
		ResultSet resultSet = null;

		Koneksi db = new Koneksi();
		Connection conn = db.getKoneksi();

		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT a.*, b.* FROM karyawan a JOIN golongan b WHERE a.golongan_id_golongan = b.id_golongan AND a.nama_karyawan='"
				+ nama + "'";

		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		float insentifGaji = Float.parseFloat(insentif);

		try {
			while (resultSet.next()) {
				Datakaryawan emp1 = new Datakaryawan();

				emp1.setNama(nama);
				emp1.setGolongan(resultSet.getString("golongan"));
				emp1.setNamaGolongan(resultSet.getString("nama_golongan"));
				emp1.setGajiGolongan(resultSet.getInt("gaji_golongan"));

				// emp1.setFotoKaryawan(resultSet.getString("foto_karyawan"));

				emp1.setInsentifGaji((int) (resultSet.getInt("gaji_golongan") * insentifGaji));

				empList.add(emp1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empList;
	}

	// Membuat List Datakaryawan untuk Simpan Data Golongan
	public static void SimpanDataGol(Datakaryawan ambil) {
		try {
			// create a mysql database connection
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();

			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/karyawaninsentif";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "zulka....");
			// the mysql insert statement
			String query = " insert into golongan (golongan, nama_golongan, gaji_golongan, tgl_input, status)"
					+ " values (?, ?, ?, ?, ?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);

			preparedStmt.setString(1, ambil.getGolongan());
			preparedStmt.setString(2, ambil.getNamaGolongan());
			preparedStmt.setInt(3, ambil.getGajiGolongan());
			preparedStmt.setString(4, formatter.format(date));
			preparedStmt.setString(5, "AKTIF");

			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();

		} catch (Exception e) {
			System.err.println("Masalah Function Simpan Data");
			System.err.println(e.getMessage());
		}
	}

	// =================================================================================================================

	// Membuat List Datakaryawan untuk UPDATE Data Golongan
	public boolean PerbaharuiDataGol(Datakaryawan update) {
		Boolean booleans = false;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();

			// create a mysql database connection
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/karyawaninsentif";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "zulka....");
			// the mysql insert statement
			String query = "UPDATE `karyawaninsentif`.`golongan` SET `golongan`=?, `nama_golongan`=?, `gaji_golongan`=?, `tgl_update`=?, `status`=? WHERE `id_golongan`=?";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);

			preparedStmt.setString(1, update.getGolongan());
			preparedStmt.setString(2, update.getNamaGolongan());
			preparedStmt.setInt(3, update.getGajiGolongan());
			preparedStmt.setString(4, formatter.format(date));
			preparedStmt.setString(5, "AKTIF");
			preparedStmt.setInt(6, update.getIdGolongan());

			// execute the preparedstatement
			preparedStmt.execute();
			booleans = true;
			conn.close();

		} catch (Exception e) {
			System.err.println("Masalah Update data function");
			System.err.println(e.getMessage());
		}
		return booleans;
	}

	// =================================================================================================================

	// Membuat List Datakaryawan untuk Hapus Data Golongan
	public static void HapusDataGol(Datakaryawan ambil) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();

			// create a mysql database connection
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/karyawaninsentif";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "zulka....");
			// the mysql insert statement
			String query = "UPDATE `karyawaninsentif`.`golongan` SET `tgl_delete`=?, `status`=? WHERE `id_golongan`=?";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);

			preparedStmt.setString(1, formatter.format(date));
			preparedStmt.setString(2, "TIDAK AKTIF");
			preparedStmt.setInt(3, ambil.getIdGolongan());

			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();

		} catch (Exception e) {
			System.err.println("Masalah function Hapus Data");
			System.err.println(e.getMessage());
		}
	}

	// =================================================================================================================

	// Membuat List Datakaryawan untuk Simpan Datakaryawan
	public boolean SimpanData(Datakaryawan ambil) {
		boolean insert = false;
		try {
			// create a mysql database connection
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/karyawaninsentif";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "zulka....");
			// the mysql insert statement
			String query = " insert into karyawan (idkaryawan, nama_karyawan,tgl_masuk_karyawan,golongan_id_golongan)"
					+ " values (?, ?, ?, ?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, ambil.getIdKaryawan());
			preparedStmt.setString(2, ambil.getNama());
			preparedStmt.setString(3, ambil.getTanggal());
			preparedStmt.setInt(4, ambil.getIdGolongan());

			// execute the preparedstatement
			preparedStmt.execute();
			insert = true;
			conn.close();

		} catch (Exception e) {
			System.err.println("masalah list simpan data karyawan");
			System.err.println(e.getMessage());
		}
		return insert;
	}

	// =================================================================================================================

	// Membuat List Datakaryawan untuk Simpan Datakaryawan
	public static List<Datakaryawan> TampilData() throws IOException {
		Statement statement = null;
		ResultSet resultSet = null;

		Koneksi db = new Koneksi();
		Connection conn = db.getKoneksi();

		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT a.*, b.* FROM karyawan a JOIN golongan b WHERE a.golongan_id_golongan=b.id_golongan ORDER BY b.gaji_golongan DESC";

		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// =================================================================================================================

		// Membuat List Datakaryawan untuk Membuat List
		List<Datakaryawan> empList = new ArrayList<Datakaryawan>();

		try {
			while (resultSet.next()) {
				Datakaryawan emp1 = new Datakaryawan();

				emp1.setIdKaryawan(resultSet.getInt("a.idKaryawan"));
				emp1.setNama(resultSet.getString("a.nama_karyawan"));
				emp1.setTanggal(resultSet.getString("a.tgl_masuk_karyawan"));
				emp1.setIdGolongan(resultSet.getInt("a.golongan_id_golongan"));
				emp1.setGolongan(resultSet.getString("b.golongan"));
				emp1.setNamaGolongan(resultSet.getString("b.nama_golongan"));
				emp1.setGajiGolongan(resultSet.getInt("b.gaji_golongan"));

				empList.add(emp1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empList;
	}

	// =================================================================================================================

	// Membuat List Datakaryawan untuk Tampilkan golongan
	public static List<Datakaryawan> TampilDataGol() {
		Statement statement = null;
		ResultSet resultSet = null;

		Koneksi db = new Koneksi();
		Connection conn = db.getKoneksi();

		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT * FROM golongan WHERE STATUS='AKTIF'";

		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// =================================================================================================================

		// Membuat List Datakaryawan untuk list karyawan
		List<Datakaryawan> empList = new ArrayList<Datakaryawan>();

		try {
			while (resultSet.next()) {
				Datakaryawan emp1 = new Datakaryawan();

				emp1.setIdGolongan(resultSet.getInt("id_golongan"));
				emp1.setGolongan(resultSet.getString("golongan"));
				emp1.setNamaGolongan(resultSet.getString("nama_golongan"));
				emp1.setGajiGolongan(resultSet.getInt("gaji_golongan"));
				emp1.setStatusGolongan(resultSet.getString("status"));
				empList.add(emp1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empList;
	}

	// =================================================================================================================

	// Membuat List Datakaryawan untuk Tampilkan JumlahKaryawan
	public static List<Datakaryawan> TampilJumlahPegawai() {
		Statement statement = null;
		ResultSet resultSet = null;

		Koneksi db = new Koneksi();
		Connection conn = db.getKoneksi();

		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT COUNT(a.nama_karyawan), a.nama_karyawan, SUM(b.gaji_golongan), GROUP_CONCAT(DISTINCT nama_karyawan SEPARATOR ','), b.nama_golongan FROM karyawan a JOIN golongan b WHERE a.golongan_id_golongan=b.id_golongan GROUP BY b.nama_golongan";

		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// =================================================================================================================

		// Membuat List Datakaryawan untuk List Karyawan
		List<Datakaryawan> empList = new ArrayList<Datakaryawan>();

		try {
			while (resultSet.next()) {
				Datakaryawan emp1 = new Datakaryawan();

				emp1.setJumlahKaryawan(resultSet.getInt("COUNT(a.nama_karyawan)"));
				// emp1.setJumlahGaji(resultSet.getInt("SUM(b.gaji_golongan)"));
				System.out.println(resultSet.getString("a.nama_karyawan"));

				// ubah tipe nominal
				String nominal = Integer.toString(resultSet.getInt("SUM(b.gaji_golongan)"));
				Locale locale = null;
				NumberFormat rupiahFormat = null;
				String rupiah = "";
				locale = new Locale("ca", "CA");
				rupiahFormat = NumberFormat.getCurrencyInstance(locale);
				rupiah = rupiahFormat.format(Double.parseDouble(nominal)).substring(4);

				emp1.setKelompokKaryawan(resultSet.getString("GROUP_CONCAT(DISTINCT nama_karyawan SEPARATOR ',')"));

				emp1.setJumlahGajiRP(rupiah);
				emp1.setNamaGolongan(resultSet.getString("b.nama_golongan"));

				empList.add(emp1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empList;
	}

	// =================================================================================================================
	// ujilocale uang
	public class Ujiduid {
		Locale locale = null;
		NumberFormat rupiahFormat = null;

		public String toRupiahFormat(String nominal) {
			String rupiah = "";
			locale = new Locale("ca", "CA");
			rupiahFormat = NumberFormat.getCurrencyInstance(locale);
			rupiah = rupiahFormat.format(Double.parseDouble(nominal)).substring(4);

			return rupiah;
		}

		// public static void main(String[] args) {
		// // TODO Auto-generated method stub
		//
		// String nominal = "9000000";
		//
		// Ujiduid rcf = new Ujiduid();
		// System.out.println(rcf.toRupiahFormat(nominal));
		//
		// }
	}

	// =================================================================================================================

	// Membuat Fungsi memunculkan DataPegawai di index.jsp
	public Datakaryawan getDataKaryawanById(int id_golongan) {
		Datakaryawan datapegawai = new Datakaryawan();

		try {
			String query = "SELECT id_golongan,golongan,nama_golongan,gaji_golongan, FROM golongan WHERE id_golongan="
					+ id_golongan;
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				datapegawai.setIdGolongan(rs.getInt("id_golongan"));
				datapegawai.setGolongan(rs.getString("golongan"));
				datapegawai.setNamaGolongan(rs.getString("nama_golongan"));
				datapegawai.setGajiGolongan(rs.getInt("gaji_golongan"));
			} else {
				System.out.println("data Karyawan Tidak di Isi...");
			}

			conn.close();
			;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datapegawai;
	}

	// =================================================================================================================
	public static void main(String[] args) {

	}

}
