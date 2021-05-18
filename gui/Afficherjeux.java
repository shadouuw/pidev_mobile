/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Stroke;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import entities.Jeu;
import services.ServiceJeu;
import gui.Ajouterjeux;


/**
 *
 * @author asus
 */
public class Afficherjeux extends Form {
    
    public Afficherjeux(Form previous) {
          super("Jeux", BoxLayout.y());
         /* 
            ImageViewer client = null;
       try {
            client = new ImageViewer(Image.createImage("/clientfront.png"));
        } catch (IOException ex) {

        }
      add(client);*/
        
        
           
        
        for(Jeu d1 : new ServiceJeu().afficherJeu() )
         { Container n = new Container(BoxLayout.y());
           SpanLabel  lieud =  new SpanLabel ("Titre: "+ d1.getTitre()) ;
           SpanLabel lieua = new SpanLabel ("Description: "+d1.getDescription());
           SpanLabel region =  new SpanLabel("Source: "+d1.getSource());
           SpanLabel periode= new SpanLabel ("Difficulty : "+d1.getDiff());
           SpanLabel dated =  new SpanLabel("Cours: "+d1.getCours());
        
        
      
     
          n.addAll(lieud, lieua ,region , periode , dated );
    Stroke borderStroke = new Stroke(3, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 3);
       n.getAllStyles().setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
        
        n.getAllStyles().setMargin(10,0,35,35);
       this.add(n);
            
       // Stroke borderStroke = new Stroke(3, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 3);
       Button Delete2 = new Button("Delete  ");
      /*  Delete2.getAllStyles().setBgColor(0xFF0000);
        Delete2.getAllStyles().setBgTransparency(200);
        Delete2.getAllStyles().setFgColor(0xFFFFFF);
        Delete2.getAllStyles().setBorder(RoundRectBorder.create().
        strokeColor(0xFFFFFF).
        strokeOpacity(120).
        stroke(borderStroke));
        Delete2.getAllStyles().setAlignment(CENTER);*/
        Delete2.getAllStyles().setMargin(0,20,0,0);
      
               Button Update = new Button("Update  ");
        Update.getAllStyles().setBgColor(0xFF0000);
        Update.getAllStyles().setBgTransparency(200);
       Update.getAllStyles().setFgColor(0xFFFFFF);
       Update.getAllStyles().setBorder(RoundRectBorder.create().
        strokeColor(0xFFFFFF).
        strokeOpacity(120).
        stroke(borderStroke));
   
                
            
            
        
        
       Delete2.addActionListener((e)->
                {
                    System.out.println("getID="+d1.getId());
                    System.out.println("test="+ new ServiceJeu().supprimerjeu(d1.getId()));
               if(new  ServiceJeu().supprimerjeu(d1.getId()))
               { Dialog.show("Sucess","Game deleted",new Command("OK"));
  
               }
                   else
                        Dialog.show("Fail","delete failed",new Command("OK"));
             
                
                
                });
       
            Update.addActionListener((e)->
                {
                    System.out.println("getID="+d1.getId());
                    System.out.println("test="+ new ServiceJeu().modifierJeu(d1));
               new  ServiceJeu().modifierJeu(d1);
              
                
                
                });
                
                
           
     
          addAll(Delete2); 
              getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );
         }
        
        
       // .show();

        /*this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
           previous.showBack();*/
        
    
       
    }
}
    

