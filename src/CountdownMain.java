public class CountdownMain
{

    public static void main(String[] args){
        Countdown CD = new Countdown();
        Runnable r = () ->{
           CD.printCount();
        };
        Thread one = new Thread(r,"Synced One");
        Thread two = new Thread(r,"Synced Two");
        one.start();
        two.start();
    }




}

class Countdown{
    public void printCount(){
         for(int i =10; i>=0; i--){
             System.out.println(Thread.currentThread().getName() +": "+ i+"!");
         }
        System.out.println( Thread.currentThread().getName() +  " reached the end, GO!");
    }
}
