public class CountdownSyncMain
{

    public static void main(String[] args){
        Countdown CD = new Countdown(); //Class in countdownmain
        Runnable r = () ->{
            synchronized (CD){
                CD.printCount();
            }

        };
        Runnable r2 = () ->{
                CD.printCount();
        };
        Thread one = new Thread(r,"synched One");
        Thread two = new Thread(r,"synched Two");
        Thread three = new Thread(r2," Three");
        Thread four = new Thread(r2," Four");
        one.start();
        two.start();
        three.start();
        four.start();


    }
}

