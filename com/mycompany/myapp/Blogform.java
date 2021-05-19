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
import com.codename1.uikit.pheonixui.InboxForm2;
import com.codename1.uikit.pheonixui.chart;

import java.io.IOException;
import java.net.URISyntaxException;


/**
 *
 * @author houss
 */
public class Blogform extends Form {
  public Form current;  
    public Blogform(Form previous)
            {
                current = this;
                 this.setUIID("Form1");
                setTitle("Blogs");
                setLayout(BoxLayout.y());
                add(new Label("Choose an option "));
                Button btn_add = new Button("Add Blog ");
                Button btn_show = new Button("Show Blogs");
               Button btn_modify = new Button("Show stats");
                btn_add.addActionListener(e -> new AddBlogForm(current).show());
                btn_show.addActionListener(e -> {
                    try {
                        new ListBlogForm(current).show();
                    } catch (IOException ex) {
                       
                    }
                });
                        btn_modify.addActionListener(e1 -> {
                    
                          chart f=  new chart();
                          Form f1=f.createPieChartForm();
                    f1.setUIID("Form1");
                    f1.show();
                    
                 
                });
                addAll(btn_add,btn_show,btn_modify);
                 getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev ->{
                    try { 
                        new InboxForm2().show();
                    } catch (IOException ex) {
              
                    } catch (URISyntaxException ex) {
                        
                    }
                 });
                 }
                
                
                
            }
    


