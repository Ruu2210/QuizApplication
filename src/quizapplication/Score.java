

package quizapplication;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    //make changes heree 
        Score(String name,int score){
        setBounds(200, 50, 1000, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("images/welldone.jpg"));
        JLabel image = new JLabel(im);
        image.setBounds(30, 0, 900, 250);
        add(image);

        JLabel yourscore = new JLabel("Your Score is "+score);
        yourscore.setBounds(380, 300, 300, 25);
        yourscore.setFont(new Font("Tahoma", Font.BOLD, 30));
        yourscore.setForeground(new Color(21,188,213));
        add(yourscore);
        
        JButton playagain = new JButton("Play Again");
        playagain.setBounds(420,360,150,25);
        playagain.setFont(new Font("Tahoma", Font.BOLD, 20));
        playagain.setBackground(new Color(93,227,247));
        playagain.setForeground(Color.WHITE);
        playagain.addActionListener(this);
        add(playagain);
                
        
        
        setVisible(true);
        }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    
    }
    public static void main(String[] args){
        new Score("User",0);
    } 
}
