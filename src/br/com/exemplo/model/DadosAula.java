package br.com.exemplo.model;

public class DadosAula {
	private int idAula;
	private String curso;
	private String disciplina;
	private String turma;
	private String periodo;
	private String semestreLetivo;
	private String dataAula;
	private boolean teveAula;
	private String justificativa;
	private String horarioInicio;
	private String horarioTermino;
	private String assunto;
	private String qtdAlunos;
	private String materiaisDisponibilizados;
	private String linkSessao;
	private String linkGravacao;
	private String obs;
	private boolean atividadeSolicitada;
	private String dataEntrega;
	private String qtdPessoas;
	private String descricao;
	private int idCursoDisciplina;
	private int idTurma;
	private int idProfessor;
	private int codProfessor;
	private String passSenha;
	
	public DadosAula() {
		
	}
	
	public DadosAula(int idAula, String curso, String disciplina, String turma, String periodo, String semestreLetivo,
			String dataAula, boolean teveAula, String justificativa, String horarioInicio, String horarioTermino,
			String assunto, String qtdAlunos, String materiaisDisponibilizados, String linkSessao, String linkGravacao,
			String obs, boolean atividadeSolicitada, String dataEntrega, String qtdPessoas, String descricao,
			int idCursoDisciplina, int idTurma, int idProfessor) {
		super();
		this.idAula = idAula;
		this.curso = curso;
		this.disciplina = disciplina;
		this.turma = turma;
		this.periodo = periodo;
		this.semestreLetivo = semestreLetivo;
		this.dataAula = dataAula;
		this.teveAula = teveAula;
		this.justificativa = justificativa;
		this.horarioInicio = horarioInicio;
		this.horarioTermino = horarioTermino;
		this.assunto = assunto;
		this.qtdAlunos = qtdAlunos;
		this.materiaisDisponibilizados = materiaisDisponibilizados;
		this.linkSessao = linkSessao;
		this.linkGravacao = linkGravacao;
		this.obs = obs;
		this.atividadeSolicitada = atividadeSolicitada;
		this.dataEntrega = dataEntrega;
		this.qtdPessoas = qtdPessoas;
		this.descricao = descricao;
		this.idCursoDisciplina = idCursoDisciplina;
		this.idTurma = idTurma;
		this.idProfessor = idProfessor;
	}
	
	public int getIdAula() {
		return idAula;
	}

	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
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

	public String getDataAula() {
		return dataAula;
	}

	public void setDataAula(String dataAula) {
		this.dataAula = dataAula;
	}

	public boolean isTeveAula() {
		return teveAula;
	}

	public void setTeveAula(boolean teveAula) {
		this.teveAula = teveAula;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioTermino() {
		return horarioTermino;
	}

	public void setHorarioTermino(String horarioTermino) {
		this.horarioTermino = horarioTermino;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getQtdAlunos() {
		return qtdAlunos;
	}

	public void setQtdAlunos(String qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}

	public String getMateriaisDisponibilizados() {
		return materiaisDisponibilizados;
	}

	public void setMateriaisDisponibilizados(String materiaisDisponibilizados) {
		this.materiaisDisponibilizados = materiaisDisponibilizados;
	}

	public String getLinkSessao() {
		return linkSessao;
	}

	public void setLinkSessao(String linkSessao) {
		this.linkSessao = linkSessao;
	}

	public String getLinkGravacao() {
		return linkGravacao;
	}

	public void setLinkGravacao(String linkGravacao) {
		this.linkGravacao = linkGravacao;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public boolean isAtividadeSolicitada() {
		return atividadeSolicitada;
	}

	public void setAtividadeSolicitada(boolean atividadeSolicitada) {
		this.atividadeSolicitada = atividadeSolicitada;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(String qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdCursoDisciplina() {
		return idCursoDisciplina;
	}

	public void setIdCursoDisciplina(int idCursoDisciplina) {
		this.idCursoDisciplina = idCursoDisciplina;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}
}
