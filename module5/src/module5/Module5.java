
package module5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Module5  {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton();
        JTextField textfield = new JTextField();
        
        textfield.setBounds(200, 100, 200, 40);
        
        button.setBounds(200, 200, 100, 40);
        button.setText("click here");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                        System.exit(0);

            }
            
        
        });
        
        frame.setLayout(null);
        frame.add(textfield);
        frame.add(button);
        frame.setSize(609,509);
        frame.setLocation(300, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    
    
}
