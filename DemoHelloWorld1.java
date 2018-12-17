
public class DemoHelloWorld1 {
	
    public void print(String s) {
        System.out.println(s);
        MyThreadDemo.pause(200);
    }
    
	public static void main(String[] args) {
		DemoHelloWorld1 obj1 = new DemoHelloWorld1();
		MyThreadDemo st1 = new MyThreadDemo(obj1, "Hello");
		MyThreadDemo st2 = new MyThreadDemo(obj1, "World");

        Thread t1 = new Thread(st1);
        Thread t2 = new Thread(st2);

        t1.start();
        t2.start();

	}

}
class MyThreadDemo implements Runnable {
    private DemoHelloWorld1 Ref1;
    private String s;

    public MyThreadDemo(DemoHelloWorld1 ref, String s) {
        this.Ref1 = ref;
        this.s = s;
    }

    public static void pause(long time) {
    	
    try {
    	Thread.sleep(time); 
    	}
        catch (InterruptedException e) 
        {
        	Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run()
    {
        synchronized (Ref1) {
                Ref1.print(s);
        }
    }
}


