public class ThreadSafe1 {

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
    public static synchronized int getID(){
        return counter++;
    }

}
