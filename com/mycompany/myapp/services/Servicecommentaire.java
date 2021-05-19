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
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionEvent;

import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.commentaire;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;





/**
 *
 * @author houss
 */
public class Servicecommentaire {
    public static Servicecommentaire instance;
   private ConnectionRequest req;
   ArrayList<commentaire> list_cours;
   
    public boolean resultOK;
    public Servicecommentaire()
    {
     req = new ConnectionRequest();   
    }
    public static Servicecommentaire getInstance()
    {
        if(instance == null)
          instance = new Servicecommentaire();
        
        return instance;
    }
    
    public boolean addcommentaire(commentaire c)
    {
     String url=Statics.BASE_URL1+"/add_comment?Email="+c.getEmail()+"&Contenu="+c.getContenu()+"&Rating="+c.getRating()+"&Iduser="+c.getIduser()+"&Idblog="+c.getIdblog();
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
        public boolean deletecommentaire(int id)
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
    
    public ArrayList<commentaire> parsecommentaire(String jsonText) throws IOException, ParseException
    {
       ArrayList<commentaire> list_cours=new ArrayList<commentaire>();
       JSONParser j = new JSONParser();
       Map<String,Object> commentaireListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
      List<Map<String,Object>> list = (List<Map<String,Object>>)commentaireListJson.get("root");
    
     for(Map<String,Object> obj : list){
      commentaire c=new commentaire();
      
              int id = (int) Float.parseFloat(obj.get("idCommentaire").toString());
      c.setId_commentaire(id);
           SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            // DateFormatPatterns.ISO8601
        Date date = (Date) format.parse(obj.get("date").toString()); 
        
          c.setEmail(obj.get("email").toString());
          c.setContenu(obj.get("contenu").toString());
          c.setDate(date);
          c.setIduser((int)Float.parseFloat((obj.get("iduser").toString())));
         
         c.setIdblog((int)Float.parseFloat((obj.get("idblog").toString())));
         
        
     list_cours.add(c);
      }
      
      
       return list_cours;
        
    }
    
    public ArrayList<commentaire> getAllcommentaire()
    {
     String Url =Statics.BASE_URL1+"/comment_mobile";  
     req.setUrl(Url);
    
        req.setPost(false);
        req.addResponseListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
             try {
                 list_cours=parsecommentaire(new String(req.getResponseData()));
                 req.removeResponseListener(this);
                 
                 
                 
             } catch (IOException ex) {
         
             } catch (ParseException ex) {
            
             }
         }
     });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return list_cours;
        
        
    }
    
    
    
    
}
