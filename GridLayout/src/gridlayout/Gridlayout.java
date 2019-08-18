
package gridlayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
public class Gridlayout {

    public static void main(String[] args) {
        

        
        JFrame f=new JFrame();
        String country[] = {"india","aus","u.s.a"};
        String data[][] = {{"df", "aman","dan"},{"erer","abeni","abe"},{"erer","abeni","try"}};

        JButton b1=new JButton("1");
        JButton b2=new JButton("2");
        JButton b3=new JButton("3");
        JButton b4=new JButton("4");
        JButton b5=new JButton("5");
        JButton b6=new JButton("6");
        JButton b7=new JButton("7");
        JButton b8=new JButton("8");
        JButton b9=new JButton("9");
        
        f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);
        f.add(b6);f.add(b7);f.add(b8);f.add(b9);
        
        f.setLayout(new FlowLayout());
        f.setSize(300,300);
        
        f.setVisible(true);
        
       
        
    }

    
}

    
    

