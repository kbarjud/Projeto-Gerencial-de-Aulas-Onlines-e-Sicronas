package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.model.Curso;
import br.com.exemplo.model.SemestreLetivo;
import br.com.exemplo.until.ConnectionFactory;

public class SemestreLetivoDAO {
	private SemestreLetivo semestreLetivo;
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;
	
	public SemestreLetivoDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception erro) {
			throw new Exception ("Erro: " + erro.getMessage());
		}
	}
	public void Salvar (SemestreLetivo semestreLetivo) throws Exception {
		try {
			String sql = "INSERT INTO semestre_letivo (semestre_letivo, status ) "
					+ " values (?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setString (1, semestreLetivo.getSemestre());
			ps.setString (2, semestreLetivo.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Alterar (SemestreLetivo semestreLetivo) throws Exception {
		try { 
			String sql = "UPDATE semestre_letivo SET semestre_letivo=?, status=? "
					+ " WHERE id_semestre=? ";
			ps = conn.prepareStatement(sql);
			ps.setString (1, semestreLetivo.getSemestre());
			ps.setString (2, semestreLetivo.getStatus());
			ps.setInt (3, semestreLetivo.getIdSemestre());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Excluir (int idSemestre) throws Exception {
		try {
			String sql = "DELETE FROM semestre_letivo WHERE id_semestre=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt (1, idSemestre);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public SemestreLetivo Consultar (int idSemestre) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM semestre_letivo "
					+ " WHERE id_semestre=?"); 
			ps.setInt (1, idSemestre);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idSemestre1 = rs.getInt ("id_semestre");
				String semestre = rs.getString ("semestre_letivo");
				String status = rs.getString ("status");
				semestreLetivo = new SemestreLetivo (idSemestre1, semestre, status);
			}
			else {
				int idSemestre1 = rs.getInt ("");
				String semestre = rs.getString ("");
				String status = rs.getString ("");
				semestreLetivo = new SemestreLetivo (idSemestre1, semestre, status);
			}
				return semestreLetivo;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public SemestreLetivo Consultar2 (String semestre, String status) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM semestre_letivo "
					+ " WHERE semestre_letivo=? AND status=? "); 
			ps.setString (1, semestre);
			ps.setString (2, status);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idSemestre1 = rs.getInt ("id_semestre");
				String semestre1 = rs.getString ("semestre_letivo");
				String status1 = rs.getString ("status");
				semestreLetivo = new SemestreLetivo (idSemestre1, semestre1, status1);
			}
			else {
				int idSemestre1 = 0;
				String semestre1 = "";
				String status1 = "";
				semestreLetivo = new SemestreLetivo (idSemestre1, semestre1, status1);
			}
				return semestreLetivo;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public SemestreLetivo Consultar3 () throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM semestre_letivo "); 
			rs= ps.executeQuery();
			if(rs.next()) {
				int idSemestre1 = rs.getInt ("id_semestre");
				String semestre1 = rs.getString ("semestre_letivo");
				String status1 = rs.getString ("status");
				semestreLetivo = new SemestreLetivo (idSemestre1, semestre1, status1);
			}
			else {
				int idSemestre1 = 0;
				String semestre1 = "";
				String status1 = "";
				semestreLetivo = new SemestreLetivo (idSemestre1, semestre1, status1);
			}
				return semestreLetivo;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos() throws Exception {
		List<SemestreLetivo> lista = new ArrayList<SemestreLetivo>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM semestre_letivo");
			rs = ps.executeQuery();
			while (rs.next()) {
				int idSemestre1 = rs.getInt ("id_semestre");
				String semestre = rs.getString ("semestre_letivo");
				String status = rs.getString ("status");
				semestreLetivo = new SemestreLetivo (idSemestre1, semestre, status);
				lista.add(semestreLetivo);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos2(int idSemestre) throws Exception {
		List<SemestreLetivo> lista = new ArrayList<SemestreLetivo>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM semestre_letivo "
					+ " WHERE id_semestre=?");
			ps.setInt (1, idSemestre);
			rs = ps.executeQuery();
			while (rs.next()) {
				int idSemestre1 = rs.getInt ("id_semestre");
				String semestre = rs.getString ("semestre_letivo");
				String status = rs.getString ("status");
				semestreLetivo = new SemestreLetivo (idSemestre1, semestre, status);
				lista.add(semestreLetivo);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos3() throws Exception {
		List<SemestreLetivo> lista = new ArrayList<SemestreLetivo>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM semestre_letivo GROUP BY semestre_letivo");
			rs = ps.executeQuery();
			while (rs.next()) {
				String semestre = rs.getString ("semestre_letivo");
				semestreLetivo = new SemestreLetivo (semestre);
				lista.add(semestreLetivo);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos4(String status) throws Exception {
		List<SemestreLetivo> lista = new ArrayList<SemestreLetivo>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM semestre_letivo WHERE status=? ");
			ps.setString(1, status);
			rs = ps.executeQuery();
			while (rs.next()) {
				int idSemestre1 = rs.getInt ("id_semestre");
				String semestre = rs.getString ("semestre_letivo");
				String status1 = rs.getString ("status");
				semestreLetivo = new SemestreLetivo (idSemestre1, semestre, status1);
				lista.add(semestreLetivo);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
}
