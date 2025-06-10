package atividadedois.DAO;

import atividadedois.classes.Esporte;
import atividadedois.Database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EsporteDAO {

    public void salvar(Esporte esporte) {
        String sql = "INSERT INTO esporte (nome, lugar, jogadores) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, esporte.getNome());
            stmt.setString(2, esporte.getLugar());
            stmt.setInt(3, esporte.getJogadores());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Esporte esporte) {
        String sql = "UPDATE esporte SET nome = ?, lugar = ?, jogadores = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, esporte.getNome());
            stmt.setString(2, esporte.getLugar());
            stmt.setInt(3, esporte.getJogadores());
            stmt.setInt(4, esporte.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM esporte WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Esporte> listarTodos() {
        List<Esporte> esportes = new ArrayList<>();
        String sql = "SELECT * FROM esporte";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Esporte esporte = new Esporte();
                esporte.setId(rs.getInt("id"));
                esporte.setNome(rs.getString("nome"));
                esporte.setLugar(rs.getString("lugar"));
                esporte.setJogadores(rs.getInt("jogadores"));

                esportes.add(esporte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return esportes;
    }
}
