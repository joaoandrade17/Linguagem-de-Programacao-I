package atividadedois.controllers;

import java.io.IOException;
import atividadedois.classes.VideoGame;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;

public class VideoGameController {

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
    private Button botaoExibir;

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

        @FXML
        private void ExibirInfo(ActionEvent event) {
            String nome = Nome.getText();
            String geracao = Geracao.getText();
            String fabricante = Fabricante.getText();

            if (nome.isEmpty() || geracao.isEmpty() || fabricante.isEmpty()) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Erro");
                alertaErro.setHeaderText(null);
                alertaErro.setContentText("Por favor, preencha todos os campos primeiro.");
                alertaErro.showAndWait();
            } else {
                String mensagem = "Videogame: " + nome + "\nGeração: " + geracao + "\nFabricante: " + fabricante;
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Informações do Videogame");
                alerta.setHeaderText(null);
                alerta.setContentText(mensagem);
                alerta.showAndWait();
            }
        }
    }