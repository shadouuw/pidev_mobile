/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;

/**
 *
 * @author houss
 */
public class MainHome extends Form {
    Form current;
      public MainHome()
            {
         
                current = this;
                setTitle("Menu");
                setLayout(BoxLayout.y());
                add(new Label("Choose an option "));
                Button btn_cours = new Button("Cours ");
                Button btn_user = new Button("Users");
                Button btn_test = new Button("Tests");
          Button btn_class = new Button("Classes");
                btn_cours.addActionListener(e -> new Homeform(current).show());
                btn_user.addActionListener(e -> {
                    new Userform(current).show();
                });
               
                 btn_test.addActionListener(e -> new TestForm(current).show());
                  btn_test.addActionListener(e -> new ClassForm(current).show());
                addAll(btn_cours,btn_user,btn_test,btn_class);
                
                
    
}
      
}
