/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.Utilisateur;

import com.wf.util.ConnexionSingleton;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marwa
 */
public class UtilisateurService {
    
      Connection cnx;
    public UtilisateurService() throws SQLException{
        cnx = ConnexionSingleton.getInstance().getCnx();
    } 
     public void ajouterUser(Utilisateur u){
        try {
             
             String req = "INSERT INTO `fos_user`(`username`, `email`, `enabled`, `password`, `roles`, `nom`, `prenom`, `monimage`, `pays`, `numero_tel`, `datede_naissance`, `point`, `region`) VALUES VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
             PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setString(1, u.getUsername());
             pstm.setString(2, u.getEmail());
             pstm.setBoolean(3, u.isEnabled());
             pstm.setString(4, u.getPassword());
             pstm.setString(5, u.getRole());
             pstm.setString(6, u.getNom());
             pstm.setString(7, u.getPrenom());
             pstm.setString(8, u.getImg());
             pstm.setString(9, u.getPays());
             pstm.setString(10, u.getTelephone());
             pstm.setDate(9, u.getDatenaissance());
             pstm.setInt(12,u.getBonus());
             pstm.setString(12,u.getRegion());

             pstm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
     public Utilisateur login(String usern, String passw)
     {
          try {
            String req = "SELECT * FROM `fos_user` WHERE username=? and password=? ";
            PreparedStatement pstm = cnx.prepareStatement(req);
            pstm.setString(1, usern);
            pstm.setString(2, passw);
            ResultSet result=pstm.executeQuery();
            if (!result.next())
            return null;
            
            System.out.println("test");
            int id = result.getInt("id");
            String username = result.getString("username");
            String email = result.getString("email");
            boolean enabled = result.getBoolean("enabled");
            String password = result.getString("password");
            Date lastLogin = result.getDate("last_login");
            String role = result.getString("roles");
            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            String confirmationToken =  result.getString("confirmation_token");
            //AdresseService ads = new AdresseService();
            //Adresse adresse = ads.getAdresse(result.getInt("adresse"));
            String telephone = result.getString("numero_tel");
            String img = result.getString("monimage");
            System.out.println("test");
           
            return new Utilisateur(id, username, email, enabled, password, lastLogin,confirmationToken, role, nom, prenom, telephone, img);

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
     }

   
    
}
