package atividadedois.DAO;

import atividadedois.classes.Planta;
import atividadedois.Database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlantaDAO {

    public void salvar(Planta planta) {
        String sql = "INSERT INTO planta (nome, tipo, ambiente) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, planta.getNome());
            stmt.setString(2, planta.getTipo());
            stmt.setString(3, planta.getAmbiente());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Planta planta) {
        String sql = "UPDATE planta SET nome = ?, tipo = ?, ambiente = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, planta.getNome());
            stmt.setString(2, planta.getTipo());
            stmt.setString(3, planta.getAmbiente());
            stmt.setInt(4, planta.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM planta WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Planta> listarTodos() {
        List<Planta> plantas = new ArrayList<>();
        String sql = "SELECT * FROM planta";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Planta planta = new Planta();
                planta.setId(rs.getInt("id"));
                planta.setNome(rs.getString("nome"));
                planta.setTipo(rs.getString("tipo"));
                planta.setAmbiente(rs.getString("ambiente"));

                plantas.add(planta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plantas;
    }
}
