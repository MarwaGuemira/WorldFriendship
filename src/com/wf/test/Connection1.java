/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.test;

import com.wf.entity.Produit;
import com.wf.service.ProduitService;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ihebm
 */
public class Connection1 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
Parent root =FXMLLoader.load(getClass().getResource("/com/wf/controller/AfficherProduit.fxml"));
Scene scene = new Scene(root);
primaryStage.setScene(scene);
primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        launch(args);
    }
    
}