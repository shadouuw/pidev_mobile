/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author houss
 */
public class Blog {
    private int id;
    private String nom;
    private String nomAdmin;

    public Blog(String nom, String nomAdmin, String desciption, String img) {
        this.nom = nom;
        this.nomAdmin = nomAdmin;
        this.desciption = desciption;
        this.img = img;
    }

    public Blog(String nom, String nomAdmin, Date Datepostule, String desciption, String img) {
        this.nom = nom;
        this.nomAdmin = nomAdmin;
        this.Datepostule = Datepostule;
        this.desciption = desciption;
        this.img = img;
    }

    public Blog() {
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

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public Date getDatepostule() {
        return Datepostule;
    }

    public void setDatepostule(Date Datepostule) {
        this.Datepostule = Datepostule;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    private Date Datepostule;
    private String desciption;
     private String img;
    
}
