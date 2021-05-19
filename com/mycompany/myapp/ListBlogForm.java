/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.mycompany.myapp.entities.Cours;
import com.mycompany.myapp.services.ServiceCours;
import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.table.TableModel;
import com.mycompany.myapp.entities.Blog;
import com.mycompany.myapp.services.ServiceBlog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author houss
 */
public class ListBlogForm extends Form{
  
    public ListBlogForm(Form previous) throws IOException
    {

         setTitle("List courses ");



Form hi = new Form();

this.setUIID("Form1");

    ArrayList<Blog> List=new ServiceBlog().getAllBlog();
    String tab[][] =new String[100][10];
    
    for(int i=0;i < List.size() ;i++)
    {
        tab[i][0]=String.valueOf(List.get(i).getId());
       tab[i][1]=List.get(i).getNom();
       tab[i][2]=List.get(i).getNomAdmin();
         tab[i][3]=List.get(i).getDesciption();
          tab[i][4]=String.valueOf(List.get(i).getDatepostule());
    }
    
 TableModel model = new DefaultTableModel(new String[] {"Id", "Course name", "Domain" ,"Photo link","Word Link"}, tab) {
        public boolean isCellEditable(int row, int col) {
            return col != 0;
        }
    };
 
Table table = new Table(model){
    @Override
    protected Component createCell(Object value, int row, int column, boolean editable) { // (1)
        Component cell;
        if(row == 1 && column == 1) { // (2)
            Picker p = new Picker();
            p.setType(Display.PICKER_TYPE_STRINGS);
            p.setStrings("Row B can now stretch", "This is a good value", "So Is This", "Better than text field");
            p.setSelectedString((String)value); // (3)
            p.setUIID("TableCell");
            p.addActionListener((e) -> getModel().setValueAt(row, column, p.getSelectedString())); // (4)
            cell = p;
        } else {
            cell = super.createCell(value, row, column, false);
              
        }
        if(row > -1 && row % 2 == 0) { // (5)

        }
        return cell;
    }
       @Override
    protected TableLayout.Constraint createCellConstraint(Object value, int row, int column) {
        TableLayout.Constraint con =  super.createCellConstraint(value, row, column);
      
        con.setWidthPercentage(20);
    
                
        
        return con;
    }
};
 EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(this.getWidth(), this.getHeight(), 0xffffffff), true);
                Image img;
                 ScaleImageLabel sl = new ScaleImageLabel();

   img = URLImage.createToStorage(placeholder,"http://localhost/FirstProject/Public/facilities-2.png","http://localhost/FirstProject/Public/facilities-2.png",
                URLImage.RESIZE_SCALE);

 
table.setPreferredW(500);

table.setScrollableY(true);
hi.add(table);

String [] list = new String [200] ;

int i = 0;
for(Blog c : ServiceBlog.getInstance().getAllBlog())
{
   list[i]=""+c.getId()+"";
   i++;
    
}

 
    String[] characters = { "Tyrion Lannister", "Jaime Lannister", "Cersei Lannister", "Daenerys Targaryen",
    "Jon Snow" /* cropped */
};


AutoCompleteTextField act = new AutoCompleteTextField(list);
act.addActionListener(e -> ToastBar.showMessage("You picked " + act.getText(), FontImage.MATERIAL_INFO));
Button down = new Button();
System.out.println(act.getText());
FontImage.setMaterialIcon(down, FontImage.MATERIAL_KEYBOARD_ARROW_DOWN);
hi.add(
        BorderLayout.center(act).
                add(BorderLayout.EAST, down));
down.addActionListener(e -> act.showPopup());

Button b = new Button("delete");
b.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
         if(new ServiceCours().deleteCours(Integer.parseInt(act.getText())))
     {
     Dialog.show("Sucess","Conenction accepted ",new Command("OK"));
     
     }
     else 
     {
    Dialog.show("Error","Server Error",new Command("OK"));     
     }
    }
});

hi.add(b);

     getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );
     addAll(hi);
   
        
    }
     

}
