package app;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import modelo.Veiculo;
import util.Dao;
import util.ExclusaoException;

public class ExcluirVeiculoController {
    @FXML
    private ComboBox<Veiculo> comboVeiculo;

    private ObservableList<Veiculo> listaOb;
    private List<Veiculo> lista;
    private Dao<Veiculo> dao;

    @FXML
    private void initialize() {
        dao = new Dao(Veiculo.class);
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboVeiculo.setItems(listaOb);
    }

    @FXML
    private void excluirVeiculo() {
        Veiculo temp = comboVeiculo.getSelectionModel().getSelectedItem();
        try {
            dao.excluir(temp);            
        } catch (ExclusaoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veiculo não pode ser excluído");
            alert.show();
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Veiculo excluido");
        alert.show();
       
        // atualiza a lista 
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboVeiculo.setItems(listaOb);           
    }

    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }
}
