package app;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Veiculo;
import util.Dao;

public class ListarVeiculoController {
    
    @FXML
    private TableView<Veiculo> tabela;
    
    @FXML
    private TableColumn<Veiculo, String> colunaMarca;
    
    @FXML
    private TableColumn<Veiculo, String> colunaModelo;
    
    @FXML
    private TableColumn<Veiculo, String> colunaPlaca;
    

    private ObservableList<Veiculo> listarVeiculo;
    private List<Veiculo> veiculo;
    
    @FXML
    public void initialize(){
        Dao<Veiculo> daoVeiculo = new Dao(Veiculo.class);
        veiculo = daoVeiculo.listarTodos();
        listarVeiculo = FXCollections.observableArrayList(veiculo);
        
        colunaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colunaModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colunaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));

        
        tabela.getColumns().addAll();
        tabela.setItems(listarVeiculo);
        tabela.sort();
    }
   
    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
}
