
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.Motorista;
import modelo.UsoVeiculo;
import modelo.Veiculo;
import util.Dao;


public class DevolucaoVeiculoController {
   @FXML
   private ComboBox<UsoVeiculo> comboVeiculo;
   
   @FXML
   private TextField campoMotorista;
   
   private Dao<Veiculo> dao;
   
   private ObservableList<UsoVeiculo> listaOb1;
   private List<UsoVeiculo> lista1;
   private Dao<UsoVeiculo> dao1;
   private UsoVeiculo temp1;
   
   
   @FXML
   private void initialize(){
        dao = new  Dao(Veiculo.class);
        dao1 = new Dao(UsoVeiculo.class);
        lista1 = dao1.listarTodos();
        listaOb1 = FXCollections.observableArrayList(lista1);
        listaOb1 = listaOb1.filtered(usoVeiculo -> !usoVeiculo.getVeiculo().getDisponivel() && usoVeiculo.getDevolucao() == null);
        comboVeiculo.setItems(listaOb1);
   }
   
   @FXML
    private void atualizaCampos(){
         temp1 = comboVeiculo.getSelectionModel().getSelectedItem();
         campoMotorista.setText(temp1.getMotorista().getNome());
    }
   
    @FXML
    private void devolucaoVeiculo(){
          
        
        temp1.setDevolucao(LocalDate.now());
        temp1.getVeiculo().setDisponivel(Boolean.TRUE);
        dao.alterar(temp1.getVeiculo());
        
        
        Dao<UsoVeiculo> dao = new Dao(UsoVeiculo.class); 
        dao.alterar(temp1);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Devolucao confirmada");
        alert.show();    
    }
    
    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
}


