/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.reclamation;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.ServiceReclamation;
import com.mycompany.myapp.services.ServiceReclamation.RequestResultStatus;

/**
 *
 * @author mohamedbrahem
 */
public class ReclamationForm extends Form {
    /**********************************************************************
     ---------------------------Public functions ---------------------------
     **********************************************************************/
    
    public ReclamationForm() {
     {  
     setTitle("Add a new Reclamation :");
     
     setLayout(BoxLayout.y());
     
     TextField mContentTxt = new TextField("","Cotenu", 500, TextArea.ANY);
     
     TextField mEmailTxt = new TextField("","Email", 100, TextArea.EMAILADDR);
     
     TextField mTelephoneTxt = new TextField("","Telephone", 11, TextArea.ANY);
     
     TextField mEtatTxt = new TextField("","Etat", 100, TextArea.ANY);

     TextField mTypeTxt = new TextField("","Type", 100, TextArea.ANY);

     Button mSendBtn = new Button("Send Reclamation");
     
     mSendBtn.addActionListener(new ActionListener()
    {
       @Override
       public void actionPerformed(ActionEvent evt) {
           
       if (AllFieldsAreComplete(
               mContentTxt.toString(),
               mEmailTxt.toString(),
               mTelephoneTxt.toString(),
               mEtatTxt.toString(),
               mTypeTxt.toString()
       )) {
           
       // TODO replace 123 with the current/active user id.
       Reclamation reclamation = new Reclamation(
               123,
               mContentTxt.getText(),
               mEmailTxt.getText(),
               Integer.parseInt(mTelephoneTxt.getText()),
               mEtatTxt.getText(),
               mTypeTxt.getText()
       );
       
         if (ServiceReclamation.instance.addNewReclamation(reclamation) == RequestResultStatus.Success) {
       
             showSuccessfullDialogMsg();
             
             // Send a mail as a confirmation for the successful Reclamation.
             ServiceReclamation.instance.SendReclamationMail();
             
         } else {
             
           showFailedDialogMsg();
           
         }
       } else {
           showMissingInputDialogMsg();
       } 
     }
    });
        
    addAll(mContentTxt, mEmailTxt, mTelephoneTxt, mEtatTxt, mTypeTxt, mSendBtn);     
    }
  }
    /**********************************************************************
    ---------------------------Private functions ---------------------------
    **********************************************************************/
    
    private boolean AllFieldsAreComplete(
            String mContentInput,
            String mEmailTxt,
            String mTelephoneTxt,
            String mEtatTxt,
            String mTypeTxt){        
        
        return  !mContentInput.isEmpty() &&
                !mEmailTxt.isEmpty()     &&
                !mTelephoneTxt.isEmpty() &&
                !mEtatTxt.isEmpty()      &&
                !mTypeTxt.isEmpty();
    }
    
    private void showSuccessfullDialogMsg(){
        Dialog.show("Success","Your Reclamation was well received, Thank you for your feedback! ",new Command("Bye"));
    }
    
    private void showFailedDialogMsg(){
        Dialog.show("Failed","We are occuring some technical issue right now, please try again later",new Command("Ok"));
    }
    
    private void showMissingInputDialogMsg(){
         Dialog.show("Failed","Please make sure that all fields are not Emtpy! ",new Command("Continue"));  
    }
}

