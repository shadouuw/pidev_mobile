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

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.TextField;
import com.gtranslate.Language;
import com.mycompany.myapp.ListTaskForm;
import com.mycompany.myapp.MainHome;
import com.mycompany.myapp.entities.Utilisateur;
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
public class SignInForm extends com.codename1.ui.Form {

    static public Utilisateur user;
    static public String language;
    static public String changing_language;
    static public String current_language=Language.ENGLISH;
    public Command r;
    
    public SignInForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    
    public SignInForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        
        initGuiBuilderComponents(resourceObjectInstance);
        language=Language.ARABIC;
        changing_language="Language";
        
        
       String s=GoogleTTS_Translate.google_Translate(Language.ARABIC,"hello");
       System.out.println(s);
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
           FontImage mat2 = FontImage.createMaterial(FontImage.MATERIAL_LANGUAGE, "SigninTitle", 3.5f);
           
         getToolbar().addCommandToLeftBar("", mat, e -> System.exit(0) );
        
          r=getToolbar().addCommandToRightBar(changing_language, mat2, ev -> 
        {        
            getToolbar().closeRightSideMenu();
            if(changing_language.equals("Arabic"))
            {
                getToolbar().setTitle(GoogleTTS_Translate.google_Translate(language,"Sign In"));
                gui_Button_2.setText(GoogleTTS_Translate.google_Translate(language,gui_Button_2.getText()) );
                  gui_Button_3.setText(GoogleTTS_Translate.google_Translate(language,gui_Button_3.getText()) );
                 gui_Button_1.setText(GoogleTTS_Translate.google_Translate(language,gui_Button_1.getText()) );
       changing_language="English";
     current_language=Language.ARABIC;
       language=Language.ENGLISH;
            }
            else
            {   getToolbar().setTitle(GoogleTTS_Translate.google_Translate(language,GoogleTTS_Translate.google_Translate(language,"Sign In")));
                gui_Button_2.setText(GoogleTTS_Translate.google_Translate(language,gui_Button_2.getText()) );
                 gui_Button_3.setText(GoogleTTS_Translate.google_Translate(language,gui_Button_3.getText()) );
                 gui_Button_1.setText(GoogleTTS_Translate.google_Translate(language,gui_Button_1.getText()) );
                   gui_Text_Field_2.setText(GoogleTTS_Translate.google_Translate(language,gui_Text_Field_2.getText()) );
    language=Language.ARABIC;
         current_language=Language.ENGLISH;
        changing_language="Arabic";
                
            }
        
        });
       
        System.out.println(SignInForm.current_language);
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
                } catch (IOException | URISyntaxException ex) {
   
                }
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Sign In");
        setName("SignInForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
        gui_Component_Group_1.addComponent(gui_Text_Field_1);
        gui_Text_Field_2.setText("TextField");
        gui_Text_Field_2.setName("Text_Field_2");
          gui_Text_Field_1.setConstraint(TextField.PASSWORD);
        gui_Text_Field_1.setText("TextField");
            gui_Text_Field_2.setSelectedStyle( gui_Text_Field_2.getUnselectedStyle());
     gui_Text_Field_1.setSelectedStyle( gui_Text_Field_1.getUnselectedStyle());
        gui_Text_Field_1.setName("Text_Field_1");
        gui_Container_1.addComponent(gui_Button_2);
        gui_Container_1.addComponent(gui_Button_3);
        gui_Label_1.setUIID("CenterLabel");
        gui_Label_1.setName("Label_1");
        gui_Label_1.setIcon(resourceObjectInstance.getImage("profile_image.png"));
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Button_2.setText("Sign In");
        gui_Button_2.setName("Button_2");
        gui_Button_3.setText("Forgot Your Password ?");
        gui_Button_3.setUIID("CenterLabelSmall");
        gui_Button_3.setSelectedStyle(gui_Button_3.getUnselectedStyle());
        gui_Button_3.setName("Button_3");
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Button_1.setText("You don't have an account ?");
        gui_Button_1.setUIID("CenterLabel");
        gui_Button_1.setName("Button_1");
        
          gui_Button_3.addActionListener(e -> {
                 new ForgetPassForm().show();
                });
           gui_Button_1.addActionListener(e -> {
                 new SignUpForm().show();
                });
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) throws IOException, URISyntaxException {
          BCryptPasswordEncoder b=new  BCryptPasswordEncoder();
ArrayList<Utilisateur> list=new ServiceUser().getAlluser();
String pass="";
int role = 0;
System.out.println(list);
for(Utilisateur u : list)
{
 if(u.getNom_utilisateur().equals(gui_Text_Field_2.getText()))
 {
     user=u;
     pass=u.getMot_de_passe();
     role=u.getRole();
     System.out.println(u.getRole());
       
 }
    
 
}
System.out.println(pass);
           

      
char[] myNameChars2 = pass.toCharArray();
myNameChars2[2] = 'a';
pass= String.valueOf(myNameChars2);
System.out.println(b.matches(gui_Text_Field_1.getText(), pass));
if(b.matches(gui_Text_Field_1.getText(), pass))
{
    System.out.println(role);
    if(user.getRole() == 3)    
    {
new InboxForm2().show();
    }
    else
    {
        new InboxForm().show();
    }
}
    }

}
