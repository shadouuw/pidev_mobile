/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.spinner.Picker;
import entities.Jeu;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import services.ServiceJeu;

/**
 *
 * @author asus
 */
public class Ajouterjeux extends Form {
    
     public Ajouterjeux(Form previous) {
         super("Add a new Request", BoxLayout.y());
         int x=0;
     int i=0;
    ArrayList<String> verif = new ArrayList<String>();
     for(Jeu d1 : new ServiceJeu().afficherJeu() )
{    
    if(!verif.contains(Integer.toString(d1.getCours())))
    {verif.add(Integer.toString(d1.getCours()));
   x++;}
   
}
         System.out.println("x="+x);
     String[] s=new String[x];
         for(String str:verif)
{    

 s[i]=str;
    System.out.println("s'"+i+"="+s[i]);
    i++;
}

 
    TextField titre= new TextField("", "Titre");
        TextField description= new TextField("", "description"); 
            TextField source= new TextField("", "source");
          Button sourcex = new Button("Add Image ");
         TextField cours= new TextField("", "cours");
           TextField topscore= new TextField("", "topscore");
            TextField diff= new TextField("", "diff");
            
            sourcex.addActionListener((ActionEvent evt) -> {
  Display.getInstance().openImageGallery((ActionListener) (ActionEvent ev) -> {
      System.out.println("1"+((String) ev.getSource()).substring(((String) ev.getSource()).lastIndexOf('/') + 1));
     
            source.setText(((String) ev.getSource()).substring(((String) ev.getSource()).lastIndexOf('/') + 1));
  });});
Picker p = new Picker();

p.setStrings(s);

p.addActionListener(e -> ToastBar.showMessage("You picked " + p.getSelectedString(), FontImage.MATERIAL_INFO));

            Button btn = new Button("Add a Request ");
        Stroke borderStroke = new Stroke(3, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 3);
       /*  btn.getAllStyles().setBgColor(0x008000);
        btn.getAllStyles().setBgTransparency(200);
        btn.getAllStyles().setFgColor(0xFFFFFF);
        btn.getAllStyles().setBorder(RoundRectBorder.create().
        strokeColor(0xFFFFFF).
        strokeOpacity(120).
        stroke(borderStroke));
        btn.getAllStyles().setAlignment(CENTER);
        btn.getAllStyles().setMargin(10,0,250,300);*/
        
        this.addAll(titre,description,source,sourcex,p,topscore,diff,btn);
              getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );
          btn.addActionListener((evt) -> {
                                Jeu   aj= new Jeu(titre.getText(), description.getText(),parseInt(p.getSelectedString()),diff.getText(),topscore.getText(),source.getText());
                                System.out.println("aj="+aj);
                               if( new ServiceJeu().ajouterJeu(aj))
                               {
                                    Dialog.show("Sucess","Game added",new Command("OK"));
                                    new HomeJeux().show();
                               }
                               else
                                      Dialog.show("Error","There is a problem ! /n game isnt added",new Command("OK"));
                       
                  

            });
}

   
     
}
