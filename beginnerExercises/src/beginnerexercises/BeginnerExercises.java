package beginnerexercises;

public class BeginnerExercises {
    public static void main(String[] args) {
  
        
     Prac onetime=new Prac();
     
     //System.out.println(onetime.toMilitary());
     System.out.println(onetime.toNormal());
     
     onetime.setTime(13,15,36);//we take nums for formality since the method expects 3 arguments...but they r gonna get replaced 
     //System.out.println(onetime.toMilitary());
     System.out.println(onetime.toNormal());


        
        
    /*taking variable length arguments
    public static void main(String[] args) {
        System.out.println(average(45,423,375,53,34));
    }
    int total=0;
    public static int average(int...nums){//this line of code, when compiled, creates a variable length array named nums...like this...nums={...}
        //no need for braces if it's one statement
        for(int x:nums)//this enhanced for loop is like "for x in someArray" technique in python...read ":" as "in" and its logical
            total+=x;
        return total/nums.length;   //since nums is an array, it has a length
    }  */
    
}  
}
