package atividadedois.controllers;

import java.io.IOException;
import atividadedois.classes.Instrumento;
import atividadedois.DAO.InstrumentoDAO;
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
    private Button botaoEditar;

    @FXML
    private Button botaoDeletar;

    @FXML
    private TableView<Instrumento> tabelaInstrumento;

    @FXML
    private TableColumn<Instrumento, Integer> colId;

    @FXML
    private TableColumn<Instrumento, String> colNome;

    @FXML
    private TableColumn<Instrumento, String> colTipo;

    @FXML
    private TableColumn<Instrumento, String> colMarca;

    private InstrumentoDAO instrumentoDAO = new InstrumentoDAO();

    private Instrumento instrumentoSelecionado = null;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        carregarInstrumentos();
    }

    @FXML
    private void SalvarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        String tipo = Tipo.getText();
        String marca = Marca.getText();

        if (nome.isEmpty() || tipo.isEmpty() || marca.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos.");
            alerta.showAndWait();
            return;
        }

        if (instrumentoSelecionado == null) {
            Instrumento instrumento = new Instrumento();
            instrumento.setNome(nome);
            instrumento.setTipo(tipo);
            instrumento.setMarca(marca);
            instrumentoDAO.salvar(instrumento);
        } else {
            instrumentoSelecionado.setNome(nome);
            instrumentoSelecionado.setTipo(tipo);
            instrumentoSelecionado.setMarca(marca);
            instrumentoDAO.atualizar(instrumentoSelecionado);
            instrumentoSelecionado = null;
        }

        carregarInstrumentos();
        limparCampos();
    }

    @FXML
    private void EditarOnAction(ActionEvent event) {
        instrumentoSelecionado = tabelaInstrumento.getSelectionModel().getSelectedItem();
        if (instrumentoSelecionado != null) {
            Nome.setText(instrumentoSelecionado.getNome());
            Tipo.setText(instrumentoSelecionado.getTipo());
            Marca.setText(instrumentoSelecionado.getMarca());
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, Selecione um instrumento na tabela para editar.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void DeletarOnAction(ActionEvent event) {
        Instrumento instrumento = tabelaInstrumento.getSelectionModel().getSelectedItem();
        if (instrumento != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Tem certeza que deseja deletar este instrumento?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    instrumentoDAO.deletar(instrumento.getId());
                    carregarInstrumentos();
                    limparCampos();
                }
            });
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione um instrumento na tabela para deletar.");
            alerta.showAndWait();
        }
    }

    private void carregarInstrumentos() {
        ObservableList<Instrumento> instrumentos = FXCollections.observableArrayList(instrumentoDAO.listarTodos());
        tabelaInstrumento.setItems(instrumentos);
    }

    private void limparCampos() {
        Nome.clear();
        Tipo.clear();
        Marca.clear();
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
}
