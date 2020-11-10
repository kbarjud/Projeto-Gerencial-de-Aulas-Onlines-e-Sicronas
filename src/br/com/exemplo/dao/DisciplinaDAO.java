package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.model.Disciplina;
import br.com.exemplo.until.ConnectionFactory;

public class DisciplinaDAO {
	private Disciplina disciplina;
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;
	
	public DisciplinaDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception erro) {
			throw new Exception ("Erro: " + erro.getMessage());
		}
	}
	public void Salvar (Disciplina disciplina) throws Exception {
		try {
			String sql = "INSERT INTO disciplina (disciplina, status ) "
					+ " values (?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setString (1, disciplina.getNomeDisciplina());
			ps.setString (2, disciplina.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Alterar (Disciplina disciplina) throws Exception {
		try { 
			String sql = "UPDATE disciplina SET disciplina=?, status=? "
					+ " WHERE id_disciplina=? ";
			ps = conn.prepareStatement(sql);
			ps.setString (1, disciplina.getNomeDisciplina());
			ps.setString (2, disciplina.getStatus());
			ps.setInt (3, disciplina.getIdDisciplina());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Excluir (int idDisciplina) throws Exception {
		try {
			String sql = "DELETE FROM disciplina WHERE id_disciplina=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt (1, idDisciplina);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public Disciplina Consultar (int idDisciplina) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM disciplina "
					+ " WHERE disciplina=?"); 
			ps.setInt (1, idDisciplina);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idDisciplina1 = rs.getInt ("id_disciplina");
				String nomeDisciplina = rs.getString ("disciplina");
				String status = rs.getString ("status");
				disciplina = new Disciplina (idDisciplina1, nomeDisciplina, status);
			}
				return disciplina;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public Disciplina Consultar2 (String nomeDisciplina, String status) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM disciplina "
					+ " WHERE disciplina=? AND status=?"); 
			ps.setString (1, nomeDisciplina);
			ps.setString (2, status);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idDisciplina1 = rs.getInt ("id_disciplina");
				String nomeDisciplina1 = rs.getString ("disciplina");
				String status1 = rs.getString ("status");
				disciplina = new Disciplina (idDisciplina1, nomeDisciplina1, status1);
			}
			else {
				int idDisciplina1 = 0;
				String nomeDisciplina1 = "";
				String status1 = "";
				disciplina = new Disciplina (idDisciplina1, nomeDisciplina1, status1);
			}
				return disciplina;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public Disciplina Consultar1 (String nomeDisciplina, String status) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM disciplina "
					+ " WHERE disciplina=? AND status=? "); 
			ps.setString (1, nomeDisciplina);
			ps.setString (2, status);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idDisciplina = rs.getInt ("id_disciplina");
				String nomeDisciplina1 = rs.getString ("disciplina");
				String status1 = rs.getString ("status");
				disciplina = new Disciplina (idDisciplina, nomeDisciplina1, status1);
			}
				return disciplina;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos() throws Exception {
		List<Disciplina> lista = new ArrayList<Disciplina>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM disciplina");
			rs = ps.executeQuery();
			while (rs.next()) {
				int idDisciplina = rs.getInt ("id_disciplina");
				String nomeDisciplina1 = rs.getString ("disciplina");
				String status = rs.getString ("status");
				disciplina = new Disciplina (idDisciplina, nomeDisciplina1, status);
				lista.add(disciplina);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos1(int idDisciplina) throws Exception {
		List<Disciplina> lista = new ArrayList<Disciplina>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM disciplina "
					+ " WHERE id_disciplina=?");
			ps.setInt (1, idDisciplina);
			rs = ps.executeQuery();
			while (rs.next()) {
				int idDisciplina1 = rs.getInt ("id_disciplina");
				String nomeDisciplina1 = rs.getString ("disciplina");
				String status = rs.getString ("status");
				disciplina = new Disciplina (idDisciplina1, nomeDisciplina1, status);
				lista.add(disciplina);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos2() throws Exception {
		List<Disciplina> lista = new ArrayList<Disciplina>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM disciplina GROUP BY disciplina");
			rs = ps.executeQuery();
			while (rs.next()) {
				String nomeDisciplina = rs.getString ("disciplina");
				disciplina = new Disciplina (nomeDisciplina);
				lista.add(disciplina);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
}
