/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.*;

/**
 *
 * @author AbirBrahem
 */
public class Reclamation {
    private int reclamationId;
    private int userID;
    private String content;   
    private String email;
    private int telephone;
    private String etat;
    private String type;


    public Reclamation() { 
        // TODO replace with auto generated id
        this.reclamationId = 1000;
    }

    public Reclamation(int userID, String content, String email, int telephone, String etat, String type) {
        this.reclamationId = 1000;
        this.userID = userID;
        this.content = content;
        this.email = email;
        this.telephone = telephone;
        this.etat = etat;
        this.type = type;
    }

    public int getReclamationId() {
        return reclamationId;
    }

    public void setReclamationId(int reclamationId) {
        this.reclamationId = reclamationId;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "reclamationId=" + reclamationId + ", userID=" + userID + ", content=" + content + ", email=" + email + ", telephone=" + telephone + ", etat=" + etat + ", type=" + type + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.reclamationId;
        hash = 53 * hash + this.userID;
        hash = 53 * hash + Objects.hashCode(this.content);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + this.telephone;
        hash = 53 * hash + Objects.hashCode(this.etat);
        hash = 53 * hash + Objects.hashCode(this.type);
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
        final Reclamation other = (Reclamation) obj;
        if (this.reclamationId != other.reclamationId) {
            return false;
        }
        if (this.userID != other.userID) {
            return false;
        }
        if (this.telephone != other.telephone) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    
}
