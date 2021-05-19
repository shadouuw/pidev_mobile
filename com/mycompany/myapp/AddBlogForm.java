/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ext.filechooser.FileChooser;
import com.mycompany.myapp.entities.Cours;
import com.mycompany.myapp.services.ServiceCours;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.messaging.Message;
import com.codename1.ui.Display;
import com.codename1.uikit.pheonixui.SignInForm;
import com.mycompany.myapp.entities.Blog;
import com.mycompany.myapp.services.ServiceBlog;


/**
 *
 * @author houss
 */
public class AddBlogForm extends Form{
    
    public AddBlogForm(Form previous)
    {
     setTitle("Add a new course ");
     setLayout(BoxLayout.y());
      this.setUIID("Form1");
      TextField Blog_name=new TextField("","Blog name");
       TextField description=new TextField("","Description");
     
     TextField photo=new TextField("","Photo of blog");
     
     Button btn_validate = new Button("Add blog");

    btn_validate.addActionListener(new ActionListener()
    {
         @Override
         public void actionPerformed(ActionEvent evt) {
   
    Blog b = new Blog(Blog_name.getText(),SignInForm.user.getNom_utilisateur(),description.getText(),photo.getText());      
     if(new ServiceBlog().addBlog(b))
     {
new ServiceCours().Sendmail();
      

     Dialog.show("Sucess","Blog added ",new Command("OK"));
     
     }
     else 
     {
    Dialog.show("Error","Error in adding the blog",new Command("OK"));     
     }
         }
        
    });
        
    addAll(Blog_name,description,photo,btn_validate); 
      
    
     
     
     
     
     
     getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );
     
        
        
    }
    
    
}
