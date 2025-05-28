package atividadedois.controllers;

import java.io.IOException;
import atividadedois.classes.Instrumento;
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

public class InstrumentoController {

    @FXML
    private TextField Nome;

    @FXML
    private TextField Tipo;

    @FXML
    private TextField Marca;

    @FXML
    private Button botaoTocar;

    @FXML
    private Button botaoAfinar;

    @FXML
    private Button botaoLimpar;

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
    private void TocarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o instrumento antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " está tocando, que belo som!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void AfinarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o instrumento antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + (" foi afinado.");
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void LimparOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o instrumento antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = (nome + " Limpo com sucesso!");
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
        String marca = Marca.getText();
        if (nome.isEmpty() || tipo.isEmpty() || marca.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, preencha todos os campos primeiro.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "Instrumento: " + nome + "\nTipo: " + tipo + "\nMarca: " + marca;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Exibir Info");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }
}
