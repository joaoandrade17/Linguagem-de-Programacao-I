package atividadedois.controllers;

import java.io.IOException;
import atividadedois.classes.Filme;
import atividadedois.DAO.FilmeDAO;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FilmeController {

    @FXML
    private TextField Nome;

    @FXML
    private TextField Genero;

    @FXML
    private TextField Ano;

    @FXML
    private Button botaoAssistir;

    @FXML
    private Button botaoRecomendar;

    @FXML
    private Button botaoAvaliar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Button botaoSalvar;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoDeletar;

    @FXML
    private TableView<Filme> tabelaFilme;

    @FXML
    private TableColumn<Filme, Integer> colId;

    @FXML
    private TableColumn<Filme, String> colNome;

    @FXML
    private TableColumn<Filme, String> colGenero;

    @FXML
    private TableColumn<Filme, Integer> colAno;

    private FilmeDAO filmeDAO = new FilmeDAO();

    private Filme filmeSelecionado = null;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        carregarFilmes();
    }

    @FXML
    private void SalvarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        String genero = Genero.getText();
        String anoText = Ano.getText();

        if (nome.isEmpty() || genero.isEmpty() || anoText.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos.");
            alerta.showAndWait();
            return;
        }

        int ano = Integer.parseInt(anoText);

        if (filmeSelecionado == null) {
            Filme filme = new Filme();
            filme.setNome(nome);
            filme.setGenero(genero);
            filme.setAno(ano);
            filmeDAO.salvar(filme);
        } else {
            filmeSelecionado.setNome(nome);
            filmeSelecionado.setGenero(genero);
            filmeSelecionado.setAno(ano);
            filmeDAO.atualizar(filmeSelecionado);
            filmeSelecionado = null;
        }

        carregarFilmes();
        limparCampos();
    }

    @FXML
    private void EditarOnAction(ActionEvent event) {
        filmeSelecionado = tabelaFilme.getSelectionModel().getSelectedItem();
        if (filmeSelecionado != null) {
            Nome.setText(filmeSelecionado.getNome());
            Genero.setText(filmeSelecionado.getGenero());
            Ano.setText(String.valueOf(filmeSelecionado.getAno()));
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, Selecione um filme na tabela para editar.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void DeletarOnAction(ActionEvent event) {
        Filme filme = tabelaFilme.getSelectionModel().getSelectedItem();
        if (filme != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Tem certeza que deseja deletar este filme?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    filmeDAO.deletar(filme.getId());
                    carregarFilmes();
                    limparCampos();
                }
            });
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, Selecione um filme na tabela para deletar.");
            alerta.showAndWait();
        }
    }

    private void carregarFilmes() {
        ObservableList<Filme> filmes = FXCollections.observableArrayList(filmeDAO.listarTodos());
        tabelaFilme.setItems(filmes);
    }

    private void limparCampos() {
        Nome.clear();
        Genero.clear();
        Ano.clear();
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
    private void AssistirOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o nome do filme antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " começou!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void RecomendarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o nome do filme antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "Recomendação enviada com sucesso!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void AvaliarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o nome do filme antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "Avaliação realizada com sucesso!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }
}