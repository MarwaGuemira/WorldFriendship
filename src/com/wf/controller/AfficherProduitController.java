/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.Produit;
import com.wf.service.ProduitService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Houssem
 */
public class AfficherProduitController implements Initializable{
@FXML
private TableView<Produit> idtable;
@FXML
private  TableColumn<Produit,String>idn;
@FXML
private TableColumn<Produit,Float> idp;
@FXML
private TableColumn<Produit,String> idd;
    @FXML
    private TableColumn<Produit,String> idi;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet.");
         loadProduit();
       
        idn.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));
        idp.setCellValueFactory(new PropertyValueFactory<>("prix"));
        idd.setCellValueFactory(new PropertyValueFactory<>("descriptionproduit"));
        idi.setCellValueFactory(new PropertyValueFactory<>("categorie"));

 

    }    
  public void loadProduit() 
  {
        
      ProduitService s = new ProduitService();
      ObservableList observableList = s.Afficher_All_Produit();
      idtable.setItems(observableList);
        
    }
//To change body of generated methods, choose Tools | Templates.
    
    
    
}
