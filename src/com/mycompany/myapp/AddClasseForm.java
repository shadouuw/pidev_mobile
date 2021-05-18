/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.ToastBar;
import com.mycompany.myapp.entities.Classe;
import com.mycompany.myapp.services.ServiceClass;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.layouts.BorderLayout;
import com.mycompany.myapp.entities.Utilisateur;
import com.mycompany.myapp.services.ServiceUser;


/**
 *
 * @author houss
 */
public class AddClasseForm extends Form{
    
    public AddClasseForm(Form previous)
    {
     setTitle("Add a new class ");
      this.setUIID("Form1");
     setLayout(BoxLayout.y());
    String [] list=new String[200];
     int i=0;
     for(Utilisateur u : ServiceUser.getInstance().getAlluser())
{
    if(u.getRole()==2)
    {
   list[i]=""+u.getId_utilisateur()+"";
   i++;
    }
    
}
     
     
     
      TextField Classe_name=new TextField("","Class name");
       TextField Age=new TextField("","Age");

Form hi=new Form();
hi.add(Classe_name);
hi.add(Age);
AutoCompleteTextField act = new AutoCompleteTextField(list);
act.addActionListener(e -> ToastBar.showMessage("You picked " + act.getText(), FontImage.MATERIAL_INFO));
Button down = new Button();
System.out.println(act.getText());
FontImage.setMaterialIcon(down, FontImage.MATERIAL_KEYBOARD_ARROW_DOWN);
hi.add(
        BorderLayout.center(act).
                add(BorderLayout.EAST, down));
down.addActionListener(e -> act.showPopup());

         
     Button btn_validate = new Button("Add Class");

    btn_validate.addActionListener(new ActionListener()
    {
         @Override
         public void actionPerformed(ActionEvent evt) {
   
     Classe c = new Classe((Classe_name.getText()),(int)Float.parseFloat(Age.getText()),(int)Float.parseFloat(act.getText()));      
     if(new ServiceClass().addClasse(c))
     {

      

     Dialog.show("Sucess","Conenction accepted ",new Command("OK"));
     
     }
     else 
     {
    Dialog.show("Error","Server Error",new Command("OK"));     
     }
         }
        
    });
        
    addAll(hi,btn_validate); 
      
    
     
     
     
     
     
     getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );
     
        
        
    }
    
    
}
