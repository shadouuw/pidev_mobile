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
public class Homeform  extends Form{
   Form current; 
    public Homeform(Form previous)
            { this.setUIID("Form1");
                current = this;
                 this.setUIID("Form1");
                setTitle("Cours");
                setLayout(BoxLayout.y());
                add(new Label("Choose an option "));
                Button btn_add = new Button("Add course ");
                Button btn_show = new Button("Show courses");
               Button btn_modify = new Button("Modify courses");
                btn_add.addActionListener(e -> new AddCourseForm(current).show());
                btn_show.addActionListener(e -> {
                    try {
                        new ListTaskForm(current).show();
                    } catch (IOException ex) {
                       
                    }
                });
                addAll(btn_add,btn_show,btn_modify);
                 getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );
                
                
                
            }
    
    
}
