package buffet;

import java.util.Scanner;

public class Buffet {
    
    static private int choice;

    public static void main(String[] args){
        optionProvider();
    }
    
    public static void optionProvider(){
        
        FoodProviders fps=new FoodProviders();
        User custom=new User();
        AppAdmin adm=new AppAdmin();
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);

        OUTER:
        while (true) {
            try{
            menu.navigationMenu();
            choice = sc.nextInt();
            
            X:
            switch (choice) {
                
                //exit
                case 4:
                    System.out.println("Buffet Closed");
                    System.out.println("Thank You For Using Our Site");
                    break OUTER;

                //Food Service Providers
                case 2:

                    System.out.println("Enter Your Username");
                    String username=sc.next();
                    System.out.println("Enter Your Password");
                    String password=sc.next();

                    new DataHandler().checkProviderExistence(username, password);

                    if (DataHandler.validPro==true) {
                        // This will run until the Provider exits
                        C:
                        while(true){
                            menu.providerMenu();
                            choice = sc.nextInt();
                            
                            switch(choice){
                                case 8:
                                    System.out.println("Provider Service Exited");
                                    break X;
                                case 1:
                                    fps.addFoodProduct(username);
                                    break;
                                case 2:
                                    fps.removeFood(username);
                                    break;
                                case 3:
                                    fps.myItems(username);
                                    break;
                                case 4:
                                    fps.ratings(username);
                                    break;
                                case 5:
                                    fps.myComments(username);
                                    break;
                                case 6:
                                    fps.myUsers(username);
                                    break;
                                case 7:
                                    fps.changePass(username);
                                    break;
                                default:
                                    System.out.println("Choose From the Options Given");
                                    break;

                            }

                        }
      
                    } 
                    else {
                        showError();
                        break;
                    }

                //if user
                    
                case 1:
                    
                    System.out.println("Enter Your Username");
                    String customer=sc.next();
                    System.out.println("Enter Your Password");
                    String pass=sc.next();

                    new DataHandler().checkUserExistence(customer, pass);

                    if (DataHandler.validCustomer==true) {

                        C:
                        while(true){
                            menu.userMenu();
                            choice = sc.nextInt();

                            D:
                            switch(choice){
                                case 6:
                                    System.out.println("Customer Service Exited");
                                    break X;
                                case 1:
                                    menu.buyingOptions();
                                    choice=sc.nextInt();

                                    switch (choice) {
                                        case 1:
                                            custom.searchByName(customer);
                                            break;
                                        case 2:
                                            custom.searchByCompany(customer);
                                            break;
                                        case 3:
                                            custom.searchByTopRated(customer);
                                            break;
                                        case 4:
                                            break D;
                                        default:
                                            System.out.println("Choose From the Options Given");
                                            break;
                                    }
                                    break;
                                case 2:
                                    custom.seeMyNotifications(customer);
                                    break;
                                case 3:
                                    custom.myFoods(customer);
                                    break;
                                case 4:
                                    custom.changePass(customer);
                                    break;
                                case 5:
                                    custom.removeMyAccount(customer);
                                    break X;
                                default:
                                    System.out.println("Choose From the Options Given");
                                    break;

                            }

                        }

                    } 
                    else {
                        showError();
                        break;
                    }
                        
                case 3:
                    
                    System.out.println("Enter Admin Username");
                    String admin=sc.next();
                    System.out.println("Enter Admin Password");
                    String passw=sc.next();

                    new DataHandler().checkAdminValidity(admin, passw);

                    if (DataHandler.validAdmin==true) {
                        
                        C:
                        while(true){
                            menu.adminMenu();
                            choice = sc.nextInt();
                            
                            D:
                            switch(choice){
                                case 7:
                                    System.out.println("Admin Service Exited");
                                    break X;
                                case 1:
                                    adm.addCustomer();
                                    break;
                                case 2:
                                    adm.addProvider();
                                    break;
                                case 3:
                                    adm.addAdvertizement();
                                    break;
                                case 4:
                                    adm.registeredUsers();
                                    break;
                                case 5:
                                    adm.registeredProviders();
                                    break;
                                case 6:
                                    adm.deleteProvider();
                                    break;
                                default:
                                    System.out.println("Choose From the Options Given");
                                    break;
                            }

                        }
      
                    } 
                    else {
                        showError();
                        break;
                    }
                
                default:
                    System.out.println("Choose From the Options Given");
                    break;
                
            }
        }
        catch(Exception e){
               System.out.println("Enter a Digit Please");
               resetter();
               break;
            }
        }
    }
    
    public static void resetter(){
        optionProvider();
    }
        public void afterOptions(String food_name,String customer, String provider_name){
            
            Menu menu = new Menu();
            Scanner sc = new Scanner(System.in);
            User custom=new User();
            
            OUTER:
            while (true) {
                menu.afterBuying();
                choice = sc.nextInt();
                switch (choice) {
                    case 4:
                        System.out.println("After-Buying Options Exited");
                        break OUTER;
                    case 1:
                        custom.rate(food_name, provider_name);
                        break;
                    case 2:
                        custom.comment(food_name, customer, provider_name);
                        break;
                    case 3:
                        custom.shareTo(food_name, customer,provider_name);
                        break;
                    default:
                        System.out.println("Choose From the Options Given");
                        break;
                     
                }
            }
        }
        
        public static void showError(){
            System.out.println("Incorrect Username or Password");
        }
}