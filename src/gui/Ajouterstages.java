/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.spinner.Picker;
import entities.Stages;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import services.ServiceJeu;
import services.ServiceStage;

/**
 *
 * @author asus
 */
public class Ajouterstages extends Form {
   Form current;
     public Ajouterstages(  Form previous) {
         
         super("Add Stage", BoxLayout.y());
    TextField numero= new TextField("", "numero");
        TextField texte= new TextField("", "texte"); 
         TextField essai= new TextField("", "essai");
          TextField correction= new TextField("", "correction");
           TextField source= new TextField("", "source");
            TextField temps= new TextField("", "temps");
                TextField jeu= new TextField("", "jeu");
            Button btn = new Button("Add Stage ");
      
        
        
        
        
              int x=0;
     int i=0;
    ArrayList<String> verif = new ArrayList<String>();
     for(Stages d1 : new ServiceStage().afficherStages() )
{    
    if(!verif.contains(Integer.toString(d1.getJeu())))
    {verif.add(Integer.toString(d1.getJeu()));
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
 Picker p = new Picker();

p.setStrings(s);

p.addActionListener(e -> ToastBar.showMessage("You picked " + p.getSelectedString(), FontImage.MATERIAL_INFO));       
        
        
        
        
        this.addAll(numero,texte,essai,correction,source,temps,p,btn);
                      getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );

          btn.addActionListener((evt) -> {
                                Stages   aj= new Stages(parseInt(numero.getText()),texte.getText(),essai.getText(),correction.getText(),source.getText(),parseInt(temps.getText()),parseInt(jeu.getText()));
                                System.out.println("aj="+aj);
                                
                               if(new ServiceStage().ajouterStage(aj))
                               {
                                    Dialog.show("Sucess","Stage added",new Command("OK")); 
                                     new HomeJeux().show();
                               }
                               else
                                   Dialog.show("Failed","addition failed",new Command("OK")); 
                       
                  

            });
}

   
     
}
