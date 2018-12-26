package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

@WebServlet("/TampilkanDG")
public class TampilkanDG extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @author zulkarnaen
	 */
	
	public TampilkanDG() {
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

		List<Datakaryawan> tampilDataGol = Manipulasi.TampilDataGol();
		request.setAttribute("empList4", tampilDataGol);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/tampilkanDG.jsp");
		rd.forward(request, response);

		// munculkand tanggal proses
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(formatter.format(date));
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
