package atividadedois.controllers;

import java.io.IOException;
import atividadedois.classes.Pessoa;
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

public class PessoaController {

    @FXML
    private TextField Nome;

    @FXML
    private TextField Idade;

    @FXML
    private TextField Altura;

    @FXML
    private Button botaoFalar;

    @FXML
    private Button botaoComer;

    @FXML
    private Button botaoAndar;

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
    private void FalarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o seu nome antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " está falando!";
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void ComerOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o seu nome antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " está comendo!";
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void AndarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o seu nome antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " está caminhando!";
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void ExibirInfo(ActionEvent event) {
        String nome = Nome.getText();
        String idade = Idade.getText();
        String altura = Altura.getText();
        if (nome.isEmpty() || idade.isEmpty() || altura.isEmpty()) {
            Alert alertaErro = new Alert(AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, preencha todos os campos primeiro.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "Nome: " + nome + "\nIdade: " + idade + "\nAltura: " + altura;
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle("Exibir Info");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

}