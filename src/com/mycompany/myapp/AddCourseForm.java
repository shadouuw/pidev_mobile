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


/**
 *
 * @author houss
 */
public class AddCourseForm extends Form{
    
    public AddCourseForm(Form previous)
    {
     setTitle("Add a new course ");
      this.setUIID("Form1");
     setLayout(BoxLayout.y());
      TextField Cours_name=new TextField("","Course name");
       TextField domaine=new TextField("","Domain");
     
     TextField lien=new TextField("","Photo link");
     Button upload =new Button("upload");
     TextField lien2=new TextField("","Word link");
     Button btn_validate = new Button("Add course");
       upload.addActionListener(new ActionListener()
    {
        @Override
         public void actionPerformed(ActionEvent evt) {
   
            ActionListener callback = e->{
   if (e != null && e.getSource() != null) {
       String filePath = (String)e.toString();
       System.out.println(filePath);

       //  Now do something with this file
   }
};   
                     
                     if (FileChooser.isAvailable()) {
    FileChooser.showOpenDialog(".pdf,application/pdf,.gif,image/gif,.png,image/png,.jpg,image/jpg,.tif,image/tif,.jpeg", callback);
      System.out.println(FileChooser.getMimeTypes());
} 
                    
              }
                
       
     
    });
    btn_validate.addActionListener(new ActionListener()
    {
         @Override
         public void actionPerformed(ActionEvent evt) {
   
     Cours c = new Cours(Cours_name.getText(),domaine.getText(),lien.getText(),lien2.getText());      
     if(new ServiceCours().addCours(c))
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
        
    addAll(Cours_name,domaine,lien,upload,lien2,btn_validate); 
      
    
     
     
     
     
     
     getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );
     
        
        
    }
    
    
}
