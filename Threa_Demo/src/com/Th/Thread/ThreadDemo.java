package com.Th.Thread;

public class ThreadDemo implements Runnable{
	
	int sum = 1000;
	int num = 0;

	@Override
	public void run() {
	
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		synchronized (this) {
			
		
				if (sum == 0) {
					break;
				}
					sum--;
					num++;
			
				System.out.println(Thread.currentThread().getName() + "抢到第"
						+ num + "张票,剩余" + sum + "张");

			}
		}
	}
	
}
