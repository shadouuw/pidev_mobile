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

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.net.URISyntaxException;






/**
 * Utility methods common to forms e.g. for binding the side menu
 *
 * @author Shai Almog
 */
public class BaseForm extends Form {
    public void installSidemenu(Resources res) {
        Image selection = res.getImage("selection-in-sidemenu.png");
        
        Image inboxImage = null;
        if(isCurrentInbox()) inboxImage = selection;
        Image blogImage = null;
        if(isCurrentBlogs()) blogImage = selection;
        Image trendingImage = null;
        if(isCurrentTrending()) trendingImage = selection;
           Image coursesImage = null;
        if(isCurrentCourses()) coursesImage = selection;
        Image MarkImage  = null;
        if(isCurrentMarks()) MarkImage = selection;
        Image GameImage  = null;
         if(isCurrentGames()) GameImage = selection;
        Image statsImage = null;
        if(isCurrentStats()) statsImage = selection;
        
        Button inboxButton = new Button("Home", inboxImage);
        inboxButton.setUIID("SideCommand");
        inboxButton.getAllStyles().setPaddingBottom(0);
        Container inbox = FlowLayout.encloseMiddle(inboxButton, 
                new Label("Hi", "SideCommandNumber"));
        inbox.setLeadComponent(inboxButton);
        inbox.setUIID("SideCommand");
        inboxButton.addActionListener(e -> {
            try {
                new InboxForm().show();
            } catch (IOException ex) {
        
            } catch (URISyntaxException ex) {
        
            }
        });
        getToolbar().addComponentToSideMenu(inbox);
        
        getToolbar().addCommandToSideMenu("Courses", coursesImage, e -> {
            try {
                new CoursesForm(res).show();
            } catch (IOException ex) {
              
            }
        });
        getToolbar().addCommandToSideMenu("Blogs", blogImage , e -> {
            try {
                new BlogsForm(res).show();
            } catch (IOException ex) {
              
            }
        });
         
              getToolbar().addCommandToSideMenu("Marks",MarkImage, e -> {
                  try {
                      new MarksForm(res).show();
                  } catch (IOException ex) {
                
                  } catch (URISyntaxException ex) {
                   
                  }
              });
        
            
        
        getToolbar().addCommandToSideMenu("Classes", trendingImage, e -> new TrendingForm(res).show());
        getToolbar().addCommandToSideMenu("Games", GameImage, e ->{
            try {
                new GamesForm(res).show();
            } catch (IOException ex) {
                
            } catch (URISyntaxException ex) {
             
            }
        });
        
        // spacer
        getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
        getToolbar().addComponentToSideMenu(new Label(res.getImage("profile_image.png"), "Container"));
        getToolbar().addComponentToSideMenu(new Label("Magic Book", "SideCommandNoPad"));

    }

        
    protected boolean isCurrentInbox() {
        return false;
    }
    
    protected boolean isCurrentTrending() {
        return false;
    }

  protected boolean isCurrentMarks() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }
   protected boolean isCurrentCourses() {
        return false;
    }
    protected boolean isCurrentBlogs() {
        return false;
    }
    
      protected boolean isCurrentGames() {
        return false;
    }
}
