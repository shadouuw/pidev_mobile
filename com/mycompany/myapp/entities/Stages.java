/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author asus
 */
public class Stages {
 int id,jeu,numero;
 int temps;
 String texte,essai,correction,source;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getJeu() {
        return jeu;
    }

    public void setJeu(int jeu) {
        this.jeu = jeu;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getEssai() {
        return essai;
    }

    public void setEssai(String essai) {
        this.essai = essai;
    }

    public String getCorrection() {
        return correction;
    }

    public void setCorrection(String correction) {
        this.correction = correction;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Stages() {
    }

    public Stages(int id,int numero,String texte,String essai,String correction,String source,int temps,int jeu) {
        this.id = id;
        this.jeu = jeu;
        this.temps = temps;
        this.texte = texte;
        this.essai = essai;
        this.correction = correction;
        this.source = source;
        this.numero=numero;
    }
    
    
        public Stages(int numero,String texte,String essai,String correction,String source,int temps,int jeu) {
      
        this.jeu = jeu;
        this.temps = temps;
        this.texte = texte;
        this.essai = essai;
        this.correction = correction;
        this.source = source;
        this.numero=numero;
    }
 
}
