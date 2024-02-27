package app;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.Veiculo;
import util.Dao;


public class EditarVeiculoController {
    @FXML
    private TextField campoMarca; 
    
    @FXML
    private TextField campoModelo; 
    
    @FXML
    private TextField campoPlaca; 
    
    @FXML
    private ComboBox<Veiculo> comboVeiculo;
    
    private ObservableList<Veiculo> listaOb;
    private List<Veiculo> lista;
    private Dao<Veiculo> dao;
    private Veiculo temp;
    
    @FXML
    private void initialize(){
        dao = new Dao(Veiculo.class);
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboVeiculo.setItems(listaOb);
    }
    
    @FXML
    private void atualizaCampos(){
        temp = comboVeiculo.getSelectionModel().getSelectedItem();
        campoMarca.setText(temp.getMarca());
        campoModelo.setText(temp.getModelo());
        campoPlaca.setText(temp.getPlaca());
    }
    
    @FXML
    private void editarVeiculo(){ 
        Veiculo temp = comboVeiculo.getSelectionModel().getSelectedItem();
        temp.setMarca(campoMarca.getText());
        temp.setModelo(campoModelo.getText());
        temp.setPlaca(campoPlaca.getText());
        
        Dao<Veiculo> dao = new Dao(Veiculo.class); 
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboVeiculo.setItems(listaOb);
        dao.alterar(temp);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("As informações do veiculo foram alteradas");
        alert.show();
    }  
    
    
    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
}
