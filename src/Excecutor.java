import javafx.concurrent.Worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinWorkerThread;

public class Excecutor {

    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10 ; i++){
            Runnable worker = new WorkerThread("Im thread" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while(!executor.isTerminated()){}
        System.out.println("Finished all threads!");

    }
}
class WorkerThread implements  Runnable{
String message;
    public WorkerThread(String message){
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "(start) message = " + message);
        workToBeDone();
        System.out.println(Thread.currentThread().getName() + "(end)");
    }
    private void workToBeDone(){
        try{
            Thread.sleep(2000);

        }catch(InterruptedException e){
        e.printStackTrace();}
    }
}
