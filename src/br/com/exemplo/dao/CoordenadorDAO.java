package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.model.Coordenador;
import br.com.exemplo.model.Professores;
import br.com.exemplo.until.ConnectionFactory;

public class CoordenadorDAO {
	private Coordenador coordenador;
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;
	
	public CoordenadorDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception erro) {
			throw new Exception ("Erro: " + erro.getMessage());
		}
	}
	public void Salvar (Coordenador coordenador) throws Exception {
		try {
			String sql = "INSERT INTO coordenador (cod_coordenador, nome, senha, email, celular, status ) "
					+ " values (?, ?, ?, ?, ?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setInt (1, coordenador.getCodCoordenador());
			ps.setString (2, coordenador.getNome());
			ps.setString (3, coordenador.getSenha());
			ps.setString (4, coordenador.getEmail());
			ps.setString (5, coordenador.getCelular());
			ps.setString (6, coordenador.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Alterar (Coordenador coordenador) throws Exception {
		try { 
			String sql = "UPDATE atestado SET cod_coordenador=?, nome=?, senha=?, email=?, celular=?, status=? "
					+ " WHERE id_coordenador=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt (1, coordenador.getCodCoordenador());
			ps.setString (2, coordenador.getNome());
			ps.setString (3, coordenador.getSenha());
			ps.setString (4, coordenador.getEmail());
			ps.setString (5, coordenador.getCelular());
			ps.setString (6, coordenador.getStatus());
			ps.setInt (7, coordenador.getIdCoordenador());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Excluir (int idCoordenador) throws Exception {
		try {
			String sql = "DELETE FROM coordenador WHERE id_coordenador=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt (1, idCoordenador);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public Coordenador Consultar (int codCoordenador) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM coordenador "
					+ " WHERE cod_coordenador=?"); 
			ps.setInt (1, codCoordenador);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idCoordenador = rs.getInt ("id_coordenador");
				int codCoordenador1 = rs.getInt ("cod_coordenador");
				String nome = rs.getString ("nome");
				String senha = rs.getString ("senha");
				String email = rs.getString ("email");
				String celular = rs.getString ("celular");
				String status = rs.getString ("status");
				coordenador = new Coordenador (idCoordenador, codCoordenador1, nome, senha, email, celular, status);
			}
				return coordenador;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos() throws Exception {
		List<Coordenador> lista = new ArrayList<Coordenador>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM coordenador");
			rs = ps.executeQuery();
			while (rs.next()) {
				int idCoordenador = rs.getInt ("id_coordenador");
				int codCoordenador = rs.getInt ("cod_coordenador");
				String nome = rs.getString ("nome");
				String senha = rs.getString ("senha");
				String email = rs.getString ("email");
				String celular = rs.getString ("celular");
				String status = rs.getString ("status");
				coordenador = new Coordenador (idCoordenador, codCoordenador, nome, senha, email, celular, status);
				lista.add(coordenador);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List ListarTodos1(int codCoordenador) throws Exception {
		List<Coordenador> lista = new ArrayList<Coordenador>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM coordenador "
					+ " WHERE cod_coordenador=?");
			ps.setInt (1, codCoordenador);
			rs = ps.executeQuery();
			while (rs.next()) {
				int idCoordenador = rs.getInt ("id_coordenador");
				int codCoordenador1 = rs.getInt ("cod_coordenador");
				String nome = rs.getString ("nome");
				String senha = rs.getString ("senha");
				String email = rs.getString ("email");
				String celular = rs.getString ("celular");
				String status = rs.getString ("status");
				coordenador = new Coordenador (idCoordenador, codCoordenador1, nome, senha, email, celular, status);
				lista.add(coordenador);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Desativar (Coordenador coordenador) throws Exception {
		try { 
			String sql = "UPDATE atestado SET status=? "
					+ " WHERE id_coordenador=? ";
			ps = conn.prepareStatement(sql);
			ps.setString (1, coordenador.getStatus());
			ps.setInt (2, coordenador.getIdCoordenador());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public Coordenador Login (int codCoordenador, String senha) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM coordenador "
					+ " WHERE cod_coordenador=? AND senha=?"); 
			ps.setInt (1, codCoordenador);
			ps.setString (2, senha);
			rs= ps.executeQuery();
			if(rs.next()) {
				int idCoordenador = rs.getInt ("id_coordenador");
				int codCoordenador1 = rs.getInt ("cod_coordenador");
				String senha1 = rs.getString ("senha");
				String nome = rs.getString ("nome");
				coordenador = new Coordenador (idCoordenador, codCoordenador1, senha1, nome);
			}
				return coordenador;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
}
