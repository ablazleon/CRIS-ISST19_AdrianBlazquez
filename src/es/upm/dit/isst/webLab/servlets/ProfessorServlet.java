package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.ProfessorDAO;
import es.upm.dit.isst.webLab.dao.ProfessorDAOImplementation;
import es.upm.dit.isst.webLab.model.Professor;

@WebServlet("/ProfessorServlet")
public class ProfessorServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("email");
		//System.out.println(id);
		ProfessorDAO pdao = ProfessorDAOImplementation.getInstance();
		Professor advisor = pdao.read(id);
		
		req.getSession().setAttribute("professor", advisor);
		getServletContext().getRequestDispatcher( "/ProfessorView.jsp" ).forward( req, resp );
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("email");
		//System.out.println(id);
		ProfessorDAO pdao = ProfessorDAOImplementation.getInstance();
		Professor advisor = pdao.read(id);
		
		req.getSession().setAttribute("professor", advisor);
		getServletContext().getRequestDispatcher( "/ProfessorView.jsp" ).forward( req, resp );
	}
	
}
