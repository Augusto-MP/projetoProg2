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
import modelo.Operador;
import util.Dao;


public class EditarOperadorController {
    @FXML
    private TextField campoNome; 
    
    @FXML
    private TextField campoEndereco; 
    
    @FXML
    private TextField campoLogin; 
    
    @FXML
    private TextField campoSenha; 
    
    @FXML
    private ComboBox<Operador> comboOperador;
    
    private ObservableList<Operador> listaOb;
    private List<Operador> lista;
    private Dao<Operador> dao;
    private Operador temp;
    
    @FXML
    private void initialize(){
        dao = new Dao(Operador.class);
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboOperador.setItems(listaOb);
    }
    
    @FXML
    private void atualizaCampos(){
        temp = comboOperador.getSelectionModel().getSelectedItem();
        campoNome.setText(temp.getNome());
        campoEndereco.setText(temp.getEndereco());
        campoLogin.setText(temp.getLogin());
        campoSenha.setText(temp.getSenha());
    }
    
    @FXML
    private void editarOperador(){ 
        Operador temp = comboOperador.getSelectionModel().getSelectedItem();
        temp.setNome(campoNome.getText());
        temp.setEndereco(campoEndereco.getText());
        temp.setLogin(campoLogin.getText());
        temp.setSenha(campoSenha.getText());
        
        Dao<Operador> dao = new Dao(Operador.class); 
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboOperador.setItems(listaOb);
        dao.alterar(temp);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("As informações do operador foram alteradas");
        alert.show();
    }  
    
    
    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
}
