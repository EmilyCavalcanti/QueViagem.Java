package com.queviagem.menu;
import java.util.Scanner;

public class MenuGeral{

	public static int menu(Scanner scanner) {
		System.out.println("- A QUE VIAGEM TE DESEJA AS BOAS VINDAS *-*. A Seguir, selecione a opcao desejada: - \n "
				+ "|1-Menu Cliente  |\n"
				+ " |2-Menu Destino  |\n"
				+ " |3-Menu Viagem   |\n"
				+ " |0-Sair          | \n");
		
		return scanner.nextInt();
	}
}