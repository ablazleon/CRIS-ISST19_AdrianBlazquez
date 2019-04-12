package es.upm.dit.isst.webLab.dao;

import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.webLab.model.Professor;

public class ProfessorDAOImplementation implements ProfessorDAO{
	
	private static  ProfessorDAOImplementation instancia = null;
	
	private ProfessorDAOImplementation() {}
	
	public static ProfessorDAOImplementation getInstance() {
	  if( null == instancia ) 
	    instancia = new ProfessorDAOImplementation();
	  return instancia;
	}

	@Override
	public void create(Professor professor) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  session.save(professor);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
	}

	@Override
	public Professor read(String email) {
		Professor professor = null;
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  professor = session.get(Professor.class, email);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		// TODO Auto-generated method stub
		return professor;
	}

	@Override
	public void update(Professor professor) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  session.saveOrUpdate(professor);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		
	}

	@Override
	public void delete(Professor professor) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  session.delete(professor);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
	}

	@Override
	public Collection<Professor> readAll() {
		Collection<Professor> professors = null;
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  professors = session.createQuery("from Professor").list();
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		return professors;
	}
}
