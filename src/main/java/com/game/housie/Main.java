package com.game.housie;// Java program to illustrate
// stopping a thread using boolean flag 

import java.sql.SQLOutput;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Main class
class task implements  Runnable{
	CountDownLatch cdl=null;
	long time=0;
	task(CountDownLatch cdl,long time){
		this.cdl=cdl;
		this.time=time;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(i);
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				break;
			}
		}
		cdl.countDown();
	}
}
public class Main {
	public static void main(String args[]) 
	{ 
		CountDownLatch cdl=new CountDownLatch(1);
		ExecutorService es= Executors.newFixedThreadPool(4);
		try {
			Thread t1=new Thread(new task(cdl,5));
			Thread t2=new Thread(new task(cdl,5000));
			Thread t3=new Thread(new task(cdl,5000));
			Thread t4=new Thread(new task(cdl,5000));
			es.submit(t1);
			es.submit(t2);
			es.submit(t3);
			es.submit(t4);
			es.shutdown();
			cdl.await(); // main thread waiting; waiting to countdown as zero
			System.out.println("Ahiya aavya");
			es.shutdownNow();// terminate all CDL threads
		}
		catch (Exception e) {
			System.out.println("Caught:" + e); 
		} 
		System.out.println("Exiting the main Thread"); 
	} 
} 