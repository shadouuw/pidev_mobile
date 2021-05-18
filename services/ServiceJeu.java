/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Jeu;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.DataSource;
import static utils.Statics.BASE_URL;

/**
 *
 * @author Zambala
 */
public class ServiceJeu {
 
    
    
    
    private ConnectionRequest request;

    private boolean responseResult;
       public ArrayList<Jeu> jeux;
       
  public ServiceJeu() {
        request = DataSource.getInstance().getRequest();
    }
   
  
     
  
  
  
  
  
         public ArrayList<Jeu> parseJeu(String jsonText) {
        try {
            jeux = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> demandeListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            

            List<Map<String, Object>> list = (List<Map<String, Object>>) demandeListJson.get("root");
            
            for (Map<String, Object> obj : list) {
              
               Map<String, Object> courss = ( Map<String, Object> ) obj.get("cours");
                 
                  int  id = (int)Float.parseFloat(obj.get("id").toString());
                
                  String titre = obj.get("titre").toString();
                  String description = obj.get("description").toString();
                  String topscore = obj.get("topscore").toString();
                 String diff = obj.get("diff").toString();
                 String source= obj.get("source").toString();

           
            
              jeux.add(new Jeu (id,titre,description,     (int)Float.parseFloat(courss.get("idCours").toString())      ,diff,topscore,source));
               
            }

        } catch (IOException ex) {
        }

        return jeux ;
    }
  
         
         
         
         public boolean ajouterJeu(Jeu d) {
 request.setPost(false);

String url="http://localhost/FirstProject/public/index.php/jeux/newjeuxmobile?titre="+d.getTitre()+"&description="+d.getDescription()+"&topscore="+d.getTopscore()+"&diff="+d.getDiff()+"&source="+d.getSource()+"&cours="+d.getCours();
//titre=sami&description=144545455445&topscore=454554&diff=2&source=44441&cours=2

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
         
                  public boolean modifierJeu(Jeu d) {
 request.setPost(false);

String url="http://localhost/FirstProject/public/index.php/jeux/"+32+"/editmobile?titre="+d.getTitre()+"&description="+d.getDescription()+"&topscore="+d.getTopscore()+"&diff="+d.getDiff()+"&source="+d.getSource()+"&cours="+d.getCours();
//titre=sami&description=144545455445&topscore=454554&diff=2&source=44441&cours=2

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
         
         
         
         
         
         
         
         
         
         
         
         
    public ArrayList<Jeu> afficherJeu() {
       // String url = "http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/afficherdemandemobile?iduser=";

        request.setUrl("http://localhost/FirstProject/public/index.php/jeux/jeuxmobile");
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                jeux= parseJeu(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return jeux;
    }
    
          public boolean supprimerjeu(int id) {
    
       String url ="http://localhost/FirstProject/public/index.php/jeux/jeuxmobiles/"+id;

        request.setUrl(url);
                request.setPost(true);

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
  
  /*  public boolean ajouterDemande(Jeu j , int iduser) {
    
String url="http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/ajouterdemandemobile?lieua="+d.getLieuarrive()+"&lieud="+d.getLieudepart()+"&periode="+d.getPeriode()+"&dated="+d.getDated()+"&region="+d.getRegion()+"&prix="+d.getPrix()+"&idu="+iduser;

System.out.println(d.getLieudepart() );
System.out.println(d.getLieuarrive() );
System.out.println(d.getPeriode() );
System.out.println(d.getIduser() );
System.out.println(d.getRegion() );
System.out.println(d.getPeriode() );
System.out.println(d.getPrix() );
System.out.println(d.getDated() );
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
    
     public boolean supprimerreservations(int  id) {
    
         String url = "http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/deletereservationmobile?id="+id;

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
    
      public boolean supprimerdemande(int id) {
    
       String url = "http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/deleterequestmobile?id="+id;

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
      
      
      
      
      
      
      public boolean Reserver (int iddemande,int iduser ) {
    
       String url = "http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/reservationmobile?iddemande="+iddemande+"&iduser="+iduser;

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
    
      
     
       
            
            
            
             public ArrayList<DemandeTaxi> trierprixdemande(int iduser) {
        String url = "http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/trierselonprixMobile?iduser="+iduser;

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                demande= parseDemande(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return demande;
    }
             
             
             
             
             
             
             
              public ArrayList<DemandeTaxi> recherchedemande(String date , String region , String lieud , int id ) {
       String url = "http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/recherchedrld?iduser="+id+"&region="+region +"&lieudepart="+lieud+"&date=" + date ;
       // String url = "http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/recherchedrld?iduser=11&region=Ariana&lieudepart=mahaaaa&date=2020-06-05";

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                demande= parseDemande(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return demande;
    }
        
        public ArrayList<DemandeTaxi> afficheruserdemande(int iduser) {
        String url = "http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/afficherdemandeusermobile?iduser="+iduser;

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                demande= parseDemande(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return demande;
    }
        
        
        
         public ArrayList<DemandeTaxi> parseDemande(String jsonText) {
        try {
            demande = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> demandeListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
          //   public DemandeTaxi(int id, int iduser, String lieudepart, String lieuarrive, String region, String periode, String username, String dated, int etat, float prix) {

            List<Map<String, Object>> list = (List<Map<String, Object>>) demandeListJson.get("root");
            
            for (Map<String, Object> obj : list) {
                 Map<String, Object> userlist = ( Map<String, Object> ) obj.get("iduser");
                  int iduser=(int)Float.parseFloat(userlist.get("id").toString());
                  String username = userlist.get("username").toString();
                  int  id = (int)Float.parseFloat(obj.get("id").toString());
                  String lieud = obj.get("lieudedepart").toString();
                  String lieua = obj.get("lieudarrive").toString();
                  String region = obj.get("region").toString();
                 String dated = obj.get("dateD").toString();
               // String dated= "menek enti ";
                  String periode = obj.get("periode").toString();
                float prix  = (float)Float.parseFloat(obj.get("prix").toString());
                int etat = (int)Float.parseFloat(obj.get("etat").toString());
              demande.add(new DemandeTaxi (id , iduser, lieud, lieua , region , periode ,username, dated, etat , prix ));
               
            }

        } catch (IOException ex) {
        }

        return demande ;
    }
         
         
        public ArrayList<ReservationTaxi> afficheruserReservation(int id) {
        String url = "http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/afficherReservationusermobile?iduser="+id;

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                reservation= parseReservation(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return reservation;
    }
        
        
        
        
           public ArrayList<ReservationTaxi> finduserreservation(int iddemande) {
        String url = "http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/afficheruserreservationMobile?iddemande="+iddemande;

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                reservation= parseReservation(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return reservation;
    }
         
       public ArrayList<ReservationTaxi> parseReservation(String jsonText) {
        try {
            reservation = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> reservationListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) reservationListJson.get("root");
            for (Map<String, Object> obj : list) {
            
              Map<String, Object> demandelist = ( Map<String, Object> ) obj.get("iddemande");
  //public ReservationTaxi(int id, float prix, String lieudepart, String lieuarrive, String region, String periode, String dated, String username) {             int iddemande= (int)Float.parseFloat(demandelist.get("id").toString());
              int iddemande= (int)Float.parseFloat(demandelist.get("id").toString());
             float prix  = (float)Float.parseFloat(demandelist.get("prix").toString());
             String lieud= demandelist.get("lieudedepart").toString();
             String lieua= demandelist.get("lieudarrive").toString();
             String periode = demandelist.get("periode").toString();
             String region = demandelist.get("region").toString();
             String dated = demandelist.get("dateD").toString();
             Map<String, Object> userlist = ( Map<String, Object> ) demandelist.get("iduser");
             String username = userlist.get("username").toString();
             int id = (int)Float.parseFloat(obj.get("id").toString());
              
              reservation.add(new ReservationTaxi ( id, prix, lieud, lieua, region, periode, dated,username ));
               
            }

        } catch (IOException ex) {
        }

        return reservation ;
    }

       
    /////////////////notiiiifffff//////////////////
       
       
        public ArrayList<Notification> affichernotifdriver(int iduser) {
        String url = "http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/notifdrivermobile?iduser="+iduser;

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                notif= parseNotif(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return notif;
    }
        
        
      public ArrayList<Notification> affichernotifclient(int iduser) {
        String url = "http://localhost/PiDev/web/app_dev.php/FiThnitek/taxi/notifclientmobile?iduser="+iduser;

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                notif= parseNotif(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return notif;
    }
       
       
        public ArrayList<Notification> parseNotif(String jsonText) {
        try {
            notif = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> notifnListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) notifnListJson.get("root");
            for (Map<String, Object> obj : list) {
            int id = (int)Float.parseFloat(obj.get("id").toString());
             Map<String, Object> demandelist = ( Map<String, Object> ) obj.get("idarticle");
  
            // int iddemande= (int)Float.parseFloat(demandelist.get("id").toString());
            
             String lieud= demandelist.get("lieudedepart").toString();
             
             String lieua= demandelist.get("lieudarrive").toString();
             String periode = demandelist.get("periode").toString();
             String region = demandelist.get("region").toString();
             String dated = demandelist.get("dateD").toString();

             Map<String, Object> userlist = ( Map<String, Object> ) demandelist.get("iduser");
             String username = userlist.get("username").toString();
           //  int id = (int)Float.parseFloat(obj.get("id").toString());

             String title = obj.get("title").toString();
             String des = obj.get("description").toString();
             String type = obj.get("type").toString();
        //  int id, String title, String des, String type, String lieudepart, String lieuarrive, String region, String periode, String dated, String username)
           notif.add(new Notification (id,title,des,type,lieud,lieua,region,periode,dated,username ));
                      //    notif.add(new Notification (id,title,des,type,"hhhhh","rrrr","hgcg","gcf","cxfgc",username ));
System.out.println("chihaaaab");
           //  notif.add(new Notification (id) );
               
            }

        } catch (IOException ex) {
        }

        return notif ;
    }

   
      
      
      
    */
       
       
       
       
}
