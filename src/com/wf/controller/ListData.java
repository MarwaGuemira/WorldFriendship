/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.Produit;
import com.wf.service.ProduitService;
import com.wf.service.User1Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ihebm
 */
public class ListData {
        private ObservableList<Produit> users=FXCollections.observableArrayList();

    public ListData() {
        
        ProduitService pdao= ProduitService.getInstance();
        users= (ObservableList<Produit>) pdao.displayAll();
        System.out.println(users);
    }
    
    public ObservableList<Produit> getUsers(){
        return users;
    }
}
