/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.test;


import com.wf.entity.Produit;
import com.wf.service.ProduitService;
import java.time.LocalDate;
import static javafx.application.Application.launch;

/**
 *
 * @author Houssem
 */
public class Test {
     public static void main(String[] args) {
        launch(args);
        LocalDate date =LocalDate.now();
        Produit p =new Produit("newprod-Test",500,date,"test","test","test");
        ProduitService ps =new ProduitService();
        ps.insert(p);
        ps.delete(p);
    }
}
