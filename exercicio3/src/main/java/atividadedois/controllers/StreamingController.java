package atividadedois.controllers;

import java.io.IOException;
import atividadedois.classes.Streaming;
import atividadedois.DAO.StreamingDAO;
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

public class StreamingController {

    @FXML
    private TextField Preco;

    @FXML
    private TextField Nome;

    @FXML
    private TextField Categoria;

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
    private Button botaoEditar;

    @FXML
    private Button botaoDeletar;

    @FXML
    private TableView<Streaming> tabelaStreaming;

    @FXML
    private TableColumn<Streaming, Integer> colId;

    @FXML
    private TableColumn<Streaming, String> colNome;

    @FXML
    private TableColumn<Streaming, String> colCategoria;

    @FXML
    private TableColumn<Streaming, Double> colPreco;

    private StreamingDAO streamingDAO = new StreamingDAO();

    private Streaming streamingSelecionado = null;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        carregarStreamings();
    }

    @FXML
    private void SalvarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        String categoria = Categoria.getText();
        String precoText = Preco.getText();

        if (nome.isEmpty() || categoria.isEmpty() || precoText.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos.");
            alerta.showAndWait();
            return;
        }

        double preco = Double.parseDouble(precoText);

        if (streamingSelecionado == null) {
            Streaming streaming = new Streaming();
            streaming.setNome(nome);
            streaming.setCategoria(categoria);
            streaming.setPreco(preco);
            streamingDAO.salvar(streaming);
        } else {
            streamingSelecionado.setNome(nome);
            streamingSelecionado.setCategoria(categoria);
            streamingSelecionado.setPreco(preco);
            streamingDAO.atualizar(streamingSelecionado);
            streamingSelecionado = null;
        }

        carregarStreamings();
        limparCampos();
    }

    @FXML
    private void EditarOnAction(ActionEvent event) {
        streamingSelecionado = tabelaStreaming.getSelectionModel().getSelectedItem();
        if (streamingSelecionado != null) {
            Nome.setText(streamingSelecionado.getNome());
            Categoria.setText(streamingSelecionado.getCategoria());
            Preco.setText(String.valueOf(streamingSelecionado.getPreco()));
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Aviso");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, selecione um streaming na tabela para editar.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void DeletarOnAction(ActionEvent event) {
        Streaming streaming = tabelaStreaming.getSelectionModel().getSelectedItem();
        if (streaming != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Tem certeza que deseja deletar este streaming?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    streamingDAO.deletar(streaming.getId());
                    carregarStreamings();
                    limparCampos();
                }
            });
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Aviso");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione um streaming na tabela para deletar.");
            alerta.showAndWait();
        }
    }

    private void carregarStreamings() {
        ObservableList<Streaming> streamings = FXCollections.observableArrayList(streamingDAO.listarTodos());
        tabelaStreaming.setItems(streamings);
    }

    private void limparCampos() {
        Nome.clear();
        Categoria.clear();
        Preco.clear();
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
    private void AssistirOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o streaming para assistir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = "Assistindo ao streaming: " + nome;
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void PausarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o streaming primeiro.");
            alertaErro.showAndWait();
        } else {
            String mensagem = ("Filme/Série pausado. ");
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
            alertaErro.setContentText("Por favor, informe o streaming para avaliar.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + "foi avaliado: ";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }
}