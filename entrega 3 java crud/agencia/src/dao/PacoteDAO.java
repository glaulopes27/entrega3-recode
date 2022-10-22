package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Connection.ConnectionMySQL;
import agencia.Pacote;

public class PacoteDAO {

	// create
	public void save(Pacote pacote) {

		// cria a query são os parâmetros que nós vamos adicionar
		// na base de dados

		String sql = "INSERT INTO pacote ( id_pacote, nome_pacote, valor_pacote) VALUES (?,?,?)";

		// faz conexao
		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			// criar um conexão com um banco de dados

			conn = ConnectionMySQL.createConnectionMySQL();

			// criamos uma (prepareStatement) , para execurta uma query

			pstm = conn.prepareStatement(sql);

			// adiciona os valores que são esperado pela query
			// Adiciona o valor do primeiro parâmetro da sql

			pstm.setInt(1, pacote.getId_pacote());
			pstm.setString(2, pacote.getNome_pacote());
			pstm.setDouble(3, pacote.getValor_pacote());

			// executar a query//Executa a sql para inserção dos dados
			pstm.execute();

			System.out.println("pacote salvo com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// fecha conexões

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// read
	public List<Pacote> getPacote() {

		// cria a query
		String sql = "SELECT * FROM pacote ";

		// faz a lista que recebe
		List<Pacote> pacotes = new ArrayList<Pacote>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// classe que vai recupera os dados do banco. ***SELECT***
		ResultSet rset = null;
		try {
			// executa a conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();
			// executa a query
			pstm = conn.prepareStatement(sql);
			// captura o que foi executado no pstm
			rset = pstm.executeQuery();

			while (rset.next()) {

				Pacote pacote = new Pacote();

				// recupera id
				pacote.setId_pacote(rset.getInt("id_cliente"));

				// recupera o nome do pacote
				pacote.setNome_pacote(rset.getString("nome_pacote"));

				// recupera o valor
				pacote.setValor_pacote(rset.getDouble("valor_pacote"));

				pacotes.add(pacote);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return pacotes;
	}

	// update

	public void update1(Pacote pacote) {

		String sql1 = "UPDATE pacote SET nome_pacote = ? WHERE id_pacote= ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql1);

			// adiciona o valor nos parametros

			pstm.setInt(1, pacote.getId_pacote());
			pstm.setString(2, pacote.getNome_pacote());
			pstm.setDouble(3, pacote.getValor_pacote());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// DELETE
	public void removeById(int id_pacote) {

		String sql1 = "DELETE FROM pacotes WHERE id_pacote = ?";

		Connection conn1 = null;
		PreparedStatement pstm1 = null;

		try {
			conn1 = ConnectionMySQL.createConnectionMySQL();

			pstm1 = (PreparedStatement) conn1.prepareStatement(sql1);

			pstm1.setInt(1, id_pacote);

			pstm1.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm1 != null) {
					pstm1.close();
				}
				if (conn1 != null) {
					conn1.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
