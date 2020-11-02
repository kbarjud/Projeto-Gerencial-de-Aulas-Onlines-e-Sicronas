package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.exemplo.model.Coordenador;
import br.com.exemplo.model.Curso;
import br.com.exemplo.model.DadosAula;
import br.com.exemplo.model.Professores;
import br.com.exemplo.until.ConnectionFactory;

public class CursoDAO {
	private Curso curso;
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;
	
	public CursoDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception erro) {
			throw new Exception ("Erro: " + erro.getMessage());
		}
	}
	public void Salvar (Curso curso) throws Exception {
		try {
			String sql = "INSERT INTO curso (curso, disciplina ) "
					+ " values (?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setString (1, curso.getNomeCurso());
			ps.setString (2, curso.getDisciplina());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Alterar (Curso curso) throws Exception {
		try { 
			String sql = "UPDATE curso SET curso=?, disciplina=? "
					+ " WHERE id_curso_disciplina=? ";
			ps = conn.prepareStatement(sql);
			ps.setString (1, curso.getNomeCurso());
			ps.setString (2, curso.getDisciplina());
			ps.setInt (3, curso.getIdCursoDisciplina());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Excluir (int idCursoDisciplina) throws Exception {
		try {
			String sql = "DELETE FROM curso WHERE id_curso_disciplina=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt (1, idCursoDisciplina);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public Curso Consultar (int idCursoDisciplina) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso "
					+ " WHERE id_curso_disciplina=?"); 
			ps.setInt (1, idCursoDisciplina);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idCursoDisciplina1 = rs.getInt ("id_curso_disciplina");
				String curso1 = rs.getString ("curso");
				String disciplina = rs.getString ("disciplina");
				curso = new Curso (idCursoDisciplina1, curso1, disciplina);
			}
				return curso;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public Curso Consultar1 (String nomeCurso, String disciplina) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso "
					+ " WHERE curso=? AND disciplina=? "); 
			ps.setString (1, nomeCurso);
			ps.setString (2, disciplina);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idCursoDisciplina = rs.getInt ("id_curso_disciplina");
				String curso1 = rs.getString ("curso");
				String disciplina1 = rs.getString ("disciplina");
				curso = new Curso (idCursoDisciplina, curso1, disciplina1);
			}
				return curso;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos() throws Exception {
		List<Curso> lista = new ArrayList<Curso>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso");
			rs = ps.executeQuery();
			while (rs.next()) {
				int idCursoDisciplina = rs.getInt ("id_curso_disciplina");
				String curso1 = rs.getString ("curso");
				String disciplina = rs.getString ("disciplina");
				curso = new Curso (idCursoDisciplina, curso1, disciplina);
				lista.add(curso);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos1(int idCursoDisciplina) throws Exception {
		List<Curso> lista = new ArrayList<Curso>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso "
					+ " WHERE id_curso_disciplina=?");
			ps.setInt (1, idCursoDisciplina);
			rs = ps.executeQuery();
			while (rs.next()) {
				int idCursoDisciplina1 = rs.getInt ("id_curso_disciplina");
				String curso1 = rs.getString ("curso");
				String disciplina = rs.getString ("disciplina");
				curso = new Curso (idCursoDisciplina1, curso1, disciplina);
				lista.add(curso);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos2() throws Exception {
		List<Curso> lista = new ArrayList<Curso>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso GROUP BY curso");
			rs = ps.executeQuery();
			while (rs.next()) {
				String nomeCurso = rs.getString ("curso");
				curso = new Curso (nomeCurso);
				lista.add(curso);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos3(String nomeCurso) throws Exception {
		List<Curso> lista = new ArrayList<Curso>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso WHERE curso LIKE ?");
			ps.setString (1, nomeCurso);
			rs = ps.executeQuery();
			while (rs.next()) {
				String disciplina = rs.getString ("disciplina");
				curso = new Curso (disciplina);
				lista.add(curso);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
}
