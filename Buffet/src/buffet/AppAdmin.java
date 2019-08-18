package buffet;

import java.util.Scanner;

public class AppAdmin {//the admin class here is mimicing the role of a casual website registeration system
    
    String username;
    String password;
    long account_no;
   
    Scanner sc=new Scanner(System.in);
    
    public void addCustomer(){
        System.out.println("Set Customer's Username");
        String usern=sc.next();
        System.out.println("Set Password");
        String passw=sc.next();
        System.out.println("Enter User's Address");
        String address=sc.next();
        System.out.println("Choose Account Type");
        System.out.println("---> Normal\n---> Premium");
        String type=sc.next();
        System.out.println("Enter Bank Account");
        long bank_id=sc.nextLong();
        if (type.equalsIgnoreCase("normal") || type.equalsIgnoreCase("premium")) {
            new DataHandler().registerUser(usern, passw, address, type, bank_id);
        } else {
            System.out.println("Please Choose From The Given Types");
        }
        
    }
    
    
    //provider's registeration is free in our system...but whenever order transactions are made
    //the provider pays 5% of the food item price to the WebAdmin
    public void addProvider(){
        System.out.println("Enter Provider's Username");
        String pro_name=sc.next();
        System.out.println("Set Password");
        String passwo=sc.next();
        System.out.println("Enter Provider's Address");
        String address=sc.next();
        System.out.println("Enter Provider's Bank Account No");
        long bank_id=sc.nextLong();
        
        new DataHandler().registerProvider(pro_name, passwo, address,bank_id);
        
    }
    
    public void addAdvertizement(){
        System.out.println("Enter the Advertizer");
        String advertizer=new Scanner(System.in).next();
        System.out.println("Enter Short Ad");
        String advertizement=new Scanner(System.in).nextLine();
        
        new DataHandler().addAdvert(advertizer, advertizement);
    }
    
    public void registeredUsers(){
        System.out.println("\033[32;1;2m Registered Users Until Now:");
        System.out.println("Username"+"\t"+"Password"+"\t"+"Address"+"\t"+"\t"+"UserType"+"\t"+"BankAccount");
        new DataHandler().allUsers();
    }
    
    public void registeredProviders(){
        System.out.println("\033[32;1;2m Registered Providers Until Now:");
        System.out.println("Username"+"\t"+"Password"+"\t"+"Address"+"\t"+"\t"+"BankAccount");
        new DataHandler().allProviders();
    }

    public void deleteProvider() {
        System.out.println("Enter the Seller's name You Want to Remove");
        String selName=sc.next();
        new DataHandler().removeSeller(selName,3);
    }
}