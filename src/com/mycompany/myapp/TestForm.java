/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

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
public class TestForm extends Form {
   Form current;  
    public TestForm(Form previous)
            {
                current = this;
                 this.setUIID("Form1");
                setTitle("Tests");
                setLayout(BoxLayout.y());
                add(new Label("Choose an option "));
                Button btn_add = new Button("Add Test ");
                Button btn_show = new Button("Show Test");
               Button btn_modify = new Button("Modify Mark");
                btn_add.addActionListener(e -> new AddTestForm(current).show());
                btn_show.addActionListener(e -> {
                    try {
                        new ListTestForm(current).show();
                    } catch (IOException ex) {
                       
                    }
                });
                addAll(btn_add,btn_show,btn_modify);
                 getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );
                
                
                
            }
    
}
