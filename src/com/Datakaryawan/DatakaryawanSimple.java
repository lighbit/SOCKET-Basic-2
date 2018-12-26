package com.Datakaryawan;

import java.io.InputStream;

/**
 * 
 * @author zulkarnaen
 *
 */

public class DatakaryawanSimple {

	// data karyawan
	private int idKaryawan;
	private String nama;
	private String tanggalmasuk;
	private String idGolongan;
	
	public DatakaryawanSimple(int idkaryawan, String nama,String tanggalmasuk ,String idGolongan) {
		super();
		this.idKaryawan = idkaryawan;
		this.nama = nama;
		this.idGolongan = idGolongan;
		this.tanggalmasuk = tanggalmasuk;
	}
	public int getIdKaryawan() {
		return idKaryawan;
	}
	public void setIdKaryawan(int idKaryawan) {
		this.idKaryawan = idKaryawan;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getIdGolongan() {
		return idGolongan;
	}
	public void setIdGolongan(String idGolongan) {
		this.idGolongan = idGolongan;
	}
	
	
}
