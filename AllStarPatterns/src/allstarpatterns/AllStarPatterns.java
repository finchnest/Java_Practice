package allstarpatterns;
import java.util.Scanner;
public class AllStarPatterns {

    public static void main(String[] args) {
        Scanner takein=new Scanner(System.in);
        
        
        
       
        /*amazing triangle with empty interior
        int spacer=12;
        int inSpacer=1;
        int limiter=1;
        for (int d=1;d<=spacer;d++){
            System.out.printf("%s"," ");
        }
        spacer-=2;
        System.out.println("#");
        for(int i=1;i<=5;i++){
            for(int r=1;r<=spacer;r++){
                System.out.printf("%s"," ");
            }
            spacer-=2;
            System.out.printf("%s","#");
            for(int q=1;q<=inSpacer;q++){
                System.out.printf("%2s"," ");
            }
            inSpacer+=2;
            System.out.printf("%s","#");
            System.out.println("\n");
        }
        for(int w=1; w<=7;w++){
            System.out.printf("%s %2s","#"," ");
        }
        */
                
        
        
        /*
         for(int a=1,b=10,c=11,d=20;a<=10;a++,b--,c++,d--){
            System.out.println(a+" "+b+" "+" "+c+" "+d);}
        */
        
 
                
        /* right triangle with empty internal
        for (int m=1; m<=2; m++){
            for(int u=1; u<=m;u++){
                System.out.printf("%s" ,"@");}
            System.out.println("\n");
        }
        int limiter=1;
        for(int i=1;i<=3;i++){
            System.out.printf("%s","@");
            for(int v=1; v<=limiter;v++){
                System.out.printf("%s"," ");}
            limiter+=1;
            System.out.printf("%s","@");
            System.out.println("\n");
        }
        for(int w=1; w<6;w++){
            System.out.printf("%s","@");}
         */  
        
  
        
        /*combined trianglge in rhombus shape
        System.out.println("Enter the size of your triangle");
        int size=takein.nextInt();
        int spaces=2*size-2;
        int spaces2=2;
        for(int i=1;i<=size;i++){
            for(int u=1; u<=spaces;u++){
                System.out.printf("%s"," ");
            }
            spaces-=2;
            for(int v=1; v<=i;v++){
                System.out.printf("%s %2s","*"," ");
            }
            System.out.println("\n");
            }
        for(int i=size-1;i>0;i--){
            for(int u=1; u<=spaces2;u++){
                System.out.printf("%s"," ");
            }
            spaces2+=2;
            for(int v=size-1; v>0;v--){
                System.out.printf("%s %2s","*"," ");
            }
            size-=1;
            System.out.println("\n");
        }
       */
        
        
        
        /*Equilateral triangle intverted
        System.out.println("Enter the size of your triangle");
        int size=takein.nextInt();
        double spaces=0;
        for(int i=size;i>0;i--){
            for(int u=1; u<=spaces;u++){
                System.out.printf("%s"," ");
            }
            spaces+=2;
            for(int v=size; v>0;v--){
                System.out.printf("%s %2s","*"," ");
            }
            size-=1;
            System.out.println("\n");
        */
        
        
        
       // /* normal equilateral trianlge
        System.out.println("Enter the size of your triangle");
        int size=takein.nextInt();
        double spaces=2*size-2;
        for(int i=1;i<=size;i++){
            for(int u=1; u<=spaces;u++){
                System.out.printf("%s"," ");
            }
            spaces-=2;
            for(int v=1; v<=i;v++){
                System.out.printf("%s %2s","*"," ");
            }
            System.out.println("\n");
            }
       //  */
        
        
        
        /*
        System.out.println("Enter the size of your star");
        int size=takein.nextInt();
        int spaces=0;
        while (size>0){
            for(int u=1; u<=spaces;u++){
                System.out.printf("%s"," ");
            }
            spaces+=3;
            for(int z=size; z>0;z--){
                System.out.printf("%s %s","*"," ");
            }
            size-=1;
            System.out.println("\n");
            }
        */
        
 
        
        /* Right Triangle inverted
        System.out.println("Enter the size of your star");
        int size=takein.nextInt();
        while (size>0){
            for(int z=size; z>0;z--){
                System.out.printf("%s %s","*"," ");
            }
            size-=1;
            
            System.out.println("\n");
            }
      */
        
        
        /* Right Trianlge shifted by 180 degree
        System.out.println("Enter the size of your star");
        int size=takein.nextInt();
        int spaces=3*size-3;
        for(int i=1;i<=size;i++){
            for(int u=1; u<=spaces;u++){
                System.out.printf("%s"," ");
            }
            spaces-=3;
            for(int z=1; z<=i;z++){
                System.out.printf("%s %s","*"," ");
            }
            System.out.println("\n");
        }
        */
        
        
        
       /* 
        System.out.println("Enter the size of your star");
        int size=takein.nextInt();
        for(int i=1;i<=size;i++){
            for(int u=1; u<=i;u++){
                System.out.printf("%s %s","*"," ");
            }
            System.out.println("\n");
        }
        */
    }
}
