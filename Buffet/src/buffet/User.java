package buffet;
 
import java.util.Scanner;

public class User extends Person{
    
    public User(){
    }
    
    public User(String userName, String Password, String Address, double User_bank_id, String User_type) {
        super(userName,Password, Address, User_bank_id,User_type);
    }
    
    
    Scanner sc=new Scanner(System.in);
    
    public void searchByName(String customer){
        System.out.println("Enter The Name of The Food You Want");
        String chosen=sc.next();
        
        System.out.println("FoodName"+"\t"+"Provider"+"\t"+"Price"+"\t"+"\t"+"FoodType"+"\t"+"Rating"+"\t"+"FoodCount");

        new DataHandler().searchByName(chosen);
        
        if(DataHandler.found_name==true){
            System.out.println("Choose A Seller");
            String seller=sc.next();
            new DataHandler().buy(customer, chosen, seller);//seller existence must be checked
            
        }else{
            System.out.println("This Item Does Not Exist In The System");
        }
        
    }
    
    public void searchByCompany(String customer){
        System.out.println("Enter The Name of The Company You Want To Buy Foods From");
        String comp=sc.next();
        System.out.println("FoodName"+"\t"+"Provider"+"\t"+"Price"+"\t"+"\t"+"FoodType"+"\t"+"Rating"+"\t"+"FoodCount");

        new DataHandler().searchByComp(comp);
        
        if(DataHandler.comp_found){
            System.out.println("Choose a Food Item");
            String food_item=sc.next();
            new DataHandler().buy(customer, food_item, comp);//food existence must be checked
            
        }else{
            System.out.println("We Dont Have a Food Company With That Name");
        }
    }
    
    
    public void searchByTopRated(String customer){
        System.out.println("FoodName"+"\t"+"Provider"+"\t"+"Price"+"\t"+"\t"+"FoodType"+"\t"+"Rating"+"\t"+"\t"+"RatersCount");
        new DataHandler().searchTopRated();
        System.out.println("Choose Food");
        String food_choice=sc.next();
        System.out.println("Choose Provider");
        String prov=sc.next();
        
        new DataHandler().buy(customer, food_choice, prov);//both food and pro existence must be checked
    }
    
    public void seeMyNotifications(String customer){
        new DataHandler().displayMessage(customer);
    }
    
    public void myFoods(String customer){
        System.out.println("Food Items You Bought: ");
        System.out.println("FoodName"+"\t"+"Provider"+"\t"+"Price"+"\t"+"\t"+"FoodType");

        new DataHandler().userFoods(customer);
    }
    
    public void rate(String food_name, String pro){
        System.out.println("Enter Your Rating out of 5");
        int rate=sc.nextInt();
        if(rate>=0 && rate<=5){
            new DataHandler().rate(food_name,rate,pro);
        }
        else{
            System.out.println("Please Enter a Valid Rating");
        }
               
    }
    
    public void comment(String food_name, String customer,String provider_name){
        System.out.println("Enter a Short Comment Below:");
        String comment_mes=new Scanner(System.in).nextLine();
        new DataHandler().commentFood(food_name, customer, provider_name, comment_mes);
        
    }
    
    public void shareTo(String food_name, String customer, String provider_name){
        System.out.println("Enter the Username of The User You Want To Share This Food Item to");
        String reciever=sc.next();
        String small_message="Try "+provider_name+"'s "+food_name;
        
        new DataHandler().justUserCheckerForNotification(reciever);
        
        if (DataHandler.just_user==true) {
            new DataHandler().shareFriend(small_message, customer, reciever);
        } else {
            System.out.println("This Username Does Not Exist");
        }
    }

    public void changePass(String customer) {
        System.out.println("Enter the New Password");
        String pass=sc.next();
        new DataHandler().changePassword(customer,pass,1);
    }

    public void removeMyAccount(String username) {
        new DataHandler().removeSeller(username,1);
    }
}