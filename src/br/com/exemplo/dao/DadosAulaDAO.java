package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.model.DadosAula;
import br.com.exemplo.until.ConnectionFactory;

public class DadosAulaDAO {
	private DadosAula dadosAula;
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;
	
	public DadosAulaDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception erro) {
			throw new Exception ("Erro: " + erro.getMessage());
		}
	}
	public void Salvar (DadosAula dadosAula) throws Exception {
		try {
			String sql = "INSERT INTO dados_aulas (curso, disciplina, turma, periodo, semestre_letivo, data_aula, teve_aula, justificativa, horario_inicio, horario_termino, assunto, qtd_alunos, "
					+ " materiais_disponibilizados, link_sessao, link_gravacao, obs, atividade_solicitada, data_entrega, qtd_pessoas, descricao, id_curso_disciplina, id_turma, id_professor, id_semestre ) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setString (1, dadosAula.getCurso());
			ps.setString (2, dadosAula.getDisciplina());
			ps.setString (3, dadosAula.getTurma());
			ps.setString (4, dadosAula.getPeriodo());
			ps.setString (5, dadosAula.getSemestreLetivo());
			ps.setString (6, dadosAula.getDataAula());
			ps.setBoolean (7, dadosAula.isTeveAula());
			ps.setString (8, dadosAula.getJustificativa());
			ps.setString (9, dadosAula.getHorarioInicio());
			ps.setString (10, dadosAula.getHorarioTermino());
			ps.setString (11, dadosAula.getAssunto());
			ps.setInt (12, dadosAula.getQtdAlunos());
			ps.setString (13, dadosAula.getMateriaisDisponibilizados());
			ps.setString (14, dadosAula.getLinkSessao());
			ps.setString (15, dadosAula.getLinkGravacao());
			ps.setString (16, dadosAula.getObs());
			ps.setBoolean (17, dadosAula.isAtividadeSolicitada());
			ps.setString (18, dadosAula.getDataEntrega());
			ps.setString (19, dadosAula.getQtdPessoas());
			ps.setString (20, dadosAula.getDescricao());
			ps.setInt (21, dadosAula.getIdCursoDisciplina());
			ps.setInt (22, dadosAula.getIdTurma());
			ps.setInt (23, dadosAula.getIdProfessor());
			ps.setInt (24, dadosAula.getIdSemestre());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Salvar1 (DadosAula dadosAula) throws Exception {
		try {
			String sql = "INSERT INTO dados_aulas (curso, disciplina, turma, periodo, semestre_letivo, data_aula, teve_aula, justificativa, id_curso_disciplina, id_turma, id_professor, id_semestre ) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setString (1, dadosAula.getCurso());
			ps.setString (2, dadosAula.getDisciplina());
			ps.setString (3, dadosAula.getTurma());
			ps.setString (4, dadosAula.getPeriodo());
			ps.setString (5, dadosAula.getSemestreLetivo());
			ps.setString (6, dadosAula.getDataAula());
			ps.setBoolean (7, dadosAula.isTeveAula());
			ps.setString (8, dadosAula.getJustificativa());
			ps.setInt (9, dadosAula.getIdCursoDisciplina());
			ps.setInt (10, dadosAula.getIdTurma());
			ps.setInt (11, dadosAula.getIdProfessor());
			ps.setInt (12, dadosAula.getIdSemestre());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Alterar (DadosAula dadosAula) throws Exception {
		try { 
			String sql = "UPDATE dados_aulas SET curso=?, disciplina=?, turma=?, periodo=?, semestre_letivo=?, data_aula=?, teve_aula=?, justificativa=?, horario_inicio=?, horario_termino=?, assunto=?, qtd_alunos=? "
					+ " materiais_disponibilizados=?, link_sesssao=?, link_gravacao=?, obs=?, atividade_solicitada=?, data_entrega=?, qtd_pessoas=?, descricao=?, id_curso_disciplina=?, id_turma=?, id_professor=?, id_semestre=? "
					+ " WHERE id_aula=? ";
			ps = conn.prepareStatement(sql);
			ps.setString (1, dadosAula.getCurso());
			ps.setString (2, dadosAula.getDisciplina());
			ps.setString (3, dadosAula.getTurma());
			ps.setString (4, dadosAula.getPeriodo());
			ps.setString (5, dadosAula.getSemestreLetivo());
			ps.setString (6, dadosAula.getDataAula());
			ps.setBoolean (7, dadosAula.isTeveAula());
			ps.setString (8, dadosAula.getJustificativa());
			ps.setString (9, dadosAula.getHorarioInicio());
			ps.setString (10, dadosAula.getHorarioTermino());
			ps.setString (11, dadosAula.getAssunto());
			ps.setInt (12, dadosAula.getQtdAlunos());
			ps.setString (13, dadosAula.getMateriaisDisponibilizados());
			ps.setString (14, dadosAula.getLinkSessao());
			ps.setString (15, dadosAula.getLinkGravacao());
			ps.setString (16, dadosAula.getObs());
			ps.setBoolean (17, dadosAula.isAtividadeSolicitada());
			ps.setString (18, dadosAula.getDataEntrega());
			ps.setString (19, dadosAula.getQtdPessoas());
			ps.setString (20, dadosAula.getDescricao());
			ps.setInt (21, dadosAula.getIdCursoDisciplina());
			ps.setInt (22, dadosAula.getIdTurma());
			ps.setInt (23, dadosAula.getIdProfessor());
			ps.setInt (24, dadosAula.getIdSemestre());
			ps.setInt (25, dadosAula.getIdAula());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Alterar1 (DadosAula dadosAula) throws Exception {
		try { 
			String sql = "UPDATE dados_aulas SET curso=?, disciplina=?, turma=?, periodo=?, semestre_letivo=?, data_aula=?, teve_aula=?, justificativa=?, id_curso_disciplina=?, id_turma=?, id_professor=?, id_semestre=? "
					+ " WHERE id_aula=? ";
			ps = conn.prepareStatement(sql);
			ps.setString (1, dadosAula.getCurso());
			ps.setString (2, dadosAula.getDisciplina());
			ps.setString (3, dadosAula.getTurma());
			ps.setString (4, dadosAula.getPeriodo());
			ps.setString (5, dadosAula.getSemestreLetivo());
			ps.setString (6, dadosAula.getDataAula());
			ps.setBoolean (7, dadosAula.isTeveAula());
			ps.setString (8, dadosAula.getJustificativa());
			ps.setInt (9, dadosAula.getIdCursoDisciplina());
			ps.setInt (10, dadosAula.getIdTurma());
			ps.setInt (11, dadosAula.getIdProfessor());
			ps.setInt (12, dadosAula.getIdSemestre());
			ps.setInt (13, dadosAula.getIdAula());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Excluir (int idAula) throws Exception {
		try {
			String sql = "DELETE FROM dados_aulas WHERE id_aula=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt (1, idAula);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public DadosAula Consultar (String nomeCurso, String nomeDisciplina, String turma, String periodo, String semestreLetivo, String data) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM dados_aulas "
					+ " WHERE curso=? AND disciplina=? AND turma=? AND periodo=? AND semestre_letivo=? AND data_aula=?"); 
			ps.setString (1, nomeCurso);
			ps.setString (2, nomeDisciplina);
			ps.setString (3, turma);
			ps.setString (4, periodo);
			ps.setString (5, semestreLetivo);
			ps.setString (6, data);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idAula1 = rs.getInt ("id_aula");
				String curso = rs.getString ("curso");
				String disciplina = rs.getString ("disciplina");
				String turma1 = rs.getString ("turma");
				String periodo1 = rs.getString ("periodo");
				String semestreLetivo1 = rs.getString ("semestre_letivo");
				String dataAula = rs.getString ("data_aula");
				boolean teveAula = rs.getBoolean ("teve_aula");
				String justificativa = rs.getString ("justificativa");
				String horarioInicio = rs.getString ("horario_inicio");
				String horarioTermino = rs.getString ("horario_termino");
				String assunto = rs.getString ("assunto");
				int qtdAlunos = rs.getInt ("qtd_alunos");
				String materiaisDisponibilizados = rs.getString ("materiais_disponibilizados");
				String linkSessao = rs.getString ("link_sessao");
				String linkGravacao = rs.getString ("link_gravacao");
				String obs = rs.getString ("obs");
				boolean atividadeSolicitada = rs.getBoolean ("atividade_solicitada");
				String dataEntrega = rs.getString ("data_entrega");
				String qtdPessoas = rs.getString ("qtd_pessoas");
				String descricao = rs.getString ("descricao");
				int idCursoDisciplina = rs.getInt ("id_curso_disciplina");
				int idTurma = rs.getInt ("id_turma");
				int idProfessor = rs.getInt ("id_professor");
				int idSemestre = rs.getInt ("id_semestre");
				dadosAula = new DadosAula (idAula1, curso, disciplina, turma1, periodo1, semestreLetivo1, dataAula, teveAula, justificativa, horarioInicio, horarioTermino, assunto, qtdAlunos, materiaisDisponibilizados, linkSessao, linkGravacao, obs, atividadeSolicitada, dataEntrega, qtdPessoas, descricao, idCursoDisciplina, idTurma, idProfessor, idSemestre);
			}
				return dadosAula;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos() throws Exception {
		List<DadosAula> lista = new ArrayList<DadosAula>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM dados_aulas");
			rs = ps.executeQuery();
			while (rs.next()) {
				int idAula = rs.getInt ("id_aula");
				String curso = rs.getString ("curso");
				String disciplina = rs.getString ("disciplina");
				String turma = rs.getString ("turma");
				String periodo = rs.getString ("periodo");
				String semestreLetivo = rs.getString ("semestre_letivo");
				String dataAula = rs.getString ("data_aula");
				boolean teveAula = rs.getBoolean ("teve_aula");
				String justificativa = rs.getString ("justificativa");
				String horarioInicio = rs.getString ("horario_inicio");
				String horarioTermino = rs.getString ("horario_termino");
				String assunto = rs.getString ("assunto");
				int qtdAlunos = rs.getInt ("qtd_alunos");
				String materiaisDisponibilizados = rs.getString ("materiais_disponibilizados");
				String linkSessao = rs.getString ("link_sessao");
				String linkGravacao = rs.getString ("linkGravacao");
				String obs = rs.getString ("obs");
				boolean atividadeSolicitada = rs.getBoolean ("atividade_solicitada");
				String dataEntrega = rs.getString ("dataEntrega");
				String qtdPessoas = rs.getString ("qtd_pessoas");
				String descricao = rs.getString ("descricao");
				int idCursoDisciplina = rs.getInt ("id_curso_disciplina");
				int idTurma = rs.getInt ("idTurma");
				int idProfessor = rs.getInt ("id_professor");
				int idSemestre = rs.getInt ("id_semestre");
				dadosAula = new DadosAula (idAula, curso, disciplina, turma, periodo, semestreLetivo, dataAula, teveAula, justificativa, horarioInicio, horarioTermino, assunto, qtdAlunos, materiaisDisponibilizados, linkSessao, linkGravacao, obs, atividadeSolicitada, dataEntrega, qtdPessoas, descricao, idCursoDisciplina, idTurma, idProfessor, idSemestre);
				lista.add(dadosAula);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos1(int idAula) throws Exception {
		List<DadosAula> lista = new ArrayList<DadosAula>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM dados_aula "
					+ " WHERE id_aula=?");
			ps.setInt (1, idAula);
			rs = ps.executeQuery();
			while (rs.next()) {
				int idAula1 = rs.getInt ("id_aula");
				String curso = rs.getString ("curso");
				String disciplina = rs.getString ("disciplina");
				String turma = rs.getString ("turma");
				String periodo = rs.getString ("periodo");
				String semestreLetivo = rs.getString ("semestre_letivo");
				String dataAula = rs.getString ("data_aula");
				boolean teveAula = rs.getBoolean ("teve_aula");
				String justificativa = rs.getString ("justificativa");
				String horarioInicio = rs.getString ("horario_inicio");
				String horarioTermino = rs.getString ("horario_termino");
				String assunto = rs.getString ("assunto");
				int qtdAlunos = rs.getInt ("qtd_alunos");
				String materiaisDisponibilizados = rs.getString ("materiais_disponibilizados");
				String linkSessao = rs.getString ("link_sessao");
				String linkGravacao = rs.getString ("linkGravacao");
				String obs = rs.getString ("obs");
				boolean atividadeSolicitada = rs.getBoolean ("atividade_solicitada");
				String dataEntrega = rs.getString ("dataEntrega");
				String qtdPessoas = rs.getString ("qtd_pessoas");
				String descricao = rs.getString ("descricao");
				int idCursoDisciplina = rs.getInt ("id_curso_disciplina");
				int idTurma = rs.getInt ("idTurma");
				int idProfessor = rs.getInt ("id_professor");
				int idSemestre = rs.getInt ("id_semestre");
				dadosAula = new DadosAula (idAula, curso, disciplina, turma, periodo, semestreLetivo, dataAula, teveAula, justificativa, horarioInicio, horarioTermino, assunto, qtdAlunos, materiaisDisponibilizados, linkSessao, linkGravacao, obs, atividadeSolicitada, dataEntrega, qtdPessoas, descricao, idCursoDisciplina, idTurma, idProfessor, idSemestre);
				lista.add(dadosAula);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
}
