package com.queviagem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.queviagem.model.Destino;

public class DestinoDAO {

	private static String sql;

	private final Connection connection;

	public DestinoDAO(Connection connection) {

		this.connection = connection;
	}
	
	public void createDestino (Destino destino) {
		sql = "INSERT INTO Destino ( pais, cidade, valor, promocao) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, destino.getPais());
			stmt.setString(2, destino.getCidade());
			stmt.setDouble(3, destino.getValor());
			stmt.setBoolean(4, destino.isPromocao());
			
			stmt.executeUpdate();
			System.out.println("Destino definido com sucesso!! " + destino.toString());
		
		} catch (SQLException e) {
			System.out.println("Erro ao definir destino" + e.getMessage());
		}
	}
		
		//READ
		
		public void readAllDestino() {
			sql = "SELECT * FROM destino";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				ResultSet r = stmt.executeQuery();
				while (r.next()) {
					Destino destino = new Destino();
					destino.setId(r.getInt("id"));
					destino.setPais(r.getString("pais"));
					destino.setCidade(r.getString("cidade"));
					destino.setValor(r.getDouble("valor"));
					destino.setPromocao(r.getBoolean("promocao"));

					System.out.println(" | ID do destino: " + destino.getId());
					System.out.printf(" | País: %s\n | Cidade: %s\n | Valor: % 2f\n" , destino.getPais(),
							destino.getCidade(), destino.getValor());
					System.out.println(" | Promoção: " + destino.isPromocao());
				}
				if (!r.next()) {
					System.out.println("Não existem mais informações disponíveis para exibir.");
				}
			} catch (SQLException e) {
				System.out.println("O acesso às informações não pôde ser estabelecido. Mensagem: " + e.getMessage());
			}
		}

			public void updateDestino(Destino destino) {
				sql = "UPDATE destino SET pais = ?, cidade = ?, valor = ?, promocao = ? WHERE id = ?";
				try (PreparedStatement stmt = connection.prepareStatement(sql)) {
					stmt.setString(1, destino.getPais());
					stmt.setString(2, destino.getCidade());
					stmt.setDouble(3, destino.getValor());
					stmt.setBoolean(4, destino.isPromocao());
					stmt.setInt(5, destino.getId());

					stmt.executeUpdate();
					System.out.println(" * Dados do destino atualizados com sucesso!* \n");
					
				} catch (SQLException e) {
					System. out.println("[LOG] Erro ao atualizar os dados do destino. Tente novamente!" + e.getMessage());

				}
			}
			
				
				public void deleteDestino(int id) {
					sql = " DELETE FROM destino WHERE id = ?";
					try (PreparedStatement stmt = connection.prepareStatement(sql)) {
						stmt.setInt(1, id);

						stmt.executeUpdate();
						System.out.println("** Dados do destino deletados com sucesso ** ");

					} catch (SQLException e) {
						System.out.println("*** Não foi possível deletar os dados do destino! *** Mensagem:" + e.getMessage());

					}

				}
	}