package com.iamalokit.flightscheduler;

import java.util.concurrent.Semaphore;

public class FlightLock {
	private FlightLock(){
		
	}
	
	private static class SingletonHolder{
		private static final FlightLock INSTANCE = new FlightLock();
	}
	
	public static FlightLock getInstance(){
		return SingletonHolder.INSTANCE;
	}
	
	private Semaphore runwayUse = new Semaphore(1);
	
	private Semaphore runwayWait = new Semaphore(5);
	
	public void getRunwayUse() throws InterruptedException{
		runwayUse.acquire();
	}
	
	public void releaseRunwayUse(){
		runwayUse.release();
	}
	
	public void getRunwayWait() throws InterruptedException{
		runwayWait.acquire();
	}
	
	public void releaseRunwayWait(){
		runwayWait.release();
	}
}
