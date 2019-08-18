package oopclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class OOPClass {
  
    public static void main(String[] args) {
        
        int[][] mato=new int[2][2];
        int[][] matpro=new int[2][3];

        int[][] mat={{2,3},{5,1}};
//        mat[0][0]=2;
//        mat[0][1]=3;
//        mat[1][0]=5;
//        mat[1][1]=1;
        
        int[][] mati={{0,9},{7,-1}};
//        mati[0][0]=0;
//        mati[0][1]=9;
//        mati[1][0]=7;
//        mati[1][1]=-1;
        
        int[][] matp={{3,2,6},{4,5,7}};
//        matp[0][0]=3;
//        matp[0][1]=2;
//        matp[0][2]=6;
//        matp[1][0]=4;
//        matp[1][1]=5;
//        matp[1][2]=7;
        
        //product
        int i1=0;
        while(i1<mat.length){
            int i2=0,j1=0,j2=0;
            while(j2<matp[0].length){
                matpro[i1][j2]=mat[i1][j1]*matp[i2][j2]+mat[i1][j1+1]*matp[i2+1][j2];
                j2+=1;
            }
            i1+=1;
        }
        
        //product print
        for (int i = 0; i < matpro.length; i++) {
            for (int j = 0; j < matpro[0].length; j++) {
                System.out.print(matpro[i][j]+" ");
            }
            System.out.println();
        }
        
        
        
        //summation
        for (int i = 0; i < mato.length; i++) {
            for (int j = 0; j < mato[0].length; j++) {
                mato[i][j]= mat[i][j]+mati[i][j];
            }
        }
        
        //print
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mati.length; j++) {
                System.out.print(mato[i][j]+" ");
            }
            System.out.println();
        }
    }   
        
    }    
        
        /*#11 
       ArrayList<Integer> cust=new ArrayList<>();
       Scanner take=new Scanner(System.in);
       System.out.println("Enter nums and press -1 to quit");
       while((take.nextInt())!=-1){
           cust.add(take.nextInt());
       }
       int max=cust.get(0);
       for (int i = 1; i < cust.size(); i++) {
            if(cust.get(i)>max){
                max=cust.get(i);
            }
        }
        System.out.println(max);
        */
        
       
        /*#10
        Scanner take=new Scanner(System.in);
        System.out.println("Enter two nums");
        int n1=take.nextInt();
        int n2=take.nextInt();
        System.out.println("Choose operation");
        String ops=take.next();
        
        switch(ops){
            case "+":
                System.out.println(n1+n2);
                break;
            case "-":
                System.out.println(n1-n2);
                break;
            case "*":
                System.out.println(n1*n2);
                break;
            case "/":
                System.out.println(n1/n2);
                break;
            default:
                System.out.println("Enter proper operation");
                
        }
        */
        
        
        
        /*#9
        Scanner take=new Scanner(System.in);
        System.out.println("Enter the numbers");
        int max=0;
        for (int i = 0; i < 5; i++) {
            int a=take.nextInt();
            if(a>max){
                max=a;
            }
        }
        System.out.println(max);
        */
        
        
        /*#8
        int a=2, b=3, c=12,max;
        if(a>b){
            if(a<c){
                max=c;
            }else{
              max=a;  
            }
        }else{
            if(b>c){
                max=b;}
            else{         
                max=c;   
            }
        }
        System.out.println(max);
        */
        
        
        /*#7
        Scanner take=new Scanner(System.in);
        System.out.println("Enter the first");
        int a=take.nextInt();
        System.out.println("enter the second");
        int b=take.nextInt();
        if (a<b) {
            System.out.println("a is "+a);
            System.out.println("b is "+ b);
        } else {
            int temp=a;
            a=b;
            b=temp;
            System.out.println("a is "+ a);
            System.out.println("b is "+ b);
        }
        */
        
        
        /*#6
        Scanner take=new Scanner(System.in);
        System.out.println("Enter a range");
        int num=take.nextInt();
        int total=0;
        int ctr=1;
        while(ctr<=num){
            int temp=ctr;
            int factor=1;
            while(temp>=1){
                factor=factor*temp;
                temp=temp-1; 
            }
            total+=factor/ctr;
            ctr+=1;
        }
        System.out.println(total);
        */
        
        
        /*#5
        Scanner takein=new Scanner(System.in);
        System.out.println("Enter range");
        int num3=takein.nextInt();
        int ctr=1;
        
        while(ctr<=num3){
            if (ctr%3==0 && ctr%7==0){
            }
            else{
            System.out.println(ctr);}
            ctr++;
        }
        */

        /*#3
        Scanner take=new Scanner(System.in);
        System.out.println("Enter a number");
        int num=take.nextInt();
        int fact=1;
        while(num>0){
            fact*=num;
            num=num-1;
        }
        System.out.println(fact);
        */
        

        /*#2
        Scanner take=new Scanner(System.in);
        System.out.println("Enter a number");
        int num=take.nextInt();
        ArrayList reverse=new ArrayList<>();
        while(num>0){
            reverse.add(num%10);
            num=num/10;
        }
        for (int i = 0; i < reverse.size(); i++) {
            System.out.print(reverse.get(i));
        }
        System.out.println();
        
    }
       */ 


/*
public class Functions extends parent{
    public static void main(String[] args) {
        Functions f=new Functions();
        f.mymeth();
    }
    
    public void mymeth(){
        super.mymeth();//the super is actually to show the super. concept...here it is unncessary to show overriding
        System.out.println("Son");
    }
}
class parent{
    public void mymeth(){
        System.out.println("Parent");
    }
}
*/


/*
public class Functions {
    
    public static void main(String[] args) {
          
        Mobile sam=new Mobile(150,"samsung","android");
        System.out.println(sam.OS);
        System.out.println(sam.company);
        System.out.println(sam.cost);
        for (int i = 0; i < sam.listOfService().length; i++) {
            System.out.println(sam.listOfService()[i]);
        }
    }
}
   
class Mobile{
    int cost;
    String company;
    String OS;
    public Mobile (int cost, String company, String OS){
        this.cost=cost;
        this.company=company;
        this.OS=OS;
    } 
    public String[] listOfService(){
        String[] myList={"call"};
        return myList;
    }
}
    }
    
}
*/