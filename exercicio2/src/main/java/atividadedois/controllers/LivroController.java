package atividadedois.controllers;

import java.io.IOException;
import atividadedois.classes.Livro;
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

public class LivroController {

    @FXML
    private TextField Nome;

    @FXML
    private TextField Paginas;

    @FXML
    private TextField Autor;

    @FXML
    private Button botaoLer;

    @FXML
    private Button botaoGuardar;

    @FXML
    private Button botaoEmprestar;

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
    private void LerOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o livro antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "Você está lendo " + nome + ". Boa leitura!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void GuardarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o livro antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " foi guardado com sucesso.";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void EmprestarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o livro antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " foi emprestado.";
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
        String pag = Paginas.getText();
        String autor =Autor.getText();
        if (nome.isEmpty() || pag.isEmpty() || autor.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, preencha todos os campos primeiro.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "Livro: " + nome + "\nEscrito por: " + autor + "\nNúmero de páginas: " + pag;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Informações");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }
}
