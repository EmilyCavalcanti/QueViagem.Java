package com.queviagem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.queviagem.model.Cliente;
import com.queviagem.model.Destino;
import com.queviagem.model.Viagem;

public class ViagemDAO {

	private static String sql;
	private final Connection connection;

	public ViagemDAO(Connection connection) {
		this.connection = connection;
	}

	public void createViagem(Viagem viagem) {
		sql = "INSERT INTO Viagem (dataIda, dataVolta, cliente_id, destino_id) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			Timestamp sqlDataIda = Timestamp.valueOf(viagem.getDataIda());
			Timestamp sqlDataVolta = Timestamp.valueOf(viagem.getDataVolta());
			stmt.setTimestamp(1, sqlDataIda);
			stmt.setTimestamp(2, sqlDataVolta);
			stmt.setInt(3, viagem.getIdCliente() .getId());
			stmt.setInt(4, viagem.getIdDestino() . getId());

			stmt.executeUpdate();
			System.out.println("Compra realizada. BOA VIAGEM!");
		} catch (SQLException e) {
			System.out.println("Erro ao efetuar compra.  Mensagem: " + e.getMessage());
		}
	}

	public void readAllViagem() {
	    String sql = "SELECT V.id, V.dataIda, V.dataVolta, C.nome AS nomeCliente, D.pais, D.cidade, D.valor " +
	                 "FROM Viagem V " +
	                 "INNER JOIN Cliente C ON V.cliente_id = C.id " +
	                 "INNER JOIN Destino D ON V.destino_id = D.id";

	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        ResultSet result = stmt.executeQuery();
	        while (result.next()) {
	            int idViagem = result.getInt("id");
	            LocalDateTime dataIda = result.getTimestamp("dataIda").toLocalDateTime();
	            LocalDateTime dataVolta = result.getTimestamp("dataVolta").toLocalDateTime();
	            String nomeCliente = result.getString("nomeCliente");
	            String paisDestino = result.getString("pais");
	            String cidadeDestino = result.getString("cidade");
	            double valorDestino = result.getDouble("valor");

	            System.out.println("ID Viagem: " + idViagem + "\nNome Cliente: " + nomeCliente + "\nDestino: " + paisDestino + ", " + cidadeDestino + "\nData de Ida: " + dataIda + "\nValor: " + valorDestino + "\n");
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}

	public void updateViagem(Viagem viagem) {
		sql = "UPDATE Viagem SET dataIda = ?, dataVolta = ?, cliente_id = ?, destino_id = ? WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			Timestamp sqlDataIda = Timestamp.valueOf(viagem.getDataIda());
			Timestamp sqlDataVolta = Timestamp.valueOf(viagem.getDataVolta());
			stmt.setTimestamp(1, sqlDataIda );
			stmt.setTimestamp(2, sqlDataVolta);			
			stmt.setInt(3, viagem.getIdCliente().getId());
			stmt.setInt(4, viagem.getIdDestino().getId());
			stmt.setInt(5, viagem.getId());

			stmt.executeUpdate();
			System.out.println(" * Dados da viagem atualizados com sucesso!* \n");
			

		} catch (SQLException e) {
			System.out.println("[LOG] Erro ao atualizar os dados da viagem. Tente novamente!" +e.getMessage());
		}
	}

	public void deleteViagem(int id) {
		sql = "DELETE FROM viagem WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
			System.out.println("** Dados da viagem deletados com sucesso ** ");

			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}