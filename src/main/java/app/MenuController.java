package app;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;


public class MenuController {
    
    @FXML
    private void cadastrarMotorista() throws IOException {
        App.setRoot("novoMotorista");
    }
    
    @FXML
    private void editarMotorista() throws IOException{
        App.setRoot("editarMotorista");
    }
    
    @FXML
    private void excluirMotorista() throws IOException{
        App.setRoot("excluirMotorista");
    }
    
    @FXML
    private void listarMotorista() throws IOException{
        App.setRoot("listarMotorista");
    }
    
    @FXML
    private void cadastrarOperador() throws IOException {
        App.setRoot("novoOperador");
    }
    
    @FXML
    private void editarOperador() throws IOException{
        App.setRoot("editarOperador");
    }
    
    @FXML
    private void excluirOperador() throws IOException{
        App.setRoot("excluirOperador");
    }
    
    @FXML
    private void listarOperador() throws IOException{
        App.setRoot("listarOperador");
    }
    
    @FXML
    private void cadastrarVeiculo() throws IOException {
        App.setRoot("novoVeiculo");
    }
    
    @FXML
    private void editarVeiculo() throws IOException{
        App.setRoot("editarVeiculo");
    }
    
    @FXML
    private void excluirVeiculo() throws IOException{
        App.setRoot("excluirVeiculo");
    }
    
    @FXML
    private void listarVeiculo() throws IOException{
        App.setRoot("listarVeiculo");
    }
  
    @FXML
    private void retirarVeiculo() throws IOException{
        App.setRoot("retiradaVeiculo");
    }
    
    @FXML
    private void devolucaoVeiculo() throws IOException{
        App.setRoot("devolucaoVeiculo");
    }
    
    @FXML
    private void buscaRegistro() throws IOException{
        App.setRoot("buscaRegistro");
    }
    
    @FXML
    private void sair(){
        Platform.exit();
        System.exit(0);
    }
    
}
