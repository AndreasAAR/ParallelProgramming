public class CountdownSyncMain
{

    public static void main(String[] args){
        Countdown CD = new Countdown(); //Class in countdownmain
        Runnable r = () ->{
            synchronized (CD){
                CD.printCount();
            }
        };
        Thread one = new Thread(r,"One");
        Thread two = new Thread(r,"Two");
        one.start();
        two.start();
    }
}

