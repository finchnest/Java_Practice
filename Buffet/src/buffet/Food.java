package buffet;

public class Food {
    
    private String name;
    private double price;
    private double rating;
   
    private FoodProviders provider;
    private String prov_nam;
    private User user;
    private String food_type;
    
    public Food(FoodProviders provider, String food_type, String food_name) {
        
        this.provider = provider;
        this.food_type = food_type;
        this.name=food_name;
        this.prov_nam=provider.proname;
        
    }

    public String getProv_nam() {
        return prov_nam;
    }
    

    public String getName() {
        return name;
    }

    public FoodProviders getProvider() {
        return provider;
    }

    public String getFood_type() {
        return food_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}