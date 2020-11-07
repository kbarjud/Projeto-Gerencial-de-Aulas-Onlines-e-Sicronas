package br.com.exemplo.model;

public class Curso {
	private int idCurso;
	private String nomeCurso;
	private String status;
	
	public Curso () {
			
		}
	
	public Curso(int idCurso, String nomeCurso, String status) {
		super();
		this.idCurso = idCurso;
		this.nomeCurso = nomeCurso;
		this.status = status;
	}
	
	public Curso(String nomeCurso) {
		super();
		this.nomeCurso = nomeCurso;
	}
	
	public int getIdCurso() {
		return idCurso;
	}
	
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return nomeCurso ;
	}
}
