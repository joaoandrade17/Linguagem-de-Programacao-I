package atividadedois.DAO;

import atividadedois.classes.Livro;
import atividadedois.Database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class LivroDAO {

        public void salvar(Livro livro) {
            String sql = "INSERT INTO livro (nome, autor, paginas) VALUES (?, ?, ?)";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, livro.getNome());
                stmt.setString(2, livro.getAutor());
                stmt.setInt(3, livro.getPaginas());

                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void atualizar(Livro livro) {
            String sql = "UPDATE livro SET nome = ?, autor = ?, paginas = ? WHERE id = ?";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, livro.getNome());
                stmt.setString(2, livro.getAutor());
                stmt.setInt(3, livro.getPaginas());
                stmt.setInt(4, livro.getId());

                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void deletar(int id) {
            String sql = "DELETE FROM livro WHERE id = ?";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, id);
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public List<Livro> listarTodos() {
            List<Livro> livros = new ArrayList<>();
            String sql = "SELECT * FROM livro";

            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Livro livro = new Livro();
                    livro.setId(rs.getInt("id"));
                    livro.setNome(rs.getString("nome"));
                    livro.setAutor(rs.getString("autor"));
                    livro.setPaginas(rs.getInt("paginas"));

                    livros.add(livro);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return livros;
        }
    }