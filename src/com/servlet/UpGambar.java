package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UpGambar
 */
@WebServlet("/UpGambar")
public class UpGambar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpGambar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		System.out.println("request: " + request);
		if (!isMultipart) {
			System.out.println("File Not Uploaded");
		} else {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			@SuppressWarnings("rawtypes")
			List items = null;

			try {
				items = upload.parseRequest((RequestContext) request);
				System.out.println("items: " + items);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			@SuppressWarnings("rawtypes")
			Iterator itr = items.iterator();
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				if (item.isFormField()) {
					String name = item.getFieldName();
					System.out.println("name: " + name);
					String value = item.getString();
					System.out.println("value: " + value);
				} else {
					try {
						String itemName = item.getName();
						Random generator = new Random();
						int r = Math.abs(generator.nextInt());

						String reg = "[.*]";
						String replacingtext = "";
						System.out.println("Text before replacing is:-" + itemName);
						Pattern pattern = Pattern.compile(reg);
						Matcher matcher = pattern.matcher(itemName);
						StringBuffer buffer = new StringBuffer();

						while (matcher.find()) {
							matcher.appendReplacement(buffer, replacingtext);
						}
						int IndexOf = itemName.indexOf(".");
						String domainName = itemName.substring(IndexOf);
						System.out.println("domainName: " + domainName);

						String finalimage = buffer.toString() + "_" + r + domainName;
						System.out.println("Final Image===" + finalimage);

						File savedFile = new File("D:/MPLT/" + "images\\" + finalimage);
						item.write(savedFile);
						out.println("<html>");
						out.println("<body>");
						out.println("<table><tr><td>");
						out.println("<img src=images/" + finalimage + ">");
						out.println("</td></tr></table>");

						Connection conn = null;
						String url = "jdbc:mysql://localhost:3306/";
						String dbName = "Karyawan_Insentif";
						String driver = "com.mysql.jdbc.Driver";
						String username = "root";
						String userPassword = "zulka....";
						String strQuery = null;
						try {
							System.out.println("itemName::::: " + itemName);
							Class.forName(driver).newInstance();
							conn = DriverManager.getConnection(url + dbName, username, userPassword);
							Statement st = conn.createStatement();
							strQuery = "insert into databarukaryawan set foto_karyawan='" + finalimage + "'";
							@SuppressWarnings("unused")
							int rs = st.executeUpdate(strQuery);
							System.out.println("Query Executed Successfully++++++++++++++");
							out.println("image inserted successfully");
							out.println("</body>");
							out.println("</html>");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						} finally {
							conn.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

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
