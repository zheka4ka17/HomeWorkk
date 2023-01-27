package Midi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui3C implements ActionListener {
JFrame jFrame;

    public static void main(String[] args) {
        SimpleGui3C simpleGui3C = new SimpleGui3C();
        simpleGui3C.go();
    }

public void go(){
   jFrame =new JFrame();
   jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   JButton button= new JButton("Change colors");
   button.addActionListener(this);

   MyDrawPanel1 myDrawPanel= new MyDrawPanel1();

   jFrame.getContentPane().add(BorderLayout.SOUTH,button);
   jFrame.getContentPane().add(BorderLayout.CENTER, myDrawPanel);

   jFrame.setSize(300,300);
   jFrame.setVisible(true);


}
    @Override
    public void actionPerformed(ActionEvent e) {
        jFrame.repaint();
    }
}

class MyDrawPanel1 extends JPanel{
    public void paintComponent(Graphics g){
        Color color = new Color(0, 0, 0);
       g.setColor(color);
       g.fillRect(0,0,this.getWidth(),this.getHeight());


        int red = (int)(Math.random()*255);
        int green = (int)(Math.random()*255);
        int blue = (int)(Math.random()*255);
        Color color1 = new Color(red, green, blue);

        g.setColor(color1);
        g.fillOval(70,70,100,100);

    }
}
