package flightsystem;

import java.util.HashMap;

public class Bank {

    static HashMap<String, Double> userMap = new HashMap();

    public void register(String name,double amount) {
        userMap.put(name, amount);
    }

    public void deposit(String name, double amount) {
        
        if (userMap.containsKey(name)) {
            double dep = userMap.get(name);
            userMap.put(name, dep + amount);
        } else {
            System.out.println("unregistered user");
        }
    }
    
    public boolean valid=true;
    
    public double balance(String name) {
        if (!userMap.containsKey(name)) {
            valid=false;
        }
        double dep = userMap.get(name);
        return dep;
    }

    public boolean withdraw(String name, double amount) {
        if (!userMap.containsKey(name)) {
            return false;
        }else{
            double oldAmount = userMap.get(name);
            if (oldAmount >= amount) {
                userMap.put(name, oldAmount - amount);
                return true;
            }
            return false;
        }
    }
    
    public void transfer(String sender, String reciever, double amount) {
        boolean isSuccessful = withdraw(sender, amount);
        if (isSuccessful) {
            deposit(reciever, amount);
        }
        else{
            System.out.println("Unregistered user or low balance");
        }
    }
    
}
