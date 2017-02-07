import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/***
 *  This is the main class which creates threads for cars on the N-S-E-W Roads
 *  and threads for the signal
 * */
public class TrafficSignals {

	public static void main(String[] args) {
		ExecutorService  service = Executors.newFixedThreadPool(4);
		ExecutorService signalHandler = Executors.newFixedThreadPool(2);
		try{

			Lock signalLock = new ReentrantLock();
			AtomicBoolean snellSignal = new AtomicBoolean(Boolean.FALSE);
			AtomicBoolean weaverSignal =  new AtomicBoolean(Boolean.FALSE);
			AtomicBoolean isStopRequested =  new AtomicBoolean(Boolean.FALSE);
			Future snellFuture = signalHandler.submit(new SnellSignal(signalLock , snellSignal,isStopRequested));
			Future weaverFuture = signalHandler.submit(new WeaverSignal(signalLock ,weaverSignal,isStopRequested));
			
			Road s = new Road("SouthSnell" ,snellSignal , isStopRequested);
			Road n = new Road("NorthSnell" ,snellSignal , isStopRequested);
			Road e= new Road("EastWeaver",weaverSignal , isStopRequested);
			Road w = new Road("WestWeaver",weaverSignal , isStopRequested);
			Future f1 = service.submit(s);
			Future f2 = service.submit(n);
			Future f3 = service.submit(e);
			Future f4 = service.submit(w);
			
			for(int i = 0 ; i<=20; i++){
				System.out.println(i+": N = "+n.getCarsQueue()+": S = "+s.getCarsQueue()+": E = "+e.getCarsQueue()+"; W ="+ w.getCarsQueue());
				Thread.sleep(1000);
			}
			isStopRequested.set(Boolean.TRUE);
		}catch(Exception iex){
			iex.printStackTrace();
		}finally{
			service.shutdown();	
			signalHandler.shutdown();
		}
	}
}

	
