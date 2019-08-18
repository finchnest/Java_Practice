package browser;

import java.awt.Container;
import java.awt.Insets;//the reason we get this is that we can set the specific locations of each components inside the container
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Browser extends JFrame {//allows us to use all the methods inside JFrame class
    private TextField field= new TextField();//to create a text field where the user can enter the html address
    private JEditorPane display=new JEditorPane(); //to create text area where data can be edited
    private JScrollPane scroll= new JScrollPane(display);//to scroll through the text area...what im gonna pass is the object of the text area
    
    public static void main(String[] args){
        Browser file=new Browser();//in other cases we simply could have called other methods...but in this case we cant because non-static methods can 
        file.frameHandler();//not be referenced from static context so we must create an object first
    }
    
    public void frameHandler(){
        setTitle("Abeni Browser");
        setSize(1280,880);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);//to make the frame visible,obviously necessary
        setResizable(true);//customer can not resize it
        setLayout(null);//not dafault but the specific locations and customizations i assigned
        setLocationRelativeTo(null);//making it null causes the frame to be displayed in the middle rather than the dafault setting
        addComponentsToFrame(getContentPane());//passing one function as an argument to another function...both are built in
    }
    
    public void addComponentsToFrame(Container holder){//here "holder" is a place holder to the argument that was passed in the previous method...so technically getContentPane() is equivalent to holder
        Insets insets=getInsets();//the loccations of the edges of out frame
        
        holder.add(field);
        holder.add(scroll);//using my container object to add items to the frame
        
        field.setBounds(8-insets.left,30-insets.top,1270,20);//boundaries of the textfield object
        scroll.setBounds(8-insets.left,52-insets.top,1270,830);//boundaries of the textfield object
        actionListenerCalls();
    }
    private void actionListenerCalls(){
        field.addActionListener(
                new ActionListener(){
                      public void actionPerformed(ActionEvent e){
                            loadData("https://"+ e.getActionCommand());//sends the text we inputed to the internet
        }
    });
       
    }
    private void loadData(String text){
        try{
            display.setPage(text);
        }catch(Exception e){
            System.out.println("Problem found");
        }
    }

}
    

