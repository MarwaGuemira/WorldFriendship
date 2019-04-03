/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.jfoenix.controls.JFXButton;
import com.wf.entity.Evenement;
import com.wf.entity.Pub;
import com.wf.service.EvenementService;
import com.wf.service.PubService;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Marwa
 */
public class MesPubsController implements Initializable {
 @FXML
    private TableView userTable;
    @FXML
    private TableColumn<Pub, Integer> colId;
    @FXML
    private TableColumn<Pub, String> colNom;
    @FXML
    private TableColumn<Pub, String> coldesc;
      @FXML
    private TableColumn<Pub, Float> colnprixsol;
    @FXML
    private TableColumn<Pub, String> colpays;
    @FXML
    private TableColumn<Pub, String> colregion;
      @FXML
    private TableColumn<Pub, Float> colnprixa;
    @FXML
    private TableColumn<Pub, String> colAdresse;
    @FXML
    private TableColumn<Pub, LocalDate> coldatedb;
     @FXML
    private TextField idLabel;
    @FXML
    private TextField nomLabel;
    @FXML
    private TextField descLabel;
     @FXML
    private TextField search2;
   
     private ListData2 listdata2 = new ListData2();
    /**
     * Initializes the controller class.
     */
       @FXML
    private JFXButton modifier;
       
       FilteredList<Pub> filter = new FilteredList<>(listdata2.getUsers2(), e -> true); 
@FXML
    private void search2(KeyEvent event1) {
       
       search2.textProperty().addListener((observable,oldValue,newValue) -> {
           filter.setPredicate((Predicate<? super Pub>) (Pub Pub)->{
           
             if(newValue.isEmpty() || newValue==null){
                 return true;
             }
             else if((Pub.getNompublicite().contains(newValue)) || (Pub.getNompublicite().toLowerCase().contains(newValue))){
                 return true;
             }
           return false;
           });
           
       });
       SortedList sort=new SortedList(filter);
       sort.comparatorProperty().bind(userTable.comparatorProperty());
       userTable.setItems(sort);
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  modifier.setDisable(false);
         userTable.setItems(listdata2.getUsers2());
              setCellValue();
                   colId.setCellValueFactory(new PropertyValueFactory<>("idpublicite"));
                colNom.setCellValueFactory(new PropertyValueFactory<>("nompublicite"));
                coldesc.setCellValueFactory(new PropertyValueFactory<>("contenupublicte"));
                colpays.setCellValueFactory(new PropertyValueFactory<>("pays"));
                colAdresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
                colregion.setCellValueFactory(new PropertyValueFactory<>("Region"));
                colnprixa.setCellValueFactory(new PropertyValueFactory<>("prixproduit"));
                colnprixsol.setCellValueFactory(new PropertyValueFactory<>("prixremise"));
                
                
                     
                     userTable.setOnMouseClicked(event->{
        idLabel.setText(String.valueOf(listdata2.getUsers()
                .get(userTable.getSelectionModel().getSelectedIndex()).getIdpublicite()
               ));
        nomLabel.setText(listdata2.getUsers()
                .get(userTable.getSelectionModel().getSelectedIndex())
                .getNompublicite());
        descLabel.setText(listdata2.getUsers()
                .get(userTable.getSelectionModel().getSelectedIndex())
                .getContenupublicte());
                     });
        
      
        // TODO
        // TODO
    }  
    private void setCellValue() {
        
        
          userTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
              
            @Override
            public void handle(MouseEvent event) {
                Pub pl = listdata2.getUsers2().get(userTable.getSelectionModel().getSelectedIndex());
                idLabel.setText(Integer.toString(pl.getIdpublicite()));
                nomLabel.setText(pl.getNompublicite());
                descLabel.setText((pl.getContenupublicte()));
                //modifier.setDisable(false);
                
        
            }});
          }
    
     @FXML
  private void updateUser(ActionEvent event3) throws ClassNotFoundException, SQLException{
                
        ObservableList<Pub> selectedRows, allusers;
        allusers = userTable.getItems();
        selectedRows = userTable.getSelectionModel().getSelectedItems();
        for(Pub p: selectedRows)
        {
     
      
      
      Pub p1=new Pub (Integer.parseInt(idLabel.getText()),nomLabel.getText(),descLabel.getText());
            PubService pdao = PubService.getInstance();
            pdao.update(p1);
             
//            listViewEvenement.clear();
//       
//            eveTable.setItems(listdata.getUsers());
//              setCellValue();
//                   colId.setCellValueFactory(new PropertyValueFactory<>("idevenement"));
//                colNom.setCellValueFactory(new PropertyValueFactory<>("nomevenement"));
//                coldesc.setCellValueFactory(new PropertyValueFactory<>("descriptionevenement"));
//                colpays.setCellValueFactory(new PropertyValueFactory<>("pays"));
//                colAdresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
//                colregion.setCellValueFactory(new PropertyValueFactory<>("Region"));
//                colnbrpar.setCellValueFactory(new PropertyValueFactory<>("nbrparticipants"));
//                colnbtick.setCellValueFactory(new PropertyValueFactory<>("nbrplacestotal"));
//          
//              
//       
//            
//            
            
            
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne modifié avec succés!");
        alert.showAndWait();
  
        
        idLabel.setText("");
                nomLabel.setText("");
        descLabel.setText("");
        }    
  }  

    @FXML
    public void deleteButton(){
        ObservableList<Pub> selectedRows, allusers;
        allusers = userTable.getItems();
        selectedRows = userTable.getSelectionModel().getSelectedItems();
        for(Pub p: selectedRows)
        {
          //  User1Service pdao1 = User1Service.getInstance();
            allusers.remove(p);
            
        }
    }
}
