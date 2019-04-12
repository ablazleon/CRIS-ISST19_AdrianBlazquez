package es.upm.dit.isst.webLab.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professor implements Serializable{
	
	public Professor() {
		
	}
	
	@Id
	private String email;
	
	private String password;
	
	private String name;
	
	@OneToMany(mappedBy = "advisor", fetch = FetchType.EAGER)
	private List<TFG> advisedTFGs;
	
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
		this.name = name;
	}
	
	public List<TFG> getAdvisedTFGs() {
		return this.advisedTFGs;
	}
	
	public void setAdvisedTFGs(List<TFG> advisedTFGs) {
		this.advisedTFGs = advisedTFGs;
	}
}
