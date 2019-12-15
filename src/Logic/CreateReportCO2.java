package Logic;

import Database.DBException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateReportCO2 {
    
    private ArrayList<Traveler> travelers;
    private ArrayList<Booking> bookings;
    private ArrayList<Ticket> tickets;
    private ArrayList<Reservation> reservations;
    private ArrayList<Traject> trajects;
    private ArrayList<Flight> flights;
    private static CreateReportCO2 createReportCO2 = new CreateReportCO2();
    //private CreateReportCO2 createReportCO2 = new CreateReportCO2();

  public static CreateReportCO2 getInstance() {
        return createReportCO2;
    }   
    
  public CreateReportCO2() {
    try {
      travelers = Database.DBTraveler.getTravelers();
      bookings = Database.DBBooking.getBookings();
      tickets = Database.DBTicket.getTickets();
      reservations = Database.DBReservation.getReservations();
      trajects = Database.DBTraject.getTrajects();
      flights = Database.DBFlight.getFlights();
      
    } 
    catch (DBException ex) {
      Logger.getLogger(CreateReportCO2.class.getName()).log(Level.SEVERE, null, ex);   //WAT DOET DIT??
    }
  }
  
  //RETOURNEERT 1 TRAVELER WAARVAN HET PASSNUM IS GEGEVEN
  public Traveler findTraveler(String passNum){
    String traveleri;
    for (int i = 0; i < travelers.size(); i++) {
        traveleri = travelers.get(i).getPassportnr();
        
        if(traveleri.equals(passNum)){
            return travelers.get(i);
        }
    }
        return null;
  }
  
  //RETOURNEERT EEN ARRAY VAN DE BOOKINGID's WAARVAN DE TRAVELERID IS GEGEVEN
  public int[] findBookingIDs(String passNum){
    String passnum;
    int lenght = 0;//Is het juist om dit op nul te zetten? Wordt aangepast door de lenght+1
    int[] BookingIDs = new int[lenght];
    
    for (int i = 0; i < bookings.size(); i++) {
        passnum = bookings.get(i).getTravelerId();
        
        if(passnum == passNum){
            lenght = lenght+1;
            BookingIDs[lenght] = bookings.get(i).getBookingreference();
        }
    }
        return BookingIDs;
  }
  
  //RETOURNEERT EEN ARRAY VAN DE TICKETID's WAARVAN DE TRAVELERID IS GEGEVEN
  public int[] findTicketID(String passNum){
    int[] BookingIDs = findBookingIDs(passNum);
    int lenght = 0;//Is het juist om dit op nul te zetten? Wordt aangepast door de lenght+1
    int[] TicketIDs = new int[lenght];
    
    for (int i = 0; i < BookingIDs.length; i++) {
        int bookingIDi = BookingIDs[i];
        int index = tickets.indexOf(bookingIDi);
        int bookingid = tickets.get(index).getId();
        if(bookingIDi == bookingid){
            lenght = lenght+1;
            TicketIDs[lenght] = tickets.get(index).getId();
        }
    }
    return TicketIDs;
  } 
  
  //RETOURNEERT EEN ARRAY VAN DE FLIGHTID's WAARVAN DE TRAVELERID IS GEGEVEN
  public int[] findFlightIDs(String passNum){
    int[] TicketIDs = findTicketID(passNum);
    int lenght = 0;//Is het juist om dit op nul te zetten? Wordt aangepast door de lenght+1
    int[] FlightIDs = new int[lenght];
    
    for (int i = 0; i < TicketIDs.length; i++) {
        int ticketIDi = TicketIDs[i];
        int index = reservations.indexOf(ticketIDi);
        int ticketid = reservations.get(index).getId();
        if(ticketIDi == ticketid){
            lenght = lenght+1;
            FlightIDs[lenght] = reservations.get(i).getFlightID();
        }
    }
    return FlightIDs;
  }
  
  //RESTOURNEERT DE ORGIGIN WAARVAN DE TRAJECTID IS GEGEVEN
  public String findorigin(int trajectId){
      int trajectID;
      for(int i = 0; i<trajects.size(); i++){
          trajectID = trajects.get(i).getId();
          
          if(trajectID == trajectId)
              return trajects.get(i).getOrigin();
      }
      return null;
  }
  
  //RESTOURNEERT DE DESTINATION WAARVAN DE TRAJECTID IS GEGEVEN
  public String finddestination(int trajectId){
      int trajectID;
      for(int i = 0; i<trajects.size(); i++){
          trajectID = trajects.get(i).getId();
          
          if(trajectID == trajectId)
              return trajects.get(i).getDestination();
      }
      return null;
  }  
  
  //RETOURNEERT EEN MULTI ARRAY VAN DE VLUCHTEN MET DAARBIJ HUN UITSTOOT, WAARVAN DE TRAVELERID IS GEGEVEN
  public String[][] findCO2(String passNum){
    int[] FlightIDs = findFlightIDs(passNum);
    int lenght = 0;//Is het juist om dit op nul te zetten? Wordt aangepast door de lenght+1
    String[][] table = new String[lenght][4];

    for (int i = 0; i < FlightIDs.length; i++) {
        int flightIDi = FlightIDs[i];
        int index = flights.indexOf(flightIDi);
        int flightid = flights.get(i).getFlightnumber();
        if(flightIDi == flightid){
            String flightidString = Integer.toString(flightid);
            int traject = flights.get(index).getTrajectID();
            String origin = findorigin(traject);
            String destination = finddestination(traject);
            int co2 = flights.get(index).getCo2();
            String co2String = Integer.toString(co2);
                
            table[i][0] = flightidString;
            table[i][1] = origin;
            table[i][2] = destination;
            table[i][3] = co2String;
        }    
    }
    return table;
   }
  
}