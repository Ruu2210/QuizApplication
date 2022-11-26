package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    //2D array for questions
    String questions[][] = new String[10][5];
    String answers[] = new String[10];
    String user_answers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 30;
    public static int TIMER_RESET = 30;
    public static int ans_given = 0; //flag for checking wheather user give ans or not
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.name = name;
        setBounds(130, 0, 1000, 670);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("images/quiz2.png"));
        JLabel image = new JLabel(im);
        image.setBounds(0, 0, 1000, 330);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 360, 50, 20);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(qno);

        question = new JLabel();
        question.setBounds(125, 360, 600, 20);
        question.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(question);

        questions[0][0] = "Who said this dialogue:- Dosti ka ek usool hai madam,No Sorry,No thank you ";
        questions[0][1] = "Prem";
        questions[0][2] = "Raj";
        questions[0][3] = "Rahul";
        questions[0][4] = "Aditya";

        answers[0] = "Prem";

        questions[1][0] = "Finish the quote: Ek chutki sindoor ki kimat........??";
        questions[1][1] = "tum kya jaano om bapu";
        questions[1][2] = "tum kya jaano ramesh babu";
        questions[1][3] = "tumhe kya pata ramesh babu";
        questions[1][4] = "tum kya jaano ramesh bapu";

        answers[1] = "tum kya jaano ramesh babu";

        questions[2][0] = "Complete the song: Moochhon ko thoda round ghumake,anna ke jaisa....?";
        questions[2][1] = "chashma nikalke,Coconut mai pani milake";
        questions[2][2] = "chashma lagake,Coconut mai pani milake";
        questions[2][3] = "chashma lagake,Coconut mai lassi milake";
        questions[2][4] = "chashma ghumake,Coconut mai lassi milake";

        answers[2] = "chashma lagake,Coconut mai lassi milake";

        questions[3][0] = "What is the No 1 Comedy movie in india?";
        questions[3][1] = "3 idiots,2009";
        questions[3][2] = "Andaz Apna Apna,1994";
        questions[3][3] = "Welcome,2007";
        questions[3][4] = "Munna Bhai MBBS,2003";

        answers[3] = "Andaz Apna Apna,1994";

        questions[4][0] = "Which was the first Indian Movie nominated for Oscar?";
        questions[4][1] = "Lagaan";
        questions[4][2] = "Salaam Bombay";
        questions[4][3] = "Mother India";
        questions[4][4] = "Slumdog Millionaire";

        answers[4] = "Mother India";

        questions[5][0] = "Guess the Movie: Babu Moshai Zindagi badi honi chahiye lambi nahi.";
        questions[5][1] = "Bawarchi";
        questions[5][2] = "Namak Haram";
        questions[5][3] = "Kati patang";
        questions[5][4] = "Anand";

        answers[5] = "Anand";

        questions[6][0] = "Which Sport is played in movie: LAGAAN";
        questions[6][1] = "Cricket";
        questions[6][2] = "Football";
        questions[6][3] = "ping pong";
        questions[6][4] = "Baseball";

        answers[6] = "Cricket";

        questions[7][0] = "What was the nick name of kartik aryan in 'Pyar ka punchnama 2'";
        questions[7][1] = "Sonu";
        questions[7][2] = "GOGO";
        questions[7][3] = "Liquid";
        questions[7][4] = "Titu";

        answers[7] = "GOGO";

        questions[8][0] = "Which was India's First Sound Movie";
        questions[8][1] = "Alam Ara";
        questions[8][2] = "Raja Harishchandra";
        questions[8][3] = "sholey";
        questions[8][4] = "Don";

        answers[8] = "Alam Ara";

        questions[9][0] = "Director of movie 3 idiots";
        questions[9][1] = "Sanjay leela Bhansali";
        questions[9][2] = "Rajkumar Hirani";
        questions[9][3] = "Prakash Jha";
        questions[9][4] = "Amir Khan";

        answers[9] = "Rajkumar Hirani";

        opt1 = new JRadioButton();
        opt1.setBounds(125, 400, 500, 25);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(125, 430, 500, 25);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(125, 460, 500, 25);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(125, 490, 500, 25);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(opt4);

        //make click only one button at a time
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(770, 400, 150, 25);
        next.setFont(new Font("Tahoma", Font.PLAIN, 18));
        next.setBackground(new Color(116, 41, 245));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(770, 450, 150, 25);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lifeline.setBackground(new Color(116, 41, 245));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);

        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(770, 500, 150, 25);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setBackground(new Color(116, 41, 245));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);

        submit.setEnabled(false); //diabled submit button at start
        add(submit);

        start(count);

        setVisible(true);
    }

    //override actionevent method 
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            //when we use lifeline where few options are disabled 
            //and when we move to next question enabled all options using below
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                user_answers[count][0] = "";
            } else {
                user_answers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            //enable submit button
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++; //to go to next question after clicking next button
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 0) {
                opt2.setEnabled(false);
                opt4.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt3.setEnabled(false);
            }
            lifeline.setEnabled(false); //disabled lifeline option after one time use

        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                user_answers[count][0] = "";
            } else {
                user_answers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            for (int i = 0; i < 10; i++) {
                if (user_answers[i][0].equals(answers[i])) {
                    score += 10;
                    System.out.println(score);
                } else {
                    score += 0;
                }

            }

            setVisible(false);
            //object of score class
            new Score(name, score);

        }
    }

    //graphics class for timer  use pain class
    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left- " + timer + " seconds"; //15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 18));

        if (timer > 0) {
            g.drawString(time, 750, 400);

        } else {
            g.drawString("Times Up!!", 800, 400);
        }
        timer--;
        //for delay in timer
        try {
            Thread.sleep(1000);
            repaint(); //repaint method call paint method
        } catch (Exception e) {
            e.printStackTrace();
        }
        //if ans selected go to next page or 
        //if option is not selected still go to next page after timer is end
        if (ans_given == 1) {
            ans_given = 0;
            timer = TIMER_RESET;
        } else if (timer < 0) {
            timer = TIMER_RESET;
            //when we use lifeline where few options are disabled 
            //and when we move to next question enabled all options using below
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                if (groupoptions.getSelection() == null) {
                    user_answers[count][0] = "";
                } else {
                    user_answers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                for (int i = 0; i < 10; i++) {
                    if (user_answers[i][0].equals(answers[i])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                //score class open
                new Score(name, score);
                timer = 30;
                TIMER_RESET = 30;
                ans_given = 0; //flag for checking wheather user give ans or not
                count = 0;
                score = 0;
            } else {
                //to check if ans is given or not we use Buttongroup
                if (groupoptions.getSelection() == null) {
                    user_answers[count][0] = "";
                } else {
                    user_answers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++;
                start(count);

            }
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String args[]) {
        new Quiz("User");
        //create frame

    }
}
