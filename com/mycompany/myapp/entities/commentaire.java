/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;


import java.util.Date;

/**
 *
 * @author Espace Info
 */
public class commentaire {
    private int id_commentaire;
    private Date date; 
    private String email;
    private String contenu; 
    private int idblog;
    private int iduser;
    private int rating;

    public commentaire(String email, String contenu, int idblog, int iduser) {
        this.email = email;
        this.contenu = contenu;
        this.idblog = idblog;
        this.iduser = iduser;
    }

    public commentaire(Date date, String email, String contenu, int idblog, int iduser, int rating) {
        this.date = date;
        this.email = email;
        this.contenu = contenu;
        this.idblog = idblog;
        this.iduser = iduser;
        this.rating = rating;
    }

    public int getIdblog() {
        return idblog;
    }

    public void setIdblog(int idblog) {
        this.idblog = idblog;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public commentaire()
{
    
}
 public commentaire(int id_commentaire, Date date, String email ,String contenu) {
       this.id_commentaire=id_commentaire;
       this.date=date; 
       this.email=email;
       this.contenu=contenu; 
    }
 public commentaire(String email ,String contenu, Date date) {
       this.email=email;
       this.contenu=contenu; 
       this.date=date;
    }
 public commentaire(int id_commentaire)
 {
     this.id_commentaire=id_commentaire;
 }

    public commentaire(String email, String contenu) {
        this.email = email;
        this.contenu = contenu;
    }

    public int getId_commentaire() {
        return id_commentaire;
    }

    public Date getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getContenu() {
        return contenu;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    
    
        @Override
    public String toString() {
        return "commentaire{" + "id_commentaire=" + id_commentaire + ", date=" + date + ", email=" + email + ", contenu=" + contenu + '}';
    }
    
    
    
    
    
}
