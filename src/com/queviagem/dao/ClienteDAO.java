package com.queviagem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.queviagem.model.Cliente;

public class ClienteDAO {

	private static String sql;

	private final Connection connection;

	public ClienteDAO(Connection connection) {

		this.connection = connection;
	}

	public void createClient(Cliente cliente) {
		sql = "INSERT INTO cliente(nome, cpf, email, senha) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getSenha());

			stmt.executeUpdate();
			System.out.println(
					"Cliente cadastrado com sucesso!!! \n Nome: " + cliente.getNome() + " | CPF:" + cliente.getCpf() + " | E-mail: " + cliente.getEmail() + "| Senha: ******");

		} catch (SQLException e) {
			System.out.println("[LOG] Erro ao cadastrar cliente!. Messagem:" + e.getMessage());
		}

	}

	public void readAllClients() {
		sql = "SELECT * FROM cliente";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(r.getInt("id"));
				cliente.setNome(r.getString("nome"));
				cliente.setCpf(r.getString("cpf"));
				cliente.setEmail(r.getString("email"));
				cliente.setSenha(r.getString("senha"));

				System.out.println("ID do cliente: " + cliente.getId());
				System.out.printf(" Nome: %s\n CPF:%s\n Email: %s\n Senha: %s\n", cliente.getNome(),
						cliente.getCpf(), cliente.getEmail(), cliente.getSenha());
			}
			if (!r.next()) {
				System.out.println("Não existem mais informações disponíveis para exibir.");
			}
		} catch (SQLException e) {
			System.out.println("O acesso às informações não pôde ser estabelecido. Mensagem: " + e.getMessage());
		}

	}

	public void updateClient(Cliente cliente) {
		sql = "UPDATE cliente SET nome = ?, cpf = ?, email = ?, senha = ? WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getSenha());
			stmt.setInt(5, cliente.getId());

			stmt.executeUpdate();
			System.out.println(" * Dados do cliente atualizados com sucesso!* \n");
			
		} catch (SQLException e) {
			System. out.println("[LOG] Erro ao atualizar o cadastro. Tente novamente!" + e.getMessage());

		}

	}

	public void deleteClient(int id) {
		sql = " DELETE FROM cliente WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();
			System.out.println("** Dados do cliente deletados com sucesso ** ");

		} catch (SQLException e) {
			System.out.println("*** Não foi possível deletar os dados do cliente! *** Mensagem: " + e.getMessage());

		}
	}

}
