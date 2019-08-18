package inher;

/*multilevel inheritance
class ClassA {
    public void dispA(){
        System.out.println("Grand Parent");
    }
}

class ClassB extends ClassA {
    public void dispB(){
        System.out.println("Parent");
    }
}

public class Inher extends ClassB{
    
    public static void main(String args[]){
        Inher son = new Inher();
        son.dispA();
        son.dispB();
        son.dispC();
    }
    public void dispC(){
        System.out.println("Son");
    }
}
*/


/*hierchical inheritance
public class Inher extends ClassB{

    public static void main(String args[]){
        ClassC c = new ClassC();
        c.dispA();
        c.dispC();
    }
}
class ClassA {
    public void dispA(){
        System.out.println("Parent");
    }
}
class ClassB extends ClassA {
    public void dispB(){
        System.out.println("sonnn1");
    }
}
class ClassC extends ClassA {
    public void dispC(){
        System.out.println("sonnn2");
    }
}
*/

/* multiple inheritance

>>> an object stores its state in fields...so java avoids MI to avoid the issues 
of multiple inheritance of state, which is the ability to inherit fields 
from multiple classes

>>> What if methods or constructors from different superclasses instantiate the 
same field? Which method or constructor will take precedence?

>>> compilers cannot determine which member or method to access or invoke*

>>> both the objects of A will behave differently
*/

/*interfaces

---interfaces are not is-a relationship things like inheritance...more like the implementing class does something...the thing that is done being found in the interface

---since we cant extend more than one class, interfaces provide an easy way to make
an object of multiple types: the type of its own class and the types of all the 
interfaces that the class implements

---this won't cause any problems as long as the interfaces that are implemented by
a class do not have same fields. if so then there will be compilation time error.
but having same methods in 2 interfaces and implenting both of these interfaces wont 
cause problem 'cause the methods are abstract so the compiler will choose one when
that method is invoked

---methods in interfaces are abstract so the implementing class can implement those
methods in a way it wants.(their own implementation)

---interfaces dont need an object so the data that the object of implementing class
holds will be manipulated or changed without the need of interface's object(no obj)

---main use of interface is to facilitate polymorphism. interface allows a class 
to behave like multiple types
*/

/*abstract classes
--- we don't know the implementation for the draw method so the concrete class that 
extends this class can implement it.

---they also dnt allow object creation like interfaces
---abstract classes are flexible in declaring the methods. You can define 
abstract methods or non-abstract methods so providing implementations for only some.
---interface...provides common functionality to unrelated classes
---abstract classes...creating something for objects that are closely related in a hierarchy

*/

/*
overriding is simply providing a different implemenation to a method that is already found
in the parent class. both the parent and the child class have methods with the same name
but the way the implement it is different


overloading refers to two or more methods with the same name but different no, or data type,
of arguments. so they are called based upon the argument type that is passed to the method.
*/


/*static methods
---Static methods can not be overridden because they are not part of the object's 
state. Rather, they belongs to the class
---It is ok to overload static (and final) methods

*/


/*The aggregate class contains a reference to another class and is said to have 
ownership of that class. Each class referenced is considered to be part-of 
the aggregate class.

public class Subject {
  private String name;
  public void setName(String name)
  {
    this.name = name;
  }
  public String getName()
  {
    return name;
  }
}
public class Student {
  private Subject[] studyAreas = new Subject[10];
  //the rest of the Student class
}
*/


/*
       
        for (int i = 0; i < s.length(); i++) {
            if((int)s.charAt(i)>=65 && (int)s.charAt(i)<=90){
                   t+=(char)((int)s.charAt(i)+32);

            }else if((int)s.charAt(i)>=97 && (int)s.charAt(i)<=122){
                   t+=(char)((int)s.charAt(i)-32);
            }
        }
        
        System.out.println(t); 
        }

*/

