import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPoolExample {

		/**
		 * @param args
		 */
		public static void main(String[] args)
		{
			/*Myrunnable r=new Myrunnable();
			Thread t=new Thread(r);
			t.start();*/
				Myrunnable[] jobs={
						new Myrunnable("Hello"),
						new Myrunnable("world"),
				};		//Jobs 	
		       ExecutorService service=Executors.newFixedThreadPool(3);
		       for( Myrunnable job:jobs)
		       {
		    	   service.submit(job);	 //jobs sent to executor service   	   
		       }
		       service.shutdown();
		}

}
class Myrunnable implements Runnable
{
			String name;
			Myrunnable(String name){
				this.name=name;
			}
		@Override
			public void run() //not returing anything if want to return use callable instead
			{
				try 
				{
					Thread.sleep(2000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				System.out.println(name);		
			}
	
	
	
	
}
