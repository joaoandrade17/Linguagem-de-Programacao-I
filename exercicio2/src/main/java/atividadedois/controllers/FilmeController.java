package atividadedois.controllers;

import java.io.IOException;
import atividadedois.classes.Esporte;
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

    @FXML
    private void ExibirInfo(ActionEvent event) {
        String nome = Nome.getText();
        String genero = Genero.getText();
        String ano = Ano.getText();
        if (nome.isEmpty() || genero.isEmpty() || ano.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, preencha todos os campos primeiro.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "Filme: " + nome + "\nGênero: " + genero + "\nAno de lançamento: " + ano;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Exibir Info");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }
}
