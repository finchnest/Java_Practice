package buffet;

public interface DataOperations {

  void addFoodItem(Food food);
  void checkProviderExistence(String username, String password);
  void removeFoodItem(String foodName, String provider_name);
  void displayProviderFoods(String username);
  void foodRating(String username);
  void userComments(String username);
  void buy(String customer, String food_name, String provider_name);
  void users(String provider);
  void checkUserExistence(String username, String password);
  void justUserCheckerForNotification(String username);
  void searchByName(String food_name);
  void searchByComp(String comp);
  void searchTopRated();
  void displayMessage(String customer);
  void userFoods(String customer);
  void rate(String food_name, int rate, String pro);
  void commentFood(String food_name, String customer, String provider, String comment);
  void shareFriend(String message, String customer, String other_user);
  void checkAdminValidity(String admin_name, String admin_pass);
  void registerUser(String usern, String passw, String address, String type, double bank_id);
  void registerProvider(String pro_name, String passwo, String address, double bank_id);
  void addAdvert(String advertizer, String advertizement);
  void allUsers();
  void allProviders();
  void randomAd();
  void removeSeller(String name, int sheetNo) ;
}
