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
import modelo.Operador;
import util.Dao;

public class ListarOperadorController {
    
    @FXML
    private TableView<Operador> tabela;
    
    @FXML
    private TableColumn<Operador, String> colunaNome;
    
    @FXML
    private TableColumn<Operador, String> colunaEndereco;
    

    private ObservableList<Operador> listarOperador;
    private List<Operador> operador;
    
    @FXML
    public void initialize(){
        Dao<Operador> daoOperador = new Dao(Operador.class);
        operador = daoOperador.listarTodos();
        listarOperador = FXCollections.observableArrayList(operador);
        
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
         
        tabela.getColumns().addAll();
        tabela.setItems(listarOperador);
        tabela.sort();
    }
   
    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
}
