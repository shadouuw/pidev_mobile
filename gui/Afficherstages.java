/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Stroke;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import entities.Stages;
import services.ServiceJeu;
import services.ServiceStage;


/**
 *
 * @author asus
 */
public class Afficherstages extends Form {
  
    public Afficherstages(Form previous) {
          super("Stages", BoxLayout.y());
         /* 
            ImageViewer client = null;
       try {
            client = new ImageViewer(Image.createImage("/clientfront.png"));
        } catch (IOException ex) {

        }
      add(client);*/
        
        
        
        
        for(Stages d1 : new ServiceStage().afficherStages() )
         { Container n = new Container(BoxLayout.y());
         
           SpanLabel  lieud =  new SpanLabel ("Numero: "+ d1.getNumero()) ;
           SpanLabel lieua = new SpanLabel ("Texte: "+d1.getTexte());
           SpanLabel region =  new SpanLabel("Essai: "+d1.getEssai());
           SpanLabel periode= new SpanLabel ("Correction: "+d1.getCorrection());
           SpanLabel dated =  new SpanLabel("Source: "+d1.getSource());
                   SpanLabel tmp =  new SpanLabel("Temps: "+d1.getTemps());
                              SpanLabel jeu =  new SpanLabel("Jeu: "+d1.getJeu());
        
      
             System.out.println(d1.getId());
          n.addAll(lieud, lieua ,region , periode , dated,tmp,jeu);
    Stroke borderStroke = new Stroke(3, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 3);
       n.getAllStyles().setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
        
        n.getAllStyles().setMargin(10,0,35,35);
       this.add(n);
            
       // Stroke borderStroke = new Stroke(3, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 3);
       Button Delete = new Button("Delete  ");
        /*Delete.getAllStyles().setBgColor(0xFF0000);
        Delete.getAllStyles().setBgTransparency(200);
        Delete.getAllStyles().setFgColor(0xFFFFFF);
        Delete.getAllStyles().setBorder(RoundRectBorder.create().
        strokeColor(0xFFFFFF).
        strokeOpacity(120).
        stroke(borderStroke));
        Delete.getAllStyles().setAlignment(CENTER);
        Delete.getAllStyles().setMargin(10,0,250,300);*/
            
               Button Update = new Button("Update  ");
        Update.getAllStyles().setBgColor(0xFF0000);
        Update.getAllStyles().setBgTransparency(200);
       Update.getAllStyles().setFgColor(0xFFFFFF);
       Update.getAllStyles().setBorder(RoundRectBorder.create().
        strokeColor(0xFFFFFF).
        strokeOpacity(120).
        stroke(borderStroke));
   
                
            
            
        
        
       Delete.addActionListener((e)->
                {
                    System.out.println("getID="+d1.getId());
                  //  System.out.println("test="+ new ServiceJeu().supprimerjeu(d1.getId()));
              if( new  ServiceStage().supprimerstage(d1.getId()))
              { Dialog.show("Sucess","Stage deleted",new Command("OK"));
                                                   new HomeJeux().show();}

              else
                   Dialog.show("Fail","Delete failed",new Command("OK"));
              
            //  new  Afficherstages().previous.show();
                
                
                });
       
            Update.addActionListener((e)->
                {
                    System.out.println("getID="+d1.getId());
                  //  System.out.println("test="+ new ServiceJeu().modifierJeu(d1));
            //   new  ServiceJeu().modifierJeu(d1);
            //  new  Afficherstages().previous.show();
                
                
                });
                
                
           
     
          addAll(Delete); 
         }
        
        
       // .show();

        this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
           previous.showBack();
        });
    }
}
    