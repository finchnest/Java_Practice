package flightsystem;

import java.util.ArrayList;

public class Traveler {
    
    ArrayList<Flight> flights = new ArrayList<>();
    String name;

    public void addF(Flight flight) {
        flights.add(flight);
    }
    //agul fancy lemehone, but unnecessary
    public void removeF(Flight flight){
        flights.remove(flight);
    }
    public void setF(int index,Flight flight){
        flights.set(index, flight);
    }
    
    
    
    
    
    
    //already implemented in the main class, but could have done it here
    public void book(Flight flight){
    }
    
    public void cancel(Flight flight){
    }
    
    public void change(Flight flight){
    }
}
