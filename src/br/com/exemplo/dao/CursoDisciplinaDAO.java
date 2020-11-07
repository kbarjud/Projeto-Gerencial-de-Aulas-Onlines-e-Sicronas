package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.model.CursoDisciplina;
import br.com.exemplo.until.ConnectionFactory;

public class CursoDisciplinaDAO {
	private CursoDisciplina cursoDisciplina;
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;
	
	public CursoDisciplinaDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception erro) {
			throw new Exception ("Erro: " + erro.getMessage());
		}
	}
	public void Salvar (CursoDisciplina cursoDisciplina) throws Exception {
		try {
			String sql = "INSERT INTO curso_disciplina (curso, disciplina, id_curso, id_disciplina, status ) "
					+ " values (?, ?, ?, ?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setString (1, cursoDisciplina.getNomeCurso());
			ps.setString (2, cursoDisciplina.getNomeDisciplina());
			ps.setInt (3, cursoDisciplina.getIdCurso());
			ps.setInt (4, cursoDisciplina.getIdDisciplina());
			ps.setString (5, cursoDisciplina.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Alterar (CursoDisciplina cursoDisciplina) throws Exception {
		try { 
			String sql = "UPDATE disciplina SET curso=?, disciplina=?, id_curso=?, id_disciplina=?, status=? "
					+ " WHERE id_curso_disciplina=? ";
			ps = conn.prepareStatement(sql);
			ps.setString (1, cursoDisciplina.getNomeCurso());
			ps.setString (2, cursoDisciplina.getNomeDisciplina());
			ps.setInt (3, cursoDisciplina.getIdCurso());
			ps.setInt (4, cursoDisciplina.getIdDisciplina());
			ps.setString (5, cursoDisciplina.getStatus());
			ps.setInt (6, cursoDisciplina.getIdCursoDisciplina());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Excluir (int idCursoDisciplina) throws Exception {
		try {
			String sql = "DELETE FROM curso_disciplina WHERE id_curso_disciplina=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt (1, idCursoDisciplina);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public CursoDisciplina Consultar (int idCursoDisciplina) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso_disciplina "
					+ " WHERE id_curso_disciplina=?"); 
			ps.setInt (1, idCursoDisciplina);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idCursoDisciplina1 = rs.getInt ("id_curso_disciplina");
				String nomeCurso = rs.getString ("curso");
				String nomeDisciplina = rs.getString ("disciplina");
				int idCurso = rs.getInt ("id_curso");
				int idDisciplina = rs.getInt ("id_disciplina");
				String status = rs.getString ("status");
				cursoDisciplina = new CursoDisciplina (idCursoDisciplina1, nomeCurso, nomeDisciplina, idCurso, idDisciplina, status);
			}
				return cursoDisciplina;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public CursoDisciplina Consultar1 (String nomeCurso, String nomeDisciplina, String status) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso_disciplina "
					+ " WHERE curso=? AND disciplina=? AND status=? "); 
			ps.setString (1, nomeCurso);
			ps.setString (2, nomeDisciplina);
			ps.setString (3, status);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idCursoDisciplina1 = rs.getInt ("id_curso_disciplina");
				String nomeCurso1 = rs.getString ("curso");
				String nomeDisciplina1 = rs.getString ("disciplina");
				int idCurso = rs.getInt ("id_curso");
				int idDisciplina = rs.getInt ("id_disciplina");
				String status1 = rs.getString ("status");
				cursoDisciplina = new CursoDisciplina (idCursoDisciplina1, nomeCurso1, nomeDisciplina1, idCurso, idDisciplina, status1);
			}
				return cursoDisciplina;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos() throws Exception {
		List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso_disciplina");
			rs = ps.executeQuery();
			while (rs.next()) {
				int idCursoDisciplina1 = rs.getInt ("id_curso_disciplina");
				String nomeCurso = rs.getString ("curso");
				String nomeDisciplina = rs.getString ("disciplina");
				int idCurso = rs.getInt ("id_curso");
				int idDisciplina = rs.getInt ("id_disciplina");
				String status = rs.getString ("status");
				cursoDisciplina = new CursoDisciplina (idCursoDisciplina1, nomeCurso, nomeDisciplina, idCurso, idDisciplina, status);
				lista.add(cursoDisciplina);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos1(int idCursoDisciplina) throws Exception {
		List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso_disciplina "
					+ " WHERE id_curso_disciplina=?");
			ps.setInt (1, idCursoDisciplina);
			rs = ps.executeQuery();
			while (rs.next()) {
				int idCursoDisciplina1 = rs.getInt ("id_curso_disciplina");
				String nomeCurso = rs.getString ("curso");
				String nomeDisciplina = rs.getString ("disciplina");
				int idCurso = rs.getInt ("id_curso");
				int idDisciplina = rs.getInt ("id_disciplina");
				String status = rs.getString ("status");
				cursoDisciplina = new CursoDisciplina (idCursoDisciplina1, nomeCurso, nomeDisciplina, idCurso, idDisciplina, status);
				lista.add(cursoDisciplina);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos2() throws Exception {
		List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso_disciplina GROUP BY curso");
			rs = ps.executeQuery();
			while (rs.next()) {
				String nomeCurso = rs.getString ("curso");
				cursoDisciplina = new CursoDisciplina (nomeCurso);
				lista.add(cursoDisciplina);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos3(String nomeCurso, String status) throws Exception {
		List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso_disciplina WHERE curso LIKE ? AND status LIKE ?");
			ps.setString (1, nomeCurso);
			ps.setString (2, status);
			rs = ps.executeQuery();
			while (rs.next()) {
				String nomeDisciplina = rs.getString ("disciplina");
				cursoDisciplina = new CursoDisciplina (nomeDisciplina);
				lista.add(cursoDisciplina);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
}
