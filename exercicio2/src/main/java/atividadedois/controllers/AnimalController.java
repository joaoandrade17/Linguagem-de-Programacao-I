package atividadedois.controllers;

import java.io.IOException;
import atividadedois.classes.Animal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class AnimalController {

        @FXML
        private TextField Especie;

        @FXML
        private TextField Peso;

        @FXML
        private TextField Comprimento;

        @FXML
        private Button botaoCorrer;

        @FXML
        private Button botaoComer;

        @FXML
        private Button botaoDormir;

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
        private void CorrerOnAction(ActionEvent event) {
            String nome = Especie.getText();
            if (nome.isEmpty()) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Erro");
                alertaErro.setHeaderText(null);
                alertaErro.setContentText("Por favor, informe a espécie do animal antes de prosseguir.");
                alertaErro.showAndWait();
            } else {
                String mensagem = nome + " está correndo!";
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Ação");
                alerta.setHeaderText(null);
                alerta.setContentText(mensagem);
                alerta.showAndWait();
            }
        }

        @FXML
        private void ComerOnAction(ActionEvent event) {
            String nome = Especie.getText();
            if (nome.isEmpty()) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Erro");
                alertaErro.setHeaderText(null);
                alertaErro.setContentText("Por favor, informe a espécie do animal antes de prosseguir.");
                alertaErro.showAndWait();
            } else {
                String mensagem = nome + " está comendo!";
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Ação");
                alerta.setHeaderText(null);
                alerta.setContentText(mensagem);
                alerta.showAndWait();
            }
        }

        @FXML
        private void DormirOnAction(ActionEvent event) {
            String nome = Especie.getText();
            if (nome.isEmpty()) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Erro");
                alertaErro.setHeaderText(null);
                alertaErro.setContentText("Por favor, informe a espécie do animal antes de prosseguir.");
                alertaErro.showAndWait();
            } else {
                String mensagem = nome + " está dormindo, zzz...";
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Ação");
                alerta.setHeaderText(null);
                alerta.setContentText(mensagem);
                alerta.showAndWait();
            }
        }

        @FXML
        private void ExibirInfo(ActionEvent event) {
            String nome = Especie.getText();
            String peso = Peso.getText();
            String comprimento = Comprimento.getText();
            if (nome.isEmpty() || peso.isEmpty() || comprimento.isEmpty()) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Erro");
                alertaErro.setHeaderText(null);
                alertaErro.setContentText("Por favor, preencha todos os campos primeiro.");
                alertaErro.showAndWait();
            } else {
                String mensagem = "Espécie: " + nome + "\nPeso: " + peso + "\nComprimento: " + comprimento;
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Exibir Info");
                alerta.setHeaderText(null);
                alerta.setContentText(mensagem);
                alerta.showAndWait();
            }
        }
    }
