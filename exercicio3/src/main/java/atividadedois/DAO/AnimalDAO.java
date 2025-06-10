package atividadedois.DAO;

import atividadedois.classes.Animal;
import atividadedois.Database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    public void salvar(Animal animal) {
        String sql = "INSERT INTO animal (especie, peso, comprimento) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, animal.getEspecie());
            stmt.setDouble(2, animal.getPeso());
            stmt.setInt(3, animal.getComprimento());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Animal animal) {
        String sql = "UPDATE animal SET especie = ?, peso = ?, comprimento = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, animal.getEspecie());
            stmt.setDouble(2, animal.getPeso());
            stmt.setInt(3, animal.getComprimento());
            stmt.setInt(4, animal.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM animal WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Animal> listarTodos() {
        List<Animal> animais = new ArrayList<>();
        String sql = "SELECT * FROM animal";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getInt("id"));
                animal.setEspecie(rs.getString("especie"));
                animal.setPeso(rs.getDouble("peso"));
                animal.setComprimento(rs.getInt("comprimento"));

                animais.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return animais;
    }
}
