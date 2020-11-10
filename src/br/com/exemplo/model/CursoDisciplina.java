package br.com.exemplo.model;

public class CursoDisciplina {
	private int idCursoDisciplina;
	private String nomeCurso;
	private String nomeDisciplina;
	private int idCurso;
	private int idDisciplina;
	private String status;
	
	public CursoDisciplina () {
		
	}
	public CursoDisciplina(int idCursoDisciplina, String nomeCurso, String nomeDisciplina, int idCurso,
			int idDisciplina, String status) {
		super();
		this.idCursoDisciplina = idCursoDisciplina;
		this.nomeCurso = nomeCurso;
		this.nomeDisciplina = nomeDisciplina;
		this.idCurso = idCurso;
		this.idDisciplina = idDisciplina;
		this.status = status;
	}
	public CursoDisciplina (String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public CursoDisciplina (String nomeDisciplina, String nomeCurso) {
		this.nomeDisciplina = nomeDisciplina;
		this.nomeCurso = nomeCurso;
	}
	public int getIdCursoDisciplina() {
		return idCursoDisciplina;
	}
	public void setIdCursoDisciplina(int idCursoDisciplina) {
		this.idCursoDisciplina = idCursoDisciplina;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public int getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
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
