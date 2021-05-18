/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.codename1.uikit.pheonixui;

import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.mycompany.myapp.MainHome;
import com.mycompany.myapp.entities.Utilisateur;
import com.mycompany.myapp.services.ServiceCours;
import com.mycompany.myapp.services.ServiceUser;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * GUI builder created Form
 *
 * @author Shai Almog
 */
public class SignUpForm extends com.codename1.ui.Form {

    static public Utilisateur user;
    
    public SignUpForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public SignUpForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

 
        getToolbar().getTitleComponent().setUIID("SigninTitle");
 FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, "SigninTitle", 3.5f);
        getToolbar().addCommandToLeftBar("", mat,e -> {    new SignInForm().show();});
        
             mat.addActionListener(e -> {
               new SignInForm().show();
               System.out.println("hi");
             });
             
        getContentPane().setUIID("SignInForm");
        gui_Text_Field_1.setText("Password");
         gui_Text_Field_2.setText("Username");
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
      TextField nom=new TextField ("","Name");
               TextField Surname=new TextField ("");
                 TextField Age=new TextField ("");
                  TextField Email=new TextField ("");
                  TextField Photo=new TextField ("");


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_2.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if(sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Button_2) {
                try {
                    onButton_2ActionEvent(ev);
                } catch (IOException ex) {
   
                } catch (URISyntaxException ex) {
              
                }
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Register");
     
        setName("SignUpForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
          gui_Component_Group_1.addComponent(nom); gui_Component_Group_1.addComponent(Surname);
          gui_Component_Group_1.addComponent(Age);
          gui_Component_Group_1.addComponent(Email);
          gui_Component_Group_1.addComponent(Photo);
        gui_Component_Group_1.addComponent(gui_Text_Field_1);
       
         
        gui_Text_Field_2.setText("TextField");
        gui_Text_Field_2.setName("Text_Field_2");
   
        gui_Text_Field_1.setText("TextField");
         Email.setUnselectedStyle(gui_Text_Field_2.getUnselectedStyle());
                  Email.setSelectedStyle( gui_Text_Field_2.getUnselectedStyle());
                    Photo.setUnselectedStyle(gui_Text_Field_2.getUnselectedStyle());
                  Photo.setSelectedStyle( gui_Text_Field_2.getUnselectedStyle());
               Age.setUnselectedStyle(gui_Text_Field_2.getUnselectedStyle());
                  Age.setSelectedStyle( gui_Text_Field_2.getUnselectedStyle());
          Surname.setUnselectedStyle(gui_Text_Field_2.getUnselectedStyle());
                  Surname.setSelectedStyle( gui_Text_Field_2.getUnselectedStyle());
        nom.setUnselectedStyle(gui_Text_Field_2.getUnselectedStyle());
                   nom.setSelectedStyle( gui_Text_Field_2.getUnselectedStyle());
            gui_Text_Field_2.setSelectedStyle( gui_Text_Field_2.getUnselectedStyle());
            Surname.setText("Surname");
            nom.setText("Name");
            Age.setText("Age");
            Email.setText("Email");
            Photo.setText("Photo");
     gui_Text_Field_1.setSelectedStyle( gui_Text_Field_1.getUnselectedStyle());
        gui_Text_Field_1.setName("Text_Field_1");
        gui_Container_1.addComponent(gui_Button_2);
     
        gui_Label_1.setUIID("CenterLabel");
        gui_Label_1.setName("Label_1");
        gui_Label_1.setIcon(resourceObjectInstance.getImage("profile_image.png"));
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Button_2.setText("Sign up");
        gui_Button_2.setName("Button_2");
        gui_Button_3.setText("Forgot Your Password ?");
        gui_Button_3.setUIID("CenterLabelSmall");
        gui_Button_3.setName("Button_3");

        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Button_1.setText("Create New Account");
        gui_Button_1.setUIID("CenterLabel");
        gui_Button_1.setName("Button_1");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) throws IOException, URISyntaxException {
          BCryptPasswordEncoder b=new  BCryptPasswordEncoder();
ArrayList<Utilisateur> list=new ServiceUser().getAlluser();
String pass="";

 Utilisateur u = new Utilisateur( gui_Text_Field_2.getText(),b.encode(gui_Text_Field_1.getText()),nom.getText(),Surname.getText(),Integer.parseInt(Age.getText()),Email.getText(),Photo.getText());    
     if(new ServiceUser().addUser(u))
     {

      

     Dialog.show("Sucess","Register was a success ",new Command("OK"));
     new SignInForm().show();
     
     }
     else 
     {
    Dialog.show("Error","Register error",new Command("OK"));     
     }
         }
        


    }


