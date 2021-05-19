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
import com.mycompany.myapp.entities.Blog;
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
public class ServiceBlog {
    public static ServiceBlog instance;
   private ConnectionRequest req;
   ArrayList<Blog> list_cours;
   
    public boolean resultOK;
    public ServiceBlog()
    {
     req = new ConnectionRequest();   
    }
    public static ServiceBlog getInstance()
    {
        if(instance == null)
          instance = new ServiceBlog();
        
        return instance;
    }
    
    public boolean addBlog(Blog c)
    {
     String url=Statics.BASE_URL1+"/add3?nom="+c.getNom()+"&nomAdmin="+c.getNomAdmin()+"&Description="+c.getDesciption()+"&img="+c.getImg();
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
  
        public boolean deleteBlog(int id)
    {
     String url=Statics.BASE_URL1+"/delete_blog/"+id;
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
    
    public ArrayList<Blog> parseBlog(String jsonText) throws IOException, ParseException
    {
       ArrayList<Blog> list_cours=new ArrayList<Blog>();
       JSONParser j = new JSONParser();
       Map<String,Object> BlogListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
      List<Map<String,Object>> list = (List<Map<String,Object>>)BlogListJson.get("root");
    
     for(Map<String,Object> obj : list){
      Blog c=new Blog();
      
              int id = (int) Float.parseFloat(obj.get("id").toString());
      c.setId(id);
           SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            // DateFormatPatterns.ISO8601
        Date date = (Date) format.parse(obj.get("date_postule").toString()); 
        
          c.setNom(obj.get("nom").toString());
          c.setNomAdmin(obj.get("nom_admin").toString());
          c.setDatepostule(date);
          c.setDesciption(obj.get("description").toString());
         
          c.setImg(obj.get("img").toString());
         
          System.out.println(c);
     list_cours.add(c);
      }
      
      
       return list_cours;
        
    }
    
    public ArrayList<Blog> getAllBlog()
    {
     String Url =Statics.BASE_URL1+"/blog_mobile";  
     req.setUrl(Url);
    
        req.setPost(false);
        req.addResponseListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
             try {
                 list_cours=parseBlog(new String(req.getResponseData()));
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
