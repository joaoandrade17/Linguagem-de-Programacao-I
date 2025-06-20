package atividadedois.controllers;

import java.io.IOException;
import atividadedois.classes.Planta;
import atividadedois.DAO.PlantaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private Button botaoEditar;

    @FXML
    private Button botaoDeletar;

    @FXML
    private TableView<Planta> tabelaPlanta;

    @FXML
    private TableColumn<Planta, Integer> colId;

    @FXML
    private TableColumn<Planta, String> colNome;

    @FXML
    private TableColumn<Planta, String> colTipo;

    @FXML
    private TableColumn<Planta, String> colAmbiente;

    private PlantaDAO plantaDAO = new PlantaDAO();

    private Planta plantaSelecionada = null;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colAmbiente.setCellValueFactory(new PropertyValueFactory<>("ambiente"));
        carregarPlantas();
    }

    @FXML
    private void SalvarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        String tipo = Tipo.getText();
        String ambiente = Ambiente.getText();

        if (nome.isEmpty() || tipo.isEmpty() || ambiente.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos.");
            alerta.showAndWait();
            return;
        }

        if (plantaSelecionada == null) {
            Planta planta = new Planta();
            planta.setNome(nome);
            planta.setTipo(tipo);
            planta.setAmbiente(ambiente);
            plantaDAO.salvar(planta);
        } else {
            plantaSelecionada.setNome(nome);
            plantaSelecionada.setTipo(tipo);
            plantaSelecionada.setAmbiente(ambiente);
            plantaDAO.atualizar(plantaSelecionada);
            plantaSelecionada = null;
        }

        carregarPlantas();
        limparCampos();
    }

    @FXML
    private void EditarOnAction(ActionEvent event) {
        plantaSelecionada = tabelaPlanta.getSelectionModel().getSelectedItem();
        if (plantaSelecionada != null) {
            Nome.setText(plantaSelecionada.getNome());
            Tipo.setText(plantaSelecionada.getTipo());
            Ambiente.setText(plantaSelecionada.getAmbiente());
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, selecione uma planta na tabela para editar.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void DeletarOnAction(ActionEvent event) {
        Planta planta = tabelaPlanta.getSelectionModel().getSelectedItem();
        if (planta != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Tem certeza que deseja deletar esta planta?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    plantaDAO.deletar(planta.getId());
                    carregarPlantas();
                    limparCampos();
                }
            });
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Atenção");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione uma planta na tabela para deletar.");
            alerta.showAndWait();
        }
    }

    private void carregarPlantas() {
        ObservableList<Planta> plantas = FXCollections.observableArrayList(plantaDAO.listarTodos());
        tabelaPlanta.setItems(plantas);
    }

    private void limparCampos() {
        Nome.clear();
        Tipo.clear();
        Ambiente.clear();
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
    }
