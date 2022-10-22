package crud;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;
	import agencia.Cliente;
	import dao.ClienteDAO;

	public class ClienteCRUD{

		public static void main(String[] args) {

			// Cria instancia do DAO para utilizar os métodos
			ClienteDAO clienteDAO = new ClienteDAO();

			Scanner input = new Scanner(System.in);

			// Setar as variáveis de navegação
			int opcao = 0;
			int posicao = 0;
			int id_cliente = 0;
			String nome_cliente = "";
			String email_cliente = "";
			String senha_cliente = "";
			String cpf_cliente = "";
	
			// Instancia da lista que vai armazenar

			List<Cliente> cliente = new ArrayList<Cliente>();

			// MENU
			do {
				System.out.println("--- CRUD CLIENTE ---");
				System.out.println("1 - Cadastro Cliente");
				System.out.println("2 - Consulta de Cliente");
				System.out.println("3 - Delete de Cliente");
				System.out.println("4 - Atualizar de Cliente");
				System.out.println("0 - Sair");

				opcao = input.nextInt();
				input.nextLine();		

				// NAVEGAÇÃO DO CRUD
				switch (opcao) {
				case 1:
					// CREATE
					System.out.println("**Cadastrar Cliente**");
					
					System.out.println("Digite o nome: ");
					nome_cliente = input.nextLine();
					
					System.out.println("Digite o cpf : ");
					cpf_cliente = input.nextLine();
			
					System.out.println("Digite a email : ");
					email_cliente = input.nextLine();
		
					System.out.println("Digite a senha : ");
					senha_cliente = input.nextLine();
		
					Cliente CLIENTE = new Cliente();

					CLIENTE.setNome_cliente(nome_cliente);
					CLIENTE.setEmail_cliente(email_cliente);
					CLIENTE.setCpf_cliente(cpf_cliente);
					CLIENTE.setSenha_cliente(senha_cliente);
		

					clienteDAO.save(CLIENTE);

					System.out.println("\n***Cadastrado**\n");
					break;

				case 2:
	         		//Lista com todos os clientes do banco
					
					List<Cliente> clientes = clienteDAO.getClientes();
					
					for(Cliente c : clientes ){
						
					 System.out.println("Id: " + c.getId_cliente() + " Nome: " + c.getNome_cliente()
	                    +  "Cpf: " + c.getCpf_cliente() +"Email: " + c.getEmail_cliente() +"Senha: "  
	                    +"\n");
	                }
	          						
    						
					System.out.println("*Consulta Finalizada*");
					break;
					
				
				case 3:
					// DELETE
					
					System.out.println("Passe o ID para exclusão: ");
					posicao = input.nextInt();

					// Remove o escola por ID
					
					clienteDAO.removeById(posicao);
					System.out.println("*Escola excluída*");
					break;
					
				
				case 4:
					// UPDATE
					System.out.println("Digite o id do cliente: ");
					id_cliente = input.nextInt();
					
					System.out.println("Digite o novo nome do cliente: ");
					nome_cliente = input.nextLine();
					
					System.out.println("Digite o cpf do cliente: ");
					cpf_cliente = input.nextLine();
					
					System.out.println("Digite o novo email do cliente: ");
					email_cliente = input.nextLine();
					
					System.out.println("Digite a nova senha: ");
					senha_cliente = input.nextLine();
						
					Cliente clientenew = new Cliente();
					ClienteDAO.update(clientenew);
					break;
				default:
					System.out.println(opcao != 0 ? "\n Opção é inválida, " + "tente novamente.\n" : "");
					break;
				}
			} while (opcao != 0);
			input.close();
			System.out.println("*Finalizado*");

		}
	}


