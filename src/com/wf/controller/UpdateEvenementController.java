/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.Evenement;
import com.wf.service.EvenementService;
import com.wf.service.User1Service;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Marwa
 */
public class UpdateEvenementController  {

    /**
     * Initializes the controller class.
     */
 @FXML
private TextField txtid;
  @FXML
private TextField  txtnom;
  @FXML
private TextField  txtprenom;

  @FXML
  private void updateUser(ActionEvent event1) throws ClassNotFoundException, SQLException{
                   Evenement u=new Evenement (Integer.parseInt(txtid.getText()),txtnom.getText(),txtprenom.getText());
            EvenementService pdao = EvenementService.getInstance();
            pdao.update(u);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne modifié avec succés!");
        alert.show();
        txtid.setText("");
                txtnom.setText("");
        txtprenom.setText("");
        
  }  
    
}
