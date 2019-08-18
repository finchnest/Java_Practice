package VotingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Voter extends Person{

    ArrayList<String> voters=new ArrayList();
    Scanner take=new Scanner(System.in);
    
    Person p=new Person();//Voter class doesn't have access to private members of the parent...
                            //so we get those via object using getters/getters

    public boolean checkVoter(){
        //setting the default value to be false or unregistered
        boolean status=false;
        
        System.out.println("Enter Your Name");
        p.setFname(take.next().toLowerCase());//set voter name
        
        System.out.println("Enter age");
        p.setAge(take.nextInt());
        
        if(p.getAge()>18){//checks for age limit
            for (int i = 0; i < voters.size(); i++) {//checks for registeration
                if(p.getFname().equals(voters.get(i))){
                    status=true;//registered user
                    break;
                }
            }
        }else{
            status=true;}
        
        return status;
       
    }
    
    
    public void vote(){
        
        voters.add(p.getFname());
        
        System.out.println("Choose Party");
        Candidate c=new Candidate();
        for (int i = 0; i < c.party.size(); i++) {
            System.out.println("--->"+ c.party.get(i));
        }
        String choice=take.next();
        new Committee().addVotes(choice);

    }
    
    public void seeResult(){
        Committee c=new Committee();
        c.announce();
    }
    
    
    
}
