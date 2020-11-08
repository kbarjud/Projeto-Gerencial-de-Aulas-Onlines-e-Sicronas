package br.com.exemplo.model;

public class Professores {
	private int idProfessor;
	private int codProfessor;
	private String nome;
	private String senha;
	private String email;
	private String celular;
	private String status;
	
	public Professores () {
		
	}
	public Professores(int idProfessor, int codProfessor, String nome, String senha, String email, String celular, String status) {
		super();
		this.idProfessor = idProfessor;
		this.codProfessor = codProfessor;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.celular = celular;
		this.status = status;
	}
	public Professores(int idProfessor, int codProfessor, String senha, String nome) {
		super();
		this.idProfessor = idProfessor;
		this.codProfessor = codProfessor;
		this.senha = senha;
		this.nome = nome;
	}
	public int getIdProfessor() {
		return idProfessor;
	}
	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}
	public int getCodProfessor() {
		return codProfessor;
	}
	public void setCodProfessor(int codProfessor) {
		this.codProfessor = codProfessor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString() {
		return nome;
	}
}
