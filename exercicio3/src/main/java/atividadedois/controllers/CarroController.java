package atividadedois.controllers;

import java.io.IOException;
import atividadedois.DAO.CarroDAO;
import atividadedois.classes.Carro;
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

public class CarroController {

    @FXML
    private TextField Modelo;

    @FXML
    private TextField Ano;

    @FXML
    private TextField Fabricante;

    @FXML
    private Button botaoAcelerar;

    @FXML
    private Button botaoFrear;

    @FXML
    private Button botaoAbastecer;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Button botaoSalvar;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoDeletar;

    @FXML
    private TableView<Carro> tabelaCarro;

    @FXML
    private TableColumn<Carro, Integer> colId;

    @FXML
    private TableColumn<Carro, String> colModelo;

    @FXML
    private TableColumn<Carro, Integer> colAno;

    @FXML
    private TableColumn<Carro, String> colFabricante;

    private CarroDAO carroDAO = new CarroDAO();

    private Carro carroSelecionado = null;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        colFabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        carregarCarros();
    }

    @FXML
    private void SalvarOnAction(ActionEvent event) {
        String modelo = Modelo.getText();
        String anoText = Ano.getText();
        String fabricante = Fabricante.getText();

        if (modelo.isEmpty() || anoText.isEmpty() || fabricante.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos.");
            alerta.showAndWait();
            return;
        }

        int ano = Integer.parseInt(anoText);

        if (carroSelecionado == null) {
            Carro carro = new Carro();
            carro.setModelo(modelo);
            carro.setAno(ano);
            carro.setFabricante(fabricante);
            carroDAO.salvar(carro);
        } else {
            carroSelecionado.setModelo(modelo);
            carroSelecionado.setAno(ano);
            carroSelecionado.setFabricante(fabricante);
            carroDAO.atualizar(carroSelecionado);
            carroSelecionado = null;
        }

        carregarCarros();
        limparCampos();
    }

    @FXML
    private void EditarOnAction(ActionEvent event) {
        carroSelecionado = tabelaCarro.getSelectionModel().getSelectedItem();
        if (carroSelecionado != null) {
            Modelo.setText(carroSelecionado.getModelo());
            Ano.setText(String.valueOf(carroSelecionado.getAno()));
            Fabricante.setText(carroSelecionado.getFabricante());
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, selecione um carro na tabela para editar.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void DeletarOnAction(ActionEvent event) {
        Carro carro = tabelaCarro.getSelectionModel().getSelectedItem();
        if (carro != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Tem certeza que deseja deletar este carro?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    carroDAO.deletar(carro.getId());
                    carregarCarros();
                    limparCampos();
                }
            });
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione um carro na tabela para deletar.");
            alerta.showAndWait();
        }
    }

    private void carregarCarros() {
        ObservableList<Carro> carros = FXCollections.observableArrayList(carroDAO.listarTodos());
        tabelaCarro.setItems(carros);
    }

    private void limparCampos() {
        Modelo.clear();
        Ano.clear();
        Fabricante.clear();
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
    private void AcelerarOnAction(ActionEvent event) {
        String nome = Modelo.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o modelo do carro antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " está acelerando!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void FrearOnAction(ActionEvent event) {
        String nome = Modelo.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o modelo do carro antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " está parando!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }

    @FXML
    private void AbastecerOnAction(ActionEvent event) {
        String nome = Modelo.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o modelo do carro antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " agora está com o tanque cheio.";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }
}