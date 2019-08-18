package easyones;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;
import java.util.Collections;
public class EasyOnes { 
    public static void main(String[] args) {
        Scanner takein=new Scanner(System.in);
        
        String s="aBeN";
        String t="";
        
        for (int i = 0; i < s.length(); i++) {
            if((int)s.charAt(i)>=65 && (int)s.charAt(i)<=90){
                   t+=(char)((int)s.charAt(i)+32);

            }else if((int)s.charAt(i)>=97 && (int)s.charAt(i)<=122){
                   t+=(char)((int)s.charAt(i)-32);
            }
        }
        
        System.out.println(t); 
        }
        
        /*ArrayList getting the Nth item
        ArrayList<Integer> tens=new ArrayList<>();
        int multi=10;
        for (int i = 0; i < 10; i++) {
            tens.add(multi*i);   
        }
        System.out.println(tens.get(tens.size()-1));
        */
          
        
       
        /*left Addition
        int[][] arr={{2,0,4,4},{2,0,2,4},{4,2,4,4},{0,4,2,4}};
        List<ArrayList<Integer>> mata=new ArrayList();
        
        for(int row=0; row<arr.length;row++){ 
            ArrayList<Integer> prep=new ArrayList();
            for(int column=0;column<arr[row].length;column++){
                prep.add(arr[row][column]);
            }
            mata.add(prep);
        }
        
        int[][] end=new int [mata.size()][mata.size()];
        for(int row=0;row<mata.size();row++){
            ArrayList<Integer> merged=new ArrayList();//merged is of data type Integer[]
            int size=(mata.get(row)).size();
            for(int colVal=0;colVal<size;colVal++){
                if((mata.get(row)).get(colVal)!=0)
                    merged.add((mata.get(row)).get(colVal));
            }
            for(int u=0;u<merged.size()-1;u++){
                if(merged.get(u)==merged.get(u+1)){
                    merged.set(u, (merged.get(u))*2);
                    merged.remove(u+1);
                }
            }
            while(merged.size()<size){
                merged.add(0);
            }
            int[] mapper=merged.stream().mapToInt(i->i).toArray();//the CENTER of this method: mapping Integer[] to int[]
            end[row]=mapper;//mapper is of data type int[]...means its an array of a primitive data type int
        }
        for (int row = 0; row < end.length; row++) {
                for (int column = 0; column < end[row].length; column++) {
                    System.out.print(end[row][column]+" ");
                }
                System.out.println();
        }
        */
                
        
        
        /*matrix transpose
        int[][] matt=new int[4][4];
        int[][]mat={{1,3,0,34},{3,12,6,4},{7,2,8,1},{13,5,2,2}};
        
        for (int x = 0; x < mat.length; x++) {
            for (int y = 0; y < mat[0].length; y++) {
                if(x==y)
                    matt[x][y] = mat[x][y];
                else
                    matt[x][y] = mat[y][x];
            }
        }
        for (int i = 0; i <matt.length; i++) {
            for(int j=0;j<matt[0].length;j++){
                System.out.print(matt[i][j]+"   ");
            }
            System.out.println();
        }
        */
        
        
                
       /*swapping elements of an ArrayList       
        ArrayList<Integer> list=new ArrayList<>();
        list.add(12);
        list.add(2);
        list.add(14);
        list.add(10);
        list.add(6);
        list.add(8);
        list.add(4);
        System.out.println(list);
        for (int i = 0; i < list.size()/2; i++) {
            Collections.swap(list,i,list.size()-1-i);
        }
        System.out.println(list);
        */
        
        
        
        /*Swapping elements of an ARRAY: MultiDimensional
        int[][]mat={{1,3,2,4},{12,6,4,9,1},{13,7,2,8,14}};
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length/2;j++){
                 int a=mat[i][j];
                 mat[i][j]=mat[i][mat[i].length-1-j];
                 mat[i][mat[i].length-1-j]=a;
            }
        }
        for (int i = 0; i <mat.length; i++) {
            for(int j=0;j<mat[i].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        *///in an Array, whether its multidimensional or not, we can not print out the elements of the Array by simple sout, but in an ArrayList we can

        
        

