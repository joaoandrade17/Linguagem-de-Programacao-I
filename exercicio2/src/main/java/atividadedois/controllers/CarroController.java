package atividadedois.controllers;

import java.io.IOException;
import atividadedois.classes.Carro;
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

public class CarroController {

    @FXML
    private TextField Modelo;

    @FXML
    private TextField Ano;

    @FXML
    private TextField Fabricante;

    @FXML
    private Button botaoAcelerar;

    @FXML
    private Button botaoFrear;

    @FXML
    private Button botaoAbastecer;

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
    private void AcelerarOnAction(ActionEvent event) {
        String nome = Modelo.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o modelo do carro antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " está acelerando!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void FrearOnAction(ActionEvent event) {
        String nome = Modelo.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o modelo do carro antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " está parando!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void AbastecerOnAction(ActionEvent event) {
        String nome = Modelo.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o modelo do carro antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " agora está com o tanque cheio.";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void ExibirInfo(ActionEvent event) {
        String nome = Modelo.getText();
        String ano = Ano.getText();
        String fabricante = Fabricante.getText();
        if (nome.isEmpty() || ano.isEmpty() || fabricante.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, preencha todos os campos primeiro.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "Modelo: " + nome + "\nAno: " + ano + "\nFabricante: " + fabricante;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Exibir Info");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }
}

