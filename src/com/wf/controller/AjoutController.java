/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.fos_user;
import com.wf.service.User1Service;
import java.awt.Image;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 *
 * @author Marwa
 */
public class AjoutController {
    

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
       @FXML
    private TextField txtTel;
    
       @FXML
    private Label errNom;   
      @FXML
    private Label errTel;   

    @FXML
    private void insertUser(ActionEvent event) throws ClassNotFoundException,SQLException{
     boolean isNomEmpty = Validation.TextFieldValidation.isTexteFieldNoEmpty(txtNom, errNom, "champ Vide ");
     boolean isTelNum = Validation.TextFieldValidation.isTexteFieldTypeNumber(txtTel, errTel, "il que des num ");

     
                 fos_user u = new fos_user(txtNom.getText(), txtPrenom.getText(),Integer.parseInt(txtTel.getText()));
            User1Service pdao = User1Service.getInstance();
            pdao.insert(u);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne insérée avec succés!");
        alert.show();
                txtNom.setText("");
        txtPrenom.setText("");
        txtTel.setText("");
    }
    
//    /**
//     * Initializes the controller class.
//     *
//     * @param url
//     * @param rb
//     */
//
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO     
//        btn.setOnAction(event -> {
//            
//           User1 u = new User1(txtNom.getText(), txtPrenom.getText());
//            User1Service pdao = User1Service.getInstance();
//            pdao.insert(u);
//});
//                }
                }
