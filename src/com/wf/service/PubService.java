/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.Evenement;
import com.wf.entity.Pub;
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
public class PubService implements IService<Pub>{
   private static PubService instance;

   
    private Statement st;
    private ResultSet rs;
    
    private PubService() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static PubService getInstance() {
         if(instance==null) 
            instance = new PubService();
        return instance;
     }
      @Override
    public void insert(Pub o) {
   String req="insert into pub (nompublicite,pays,region,adresse,datepublicite,datepublicitefin,contenupublicte, point,prixproduit,pourcentage,prixremise,nomimage,offr_id,user_id) values ('"+o.getNompublicite()+"','"+o.getPays()+"','"+o.getRegion()+"','"+o.getAdresse()+"','"+o.getDatepublicite()+"','"+o.getDatepublicitefin()+"','"+o.getContenupublicte()+"','"+o.getPoint()+"','"+o.getPrixproduit()+"','"+o.getPourcentage()+"','"+o.getPrixremise()+"','"+o.getNomimage()+"','"+o.getOffre_id()+"','"+o.getUser_id()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void delete(Pub o) {
     String req="DELETE from Pub where idpublicite="+o.getIdpublicite();

              try {
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    
    @Override
    public List<Pub> displayAll() {
      String req="select * from pub";
        ObservableList<Pub> list=FXCollections.observableArrayList();       

        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Pub p=new Pub();
                p.setIdpublicite(rs.getInt(1));
                p.setNompublicite(rs.getString("nompublicite"));
                p.setContenupublicte(rs.getString("contenupublicte"));
                 p.setPays(rs.getString("pays"));
                  p.setAdresse(rs.getString("adresse"));
                   p.setRegion(rs.getString("region"));
                    p.setPrixproduit(rs.getFloat("prixproduit"));
                     p.setPrixremise(rs.getFloat("prixremise"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

      public List<Pub> displayAllList() {
        String req="select * from pub";
        List<Pub> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               Pub p=new Pub();
                p.setIdpublicite(rs.getInt(1));
                p.setNompublicite(rs.getString("nompublicite"));
                p.setContenupublicte(rs.getString("contenupublicte"));
                 p.setPays(rs.getString("pays"));
                  p.setAdresse(rs.getString("adresse"));
                   p.setRegion(rs.getString("region"));
                    p.setPrixproduit(rs.getFloat("prixproduit"));
                     p.setPrixremise(rs.getFloat("prixremise"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 

public List<Pub>  displayAllListbyorganisateur(int id) {
        String req="select * from Pub where user_id =  " +id+ "";
            ObservableList<Pub> list=FXCollections.observableArrayList();       

        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Pub p=new Pub();
                p.setIdpublicite(rs.getInt(1));
                p.setNompublicite(rs.getString("nompublicite"));
                p.setContenupublicte(rs.getString("contenupublicte"));
                 p.setPays(rs.getString("pays"));
                  p.setAdresse(rs.getString("adresse"));
                   p.setRegion(rs.getString("region"));
                    p.setPrixproduit(rs.getFloat("prixproduit"));
                     p.setPrixremise(rs.getFloat("prixremise"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Pub displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Pub os) {
  
        String qry = "UPDATE pub SET nompublicite = '"+os.getNompublicite()+"', contenupublicte = '"+os.getContenupublicte()+"' WHERE idpublicite= "+os.getIdpublicite();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   } 
    
    }
    