        /*isbn filling the last digit
        String num="020131452";
        String[] v=new String[9];
        for(int i=0,j=1;i<num.length();i++,j++){
            v[i]=num.substring(i, j);
        }
        int n=0;
        int ctr=10;
        int total=0;
        while(ctr>1){
            total+=(Integer.parseInt(v[n]))*ctr;
            ctr--;
            n++;
        }
        for(int g=0;g<10;g++){
            if((total+g)%11==0){
                System.out.printf("%d, The ISBN no is %s\n",g,num+Integer.toString(g));
        }
        */
        
        
        
        
        /*quadrupling the vowels
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the text");
        String txt=in.nextLine();
        String k="";
        char[] vowels={'a','e','i','o','u'};
        for(int i=0;i<txt.length();i++){
            char c=txt.charAt(i);
            if((int)c==97 || (int)c==101 || (int)c==105 || (int)c==111 || (int)c==117){
                k+=c;k+=c;k+=c;k+=c;
            }
            else{
                k+=c;
            }
        }
        System.out.println(k);
        */
        
        
  
       /*telling money in all the notes available
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the money");
        int money=in.nextInt();
        if(money%10<5)
            System.out.println(money%10+" ones");
        else if(money%10==5)
            System.out.println("1 fives");
        else{
            System.out.println((money%10)%5+" ones");
            System.out.println("1 fives");
        }
        if((money/10)%10<5)
            System.out.println((money/10)%10+" tens");
        else if((money/10)%10==5)
            System.out.println("1 fifties");
        else{
            System.out.println(((money/10))%5+" tens");
            System.out.println("1 fifties");
        }
        System.out.println(money/100+" hundreds");
        */
        
        
        
        
        /*the last digit first
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        String num=in.nextLine();
//        int m=Integer.parseInt(num);
//        String k=Integer.toString(m%10);
        String p=num.charAt(num.length()-1)+"";//can do this easily, but converting the int to string also works
        for (int i = 0; i < num.length()-1; i++) {
             p+= num.charAt(i);
        }
        System.out.println(Integer.parseInt(p)+1);//making it ready for arthimetics
        */
        
        
        
        
        /*armestrong number
        for (int i = 2; i < 1000; i++) {
            int d1=i%10;
            int d2=(i/10)%10;
            int d3=i/100;
            if((Math.pow(d1, 3)+Math.pow(d2, 3)+Math.pow(d3, 3))==i){
                System.out.println(i+" is an armstrong number");
            }
            
        }
        */

        
        
        
        /*
        String x="1038";
        System.out.println("Guess a number");
        String y=in.nextLine();
        int cats=0;
        int dogs=0;
        A: while (cats<=4){
            cats=0;
            dogs=0;
            for(int i=0;i<x.length();i++){
                for(int j=0;j<y.length();j++){
                    if(i==j && x.charAt(i)==y.charAt(j)){
                        cats++;
                    }
                    else if(i!=j && x.charAt(i)==y.charAt(j)){
                        dogs++;
                    }
                }
            }
            if(cats==4){
                System.out.println("You Won");
                break A;
            }
            System.out.println("You have "+cats+" and "+dogs+" dogs");
            System.out.println("Guess Again");
            y=in.nextLine();
                    
        }
        */
    
     

    /*
    String h="hello world";
         for (int i = 0,j=1; i < h.length(); i++,j++) {
            System.out.println(h.substring(i,j));
        }
    */

        
    
    
    /*
    for (int i = 0; i < 26; i++) {
        System.out.println((char) ((int)'a'+i));
    }
    */

    
    
    /*
    String a="angel";
    String b="ANGEL";
    if(a.equalsIgnoreCase(b))
            System.out.println("yes they are");
    */


    
    
        /*UNFINISHED try catch and do while loop together 
        Scanner takein=new Scanner(System.in);
        int x=1;
        A: do{
        try{
            System.out.println("Enter the numerator");
            int n1=takein.nextInt();
            System.out.println("Enter the Denominator");
            int n2=takein.nextInt();
            System.out.println("result: "+n1/n2);
            
            
        }catch(Exception e){//this catch block will never run unless there occurs an error in the try block
            System.out.println("u made error");
        }
        }while(x==1);
        
   */
    

    //System.out.println(Math.sin(Math.toRadians(30)));
    

   /*Swapping the contents of two Arrays...WRITE THE BEST ALGORITHM: TIME, MEMORY, STEPS
    int[] s1=new int[3];
    int[] temp1=new int[3];
    int[] s2=new int[3];
    
    System.out.println("enter the indices of the first array");
    for(int u=0;u<=2;u++){
        s1[u]=takein.nextInt();
        temp1[u]=s1[u];
    }
    System.out.println("enter the indices of the second array");
    for(int u=0;u<=2;u++){
        s2[u]=takein.nextInt();
    }
    
    for(int u=0;u<=2;u++){
        s1[u]=s2[u];
    }
    for(int u=0;u<=2;u++){
        s2[u]=temp1[u];
    }
    
    System.out.println("changed indicies of array1: ");
    for(int u=0;u<=2;u++){
        System.out.println(s1[u]);
    }
    System.out.println("changed indicies of array2: ");
    for(int u=0;u<=2;u++){
        System.out.println(s2[u]);
    }
    */
   
    
    
