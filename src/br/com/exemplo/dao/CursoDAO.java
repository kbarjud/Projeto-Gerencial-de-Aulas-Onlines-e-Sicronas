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
			String sql = "INSERT INTO curso (curso, status ) "
					+ " values (?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setString (1, curso.getNomeCurso());
			ps.setString (2, curso.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Alterar (Curso curso) throws Exception {
		try { 
			String sql = "UPDATE curso SET curso=?, status=? "
					+ " WHERE id_curso=? ";
			ps = conn.prepareStatement(sql);
			ps.setString (1, curso.getNomeCurso());
			ps.setString (2, curso.getStatus());
			ps.setInt (3, curso.getIdCurso());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Excluir (int idCurso) throws Exception {
		try {
			String sql = "DELETE FROM curso WHERE id_curso=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt (1, idCurso);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public Curso Consultar (int idCurso) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso "
					+ " WHERE id_curso=?"); 
			ps.setInt (1, idCurso);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idCurso1 = rs.getInt ("id_curso");
				String curso1 = rs.getString ("curso");
				String status = rs.getString ("status");
				curso = new Curso (idCurso1, curso1, status);
			}
				return curso;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public Curso Consultar1 (String nomeCurso, String status) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso "
					+ " WHERE curso=? AND status=? "); 
			ps.setString (1, nomeCurso);
			ps.setString (2, status);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idCurso = rs.getInt ("id_curso");
				String curso1 = rs.getString ("curso");
				String status1 = rs.getString ("status");
				curso = new Curso (idCurso, curso1, status1);
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
				int idCurso = rs.getInt ("id_curso");
				String curso1 = rs.getString ("curso");
				String status = rs.getString ("status");
				curso = new Curso (idCurso, curso1, status);
				lista.add(curso);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos1(int idCurso) throws Exception {
		List<Curso> lista = new ArrayList<Curso>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso "
					+ " WHERE id_curso=?");
			ps.setInt (1, idCurso);
			rs = ps.executeQuery();
			while (rs.next()) {
				int idCurso1 = rs.getInt ("id_curso");
				String curso1 = rs.getString ("curso");
				String status = rs.getString ("status");
				curso = new Curso (idCurso, curso1, status);
				lista.add(curso);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos2(String status) throws Exception {
		List<Curso> lista = new ArrayList<Curso>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM curso WHERE status LIKE ? GROUP BY curso");
			ps.setString (1, status);
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
}
