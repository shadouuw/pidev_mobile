/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.mycompany.myapp.entities.Utilisateur;
import com.mycompany.myapp.services.ServiceUser;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.TableLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author houss
 */
public class ListUserForm extends Form{
  
    public ListUserForm(Form previous) throws IOException
    {
TableLayout tl = new TableLayout(6,6); 
         setTitle("List Users ");

SpanLabel ls =new SpanLabel(ServiceUser.getInstance().getAlluser().toString());

Form hi = new Form( tl);


 this.setUIID("Form1");



Label l1=new Label("Id ");
l1.setUIID("label3");
Label l2=new Label("Username");
l2.setUIID("label3");
Label l3=new Label("Name");
l3.setUIID("label3");
Label l4=new Label("Surname");
l4.setUIID("label3");
Label l5=new Label("Age");
l5.setUIID("label3");
Label l6=new Label("Email");
l6.setUIID("label3");
hi.add(l1).add(l2)
        .add(l3).add(l4)
        .add(l5).add(l6);
for(Utilisateur u : ServiceUser.getInstance().getAlluser())
{
hi.add(new Label(""+u.getId_utilisateur()+"")).
    add(new Label(u.getNom_utilisateur())).
    add(new Label(u.getNom())).
    add(new Label(u.getPrénom())).
    add(new Label(String.valueOf(u.getAge()))).
         add(new Label(u.getEmail()));
}
Container c5 = new Container();
String [] list = new String [200] ;

int i = 0;
for(Utilisateur u : ServiceUser.getInstance().getAlluser())
{
   list[i]=""+u.getId_utilisateur()+"";
   i++;
    
}

 


AutoCompleteTextField act = new AutoCompleteTextField(list);
act.addActionListener(e -> ToastBar.showMessage("You picked " + act.getText(), FontImage.MATERIAL_INFO));
Button down = new Button();
System.out.println(act.getText());
FontImage.setMaterialIcon(down, FontImage.MATERIAL_KEYBOARD_ARROW_DOWN);
hi.add(
        BorderLayout.center(act).
                add(BorderLayout.EAST, down));
down.addActionListener(e -> act.showPopup());

Button b = new Button("delete");
b.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
         if(new ServiceUser().deleteUser(Integer.parseInt(act.getText())))
     {
     Dialog.show("Sucess","Conenction accepted ",new Command("OK"));
     
     }
     else 
     {
    Dialog.show("Error","Server Error",new Command("OK"));     
     }
    }
});
hi.add(b);

     getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );
     addAll(hi);
     
        
    }
    

}
