package buffet;

import java.util.Scanner;

public class FoodProviders {
    
    String proname;//primary key since there exists one company in that name
    String password;
    String address;
    double provider_bank_id;
    
   
    
    Scanner sc=new Scanner(System.in);

    public FoodProviders() {
    }

    public FoodProviders(String username) {
        this.proname = username;
    }
    
    public void addFoodProduct(String username){
        
        System.out.println("Enter the Food Name");
        String foodName=sc.next();
        
        System.out.println("Enter the Food Type");
        String type=sc.next();
        
        
        Food food=new Food(new FoodProviders(username),type, foodName);
        
        System.out.println("Set Price");
        food.setPrice(sc.nextDouble());
        
        new DataHandler().addFoodItem(food);
        
    }
    
    public void removeFood(String username){
         System.out.println("Enter the Food Item You Want to Remove");
         String food_name=sc.next();
         new DataHandler().removeFoodItem(food_name, username);
    }
    public void myItems(String username){
        System.out.println("The Foods Under This Username: ");
        System.out.println("FoodName"+"\t"+"Provider"+"\t"+"Price"+"\t"+"\t"+"FoodType"+"\t"+"Rating");
        new DataHandler().displayProviderFoods(username);
    }
    
    public void ratings(String username){
        System.out.println("Your Foods Rating: ");
        new DataHandler().foodRating(username);
    }
    
    public void myComments(String username){
        System.out.println("Your Foods which are Given Comments: ");
        System.out.println("FoodName"+"\t"+"Commentor"+"\t"+"Comment");
        new DataHandler().userComments(username);
    }
    
    public void myUsers(String username){
        System.out.println("So Far, These Users Bought Your Foods: ");
        new DataHandler().users(username);
    }

    public void changePass(String username) {
        System.out.println("Enter the New Password");
        String pass=sc.next();
        new DataHandler().changePassword(username,pass,3);
    }
}