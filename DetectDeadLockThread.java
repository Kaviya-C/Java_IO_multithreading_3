package com.multithreading.end.java.io;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.lang.management.ThreadInfo;

public class DetectDeadLockThread 
{
	public static void main(String...args)
	{
		ThreadMXBean bean=ManagementFactory.getThreadMXBean();
		long[] ids=bean.findMonitorDeadlockedThreads();
		
		if(ids!=null)
		{
		ThreadInfo[] threads=bean.getThreadInfo(ids);
		
		
		for(ThreadInfo thread:threads)
		{
			System.out.println(thread.getLockName());
			
			System.out.println(thread.getLockOwnerId());
		}
		}
	}

}
