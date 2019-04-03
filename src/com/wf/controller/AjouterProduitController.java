/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.Produit;
import com.wf.entity.fos_user;
import com.wf.service.ProduitService;
import com.wf.service.User1Service;
import javafx.scene.image.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author Houssem
 */
public class AjouterProduitController {
    
     @FXML
    private TextField Nomp;
    @FXML
    private TextField Prix;
       @FXML
    private TextField idcat;
         @FXML
    private DatePicker iddate;
       @FXML
    private TextField iddesc;
       @FXML
        private ImageView idimage;
      private String ImgToDb;
    @FXML
    private void insertProduit(ActionEvent event) throws ClassNotFoundException,SQLException{
    
     LocalDate date=iddate.getValue();
                 Produit u = new Produit(Nomp.getText(),Float.parseFloat(Prix.getText()),date
                         ,idcat.getText(),iddesc.getText(),ImgToDb); 
            ProduitService pdao = ProduitService.getInstance();
            pdao.insert(u);
            
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Produit insérée avec succés!");
        alert.show();
                Nomp.setText("");
        idcat.setText("");
        Prix.setText("");
        iddesc.setText("");
    }
    @FXML
    private void ProductPicture(ActionEvent event) throws IOException{
     FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files",
                        "*.bmp", "*.png", "*.jpg", "*.gif"));
        File selectedFile =fc.showOpenDialog(new Stage());
        System.out.println("");
        if (selectedFile != null){
            //System.out.println(selectedFile.getName());
//            System.out.println(selectedFile.getAbsolutePath());
//            btnup.setText(selectedFile.getAbsolutePath());

           String imagepath = selectedFile.toURI().toString();
           //System.out.println("file==>  "+imagepath);
    Image image = new Image(imagepath);
           idimage.setImage(image);
           
           File source = new File(selectedFile.getAbsolutePath());
           File dest = new File("C:\\wamp\\www\\PIDev_WorldFriendship\\web\\images");
           
           FileUtils.copyFileToDirectory(source, dest);
//               System.out.println("file uploaded ^^");
               Path p = Paths.get(selectedFile.getAbsolutePath());
               String file = p.getFileName().toString();
//               System.out.println("your link :))))))))");
//               System.out.println("http://localhost/pidev/images/"+file);
               ImgToDb =file;

           
 
            } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Dialogue D'information");
            alert.setHeaderText("Veuillez sélectionner un fichier");
            /*alert.setContentText("You didn't select a file!");*/
            alert.showAndWait();

            //System.out.println("not a valid File ");
        }
    }
    
}
