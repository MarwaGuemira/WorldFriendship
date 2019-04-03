/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;


import static com.oracle.nio.BufferSecrets.instance;
import com.wf.entity.Produit;
import com.wf.entity.fos_user;
import com.wf.util.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * @author Houssem
 */
public class ProduitService implements IService<Produit> {
     Connection con = ConnectionDB.getInstance().getCnx();
     ObservableList<Produit> oblist = FXCollections.observableArrayList();
    private static ProduitService instance;

     private Connection connection;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs ;
    public ProduitService() {
ConnectionDB cs=ConnectionDB.getInstance();     
try {
            ste=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ProduitService getInstance(){
        if(instance==null) 
            instance=new ProduitService();
        return instance;
    }
    @Override
    public void insert(Produit t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String req= "insert into produit(nomproduit,prix,datemisevente,categorie,descriptionproduit,nomimage) values('"+t.getNomproduit()+"','"
                     +t.getPrix()+"','"
                     +t.getDatemisevente()+"','"
                     +t.getCategorie()+"','"
                     +t.getDescriptionproduit()+"','"
                     +t.getNomimage()+"')";
        try {
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public void afficherProduit() {
                 String req="select nomproduit,prix,nomimage,categorie from Produit";

        try {
          
           ResultSet rs=ste.executeQuery(req);
           while(rs.next()){
               //rs.get type de la colonne () l'index ou nom de la colonne 
              System.out.println(
                       "Nom  : "+rs.getString(1)
                      +"Prix : "+rs.getFloat(2)
                       +"Nom Image "+rs.getString(3)
                       +"categorie: "+rs.getString(4)
              );
           }
       } catch (SQLException ex) {
           Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
        

    

    @Override
    public void delete(Produit t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     String req="DELETE FROM Produit WHERE idproduit = ?";
        try {
           pst=connection.prepareStatement(req);
             pst.setInt(1, t.getIdproduit());
             pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public List<Produit> displayAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String req="SELECT * FROM Produit";
         List<Produit>list =new ArrayList<Produit>();
        try {
            pst=connection.prepareStatement(req);
            rs=pst.executeQuery();
            while(rs.next()){
            list.add(
                    new Produit(
                     rs.getString("nomproduit"),
                    rs.getFloat("prix"),
                    rs.getString("categorie"),
                    rs.getString("descriptionproduit"),
                    rs.getString("nomimage")));
                    }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    @Override
    public Produit displayById(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Produit p=null;
   String req="SELECT * FROM Produit WHERE idproduit =?";
         List<Produit>list =new ArrayList<Produit>();
        try {
            pst=connection.prepareStatement(req);
             pst.setInt(1, id);
            rs=pst.executeQuery();
            while(rs.next()){
           p=(
                    new Produit(
                     rs.getString("nomproduit"),
                    rs.getFloat("prix"),
                    rs.getString("categorie"),
                    rs.getString("descriptionproduit"),
                    rs.getString("nomimage")));
                    }
        } catch (SQLException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    
    }

    @Override
    public void update(Produit t) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   String req="UPDATE Produit SET nomprodit= ?,descriptionproduit= ?,prix=?,nomimage=? WHERE idproduit=?";
     try {
         pst=connection.prepareStatement(req);
         pst.setString(1, t.getNomimage());
         pst.setString(2, t.getDescriptionproduit());
         pst.setFloat(3, t.getPrix());
         pst.setString(4, t.getNomimage());
         pst.setInt(5, t.getIdproduit());
         
          pst.executeUpdate();
     } catch (SQLException ex) {
         Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    
}
    
    public ObservableList<Produit> Afficher_All_Produit(){
  
  try {
            Statement st = con.createStatement();
           String req="SELECT * FROM Produit order by datemisevente desc";
            rs=st.executeQuery(req);
            while(rs.next())
  {
      
  oblist.add(new Produit(rs.getString("nomproduit"),rs.getFloat("prix"),rs.getString("descriptionproduit"),rs.getString("categorie")));
								
  }
     } catch (SQLException ex) {
         Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
     }
          
          return oblist;
          
  }

}
