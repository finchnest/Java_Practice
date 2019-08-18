package functions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Functions{

    /*getting messages encoded in separate Strings like decryption
    public static void main(String[] args) {
        HashMap<Character,Integer> mapper=new HashMap<>();
        String[] codes={"abcb", "bab", "deab", "adbe", "abcde", 
            "abcdecb", "edcbaf", "ba", "agaaa", "ad", "fff"};
        for (int i = 0; i < 26; i++) {
            mapper.put(((char) ((int)'a'+i)), i+1);
        }
        for(String s:codes){
           int total=0;
           int n=0;
           for(s.charAt(n);n<s.length();n++){
               for(Entry<Character,Integer> entrys : mapper.entrySet()){
                   if(s.charAt(n)==entrys.getKey())
                       total+=entrys.getValue();
               }
           }
           if(total>26){
               total=total/26;
           }
           for(Entry<Character,Integer> entrys : mapper.entrySet()){
                if(entrys.getValue()==total)
                    System.out.print(entrys.getKey()+"\n");
           }
        }
    } 
    */
    

    /*the number of inversions in a String...taking their ascii order into consideration
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a String");
        String t=in.nextLine().toLowerCase();
        int n=0;
        int inver=0;
                
        for(t.charAt(n);n<t.length();n++){
            int looper=1;
            while(looper<t.length()-n){
                if((int)(t.charAt(n))>(int)(t.charAt(n+looper))){
                    inver++;
                }
                looper+=1;
            }
        }
        System.out.println(inver);
    }
    */
    
    
    
    
   /*check if the sequence is arthimetic
    //to check if a sequence is geometric, we simply convert the 2 minus signs at the bottom to division
    public static void main(String[] args) {
       List<Integer> listy=new ArrayList<>();
       Scanner in=new Scanner(System.in);
       System.out.println("Enter the numbers in your sequence and press -1 to end");
       int n=in.nextInt();
       while(n!=-1){
            listy.add(n);
            n=in.nextInt();
       }
       Functions f=new Functions();
       boolean x=f.arthimetic(listy);
       System.out.println(x);
    }
    public boolean arthimetic(List<Integer> list){
        if(list.size()==1){
            return true;
        }else{
            return (list.get(1))-(list.get(0))==(list.get(list.size()-1))-(list.get(list.size()-2)) && arthimetic(list.subList(1, list.size()));
        }
    }
   */
    
    
   
    
    
    /*nums with their factors
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter a limiting number");
        int n=in.nextInt();
        Map<Integer,Integer> mapper=new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int factors=0;
            int d=1;
            while(d<=i){
                if(i%d==0){
                    factors++;
                }
                d++;
            }
            mapper.put(i, factors);
        }
        //all factors
        System.out.println("Numbers with maximum no of divisors upto "+n+" are: ");
        for(Entry<Integer,Integer> entrys : mapper.entrySet()){
            System.out.println(entrys.getKey()+"  \t"+entrys.getValue());
        }
        //max factors
        System.out.println("Those that have max no of factors");
        int maxValue=Collections.max(mapper.values());//we used the max function from Collections, and to the max() method we passed the values() method which we 
        //get by using our object: mapper. The max function knows to return "the max Value of which collection" through the object we used
        for(Entry<Integer,Integer> entrys : mapper.entrySet()){//enhanced for loop to iterate through mapper.entrySet()
            if(entrys.getValue()==maxValue)
                System.out.println(entrys.getKey()+"--->"+maxValue);
        }
    }
   */
    
    
    

    
    /*squaring evens,but much more: enhanced for loop, custom list, built-in list, appending to the list
    public static void main(String[] args) {
        ArrayList<Integer> evens=new ArrayList<>();
        int[] nums={3,2,5,6,7,11,10};
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==0)
                evens.add(nums[i]);
        }
        for (int x: evens){
            System.out.print(Math.pow(x, 2)+" ");
        }
    }
    */
    
  
    
    
    
    /* letters and number in a sentence
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter a sentence");
        String txt=in.nextLine().toLowerCase();
        String [] ass=txt.split(" ");//using space separator...could've used Regex
        int numbers=0;
        int letters=0;
        for(int i=0;i<ass.length;i++){
            System.out.println(ass[i]);
        }
        for(int i=0;i<txt.length();i++){
            char c=txt.charAt(i);
            if(Character.isDigit(c)){
                numbers+=1;
            }
            else if((int)(txt.charAt(i))<=122 && (int)(txt.charAt(i))>=97){
                letters++;
            }
        }
        System.out.println("Letters: "+letters+" Numbers: "+numbers);
    }  
    */
    
    
    

    
    /*checking apperance of a word in a string and returning the first index its found at
    public static void main(String[] args) {
        String txt="sees paramount green in the red";
        String[] sl=  txt.split(" ");
        String word="paramount";
        Functions f=new Functions();
        int x=f.finder(sl, word);
        System.out.println(x);
    }
    public int finder(String[] sl, String word){
        for(int i=0;i<sl.length;i++) {
            if (sl[i].equalsIgnoreCase(word)) {
                return i;
            }
        }
        return -1;
    }    
    */
    

    
    
    /*GCD finder using recursion
     public static void main(String[] args) {
       Functions f=new Functions();
       Scanner takein=new Scanner(System.in);
       int num1=takein.nextInt();
       int num2=takein.nextInt();
       System.out.println(f.gcd(num1,num2));
    }
    public int gcd(int n1,int n2){  
        if(n1%n2==0)
            return n2;
        return gcd(n2,n1%n2);
    }
    */
    
    

    
    /*sum of digits
    public static void main(String[] args) {
       Functions f=new Functions();
       Scanner takein=new Scanner(System.in);
       int num=takein.nextInt();
       System.out.println(f.sumDigits(num));
    }
    public int sumDigits(int n){  
        if(n==0)
            return 0;
        return n%10+sumDigits(n/10);
    }
    */
    
    

    
    /*finding the the count of each word in a string and the most frequent one
    public static void main(String[] args) {
        Scanner takein=new Scanner(System.in);
        System.out.println("Enter any Text");
        String txt=takein.nextLine().toLowerCase();
        String[] ass=  txt.split(" ");

        String s;
       //initializing HashMap constructor...mapper maps strings to their occurence values
        Map<String,Integer> mapper= new HashMap<>();
        for (String v : ass) {
            s = v;
            int count;
            if(mapper.containsKey(s)){
                count=mapper.get(s)+1;
            }else{
                count=1;
            }
            mapper.put(s, count);//updates the status of key-to-value association every time the loop runs
        }//now the mapper is full
        
        System.out.println("\nWord\tCount");
        for(Entry<String,Integer> entrys : mapper.entrySet()){//mapper.entrySet() is like mapper.items() in python & entrys is like k,v
            System.out.println(entrys.getKey()+"  \t"+entrys.getValue());
            
        }
      
        System.out.println("The most frequent words are: ");
        int maxValue=Collections.max(mapper.values());
        for(Entry<String,Integer> entrys : mapper.entrySet()){//enhanced for loop to iterate through mapper.entrySet()
            if(entrys.getValue()==maxValue)
                System.out.println(entrys.getKey()+"--->"+maxValue);
        }
    }   
    */
    
    
    

   /*finding the frequency of each letter in the inputed string or sentence
      public static void main(String[] args) {
        Scanner takein=new Scanner(System.in);
        System.out.println("Enter any Text");
        String txt=takein.nextLine();
        txt=txt.toLowerCase();
        char c;
       
        Map<Character,Integer> mapi= new HashMap<>();//using the HashMap from the big Map class
        for(int i=0;i<txt.length();i++){
            c=txt.charAt(i);
            if(Character.isLetter(c)){
                int count;
                if(mapi.containsKey(c)){//returns true if the key is in the map
                    count=mapi.get(c);//returns the value to which the specified key is mapped...imagine it like this mapi={"h":1,"e":2};
                    count++;
                }else{
                    count=1;
                }
                mapi.put(c, count);//associates the specified value with the specified key in the map
            }
        }
        System.out.println("\nLetter\tCount");
        for(Entry<Character,Integer> entrys : mapi.entrySet()){//mapper.entrySet() is like mapper.items() in python & entrys is like k,v
            System.out.println(entrys.getKey()+"  \t"+entrys.getValue());
        }

        System.out.println("The most frequent letters are: ");
        int maxValue=Collections.max(mapi.values());
        for(Entry<Character,Integer> entrys : mapi.entrySet()){//enhanced for loop to iterate through mapper.entrySet()
            if(entrys.getValue()==maxValue)
                System.out.println(entrys.getKey()+"--->"+maxValue);
        }
   
    }
     */
    

    
    
    /*palidrome next level
    public static void main(String[] args) {
        Scanner takein=new Scanner(System.in);
        Functions get=new Functions();
        System.out.println("Enter the string");
        String t=takein.nextLine();
        System.out.println(get.pali(get.cleaner(t)));
    }
    public String cleaner(String tt){
        String t1=tt.toLowerCase();
        String newer="";
        for (int i = 0; i < t1.length(); i++) {
            char c=t1.charAt(i);
            if(Character.isLetter(c)){
                newer+=c;
             }
        }
        return newer;
    }
    public boolean pali(String texti){
        if(texti.length()<=1){
            return true;
        }
        else{
            return texti.charAt(0)==texti.charAt(texti.length()-1) && pali(texti.substring(1, texti.length()-1));
        }
    }
    */
    
    

    
    /*Area of circle using three methods
    public static void main(String[] args) {
        Scanner takein=new Scanner(System.in);
        Functions get=new Functions();
        System.out.println("Enter the coordiantes respectively");
        int x1=takein.nextInt();
        int y1=takein.nextInt();
        int x2=takein.nextInt();
        int y2=takein.nextInt();
        System.out.println(get.area(get.radius(x1,y1,x2,y2)));
        
    }
    public double radius(int x1,int y1,int x2,int y2){
        double dis=Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1, 2));
        return dis;
    }
    public double area(double rad){
        double areaT=Math.PI*Math.pow(rad, 2);
        return areaT;
    }
    */
    
    

    
    /*encryption decryptions
    public static void main(String[] args) {
        Scanner takein = new Scanner(System.in);
        String s="the quick brown fox jumped over the lazy dog";
        String u="wkh txlfn eurzq ira mxpshg ryhu wkh odcb grj";
//        String t=takein.nextLine();
//        System.out.println("Enter encryption key");//use these for customized encryption
//        int k=takein.nextInt();
//        for (int i = 1; i <= 26; i++) {
//            System.out.println(decrypt(t, i));
//        }
        System.out.println(encrypt(s,3));
        System.out.println(decrypt(u, 3));
        
    }
    
     public static String decrypt(String text,int key){
        String lower=text.toLowerCase();
        String newer="";

        for (int i = 0; i < lower.length(); i++) {
            char c=lower.charAt(i);
            if(Character.isLetter(c)){
                newer+=((char)((((int)c-97)-key)%26+97));
            }else{
                newer+=c;
            }
        }
           return newer;
       }
     public static String encrypt(String text,int key){
        String lower=text.toLowerCase();
        String newer="";

        for (int i = 0; i < lower.length(); i++) {
            char c=lower.charAt(i);
            if(Character.isLetter(c)){
                newer+=((char)((((int)c-97)+key)%26+97));
            }else{
                newer+=c;
            }
        }
           return newer;
       }
   */ 

}
