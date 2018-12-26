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
 * Servlet implementation class TampilkanDK
 */
@WebServlet("/TampilkanDK")
public class TampilkanDK extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TampilkanDK() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Manipulasi muncul = new Manipulasi();
		for (Datakaryawan value : Manipulasi.TampilData()) {
		}
		request.setAttribute("empList", Manipulasi.TampilData());
		request.setAttribute("empListJumlah", Manipulasi.TampilJumlahPegawai());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/tampilkanDK.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
