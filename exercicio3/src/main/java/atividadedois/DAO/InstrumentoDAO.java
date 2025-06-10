package atividadedois.DAO;

import atividadedois.classes.Instrumento;
import atividadedois.Database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstrumentoDAO {

    public void salvar(Instrumento instrumento) {
        String sql = "INSERT INTO instrumento (nome, tipo, marca) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, instrumento.getNome());
            stmt.setString(2, instrumento.getTipo());
            stmt.setString(3, instrumento.getMarca());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Instrumento instrumento) {
        String sql = "UPDATE instrumento SET nome = ?, tipo = ?, marca = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, instrumento.getNome());
            stmt.setString(2, instrumento.getTipo());
            stmt.setString(3, instrumento.getMarca());
            stmt.setInt(4, instrumento.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM instrumento WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Instrumento> listarTodos() {
        List<Instrumento> instrumentos = new ArrayList<>();
        String sql = "SELECT * FROM instrumento";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Instrumento instrumento = new Instrumento();
                instrumento.setId(rs.getInt("id"));
                instrumento.setNome(rs.getString("nome"));
                instrumento.setTipo(rs.getString("tipo"));
                instrumento.setMarca(rs.getString("marca"));

                instrumentos.add(instrumento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instrumentos;
    }
}
