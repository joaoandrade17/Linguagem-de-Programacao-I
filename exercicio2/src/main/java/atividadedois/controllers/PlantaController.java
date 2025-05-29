package atividadedois.controllers;

import java.io.IOException;
import atividadedois.classes.Planta;
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

public class PlantaController {

    @FXML
    private TextField Nome;

    @FXML
    private TextField Tipo;

    @FXML
    private TextField Ambiente;

    @FXML
    private Button botaoRegar;

    @FXML
    private Button botaoPlantar;

    @FXML
    private Button botaoColher;

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
        private void RegarOnAction(ActionEvent event) {
            String nome = Nome.getText();
            if (nome.isEmpty()) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Erro");
                alertaErro.setHeaderText(null);
                alertaErro.setContentText("Por favor, informe o nome da planta antes de prosseguir.");
                alertaErro.showAndWait();
            } else {
                String mensagem = nome + " foi regada com sucesso!";
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Ação");
                alerta.setHeaderText(null);
                alerta.setContentText(mensagem);
                alerta.showAndWait();
            }
        }

        @FXML
        private void PlantarOnAction(ActionEvent event) {
            String nome = Nome.getText();
            if (nome.isEmpty()) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Erro");
                alertaErro.setHeaderText(null);
                alertaErro.setContentText("Por favor, informe o nome da planta antes de prosseguir.");
                alertaErro.showAndWait();
            } else {
                String mensagem = nome + " foi plantada com sucesso!";
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Ação");
                alerta.setHeaderText(null);
                alerta.setContentText(mensagem);
                alerta.showAndWait();
            }
        }

        @FXML
        private void ColherOnAction(ActionEvent event) {
            String nome = Nome.getText();
            if (nome.isEmpty()) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Erro");
                alertaErro.setHeaderText(null);
                alertaErro.setContentText("Por favor, informe o nome da planta antes de prosseguir.");
                alertaErro.showAndWait();
            } else {
                String mensagem = nome + " foi colhida com sucesso!";
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
            String tipo = Tipo.getText();
            String ambiente = Ambiente.getText();

            if (nome.isEmpty() || tipo.isEmpty() || ambiente.isEmpty()) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Erro");
                alertaErro.setHeaderText(null);
                alertaErro.setContentText("Por favor, preencha todos os campos primeiro.");
                alertaErro.showAndWait();
            } else {
                String mensagem = "Planta: " + nome + "\nTipo: " + tipo + "\nAmbiente: " + ambiente;
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Informações da Planta");
                alerta.setHeaderText(null);
                alerta.setContentText(mensagem);
                alerta.showAndWait();
            }
        }
    }
