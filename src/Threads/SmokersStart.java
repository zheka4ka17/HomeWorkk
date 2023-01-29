package Threads;



import java.util.*;
import java.util.concurrent.Semaphore;
/*Изначально есть три заядлых курильщика, сидящих за
столом. Каждому из них доступно бесконечное количество
одного из трех компонентов: у одного курильщика –табак, у
второго – бумага, у третьего – спички. Для того чтобы делать
и курить сигареты, необходимы все три компонента.
Также, кроме курильщиков, есть бармен, помогающий им
делать сигареты: он недетерминировано (выбирает случай-
ных) выбирает двух курильщиков, берет у них по одному
компоненту из их запасов и кладет их на стол. Третий ку-
3
рильщик забирает ингредиенты со стола и использует их для
изготовления сигареты, которую он курит некоторое время
(от 1 до 3 с). В это время бармен, завидев стол пустым, снова
выбирает двух курильщиков случайным образом и кладет
их компоненты на стол. Процесс повторяется бесконечно.
Курильщики, по условию задачи, честные: они не прячут
компоненты, выданные барменом, – они лишь скручивают
сигарету тогда, когда докурят предыдущую. Если бармен
кладет, например, табак и бумагу на стол, пока поставщик
спичек курит, то табак и бумага останутся нетронутыми на
столе, пока курильщик со спичками не докурит сигарету и
только затем не возьмет табак и бумагу. Задача написать,
программу имитирующую процесс курения.*/

public class SmokersStart {
   static Barmen barmen = new Barmen();


    public static void main(String[] args) {


        Smoker3 smoker3 = new Smoker3("Third", barmen);
        Smoker1 smoker1 = new Smoker1("First", barmen);
        Smoker2 smoker2 = new Smoker2("Second", barmen);



    }

    static class Smoker1 implements Runnable {
        Thread thr;
        String name;
        Barmen barmen;



        private final Resource resource = Resource.Lighter;

        public Smoker1(String name, Barmen barmen) {
            thr = new Thread(this, name);
            this.barmen= barmen;
            this.name = name;
            thr.start();
        }


        @Override
        public  void run() {
            while (true) {
                barmen.testProgram(resource);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public Resource getResource() {
            return resource;
        }
    }
    static class Smoker2 implements Runnable {
        Thread thr;
        String name;
        Barmen barmen;

        int count=0;

        private final Resource resource = Resource.Paper;

        public Smoker2(String name, Barmen barmen) {
            thr = new Thread(this, name);
            this.barmen= barmen;
            this.name = name;
            thr.start();
        }


        @Override
        public void run() {
            while (true) {
                barmen.testProgram(resource);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }

        }
    }
    static class Smoker3 implements Runnable {
        Thread thr;
        String name;
        Barmen barmen;



        private final Resource resource = Resource.Tobacco;

        public Smoker3(String name, Barmen barmen) {
            thr = new Thread(this, name);
            this.barmen= barmen;
            this.name = name;
            thr.start();
        }



        @Override
        public  void run() {
            while (true) {
                  barmen.testProgram(resource);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
            }


    }

    static class Barmen {

        private volatile HashSet<Resource> set = new HashSet<>();

        public HashSet<Resource> getSet() {
            return set;
        }

        public synchronized void testProgram(Resource resource) {

            set.add(resource);
            if (set.size() < 3) {

                try {
                    System.out.println(Thread.currentThread().getName() + " дал " + resource);
                    System.out.println(Thread.currentThread().getName() + ": ожидает ");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            } else if (set.size() == 3)
                smoke();
            notify();



        }


        public void smoke() {
            Random random = new Random();
            int x = random.nextInt(3)+1;

            try {

                System.out.println("Взял ресурсы готовится к курению");
                System.out.println("Курит : " + Thread.currentThread().getName());
                Thread.sleep(x*1000);
                System.out.println(Thread.currentThread().getName() + " Закончил курить");
                System.out.println();
                set.clear();


            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        }




        }
    }
    enum Resource {Lighter, Paper, Tobacco}
