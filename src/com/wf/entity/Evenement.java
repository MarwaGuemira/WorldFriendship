/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entites;

import java.util.Date;

/**
 *
 * @author Marwa
 */
public class Evenement {
    
    
    private int idevenement;
   // private User  user_id;
    // private Categorie categorie_id;
     // private Typeevenement typeevenement_id;

    private  String nomevenement ;
     private  String pays;
    private  String region;
     private String adresse;
     private Date  datedebut;
    private  Date datefin ;
    private  String descriptionevenement ;
    private int nbrparticipants ;
    private int nbrplacestotal ;
     private  int payment ;
    private int nbrtickets;
    private float  prixtickets;
    private  String nomimage;
    private  int nbrlikes;
    private int nbrdislikes ;
   private  int nbsignal ;

    public Evenement() {
    }
                                
    
}
