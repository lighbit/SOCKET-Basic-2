package com.Datakaryawan;

import java.io.InputStream;

/**
 * 
 * @author zulkarnaen
 *
 */

public class Datakaryawan {

	// data karyawan
	private int idKaryawan;
	private String idKaryawan1;
	private String nama;
	private String tanggal;
	private int idGolongan;
	private String fotoKaryawan;
	private String base64Image;
	private InputStream dataFoto;

	// data golongan
	private String golongan;
	private String namaGolongan;
	private int gajiGolongan;
	private String statusGolongan;

	// data socket lain
	private int idscoket;
	private String nama_socket;
	private String golongan_socekt;
	private int gaji;

	// jumlah data
	private int jumlahGaji;
	private int jumlahKaryawan;
	private String jumlahGajiRP;
	private String kelompokKaryawan;

	// insentif
	private int insentifGaji;

	public int getIdKaryawan() {
		return idKaryawan;
	}

	public void setIdKaryawan(int idKaryawan) {
		this.idKaryawan = idKaryawan;
	}

	public String getIdKaryawan1() {
		return idKaryawan1;
	}

	public void setIdKaryawan1(String idKaryawan1) {
		this.idKaryawan1 = idKaryawan1;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public int getIdGolongan() {
		return idGolongan;
	}

	public void setIdGolongan(int idGolongan) {
		this.idGolongan = idGolongan;
	}

	public String getFotoKaryawan() {
		return fotoKaryawan;
	}

	public void setFotoKaryawan(String fotoKaryawan) {
		this.fotoKaryawan = fotoKaryawan;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public InputStream getDataFoto() {
		return dataFoto;
	}

	public void setDataFoto(InputStream dataFoto) {
		this.dataFoto = dataFoto;
	}

	public String getGolongan() {
		return golongan;
	}

	public void setGolongan(String golongan) {
		this.golongan = golongan;
	}

	public String getNamaGolongan() {
		return namaGolongan;
	}

	public void setNamaGolongan(String namaGolongan) {
		this.namaGolongan = namaGolongan;
	}

	public int getGajiGolongan() {
		return gajiGolongan;
	}

	public void setGajiGolongan(int gajiGolongan) {
		this.gajiGolongan = gajiGolongan;
	}

	public String getStatusGolongan() {
		return statusGolongan;
	}

	public void setStatusGolongan(String statusGolongan) {
		this.statusGolongan = statusGolongan;
	}

	public int getJumlahGaji() {
		return jumlahGaji;
	}

	public void setJumlahGaji(int jumlahGaji) {
		this.jumlahGaji = jumlahGaji;
	}

	public int getJumlahKaryawan() {
		return jumlahKaryawan;
	}

	public void setJumlahKaryawan(int jumlahKaryawan) {
		this.jumlahKaryawan = jumlahKaryawan;
	}

	public String getJumlahGajiRP() {
		return jumlahGajiRP;
	}

	public void setJumlahGajiRP(String jumlahGajiRP) {
		this.jumlahGajiRP = jumlahGajiRP;
	}

	public String getKelompokKaryawan() {
		return kelompokKaryawan;
	}

	public void setKelompokKaryawan(String kelompokKaryawan) {
		this.kelompokKaryawan = kelompokKaryawan;
	}

	public int getInsentifGaji() {
		return insentifGaji;
	}

	public void setInsentifGaji(int insentifGaji) {
		this.insentifGaji = insentifGaji;
	}

	public int getIdscoket() {
		return idscoket;
	}

	public void setIdscoket(int idscoket) {
		this.idscoket = idscoket;
	}

	public String getNama_socket() {
		return nama_socket;
	}

	public void setNama_socket(String nama_socket) {
		this.nama_socket = nama_socket;
	}

	public String getGolongan_socekt() {
		return golongan_socekt;
	}

	public void setGolongan_socekt(String golongan_socekt) {
		this.golongan_socekt = golongan_socekt;
	}

	public int getGaji() {
		return gaji;
	}

	public void setGaji(int gaji) {
		this.gaji = gaji;
	}

}
