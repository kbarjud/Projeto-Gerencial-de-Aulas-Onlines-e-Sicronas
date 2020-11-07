package br.com.exemplo.model;

public class Turma {
	private int idTurma;
	private String nomeCurso;
	private String disciplina;
	private String turmaCod;
	private int alunosMatriculados;
	private String periodo;
	private String semestreLetivo;
	private int idCursoDisciplina;
	private int idSemestre;
	private String status;

	public Turma() {
		
	}
	
	public Turma(int idTurma, String nomeCurso, String disciplina, String turmaCod, int alunosMatriculados, String periodo, String semestreLetivo,
			int idCursoDisciplina, int idSemestre, String status) {
		super();
		this.idTurma = idTurma;
		this.nomeCurso = nomeCurso;
		this.disciplina = disciplina;
		this.turmaCod = turmaCod;
		this.alunosMatriculados = alunosMatriculados;
		this.periodo = periodo;
		this.semestreLetivo = semestreLetivo;
		this.idCursoDisciplina = idCursoDisciplina;
		this.idSemestre = idSemestre;
		this.status = status;
	}
	
	public Turma(int idTurma, String nomeCurso, String disciplina, String turmaCod, String periodo, String semestreLetivo, String status) {
		super();
		this.idTurma = idTurma;
		this.nomeCurso = nomeCurso;
		this.disciplina = disciplina;
		this.turmaCod = turmaCod;
		this.periodo = periodo;
		this.semestreLetivo = semestreLetivo;
		this.status = status;
	}

	public Turma(String turmaCod) {
		super();
		this.turmaCod = turmaCod;
	}
	
	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
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

	public String getTurmaCod() {
		return turmaCod;
	}

	public void setTurmaCod(String turmaCod) {
		this.turmaCod = turmaCod;
	}

	public int getAlunosMatriculados() {
		return alunosMatriculados;
	}

	public void setAlunosMatriculados(int alunosMatriculados) {
		this.alunosMatriculados = alunosMatriculados;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getSemestreLetivo() {
		return semestreLetivo;
	}

	public void setSemestreLetivo(String semestreLetivo) {
		this.semestreLetivo = semestreLetivo;
	}

	public int getIdCursoDisciplina() {
		return idCursoDisciplina;
	}

	public void setIdCursoDisciplina(int idCursoDisciplina) {
		this.idCursoDisciplina = idCursoDisciplina;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}

	@Override
	public  String toString() {
		return turmaCod;
	}
	public  String toString2() {
		return semestreLetivo;
	}
	public  String toString3() {
		return periodo;
	}
}
