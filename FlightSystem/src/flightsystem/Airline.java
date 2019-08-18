package flightsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Airline {
    
//    static ArrayList<String> destinations=new ArrayList<>();
    static String name="lufthansa";

    static Map<String, Double> lufthansa=new HashMap<>();
//    static HashMap<String, Integer> airline_names=new HashMap<>();

    public void add_airlines(){
//        airline_names.put("lufthansa",1);
//         airline_names.put("turkish",2);
//          airline_names.put("emirates",3);
    }

    public static void map_price(){
          //here the method doesnt have to be static 'cause declaring static fields makes those 
          //fields associated with the class, hence accessible anytime, but the vice doesnt work
        
        
        lufthansa.put("sweden", 2600.0);
        lufthansa.put("belgium", 2100.0);
        lufthansa.put("france", 1400.0);
        lufthansa.put("germany", 3200.0);
        lufthansa.put("thiland", 4100.0);
        
    }
    
    public void add_des(){
//        destinations.add("malawi");
//        destinations.add("belgium");
//        destinations.add("sweden");
        
    }
    
}
