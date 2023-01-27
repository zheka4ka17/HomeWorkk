package Midi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons {
    JFrame jFrame;
    JLabel jLabel;

    public static void main(String[] args) {
TwoButtons gui = new TwoButtons();
gui.go();
    }

    public void go(){
        jFrame= new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());

        jLabel= new JLabel("I'm a label");
        MyDrawPanel2 drawPanel= new MyDrawPanel2();


        jFrame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        jFrame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        jFrame.getContentPane().add(BorderLayout.EAST, labelButton);
        jFrame.getContentPane().add(BorderLayout.WEST, jLabel);

        jFrame.setSize(300,300);
        jFrame.setVisible(true);

    }

    class LabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            jLabel.setText("Ouch!");
        }

    }

    class ColorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           jFrame.repaint();
        }
    }
}
class MyDrawPanel2 extends JPanel{
    public void paintComponent(Graphics g){
        Color color = new Color(0, 0, 0);
        g.setColor(color);
        g.fillRect(0,0,this.getWidth(),this.getHeight());


        int red = (int)(Math.random()*255);
        int green = (int)(Math.random()*255);
        int blue = (int)(Math.random()*255);
        Color color1 = new Color(red, green, blue);

        g.setColor(color1);
        g.fillOval(70,70,40,40);

    }
}

