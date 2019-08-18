package flightsystem;

public class Flight {
    
    String traveler;
    String destination;
    String airline=Airline.name;
    double fee;
    String schedule;//to be used later
    
    public String describe() {
        return String.format("%s : %s : %s: %e" , traveler,this.destination, airline, fee);
    }
}
