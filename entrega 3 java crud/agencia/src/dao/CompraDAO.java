package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Connection.ConnectionMySQL;
import agencia.Compra;
public class CompraDAO {

	// criar 
	public void save(Compra compra) {

		// cria a query são os parâmetros que nós vamos adicionar
		// na base de dados

		String sql = "INSERT INTO cliente (data_compra )  VALUES (?)";

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
		
			pstm.setDate(1, new Date(compra.getData_compra().getTime()));
	
			// executar a query//Executa a sql para inserção dos dados
			pstm.execute();

			System.out.println("compra salva com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// fechar as conexões

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
	public List<Compra> getCompra() {

		// cria a query
		String sql = "SELECT * FROM compra ";

		// faz a lista que recebe 
		List<Compra> compras = new ArrayList<Compra>();

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

				Compra compra = new Compra();

				// recupera id
				compra.setId_compra(rset.getInt("id_compra"));

				// recupera a data
				compra.setData_compra(rset.getDate("data_compra"));

				
				compras.add(compra);
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

		return compras;
	}

	// update

	public void update1(Compra compra) {

		String sql1 = "UPDATE cliente SET data_compra = ? WHERE id_compra= ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql1);

			// adiciona o valor nos parametros

			pstm.setInt(1, compra.getId_compra());
			pstm.setDate(2, compra.getData_compra());
			
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
	public void removeById(int id_compra) {

		String sql1 = "DELETE FROM compra WHERE id_compra = ?";

		Connection conn1 = null;
		PreparedStatement pstm1 = null;

		try {
			conn1 = ConnectionMySQL.createConnectionMySQL();

			pstm1 = (PreparedStatement) conn1.prepareStatement(sql1);

			pstm1.setInt(1, id_compra);

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

