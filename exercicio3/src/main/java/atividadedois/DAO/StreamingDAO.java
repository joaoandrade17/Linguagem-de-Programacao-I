package atividadedois.DAO;

import atividadedois.classes.Streaming;
import atividadedois.Database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StreamingDAO {

    public void salvar(Streaming streaming) {
        String sql = "INSERT INTO streaming (nome, preco, categoria) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, streaming.getNome());
            stmt.setDouble(2, streaming.getPreco());
            stmt.setString(3, streaming.getCategoria());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Streaming streaming) {
        String sql = "UPDATE streaming SET nome = ?, preco = ?, categoria = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, streaming.getNome());
            stmt.setDouble(2, streaming.getPreco());
            stmt.setString(3, streaming.getCategoria());
            stmt.setInt(4, streaming.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM streaming WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Streaming> listarTodos() {
        List<Streaming> streamings = new ArrayList<>();
        String sql = "SELECT * FROM streaming";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Streaming streaming = new Streaming();
                streaming.setId(rs.getInt("id"));
                streaming.setNome(rs.getString("nome"));
                streaming.setPreco(rs.getDouble("preco"));
                streaming.setCategoria(rs.getString("categoria"));

                streamings.add(streaming);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return streamings;
    }
}
