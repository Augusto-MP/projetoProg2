
package app;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import modelo.Motorista;
import modelo.UsoVeiculo;
import modelo.Veiculo;
import util.Dao;


public class RetiradaVeiculoController {
   @FXML
   private ChoiceBox<Motorista> comboMotorista;
   @FXML
   private ChoiceBox<Veiculo> comboVeiculo;
   
   private ObservableList<Motorista> listaOb;
   private List<Motorista> lista;
   private Dao<Motorista> dao;
   private Motorista temp;
   
   private ObservableList<Veiculo> listaOb1;
   private List<Veiculo> lista1;
   private Dao<Veiculo> dao1;
   private Veiculo temp1;
   
   @FXML
   private void initialize(){
        dao = new Dao(Motorista.class);
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboMotorista.setItems(listaOb);
        
        dao1 = new Dao(Veiculo.class);
        lista1 = dao1.listarTodos();
        listaOb1 = FXCollections.observableArrayList(lista1);
        comboVeiculo.setItems(listaOb1.filtered(Veiculo::getDisponivel));     
   }
    
    @FXML
    private void retiradaVeiculo(){
        
        temp = comboMotorista.getSelectionModel().getSelectedItem();
        temp1 = comboVeiculo.getSelectionModel().getSelectedItem();
        UsoVeiculo usoVeiculo = new UsoVeiculo();   
        
        
        usoVeiculo.setVeiculo(temp1);
        usoVeiculo.setMotorista(temp);
        usoVeiculo.setRetirada(LocalDate.now());
        usoVeiculo.setNome(temp.getNome());
        usoVeiculo.setModelo(temp1.getModelo());
        temp1.setDisponivel(Boolean.FALSE);
        dao1.alterar(temp1);
        
        
        Dao<UsoVeiculo> dao = new Dao(UsoVeiculo.class); 
        dao.inserir(usoVeiculo);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Retirada confirmada");
        alert.show();    
    }
    
    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
}


