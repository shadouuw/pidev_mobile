/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author shado
 */
public class Utilisateur {
     private int id_utilisateur;
     private String nom_utilisateur;
       private String mot_de_passe;
       private String nom;
       private String prénom;
       private int age;
       private String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Utilisateur(String nom_utilisateur, String mot_de_passe, String nom, String prénom, int age,String email, String photo) {
        this.nom_utilisateur = nom_utilisateur;
        this.mot_de_passe = mot_de_passe;
        this.nom = nom;
        this.prénom = prénom;
        this.age = age;
        this.photo = photo;
        this.email = email;

    }
       private String email;
      private int id_class;

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public int getId_class() {
        return id_class;
    }
       private int status;
       private int code;

    public Utilisateur(String email) {
        this.email = email;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
        
       
        private int role;
      

    public Utilisateur() {
         //To change body of generated methods, choose Tools | Templates.
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setRole(int role) {
        this.role = role;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public String getNom() {
        return nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }


    public int getRole() {
        return role;
    }

    public Utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public Utilisateur(int id_utilisateur, String nom_utilisateur, String mot_de_passe, String nom, String prénom, int age, String email,int role) {
        this.id_utilisateur = id_utilisateur;
        this.nom_utilisateur = nom_utilisateur;
        this.mot_de_passe = mot_de_passe;
        this.nom = nom;
        this.prénom = prénom;
        this.age = age;
        this.email = email;
     
        this.role = role;
    }

    public Utilisateur(String nom_utilisateur, String mot_de_passe, String nom, String prénom, int age, String email) {
        this.nom_utilisateur = nom_utilisateur;
        this.mot_de_passe = mot_de_passe;
        this.nom = nom;
        this.prénom = prénom;
        this.age = age;
        this.email = email;
    }

    public Utilisateur(int id_utilisateur, String nom_utilisateur, String mot_de_passe, String nom, String prénom, int age, String email) {
        this.id_utilisateur = id_utilisateur;
        this.nom_utilisateur = nom_utilisateur;
        this.mot_de_passe = mot_de_passe;
        this.nom = nom;
        this.prénom = prénom;
        this.age = age;
        this.email = email;
    }

    public Utilisateur(String nom_utilisateur, String mot_de_passe, String nom, String prénom, int age, String email, int role) {
        this.nom_utilisateur = nom_utilisateur;
        this.mot_de_passe = mot_de_passe;
        this.nom = nom;
        this.prénom = prénom;
        this.age = age;
        this.email = email;
        this.role = role;
    }

    public Utilisateur(String nom_utilisateur, String mot_de_passe) {
        this.nom_utilisateur = nom_utilisateur;
        this.mot_de_passe = mot_de_passe;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id_utilisateur=" + id_utilisateur + ", nom_utilisateur=" + nom_utilisateur + ", mot_de_passe=" + mot_de_passe + ", nom=" + nom + ", pr\u00e9nom=" + prénom + ", age=" + age + ", email=" + email + ", role=" + role + '}';
    }

   
}
