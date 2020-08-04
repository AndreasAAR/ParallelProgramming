public class RaceCondition {

    static double a = 10;
    static double b;

    public static void main(String[]args){
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
        Thread th1 = new Thread(r1, "Thread r1");
        Thread th2 = new Thread(r2, "Thread r2");
        th1.start();
        th2.start();
        //About half the time Th2 changes the a value before we calculate b!

    }

}
