/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

import java.sql.Date;
import java.time.LocalDate;
import javafx.stage.FileChooser;

/**
 *
 * @author Houssem
 */
public class Produit {
    private int idproduit;
    private String nomproduit;
        private String nomimage;

    private LocalDate datemisevente;
    private float prix;
    private String categorie;
    private int nbrlike=0;
    private int nbrdislike=0;
    private String etat;
    private FileChooser image;
    private String descriptionproduit;

    public Produit() {
    }

    public Produit(String nomproduit,float prix,LocalDate datemisevente, String categorie, String descriptionproduit,String nomimage) {
        this.nomproduit = nomproduit;
        this.prix = prix;
        this.datemisevente=datemisevente;
        this.categorie = categorie;
        this.descriptionproduit = descriptionproduit;
        this.nomimage=nomimage;
    }
    public Produit(String nomproduit,float prix, String descriptionproduit , String categorie ) {
        this.nomproduit = nomproduit;
        this.prix = prix;
        this.descriptionproduit = descriptionproduit;
          this.categorie = categorie;
    }
    public Produit(String nomproduit,float prix, String categorie, String descriptionproduit,String nomimage) {
        this.nomproduit = nomproduit;
        this.prix = prix;
        this.categorie = categorie;
        this.descriptionproduit = descriptionproduit;
        this.nomimage=nomimage;
    }

    public String getNomimage() {
        return nomimage;
    }

    public void setNomimage(String nomimage) {
        this.nomimage = nomimage;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public LocalDate getDatemisevente() {
        return datemisevente;
    }

    public void setDatemisevente(LocalDate datemisevente) {
        this.datemisevente = datemisevente;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getNbrlike() {
        return nbrlike;
    }

    public void setNbrlike(int nbrlike) {
        this.nbrlike = nbrlike;
    }

    public int getNbrdislike() {
        return nbrdislike;
    }

    public void setNbrdislike(int nbrdislike) {
        this.nbrdislike = nbrdislike;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public FileChooser getImage() {
        return image;
    }

    public void setImage(FileChooser image) {
        this.image = image;
    }

    public String getDescriptionproduit() {
        return descriptionproduit;
    }

    public void setDescriptionproduit(String descriptionproduit) {
        this.descriptionproduit = descriptionproduit;
    }
    
    @Override
    public String toString() {
        return "Produit{" + " id=" + idproduit + " ,nomproduit=" + nomproduit + " ,Date Mise En Vente=" +datemisevente +" ,Prix = "+
                prix+" <Catégorie = "+categorie +" ,Description = "+descriptionproduit+'}';
    }
    
    
    
    
    
    
    
    
    
    
    

    
}