    /*swapping the position of two numbers
    System.out.println("fill ur array");
    int[] arr= new int[10];
    for(int i=0; i<=9; i++){
        arr[i]=takein.nextInt();
    }
    System.out.println("enter numbers from ur array");
    int a=takein.nextInt();
    int b=takein.nextInt();
    for(int t=0;t<=9;t++){
        if(a==arr[t])
            arr[t]=b;
        else if(b==arr[t])
            arr[t]=a;
    }
    for(int i=0; i<=9;i++){
        System.out.print(arr[i]+" ");
    }
    */
    
    
    
    /*the second min and the second max of an array...ALGORITHM...Nice One
    int[] arry= {170,600,12,1000,5,230,15,4,23,90};
    int max=arry[0];
    int max2=arry[0];
    int min=arry[0];
    int min2=arry[0];
   
    for(int i=1; i<=9;i++){
        if(arry[i]> max)
            max=arry[i];}//no need for else statement because the status will remain as it is since we put no code for else.
    for(int i=1; i<=9;i++){
        if(arry[i]<min)
            min=arry[i];}
    
    if(arry[0]==max) max2=arry[1];
    if(arry[0]==min) min2=arry[1];
    
    for(int k=1; k<=9;k++){
        if(arry[k]<max && arry[k]>max2) 
            max2=arry[k];}
    for(int k=1; k<=9;k++){
        if(arry[k]>min && arry[k]<min2) 
            min2=arry[k];}
    
    System.out.println("the second max is "+max2);
    System.out.println("the second min is "+min2);
    */
    
   

    
   /*Adding elements of two arrays into third one artistically
    int[] arr1= {1,2,3,4,5,6,7,8,9,10};
    int[] arr2= {11,12,13,14,15,16,17,18,19,20};
    int[] arr3=new int [20];
    int k=0,m=0;
    for(int i=0;i<=19;i++){
        if (i%2==0){
            arr3[i]=arr1[k];
            k++;                          
        }                          
        else{  
            arr3[i]=arr2[m];
            m++;
        }
     }
    for(int p=0;p<=19;p++){
        System.out.printf("%d %s",arr3[p]," ");
    }
    */

    
            
    /*Total primes upto some number and max of them
    System.out.println("Enter a number");
    int n=takein.nextInt();
    int primes=0;
    int ctr=2;
    int max=ctr;
    while (ctr<n){
        int divisor=1;
        int total=0;
        while(divisor<=ctr){
            if (ctr%divisor==0 ){
                total+=1;}
                
            divisor++; 
        }
        if(total==2){
            max=ctr;
            primes++;
        }
        ctr++;
    }
    System.out.println("total primes "+ primes);
    System.out.println("max of them "+ max);
    */
    
    

    /*total and product of all nums in a given range
    System.out.println("enter the first num");
    int n1=takein.nextInt();
    System.out.println("enter the second num");
    int n2=takein.nextInt();
    if (n1<n2){
        int sum=0;
        int product=1;
        for (int x=n1+1;x<n2;x++){
            sum+=x;
            product*=x;   
        }
        System.out.println("sum is "+sum+" product is "+ product);
    }
    else if(n1>n2){
        int ns=n1;
        n1=n2;
        n2=ns;
        int sum=0;
        int product=1;
        for (int x=n1+1;x<n2;x++){
            sum+=x;
            product*=x;   
        }
        System.out.println("sum is "+sum+" product is "+ product);
    }
   */
    
    
    
    /*sum of all evens from 1 to 100
    int total=0;
    for(int i=1; i<=100; i++){
        if (i%2==0)
            total+=i;
    }
    System.out.println(total);
    */
    
    
    
    /*root finder program
     System.out.println("Enter the coefficients a, b, and c respectively");
        double a=takein.nextDouble();
        double b=takein.nextDouble();
        double c=takein.nextDouble();

        double  dis=(Math.pow(b, 2))-4*a*c;
        if (dis<0)
             System.out.println("it has no roots");
        else if (dis==0)
             System.out.println("it has one root and that is 0");
        else
             System.out.println("the roots are "+ (b+Math.sqrt(dis))/2*a + " and "+ (-b+Math.sqrt(dis))/2*a);
    */
    
    
    
