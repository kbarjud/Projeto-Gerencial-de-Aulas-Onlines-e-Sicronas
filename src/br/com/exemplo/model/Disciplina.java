package br.com.exemplo.model;

public class Disciplina {
	private int idDisciplina;
	private String nomeDisciplina;
	private String status;
	
	public Disciplina () {
			
		}
	
	public Disciplina(int idDisciplina, String nomeDisciplina, String status) {
		super();
		this.idDisciplina = idDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.status = status;
	}
	
	public Disciplina(String nomeDisciplina) {
		super();
		this.nomeDisciplina = nomeDisciplina;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString() {
		return nomeDisciplina;
	}
}
