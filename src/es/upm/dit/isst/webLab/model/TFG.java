package es.upm.dit.isst.webLab.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class TFG implements Serializable{
	
	//constructor
	public TFG() {
		
	}
	
	@Id
	private String email;
	
	private String password;
	
	private String name;
	
	private String title;
	
	private int status;
	
	@Lob
	private byte[] document;
	
	private double grade;
	
	@ManyToOne
	private Professor advisor;
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name= name;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public byte[] getDocument() {
		return this.document;
	}
	
	public void setDocument(byte[] document) {
		this.document = document;
	}
	
	public double getGrade() {
		return this.grade;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public Professor getAdvisor() {
		return this.advisor;
	}
	
	public void setAdvisor(Professor advisor) {
		this.advisor = advisor;
	}
}
