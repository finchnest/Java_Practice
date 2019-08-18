package buffet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataHandler implements DataOperations{

    @Override
    public  void addFoodItem(Food food){ 
        try{
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet foodSheet = workbook.getSheetAt(2);
            Iterator<Row> foodIterator=foodSheet.iterator();
            
            if(foodIterator.hasNext()){//checks if there are any foods initiallt in the excel row
                while (foodIterator.hasNext()){

                    Row row = foodIterator.next();
                    if(foodSheet.getRow(row.getRowNum()).getCell(0).getStringCellValue().equalsIgnoreCase(food.getName()) &&
                           foodSheet.getRow(row.getRowNum()).getCell(1).getStringCellValue().equals(food.getProv_nam()) ){

                        foodSheet.getRow(row.getRowNum()).getCell(7).setCellValue(
                            foodSheet.getRow(row.getRowNum()).getCell(7).getNumericCellValue()+1);
                        break;

                    }else if(row.getRowNum()==foodSheet.getLastRowNum()){
                        int rowCount = foodSheet.getLastRowNum()+1;
                        Row foodRow = foodSheet.createRow(rowCount);
                        
                        Cell Name = foodRow.createCell(0);
                          Name.setCellValue(food.getName());

                        Cell Provider_name = foodRow.createCell(1);
                          Provider_name.setCellValue(food.getProv_nam());

                        Cell Price = foodRow.createCell(2);
                          Price.setCellValue(food.getPrice());

                        Cell FoodType = foodRow.createCell(3);
                          FoodType.setCellValue(food.getFood_type());

                        Cell rating = foodRow.createCell(4);
                          rating.setCellValue(0);

                        Cell cust = foodRow.createCell(5);
                          cust.setCellValue("");

                        Cell foodCount = foodRow.createCell(7);
                          foodCount.setCellValue(1);  

                        Cell ratesCount = foodRow.createCell(6);
                          ratesCount.setCellValue(0); 

                        break;
                    }
                }
                
                
            }else{//runs if there is no food available in the food table...so that this foood could be the first one
                int rowCount = foodSheet.getLastRowNum();
                Row foodRow = foodSheet.createRow(rowCount);
                Cell Name = foodRow.createCell(0);
                  Name.setCellValue(food.getName());

                Cell Provider_name = foodRow.createCell(1);
                  Provider_name.setCellValue(food.getProv_nam());

                Cell Price = foodRow.createCell(2);
                  Price.setCellValue(food.getPrice());

                Cell FoodType = foodRow.createCell(3);
                  FoodType.setCellValue(food.getFood_type());

                Cell rating = foodRow.createCell(4);
                  rating.setCellValue(0);

                Cell cust = foodRow.createCell(5);
                  cust.setCellValue("");

                Cell foodCount = foodRow.createCell(7);
                  foodCount.setCellValue(1);  

                Cell ratesCount = foodRow.createCell(6);
                  ratesCount.setCellValue(0); 

            }
            
            
            
            try{
                FileOutputStream out = new FileOutputStream("MyDatabase.xlsx");
                workbook.write(out);
                out.close();
                System.out.println("Food Added Successfully");

            } catch (FileNotFoundException e) {
                e.getMessage();
            } catch (IOException e) {
                e.getMessage();
            }

        }catch (IOException e) 
        {
            e.getMessage();
        }catch (Exception e) 
        {
            e.getMessage();
        }
        
            
        
    }

    static boolean validPro=false;
    @Override
    public  void checkProviderExistence(String username, String password) {
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");//reads a file in byte format
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            XSSFSheet providerSheet = workbook.getSheetAt(3);

            Iterator<Row> proIterator = providerSheet.iterator();
            
            validPro=false;//resetting the variable to get rid of any static data
            
            while (proIterator.hasNext()){
            
                Row row = proIterator.next();
                
                if (providerSheet.getRow(row.getRowNum()).getCell(0).getStringCellValue().equals(username)
                        && providerSheet.getRow(row.getRowNum()).getCell(1).getStringCellValue().equals(password)){

                    validPro=true;
                    break;
                }
                else if(row.getRowNum()==providerSheet.getLastRowNum()){
                        validPro=false;
                        break;
                }
            
            }
            file.close();
            
        } catch (IOException e) {
            e.getMessage();//returns the cause of the error
        }            
    }
    
        
    @Override
    public  void removeFoodItem(String foodName, String provider_name){
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            XSSFSheet foodSheet = workbook.getSheetAt(2);
            Iterator<Row> foodIterator = foodSheet.iterator();
            
            while (foodIterator.hasNext()){
            
                Row row = foodIterator.next();
                
                if (foodSheet.getRow(row.getRowNum()).getCell(0).getStringCellValue().equalsIgnoreCase(foodName)
                        && foodSheet.getRow(row.getRowNum()).getCell(1).getStringCellValue().equals(provider_name)){
                    
                    foodSheet.removeRow(row);
                    
                    try{
                        FileOutputStream out = new FileOutputStream("MyDatabase.xlsx");
                        workbook.write(out);
                        out.close();
                        System.out.println("Food Deleted Successfully");

                    } catch (FileNotFoundException e) {
                        e.getMessage();
                    } catch (IOException e) {
                        e.getMessage();
                    }
                    
                    break;
                }
                else if(row.getRowNum()==foodSheet.getLastRowNum()){
                        System.out.println("There is No Such Food Associated With this Username");
                        break;
                }
            
            }
          
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }  
    }
    
    @Override
    public  void displayProviderFoods(String username){
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet foodSheet = workbook.getSheetAt(2);

            Iterator<Row> foodIterator = foodSheet.iterator();

            boolean found=false;
            while (foodIterator.hasNext())
            {
                Row row = foodIterator.next();
                
                if (foodSheet.getRow(row.getRowNum()).getCell(1).getStringCellValue().equals(username)) {

                    found=true;
                    //this for loop runs for one Row
                    for (int i=0; i<row.getLastCellNum()-3;i++) {
                        if(row.getCell(i).getCellType()==Cell.CELL_TYPE_NUMERIC){
                            System.out.print(row.getCell(i).getNumericCellValue()+"\t"+"\t");

                        }
                        else if(row.getCell(i).getCellType()==Cell.CELL_TYPE_STRING){
                            System.out.print(row.getCell(i).getStringCellValue()+"\t"+"\t");

                        }
                    }
                    System.out.println("");//no break because we also want other items to be displayed if they exist

                } else if(row.getRowNum()==foodSheet.getLastRowNum() && found==false){
                    System.out.println("No Such Food Item is Associated with "+ username);
                    break;

                }

            }
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    
    @Override
    public  void foodRating(String username){
         try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet foodSheet = workbook.getSheetAt(2);

            Iterator<Row> foodIterator = foodSheet.iterator();
                
            boolean found=false;
            
            while (foodIterator.hasNext())
            {
                Row row = foodIterator.next();
                
                if (foodSheet.getRow(row.getRowNum()).getCell(1).getStringCellValue().equals(username)) {
                    found=true;
                        System.out.println(
                                row.getCell(0).getStringCellValue()+"\t"+ 
                                row.getCell(1).getStringCellValue()+"\t"+
                                row.getCell(4).getNumericCellValue()+"\t"+
                                row.getCell(6).getNumericCellValue());

                } else if(row.getRowNum()==foodSheet.getLastRowNum() && found==false){
                    System.out.println("No FoodItems or Ratings are associated with "+ username);
                    break;

                }

            }
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
    } 
    
    @Override
    public  void userComments(String username){
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet commentSheet = workbook.getSheetAt(5);

            Iterator<Row> commentIterator = commentSheet.iterator();
                
            boolean found=false;
            
            while (commentIterator.hasNext())
            {
                Row row = commentIterator.next();
                
                if (commentSheet.getRow(row.getRowNum()).getCell(2).getStringCellValue().equals(username)) {
                    found=true;
                        System.out.println(
                                row.getCell(0).getStringCellValue()+"\t"+ "\t"+
                                row.getCell(1).getStringCellValue()+"\t"+ "\t"+
                                row.getCell(3).getStringCellValue());

                } else if(row.getRowNum()==commentSheet.getLastRowNum() && found==false){
                    System.out.println("No Comments are Given For Your Foods "+ username);
                    break;

                }

            }
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    
    @Override
    public  void users(String provider){
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet foodSheet = workbook.getSheetAt(2);

            Iterator<Row> foodIterator = foodSheet.iterator();
                
            boolean found=false;
            
            while (foodIterator.hasNext())
            {
                Row row = foodIterator.next();
                
                if (foodSheet.getRow(row.getRowNum()).getCell(5)!=null && 
                        foodSheet.getRow(row.getRowNum()).getCell(1).getStringCellValue().equals(provider)) {
                    
                    found=true;
                        System.out.println(
                                row.getCell(0).getStringCellValue()+" Bought By--> "+ 
                                row.getCell(5).getStringCellValue() 
                                );

                } else if(row.getRowNum()==foodSheet.getLastRowNum() && found==false){
                    System.out.println("No Buyers For Your Foods So Far");
                    break;

                }

            }
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    
    static boolean validCustomer=false;
    static String usertype="";
    
    @Override
    public  void checkUserExistence(String username, String password) {
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");//reads a file in byte format
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            XSSFSheet userSheet = workbook.getSheetAt(1);

            Iterator<Row> userIterator = userSheet.iterator();
            usertype="";
            validCustomer=false;//resetting the variable to get rid of any static data
            
            while (userIterator.hasNext()){
            
                Row row = userIterator.next();
                
                if (userSheet.getRow(row.getRowNum()).getCell(0).getStringCellValue().equals(username)
                        && userSheet.getRow(row.getRowNum()).getCell(1).getStringCellValue().equals(password)){
                    
                    usertype=userSheet.getRow(row.getRowNum()).getCell(3).getStringCellValue();
                    validCustomer=true;
                    break;
                }
                else if(row.getRowNum()==userSheet.getLastRowNum()){
                        validCustomer=false;
                        break;
                }
                
            
            }
            file.close();
            
        } catch (IOException e) {
            e.getMessage();//returns the cause of the error
        }            
    }
    
    
    
    static boolean just_user=false;
    
    @Override
    public  void justUserCheckerForNotification(String username) {
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            XSSFSheet userSheet = workbook.getSheetAt(1);

            Iterator<Row> userIterator = userSheet.iterator();
            
            just_user=false;//resetting
            
            while (userIterator.hasNext()){
            
                Row row = userIterator.next();
                
                if (userSheet.getRow(row.getRowNum()).getCell(0).getStringCellValue().equals(username)){
                    just_user=true;
                    break;
                }
                else if(row.getRowNum()==userSheet.getLastRowNum()){
                        just_user=false;
                        break;
                }
            
            }
            file.close();
            
        } catch (IOException e) {
            e.getMessage();
        }            
    }
    
    
    static boolean found_name=false;
    
    @Override
    public  void searchByName(String food_name){
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet foodSheet = workbook.getSheetAt(2);

            Iterator<Row> foodIterator = foodSheet.iterator();

            found_name=false;
            
            while (foodIterator.hasNext())
            {
                Row row = foodIterator.next();
                
                if (foodSheet.getRow(row.getRowNum()).getCell(0).getStringCellValue().equalsIgnoreCase(food_name)) {

                    found_name=true;
                    
                    for (int i=0; i<row.getLastCellNum();i++) {
                        
                        if(row.getCell(i).getCellType()==Cell.CELL_TYPE_NUMERIC && i!=5 && i!=6){
                            System.out.print(row.getCell(i).getNumericCellValue()+"\t"+"\t");

                        }
                        else if(row.getCell(i).getCellType()==Cell.CELL_TYPE_STRING && i!=5 && i!=6){
                            System.out.print(row.getCell(i).getStringCellValue()+"\t"+"\t");

                        }
                    }
                    System.out.println("");

                } else if(row.getRowNum()==foodSheet.getLastRowNum() && found_name==false){
                    System.out.println("No Food Exists With That Name");
                    break;

                }

            }
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    
    
    static double item_price;
    static double bankId;
    static double pro_bank_id;
    static double balance=0;
    static boolean validOrder=false;
    
    @Override
    public  void buy(String customer, String food_name, String provider_name){
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            XSSFSheet foodSheet = workbook.getSheetAt(2);
            XSSFSheet bankSheet=workbook.getSheetAt(4);
            XSSFSheet userSheet=workbook.getSheetAt(1);
            XSSFSheet proSheet=workbook.getSheetAt(3);

            Iterator<Row> foodIterator = foodSheet.iterator();
            Iterator<Row> bankIterator = bankSheet.iterator();
            Iterator<Row> userIterator = userSheet.iterator();
            Iterator<Row> proIterator = proSheet.iterator();

            
            validOrder=false;

            
            //cutomer bankId finder
            while (userIterator.hasNext()){

                Row row = userIterator.next();

                if(userSheet.getRow(row.getRowNum()).getCell(0).getStringCellValue().equals(customer)){
                   bankId= userSheet.getRow(row.getRowNum()).getCell(4).getNumericCellValue();
                   break;
                }
                
            }
            
            
            //balance checker for customer
            while (bankIterator.hasNext()){

                Row row = bankIterator.next();

                if(bankSheet.getRow(row.getRowNum()).getCell(0).getNumericCellValue()==bankId){
                    balance=bankSheet.getRow(row.getRowNum()).getCell(2).getNumericCellValue();
                    break;
                }
            }
            bankIterator=bankSheet.iterator();//resetting is necessary
            
            L:
            while (foodIterator.hasNext())
            {
                Row row = foodIterator.next();

                //checks for provider's existence and food availability
                if (foodSheet.getRow(row.getRowNum()).getCell(1).getStringCellValue().equals(provider_name)
                        && foodSheet.getRow(row.getRowNum()).getCell(0).getStringCellValue().equals(food_name)
                        && foodSheet.getRow(row.getRowNum()).getCell(7).getNumericCellValue()>0) {

                    item_price=foodSheet.getRow(row.getRowNum()).getCell(2).getNumericCellValue();
                    
                    
                    if(balance>=item_price){
                        validOrder=true;
                        
                        
                        
                        //adds the customer to the users list
                        if(foodSheet.getRow(row.getRowNum()).getCell(5).getCellType()==Cell.CELL_TYPE_BLANK){
                            foodSheet.getRow(row.getRowNum()).getCell(5).setCellValue( customer);
                              
                            foodSheet.getRow(row.getRowNum()).getCell(7).setCellValue(
                               foodSheet.getRow(row.getRowNum()).getCell(7).getNumericCellValue()-1);
                            
                            
                            
                        }else{
                            foodSheet.getRow(row.getRowNum()).getCell(5).setCellValue(
                               foodSheet.getRow(row.getRowNum()).getCell(5).getStringCellValue()+","+customer);

                            foodSheet.getRow(row.getRowNum()).getCell(7).setCellValue(
                               foodSheet.getRow(row.getRowNum()).getCell(7).getNumericCellValue()-1);
                        }
                        
                        
                        
                        //pro bank id finder
                        while (proIterator.hasNext()){

                            Row roww = proIterator.next();

                            if(proSheet.getRow(roww.getRowNum()).getCell(0).getStringCellValue().equals(provider_name)){
                               pro_bank_id=  proSheet.getRow(row.getRowNum()).getCell(3).getNumericCellValue();
                               break;
                            }
                        }
                        
//                        System.out.println("in while");
                        
                        //updates the account of the user
                        while (bankIterator.hasNext()){
                            
                            Row rowww = bankIterator.next();
                            
                            if((bankSheet.getRow(rowww.getRowNum()).getCell(0).getNumericCellValue())==bankId){
                                bankSheet.getRow(rowww.getRowNum()).getCell(2).setCellValue(
                                        bankSheet.getRow(rowww.getRowNum()).getCell(2).getNumericCellValue()-item_price);
                                break;
                            }
                        }
                        bankIterator=bankSheet.iterator();//this has to be initialized everyTime we want to iterate through the bank rows
                        
                        //updates the provider's account
                        while (bankIterator.hasNext()){
                            Row rowww = bankIterator.next();
                            if((bankSheet.getRow(rowww.getRowNum()).getCell(0).getNumericCellValue())==pro_bank_id){
                                
                                bankSheet.getRow(rowww.getRowNum()).getCell(2).setCellValue(
                                        bankSheet.getRow(rowww.getRowNum()).getCell(2).getNumericCellValue()+item_price*0.95);
                                break;
                            }
                        }
                        bankIterator=bankSheet.iterator();

                        //deducts some to the webAdmin
                        while (bankIterator.hasNext()){
                            Row rowww = bankIterator.next();
                            if((bankSheet.getRow(rowww.getRowNum()).getCell(0).getNumericCellValue())==10001){
                                
                                bankSheet.getRow(rowww.getRowNum()).getCell(2).setCellValue(
                                        bankSheet.getRow(rowww.getRowNum()).getCell(2).getNumericCellValue()+item_price*0.05);
                                break;
                            }
                        }
                        
//                        System.out.println("about to write");
                        
                        try (FileOutputStream data = new FileOutputStream("MyDatabase.xlsx")) {
                                  workbook.write(data);
                                  data.close();
                                  System.out.printf("You Bought %s From %s ", food_name, provider_name);
                                  System.out.println("");
                            }
                            catch(FileNotFoundException e){
                                e.getMessage();
                            }
                        
                        
                        
                        break;
                        
                    }
                    else{
                        System.out.println("Insufficient Balance !!!!");
                        break;
                    }
                    
                    
                } else if(row.getRowNum()==foodSheet.getLastRowNum() && validOrder==false){
                    System.out.println("You Entered a Wrong Provider/Food name, or The Item is Finished");
                    break;

                }

            }
            
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
        
        if(validOrder==true){
            new Buffet().afterOptions(food_name, customer,provider_name);//return the call to the main method
        }
    }
    
    static boolean comp_found=false;
    
    @Override
    public  void searchByComp(String comp){
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet foodSheet = workbook.getSheetAt(2);

            Iterator<Row> foodIterator = foodSheet.iterator();

            comp_found=false;
            
            while (foodIterator.hasNext())
            {
                Row row = foodIterator.next();
                
                if (foodSheet.getRow(row.getRowNum()).getCell(1).getStringCellValue().equals(comp)) {

                    comp_found=true;
                    for (int i=0; i<row.getLastCellNum();i++) {
                        if(row.getCell(i).getCellType()==Cell.CELL_TYPE_NUMERIC && i!=5 && i!=6){
                            System.out.print(row.getCell(i).getNumericCellValue()+"\t"+"\t");

                        }
                        else if(row.getCell(i).getCellType()==Cell.CELL_TYPE_STRING && i!=5 && i!=6){
                            System.out.print(row.getCell(i).getStringCellValue()+"\t"+"\t");

                        }
                    }
                    System.out.println("");

                } else if(row.getRowNum()==foodSheet.getLastRowNum() && comp_found==false){
                    System.out.println("No Provider Exists With That Name");
                    break;

                }

            }
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    
  
    
    @Override
    public  void searchTopRated(){
        
        ArrayList<Double> tops=new ArrayList<>();
        
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            XSSFSheet foodSheet = workbook.getSheetAt(2);

            Iterator<Row> foodIterator = foodSheet.iterator();

            //adding all ratings to arraylist
            while (foodIterator.hasNext()){
                
                Row row = foodIterator.next();
                
                if(row.getCell(4).getCellType()==Cell.CELL_TYPE_NUMERIC){
                    tops.add(foodSheet.getRow(row.getRowNum()).getCell(4).getNumericCellValue());
                }
            }
            foodIterator=foodSheet.iterator();
            
            //applying bubble sort to sort the elements in descending order
            for (int i = 0; i < tops.size()-1; i++) {
                for (int j = 0; j < tops.size()-1; j++) {
                    if(tops.get(j)<tops.get(j+1)){
                        double temp=tops.get(j);
                        tops.set(j, tops.get(j+1));
                        tops.set(j+1,temp);
                    }
                }
            }
            
            
            int k=0;
            int checker=0;//so that the attribute name will be printed only once.
            while (k<tops.size()){
                while (foodIterator.hasNext()){

                    Row row = foodIterator.next();
                    
                    if(row.getCell(4).getCellType()==Cell.CELL_TYPE_NUMERIC){
                        checker=1;
                        if(foodSheet.getRow(row.getRowNum()).getCell(4).getNumericCellValue()==tops.get(k)){

                            for (int i=0; i<row.getLastCellNum();i++) {
                                if(row.getCell(i).getCellType()==Cell.CELL_TYPE_NUMERIC && i!=5 && i!=6){
                                    System.out.print(row.getCell(i).getNumericCellValue()+"\t"+"\t");

                                }
                                else if(row.getCell(i).getCellType()==Cell.CELL_TYPE_STRING && i!=5 && i!=6){
                                    System.out.print(row.getCell(i).getStringCellValue()+"\t"+"\t");

                                }
                            }
                            System.out.println("");
                        }
                    }
                    else if(row.getCell(4).getCellType()==Cell.CELL_TYPE_STRING && checker==0){//runs only one time...it is the title
                        for (Cell cell : row) {
                            System.out.print(cell.getStringCellValue()+"\t");
                        }
                        System.out.println("");

                    }
                }
                foodIterator=foodSheet.iterator();
                k+=1;
            }
            
            
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    
    @Override
    public  void displayMessage(String customer){
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet notificationSheet = workbook.getSheetAt(0);

            Iterator<Row> notiIterator = notificationSheet.iterator();

            boolean found=false;
            while (notiIterator.hasNext())
            {
                Row row = notiIterator.next();
                
                if (notificationSheet.getRow(row.getRowNum()).getCell(0).getStringCellValue().equals(customer)
                        && notificationSheet.getRow(row.getRowNum()).getCell(2)!=null) {
                    found=true;
                    
                    System.out.println("Sender-->"+
                            notificationSheet.getRow(row.getRowNum()).getCell(1).getStringCellValue()+"\n"+
                            "...Message--> "+ notificationSheet.getRow(row.getRowNum()).getCell(2).getStringCellValue());

                    
                } else if(row.getRowNum()==notificationSheet.getLastRowNum() && found==false){
                    System.out.println("You Have No Sent Messages");
                    break;

                }

            }
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    
    @Override
    public  void userFoods(String customer){
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet foodSheet = workbook.getSheetAt(2);

            Iterator<Row> foodIterator = foodSheet.iterator();

            boolean found=false;
            while (foodIterator.hasNext())
            {
                Row row = foodIterator.next();
                
                String cus=foodSheet.getRow(row.getRowNum()).getCell(5).getStringCellValue();
                
                for (String cuss : cus.split(",")) {
                    
                    if(cuss.equals(customer)){
                        
                        found=true;

                        for (int i=0; i<row.getLastCellNum()-4;i++) {
                            if(row.getCell(i).getCellType()==Cell.CELL_TYPE_NUMERIC){
                                System.out.print(row.getCell(i).getNumericCellValue()+"\t"+"\t");

                            }
                            else if(row.getCell(i).getCellType()==Cell.CELL_TYPE_STRING){
                                System.out.print(row.getCell(i).getStringCellValue()+"\t"+"\t");

                            }
                        }
                        System.out.println("");
                        break;
                    }
                    
                     
                }
                
                if(row.getRowNum()==foodSheet.getLastRowNum() && found==false){
                    System.out.println("No Food Items are Associated with "+ customer);
                    break;
                }
                

            }
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    
    @Override
    public  void rate(String food_name, int rate, String pro){
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet foodSheet = workbook.getSheetAt(2);

            Iterator<Row> foodIterator = foodSheet.iterator();

            while (foodIterator.hasNext())
            {
                Row row = foodIterator.next();
                
                if (foodSheet.getRow(row.getRowNum()).getCell(0).getStringCellValue().equalsIgnoreCase(food_name)
                        && foodSheet.getRow(row.getRowNum()).getCell(1).getStringCellValue().equals(pro)){
                    
                    double newRate=((foodSheet.getRow(row.getRowNum()).getCell(4).getNumericCellValue())*
                            (foodSheet.getRow(row.getRowNum()).getCell(6).getNumericCellValue())+rate)/
                            (foodSheet.getRow(row.getRowNum()).getCell(6).getNumericCellValue()+1);
                    foodSheet.getRow(row.getRowNum()).getCell(4).setCellValue(newRate);
                    
                     foodSheet.getRow(row.getRowNum()).getCell(6).setCellValue(
                           foodSheet.getRow(row.getRowNum()).getCell(6).getNumericCellValue()+1);
                        
                        
                    
                    System.out.println("Rating Recorded");
                    
                    break;

                } 

            }
            
            try {
                FileOutputStream data = new FileOutputStream("MyDatabase.xlsx"); 
                workbook.write(data);
                data.close();
            }
            catch(FileNotFoundException e){
                e.getMessage();
            }

        } catch (IOException e) {
            e.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    
    @Override
    public  void commentFood(String food_name, String customer, String provider, String comment){
        try{
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet commentSheet = workbook.getSheetAt(5);

            int rowCount = commentSheet.getLastRowNum()+1;
            Row commentsRow = commentSheet.createRow(rowCount);

            Cell fud_name = commentsRow.createCell(0);
              fud_name.setCellValue(food_name);

            Cell userr = commentsRow.createCell(1);
              userr.setCellValue(customer);

            Cell owner = commentsRow.createCell(2);
              owner.setCellValue(provider);

            Cell comment_value = commentsRow.createCell(3);
              comment_value.setCellValue(comment);

               
            //Write the updated workbook in the database   
                try (FileOutputStream data = new FileOutputStream("MyDatabase.xlsx")) {
                    workbook.write(data);
                    data.close();
                    System.out.println("Comment Added");
                }
                catch(FileNotFoundException e){
                    e.getMessage();
                }
            
            }catch (IOException e) 
            {
                e.getMessage();
            }
    } 
    
    @Override
    public  void shareFriend(String message, String customer, String other_user){
        try{
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet notiSheet = workbook.getSheetAt(0);

            int rowCount = notiSheet.getLastRowNum()+1;
            
            Row notificationRow = notiSheet.createRow(rowCount);

            Cell reciever = notificationRow.createCell(0);
              reciever.setCellValue(other_user);

            Cell sender = notificationRow.createCell(1);
              sender.setCellValue(customer);

            Cell notification = notificationRow.createCell(2);
              notification.setCellValue(message);
              
                try (FileOutputStream data = new FileOutputStream("MyDatabase.xlsx")) {
                      workbook.write(data);
                      data.close();
                      System.out.println("Shared To The Specified User");
                }
                catch(FileNotFoundException e){
                    e.getMessage();
                }
            
            }catch (IOException e) {
                e.getMessage();
            }
    }

    static boolean validAdmin=false;//we made it field variable so that it could be accessed from other classes
    
    @Override
    public  void checkAdminValidity(String admin_name, String admin_pass) {
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");//reads a file
            XSSFWorkbook workbook = new XSSFWorkbook(file);//applying Polymorphism here. This 3rd party library class converts the file 
                                                           //  object into XSSFWorkbook object so that basic excel operations could be perfomrmed on it
            
            XSSFSheet adminSheet = workbook.getSheetAt(6);//getting the 6th excel spreadsheet from the workbook. getSheetAt() is a method found in XSSFWorkbook class

            Iterator<Row> adminIterator = adminSheet.iterator();//this iterator interface iterates through XSSFRows. iterator() is a method found in XSSFSheet class
            
            validAdmin=false;//resetting the variable to get rid of any static data
            
            while (adminIterator.hasNext()){
            
                Row row = adminIterator.next();
                
                if (adminSheet.getRow(row.getRowNum()).getCell(0).getStringCellValue().equals(admin_name)
                        && adminSheet.getRow(row.getRowNum()).getCell(1).getStringCellValue().equals(admin_pass)){

                    validAdmin=true;
                    break;
                }
                else if(row.getRowNum()==adminSheet.getLastRowNum()){
                        validAdmin=false;
                        break;
                }
            
            }
            file.close();
            
        } catch (IOException e) {
            e.getMessage();//returns the cause of the error
        }
        
    }  
    
    
    static boolean valid_bank_user=false;//only used in this class
    
    @Override
    public  void registerUser(String usern, String passw, String address, String type, double bank_id) {
        try{
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");//contains all the data...it mimics a database
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            XSSFSheet userSheet = workbook.getSheetAt(1);//gets the user sheet
            XSSFSheet bankSheet=workbook.getSheetAt(4);//gets the bank sheet
            
            Iterator<Row> userIterator = userSheet.iterator();//iterates the user sheet
            
            Iterator<Row> bankIterator = bankSheet.iterator();//iterates the bank sheet

            valid_bank_user=false;//resetting
            
            //iterates to check bank account existence
            while (bankIterator.hasNext()){
                
                Row row = bankIterator.next();
                
                if((bankSheet.getRow(row.getRowNum()).getCell(0).getNumericCellValue())==bank_id){
                    valid_bank_user=true;
                    break;
                }else if(row.getRowNum()==bankSheet.getLastRowNum()){
                    valid_bank_user=false;
                    break;
                }
            }
            bankIterator=bankSheet.iterator();
            
            //if he has account and the username is not occupied, then he will be registered
            if(valid_bank_user==true){
                
                if(userIterator.hasNext()){
                    OUTER:
                    while (userIterator.hasNext()){

                        Row row = userIterator.next();

                        if(userSheet.getRow(row.getRowNum()).getCell(0).getStringCellValue().equals(usern)){
                            System.out.println("This Username is Occupied");
                            break;
                        }else if(row.getRowNum()==userSheet.getLastRowNum()){

                            //check if the user has enough balance to create a premium account
                            //only runs if the user choose a premium account type
                            if(type.equalsIgnoreCase("premium")){
                                while (bankIterator.hasNext()){
                                    Row rowww = bankIterator.next();

                                    if(bankSheet.getRow(rowww.getRowNum()).getCell(0).getNumericCellValue()==bank_id && 
                                           bankSheet.getRow(rowww.getRowNum()).getCell(2).getNumericCellValue()>=100){

                                        bankSheet.getRow(rowww.getRowNum()).getCell(2).setCellValue(
                                            bankSheet.getRow(rowww.getRowNum()).getCell(2).getNumericCellValue()-100);

                                        break;//if a user that qualifies for the condition is found, the loop immediately breaks
                                    }

                                    //if the user exists in the bank but does not have a sufficient balance this else if runs
                                    else if (bankSheet.getRow(rowww.getRowNum()).getCell(0).getNumericCellValue()==bank_id && 
                                           bankSheet.getRow(rowww.getRowNum()).getCell(2).getNumericCellValue()<100){
                                        System.out.println("Insufficient Balance To Create a Premium Account");
                                        break OUTER;
                                    }
                                }
                            }

                            //registeration: whether a normal or a premium user
                            int newRow = userSheet.getLastRowNum()+1;
                            Row newUser = userSheet.createRow(newRow);

                            //creating cells and adding data
                            Cell userna = newUser.createCell(0);
                            userna.setCellValue(usern);

                            Cell pas = newUser.createCell(1);
                            pas.setCellValue(passw);

                            Cell addre = newUser.createCell(2);
                            addre.setCellValue(address);

                            Cell user_type = newUser.createCell(3);
                            user_type.setCellValue(type);

                            Cell bank_no = newUser.createCell(4);
                            bank_no.setCellValue(bank_id);


                            try (FileOutputStream data = new FileOutputStream("MyDatabase.xlsx")) {
                                  workbook.write(data);
                                  data.close();
                                  System.out.println("User Added");
                            }
                            catch(FileNotFoundException e){
                                e.getMessage();
                            }

                            break;

                        }
                    }
                    
                }else{//this runs if there are no records initially
                    boolean works=false;
                    int checker=0;
                    if(type.equalsIgnoreCase("premium")){
                        checker=1;
                        while (bankIterator.hasNext()){
                            Row rowww = bankIterator.next();

                            if(bankSheet.getRow(rowww.getRowNum()).getCell(0).getNumericCellValue()==bank_id && 
                                   bankSheet.getRow(rowww.getRowNum()).getCell(2).getNumericCellValue()>=100){

                                bankSheet.getRow(rowww.getRowNum()).getCell(2).setCellValue(
                                    bankSheet.getRow(rowww.getRowNum()).getCell(2).getNumericCellValue()-100);
                                works=true;
                                break;//if a user that qualifies for the condition is found, the loop immediately breaks
                            }

                            //if the user exists in the bank but does not have a sufficient balance this else if runs
                            else if (bankSheet.getRow(rowww.getRowNum()).getCell(0).getNumericCellValue()==bank_id && 
                                   bankSheet.getRow(rowww.getRowNum()).getCell(2).getNumericCellValue()<100){
                                System.out.println("Insufficient Balance To Create a Premium Account");
                                works=false;
                                break;
                            }
                        }
                    }
                    if(works==true || checker==0){
                        int newRow = userSheet.getLastRowNum();
                        Row newUser = userSheet.createRow(newRow);

                        //creating cells and adding data
                        Cell userna = newUser.createCell(0);
                        userna.setCellValue(usern);

                        Cell pas = newUser.createCell(1);
                        pas.setCellValue(passw);

                        Cell addre = newUser.createCell(2);
                        addre.setCellValue(address);

                        Cell user_type = newUser.createCell(3);
                        user_type.setCellValue(type);

                        Cell bank_no = newUser.createCell(4);
                        bank_no.setCellValue(bank_id);


                        try (FileOutputStream data = new FileOutputStream("MyDatabase.xlsx")) {
                              workbook.write(data);
                              data.close();
                              System.out.println("User Added");
                        }
                        catch(FileNotFoundException e){
                            e.getMessage();
                        }
                    }
                }
                
            }else{
                System.out.println("This User has No Bank Account");
            }
        }catch (IOException e) {
            e.getMessage();
        }
    }

    
    static boolean bank_user_provider=false;
    
    @Override
    public  void registerProvider(String pro_name, String passwo, String address, double bank_id) {
        try{
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            XSSFSheet providerSheet = workbook.getSheetAt(3);
            XSSFSheet bankSheet=workbook.getSheetAt(4);
            
            Iterator<Row> bankIterator = bankSheet.iterator();
            Iterator<Row> providerIterator = providerSheet.iterator();
            
            bank_user_provider=false;
            
            while (bankIterator.hasNext()){
                
                Row row = bankIterator.next();
                
                if(bankSheet.getRow(row.getRowNum()).getCell(0).getNumericCellValue()==bank_id){
                    bank_user_provider=true;
                    break;
                }else if(row.getRowNum()==bankSheet.getLastRowNum()){
                    bank_user_provider=false;
                    break;
                }
            }
            if(bank_user_provider==true){
            
                if(providerIterator.hasNext()){
                    while (providerIterator.hasNext()){

                        Row row = providerIterator.next();

                        if(providerSheet.getRow(row.getRowNum()).getCell(0).getStringCellValue().equals(pro_name)){
                            System.out.println("This Username is Occupied");
                            break;
                        }else if(row.getRowNum()==providerSheet.getLastRowNum()){

                            int rowCount = providerSheet.getLastRowNum()+1;
                            Row newPro = providerSheet.createRow(rowCount);


                            Cell name = newPro.createCell(0);
                            name.setCellValue(pro_name);

                            Cell pas = newPro.createCell(1);
                            pas.setCellValue(passwo);

                            Cell addre = newPro.createCell(2);
                            addre.setCellValue(address);

                            Cell bank_no = newPro.createCell(3);
                            bank_no.setCellValue(bank_id);
                            
                            try{
                                FileOutputStream out = new FileOutputStream("MyDatabase.xlsx");
                                workbook.write(out);
                                out.close();
                                System.out.println("Provider Added Successfully");

                            } catch (FileNotFoundException e) {
                                e.getMessage();
                            } catch (IOException e) {
                                e.getMessage();
                            }
                            break;

                        }
                    }
                }else{//runs only when there are no records
                    int rowCount = providerSheet.getLastRowNum();
                    Row newPro = providerSheet.createRow(rowCount);


                    Cell name = newPro.createCell(0);
                    name.setCellValue(pro_name);

                    Cell pas = newPro.createCell(1);
                    pas.setCellValue(passwo);

                    Cell addre = newPro.createCell(2);
                    addre.setCellValue(address);

                    Cell bank_no = newPro.createCell(3);
                    bank_no.setCellValue(bank_id);


                    try (FileOutputStream data = new FileOutputStream("MyDatabase.xlsx")) { //creating a new instance of the database to write data  
                          workbook.write(data);//writing the workbook on the instance 
                          data.close();
                          System.out.println("Provider Added");
                    }
                    catch(FileNotFoundException e){
                        e.getMessage();
                    }
                }
            }else{
                System.out.println("There is No Bank Account Associated With this Provider Username");
            }
        }catch (IOException e) {
            e.getMessage();
        }
    }

    @Override
    public  void addAdvert(String advertizer, String advertizement) {
        try{
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet advertSheet = workbook.getSheetAt(7);
            
            Iterator<Row> adIterator = advertSheet.iterator();
            
            if(adIterator.hasNext()){
                int rowCount = advertSheet.getLastRowNum()+1;
                Row newAd = advertSheet.createRow(rowCount);

                Cell owner = newAd.createCell(0);
                  owner.setCellValue(advertizer);

                Cell ad = newAd.createCell(1);
                  ad.setCellValue(advertizement);
            }else{
                int rowCount = advertSheet.getLastRowNum();
                Row newAd = advertSheet.createRow(rowCount);

                Cell owner = newAd.createCell(0);
                  owner.setCellValue(advertizer);

                Cell ad = newAd.createCell(1);
                  ad.setCellValue(advertizement);
            }
            try{
                //Write the workbook in file system
                FileOutputStream out = new FileOutputStream("MyDatabase.xlsx");
                workbook.write(out);
                out.close();
                System.out.println("Advertizement Added");

            } catch (FileNotFoundException e) {
                e.getMessage();
            } catch (IOException e) {
                e.getMessage();
            }
        }
        catch (IOException e) 
        {
            e.getMessage();
        }
    }

    @Override
    public  void allUsers() { 
        try { 
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet userSheet = workbook.getSheetAt(1);
    
            Iterator<Row> userIterator = userSheet.iterator();

            while (userIterator.hasNext())
            {
                Row row = userIterator.next();

                for (int i=0; i<row.getLastCellNum();i++) {
                    if(row.getCell(i).getCellType()==Cell.CELL_TYPE_NUMERIC){
                        System.out.print((int)row.getCell(i).getNumericCellValue()+"\t"+"\t");

                    }
                    else if(row.getCell(i).getCellType()==Cell.CELL_TYPE_STRING){
                        System.out.print(row.getCell(i).getStringCellValue()+"\t"+"\t");

                    }
                }
                System.out.println("");

            }
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
    }

    @Override
    public  void allProviders() {
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet providerSheet = workbook.getSheetAt(3);

            Iterator<Row> proIterator = providerSheet.iterator();

            while (proIterator.hasNext())
            {
                Row row = proIterator.next();

                for (int i=0; i<row.getLastCellNum();i++) {
                    if(row.getCell(i).getCellType()==Cell.CELL_TYPE_NUMERIC){
                        System.out.print((int)row.getCell(i).getNumericCellValue()+"\t"+"\t");

                    }
                    else if(row.getCell(i).getCellType()==Cell.CELL_TYPE_STRING){
                        System.out.print(row.getCell(i).getStringCellValue()+"\t"+"\t");

                    }
                }
                System.out.println("");

            }
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    
    

    @Override
    public  void randomAd() {
        
        ArrayList<String> ads=new ArrayList<>();
        
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet adSheet = workbook.getSheetAt(7);

            Iterator<Row> adIterator = adSheet.iterator();

            while (adIterator.hasNext()){
                
                Row row = adIterator.next();
                ads.add(adSheet.getRow(row.getRowNum()).getCell(1).getStringCellValue());
            }
            
            System.out.println(ads.get(new Random().nextInt(ads.size())));//prints a random ad when the user logs in
        
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
    }

    @Override
    public void removeSeller(String name, int sheetNo) {
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            XSSFSheet remSheet = workbook.getSheetAt(sheetNo);
            Iterator<Row> remIterator = remSheet.iterator();
            
            while (remIterator.hasNext()){
            
                Row row = remIterator.next();
                
                if (remSheet.getRow(row.getRowNum()).getCell(0).getStringCellValue().equals(name)){
                    
                    remSheet.removeRow(row);
                    
                    try{
                        FileOutputStream out = new FileOutputStream("MyDatabase.xlsx");
                        workbook.write(out);
                        out.close();
                        System.out.println("Deleted Successfully");

                    } catch (FileNotFoundException e) {
                        e.getMessage();
                    } catch (IOException e) {
                        e.getMessage();
                    }
                    
                    break;
                }
                else if(row.getRowNum()==remSheet.getLastRowNum()){
                        System.out.println("No Such Username exists");
                        break;
                }
            
            }
          
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void changePassword(String username, String pass, int sheetNo) {
        try {
            FileInputStream file = new FileInputStream("MyDatabase.xlsx");//reads a file in byte format
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet mySheet = workbook.getSheetAt(sheetNo);
            Iterator<Row> recordIterator = mySheet.iterator();
            
            while (recordIterator.hasNext()){
                Row row = recordIterator.next();
                if (mySheet.getRow(row.getRowNum()).getCell(0).getStringCellValue().equals(username)){
                    mySheet.getRow(row.getRowNum()).getCell(1).setCellValue(pass);
                    
                    try{
                        FileOutputStream out = new FileOutputStream("MyDatabase.xlsx");
                        workbook.write(out);
                        out.close();
                        System.out.println("Password Changed Successfully");

                    } catch (FileNotFoundException e) {
                        e.getMessage();
                    } catch (IOException e) {
                        e.getMessage();
                    }
                    
                    break;
                }
            }
            file.close();
        } catch (IOException e) {
            e.getMessage();
        } 
    }
 
}