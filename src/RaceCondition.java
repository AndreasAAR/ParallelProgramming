public class RaceCondition {

    static double a = 10;
    static double b;
    static double c = 10;
    static double d;
    static double e = 10;
    static double f;
    public static void main(String[]args) throws InterruptedException {
        Runnable r1 = ()-> {
            if(a==10){
                try{
                    Thread.sleep(0);
                  b = a/2.0;
                 System.out.println(Thread.currentThread().getName() + ": " + b);
                }catch (InterruptedException e ){
                    System.out.println(e);
                }
            }
        };
        Runnable r2 = () -> {
            a = 12;
        };

        Runnable r3 = ()-> {
            if(c==10){
                try{
                    Thread.sleep(500);
                    d = c/2.0;
                    System.out.println(Thread.currentThread().getName() + ": " + d);
                }catch (InterruptedException e ){
                    System.out.println(e);
                }
            }
        };
        Runnable r4 = () -> {
            c = 12;
        };
        Thread th1 = new Thread(r1, "Thread r1");
        Thread th2 = new Thread(r2, "Thread r2");

        //About half the time Th2 changes the a value before we calculate b!

        Thread th3 = new Thread(r3, "Thread r3");
        Thread th4 = new Thread(r4, "Thread r4");

        //This time we only get 6.0

        Runnable r5 = ()-> {
            if(e==10){
                try{
                    Thread.sleep(500);
                   f = e/2.0;
                    System.out.println(Thread.currentThread().getName() + ": " + f);
                }catch (InterruptedException e ){
                    System.out.println(e);
                }
            }
        };
        Runnable r6 = () -> {
            e = 12;
        };

        Thread th5 = new Thread(r5, "Thread r5");
        Thread th6 = new Thread(r6, "Thread r6");
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th5.join(); //Makes r5 occur before th6!
        th6.start();

        /*
        Output(sometimes)
        Thread r1: 5.0
        Thread r3: 6.0
        Thread r5: 5.0
Output(sometimes)
Thread r1: 5.0
Thread r5: 5.0
Output(sometimes)
Thread r1: 5.0
Thread r3: 6.0
Thread r5: 5.0
WITHOUT JOIN:
Thread r1: 5.0
Thread r5: 6.0
Thread r3: 6.0
         */

    }

}
