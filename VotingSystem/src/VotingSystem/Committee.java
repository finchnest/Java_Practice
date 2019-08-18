package VotingSystem;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Committee {//a committee is not a Person entity so I cant extend Person here
    
    Scanner take=new Scanner(System.in);
    static HashMap<String, Integer> count=new HashMap();
    
    public void addCandidate(){
        System.out.println("Enter the Party Name");
        String par=take.next();
        
        Candidate.party.add(par);
        
        count.put(par, 0);//adding the party to the map with 0 voters
        System.out.println("Party Added");
    }
    
    public void addVotes(String party){
        
        int currentCount=count.get(party);
        int newCount=currentCount+1;
        count.put(party, newCount);//adding value to the key(party)
        System.out.println("Vote Successfully Added");
        
    }
   
    //print the key(party) in the Map with its respective value(voters)
    public void announce(){
        System.out.println("The Most Up-to-Date Status:");
        for(Entry<String,Integer> entrys : count.entrySet()){
            System.out.println(entrys.getKey()+"-->"+entrys.getValue());
        }
    }
}
