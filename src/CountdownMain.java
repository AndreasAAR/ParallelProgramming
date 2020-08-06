public class CountdownMain
{

    public static void main(String[] args){
        Countdown CD = new Countdown();
        Runnable r = () ->{
           CD.printCount();
        };
        Thread one = new Thread(r,"One");
        Thread two = new Thread(r,"Two");
        one.start();
        two.start();
    }




}

class Countdown{
    public void printCount(){
         for(int i =10; i>=0; i--){
             System.out.println(i+"!");
         }
        System.out.println( "reached the end, GO!");
    }
}
