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
import modelo.Motorista;
import util.Dao;


public class EditarMotoristaController {
    @FXML
    private TextField campoNome; 
    
    @FXML
    private TextField campoEndereco; 
    
    @FXML
    private TextField campoCnh; 
    
    @FXML
    private TextField campoCategoria; 
    
    @FXML
    private TextField campoSetor; 
    
    @FXML
    private ComboBox<Motorista> comboMotorista;
    
    private ObservableList<Motorista> listaOb;
    private List<Motorista> lista;
    private Dao<Motorista> dao;
    private Motorista temp;
    
    @FXML
    private void initialize(){
        dao = new Dao(Motorista.class);
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboMotorista.setItems(listaOb);
    }
    
    @FXML
    private void atualizaCampos(){
        Motorista temp = comboMotorista.getSelectionModel().getSelectedItem();
        temp = comboMotorista.getSelectionModel().getSelectedItem();
        campoNome.setText(temp.getNome());
        campoEndereco.setText(temp.getEndereco());
        campoCnh.setText(temp.getCnh().toString());
        campoSetor.setText(temp.getSetor());
        campoCategoria.setText(temp.getCategoria());
    }
    
    @FXML
    private void editarMotorista(){ 
        Motorista temp = comboMotorista.getSelectionModel().getSelectedItem();
        temp.setNome(campoNome.getText());
        temp.setEndereco(campoEndereco.getText());
        temp.setCnh(Long.valueOf(campoCnh.getText()));
        temp.setCategoria(campoCategoria.getText());
        temp.setSetor(campoSetor.getText());
        
        Dao<Motorista> dao = new Dao(Motorista.class); 
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboMotorista.setItems(listaOb);
        dao.alterar(temp);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("As informações do motorista foram alteradas");
        alert.show();
    }   

    
    
    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
}
