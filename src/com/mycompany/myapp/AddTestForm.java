/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.mycompany.myapp.entities.Utilisateur;
import com.mycompany.myapp.services.ServiceCours;
import com.mycompany.myapp.services.ServiceUser;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.table.TableModel;
import com.mycompany.myapp.entities.Cours;
import com.mycompany.myapp.entities.Test;
import com.mycompany.myapp.services.ServiceTest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.PasswordField;

/**
 *
 * @author houss
 */
public class AddTestForm extends Form{
      public AddTestForm(Form previous)
    {
     setTitle("Add new user ");
     setLayout(BoxLayout.y());
      this.setUIID("Form1");
      TextField q1=new TextField("","Question one ?");
      TextField q2 =new TextField("","Question two ?");
       TextField q3=new TextField("","Question three ?");
     
     TextField q4=new TextField("","Question four ? ");
     
     TextField q5=new TextField("","Question five ?");
     Picker date=new Picker();
       TextField Photo=new TextField("","Photo");
     Button btn_validate = new Button("Add User");
     
    btn_validate.addActionListener(new ActionListener()
    {
         @Override
         public void actionPerformed(ActionEvent evt) {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date date2=null;
             try {
                 // DateFormatPatterns.ISO8601
                  date2 = (Date) format.parse(date.getText());
                  System.out.println();
             } catch (ParseException ex) {
    
             }
   Test u = new Test(q1.getText(),q2.getText(),q3.getText(),q4.getText(),q5.getText(),date.getDate());    
     if(new ServiceTest().addTest(u))
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
 
    
    addAll(q1,q2,q3,q4,q5,date,btn_validate); 
      
    
     
     
     
     
     
     getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );
     
        
}
      
      

private Map<String, Object> createListEntry(String name, String date) {
  Map<String, Object> entry = new HashMap<>();
  entry.put("Line1", name);
  entry.put("Line3", date);
  entry.put("Line4", date);
  entry.put("Line5", date);
 entry.put("Line2", date);

  return entry;
}
      
}
