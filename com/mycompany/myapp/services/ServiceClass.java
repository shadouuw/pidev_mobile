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
import com.codename1.ui.events.ActionEvent;

import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Classe;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




/**
 *
 * @author houss
 */
public class ServiceClass {
    public static ServiceClass instance;
   private ConnectionRequest req;
   ArrayList<Classe> list_cours;
   
    public boolean resultOK;
    public ServiceClass()
    {
     req = new ConnectionRequest();   
    }
    public static ServiceClass getInstance()
    {
        if(instance == null)
          instance = new ServiceClass();
        
        return instance;
    }
    
    public boolean addClasse(Classe c)
    {
     String url=Statics.BASE_URL1+"/add2?nomClass="+c.getNom_class()+"&Age="+c.getAge()+"&idUtilisateur="+c.getId_utilisateur();
     req.setUrl(url);
     req.addResponseListener(new ActionListener<NetworkEvent>() {
         @Override
         public void actionPerformed(NetworkEvent evt) {
             resultOK = req.getResponseCode()==200;
             
         }
     });
        
     NetworkManager.getInstance().addToQueueAndWait(req);
     return resultOK;   
        
    }  
      public boolean Sendmail()
    {
     String url=Statics.BASE_URL1+"/mail_mobile";
     req.setUrl(url);
     req.addResponseListener(new ActionListener<NetworkEvent>() {
         @Override
         public void actionPerformed(NetworkEvent evt) {
             resultOK = req.getResponseCode()==200;
             
         }
     });
        
     NetworkManager.getInstance().addToQueueAndWait(req);
     return resultOK;   
        
    }  
        public boolean deleteClasse(int id)
    {
     String url=Statics.BASE_URL1+"/delete/"+id;
     req.setUrl(url);
     req.addResponseListener(new ActionListener<NetworkEvent>() {
         @Override
         public void actionPerformed(NetworkEvent evt) {
             resultOK = req.getResponseCode()==200;
             
         }
     });
        
     NetworkManager.getInstance().addToQueueAndWait(req);
     return resultOK;   
        
    }     
   
    public ArrayList<Classe> parseClasse(String jsonText) throws IOException
    {
       ArrayList<Classe> list_cours=new ArrayList<Classe>();
       JSONParser j = new JSONParser();
       Map<String,Object> ClasseListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
      List<Map<String,Object>> list = (List<Map<String,Object>>)ClasseListJson.get("root");
    
     for(Map<String,Object> obj : list){
      Classe c=new Classe();
      
              int id = (int) Float.parseFloat(obj.get("id").toString());
        c.setId_class(id);
   
        
          c.setNom_class(obj.get("nom_class").toString());
          c.setAge((int)Float.parseFloat(obj.get("age").toString()));
          c.setId_utilisateur((int)Float.parseFloat(obj.get("id_utilisateur").toString()));
        
     
     list_cours.add(c);
      }
      
      
       return list_cours;
        
    }

   
    public ArrayList<Classe> getAllClasse()
    {
     String Url =Statics.BASE_URL1+"/class_mobile";  
     req.setUrl(Url);
    
        req.setPost(false);
        req.addResponseListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            
             try {
                 list_cours=parseClasse(new String(req.getResponseData()));
             } catch (IOException ex) {
              
             }
             req.removeResponseListener(this);
             
         }
     });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return list_cours;
        
        
    }
    
    
     public boolean deleteClass(int id)
    {
     String url=Statics.BASE_URL1+"/delete_class/"+id;
     req.setUrl(url);
     req.addResponseListener(new ActionListener<NetworkEvent>() {
         @Override
         public void actionPerformed(NetworkEvent evt) {
             resultOK = req.getResponseCode()==200;
             
         }
     });
        
     NetworkManager.getInstance().addToQueueAndWait(req);
     return resultOK;   
        
    }   
    
}
