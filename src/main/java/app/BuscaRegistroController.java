
package app;

import java.io.IOException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Veiculo;
import modelo.UsoVeiculo;
import util.Dao;


public class BuscaRegistroController {
    
    @FXML
    private TableView<UsoVeiculo> tabela;
    
    
    @FXML
    private TableColumn<UsoVeiculo, Integer> colunaCodigo;
    
    @FXML
    private TableColumn<UsoVeiculo, LocalDate> colunaDevolucao;
    
    @FXML
    private TableColumn<UsoVeiculo, LocalDate> colunaRetirada;
    
    @FXML
    private TableColumn<UsoVeiculo, String> colunaVeiculo;
    
    @FXML
    private TableColumn<UsoVeiculo, String> colunaMotorista;
    
    @FXML
    private DatePicker data;

  
    private ObservableList<UsoVeiculo> listarUsoVeiculo;
    private List<UsoVeiculo> usoVeiculo;
    Dao<UsoVeiculo> daoUsoVeiculo = new Dao(UsoVeiculo.class);
   
    
    @FXML
    public void initialize(){
        usoVeiculo = daoUsoVeiculo.listarTodos();
        listarUsoVeiculo = FXCollections.observableArrayList(usoVeiculo);
        
        
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaDevolucao.setCellValueFactory(new PropertyValueFactory<>("devolucao"));
        colunaRetirada.setCellValueFactory(new PropertyValueFactory<>("retirada"));
        colunaVeiculo.setCellValueFactory(new PropertyValueFactory<>("veiculo"));
        colunaMotorista.setCellValueFactory(new PropertyValueFactory<>("motorista"));        

        
        tabela.getColumns().addAll();
        tabela.setItems(listarUsoVeiculo);
        
    }
    
    @FXML
    public void buscaRegistro(){
        LocalDate dataA = data.getValue();
               
        usoVeiculo = daoUsoVeiculo.listarTodos();
        listarUsoVeiculo = FXCollections.observableArrayList(usoVeiculo);
        
        
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaDevolucao.setCellValueFactory(new PropertyValueFactory<>("devolucao"));
        colunaRetirada.setCellValueFactory(new PropertyValueFactory<>("retirada"));
        colunaVeiculo.setCellValueFactory(new PropertyValueFactory<>("veiculo"));
        colunaMotorista.setCellValueFactory(new PropertyValueFactory<>("motorista"));        

        
        tabela.getColumns().addAll();
        tabela.setItems(listarUsoVeiculo.filtered(listarUsoVeiculo -> listarUsoVeiculo.getRetirada().equals(dataA) || listarUsoVeiculo.getDevolucao().equals(dataA)));

        tabela.refresh();
        tabela.sort();
        //System.out.println("data selecionada:"+dataA);
    }
    
    
    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }

    
}


