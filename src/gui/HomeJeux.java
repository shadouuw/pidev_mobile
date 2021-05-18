/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;


/**
 *
 * @author houss
 */
public class HomeJeux  extends Form{
   Form current; 
    public HomeJeux()
            {
                current = this;
                setTitle("Games");
                setLayout(BoxLayout.y());
                add(new Label("Choose an option "));
                Button btn_add = new Button("Add game ");
                Button btn_show = new Button("Show game");
               Button btn_modify = new Button("Modify game");
                btn_add.addActionListener(e -> new Ajouterjeux(current).show());
                btn_show.addActionListener(e -> new Afficherjeux(current).show());
                 btn_modify.addActionListener(e -> new Modifierjeux(current).show());
                addAll(btn_add,btn_show/*,btn_modify*/);
              //   getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );
              

                
                
            }
    
    
}
