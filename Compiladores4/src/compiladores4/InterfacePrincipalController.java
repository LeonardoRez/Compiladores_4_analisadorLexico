/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author leo
 */
public class InterfacePrincipalController implements Initializable {
    
    @FXML
    TextField addTokenRegex;
    @FXML
    TextField addTokenNome;
    @FXML
    TextField entrada;
    @FXML
    TextArea saida;
    @FXML
    TextArea listaTokens;
    @FXML
    Label log;
    
    AnalisadorLexico AL = new AnalisadorLexico();
    
    @FXML
    public void addToken() {
        AL.adicionarToken(addTokenNome.getText(), addTokenRegex.getText());
        listaTokens.setText(AL.getTokensToString());
    }

    @FXML
    public void testarExpressao() {
        saida.setText(AL.tokenizar(entrada.getText()));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void resetarTokens(){
        AL.resetarTokens();
    }
}
