package atividadedois.controllers;

import java.awt.event.ActionEvent;
import java.io.IOException;

import atividadedois.classes.Pessoa;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    public void FalarOnAction(javafx.event.ActionEvent actionEvent) {
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
}
