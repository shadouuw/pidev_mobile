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
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionEvent;

import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Test;
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
public class ServiceTest {
    public static ServiceTest instance;
   private ConnectionRequest req;
   ArrayList<Test> list_cours;
   
    public boolean resultOK;
    public ServiceTest()
    {
     req = new ConnectionRequest();   
    }
    public static ServiceTest getInstance()
    {
        if(instance == null)
          instance = new ServiceTest();
        
        return instance;
    }
    
    public boolean addTest(Test c)
    {
     String url=Statics.BASE_URL1+"/add_mobile_test?Question1="+c.getQuestion_1()+"&Question2="+c.getQuestion_2()+"&Question3="+c.getQuestion_3()+"&Question4="+c.getQuestion_4()+"&Question5="+c.getQuestion_5()+"&temps="+c.getTemps()+"";
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
       public boolean export_pdf()
    {
     String url=Statics.BASE_URL1+"/e/export_pdf";
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
        public boolean deleteTest(int id)
    {
     String url=Statics.BASE_URL1+"/delete_test/"+id;
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
    
    public ArrayList<Test> parseTest(String jsonText) throws IOException, ParseException
    {
       ArrayList<Test> list_cours=new ArrayList<Test>();
       JSONParser j = new JSONParser();
       Map<String,Object> TestListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
      List<Map<String,Object>> list = (List<Map<String,Object>>)TestListJson.get("root");
    
     for(Map<String,Object> obj : list){
      Test c=new Test();
      
              int id = (int) Float.parseFloat(obj.get("idTest").toString());
        c.setId_test(id);
          SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            // DateFormatPatterns.ISO8601
        Date date = (Date) format.parse(obj.get("temps").toString());  
        
          c.setQuestion_1(obj.get("question1").toString());
   c.setQuestion_2(obj.get("question2").toString());
      c.setQuestion_3(obj.get("question3").toString());
      c.setQuestion_4(obj.get("question4").toString());
      c.setQuestion_5(obj.get("question5").toString());
           c.setNote((int)Float.parseFloat(obj.get("note").toString()));
      c.setTemps(date);
          System.out.println(c);
     list_cours.add(c);
      }
      
      
       return list_cours;
        
    }
    
    public ArrayList<Test> getAllTest()
    {
     String Url =Statics.BASE_URL1+"/t/test_mobile";  
     req.setUrl(Url);
    
        req.setPost(false);
        req.addResponseListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
             try {
                 list_cours=parseTest(new String(req.getResponseData()));
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
