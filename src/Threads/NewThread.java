package Threads;

public class NewThread implements Runnable {
    Thread thrd;
    volatile boolean suspended; //если переменная принимает тру , то поток приостонавливается(ПРИОСТАНОВЛЕННЫЙ)
    volatile boolean stopped; // если тру , поток прекращается

    NewThread(String name){
        thrd = new Thread(this,name);
        suspended=false;
        stopped=false;
        thrd.start();
    }

    @Override
    public void run() {
        System.out.println(thrd.getName()+" starting");
        try {
            for(int i=0; i<1000; i++) {
                System.out.println(i + " ");
                if (i % 10 == 0) {
                    System.out.println();
                    Thread.sleep(1000);
                }
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                    if (stopped) break;
                }
            }
        } catch (InterruptedException e) {
            System.out.println(thrd.getName() + " interrupted");
        }
        System.out.println(thrd.getName() + " exiting.");
    }

    synchronized void myStop(){
        stopped=true;

    }

    synchronized void mySuspend(){

        suspended=true;

    }
    synchronized void myResume(){

        suspended=false;
        notify();

    }



}
class Suspend{
    public static void main(String[] args) {
        NewThread nt = new NewThread("one");
        try {
            Thread.sleep(1000);
            nt.mySuspend();
            Thread.sleep(1000);
            nt.myResume();
            Thread.sleep(1000);
            nt.myStop();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread Interrupted");
    }
}
