package com.queviagem.menu;

import java.sql.Connection;
import java.util.Scanner;


import com.queviagem.dao.DestinoDAO;
import com.queviagem.database.ConexaoDatabase;
import com.queviagem.model.Destino;

public class DestinoMenu {
	
	static Connection connection = ConexaoDatabase.createConnection();
	static DestinoDAO destinoDAO = new DestinoDAO (connection);
	
	public static int SubMenuDestino(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("- Você está no MENU DESTINO. Selecione a opcao desejada: - \n "
					+ "|1-Cadastrar Destino|\n"
					+ " |2-Listar Destinos  |\n"
					+ " |3-Atualizar Destino|\n"
					+ " |4-Deletar Destino  |\n"
					+ " |0-Sair             | \n");
			
			option = scanner.nextInt();

	 switch (option) {
		case 1:
			Destino destino = new Destino ();
			scanner.nextLine ();
			System.out.println(" * País: ");
			destino.setPais(scanner.nextLine());
			System.out.println(" * Cidade: ");
			destino.setCidade(scanner.nextLine ().trim ());
			System.out.println(" * Valor: ");
			destino.setValor(scanner.nextDouble());
			System.out.println(" * Promocao:  Digite True para Sim ou False para NÃO");
			destino.setPromocao(scanner.nextBoolean());
			
			destinoDAO.createDestino(destino);
			
			break;
		case 2:
			destinoDAO.readAllDestino();
			break;
		case 3:
			Destino destinoAtualizado = new Destino();
			System.out.println("Digite o ID do destino a ser atualizado: ");
			destinoAtualizado.setId(scanner.nextInt());
			scanner.nextLine();
			System.out.println("País: ");
			destinoAtualizado.setPais(scanner.nextLine());
			System.out.println("Cidade: ");
			destinoAtualizado.setCidade(scanner.nextLine().trim());
			System.out.println("Valor: ");
			destinoAtualizado.setValor(scanner.nextDouble());
			System.out.println("Promocao: ");
			destinoAtualizado.setPromocao(scanner.nextBoolean ());
		
			destinoDAO.updateDestino(destinoAtualizado);
			
			break;
		case 4:
			System.out.println("Digite o ID do destino a ser DELETADO");
 
			int idDestino = scanner.nextInt();
			destinoDAO.deleteDestino(idDestino);
		
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
