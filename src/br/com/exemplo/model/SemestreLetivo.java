package br.com.exemplo.model;

public class SemestreLetivo {
	private int idSemestre;
	private String semestre;
	private String status;
	
	public SemestreLetivo() {
		
	}
	
	public SemestreLetivo(int idSemestre, String semestre, String status) {
		super();
		this.idSemestre = idSemestre;
		this.semestre = semestre;
		this.status = status;
	}
	
	public SemestreLetivo(String semestre) {
		super();
		this.semestre = semestre;
	}

	public int getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString() {
		return semestre;
	}
}
