/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import java.io.IOException;

/**
 *
 * @author Abeni
 */
public class Exception {

    public void start() throws IOException{}
    public  void foo() throws NullPointerException{}
     
}
 public class Exception2 extends Exception{//Exception2 can not be a public class so the key word 'public' should be removed

    
    
    public void start() throws Exception{}//exception object can not be converted to throwable so the IOException should be thrown
    //not the general Exception....and also the start method here does not override the start() method in the parent class
    
    @Override
    public void foo() throws RuntimeException{}
    
        public static void main(String[] args) {
        try{
            
            foo();//non static method foo() can not be referenced from a static context...so new Exception2().foo()
        }catch(IOException e){//IO Exception is never thrown in the body of a try statement...so other kinds of exceptions should be handled here
            e=new Exception("");//the constructor of exception does not take any arguments and also IOException is never thown in try statement
            e.printStackTrace();
        }
        
    }
    
    
}
