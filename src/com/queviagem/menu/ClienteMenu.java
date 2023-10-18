package com.queviagem.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.queviagem.dao.ClienteDAO;
import com.queviagem.database.ConexaoDatabase;
import com.queviagem.model.Cliente;

public class ClienteMenu {
	
	static Connection connection = ConexaoDatabase.createConnection();
	static ClienteDAO clienteDAO = new ClienteDAO(connection);
	
	public static int SubMenuCliente(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("- Você está no MENU CLIENTE. Digite a opcao desejada: - \n "
					+ "|1-Cadastrar Cliente                       |\n"
					+ " |2-Listar Cliente                          |\n"
					+ " |3-Atualizar Cliente                       |\n"
					+ " |4-Deletar Cliente                         |\n"
					+ " |0-Sair                                    | \n");
			
			option = scanner.nextInt(); 
			
		switch (option) {
			case 1:
				Cliente cliente = new Cliente ();
				scanner.nextLine ();
				System.out.println("Nome Completo: ");
				cliente.setNome(scanner.nextLine());
				System.out.println("CPF: ");
				cliente.setCpf(scanner.nextLine ().trim ());
				System.out.println("Email: ");
				cliente.setEmail(scanner.nextLine());
				System.out.println("Senha: ");
				cliente.setSenha(scanner.next().trim ());
				
				clienteDAO.createClient(cliente);
				
				break;
			case 2:
				clienteDAO.readAllClients();
				break;
			case 3:
				Cliente clienteAtualizado = new Cliente();
				System.out.println("Digite o ID do cliente a ser atualizado: ");
				clienteAtualizado.setId(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Nome Completo: ");
				clienteAtualizado.setNome(scanner.nextLine());
				System.out.println("CPF: ");
				clienteAtualizado.setCpf(scanner.nextLine().trim());
				System.out.println("Email: ");
				clienteAtualizado.setEmail(scanner.nextLine());
				System.out.println("Senha: ");
				clienteAtualizado.setSenha(scanner.nextLine ());
			
				clienteDAO.updateClient(clienteAtualizado);
				
				break;
			case 4:
				System.out.println("Digite o ID do Cliente a ser DELETADO");
				int idCliente = scanner.nextInt();
				clienteDAO.deleteClient(idCliente);
			
				break;
			case 0:
                System.out.println("Saindo...");
                break;
                
			default:
				
				System.out.println("ATENÇÃO: Digite uma opção valida");
		}

			} while (option != 0);
		
		return option;

	
}
}
