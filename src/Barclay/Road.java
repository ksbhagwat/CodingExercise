import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/***
 *  This class represents vehicles on the E-W-N-S Road
 *  carsQueue maintains the cars waiting at the signal
 * 
 * */
class Road implements Runnable {
	private String name ;
	private AtomicBoolean signal =null;
	private AtomicBoolean isStopRequested =null;
	private AtomicInteger carsQueue = new AtomicInteger(0);
	
	public AtomicInteger getCarsQueue() {
		return carsQueue;
	}
	Road(String name , AtomicBoolean signal, AtomicBoolean isStopRequested ){
		this.name = name;
		this.signal = signal;
		this.isStopRequested = isStopRequested;
	}
	@Override
	public void run() {
		try{
			while(!isStopRequested.get()){
				if(this.signal.get()){
					//first car takes 2 sec and subsequent takes 1 sec
					if(carsQueue.get() >0)
					carsQueue.decrementAndGet();
					Thread.sleep(2000);
					while(carsQueue.get() >0){
						carsQueue.decrementAndGet();
						Thread.sleep(1000);
					}
				}else{
					carsQueue.incrementAndGet();
					Thread.sleep(1000);
				}
			}
		} catch(InterruptedException iex){
			iex.printStackTrace();
		}
	}

}