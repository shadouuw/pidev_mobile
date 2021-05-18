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
import com.mycompany.myapp.entities.Cours;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




/**
 *
 * @author houss
 */
public class ServiceCours {
    public static ServiceCours instance;
   private ConnectionRequest req;
   ArrayList<Cours> list_cours;
   
    public boolean resultOK;
    public ServiceCours()
    {
     req = new ConnectionRequest();   
    }
    public static ServiceCours getInstance()
    {
        if(instance == null)
          instance = new ServiceCours();
        
        return instance;
    }
    
    public boolean addCours(Cours c)
    {
     String url=Statics.BASE_URL1+"/add?nomCours="+c.getNomCours()+"&Domaine="+c.getDomaine()+"&lien="+c.getLien()+"&lien2="+c.getLien2();
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
        public boolean deleteCours(int id)
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
    
    public ArrayList<Cours> parseCours(String jsonText) throws IOException
    {
       ArrayList<Cours> list_cours=new ArrayList<Cours>();
       JSONParser j = new JSONParser();
       Map<String,Object> CoursListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
      List<Map<String,Object>> list = (List<Map<String,Object>>)CoursListJson.get("root");
    
     for(Map<String,Object> obj : list){
      Cours c=new Cours();
      
              int id = (int) Float.parseFloat(obj.get("idCours").toString());
        c.setIdCours(id);
   
        
          c.setNomCours(obj.get("nomCours").toString());
          c.setDomaine(obj.get("domaine").toString());
          c.setLien(obj.get("lien").toString());
          c.setLien2(obj.get("lien2").toString());
          if(obj.get("doc_file") != null)
          {
          c.setDoc_file(obj.get("doc_file").toString());
          }
          System.out.println(c);
     list_cours.add(c);
      }
      
      
       return list_cours;
        
    }
    
    public ArrayList<Cours> getAllCours()
    {
     String Url =Statics.BASE_URL1+"/cours_mobile";  
     req.setUrl(Url);
    
        req.setPost(false);
        req.addResponseListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
             try {
                 list_cours=parseCours(new String(req.getResponseData()));
                 req.removeResponseListener(this);
                 
                 
                 
             } catch (IOException ex) {
         
             }
         }
     });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return list_cours;
        
        
    }
    
    
    
    
}
