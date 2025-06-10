package atividadedois.controllers;

import atividadedois.classes.Animal;
import atividadedois.DAO.AnimalDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;

public class AnimalController {

        @FXML
        private TextField Especie;

        @FXML
        private TextField Peso;

        @FXML
        private TextField Comprimento;

        @FXML
        private Button botaoCorrer;

        @FXML
        private Button botaoComer;

        @FXML
        private Button botaoDormir;

        @FXML
        private Button botaoVoltar;

        @FXML
        private Button botaoSalvar;

        @FXML
        private Button botaoEditar;

        @FXML
        private Button botaoDeletar;

    @FXML
    private TableView<Animal> tabelaAnimal;

    @FXML
    private TableColumn<Animal, String> colEspecie;

    @FXML
    private TableColumn<Animal, Double> colComprimento;

    @FXML
    private TableColumn<Animal, Double> colPeso;

    @FXML
    private TableColumn<Animal, Integer> colId;

    private AnimalDAO animalDAO = new AnimalDAO();

    private Animal animalSelecionado = null;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colComprimento.setCellValueFactory(new PropertyValueFactory<>("comprimento"));

        tabelaAnimal.setItems(FXCollections.observableArrayList());

        carregarAnimais();
    }

    @FXML
    private void SalvarOnAction(ActionEvent event) {
        String especie = Especie.getText();
        String pesoText = Peso.getText();
        String comprimentoText = Comprimento.getText();

        if (especie.isEmpty() || pesoText.isEmpty() || comprimentoText.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos.");
            alerta.showAndWait();
            return;
        }
        double peso = Double.parseDouble(pesoText);
        int comprimento = Integer.parseInt(comprimentoText);

        if (animalSelecionado == null) {
            Animal animal = new Animal();
            animal.setEspecie(especie);
            animal.setPeso(peso);
            animal.setComprimento(comprimento);
            animalDAO.salvar(animal);
        } else {
            animalSelecionado.setEspecie(especie);
            animalSelecionado.setPeso(peso);
            animalSelecionado.setComprimento(comprimento);
            animalDAO.atualizar(animalSelecionado);
            animalSelecionado = null;
        }

        carregarAnimais();
        limparCampos();
    }

    @FXML
    private void EditarOnAction(ActionEvent event) {
        animalSelecionado = tabelaAnimal.getSelectionModel().getSelectedItem();
        if (animalSelecionado != null) {
            Especie.setText(animalSelecionado.getEspecie());
            Peso.setText(String.valueOf(animalSelecionado.getPeso()));
            Comprimento.setText(String.valueOf(animalSelecionado.getComprimento()));
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Aviso");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione um animal na tabela para editar.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void DeletarOnAction(ActionEvent event) {
        Animal animal = tabelaAnimal.getSelectionModel().getSelectedItem();
        if (animal != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Tem certeza que deseja deletar este animal?");

            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    animalDAO.deletar(animal.getId());
                    carregarAnimais();
                    limparCampos();
                }
            });
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Aviso");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione um animal na tabela para deletar.");
            alerta.showAndWait();
        }
    }

    private void carregarAnimais() {
        ObservableList<Animal> animais = FXCollections.observableArrayList(animalDAO.listarTodos());
        tabelaAnimal.setItems(animais);
    }

    private void limparCampos() {
        Especie.clear();
        Peso.clear();
        Comprimento.clear();
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
        private void CorrerOnAction(ActionEvent event) {
            String nome = Especie.getText();
            if (nome.isEmpty()) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Erro");
                alertaErro.setHeaderText(null);
                alertaErro.setContentText("Por favor, informe a espécie do animal antes de prosseguir.");
                alertaErro.showAndWait();
            } else {
                String mensagem = nome + " está correndo!";
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Ação");
                alerta.setHeaderText(null);
                alerta.setContentText(mensagem);
                alerta.showAndWait();
            }
        }

        @FXML
        private void ComerOnAction(ActionEvent event) {
            String nome = Especie.getText();
            if (nome.isEmpty()) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Erro");
                alertaErro.setHeaderText(null);
                alertaErro.setContentText("Por favor, informe a espécie do animal antes de prosseguir.");
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
        private void DormirOnAction(ActionEvent event) {
            String nome = Especie.getText();
            if (nome.isEmpty()) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setTitle("Erro");
                alertaErro.setHeaderText(null);
                alertaErro.setContentText("Por favor, informe a espécie do animal antes de prosseguir.");
                alertaErro.showAndWait();
            } else {
                String mensagem = nome + " está dormindo, zzz...";
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Ação");
                alerta.setHeaderText(null);
                alerta.setContentText(mensagem);
                alerta.showAndWait();
            }
        }
    }
