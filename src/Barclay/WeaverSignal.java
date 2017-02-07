import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/***
 *  This class represents signal on Road 'Weaver' 
 *  Weaver Road signal is considered as Green when 'signalLock' is acquired 
 * 
 * */
class WeaverSignal implements Runnable {
	private Lock signalLock = null;
	private AtomicBoolean weaverSignal=null;
	private AtomicBoolean isStopRequested = null;
	public WeaverSignal(Lock signalLock ,AtomicBoolean weaverSignal, AtomicBoolean isStopRequested) {
		this.signalLock = signalLock;
		this.weaverSignal = weaverSignal;
		this.isStopRequested = isStopRequested;
	}
	@Override
	public void run() {
		while(!isStopRequested.get()){
				try {
					//Weaver ->Green
					signalLock.lock();
					weaverSignal.set(true); 
					Thread.sleep(3000);
					weaverSignal.set(false);
					//Weaver ->Red
					signalLock.unlock();
					Thread.sleep(1000);
				} catch(InterruptedException iex){
					iex.printStackTrace();
				}
		}
	}
}