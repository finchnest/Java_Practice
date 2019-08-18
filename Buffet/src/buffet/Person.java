package buffet;


public abstract class Person {
    
    private String username;//primary key in our case.
    private String password;
    private String address;
    private double user_bank_id;//foreign key
    private String user_type;//normal or premium user

    
    public Person(){
        
    }
    public Person(String username, String password, String address, double user_bank_id, String user_type) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.user_bank_id = user_bank_id;
        this.user_type = user_type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public double getUser_bank_id() {
        return user_bank_id;
    }

    public String getUser_type() {
        return user_type;
    }

}
