package Threads;

public class SumArray {
    private  int sum;
      int sumArray(int [] nums){
         sum=0;
         for(int i=0; i<nums.length; i++){
             sum+=nums[i];
             System.out.println("Running total for "+ Thread.currentThread().getName()+ " is "+ sum);}
         try {
             Thread.sleep(10);
         } catch (InterruptedException e) {
             System.out.println("Main thread interrupted");
         }
         return sum;
         }

}
class MyThread implements Runnable{
    Thread thrd;
    static SumArray sa = new SumArray();
    int [] a;
    int answer;

    public MyThread(String name, int[]a){
        thrd= new Thread(this, name);
        this.a=a;
        thrd.start();
    }

    @Override
    public void run() {
        //int sum;
        System.out.println(thrd.getName()+ " starting.");
        synchronized (sa){
        answer=sa.sumArray(a);}
        System.out.println("Sum for "+ thrd.getName() + " is "+ answer);
        System.out.println(thrd.getName()+ " terminating.");

    }
}

class Sync{
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        MyThread mt1= new MyThread("Child #1", a);
        MyThread mt2= new MyThread("Child #2", a);

    }
}

