public class ThreadState{

    public static void main(String[] args) throws InterruptedException {

        class TestRun implements Runnable{

            public Thread.State getState(){
                return Thread.currentThread().getState();
            }
            @Override
            public void run(){
                System.out.println("I run quickly, my state is" + getState());
            }
        };

        Thread slowThread = new Thread("Slow");
        System.out.println("Slowthreads state " + slowThread.getState());
       TestRun testRun1 = new TestRun();
        System.out.println(testRun1.getState());
        Thread startTR = new Thread(testRun1);
        slowThread.start();
        slowThread.sleep(4000);
        System.out.println("slowthread get status after sleep: "  + slowThread.getState());
        System.out.println("StartTr before starting!" + startTR.getState());
        startTR.start();
        System.out.println( "StartTrs state is then" + startTR.getState());
        System.out.println("slow is then "  + slowThread.getState());
        startTR.sleep(2000);
        System.out.println("sleeping startTR is"+ startTR.getState());
        System.out.println("sleeping startTR is alive?"+ (startTR.isAlive()? "Yes" : "no") );
    }



}
