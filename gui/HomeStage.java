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
public class HomeStage  extends Form{
   Form current; 
    public HomeStage()
            {
                current = this;
                setTitle("Stages");
                setLayout(BoxLayout.y());
                add(new Label("Choose an option "));
                Button btn_add = new Button("Add stage ");
                Button btn_show = new Button("Show stage");
               Button btn_modify = new Button("Modify stage");
                btn_add.addActionListener(e -> new Ajouterstages(current).show());
                btn_show.addActionListener(e -> new Afficherstages(current).show());
                // btn_modify.addActionListener(e -> new Modifierjeux().show());
                addAll(btn_add,btn_show/*,btn_modify*/);
              //   getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );
              

                
                
            }
    
    
}
