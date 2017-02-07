import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/***
 *  This class represents signal on Road 'Snell' 
 *  Snell Road signal is considered as Green when 'signalLock' is acquired 
 * 
 * */
class SnellSignal implements Runnable {
	private AtomicBoolean snellSignal =null;
	private Lock signalLock = null;
	private AtomicBoolean isStopRequested = null;
	public SnellSignal(Lock signalLock,AtomicBoolean snellSignal, AtomicBoolean isStopRequested ) {
		this.signalLock = signalLock;
		this.snellSignal = snellSignal;
		this.isStopRequested = isStopRequested;
	}
	@Override
	public void  run()  {
		while(!isStopRequested.get()){
				try {
					//Snell ->Green
					signalLock.lock();
					snellSignal.set(true);
					Thread.sleep(3000);
					snellSignal.set(false);
					//Snell ->Red;
					signalLock.unlock();
					Thread.sleep(1000);
				} catch(InterruptedException iex){
					iex.printStackTrace();
				}
		}
	}

}