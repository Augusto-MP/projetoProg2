package app;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Motorista;
import util.Dao;

public class ListarMotoristaController {
    
    @FXML
    private TableView<Motorista> tabela;
    
    @FXML
    private TableColumn<Motorista, String> colunaNome;
    
    @FXML
    private TableColumn<Motorista, String> colunaEndereco;
    
    @FXML
    private TableColumn<Motorista, String> colunaSetor;
    
    @FXML
    private TableColumn<Motorista, String> colunaCategoria;
    
    @FXML
    private TableColumn<Motorista, Long> colunaCnh;

    private ObservableList<Motorista> listarMotorista;
    private List<Motorista> motorista;
    
    @FXML
    public void initialize(){
        Dao<Motorista> daoMotorista = new Dao(Motorista.class);
        motorista = daoMotorista.listarTodos();
        listarMotorista = FXCollections.observableArrayList(motorista);
        
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colunaCnh.setCellValueFactory(new PropertyValueFactory<>("cnh"));
        colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        colunaSetor.setCellValueFactory(new PropertyValueFactory<>("setor"));  
        
        tabela.getColumns().addAll();
        tabela.setItems(listarMotorista);
        tabela.sort();
    }
   
    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
}
