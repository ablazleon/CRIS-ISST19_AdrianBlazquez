package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Sha256Hash;

import es.upm.dit.isst.webLab.dao.ProfessorDAO;
import es.upm.dit.isst.webLab.dao.ProfessorDAOImplementation;
import es.upm.dit.isst.webLab.dao.TFGDAO;
import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;
import es.upm.dit.isst.webLab.model.Professor;
import es.upm.dit.isst.webLab.model.TFG;

@WebServlet("/CreateTFGServlet")
public class CreateTFGServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter( "nameTfg" );
		//System.out.println(name);
		String password = req.getParameter( "passwordTfg" );
		//System.out.println(password);
		String email = req.getParameter( "emailTfg" );
		//System.out.println(email);
		String title = req.getParameter("title");
		//System.out.println(email);
		int status = 1;
		ProfessorDAO pdao = ProfessorDAOImplementation.getInstance();
		Professor professor = pdao.read(req.getParameter("advisor"));
		//System.out.println(professor.getName());
		TFG tfg = new TFG();
		
		tfg.setName( name );
		tfg.setEmail( email );
		tfg.setPassword( new Sha256Hash( password ).toString() );
		tfg.setTitle(title);
		tfg.setStatus(status);
		tfg.setAdvisor(professor);
		
		TFGDAO tdao = TFGDAOImplementation.getInstance();
		tdao.create(tfg);
		
		resp.sendRedirect( req.getContextPath() + "/LoginServlet" );
	}
}
