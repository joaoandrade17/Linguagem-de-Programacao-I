package atividadedois.controllers;

import java.io.IOException;
import atividadedois.classes.Videogame;
import atividadedois.DAO.VideogameDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VideogameController {

        @FXML
        private TextField Nome;

        @FXML
        private TextField Geracao;

        @FXML
        private TextField Fabricante;

        @FXML
        private Button botaoLigar;

        @FXML
        private Button botaoDesligar;

        @FXML
        private Button botaoInserirDisco;

        @FXML
        private Button botaoVoltar;

        @FXML
        private Button botaoSalvar;

        @FXML
        private Button botaoEditar;

        @FXML
        private Button botaoDeletar;

        @FXML
        private TableView<Videogame> tabelaVideogame;

        @FXML
        private TableColumn<Videogame, Integer> colId;

        @FXML
        private TableColumn<Videogame, String> colNome;

        @FXML
        private TableColumn<Videogame, String> colGeracao;

        @FXML
        private TableColumn<Videogame, Integer> colFabricante;

        private VideogameDAO videogameDAO = new VideogameDAO();

        private Videogame videogameSelecionado = null;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colGeracao.setCellValueFactory(new PropertyValueFactory<>("geracao"));
        colFabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        carregarVideogames();
    }

    @FXML
    private void SalvarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        String geracao = Geracao.getText();
        String fabricante = Fabricante.getText();

        if (nome.isEmpty() || geracao.isEmpty() || fabricante.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos.");
            alerta.showAndWait();
            return;
        }

        if (videogameSelecionado == null) {
            Videogame videogame = new Videogame();
            videogame.setNome(nome);
            videogame.setGeracao(geracao);
            videogame.setFabricante(fabricante);
            videogameDAO.salvar(videogame);
        } else {
            videogameSelecionado.setNome(nome);
            videogameSelecionado.setGeracao(geracao);
            videogameSelecionado.setFabricante(fabricante);
            videogameDAO.atualizar(videogameSelecionado);
            videogameSelecionado = null;
        }

        carregarVideogames();
        limparCampos();
    }

    @FXML
    private void EditarOnAction(ActionEvent event) {
        videogameSelecionado = tabelaVideogame.getSelectionModel().getSelectedItem();
        if (videogameSelecionado != null) {
            Nome.setText(videogameSelecionado.getNome());
            Geracao.setText(videogameSelecionado.getGeracao());
            Fabricante.setText(videogameSelecionado.getFabricante());
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Aviso");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, selecione um videogame na tabela para editar.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void DeletarOnAction(ActionEvent event) {
        Videogame videogame = tabelaVideogame.getSelectionModel().getSelectedItem();
        if (videogame != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Tem certeza que deseja deletar este videogame?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    videogameDAO.deletar(videogame.getId());
                    carregarVideogames();
                    limparCampos();
                }
            });
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Aviso");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione um videogame na tabela para deletar.");
            alerta.showAndWait();
        }
    }

    private void carregarVideogames() {
        ObservableList<Videogame> videogames = FXCollections.observableArrayList(videogameDAO.listarTodos());
        tabelaVideogame.setItems(videogames);
    }

    private void limparCampos() {
        Nome.clear();
        Geracao.clear();
        Fabricante.clear();
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
        private void LigarOnAction(ActionEvent event) {
            String nome = Nome.getText();
            if (nome.isEmpty()) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Erro");
                alertaErro.setHeaderText(null);
                alertaErro.setContentText("Por favor, informe o nome do videogame.");
                alertaErro.showAndWait();
            } else {
                String mensagem = nome + " está ligado!";
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Ação");
                alerta.setHeaderText(null);
                alerta.setContentText(mensagem);
                alerta.showAndWait();
            }
        }

        @FXML
        private void DesligarOnAction(ActionEvent event) {
            String nome = Nome.getText();
            if (nome.isEmpty()) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Erro");
                alertaErro.setHeaderText(null);
                alertaErro.setContentText("Por favor, informe o nome do videogame.");
                alertaErro.showAndWait();
            } else {
                String mensagem = nome + " foi desligado.";
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Ação");
                alerta.setHeaderText(null);
                alerta.setContentText(mensagem);
                alerta.showAndWait();
            }
        }

        @FXML
        private void InserirDiscoOnAction(ActionEvent event) {
            String nome = Nome.getText();
            if (nome.isEmpty()) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Erro");
                alertaErro.setHeaderText(null);
                alertaErro.setContentText("Por favor, informe o nome do videogame.");
                alertaErro.showAndWait();
            } else {
                String mensagem = "Disco inserido no " + nome + " com sucesso!";
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Ação");
                alerta.setHeaderText(null);
                alerta.setContentText(mensagem);
                alerta.showAndWait();
            }
        }
    }