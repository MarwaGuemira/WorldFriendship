/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.wf.entity.Evenement;
import com.wf.entity.Reclamation;
import com.wf.entity.Utilisateur;
import com.wf.entity.type_evenement;
import com.wf.service.EvenementService;
import com.wf.service.ReclamationService;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 *
 * @author ihebm
 */
public class AjouterReclamationController {
    @FXML
 private JFXTextField txtdesc;
    @FXML
 private JFXTextField txttitre;
     @FXML
    private JFXDatePicker txtdatdeb;
     
     
    
     @FXML
    
     private void insertRec (ActionEvent event) throws ClassNotFoundException,SQLException{
     
         
   LocalDate date1 =txtdatdeb.getValue() ;
  
        // Utilisateur user = LoginFXMLController.CurrentUser;
         
             Reclamation rec = new Reclamation(txtdesc.getText(), txttitre.getText(), date1 );
           ReclamationService pdrec = ReclamationService.getInstance();
            pdrec.insert(rec);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne insérée avec succés!");
        alert.show();
                txtdesc.setText("");
                 txttitre.setText("");  

     }
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
}
