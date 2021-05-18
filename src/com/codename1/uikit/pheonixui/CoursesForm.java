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

import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.entities.Cours;
import com.mycompany.myapp.services.ServiceCours;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class CoursesForm extends BaseForm {

    public CoursesForm() throws IOException {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public CoursesForm(com.codename1.ui.util.Resources resourceObjectInstance) throws IOException {
        initGuiBuilderComponents(resourceObjectInstance);

        gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);
        
        ScaleImageLabel sl = new ScaleImageLabel(resourceObjectInstance.getImage("skate-park.jpg"));
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        gui_imageContainer1.add(BorderLayout.CENTER, sl);
        sl = new ScaleImageLabel(resourceObjectInstance.getImage("bridge.jpg"));
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        gui_imageContainer2.add(BorderLayout.CENTER, sl);
        
        installSidemenu(resourceObjectInstance);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        
        FontImage.setMaterialIcon(gui_LA, FontImage.MATERIAL_LOCATION_ON);
        gui_LA.setIconPosition(BorderLayout.EAST);

        FontImage.setMaterialIcon(gui_newYork, FontImage.MATERIAL_LOCATION_ON);
        gui_newYork.setIconPosition(BorderLayout.EAST);
        
        gui_Text_Area_2.setRows(2);
        gui_Text_Area_2.setColumns(100);
        gui_Text_Area_2.setGrowByContent(false);
        gui_Text_Area_2.setEditable(false);
        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setGrowByContent(false);
        gui_Text_Area_1.setEditable(false);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    private com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
    private com.codename1.ui.Container gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
    
    
    private com.codename1.ui.Container gui_null_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.components.MultiButton gui_null_1_1_1 = new com.codename1.components.MultiButton();
    private com.codename1.components.MultiButton gui_newYork = new com.codename1.components.MultiButton();
    private com.codename1.ui.Container gui_imageContainer2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_Label_1_1_1 = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) throws IOException {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Courses");
        setName("TrendingForm");
 EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(this.getWidth(), this.getHeight(), 0xffffffff), true);
                Image img;
                

 ScaleImageLabel sl = new ScaleImageLabel();

ArrayList<Container> list_container=new ArrayList<>();
ArrayList<Container> img_container = new ArrayList<>();
ArrayList<Container> list_container2=new ArrayList<>();
ArrayList<TextArea> text_area=new ArrayList<>();
ArrayList<MultiButton> multi_button=new ArrayList<>();
ArrayList<MultiButton> multi_button2 = new ArrayList<>();
ArrayList<Button> btn=new ArrayList<>();

ArrayList<Cours> list_cours=new ServiceCours().getAllCours();

for (int i=0;i<list_cours.size();i++)
    
{  
FileSystemStorage inst = FileSystemStorage.getInstance();
//Gets CN1 home`
final String homePath = inst.getAppHomePath();
final char sep = inst.getFileSystemSeparator();
// Getting input stream of the file
InputStream is = inst.openInputStream(homePath + sep +"ines.docx");
// CN1 Util class, readInputStream() returns byte array
byte[] b = Util.readInputStream(is);
String myString = new String(b);


    System.out.println(myString);
   btn.add(new com.codename1.ui.Button());
 list_container.add(new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout()));
 multi_button.add(new com.codename1.components.MultiButton());
  multi_button2.add(new com.codename1.components.MultiButton());
  list_container2.add(new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout()));
  img_container.add(new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout()));
  text_area.add(new com.codename1.ui.TextArea());

}

      

for(int j=0;j<list_cours.size();j++)
{

        addComponent(list_container.get(j));
        
        list_container.get(j).setName("Container_"+j+"");
        list_container.get(j).addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, multi_button.get(j));
        list_container.get(j).addComponent(com.codename1.ui.layouts.BorderLayout.EAST,multi_button2.get(j));
        multi_button.get(j).setUIID("SmallFontLabel");
        multi_button.get(j).setName("Multi_Button_1");

        multi_button.get(j).setPropertyValue("line1", list_cours.get(j).getNomCours());
  multi_button.get(j).setPropertyValue("line2", "@MagicbookCourses");
    multi_button.get(j).setPropertyValue("uiid1", "SmallFontLabel");
    multi_button.get(j).setPropertyValue("uiid2", "RedLabel");
       multi_button2.get(j).setUIID("Label");
         multi_button2.get(j).setName("LA"+j+"");
 multi_button2.get(j).setPropertyValue("line1","");
         multi_button2.get(j).setPropertyValue("line2", list_cours.get(j).getDomaine());
         multi_button2.get(j).setPropertyValue("uiid1", "SlightlySmallerFontLabel");
        multi_button2.get(j).setPropertyValue("uiid2", "RedLabel");
        addComponent( img_container.get(j));
        img_container.get(j).setName("imageContainer1");
         img_container.get(j).addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, list_container2.get(j));
        list_container2.get(j).setName("Container_2");
         list_container2.get(j).addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, text_area.get(j));
         list_container2.get(j).addComponent(com.codename1.ui.layouts.BorderLayout.EAST, btn.get(j));
       text_area.get(j).setText(list_cours.get(j).getDoc_file());
      text_area.get(j).setUIID("SmallFontLabel");
       text_area.get(j).setName("Text_Area_1");
       btn.get(j).setText("");
      btn.get(j).setUIID("Label");
       btn.get(j).setName("Button_1");
        com.codename1.ui.FontImage.setMaterialIcon(btn.get(j),"".charAt(0));
}
              
for(int j=0;j<list_cours.size();j++)
{
        
                img = URLImage.createToStorage(placeholder,"http://localhost/FirstProject/Public/"+list_cours.get(j).getLien(),"http://localhost/FirstProject/Public/"+list_cours.get(j).getLien(),
                URLImage.RESIZE_SCALE);
              sl = new ScaleImageLabel(img);
 sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
       img_container.get(j).add(BorderLayout.CENTER,img);  
}
        
     
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!

    @Override
   protected boolean isCurrentCourses() {
        return true;
    }
}
