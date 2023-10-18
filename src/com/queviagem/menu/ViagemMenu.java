package com.queviagem.menu;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.queviagem.dao.ViagemDAO;
import com.queviagem.database.ConexaoDatabase;
import com.queviagem.model.Cliente;
import com.queviagem.model.Destino;
import com.queviagem.model.Viagem;

public class ViagemMenu {

	static Connection connection = ConexaoDatabase.createConnection();
	static ViagemDAO viagemDAO = new ViagemDAO(connection);

	public static int SubMenuViagem(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		do {
			System.out.println("- Você está no MENU VIAGEM. Selecione a opcao desejada: - \n "
					+ "|1-Cadastrar Viagem         D|\n"
					+ " |2-Listar Viagem            |\n"
					+ " |3-Atualizar Viagem         |\n"
					+ " |4-Deletar Viagem           |\n"
					+ " |0-Sair                     | \n");

			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Viagem viagem = new Viagem();
				System.out.print("Infome a data de ida da viagem com dd/MM/yyyy HH:mm:ss");
				String dataIda = scanner.nextLine();
				viagem.setDataIda(LocalDateTime.parse(dataIda, formatter));
				System.out.print("Infome a data de volta da viagem com dd/MM/yyyy HH:mm:ss");
				String dataVolta = scanner.nextLine();
				viagem.setDataVolta(LocalDateTime.parse(dataVolta, formatter));
				System.out.print("Digite o ID do Cliente: ");
				Cliente clienteViagem = new Cliente();
				clienteViagem.setId(scanner.nextInt());
				viagem.setIdCliente(clienteViagem);
				System.out.print("Digite o ID do Destino: ");
				Destino destinoViagem = new Destino();
				destinoViagem.setId(scanner.nextInt());
				viagem.setIdDestino(destinoViagem);

				viagemDAO.createViagem(viagem);
				break;
			case 2:
				viagemDAO.readAllViagem();
				break;
			case 3:
				Viagem viagemAtualizada = new Viagem();
				System.out.println("Digite o ID da Viagem a ser ATUALIZADA ");
				viagemAtualizada.setId(scanner.nextInt());
				scanner.nextLine();
				System.out.print("Infome a data de ida da viagem com dd/MM/yyyy HH:mm:ss");
				String dataIdaAtualizada = scanner.nextLine();
				viagemAtualizada.setDataIda(LocalDateTime.parse(dataIdaAtualizada, formatter));
				System.out.print("Infome a data de volta da viagem com dd/MM/yyyy HH:mm:ss");
				String dataVoltaAtualizada = scanner.nextLine();
				viagemAtualizada.setDataVolta(LocalDateTime.parse(dataVoltaAtualizada, formatter));
				System.out.print("Digite o ID do Cliente : ");
				Cliente clienteViagemAtualizado = new Cliente();
				clienteViagemAtualizado.setId(scanner.nextInt());
				viagemAtualizada.setIdCliente(clienteViagemAtualizado);
				System.out.print("Digite o ID do Destino : ");
				Destino destinoViagemAtualizado = new Destino();
				destinoViagemAtualizado.setId(scanner.nextInt());
				viagemAtualizada.setIdDestino(destinoViagemAtualizado);

				viagemDAO.updateViagem(viagemAtualizada);
				break;
			case 4:
				System.out.println("Digite o ID da viagem a ser *DELETADA*: ");
				int idViagem = scanner.nextInt();
				viagemDAO.deleteViagem(idViagem);

				break;
		
			case 0 :
				System.out.println("Saindo...");
                break;
			default:
				System.out.println("ATENÇÃO: Digite uma opção valida");

			}

		} while (option != 0);

		return option;
	}
}
