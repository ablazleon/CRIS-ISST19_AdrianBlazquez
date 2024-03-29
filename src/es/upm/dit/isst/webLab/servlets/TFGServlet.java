package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.TFGDAO;
import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;

@WebServlet("/TFGServlet")
public class TFGServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("email");
		
		TFGDAO tdao = TFGDAOImplementation.getInstance();
		
		req.getSession().setAttribute("tfg", tdao.read(id));
		getServletContext().getRequestDispatcher( "/TFGView.jsp" ).forward( req, resp );
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("email");
		
		TFGDAO tdao = TFGDAOImplementation.getInstance();
		
		req.getSession().setAttribute("tfg", tdao.read(id));
		getServletContext().getRequestDispatcher( "/TFGView.jsp" ).forward( req, resp );
	}
}
