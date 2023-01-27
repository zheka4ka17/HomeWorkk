package Midi;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
    int x = 70;
    int y = 70;

    public static void main(String[] args) {
SimpleAnimation simpleAnimation =new SimpleAnimation();
simpleAnimation.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel3 myDrawPanel3 = new MyDrawPanel3();

        frame.getContentPane().add(myDrawPanel3);
        frame.setSize(300,300);
        frame.setVisible(true);

        for(int i =0; i<130; i++){
            x++;
            y++;

            myDrawPanel3.repaint();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
    class MyDrawPanel3 extends JPanel {
        public void paintComponent(Graphics g) {
            Color color = new Color(0, 0, 0);
            g.setColor(color);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());


            g.setColor(Color.RED);
            g.fillOval(x, y, 40, 40);

        }
    }
}