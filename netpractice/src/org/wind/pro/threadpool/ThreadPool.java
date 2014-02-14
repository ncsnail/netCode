package org.wind.pro.threadpool;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool extends ThreadGroup{
	
	private boolean isClosed = false;
	private List<Runnable> workQueue;
	private static int threadPoolId = 0;
	private int threadId;
	
	public ThreadPool(int threadSize) {
		super("ThreadPool:"+(threadPoolId ++));
		//是否是后台线程组
		setDaemon(false);
		workQueue = new LinkedList<Runnable>();
		if(threadSize<1){
			threadSize = 1;
		}
		for(int i = 0;i<threadSize;i++){
			//new WorkThread();
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
