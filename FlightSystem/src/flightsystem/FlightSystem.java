package flightsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class FlightSystem {
    
    static ArrayList<Airline> airlines = new ArrayList();
    static ArrayList<Traveler> travelers = new ArrayList();
    

    static Bank bank=new Bank();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Bank of America");
            System.out.println("Bank Services: register, deposit, withdraw, balance, transfer, exit");
            System.out.println("Airline Services: book, change, cancel, show");
            String line = sc.nextLine();
            String[] values = line.split(" ");
            if (values[0].equals("exit")) {
                System.out.println("Thank you!");
                System.exit(0);
            }
            handleBankCommand(values);
            handleTravelerCommand(values);
        }
    }
    
    public static void handleBankCommand(String[] values){
        switch (values[0]) {
            case "register": {//commands: register abeni traveler 100
                String name = values[1];
                bank.register(name,Double.parseDouble(values[3]));
                
                //not used currently, but can be used to make the program dynamic
                if (values[2].equals("airline")) {
                    Airline airline = new Airline();
                    airline.name = name;
                    airlines.add(airline);
                } else if(values[2].equals("traveler")){
                    Traveler traveler = new Traveler();
                    traveler.name = name;
                    travelers.add(traveler);
                } 
                
                break;
            }
            case "deposit": {//command: deposit abeni 1000
                double amount = Double.parseDouble(values[2]);
                bank.deposit(values[1], amount);
                break;
            }
            case "balance": {//command: balance abeni
                boolean isMember=bank.valid;
                if(isMember){
                    double amount = bank.balance(values[1]);
                    System.out.println("Your balance is: " + amount);
                }else{
                System.out.println("Oops, an unregistered user");}
                break;
            }
            case "withdraw": {//command: withdraw abeni 1000
                double amount = Double.parseDouble(values[2]);
                boolean isSucccessful = bank.withdraw(values[1], amount);
                if (isSucccessful) {
                    System.out.println("Successful withdraw");
                } else {
                    System.out.println("Low balance or Unregistered user");
                }
                break;
            }
            case "transfer":{//command: withdraw abeni gedion 1000
                bank.transfer(values[1], values[2], Double.parseDouble(values[3]));
            }
        }
    }
    public static void handleTravelerCommand(String[] values){
        A: switch(values[0]){
            case "book":{
                System.out.println("Enter your name");
                String user=new Scanner(System.in).next();
//                System.out.println("Choose Airline: turkish, emirates, lufthansa");
//                String airline=new Scanner(System.in).nextLine();
                System.out.println("Enter destination:sweden belgium, france, germany, thiland");
                String dest=new Scanner(System.in).nextLine();
               
                Airline.map_price();
                C:for (Traveler tra : travelers) {
                    if(tra.name.equalsIgnoreCase(user)){
                        int position=travelers.indexOf(tra);//object index
                        if (travelers.contains(travelers.get(position)) ) {
                            double payment=Airline.lufthansa.get(dest);
                            if(bank.balance(user)-payment>=0){
                                    //not creating an object...instead getting already created objects that are stored in the arraylist
                                    Traveler traveler=travelers.get(position);//this is like Intent intent=getIntent() in android
                                    //we have already stored traveler objects so getting  one and assigning it to a pointer 
                                    //that is data typed as Traveler is not a big deal...and obviously data type is a must in java
                                    Flight f=new Flight();
                                    f.destination=dest;//objects store their data in fields
                                    f.traveler=user;
                                    f.fee=payment;

                                    traveler.addF(f);//the store flight object will have all the attributes we set
                                    System.out.println("Flight Booked");
                                    bank.withdraw(user, payment);
                                    break A;//label
                            }else{
                                System.out.println("Low Balance");
                                break A;
                            }
                        } else {
                            System.out.println("Destination or user doesnt exist");
                            break A;
                        }
                        
                    }
                }


            }
            case "cancel":{
                System.out.println("Enter your name");
                String user=new Scanner(System.in).next();
                
            S :for (int i=0; i<travelers.size();i++) {
                String tr=travelers.get(i).name;
                if(tr.equalsIgnoreCase(user)){
                    Traveler traveler=travelers.get(i);
                    for (Flight f : traveler.flights) {
                        if(f.traveler.equalsIgnoreCase(user)){
                           //traveler.flights.remove(f); could also have done this
                           traveler.removeF(f);//removes object f, hence all data/attributes associated with that object
                           System.out.println("Flight was canceled and your money is returned with some deductions");
                           double money=f.fee-300;
                           bank.deposit(user, money);
                           break A;
                        }else{
                            System.out.println("There are no flights associated with the name"+ user);
                            break A;
                        }
                    }
                }else{
                    continue S;
                }
            }
            }
            case "change":{
                System.out.println("Enter your name");
                String user=new Scanner(System.in).next();
                
                Q:for (int i=0; i<travelers.size();i++) {
                    String tr=travelers.get(i).name;
                    if(tr.equalsIgnoreCase(user)){
                        Traveler traveler=travelers.get(i);
                        for (Flight f : traveler.flights) {
                            if(f.traveler.equalsIgnoreCase(user)){
                                System.out.println("Enter the new destination");
                                String destination=new Scanner(System.in).nextLine();
                                //with deductions for the changes
                                bank.deposit(user, f.fee-100);
                                if(bank.balance(user)-(Airline.lufthansa.get(destination))>=0){
                                    bank.withdraw(user,Airline.lufthansa.get(destination));
                                    f.destination=destination;
                                    f.fee=Airline.lufthansa.get(destination);
                                    f.traveler=user;
                                    //add method is no suitable 'cause it appends it to the last
                                    //but the set method replaces the existing value
                                    traveler.setF(traveler.flights.indexOf(f),f);
                                    System.out.println("Flight Changed");
                                    break A;
                                }else{
                                    System.out.println("Your balance is low to make changes");
                                    break A;
                                }
                            }else{
                                System.out.println("There are no flights associated with the name"+ user);
                                break A;
                            }
                        }
                    } else{
                        continue Q;
                    }
                }
                
            }
            
            case "show":{
                System.out.println("Enter your name");
                String user=new Scanner(System.in).next();
                
                D: for (int i=0; i<travelers.size();i++) {
                    String tr=travelers.get(i).name;
                    //checks for user registration at all
                    if(tr.equals(user)){
                        Traveler traveler=travelers.get(i);
                        
                        for (Flight f : traveler.flights) {
                            //the if statement below checks for flight record of the given user
                            if(f.traveler.equalsIgnoreCase(user)){
                                if(f.traveler.contains(user)){
                                    System.out.println(f.describe());
                                    break A;
                                }else{
                                    System.out.println("No flight record in ur name");
                                    break A;}
                            }else{System.out.println("oops");
                            break A;}
                        }
                    }else{
                        continue D;
                    }
                }  
            }
        }
    } 
}
