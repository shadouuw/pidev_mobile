/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.mycompany.myapp.entities.Utilisateur;
import com.mycompany.myapp.services.ServiceCours;
import com.mycompany.myapp.services.ServiceUser;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import javafx.scene.control.PasswordField;

/**
 *
 * @author houss
 */
public class AddUserForm extends Form{
      public AddUserForm(Form previous)
    {
     setTitle("Add new user ");
     setLayout(BoxLayout.y());
      TextField nom_utilisateur=new TextField("","Username");
      TextField mdp =new TextField();
       TextField nom=new TextField("","Name");
      this.setUIID("Form1");
     TextField prenom=new TextField("","Surname");
     
     TextField Age=new TextField("","Age");
      TextField Email=new TextField("","Email");
       TextField Photo=new TextField("","Photo");
     Button btn_validate = new Button("Add User");
     
    btn_validate.addActionListener(new ActionListener()
    {
         @Override
         public void actionPerformed(ActionEvent evt) {
   
   Utilisateur u = new Utilisateur(nom_utilisateur.getText(),mdp.getText(),nom.getText(),prenom.getText(),Integer.parseInt(Age.getText()),Email.getText(),Photo.getText());    
     if(new ServiceUser().addUser(u))
     {
new ServiceCours().Sendmail();
      

     Dialog.show("Sucess","Conenction accepted ",new Command("OK"));
     
     }
     else 
     {
    Dialog.show("Error","Server Error",new Command("OK"));     
     }
         }
        
    });
        
    addAll(nom_utilisateur,mdp,nom,prenom,Age,Email,Photo,btn_validate); 
      
    
     
     
     
     
     
     getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );
     
        
}
      
}
