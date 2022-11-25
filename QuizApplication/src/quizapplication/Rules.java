
package quizapplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame  implements ActionListener{
    JButton start,back;
    String name;
    Rules(String name) {
        this.name = name;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome "+ name +" to Quizholic");
        heading.setBounds(50,30,800,45);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        heading.setForeground(new Color(21,188,213));
        add(heading);
        
       // ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("images/remember2.png"));
       //JLabel image = new JLabel(im);
       //image.setBounds(600,100,300,325);
       // add(image);
        
        JLabel rules = new JLabel();
        rules.setBounds(30,90,800,300);
        rules.setFont(new Font("Tahoma",Font.PLAIN,15));
        //rules.setForeground(new Color(21,188,213));
        rules.setText(
            "<html>"+ 
                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
            "<html>");

        add(rules);
        
        
         back = new JButton("Back");
        back.setBounds(280,400,120,25);
        back.setBackground(new Color(93,227,247));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        start = new JButton("Let's Play");
        start.setBounds(470,400,120,25);
        start.setBackground(new Color(93,227,247));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
         setSize(900,550);
         setLocation(150,100);
         setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae){
           if(ae.getSource() == start){
               setVisible(false);
               new Quiz(name);
     
               
           } else if(ae.getSource() == back){
               setVisible(false);
               new Login();
           }
           
       }
   // public  void actionPerformed(ActionEvent ae){
     //      if(ae.getSource() == start){
               //String name = tfname.getText(); //get what user type in textbox
       //        setVisible(false);
              // new Rules(name);
               
         //  } else if(ae.getSource() == back){
           //    setVisible(false);
           //}
           
       //}
   
    public static void main(String[] args){
        new Rules("User"); //anonymous object
       
    }

}