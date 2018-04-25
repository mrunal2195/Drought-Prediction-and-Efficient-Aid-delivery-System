package com.Naive.WebServices;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.Naive.JavaSource.*;

/**
 * Servlet implementation class Accept_Route
 */
@WebServlet("/Accept_Route")
public class Accept_Route extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Accept_Route() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String inputWaterDepth = request.getParameter("txt_waterlevel");
		String inputAvgRainfall = request.getParameter("txt_rainfall");
		String inputPopulation = request.getParameter("txt_population");
		String inputName = request.getParameter("txt_name");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Naive_Predict nv = new Naive_Predict();

		try {
			String status = nv.predict(inputWaterDepth, inputAvgRainfall, inputPopulation);

			out.print(status);

		} catch (Exception e) {
			out.print(e.getMessage());
		}

	}

}
