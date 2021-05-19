/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mycompany.myapp.entities.Stages;
import com.mycompany.myapp.utils.DataSource;
import com.mycompany.myapp.utils.Statics;

/**
 *
 * @author asus
 */
public class ServiceStage {
    
    
        private ConnectionRequest request;

    private boolean responseResult;
       public ArrayList<Stages> stages;
       
  public ServiceStage() {
        request = DataSource.getInstance().getRequest();
    }
   
  
     
  
  
         public ArrayList<Stages> parseStage(String jsonText) throws IOException {
       
            stages = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> demandeListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            

            List<Map<String, Object>> list = (List<Map<String, Object>>) demandeListJson.get("root");
            
            for (Map<String, Object> obj : list) {
               Map<String, Object> jeuxx = ( Map<String, Object> ) obj.get("jeu");
                //  int idj=(int)Float.parseFloat(jeuxx.get("id").toString());
                 // String username = userlist.get("username").toString();
             //    System.out.println("jeuxx="+jeuxx);
               // System.out.println("id="+(int)Float.parseFloat(jeuxx.get("id").toString()));
                  int id  = (int)Float.parseFloat(obj.get("id").toString());
                  int numero  = (int)Float.parseFloat(obj.get("numero").toString());
                  String texte = obj.get("texte").toString();
                  String essai = obj.get("essai").toString();
                  String correction = obj.get("correction").toString();
                 String source = obj.get("source").toString();
   int temps  = (int)Float.parseFloat(obj.get("temps").toString());
               // System.out.println("1111111111111111111111");
               // System.out.println(obj.get("jeu").toString());
  //   int jeu  = (int)Float.parseFloat(obj.get("jeu").toString());
           //String jeu  = obj.get("jeu").toString();

               // System.out.println("22222222222222222222222222222");
                 // String dated= "menek enti ";
            //wallah khatiiiniiiii enti heya lblé tfuuuuh aalik 
            
              stages.add(new Stages (id,numero,texte,essai,correction,source,temps,    (int)Float.parseFloat(jeuxx.get("id").toString())   ));
               
            }

         

        return stages;
    }
         
         
     
    public ArrayList<Stages> afficherStages() {
       // String url = "http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/afficherdemandemobile?iduser=";

        request.setUrl("http://localhost/FirstProject/public/index.php/stages/affichermobilestage");
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                try {
                    stages=parseStage(new String(request.getResponseData()));
                } catch (IOException ex) {
                 
                }
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return stages;
    }
    
  
  
  
           public boolean ajouterStage(Stages d) {
 request.setPost(false);

String url="http://localhost/FirstProject/public/index.php/stages/newstagemobile?numero="+d.getNumero()+"&texte="+d.getTexte()+"&essai="+d.getEssai()+"&correction="+d.getCorrection()+"&source="+d.getSource()+"&temps="+d.getTemps()+"&jeu="+d.getJeu();


System.out.println("url:"+url);

        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }
         
  
           
           
           
                 public boolean supprimerstage(int id) {
    
       String url ="http://localhost/FirstProject/public/index.php/stages/deletemobiles/"+id;
                     System.out.println(url);
        request.setUrl(url);
               

        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }
  
  
  
    
}
