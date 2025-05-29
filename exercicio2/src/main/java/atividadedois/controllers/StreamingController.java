package atividadedois.controllers;

import java.io.IOException;
import atividadedois.classes.Streaming;
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

public class StreamingController {

    @FXML
    private TextField Preco;

    @FXML
    private TextField Series;

    @FXML
    private TextField Filmes;

    @FXML
    private Button botaoAssistir;

    @FXML
    private Button botaoPausar;

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
        String serie = Series.getText();
        if (serie.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o filme/série para assistir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "Assistindo à série: " + serie;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void PausarOnAction(ActionEvent event) {
        String serie = Series.getText();
        if (serie.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe a série/filme primeiro.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "Série pausada: " + serie;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void AvaliarOnAction(ActionEvent event) {
        String filme = Filmes.getText();
        if (filme.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o filme para avaliar.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "Filme avaliado: " + filme;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void ExibirInfo(ActionEvent event) {
        String preco = Preco.getText();
        String series = Series.getText();
        String filmes = Filmes.getText();

        if (preco.isEmpty() || series.isEmpty() || filmes.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, preencha todos os campos primeiro.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "Preço: " + preco + "\nSérie: " + series + "\nFilme: " + filmes;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Informações do Streaming");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }
}
