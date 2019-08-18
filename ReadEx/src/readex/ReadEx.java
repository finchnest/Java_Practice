package readex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadEx {
    
    static ArrayList<Double> tops=new ArrayList<>();
    
     //we use static block to initialize static memebers of the class
//static{
//        try{
//          FileInputStream file = new FileInputStream("Book1.xlsx");
//
//          //Create Workbook instance holding reference to .xlsx file
//          XSSFWorkbook workbook = new XSSFWorkbook(file);
//
//          //Get first/desired sheet from the workbook
//          //Most of people make mistake by making new sheet by looking in tutorial
//          XSSFSheet sheet = workbook.getSheetAt(0);
//
//        
//          
//          Row empRow = sheet.createRow(0);
//          
//          Cell c1 = empRow.createCell(0);
//          c1.setCellValue("item");
//          Cell c2 = empRow.createCell(1);
//          c2.setCellValue("company");
//          Cell c3 = empRow.createCell(2);
//          c3.setCellValue("price");
//          Cell c4 = empRow.createCell(3);
//          c4.setCellValue("rating");
//          
//            try{
//                //Write the workbook in file system
//                FileOutputStream out = new FileOutputStream("Book1.xlsx");
//                workbook.write(out);
//                out.close();
//                
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//          
//          
//        }
//        catch (Exception e) 
//        {
//            e.printStackTrace();
//        }
//
//}

public static void main(String[] args) {
    
     writeToExcel();
        
//     readExcel();

//     checkPass();

 //qualifiers();


}

public static void qualifiers(){
        try {
            FileInputStream file = new FileInputStream("Book1.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            Iterator<Row> rowIterator2 = sheet.iterator();


            while (rowIterator.hasNext()){
                
                Row row = rowIterator.next();
                
                if(row.getCell(3).getCellType()==Cell.CELL_TYPE_NUMERIC){
                    tops.add(sheet.getRow(row.getRowNum()).getCell(3).getNumericCellValue());
                }
            }
            

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
            int iteration=0;
            while (k<tops.size()){
                while (rowIterator2.hasNext()){

                    Row row = rowIterator2.next();
                    if(row.getCell(3).getCellType()==Cell.CELL_TYPE_NUMERIC){
                        iteration=1;
                        if(sheet.getRow(row.getRowNum()).getCell(3).getNumericCellValue()==tops.get(k)){

                            for (int i=0; i<row.getLastCellNum();i++) {
                                if(row.getCell(i).getCellType()==Cell.CELL_TYPE_NUMERIC && i!=2){
                                    System.out.print(row.getCell(i).getNumericCellValue()+"\t"+"\t"+"\t"+"\t");

                                }
                                else if(row.getCell(i).getCellType()==Cell.CELL_TYPE_STRING && i!=2){
                                    if(row.getCell(i).getStringCellValue().length()>10){
                                        System.out.print(row.getCell(i).getStringCellValue()+"\t"+"\t");

                                    }else{
                                        System.out.print(row.getCell(i).getStringCellValue()+"\t"+"\t"+"\t"+"\t");

                                    }
                                    

                                }
                            }
                            System.out.println("");
                        }
                    }
                    else if(row.getCell(3).getCellType()==Cell.CELL_TYPE_STRING && iteration==0){
                        for (Cell cell : row) {
                            if(cell.getColumnIndex()!=2){
                            System.out.print(cell.getStringCellValue()+"\t"+"\t"+"\t"+"\t");}
                        }
                        System.out.println("");

                    }
                }
                rowIterator2=sheet.iterator();
                k+=1;
            }
            
            file.close();

        } catch (IOException e) {
            e.getMessage();
        }
}



public static void checkPass(){
    try {
        FileInputStream file = new FileInputStream("Book1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(1);
       
        Iterator<Row> rowIterator = sheet.iterator();
        C: while (rowIterator.hasNext())
        {
            Row row = rowIterator.next();
            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) 
            {
                Cell cell = cellIterator.next();
                
                if(cell.getStringCellValue().equalsIgnoreCase("abeni") && cellIterator.next()
                        .getStringCellValue().equalsIgnoreCase("A123")){
                    System.out.println("Username and password exist");
                    break C;
                }
                else if(row.getRowNum()==sheet.getLastRowNum()){
                    System.out.println("u dnt exist in the system");
                    break C;
                }
                
            }
            
        }
        file.close();

    } catch (Exception e) {
    }
}

public static void readExcel(){
        try {
        
        FileInputStream file = new FileInputStream("Book1.xlsx");
        //Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);
       

        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext())
        {
            Row row = rowIterator.next();
            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) 
            {
                Cell cell = cellIterator.next();
                //Check the cell type and format accordingly
                switch (cell.getCellType()) 
                {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                }
            }
            System.out.println("");
        }
        file.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void writeToExcel(){
    try{
          FileInputStream file = new FileInputStream("Book1.xlsx");

          //Create Workbook instance holding reference to .xlsx file
          XSSFWorkbook workbook = new XSSFWorkbook(file);

          //Get first/desired sheet from the workbook
          //Most of people make mistake by making new sheet by looking in tutorial
          XSSFSheet sheet = workbook.getSheetAt(0);

          Employee ess = new Employee("abnei","sewer",400,3.5);
          //Get the count in sheet
          int rowCount = sheet.getLastRowNum()+1;
          Row empRow = sheet.createRow(rowCount);
          
          Cell c1 = empRow.createCell(0);
          c1.setCellValue(ess.getItem());
          Cell c2 = empRow.createCell(1);
          c2.setCellValue(ess.getCompany());
          Cell c3 = empRow.createCell(2);
          c3.setCellValue(ess.getPrice());
          Cell c4 = empRow.createCell(3);
          c4.setCellValue(ess.getRating());
          

          
            try{
                //Write the workbook in file system
                FileOutputStream out = new FileOutputStream("Book1.xlsx");
                workbook.write(out);
                out.close();
                System.out.println("Update Successfully");

            } catch (FileNotFoundException e) {
                e.getMessage();
            } catch (IOException e) {
                e.getMessage();
            }
          
          
        }
        catch (IOException e) 
        {
        }
}
    
}



class Employee {
    private String item;
    private String company;
    private double price;
    private double rating;

    public Employee(String item, String company, double price, double rating) {
        this.item = item;
        this.company = company;
        this.price = price;
        this.rating = rating;
    }
    
    
// Getters and Setters 
    
    
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

	
  
}