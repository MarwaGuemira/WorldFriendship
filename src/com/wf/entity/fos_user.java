/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

/**
 *
 * @author ihebm
 */
public class fos_user {
    private int id;
    private String nom;
    private String prenom;
    private int  numero_tel;
    private String  monimage;
    public fos_user() {
    }

    public fos_user(int id, String nom, String prenom, int numero_tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numero_tel = numero_tel;
    }

    public fos_user(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public fos_user(String nom, String prenom, int numero_tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero_tel = numero_tel;
    }

    public fos_user(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNumero_tel() {
        return numero_tel;
    }

    public void setNumero_tel(int numero_tel) {
        this.numero_tel = numero_tel;
    }

    public String getMonimage() {
        return monimage;
    }

    public void setMonimage(String monimage) {
        this.monimage = monimage;
    }

    @Override
    public String toString() {
        return "User1{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final fos_user other = (fos_user) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
        
}
