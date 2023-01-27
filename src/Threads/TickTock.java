package Threads;

public class TickTock {
    String state;
    synchronized void tick(boolean running){
        if(!running){
            state="ticked";
            notify();
            return;
        }
        System.out.println("Tick ");
        state="ticked";
        notify();
        try{
            while(!state.equals("talked"))
                wait();

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    synchronized void talk(boolean running){
        if(!running){
            state="talked";
            notify();
            return;
        }
        System.out.println("Talk ");
        state="talked";
        notify();
        try{
            while(!state.equals("ticked"))
                wait();

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
}

class MyThread1 implements Runnable{
Thread thrd;

TickTock obj;

public MyThread1(String name, TickTock o){
    thrd= new Thread(this,name);
    this.obj=o;
    thrd.start();

}
    @Override
    public void run() {
        if(thrd.getName().compareTo("Tick")==0){
            for(int i=0; i<5;i++)
                obj.tick(true);
            obj.tick(false);}
        else { for(int i=0; i<5;i++)
            obj.talk(true);
            obj.talk(false);}
        }
    }
class ThreadCom {
    public static void main(String[] args) {
        TickTock obj = new TickTock();
 MyThread1 mt1= new MyThread1("Tick", obj) ;
 MyThread1 mt2= new MyThread1("Talk", obj) ;
        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
