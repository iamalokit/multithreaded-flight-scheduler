package com.iamalokit.flightscheduler;

public class Flight extends Thread implements Runnable {
	private int flightId;
	private String flightName;
	
	public Flight(int id, String name) {
		flightId = id;
		flightName = name;
		
		System.out.println("Flight " + flightName + " with id : " + flightId + " CREATED.");
	}
	
	@Override
	public void run() {
		try {
			FlightLock.getInstance().getRunwayWait();
			System.out.println("Flight " + this.flightName + " with id : " + this.flightId + " is WAITING in a queue.");
			System.out.println("Flight " + this.flightName + " with id : " + this.flightId + " TRYING to access the runway.");
			FlightLock.getInstance().getRunwayUse();
			System.out.println("Flight " + this.flightName + " with id : " + this.flightId + " has ACQUIRED the runway.");
			System.out.println("Flight " + this.flightName + " with id : " + this.flightId + " is USING the runway.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			FlightLock.getInstance().releaseRunwayUse();
			System.out.println("Flight " + this.flightName + " with id : " + this.flightId + " EXITED the runway.");
		}
		
	}
}
