package com.queviagem;

import java.util.Scanner;

import com.queviagem.menu.ClienteMenu;
import com.queviagem.menu.DestinoMenu;
import com.queviagem.menu.MenuGeral;
import com.queviagem.menu.ViagemMenu;


public class Main {

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);

		int option = 0;

		do {

			option = MenuGeral.menu(scanner);

			switch (option) {
			case 1:
				ClienteMenu.SubMenuCliente(scanner);
				break;
			case 2:
				DestinoMenu.SubMenuDestino(scanner);
				break;
			case 3:
				ViagemMenu.SubMenuViagem(scanner);

			default:
				System.out.println("ATENÇÃO: Digite uma opcao valida");
				break;

			}

		} while (option != 4);
		scanner.close();

	}
}