package VotingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Candidate implements Campaign{//candidate refers to a party so I can't extend Person here
    
    Scanner take=new Scanner(System.in);
    static ArrayList<String> party=new ArrayList();
   
    //candidate can see result...other operations could be added
    public void seeResult(){
        Committee c=new Committee();
        c.announce();
    }

    @Override
    public void createAwareness(String party, String medium) {
        System.out.println(party+ " Party Promoted Via "+ medium);
    }
    
    
    

    
}
