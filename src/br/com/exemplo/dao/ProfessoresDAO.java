package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.exemplo.model.Professores;
import br.com.exemplo.until.ConnectionFactory;
import br.com.exemplo.view.Tela_DadosAulas;
import br.com.exemplo.view.Tela_InicialProfessor;

public class ProfessoresDAO {
	private Professores professores;
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ProfessoresDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception erro) {
			throw new Exception ("Erro: " + erro.getMessage());
		}
	}
	public void Salvar (Professores professores) throws Exception {
		try {
			String sql = "INSERT INTO professores (cod_professor, nome, senha, email, celular, status ) "
					+ " values (?, ?, ?, ?, ?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setInt (1, professores.getCodProfessor());
			ps.setString (2, professores.getNome());
			ps.setString (3, professores.getSenha());
			ps.setString (4, professores.getEmail());
			ps.setString (5, professores.getCelular());
			ps.setString (6, professores.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Alterar (Professores professores) throws Exception {
		try { 
			String sql = "UPDATE professores SET cod_professor=?, nome=?, senha=?, email=?, celular=?, status=? "
					+ " WHERE id_professor=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt (1, professores.getCodProfessor());
			ps.setString (2, professores.getNome());
			ps.setString (3, professores.getSenha());
			ps.setString (4, professores.getEmail());
			ps.setString (5, professores.getCelular());
			ps.setString (6, professores.getStatus());
			ps.setInt (7, professores.getIdProfessor());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Excluir (int idProfessor) throws Exception {
		try {
			String sql = "DELETE FROM professores WHERE id_professor=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt (1, idProfessor);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public Professores Consultar (int codProfessor) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM professores "
					+ " WHERE cod_professor=?"); 
			ps.setInt (1, codProfessor);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idProfessor = rs.getInt ("id_professor");
				int codProfessor1 = rs.getInt ("cod_professor");
				String nome = rs.getString ("nome");
				String senha = rs.getString ("senha");
				String email = rs.getString ("email");
				String celular = rs.getString ("celular");
				String status = rs.getString ("status");
				professores = new Professores (idProfessor, codProfessor1, nome, senha, email, celular, status);
			}
				return professores;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public Professores Consultar2 (String nomeProfessor) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM professores "
					+ " WHERE nome=?"); 
			ps.setString (1, nomeProfessor);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idProfessor = rs.getInt ("id_professor");
				int codProfessor1 = rs.getInt ("cod_professor");
				String nome = rs.getString ("nome");
				String senha = rs.getString ("senha");
				String email = rs.getString ("email");
				String celular = rs.getString ("celular");
				String status = rs.getString ("status");
				professores = new Professores (idProfessor, codProfessor1, nome, senha, email, celular, status);
			}
				return professores;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos() throws Exception {
		List<Professores> lista = new ArrayList<Professores>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM professores");
			rs = ps.executeQuery();
			while (rs.next()) {
				int idProfessor = rs.getInt ("id_professor");
				int codProfessor = rs.getInt ("cod_professor");
				String nome = rs.getString ("nome");
				String senha = rs.getString ("senha");
				String email = rs.getString ("email");
				String celular = rs.getString ("celular");
				String status = rs.getString ("status");
				professores = new Professores (idProfessor, codProfessor, nome, senha, email, celular, status);
				lista.add(professores);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos1(int codProfessor) throws Exception {
		List<Professores> lista = new ArrayList<Professores>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM professores "
					+ " WHERE cod_professor=?");
			ps.setInt (1, codProfessor);
			rs = ps.executeQuery();
			while (rs.next()) {
				int idProfessor = rs.getInt ("id_professor");
				int codProfessor1 = rs.getInt ("cod_professor");
				String nome = rs.getString ("nome");
				String senha = rs.getString ("senha");
				String email = rs.getString ("email");
				String celular = rs.getString ("celular");
				String status = rs.getString ("status");
				professores = new Professores (idProfessor, codProfessor1, nome, senha, email, celular, status);
				lista.add(professores);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos2(String status) throws Exception {
		List<Professores> lista = new ArrayList<Professores>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM professores "
					+ " WHERE status=?");
			ps.setString (1, status);
			rs = ps.executeQuery();
			while (rs.next()) {
				int idProfessor = rs.getInt ("id_professor");
				int codProfessor1 = rs.getInt ("cod_professor");
				String nome = rs.getString ("nome");
				String senha = rs.getString ("senha");
				String email = rs.getString ("email");
				String celular = rs.getString ("celular");
				String status1 = rs.getString ("status");
				professores = new Professores (idProfessor, codProfessor1, nome, senha, email, celular, status1);
				lista.add(professores);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos3(String nomeProfessor) throws Exception {
		List<Professores> lista = new ArrayList<Professores>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM professores "
					+ " WHERE nome=?");
			ps.setString (1, nomeProfessor);
			rs = ps.executeQuery();
			while (rs.next()) {
				int idProfessor = rs.getInt ("id_professor");
				int codProfessor1 = rs.getInt ("cod_professor");
				String nome = rs.getString ("nome");
				String senha = rs.getString ("senha");
				String email = rs.getString ("email");
				String celular = rs.getString ("celular");
				String status1 = rs.getString ("status");
				professores = new Professores (idProfessor, codProfessor1, nome, senha, email, celular, status1);
				lista.add(professores);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos4(String status) throws Exception {
		List<Professores> lista = new ArrayList<Professores>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM professores "
					+ " WHERE status=?");
			ps.setString (1, status);
			rs = ps.executeQuery();
			while (rs.next()) {
				int idProfessor = rs.getInt ("id_professor");
				int codProfessor1 = rs.getInt ("cod_professor");
				String nome = rs.getString ("nome");
				String senha = rs.getString ("senha");
				String email = rs.getString ("email");
				String celular = rs.getString ("celular");
				String status1 = rs.getString ("status");
				professores = new Professores (idProfessor, codProfessor1, nome, senha, email, celular, status1);
				lista.add(professores);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void AtivarDesativar (Professores professores) throws Exception {
		try { 
			String sql = "UPDATE professores SET status=? "
					+ " WHERE id_professor=? ";
			ps = conn.prepareStatement(sql);
			ps.setString (1, professores.getStatus());
			ps.setInt (2, professores.getIdProfessor());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public Professores Login (int codProfessor, String senha, String status) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM professores "
					+ " WHERE cod_professor=? AND senha=? AND status=?"); 
			ps.setInt (1, codProfessor);
			ps.setString (2, senha);
			ps.setString (3, status);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idProfessor = rs.getInt ("id_professor");
				int codProfessor1 = rs.getInt ("cod_professor");
				String senha1 = rs.getString ("senha");
				String nome = rs.getString ("nome");
				professores = new Professores (idProfessor, codProfessor1, senha1, nome);
			}
				return professores;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodosOB() throws Exception {
		List<Professores> lista = new ArrayList<Professores>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM professores ORDER BY nome");
			rs = ps.executeQuery();
			while (rs.next()) {
				int idProfessor = rs.getInt ("id_professor");
				int codProfessor = rs.getInt ("cod_professor");
				String nome = rs.getString ("nome");
				String senha = rs.getString ("senha");
				String email = rs.getString ("email");
				String celular = rs.getString ("celular");
				String status = rs.getString ("status");
				professores = new Professores (idProfessor, codProfessor, nome, senha, email, celular, status);
				lista.add(professores);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
}
