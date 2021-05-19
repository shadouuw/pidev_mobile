/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import com.codename1.ui.spinner.Picker;
import java.util.Date;




/**
 *
 * @author shado
 */
public class Test { 
    	private int id_test;
        private String question_1;
        private String question_2;
        private String question_3;
        private String question_4; 
        private String	question_5;
        private int note;
   private int id_utilisateur;
   private int status;
   private String reponse_1;
   private String reponse_2;
    private String reponse_3;	
     private String reponse_4;
      private String reponse_5;
       private Date temps;
  

 
public Test()
{
    
    
    
    
}

    public Test(String question_1, String question_2, String question_3, String question_4, String question_5, int id_utilisateur,Date temps) {
        this.question_1 = question_1;
        this.question_2 = question_2;
        this.question_3 = question_3;
        this.question_4 = question_4;
        this.question_5 = question_5;
        this.id_utilisateur = id_utilisateur;
        this.temps = temps;
    }



    public Test(String question_1, String question_2, String question_3, String question_4, String question_5, Date temps) {
        this.question_1 = question_1;
        this.question_2 = question_2;
        this.question_3 = question_3;
        this.question_4 = question_4;
        this.question_5 = question_5;
        this.temps = temps;
    }

    public Test(String question_1, String question_2, String question_3, String question_4, String question_5, String reponse_1, String reponse_2, String reponse_3, String reponse_4, String reponse_5) {
        this.question_1 = question_1;
        this.question_2 = question_2;
        this.question_3 = question_3;
        this.question_4 = question_4;
        this.question_5 = question_5;
        this.reponse_1 = reponse_1;
        this.reponse_2 = reponse_2;
        this.reponse_3 = reponse_3;
        this.reponse_4 = reponse_4;
        this.reponse_5 = reponse_5;
    }

    public Test(int id_test, String question_1, String question_2, String question_3, String question_4, String question_5, Date temps) {
        this.id_test = id_test;
        this.question_1 = question_1;
        this.question_2 = question_2;
        this.question_3 = question_3;
        this.question_4 = question_4;
        this.question_5 = question_5;
        this.temps = temps;
    }

    public Test(int id_test) {
        this.id_test = id_test;
    }


    public int getId_test() {
        return id_test;
    }

    public String getQuestion_1() {
        return question_1;
    }

    public String getQuestion_2() {
        return question_2;
    }

    public String getQuestion_3() {
        return question_3;
    }

    public String getQuestion_4() {
        return question_4;
    }

    public String getQuestion_5() {
        return question_5;
    }

    public int getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "Test{" + "id_test=" + id_test + ", question_1=" + question_1 + ", question_2=" + question_2 + ", question_3=" + question_3 + ", question_4=" + question_4 + ", question_5=" + question_5 + ", note=" + note + ", id_utilisateur=" + id_utilisateur + ", status=" + status + ", reponse_1=" + reponse_1 + ", reponse_2=" + reponse_2 + ", reponse_3=" + reponse_3 + ", reponse_4=" + reponse_4 + ", reponse_5=" + reponse_5 + ", temps=" + temps + '}';
    }

    public void setId_test(int id_test) {
        this.id_test = id_test;
    }

    public void setQuestion_1(String question_1) {
        this.question_1 = question_1;
    }

    public void setQuestion_2(String question_2) {
        this.question_2 = question_2;
    }

    public void setQuestion_3(String question_3) {
        this.question_3 = question_3;
    }

    public void setQuestion_4(String question_4) {
        this.question_4 = question_4;
    }

    public void setQuestion_5(String question_5) {
        this.question_5 = question_5;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setReponse_1(String reponse_1) {
        this.reponse_1 = reponse_1;
    }

    public void setReponse_2(String reponse_2) {
        this.reponse_2 = reponse_2;
    }

    public void setReponse_3(String reponse_3) {
        this.reponse_3 = reponse_3;
    }

    public void setReponse_4(String reponse_4) {
        this.reponse_4 = reponse_4;
    }

    public void setReponse_5(String reponse_5) {
        this.reponse_5 = reponse_5;
    }

    public void setTemps(Date temps) {
        this.temps = temps;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public int getStatus() {
        return status;
    }

    public Test(int id_utilisateur, String reponse_1, String reponse_2, String reponse_3, String reponse_4, String reponse_5) {
        this.id_utilisateur = id_utilisateur;
        this.reponse_1 = reponse_1;
        this.reponse_2 = reponse_2;
        this.reponse_3 = reponse_3;
        this.reponse_4 = reponse_4;
        this.reponse_5 = reponse_5;
    }

    public String getReponse_1() {
        return reponse_1;
    }

    public String getReponse_2() {
        return reponse_2;
    }

    public String getReponse_3() {
        return reponse_3;
    }

    public String getReponse_4() {
        return reponse_4;
    }

    public String getReponse_5() {
        return reponse_5;
    }

    public Date getTemps() {
        return temps;
    }
    
    
    
    
    
}
