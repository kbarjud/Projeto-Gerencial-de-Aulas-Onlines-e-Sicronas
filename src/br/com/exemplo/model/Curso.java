package br.com.exemplo.model;

public class Curso {
	private int idCursoDisciplina;
	private String nomeCurso;
	private String disciplina;
	
	public Curso () {
			
		}
	
	public Curso(int idCursoDisciplina, String nomeCurso, String disciplina) {
		super();
		this.idCursoDisciplina = idCursoDisciplina;
		this.nomeCurso = nomeCurso;
		this.disciplina = disciplina;
	}
	
	public Curso(String nomeCurso) {
		super();
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
	
	public String getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return nomeCurso ;
	}
	
	public String toString2() {
		return disciplina ;
	}
}
