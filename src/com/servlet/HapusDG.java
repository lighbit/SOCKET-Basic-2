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

@WebServlet("/HapusDG")
public class HapusDG extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @author zulkarnaen
	 */

	public HapusDG() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author zulkarnaen
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		String id_Golongan = request.getParameter("idGol");
		int idGolongan = Integer.parseInt(id_Golongan);

		System.out.println(idGolongan);
		Datakaryawan datakaryawanGol = new Datakaryawan();

		datakaryawanGol.setIdGolongan(idGolongan);
		Manipulasi.HapusDataGol(datakaryawanGol);

		response.sendRedirect("TampilkanDG");
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
