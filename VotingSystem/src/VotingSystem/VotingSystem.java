package VotingSystem;

import java.util.Scanner;

public class VotingSystem {//Main class
    
    static Scanner take=new Scanner(System.in);
    public static void main(String[] args) {
        
        while (true) {
                System.out.println("Welcome To The Voting System");
                System.out.println("1. candidate\n2. voter\n3. committee\n4. exit");
                String entity = take.next();
                
                switch(entity){
                    case "exit": 
                        System.out.println("System Closed");
                        System.exit(0);
                        
                    case "voter":
                        System.out.println("1. vote\n2. result");
                        String command = take.next();
                        if (command.equals("vote")) {
                            runVoter();
                        } else if(command.equals("result")){
                            new Voter().seeResult();
                        }
                        break;
                        
                    case "candidate":
                        System.out.println("1. result\n2. promote");
                        String doo = take.next();
                        
                        if (doo.equals("result")) {
                            new Candidate().seeResult();//using declaration and assignment in one line
                        } else if(doo.equals("promote")){
                            System.out.println("Enter party name");
                            String name=take.next();
                            System.out.println("Promote Party Via: TV, internet, Media");
                            String medium=take.next();
                            runCandidate(name,medium);
                        }
                        break;
                        
                    case "committee":
                        System.out.println("1. addCandidate\n2. announce");
                        String order = take.next();
                        if (order.equals("addCandidate")) {
                            runCommittee();
                        } else if(order.equals("announce")){
                            new Committee().announce();
                        }
                        break;
                    default:
                        System.out.println("Please Choose One From the Options Given");
                        break;
                }
        }
    }

    private static void runVoter() {
        Voter voter=new Voter();
        boolean registered = voter.checkVoter();
        if (!registered) {
            voter.vote();
        }
    }

    private static void runCommittee() {
        Committee c=new Committee();
        c.addCandidate();
    }
    
    private static void runCandidate(String name, String medium) {
        Candidate c=new Candidate();
        c.createAwareness(name,medium);
    }
}
