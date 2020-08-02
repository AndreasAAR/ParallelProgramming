class ThreadTester{
   public static void main(String[] args){

       //Create a thread using the runnable class
       (new Thread(new RunThread())).start();
       //Created using Thread subclass
       (new subThread()).start();
       //Created using a name
       (new subThread(" Named thread ")).start();
       //Created using a runnable object, with a lambda body
       Runnable lambRun = () -> { while(true){
           try {
               Thread.sleep(3500);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("Im a lambda runnable");

       } };

       Runnable testRun = new Runnable(){
           @Override
          public void run(){
               while(true){
                   try {
                       Thread.currentThread().sleep(4000);
                       System.out.println("Im locally defined runnable");
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       };
       (new Thread(testRun)).start();
       (new Thread(lambRun)).start();

   }
}

class subThread extends Thread{

    //Three optional ways of calling a thread object
    public subThread(){
        super();
    }
    public subThread(String name){
        super(name);
    }
    public subThread(Runnable runner){
        super(runner);
    }



    @Override
    public void run(){

        while(true)
        {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I a thread subclass "+Thread.currentThread().getName()+ " Am running!");
        }
    }


}

class RunThread implements Runnable{

    @Override
    public void run() {
         while(true)
         {
             try {
                 Thread.sleep(5000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println("I, a runnable "+Thread.currentThread().getName()+ " Am running!");
         }
    }
}

