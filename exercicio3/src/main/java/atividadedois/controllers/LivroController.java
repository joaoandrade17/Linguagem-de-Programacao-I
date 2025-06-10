package atividadedois.controllers;

import java.io.IOException;

import atividadedois.classes.Livro;
import atividadedois.DAO.LivroDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.util.List;

public class LivroController {

    @FXML
    private TextField Nome;

    @FXML
    private TextField Paginas;

    @FXML
    private TextField Autor;

    @FXML
    private Button botaoLer;

    @FXML
    private Button botaoGuardar;

    @FXML
    private Button botaoEmprestar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Button botaoSalvar;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoDeletar;

    @FXML
    private TableView<Livro> tabelaLivro;

    @FXML
    private TableColumn<Livro, String> colNome;

    @FXML
    private TableColumn<Livro, String> colAutor;

    @FXML
    private TableColumn<Livro, Integer> colPag;

    @FXML
    private TableColumn<Livro, Integer> colId;

    private LivroDAO livroDAO = new LivroDAO();

    private Livro livroSelecionado = null;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colPag.setCellValueFactory(new PropertyValueFactory<>("paginas"));

        tabelaLivro.setItems(FXCollections.observableArrayList());

        carregarLivros();
    }

    @FXML
    private void SalvarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        String pagText = Paginas.getText();
        String autor = Autor.getText();

        if (nome.isEmpty() || autor.isEmpty() || pagText.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos.");
            alerta.showAndWait();
            return;
        }
        int paginas = Integer.parseInt(pagText);

        if (livroSelecionado == null) {
            Livro livro = new Livro();
            livro.setNome(nome);
            livro.setAutor(autor);
            livro.setPaginas(paginas);
            livroDAO.salvar(livro);
        } else {
            livroSelecionado.setNome(nome);
            livroSelecionado.setAutor(autor);
            livroSelecionado.setPaginas(paginas);
            livroDAO.atualizar(livroSelecionado);
            livroSelecionado = null;
        }

        carregarLivros();
        limparCampos();
    }

    @FXML
    private void EditarOnAction(ActionEvent event) {
        livroSelecionado = tabelaLivro.getSelectionModel().getSelectedItem();

        if (livroSelecionado != null) {
            Nome.setText(livroSelecionado.getNome());
            Autor.setText(livroSelecionado.getAutor());
            Paginas.setText(String.valueOf(livroSelecionado.getPaginas()));
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Aviso");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione um livro na tabela para editar.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void DeletarOnAction(ActionEvent event) {
        Livro livroSelecionado = tabelaLivro.getSelectionModel().getSelectedItem();

        if (livroSelecionado != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Tem certeza que deseja deletar este livro? ");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    livroDAO.deletar(livroSelecionado.getId());
                    carregarLivros();
                    limparCampos();
                }
            });
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Aviso");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione um livro na tabela para deletar.");
            alerta.showAndWait();
        }
    }

    private void carregarLivros() {
        try {
            List<Livro> livrosList = livroDAO.listarTodos();
            ObservableList<Livro> livros = FXCollections.observableArrayList(livrosList);
            tabelaLivro.setItems(livros);
            tabelaLivro.refresh();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Erro ao carregar os livros: " + e.getMessage());
            alert.showAndWait();
        }
    }

    private void limparCampos() {
        Nome.clear();
        Autor.clear();
        Paginas.clear();
    }

    @FXML
    public void VoltarOnAction() {
        try {
            Stage stage = (Stage) botaoVoltar.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/menu.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void LerOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o livro antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "Você está lendo " + nome + ". Boa leitura!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void GuardarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o livro antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " foi guardado com sucesso.";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void EmprestarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o livro antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " foi emprestado.";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }
}
