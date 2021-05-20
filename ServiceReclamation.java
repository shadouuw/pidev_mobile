/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AbirBrahem
 */
public class ServiceReclamation {
   
   //TODO update the Base url when merging impl, otherwise -> Timeout Exception
    
   public static final String BASE_URL="http://localhost/FirstProject/public/index.php";

   public static ServiceReclamation instance;
   
   private ConnectionRequest dbConnectionRequest;
      
   public enum RequestResultStatus {
             Success,
             Failed,
             Pending;
   }
   
   private final int statusCodeSuccess = 200;
   
   private boolean requestResult = false;

   private ArrayList<Reclamation> reclamations = new ArrayList<Reclamation>();

   /**********************************************************************
    ---------------------------Public functions ---------------------------
    **********************************************************************/
   
   public ServiceReclamation() {
       
      // initialise connection request with DB 
      dbConnectionRequest = new ConnectionRequest();
   }
   
   public static ServiceReclamation getInstance()
           
    { // return current instance if not null, else create a new ServiceReclamation
        if(instance == null)
          instance = new ServiceReclamation();
        
        return instance;
    }
   
   /**********************************************************************
    --------------------------- DATABSE CRUD functions ---------------------------
    **********************************************************************/
   
   public RequestResultStatus addNewReclamation(Reclamation recalamation) {
       
    String addNewReclamationUrl = BASE_URL + "/add_reclamation? "
            + "id_reclamation=" + recalamation.getReclamationId()
            +"&content=" + recalamation.getContent()
            +"&id_utilisateur=" + recalamation.getUserID()
            +"&email=" + recalamation.getEmail()
            +"&telephone=" + recalamation.getTelephone()
            +"&etat=" + recalamation.getEtat()
            +"&type=" + recalamation.getType();
    
    dbConnectionRequest.setUrl(addNewReclamationUrl);
    
    dbConnectionRequest.addResponseListener((NetworkEvent evt) -> {
        
        requestResult = dbConnectionRequest.getResponseCode() == statusCodeSuccess;
        
    });
        
    NetworkManager.getInstance().addToQueueAndWait(dbConnectionRequest);       
      
    return true == requestResult ? RequestResultStatus.Success : RequestResultStatus.Failed;
   }
   
   
   public ArrayList<Reclamation> getAllReclamations(int userId) {
      
    String getAllReclamationsUrl = BASE_URL + "/reclamations"
            +"&userID=" + userId;
    
    dbConnectionRequest.setUrl(getAllReclamationsUrl);
    
    // Get Request -> setPost = false
    dbConnectionRequest.setPost(false);
    
    dbConnectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {
        @Override
        public void actionPerformed(NetworkEvent evt) {
            try {
                reclamations = parseAllReclamationsResponse(new String(dbConnectionRequest.getResponseData()));
                
                dbConnectionRequest.removeResponseListener((ActionListener<NetworkEvent>) evt);
                
            } catch (IOException ex) {
                
                System.out.println("Ops ! Exception occured with message : " + ex.getMessage());
                
            }        
        }
    });
        
    NetworkManager.getInstance().addToQueueAndWait(dbConnectionRequest);       
      
    return reclamations;
   }
   
   public RequestResultStatus SendReclamationMail()
    {
     String sendMailUrl = BASE_URL+"/mail_mobile";
     
     dbConnectionRequest.setUrl(sendMailUrl);
     
     dbConnectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {
         @Override
         public void actionPerformed(NetworkEvent evt) {
             
             requestResult = dbConnectionRequest.getResponseCode() == statusCodeSuccess; 
             
         }
     });
        
     NetworkManager.getInstance().addToQueueAndWait(dbConnectionRequest);
     
     return requestResult == true ? RequestResultStatus.Success : RequestResultStatus.Failed ;   
        
    } 
   
    /**********************************************************************
    --------------------------- Response Parser function ---------------------------
    **********************************************************************/
   
    
   public ArrayList<Reclamation> parseAllReclamationsResponse(String jsonText) throws IOException {
       
    ArrayList<Reclamation> reclamations = new ArrayList<Reclamation>();
       
    JSONParser parser = new JSONParser();
       
    Map<String,Object> reclamationListJson = parser.parseJSON(new CharArrayReader(jsonText.toCharArray()));
       
    List<Map<String,Object>> list = (List<Map<String,Object>>)reclamationListJson.get("root");
    
     for(Map<String,Object> obj : list) {
         
     Reclamation reclamation = new Reclamation();
          
        reclamation.setReclamationId((int) Float.parseFloat(obj.get("id_reclamation").toString()));

        reclamation.setContent(obj.get("content").toString());

        reclamation.setUserID((int) Float.parseFloat(obj.get("id_utilisateur").toString()));
      
        reclamation.setContent(obj.get("email").toString());

        reclamation.setTelephone((int) Float.parseFloat(obj.get("telephone").toString()));

        reclamation.setEtat(obj.get("etat").toString());
        
        reclamation.setType(obj.get("type").toString());
        
        
     // Log reclamation object to logcat to see the parser result.
     System.out.println(reclamation);
     
     // Add parsed reclamation object to the final list before return.
     reclamations.add(reclamation);
     }
     
     // Return final reclamations list.
     return reclamations;   
    }
}
