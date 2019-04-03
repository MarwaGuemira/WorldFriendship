/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

import java.sql.Date;

/**
 *
 * @author nermi
 */
public class Utilisateur {

   
    
    protected int id;
    protected String username;
    protected String email;
    protected boolean enabled;
    private String password;
    protected Date lastLogin;
    private String confirmationToken;
    protected String role;
    protected String nom;
    protected String prenom;
    protected int bonus;
    protected String telephone;
    protected String img;
    protected String pays;
    protected String region;
    public Date Datenaissance;

    public Utilisateur(int id, String username, String email, boolean enabled, String password, Date lastLogin, String confirmationToken, String role, String nom, String prenom, int bonus, String telephone, String img, String pays, String region,Date Datenaissance) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.lastLogin = lastLogin;
        this.confirmationToken = confirmationToken;
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.bonus = bonus;
        this.telephone = telephone;
        this.img = img;
        this.pays = pays;
        this.region = region;
    }
 public Utilisateur(int id, String username, String email, boolean enabled, String password, Date lastLogin, String confirmationToken, String role, String nom, String prenom, String telephone, String img) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.lastLogin = lastLogin;
        this.confirmationToken = confirmationToken;
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.img = img;
        this.Datenaissance=Datenaissance;
    }

    public Utilisateur() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Date getDatenaissance() {
        return Datenaissance;
    }

    public void setDatenaissance(Date Datenaissance) {
        this.Datenaissance = Datenaissance;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
       
}
