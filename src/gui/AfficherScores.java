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
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.table.TableLayout;
import entities.Jeu;
import entities.Scores;
import services.ServiceJeu;
import gui.Ajouterjeux;
import services.ServiceScore;
import gui.statscore;


/**
 *
 * @author asus
 */
public class AfficherScores extends Form {
    int i=0;
    Form previous;
    Form current=this;
    public AfficherScores() {
          super("Score", BoxLayout.y());
         /* 
            ImageViewer client = null;
       try {
            client = new ImageViewer(Image.createImage("/clientfront.png"));
        } catch (IOException ex) {

        }
      add(client);*/
        
          for(Scores d1 : new ServiceScore().afficherScore() )
         {
             i++;
         }
           
      
       Container n = new Container(BoxLayout.y());
        Form hi = new Form("TOPSCORES", new TableLayout(i,3));
            for(Scores d1 : new ServiceScore().afficherScore() )
         {
       hi.add(d1.getId_user()).
    add(Integer.toString(d1.getScore())).
 add(Integer.toString(d1.getId_jeux()));
        

    Stroke borderStroke = new Stroke(3, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 3);
       n.getAllStyles().setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
        
        n.getAllStyles().setMargin(10,0,35,35);

   
         }
                     Button stats = new Button("Stats");
                     
                      stats.addActionListener((evt) -> {   new statscore(current).show(); });

          n.addAll(hi,stats);
               this.add(n);
            
                
       // .show();

        /*this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
           previous.showBack();*/
        
    
       
    }
}
    

