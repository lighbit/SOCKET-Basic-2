package com.Insentif;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Manipulasi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author zulkarnaen
 */

@WebServlet("/InsentifKaryawan")
public class InsentifKaryawan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @author zulkarnaen
	 */

	public InsentifKaryawan() {
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

		PrintWriter pw = response.getWriter();

		// membuat string baru
		String namaGolongan = request.getParameter("namaGolongan");
		String nama = request.getParameter("nama");

		// membuat encoder dari nama
		String namaencoder = URLEncoder.encode(nama, "UTF-8");
		// System.out.println("param1 before:" + param1Before);

		String url = "http://localhost:8080/AplikasiInsentif/InsentifKaryawan?namaGolongan=" + namaGolongan + "&nama="
				+ namaencoder;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response1 = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response1.append(inputLine);
		}
		in.close();

		// print result
		String insentif = response1.toString();
		System.out.println(response1.toString());
		pw.print(insentif);

		request.setAttribute("empList", Manipulasi.ambilDataInsentif(nama, insentif));
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/dataInsentif.jsp");
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
