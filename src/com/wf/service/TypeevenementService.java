/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.type_evenement;
import com.wf.util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marwa
 */
public class TypeevenementService implements IService<type_evenement> {

   private static TypeevenementService instance;

   
    private Statement st;
    private ResultSet rs;
    
    public TypeevenementService() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static TypeevenementService getInstance() {
         if(instance==null) 
            instance = new TypeevenementService();
        return instance;
     }
    @Override
    public void insert(type_evenement o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(type_evenement o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<type_evenement> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public type_evenement displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(type_evenement os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

                  public  ArrayList<type_evenement> getcategorieparent() throws SQLException {
       ArrayList<type_evenement> retour = new ArrayList<>();
//String names = retour.stream().reduce(new type_evenement()).get
        String req = "SELECT * FROM `type_evenement` ";
        ResultSet resultat = st.executeQuery(req);
        while(resultat.next()){
             int idtype =resultat.getInt(1);
             String nomtype= resultat.getString(2);
           retour.add(new type_evenement( idtype ,nomtype));
            
        }
            
        return retour;
    }
                  
                  public  ArrayList<type_evenement> getnomcategorie() throws SQLException {
       ArrayList<type_evenement> retour = new ArrayList<>();
       
        String req = "SELECT nomtype FROM type_evenement";
        ResultSet resultat = st.executeQuery(req);
        while(resultat.next()){
            
             String nomtype= resultat.getString(1);
           retour.add(new type_evenement(nomtype) );
            
        }
            
        return retour;
    }
}
