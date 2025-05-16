package atividadedois.controllers;

import javafx.fxml.FXML;
import atividadedois.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class MenuController {

    @FXML
    private Button botaoPessoas;

    @FXML
    public void AbrirTelaPessoa() {
        try {
            Stage stage = (Stage) botaoPessoas.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/pessoa.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}