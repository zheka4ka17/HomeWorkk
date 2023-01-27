import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LuckyExample implements ActionListener {
 private static MyThread myThread= null;
    public static void main(String[] args) {
        LuckyExample luckyExample = new LuckyExample();
        luckyExample.go();
        myThread = new MyThread();
        myThread.start();

    }
        public void go(){
        JFrame frame = new JFrame();
        JButton button = new JButton("Interrupt thread");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);

        frame.setSize(300,300);
        frame.setVisible(true);

        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      myThread.interrupt();
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            System.out.println("|");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Метод прерван");
                flag=false;

            }
        }
    }
}