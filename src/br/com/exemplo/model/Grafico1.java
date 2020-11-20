package br.com.exemplo.model;

public class Grafico1 {
	private String nomeCurso;
	private String turmaCod;
	private String periodo;
	private String semestre;
	private String dataInicio;
	private String dataFim;
	
	public Grafico1 () {
		
	}

	public Grafico1(String nomeCurso, String turmaCod, String periodo, String semestre, String dataInicio,
			String dataFim) {
		super();
		this.nomeCurso = nomeCurso;
		this.turmaCod = turmaCod;
		this.periodo = periodo;
		this.semestre = semestre;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getTurmaCod() {
		return turmaCod;
	}

	public void setTurmaCod(String turmaCod) {
		this.turmaCod = turmaCod;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	
}
