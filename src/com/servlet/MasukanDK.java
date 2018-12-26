package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Datakaryawan.Datakaryawan;
import com.Model.Manipulasi;

/**
 * @author zulkarnaen
 */

@WebServlet("/MasukanDK")
public class MasukanDK extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @author zulkarnaen
	 */
	
	public MasukanDK() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void proses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Ambil data dari form
		PrintWriter out = response.getWriter();
		Datakaryawan ambildatapegawai = new Datakaryawan();
		ambildatapegawai.setIdKaryawan(Integer.parseInt(request.getParameter("idKaryawan")));
		ambildatapegawai.setNama(request.getParameter("nama"));
		ambildatapegawai.setTanggal(request.getParameter("Gaji Perbulan"));

		// simpan data
		Manipulasi datamanipulasi = new Manipulasi();

		if (datamanipulasi.SimpanData(ambildatapegawai)) {
			response.sendRedirect("masukanDK.jsp");
		} else {
			out.print("Kesalahan di Fungsi Menyimpan data. Check Manipulasi");
		}

		// Ambil data dari form
		// String idkaryawan = request.getParameter("idKaryawan");
		// String nama_karyawan = request.getParameter("nama");
		// String tgl_masuk = request.getParameter("tanggal");
		//
		// int idKaryawan = Integer.parseInt(idkaryawan);
		//
		// Datakaryawan datakaryawan = new Datakaryawan();
		//
		// datakaryawan.setIdKaryawan(idKaryawan);
		// datakaryawan.setNama(nama_karyawan);
		// datakaryawan.setTanggal(tgl_masuk);
		//
		// Manipulasi.SimpanData(datakaryawan);
		//
		// response.sendRedirect("MasukanDK");
	}

	/**
	 * @author zulkarnaen
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		request.setAttribute("empList", Manipulasi.OpsiDataGolongan());

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/masukanDK.jsp");
		rd.forward(request, response);
	}

	/**
	 * @author zulkarnaen
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
