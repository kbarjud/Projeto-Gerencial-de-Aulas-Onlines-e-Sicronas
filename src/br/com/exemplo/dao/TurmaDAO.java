package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.model.Curso;
import br.com.exemplo.model.Turma;
import br.com.exemplo.until.ConnectionFactory;

public class TurmaDAO {
	private Turma turma;
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;
	
	public TurmaDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception erro) {
			throw new Exception ("Erro: " + erro.getMessage());
		}
	}
	public void Salvar (Turma turma) throws Exception {
		try {
			String sql = "INSERT INTO turma (curso, disciplina, turma, alunos_matriculados, periodo, semestre_letivo, id_curso_disciplina, idSemestre, status ) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setString (1, turma.getNomeCurso());
			ps.setString (2, turma.getDisciplina());
			ps.setString (3, turma.getTurmaCod());
			ps.setInt (4, turma.getAlunosMatriculados());
			ps.setString (5, turma.getPeriodo());
			ps.setString (6, turma.getSemestreLetivo());
			ps.setInt (7, turma.getIdCursoDisciplina());
			ps.setInt (8, turma.getIdSemestre());
			ps.setString (9, turma.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Alterar (Turma turma) throws Exception {
		try { 
			String sql = "UPDATE turma SET curso=?, disciplina=?, turma=?, alunos_matriculados=?, periodo=?, semestre_letivo=?, id_curso_disciplina=?, idSemestre=?, status=? "
					+ " WHERE id_turma=? ";
			ps = conn.prepareStatement(sql);
			ps.setString (1, turma.getNomeCurso());
			ps.setString (2, turma.getDisciplina());
			ps.setString (3, turma.getTurmaCod());
			ps.setInt (4, turma.getAlunosMatriculados());
			ps.setString (5, turma.getPeriodo());
			ps.setString (6, turma.getSemestreLetivo());
			ps.setInt (7, turma.getIdCursoDisciplina());
			ps.setInt (8, turma.getIdSemestre());
			ps.setString (9, turma.getStatus());
			ps.setInt (10, turma.getIdTurma());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Excluir (int idTurma) throws Exception {
		try {
			String sql = "DELETE FROM turma WHERE id_turma=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt (1, idTurma);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public Turma Consultar (int idTurma) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM turma "
					+ " WHERE id_turma=?"); 
			ps.setInt (1, idTurma);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idTurma1 = rs.getInt ("id_turma");
				String nomeCurso = rs.getString ("curso");
				String disciplina = rs.getString ("disciplina");
				String turma1 = rs.getString ("turma");
				int alunosMatriculados = rs.getInt ("alunos_matriculados");
				String periodo = rs.getString ("periodo");
				String semestreLetivo = rs.getString ("semestre_letivo");
				int idCursoDisciplina = rs.getInt ("id_curso_disciplina");
				int idSemestre = rs.getInt ("id_semestre");
				String status = rs.getString ("status");
				turma = new Turma (idTurma1, nomeCurso, disciplina, turma1, alunosMatriculados, periodo, semestreLetivo, idCursoDisciplina, idSemestre, status);
			}
				return turma;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public Turma Consultar1 (String nomeCurso, String disciplina, String turmaCod, String periodo, String semestreLetivo, String status) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM turma "
					+ " WHERE curso=? AND disciplina=? AND turma=? AND periodo=? AND semestre_letivo=? AND status=? "); 
			ps.setString (1, nomeCurso);
			ps.setString (2, disciplina);
			ps.setString (3, turmaCod);
			ps.setString (4, periodo);
			ps.setString (5, semestreLetivo);
			ps.setString (6, status);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idTurma = rs.getInt ("id_turma");
				String curso = rs.getString ("curso");
				String disciplina1 = rs.getString ("disciplina");
				String turma1 = rs.getString ("turma");
				String periodo1 = rs.getString ("periodo");
				String semestreLetivo1 = rs.getString ("semestre_letivo");
				String status1 = rs.getString ("status");
				turma = new Turma (idTurma, curso, disciplina1, turma1, periodo1, semestreLetivo1, status1);
			}
				return turma;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos() throws Exception {
		List<Turma> lista = new ArrayList<Turma>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM turma");
			rs = ps.executeQuery();
			while (rs.next()) {
				int idTurma1 = rs.getInt ("id_turma");
				String nomeCurso = rs.getString ("curso");
				String disciplina = rs.getString ("disciplina");
				String turma1 = rs.getString ("turma");
				int alunosMatriculados = rs.getInt ("alunos_matriculados");
				String periodo = rs.getString ("periodo");
				String semestreLetivo = rs.getString ("semestre_letivo");
				int idCursoDisciplina = rs.getInt ("id_curso_disciplina");
				int idSemestre = rs.getInt ("id_semestre");
				String status = rs.getString ("status");
				turma = new Turma (idTurma1, nomeCurso, disciplina, turma1, alunosMatriculados, periodo, semestreLetivo, idCursoDisciplina, idSemestre, status);
				lista.add(turma);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos1(int idTurma) throws Exception {
		List<Turma> lista = new ArrayList<Turma>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM turma "
					+ " WHERE id_turma=?");
			ps.setInt (1, idTurma);
			rs = ps.executeQuery();
			while (rs.next()) {
				int idTurma1 = rs.getInt ("id_turma");
				String nomeCurso = rs.getString ("curso");
				String disciplina = rs.getString ("disciplina");
				String turma1 = rs.getString ("turma");
				int alunosMatriculados = rs.getInt ("alunos_matriculados");
				String periodo = rs.getString ("periodo");
				String semestreLetivo = rs.getString ("semestre_letivo");
				int idCursoDisciplina = rs.getInt ("id_curso_disciplina");
				int idSemestre = rs.getInt ("id_semestre");
				String status = rs.getString ("status");
				turma = new Turma (idTurma1, nomeCurso, disciplina, turma1, alunosMatriculados, periodo, semestreLetivo, idCursoDisciplina, idSemestre, status);
				lista.add(turma);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Desativar (Turma turma) throws Exception {
		try { 
			String sql = "UPDATE turma SET status=? "
					+ " WHERE id_turma=? ";
			ps = conn.prepareStatement(sql);
			ps.setString (1, turma.getStatus());
			ps.setInt (2, turma.getIdTurma());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos2(String nomeCurso, String disciplina, String status) throws Exception {
		List<Turma> lista = new ArrayList<Turma>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM turma WHERE curso LIKE ? AND disciplina LIKE ? AND status LIKE ? GROUP BY turma");
			ps.setString (1, nomeCurso);
			ps.setString (2, disciplina);
			ps.setString (3, status);
			rs = ps.executeQuery();
			while (rs.next()) {
				String turma1 = rs.getString ("turma");
				turma = new Turma (turma1);
				lista.add(turma);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos3(String nomeCurso, String disciplina, String turmaCod, String status) throws Exception {
		List<Turma> lista = new ArrayList<Turma>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM turma WHERE curso LIKE ? AND disciplina LIKE ? AND turma LIKE ? AND status LIKE ? GROUP BY semestre_letivo");
			ps.setString (1, nomeCurso);
			ps.setString (2, disciplina);
			ps.setString (3, turmaCod);
			ps.setString (4, status);
			rs = ps.executeQuery();
			while (rs.next()) {
				String semetreLetivo = rs.getString ("semestre_letivo");
				turma = new Turma (semetreLetivo);
				lista.add(turma);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos4(String nomeCurso, String disciplina, String turmaCod, String status) throws Exception {
		List<Turma> lista = new ArrayList<Turma>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM turma WHERE curso LIKE ? AND disciplina LIKE ? AND turma LIKE ? AND status LIKE ? GROUP BY periodo");
			ps.setString (1, nomeCurso);
			ps.setString (2, disciplina);
			ps.setString (3, turmaCod);
			ps.setString (4, status);
			rs = ps.executeQuery();
			while (rs.next()) {
				String periodo = rs.getString ("periodo");
				turma = new Turma (periodo);
				lista.add(turma);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	
	public List ListarTodos5(String nomeCurso, String disciplina, String status) throws Exception {
		List<Turma> lista = new ArrayList<Turma>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM turma WHERE curso LIKE ? AND disciplina LIKE ? AND status=? GROUP BY semestre_letivo");
			ps.setString (1, nomeCurso);
			ps.setString (2, disciplina);
			ps.setString (3, status);
			rs = ps.executeQuery();
			while (rs.next()) {
				String semetreLetivo = rs.getString ("semestre_letivo");
				turma = new Turma (semetreLetivo);
				lista.add(turma);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos6(String nomeCurso, String disciplina, String status) throws Exception {
		List<Turma> lista = new ArrayList<Turma>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM turma WHERE curso LIKE ? AND disciplina LIKE ? AND status=? GROUP BY periodo");
			ps.setString (1, nomeCurso);
			ps.setString (2, disciplina);
			ps.setString (3, status);
			rs = ps.executeQuery();
			while (rs.next()) {
				String periodo = rs.getString ("periodo");
				turma = new Turma (periodo);
				lista.add(turma);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
}
