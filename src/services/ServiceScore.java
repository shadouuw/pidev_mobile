/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entities.Scores;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.DataSource;

/**
 *
 * @author asus
 */
public class ServiceScore {
      private ConnectionRequest request;

    private boolean responseResult;
       public ArrayList<Scores> score;
       
  public ServiceScore() {
        request = DataSource.getInstance().getRequest();
    }
  
  
  
        public ArrayList<Scores> parseScore(String jsonText) {
        try {
            score = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> demandeListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            

            List<Map<String, Object>> list = (List<Map<String, Object>>) demandeListJson.get("root");
            
            for (Map<String, Object> obj : list) {
              
                System.out.println("aaaaaaaaaaaaaaaaaaaaa");
                 
                 /* int  id = (int)Float.parseFloat(obj.get("id").toString());
                System.out.println("1");*/
                   int idJeux = (int)Float.parseFloat(obj.get("idJeux").toString());
                      System.out.println("2");
                  String id_user = obj.get("idUser").toString();
                     System.out.println("3");
                  int  scorex = (int)Float.parseFloat(obj.get("1").toString());
           
                System.out.println("bbbbbbbbbbbbbbbb");
           
            
              score.add(new Scores (0,idJeux,id_user,scorex));
               
            }

        } catch (IOException ex) {
        }

        return score;
    }
  
       public ArrayList<Scores> parseScore2(String jsonText) {
        try {
            score = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> demandeListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            

            List<Map<String, Object>> list = (List<Map<String, Object>>) demandeListJson.get("root");
            
            for (Map<String, Object> obj : list) {
              
                System.out.println("aaaaaaaaaaaaaaaaaaaaa");
                 
                 /* int  id = (int)Float.parseFloat(obj.get("id").toString());
                System.out.println("1");*/
                   int idJeux = (int)Float.parseFloat(obj.get("idJeux").toString());
                      System.out.println("2");
                  String id_user = obj.get("idUser").toString();
                     System.out.println("3");
                  int  scorex = (int)Float.parseFloat(obj.get("score").toString());
           
                System.out.println("bbbbbbbbbbbbbbbb");
           
            
              score.add(new Scores (0,idJeux,id_user,scorex));
               
            }

        } catch (IOException ex) {
        }

        return score;
    }
  
  
      public ArrayList<Scores> afficherall() {
       // String url = "http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/afficherdemandemobile?iduser=";

        request.setUrl("http://localhost/FirstProject/public/index.php/stages/afficherall");
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                score=parseScore2(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return score;
    }
         
  
   public ArrayList<Scores> afficherScore() {
       // String url = "http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/afficherdemandemobile?iduser=";

        request.setUrl("http://localhost/FirstProject/public/index.php/stages/scoremobile");
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println("hiiiiiii");
                score= parseScore(new String(request.getResponseData()));
                System.out.println("parsed");
                request.removeResponseListener(this);
            }
        });
         System.out.println("hooooo");
        NetworkManager.getInstance().addToQueueAndWait(request);
  System.out.println("request");
        return score;
    }
}
