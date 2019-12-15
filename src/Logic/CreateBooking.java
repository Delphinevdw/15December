package Logic;

import Database.DBException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateBooking {
    private ArrayList<Traject> trajects;
    private ArrayList<Leg> legs;
    private CreateBooking createBooking = new CreateBooking();

    
  public CreateBooking() {
    try {
      trajects = Database.DBTraject.getTrajects();
      legs = Database.DBLeg.getLegs();
    } 
    catch (DBException ex) {
      Logger.getLogger(CreateBooking.class.getName()).log(Level.SEVERE, null, ex);   //WAT DOET DIT??
    }
  }
   
  //RETOURNEERT HET TRAJECTID WAARVAN DE ORIGIN EN DESTINATION IS GEGEVEN
  public int findTrajectID(String origin, String destination){
    for (int i = 0; i < trajects.size(); i++) {
        String orgininTrajecti = trajects.get(i).getOrigin();
        String destinationTrajecti = trajects.get(i).getDestination();
        
        if(orgininTrajecti.equals(origin) && destinationTrajecti.equals(destination)){
            return trajects.get(i).getId();
        }
    }
    return 0;
  }
  
  //RETOURNEERT EEN ARRAY VAN DE LEGID's WAARVAN DE ORIGIN EN DESTINATION IS GEGEVEN
  public int[] findLegID(String origin, String destination){
    int trajectID = findTrajectID(origin, destination);
    int traject;
    int lenght = 0;
    int[] LegIDs = new int[lenght];
    
    for (int i = 0; i < legs.size(); i++) {
        traject = legs.get(i).getTrajectID();
        
        if(traject == trajectID){
            lenght = lenght+1;
            LegIDs[lenght] = legs.get(i).getId();
        }
    }
    return LegIDs;
  }
  
  //RETOURNEERT EEN MATRIX VAN ARRAYLISTS MET DAARIN PER DE LEGIDs DIE SAMEN EEN ROUTE VORMEN
  public ArrayList<ArrayList<Integer>> findRoutes(String origin, String destination){
    int[] legIDs = findLegID(origin, destination);
    ArrayList<ArrayList<Integer>> routes = new ArrayList<ArrayList<Integer>>(); //matrix van ArrayLists, zowel rijen als kolommen variabel
    int rij = -1;
    
    for (int i = 0; i < legIDs.length; i++){
        int legi = legIDs[i];
        int index = legs.indexOf(legi);
        String originLeg = legs.get(index).getOrigin();
        String destinationLeg = legs.get(index).getDestination();

        if(originLeg.equals(origin)){
            rij++; //Duid aan op welke rij we zitten
            routes.add(new ArrayList<Integer>()); //nieuwe rij toegevoegd, deze rij kan opgevraagd worden via routes.get(rij)
            routes.get(rij).add(legs.get(index).getId()); //huidige rij wordt opgevraagd, aan deze rij wordt de id van de leg toegevoegd
        
            while(!destinationLeg.equals(destination)){		
                String nextOrigin = destinationLeg; 
                for (int j = 0; j < legIDs.length; j++){
                    int legj = legIDs[j];
                    int index2 = legs.indexOf(legj);
                    originLeg = legs.get(index2).getOrigin(); //gebruik legj voor opzoekingen en niet de index j van de for loop
                    destinationLeg = legs.get(index2).getDestination(); //idem
                    if(nextOrigin.equals(originLeg) && !destinationLeg.equals(origin) && !destination.equals(nextOrigin)){					
			routes.get(rij).add(legs.get(index2).getId()); //id van nieuwe leg wordt achteraan de rij toegevoegd
                    }
                }
				
            }
        }             
    }
    return routes;    
  }

  /*
  public int[][] findFlights(String origin, String destination, DateTime departure){
    int [][] routes = findRoutes(origin, destination);
    int[][] flights;
    
    for (int i = 0; i < routes.length; i++){
        
        
    }
  }
  */
}