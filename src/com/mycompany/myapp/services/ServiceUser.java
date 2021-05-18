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
import com.mycompany.myapp.utils.Statics;
import com.mycompany.myapp.entities.Utilisateur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author houss
 */
public class ServiceUser {
    public static ServiceUser instance;
   private ConnectionRequest req;
   ArrayList<Utilisateur> list_user;
   
    public boolean resultOK;
    public ServiceUser()
    {
     req = new ConnectionRequest();   
    }
    public static ServiceUser getInstance()
    {
        if(instance == null)
          instance = new ServiceUser();
        
        return instance;
    }
      public boolean addUser(Utilisateur u)
    {
     String url=Statics.BASE_URL1+"/add_mobile_user?NomUtilisateur="+u.getNom_utilisateur()+"&Nom="+u.getNom()+"&Prenom="+u.getPrénom()+"&Age="+u.getAge()+"&MotDePasse="+u.getMot_de_passe()+"&Email="+u.getEmail()+"&img="+u.getPhoto()+"";
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
            public boolean updateUser(String email,String pass)
    {
     String url=Statics.BASE_URL1+"/update_password_mobile?Email="+email+"&MotDePasse="+pass+"";
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
           public boolean Sendcode(String email)
    {
     String url=Statics.BASE_URL1+"/u/mail_mobile?Email="+email+"";
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
      
       public ArrayList<Utilisateur> parseUser(String jsonText) throws IOException
    {
       ArrayList<Utilisateur> list_user=new ArrayList<Utilisateur>();
       JSONParser j = new JSONParser();
       Map<String,Object> userListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
      List<Map<String,Object>> list = (List<Map<String,Object>>)userListJson.get("root");
    
     for(Map<String,Object> obj : list){
    Utilisateur u =new Utilisateur();
      
              int id = (int) Float.parseFloat(obj.get("id").toString());
       u.setId_utilisateur(id);
   
        
          u.setNom_utilisateur(obj.get("nomUtilisateur").toString());
          u.setNom(obj.get("nom").toString());
          u.setPrénom(obj.get("prenom").toString());
              int age = (int) Float.parseFloat(obj.get("age").toString());
               int role = (int) Float.parseFloat(obj.get("role").toString());
               u.setRole(role);
              u.setMot_de_passe(obj.get("motDePasse").toString());
              u.setCode((int)Float.parseFloat(obj.get("code").toString()));
       u.setAge(age);
       u.setPhoto(obj.get("img").toString());
           u.setEmail(obj.get("email").toString());
           System.out.println(u.getPhoto());
          
     list_user.add(u);
      }
      
      
       return list_user;
        
    }
    
    public ArrayList<Utilisateur> getAlluser()
    {
     String Url =Statics.BASE_URL1+"/user_mobile";  
     req.setUrl(Url);
    
        req.setPost(false);
        req.addResponseListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
             try {
                 list_user=parseUser(new String(req.getResponseData()));
                 req.removeResponseListener(this);
                 
                 
                 
             } catch (IOException ex) {
         
             }
         }
     });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return list_user;
        
        
    }
        public boolean deleteUser(int id)
    {
     String url=Statics.BASE_URL1+"/delete_user/"+id;
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
