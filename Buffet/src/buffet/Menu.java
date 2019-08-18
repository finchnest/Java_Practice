package buffet;


public class Menu {
    
    public void navigationMenu(){
        System.out.println("\033[32;1;2m Welcome To Buffet");
        System.out.println("\033[1m What Services Do You Want To Get?");
        System.out.println("1--> User");
        System.out.println("2--> Provider");
        System.out.println("3--> WebAdmin");
        System.out.println("4--> Exit");
        System.out.println("Enter Your Choice NUMBER:");
    }
    
    public void providerMenu(){
        System.out.println("\033[1m Welcome Provider");
        System.out.println("\033[1m What Services Do You Want To Get?");
        System.out.println("1--> Add Food");
        System.out.println("2--> Remove Food");
//        System.out.println("3--> See My Foods");
        System.out.println("4--> See My Foods' Ratings");
        System.out.println("5--> See My Foods' Comments");
        System.out.println("6--> See Who Bought My Foods");
        System.out.println("7--> Change Password");
        System.out.println("8--> Exit");
        System.out.println("Enter Your Choice:");
    }
    
//    public void userOptions(){
//        System.out.println("\033[1m What Services Do You Want To Get?");
//        System.out.println("1--> Register");
//        System.out.println("2--> Log in");
//    }
    
    public void userMenu(){
        System.out.println("\033[1m Welcome Customer\n");
        
        if(DataHandler.usertype.equalsIgnoreCase("normal")){//if it is a normal user, ads will be shown when he logs in
            new DataHandler().randomAd();
            System.out.println("");
        }
        
        System.out.println("\033[1m What Services Do You Want To Get?");
        System.out.println("1--> Buy Food");
        System.out.println("2--> See Notifications");
        System.out.println("3--> See My History");
        System.out.println("4--> Change Password");
        System.out.println("5--> Remove My Account");
        System.out.println("6--> Exit");
        System.out.println("Enter Your Choice:");
    }
    
    public void buyingOptions(){
        System.out.println("\033[32;1;2m How Do You Want To Search Food");
        System.out.println("1--> Search By Name");
        System.out.println("2--> Search By Company");
        System.out.println("3--> Search By Top Rated");    
        System.out.println("4--> Exit");
        System.out.println("Enter Your Choice:");
    }
    
    public void afterBuying(){
        System.out.println("\033[32;1;2m You Can Comment, Share, or Rate this Food");
        System.out.println("1--> Rate This Food ");
        System.out.println("2--> Comment On This Food");
        System.out.println("3--> Share To Other Users");
        System.out.println("4--> Exit");
        System.out.println("Enter Your Choice:");
    }
    
    public void adminMenu(){
        System.out.println("\033[32;1;2m Welcome Admin: What Do You Want To Do");
        System.out.println("1--> Add Customer");
        System.out.println("2--> Add Providers");
        System.out.println("3--> Add Advertizement");
        System.out.println("4--> See Registered Users");
        System.out.println("5--> See Registered Providers");
        System.out.println("6--> Delete Provider");
        System.out.println("7--> Exit");
        System.out.println("Enter Your Choice:");
    }
    
}