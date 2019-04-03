/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.Evenement;
import com.wf.entity.Utilisateur;
import com.wf.service.EvenementService;
import com.wf.service.User1Service;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Marwa
 */
class ListData {
     private ObservableList<Evenement>  events=FXCollections.observableArrayList();
 private ObservableList<Evenement>  events1=FXCollections.observableArrayList();
    public ListData() {
        Utilisateur user = LoginFXMLController.CurrentUser;
        int id = user.getId();
        EvenementService pdao= EvenementService.getInstance();
          EvenementService pdao1= EvenementService.getInstance();
         events= (ObservableList<Evenement>) pdao.displayAll();
        System.out.println( events);
        
          events1= (ObservableList<Evenement>) pdao1.displayAllListbyorganisateur(id);
        System.out.println( events1);
    }
     public ObservableList<Evenement> getUsers(){
        return events;
    } 
    public ObservableList<Evenement> getUsers1(){
        events.clear();
      
        return events;
    }
      public ObservableList<Evenement> getUsers2(){
        return events1;
    } 

    }
    
    

