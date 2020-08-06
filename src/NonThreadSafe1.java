public class NonThreadSafe1 {

    static int counter = 1;

    public static void main(String[] args){

        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName()+"ID value: " + getID());
        };
        Thread one = new Thread(r, "one");
        one.start();
        Thread two = new Thread(r, "two");
        two.start();

    }
    public static int getID(){
        return counter++;
    }
    /*
    UNRELIABLE!
    Run 1
   twoID value: 2
oneID value: 1
 Run 2
ID value: 1
ID value: 2
     */
}
