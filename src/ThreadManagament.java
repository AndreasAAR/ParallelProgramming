public class ThreadManagament {



}

class TestJoinClass extends Thread {

    public TestJoinClass(String name){
        super(name);
    }

    public void run(){
        for(int i = 1 ; i <=5; i++){
            try{
                Thread.sleep(500);
            }catch (Exception e ) {
                System.out.println(e);
            }
                System.out.println(Thread.currentThread().getName() + " i = "  + i +  " ");
            }
        }
    }

class TestJoinclassExample{
    public static void main(String [] args){
        TestJoinClass testJoinClass = new TestJoinClass("T1");
        TestJoinClass testJoinClass2 = new TestJoinClass("T2");
        TestJoinClass testJoinClass3 = new TestJoinClass("T3");
        testJoinClass.start();
        //1 has to finish before T2 gets to start!
        try{
            testJoinClass.join(); //Waits for T1 to die before continuation
        }catch (Exception e){
            System.out.println(e);
        }
        //T1 gets to start
        testJoinClass2.start(); //T2 must start before 3, but both runs continously
        testJoinClass3.start(); //Both will get to finish at 5, but when one rest the other gets to finish in parallel
    }

}

