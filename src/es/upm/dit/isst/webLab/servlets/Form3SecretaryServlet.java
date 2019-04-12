package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.TFGDAO;
import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;
import es.upm.dit.isst.webLab.model.TFG;

@WebServlet("/Form3SecretaryServlet")
public class Form3SecretaryServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("email");
		
		//System.out.println(idProfessor);
		
		TFGDAO tdao = TFGDAOImplementation.getInstance();
		TFG tfg = tdao.read(id);
		
		// Cambio el estado del tfg a aceptado por el profesor
		tfg.setStatus(3);
		
		// Guardo el cambio en la base de datos
		tdao.update(tfg);
		
		RequestDispatcher dispatcher = getServletContext()
			      .getRequestDispatcher("/AdminServlet");
			    dispatcher.forward(req, resp);
	}
}
