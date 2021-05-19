/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author houss
 */
public class Cours {
    private int idCours;
    private String doc_file;

    public String getDoc_file() {
        return doc_file;
    }

    public void setDoc_file(String doc_file) {
        this.doc_file = doc_file;
    }

    public Cours(int idCours, String nomCours, String Domaine, String lien, String lien2) {
        this.idCours = idCours;
        this.nomCours = nomCours;
        this.Domaine = Domaine;
        this.lien = lien;
        this.lien2 = lien2;
        
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }
    private String nomCours;
    private String Domaine;
    private String lien;
    private String lien2;

    public Cours(String nomCours, String Domaine, String lien, String lien2) {
        this.nomCours = nomCours;
        this.Domaine = Domaine;
        this.lien = lien;
        this.lien2 = lien2;
    }

    public Cours() {
    }

    public String getNomCours() {
        return nomCours;
    }

    public String getDomaine() {
        return Domaine;
    }

    public String getLien() {
        return lien;
    }

    public String getLien2() {
        return lien2;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public void setDomaine(String Domaine) {
        this.Domaine = Domaine;
    }

    @Override
    public String toString() {
        return "Cours{" + "nomCours=" + nomCours + ", Domaine=" + Domaine + ", lien=" + lien + ", lien2=" + lien2 + '}';
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public void setLien2(String lien2) {
        this.lien2 = lien2;
    }
    
    
    
    
}
