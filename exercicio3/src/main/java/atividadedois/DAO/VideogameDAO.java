package atividadedois.DAO;

import atividadedois.classes.Videogame;
import atividadedois.Database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideogameDAO {

    public void salvar(Videogame videoGame) {
        String sql = "INSERT INTO videogame (nome, geracao, fabricante) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, videoGame.getNome());
            stmt.setString(2, videoGame.getGeracao());
            stmt.setString(3, videoGame.getFabricante());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Videogame videoGame) {
        String sql = "UPDATE videogame SET nome = ?, geracao = ?, fabricante = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, videoGame.getNome());
            stmt.setString(2, videoGame.getGeracao());
            stmt.setString(3, videoGame.getFabricante());
            stmt.setInt(4, videoGame.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM videogame WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Videogame> listarTodos() {
        List<Videogame> jogos = new ArrayList<>();
        String sql = "SELECT * FROM videogame";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Videogame game = new Videogame();
                game.setId(rs.getInt("id"));
                game.setNome(rs.getString("nome"));
                game.setGeracao(rs.getString("geracao"));
                game.setFabricante(rs.getString("fabricante"));

                jogos.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jogos;
    }
}
