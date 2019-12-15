package Logic;

import Database.DBException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InfoTraject {

    private static ArrayList<Traject> trajects;

    private static InfoTraject infoTraject = new InfoTraject();

    
  public InfoTraject() {
    try {
      trajects = Database.DBTraject.getTrajects();
    } 
    catch (DBException ex) {
      Logger.getLogger(InfoTraject.class.getName()).log(Level.SEVERE, null, ex);   //WAT DOET DIT??
    }
  }

  
  //RESTOURNEERT DE ORGIGIN WAARVAN DE TRAJECTID IS GEGEVEN
  public static String findorigin(int trajectId){
      int trajectID;
      for(int i = 0; i<trajects.size(); i++){
          trajectID = trajects.get(i).getId();
          
          if(trajectID == trajectId)
              return trajects.get(i).getOrigin();
      }
      return null;
  }
  
  //RESTOURNEERT DE DESTINATION WAARVAN DE TRAJECTID IS GEGEVEN
  public static String finddestination(int trajectId){
      int trajectID;
      for(int i = 0; i<trajects.size(); i++){
          trajectID = trajects.get(i).getId();
          
          if(trajectID == trajectId)
              return trajects.get(i).getDestination();
      }
      return null;
  }
}
