package com.servlet;

import java.io.IOException;
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

@WebServlet("/MasukanDG")
public class MasukanDG extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @author zulkarnaen
	 */
	
	public MasukanDG() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author zulkarnaen
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		String golongan = request.getParameter("golongan");
		String namaGolongan = request.getParameter("namaGolongan");
		String gaji_Golongan = request.getParameter("gajiGolongan");
		
		int gajiGolongan = Integer.parseInt(gaji_Golongan);

		Datakaryawan datakaryawanGol = new Datakaryawan();

		datakaryawanGol.setGolongan(golongan);
		datakaryawanGol.setNamaGolongan(namaGolongan);
		datakaryawanGol.setGajiGolongan(gajiGolongan);

		Manipulasi.SimpanDataGol(datakaryawanGol);

		response.sendRedirect("masukanDG.jsp");
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
