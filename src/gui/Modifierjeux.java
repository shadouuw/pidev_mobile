/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import entities.Jeu;
import static java.lang.Integer.parseInt;
import services.ServiceJeu;

/**
 *
 * @author asus
 */
public class Modifierjeux extends Form {
    
     public Modifierjeux(Form previous) {
         
         super("update", BoxLayout.y());
    TextField titre= new TextField("", "Titre");
        TextField description= new TextField("", "description"); 
         TextField source= new TextField("", "source");
          TextField cours= new TextField("", "cours");
           TextField topscore= new TextField("", "topscore");
            TextField diff= new TextField("", "diff");
            Button btn = new Button("Add a Request ");
        Stroke borderStroke = new Stroke(3, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 3);
         btn.getAllStyles().setBgColor(0x008000);
        btn.getAllStyles().setBgTransparency(200);
        btn.getAllStyles().setFgColor(0xFFFFFF);
        btn.getAllStyles().setBorder(RoundRectBorder.create().
        strokeColor(0xFFFFFF).
        strokeOpacity(120).
        stroke(borderStroke));
        btn.getAllStyles().setAlignment(CENTER);
        btn.getAllStyles().setMargin(10,0,250,300);
        
        this.addAll(titre,description,source,cours,topscore,diff,btn);
              getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );
          btn.addActionListener((evt) -> {
                                Jeu   aj= new Jeu(titre.getText(), description.getText(),parseInt(cours.getText()),diff.getText(),topscore.getText(),source.getText());
                                System.out.println("aj="+aj);
                                new ServiceJeu().modifierJeu(aj);
                       
                  

            });
}

   
     
}
