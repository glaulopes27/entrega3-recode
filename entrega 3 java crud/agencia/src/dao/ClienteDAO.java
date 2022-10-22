package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionMySQL;
import agencia.Cliente;

public class ClienteDAO {

	// create
	public void save(Cliente cliente) {

		// cria a query são os parâmetros que nós vamos adicionar
		// na base de dados sql

		String sql = "INSERT INTO cliente (id_cliente, nome_cliente, cpf_cliente, email_cliente, senha_cliente) VALUES (?,?,?,?,?)";

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

			pstm.setString(1, cliente.getCpf_cliente());
			pstm.setString(2, cliente.getEmail_cliente());
			pstm.setString(3, cliente.getNome_cliente());
			pstm.setString(4, cliente.getSenha_cliente());
			

			// executar a query//Executa a sql para inserção dos dados
			pstm.execute();

			System.out.println("contato salvo com sucesso!");

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
	public List<Cliente> getClientes (){

		// cria a query
		String sql = "SELECT * FROM cliente";

		// faz a lista que recebe 
		List<Cliente> cliente = new ArrayList<Cliente>();
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

				Cliente clientes = new Cliente();

				// recupera id
				clientes.setId_cliente(rset.getInt("id_cliente"));

				// recupera o nome cliente
				clientes.setNome_cliente(rset.getString("nome_cliente"));

				// recupera o email
				clientes.setEmail_cliente(rset.getString("email_cliente"));

				// recupera a senha
				clientes.setSenha_cliente(rset.getString("senha_cliente"));

				// recupera cpf
				clientes.setCpf_cliente(rset.getString("cpf_cliente"));

				cliente.add(clientes);
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

		return cliente;
	}

	// update

	public void update1(Cliente cliente) {

		String sql = "UPDATE cliente SET nome_cliente = ? WHERE id_cliente= ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			// adiciona o valor nos parametros

			pstm.setString(1, cliente.getCpf_cliente());
			pstm.setString(2, cliente.getEmail_cliente());
			pstm.setInt(3, cliente.getId_cliente());
			pstm.setString(4, cliente.getNome_cliente());
			pstm.setString(5, cliente.getSenha_cliente());

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
	public void removeById(int id_cliente) {

		String sql = "DELETE FROM cliente WHERE id_cliente = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_cliente);

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

	public static Cliente[] getCLIENTE() {
		// TODO Stub de método gerado automaticamente
		return null;
	}



	public static void update(Cliente clientenew) {
		// TODO Stub de método gerado automaticamente
		
	}


	}
