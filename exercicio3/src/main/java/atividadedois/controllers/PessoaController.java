package atividadedois.controllers;

import java.io.IOException;
import atividadedois.classes.Pessoa;
import atividadedois.DAO.PessoaDAO;
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
    private Button botaoEditar;

    @FXML
    private Button botaoDeletar;

    @FXML
    private TableView<Pessoa> tabelaPessoa;

    @FXML
    private TableColumn<Pessoa, Integer> colId;

    @FXML
    private TableColumn<Pessoa, String> colNome;

    @FXML
    private TableColumn<Pessoa, Integer> colIdade;

    @FXML
    private TableColumn<Pessoa, Double> colAltura;

    private PessoaDAO pessoaDAO = new PessoaDAO();

    private Pessoa pessoaSelecionada = null;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        colAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));
        carregarPessoas();
    }

    @FXML
    private void SalvarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        String idadeText = Idade.getText();
        String alturaText = Altura.getText();

        if (nome.isEmpty() || idadeText.isEmpty() || alturaText.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos.");
            alerta.showAndWait();
            return;
        }

        int idade = Integer.parseInt(idadeText);
        double altura = Double.parseDouble(alturaText);

        if (pessoaSelecionada == null) {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);
            pessoa.setIdade(idade);
            pessoa.setAltura(altura);
            pessoaDAO.salvar(pessoa);
        } else {
            pessoaSelecionada.setNome(nome);
            pessoaSelecionada.setIdade(idade);
            pessoaSelecionada.setAltura(altura);
            pessoaDAO.atualizar(pessoaSelecionada);
            pessoaSelecionada = null;
        }

        carregarPessoas();
        limparCampos();
    }

    @FXML
    private void EditarOnAction(ActionEvent event) {
        pessoaSelecionada = tabelaPessoa.getSelectionModel().getSelectedItem();
        if (pessoaSelecionada != null) {
            Nome.setText(pessoaSelecionada.getNome());
            Idade.setText(String.valueOf(pessoaSelecionada.getIdade()));
            Altura.setText(String.valueOf(pessoaSelecionada.getAltura()));
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, selecione uma pessoa na tabela para editar.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void DeletarOnAction(ActionEvent event) {
        Pessoa pessoa = tabelaPessoa.getSelectionModel().getSelectedItem();
        if (pessoa != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Tem certeza que deseja deletar esta pessoa?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    pessoaDAO.deletar(pessoa.getId());
                    carregarPessoas();
                    limparCampos();
                }
            });
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione uma pessoa na tabela para deletar.");
            alerta.showAndWait();
        }
    }

    private void carregarPessoas() {
        ObservableList<Pessoa> pessoas = FXCollections.observableArrayList(pessoaDAO.listarTodos());
        tabelaPessoa.setItems(pessoas);
    }

    private void limparCampos() {
        Nome.clear();
        Idade.clear();
        Altura.clear();
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
    private void FalarOnAction(ActionEvent event) {
        String nome = Nome.getText();
        if (nome.isEmpty()) {
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o seu nome antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " está falando!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
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
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o seu nome antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " está comendo!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
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
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setTitle("Erro");
            alertaErro.setHeaderText(null);
            alertaErro.setContentText("Por favor, informe o seu nome antes de prosseguir.");
            alertaErro.showAndWait();
        } else {
            String mensagem = nome + " está caminhando!";
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Ação");
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }
    }
}