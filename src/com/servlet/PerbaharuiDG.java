package com.servlet;

import java.io.IOException;

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

@WebServlet("/PerbaharuiDG")
public class PerbaharuiDG extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @author zulkarnaen
	 */
	
	public PerbaharuiDG() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author zulkarnaen
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_Golongan = request.getParameter("idGol");
		int idGolongan = Integer.parseInt(id_Golongan);
		
		System.out.println(idGolongan);
		
		request.setAttribute("empList", Manipulasi.ambilDataGolongan(idGolongan));
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/perbaharuiDG.jsp");
		rd.forward(request, response);
	}

	/**
	 * @author zulkarnaen
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id_golongan = request.getParameter("idGolongan");
		String golongan = request.getParameter("golongan");
		String namaGolongan = request.getParameter("namaGolongan");
		String gaji_Golongan = request.getParameter("gajiGolongan");
		
		int idGolongan = Integer.parseInt(id_golongan);
		int gajiGolongan = Integer.parseInt(gaji_Golongan);
		
		Datakaryawan datakaryawanGol = new Datakaryawan();
		
		datakaryawanGol.setIdGolongan(idGolongan);
		datakaryawanGol.setGolongan(golongan);
		datakaryawanGol.setNamaGolongan(namaGolongan);
		datakaryawanGol.setGajiGolongan(gajiGolongan);
		
		//gunakan manipulasi
		Manipulasi update = new Manipulasi();
		update.PerbaharuiDataGol(datakaryawanGol);
		
		
		response.sendRedirect("TampilkanDG");
		
		System.out.println(id_golongan);
	}

}
