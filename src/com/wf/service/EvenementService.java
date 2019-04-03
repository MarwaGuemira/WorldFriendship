/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.Evenement;
import com.wf.util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Marwa
 */
public class EvenementService implements IService<Evenement>  {

   

   private static EvenementService instance;

   
    private Statement st;
    private ResultSet rs;
    
    public EvenementService() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static EvenementService getInstance() {
         if(instance==null) 
            instance = new EvenementService();
        return instance;
     }

    @Override
    public void insert(Evenement o) {
        String req="insert into evenement (nomevenement,pays,region,adresse,datedebut,datefin,descriptionevenement,nbrtickets,nbrplacestotal,nomimage,typeevenement_id,user_id) values ('"+o.getNomevenement()+"','"+o.getPays()+"','"+o.getRegion()+"','"+o.getAdresse()+"','"+o.getDatedebut()+"','"+o.getDatefin()+"','"+o.getDescriptionevenement()+"','"+o.getNbrtickets()+"','"+o.getNbrplacestotal()+"','"+o.getNomimage()+"','"+o.getTypeevenement_id()+"','"+o.getUser_id()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void delete(Evenement o) {
       String req="DELETE from evenement where idevenement="+o.getIdevenement();

              try {
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public List<Evenement> displayAll() {
      String req="select * from Evenement";
        ObservableList<Evenement> list=FXCollections.observableArrayList();       

        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Evenement p=new Evenement();
                p.setIdevenement(rs.getInt(1));
                p.setNomevenement(rs.getString("nomevenement"));
                p.setDescriptionevenement(rs.getString("descriptionevenement"));
                 p.setPays(rs.getString("pays"));
                  p.setAdresse(rs.getString("adresse"));
                   p.setRegion(rs.getString("region"));
                    p.setNbrparticipants(rs.getInt("nbrparticipants"));
                     p.setNbrtickets(rs.getInt("nbrtickets"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

      public List<Evenement> displayAllList() {
        String req="select * from Evenement";
        List<Evenement> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Evenement p=new Evenement();
                 
                p.setIdevenement(rs.getInt(1));
                p.setNomevenement(rs.getString("nomevenement"));
                p.setDescriptionevenement(rs.getString("descriptionevenement"));
                 p.setPays(rs.getString("pays"));
                  p.setAdresse(rs.getString("adresse"));
                   p.setRegion(rs.getString("region"));
                    p.setNbrparticipants(rs.getInt("nbrparticipants"));
                     p.setNbrtickets(rs.getInt("nbrtickets"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 

      
      public List<Evenement> displayAllListbyorganisateur(int id) {
        String req="select * from Evenement where user_id =  " +id+ "";
            ObservableList<Evenement> list=FXCollections.observableArrayList();   
         try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Evenement p=new Evenement();
                p.setIdevenement(rs.getInt(1));
                p.setNomevenement(rs.getString("nomevenement"));
                p.setDescriptionevenement(rs.getString("descriptionevenement"));
                 p.setPays(rs.getString("pays"));
                  p.setAdresse(rs.getString("adresse"));
                   p.setRegion(rs.getString("region"));
                    p.setNbrparticipants(rs.getInt("nbrparticipants"));
                     p.setNbrtickets(rs.getInt("nbrtickets"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Evenement displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Evenement os) {
        String qry = "UPDATE evenement SET nomevenement = '"+os.getNomevenement()+"', descriptionevenement = '"+os.getDescriptionevenement()+"' WHERE idevenement= "+os.getIdevenement();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   }
    
}