    /*the GCD of two customer-enter numbers
    List <Integer> CDs = new ArrayList<>();
    System.out.println("Enter the first number");
    int num8=takein.nextInt();
    System.out.println("Enter the second number");
    int num9=takein.nextInt();
    for (int d=1; d<=num8;d++){
        for (int e=1; e<=num9; e++){
            if (num8%d==0 && num9%e==0 && d==e)
                CDs.add(d);
               }
    }
    System.out.println("The Greatest common factor is "+ " "+ CDs.get(CDs.size()-1));
    */
   
    
    
    /*the number of occurence of a given digit in a number 
    System.out.println("Enter the number");
    int num5=takein.nextInt();
    System.out.println("enter the digit ur looking for");
    int num6=takein.nextInt();
    int ctr=0;
    while (num5!=0){
        if (num5 % 10==num6)
            ctr++;
        num5=num5/10;
    }
    System.out.println("the total number of occurences is " + ctr);
   */
    
    
    
    /*the number of digits in a number
    System.out.println("Enter a number");
    int num5=takein.nextInt();
    int ctr=0;
    while(num5>0){
        num5=num5/10;
        ctr++;
    }
    System.out.println("the number of digits in the number is "+ctr);
    */
    
    
    
    /*factorial  
     System.out.println("enter the number");
     int num=takein.nextInt();
     int factor=1;
     while(num>0){
         factor*=num;
         num--;
     }
     System.out.println(factor);
    */
    
    
    
    /*hailstone sequence
    System.out.println("Enter a number to see the hailstone sequence");
    int num5=takein.nextInt();
    while (num5!=1){
       if (num5%2==0){
           num5=num5/2;
           System.out.println(num5);
       }
       else{
           num5=3*num5+1;
           System.out.println(num5);
       }
    }
    */
    
    
    
    /*n prime numbers
    System.out.println("Enter a number");
    int num4=takein.nextInt();
    int primes=0;
    int ctr=2;
    while (primes<num4){//here the total primes must be equal to the given num...but the previous one was primes upto the given num
        int divisor=1;
        int total=0;
        while(divisor<=ctr){
            if (ctr%divisor==0 ){
                total+=1;}
                
            divisor++; 
        }
        if(total==2){
            System.out.println(ctr);
            primes++;
            }
        ctr++;
    }
    */
   
    
    
    /*total of factorial of numbers upto a given number
    System.out.println("Enter a number");
    int cust=takein.nextInt();
    int total=0;
    for(int i=1;i<=cust;i++){
        int factor=1;
        while(i>0){
                factor=factor*i;
                i--; 
        }
        total+=factor;
    }
    System.out.println("total of all the factorials  is "+ total);
    */
    
    
    
    /*
    System.out.println("Enter a number");
    double per=takein.nextInt();
    int total=0;
    int divisor=1;
    while(divisor<per){
        if (per%divisor==0 )
            total+=divisor;
        divisor++; 
    }
    if(total==per){
        System.out.println("its a perfect number");}
    else{
    System.out.println("it is not perfect");}
    */
    
    
    
    /*guess number game
    Random rand=new Random();
    int  randnum=rand.nextInt(101);//nums upto 100
    System.out.println("guess a number in range of 100");
    int  guess=takein.nextInt();
    int chance=1;
    while(chance<=7){
        if (guess==randnum ){
                System.out.println("you found the number");
                   break;}

        else if (guess!=randnum){
            if (guess<randnum){
                System.out.println("guess higher");
                   }
            else{
                System.out.println("guess lower");

            }
        } 
        System.out.println("try again");
        guess=takein.nextInt();
    }
    if(chance>7){
        System.out.println("game over");}
   */
    
    
    
    /*number is prime or not
    System.out.println("Enter a number");
    double num3=takein.nextInt();
    int total=0;
    int divisor=1;
    while(divisor<=num3){
        if (num3%divisor==0 )
            total+=1;
        divisor++; 
    }
    if(total==2){
        System.out.println("its a prime number");}
    else{
    System.out.println("it is not prime");}
    */
    

    
    /*sum of divisors a number
    System.out.println("Enter a number");
    double num2=takein.nextInt();
    int total=0;
    int divisor=1;
    while(divisor<=num2){
        if (num2%divisor==0 )
            total+=divisor;
        divisor++;
         
     }
    System.out.println("The sum of divisors of the number is " + total);
    */

    
    
    /*
     System.out.println("Enter a number");
     double num=takein.nextInt();
     int total=0;
     while(num>0){
         total+=num%10;
         num=Math.floor(num/10);
     }
     System.out.println("The sum of the digits of the number is " + total);
    */
    }