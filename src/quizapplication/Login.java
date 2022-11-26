package quizapplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener {
    JButton rules,back;
    JTextField tfname; //globaly define button 
    Login(){
          
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("images/quiztime.jpg"));
        JLabel image = new JLabel(im);
        image.setBounds(0,0,550,550);
        add(image);
        
        JLabel heading = new JLabel("Quizholic");
        heading.setBounds(700,60,300,45);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        heading.setForeground(new Color(21,188,213));
        add(heading);
        
        JLabel name = new JLabel("Enter your name");
        name.setBounds(700,150,350,30);
        name.setFont(new Font("Mangolian Baiti",Font.BOLD,20));
        name.setForeground(new Color(21,188,213));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(650,200,250,25);
        tfname.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(tfname);
        
        back = new JButton("Back");
        back.setBounds(620,280,120,25);
        back.setBackground(new Color(93,227,247));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        rules = new JButton("Start");
        rules.setBounds(820,280,120,25);
        rules.setBackground(new Color(93,227,247));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);
        
        
        
        
        setSize(1000,550);
        setLocation(150,100);
        setVisible(true);
        }
    
    //for click event on buttons
       public  void actionPerformed(ActionEvent ae){
           if(ae.getSource() == rules){
               String name = tfname.getText(); //get what user type in textbox
               setVisible(false);
               new Rules(name);
               
           } else if(ae.getSource() == back){
               setVisible(false);
           }
           
       }
    
    public static void main(String[] args){
        new Login(); //anonymous object
       
    }
}
