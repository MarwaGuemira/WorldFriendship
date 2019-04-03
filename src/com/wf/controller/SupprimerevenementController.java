/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.Evenement;
import com.wf.service.EvenementService;
import com.wf.service.User1Service;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 *
 * @author Marwa
 */
public class SupprimerevenementController {
          @FXML
private TextField txtid;
  
    @FXML
    private void deleteUser(ActionEvent event) throws ClassNotFoundException, SQLException{
                   Evenement u= new Evenement(Integer.parseInt(txtid.getText()));
            EvenementService pdao1 = EvenementService.getInstance();
            pdao1.delete(u);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" Supprimer");
        alert.setHeaderText(null);
        alert.setContentText("Personne supprimé avec succés!");
        alert.show();
        txtid.setText("");

  }
}
