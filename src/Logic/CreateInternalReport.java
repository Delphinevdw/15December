package Logic;

import Database.DBException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateInternalReport {

    //TRIPS BOOKED
    //MOST POPULAR AIRPORTS
    //TOTAL PRICE PER MONTH
    
    private ArrayList<Booking> bookings;
    private ArrayList<Ticket> tickets;
    private ArrayList<Reservation> reservations;
    private ArrayList<Flight> flights;
    private ArrayList<Traject> trajects;
    private CreateInternalReport CreateInternalReport = new CreateInternalReport();

    
  public CreateInternalReport() {
    try {
      bookings = Database.DBBooking.getBookings();
      tickets = Database.DBTicket.getTickets();
      reservations = Database.DBReservation.getReservations();
      flights = Database.DBFlight.getFlights();
      trajects = Database.DBTraject.getTrajects();
    } 
    catch (DBException ex) {
      Logger.getLogger(CreateInternalReport.class.getName()).log(Level.SEVERE, null, ex);   //WAT DOET DIT??
    }
  }

  //RETOURNEERT EEN MULTIARRAY MET 5 KOLOMMEN VAN ALLE BOOKINGS
  /*
  public String[][] findAllBookings() throws DBException{
      int lenght = 0;
      String[][] table = new String[lenght][5];
      
      for (int i = 0; i < bookings.size(); i++) {
          lenght = lenght + 1;
          
          int ticketIDi = bookings.get(i).getTicketId();
          int indexTicket = reservations.indexOf(ticketIDi);
          int lenght2 = 0;
          
          //RETOURNEERT EEN ARRAY VAN ALLE VLUCHTEN DIE IN BOOKING i ZITTEN
          int[] flightsInBooking = new int[lenght2];
          for (int j = 0; j<flights.size(); j++){
              if(flights.get(j).getFlightnumber() == reservations.get(indexTicket).getFlightID()){
                  lenght2 = lenght2 + 1;
                  flightsInBooking[lenght] = flights.get(j).getFlightnumber();
              }   
          }        
          
          //Origin en Destination ophalen
          int eenVluchtID = flightsInBooking[0];
          int indexVlucht = flights.indexOf(eenVluchtID);
          int trajectID = flights.get(indexVlucht).getTrajectID();
          int indexTraject = trajects.indexOf(trajectID);
          String origin = trajects.get(indexTraject).getOrigin();
          String destination = trajects.get(indexTraject).getDestination();
          
          //Totale prijs berekening
          double totalPrice = 0;
          for(int k = 0; k<flightsInBooking.lenght; k++){
              int flightIDk = flightsInBooking[k];
              int indexFlight = flights.indexOf(flightIDk);
              double price = flights.get(indexFlight).getPriceperflight();
              totalPrice = totalPrice + price;
          }
          String priceString = Double.toString(totalPrice);
         
          //Dep
          for(int h = 0; h<flightsInBooking.length; h++){
              int flightIDh = flightsInBooking[h];
              int indexFlight2 = flights.indexOf(flightIDh);
              int trajectID2 = flights.get(indexFlight2).getTrajectID();
              int indexTraject2 = trajects.indexOf(trajectID2);
              String originFlighth = trajects.get(indexTraject2).getOrigin();
              if(origin.equals(originFlighth)){
                  int flightID1 = flightsInBooking[h];
              }
          }
          int indexFlightID1 = flights.indexOf(flightID1);
          LocalDateTime dep = flights.get(indexFlightID1).getDeparture();
          String depString = LocalDateTime.toString(dep);
          
          //Arr
          for(int h = 0; h<flightsInBooking.length; h++){
              int flightIDh = flightsInBooking[h];
              int indexFlight2 = flights.indexOf(flightIDh);
              int trajectID2 = flights.get(indexFlight2).getTrajectID();
              int indexTraject2 = trajects.indexOf(trajectID2);
              String destinationFlighth = trajects.get(indexTraject2).getDestination();
              if(destination.equals(destinationFlighth)){
                  int flightIDlast = flightsInBooking[h];
              }
          }
          int indexFlightIDlast = flights.indexOf(flightIDlast);
          LocalDateTime arr = flights.get(indexFlightIDlast).getArrival();
          String arrString = LocalDateTime.toString(arr);
          
          //Plaats opgehaalde gegevens in de multiarray
          table[lenght][1] = origin;
          table[lenght][2] = destination;
          table[lenght][3] = priceString;
          table[lenght][4] = depString;
          table[lenght][5] = arrString;
      }
      return table;
  }*/
  
  
  
  
  
  
  
}