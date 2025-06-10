package atividadedois.controllers;

import java.io.IOException;
import atividadedois.DAO.EsporteDAO;
import atividadedois.classes.Esporte;
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

public class EsporteController {

    @FXML
    private TextField Nome;

    @FXML
    private TextField Local;

    @FXML
    private TextField Jogadores;

    @FXML
    private Button botaoIniciar;

    @FXML
    private Button botaoEncerrar;

    @FXML
    private Button botaoGanhador;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Button botaoSalvar;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoDeletar;

    @FXML
    private TableView<Esporte> tabelaEsporte;

    @FXML private
    TableColumn<Esporte, Integer> colId;

    @FXML private
    TableColumn<Esporte, String> colNome;

    @FXML private
    TableColumn<Esporte, String> colLocal;

    @FXML private
    TableColumn<Esporte, Integer> colNumJogadores;

    private EsporteDAO esporteDAO = new EsporteDAO();

    private Esporte esporteSelecionado = null;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colLocal.setCellValueFactory(new PropertyValueFactory<>("lugar"));
        colNumJogadores.setCellValueFactory(new PropertyValueFactory<>("jogadores"));
        carregarEsportes();
    }

    @FXML
    private void SalvarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        String lugar = Local.getText();
        String jogadoresText = Jogadores.getText();

        if (nome.isEmpty() || lugar.isEmpty() || jogadoresText.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos.");
            alerta.showAndWait();
            return;
        }

        int jogadores = Integer.parseInt(jogadoresText);

        if (esporteSelecionado == null) {
            Esporte esporte = new Esporte();
            esporte.setNome(nome);
            esporte.setLugar(lugar);
            esporte.setJogadores(jogadores);
            esporteDAO.salvar(esporte);
        } else {
            esporteSelecionado.setNome(nome);
            esporteSelecionado.setLugar(lugar);
            esporteSelecionado.setJogadores(jogadores);
            esporteDAO.atualizar(esporteSelecionado);
            esporteSelecionado = null;
        }

        carregarEsportes();
        limparCampos();
    }

    @FXML
    private void EditarOnAction(ActionEvent event) {
        esporteSelecionado = tabelaEsporte.getSelectionModel().getSelectedItem();
        if (esporteSelecionado != null) {
            Nome.setText(esporteSelecionado.getNome());
            Local.setText(esporteSelecionado.getLugar());
            Jogadores.setText(String.valueOf(esporteSelecionado.getJogadores()));
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione um esporte na tabela para editar.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void DeletarOnAction(ActionEvent event) {
        Esporte esporte = tabelaEsporte.getSelectionModel().getSelectedItem();
        if (esporte != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Tem certeza que deseja deletar este esporte?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    esporteDAO.deletar(esporte.getId());
                    carregarEsportes();
                    limparCampos();
                }
            });
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione um esporte na tabela para deletar.");
            alerta.showAndWait();
        }
    }

    private void carregarEsportes() {
        ObservableList<Esporte> esportes = FXCollections.observableArrayList(esporteDAO.listarTodos());
        tabelaEsporte.setItems(esportes);
    }

    private void limparCampos() {
        Nome.clear();
        Local.clear();
        Jogadores.clear();
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
    private void IniciarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o esporte antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " iniciou!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void EncerrarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o esporte antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "fim de jogo!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void GanhadorOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o esporte antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " tem um ganhador!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }
}