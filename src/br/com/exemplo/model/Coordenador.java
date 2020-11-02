package br.com.exemplo.model;

public class Coordenador {
	private int idCoordenador;
	private int codCoordenador;
	private String nome;
	private String senha;
	private String email;
	private String celular;
	private String status;
	
	public Coordenador () {
		
	}

	public Coordenador(int idCoordenador, int codCoordenador, String nome, String senha, String email, String celular,
			String status) {
		super();
		this.idCoordenador = idCoordenador;
		this.codCoordenador = codCoordenador;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.celular = celular;
		this.status = status;
	}
	
	public Coordenador(int idProfessor, int codProfessor, String senha, String nome) {
		super();
		this.idCoordenador = idCoordenador;
		this.codCoordenador = codCoordenador;
		this.senha = senha;
		this.nome = nome;
	}

	public int getIdCoordenador() {
		return idCoordenador;
	}

	public void setIdCoordenador(int idCoordenador) {
		this.idCoordenador = idCoordenador;
	}

	public int getCodCoordenador() {
		return codCoordenador;
	}

	public void setCodCoordenador(int codCoordenador) {
		this.codCoordenador = codCoordenador;
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
}
