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

    @FXML
    private Button botaoAnimais;

    @FXML
    public void AbrirTelaAnimal() {
        try {
            Stage stage = (Stage) botaoAnimais.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/animal.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button botaoCarros;

    @FXML
    public void AbrirTelaCarro() {
        try {
            Stage stage = (Stage) botaoCarros.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/carro.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button botaoEsportes;

    @FXML
    public void AbrirTelaEsporte() {
        try {
            Stage stage = (Stage) botaoEsportes.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/esporte.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button botaoFilmes;

    @FXML
    public void AbrirTelaFilme() {
        try {
            Stage stage = (Stage) botaoFilmes.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/filme.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        @FXML
        private Button botaoInstrumentos;

        @FXML
        public void AbrirTelaInstrumento() {
            try {
                Stage stage = (Stage) botaoInstrumentos.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/instrumento.fxml"));
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    @FXML
    private Button botaoLivros;

    @FXML
    public void AbrirTelaLivro() {
        try {
            Stage stage = (Stage) botaoLivros.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/livro.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button botaoPlantas;

    @FXML
    public void AbrirTelaPlanta() {
        try {
            Stage stage = (Stage) botaoPlantas.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/planta.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button botaoStreamings;

    @FXML
    public void AbrirTelaStreaming() {
        try {
            Stage stage = (Stage) botaoStreamings.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/streaming.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button botaoVideogames;

    @FXML
    public void AbrirTelaVideogame() {
        try {
            Stage stage = (Stage) botaoVideogames.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/atividadedois/videogame.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}