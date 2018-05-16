package com.Th.Thread;

public class Test {

		public static void main(String[] args) {
			
			
			ThreadDemo demo = new ThreadDemo();
			Thread thread1 = new Thread(demo, "线程1");
			Thread thread2 = new Thread(demo, "线程2");
			Thread thread3 = new Thread(demo, "线程3");
			Thread thread4 = new Thread(demo, "线程4");
			Thread thread5 = new Thread(demo, "线程5");
			Thread thread6 = new Thread(demo, "线程6");
			Thread thread7 = new Thread(demo, "线程7");
			Thread thread8 = new Thread(demo, "线程8");
			Thread thread9 = new Thread(demo, "线程9");
			Thread thread10 = new Thread(demo, "线程10");
			
			
			thread1.start();
			thread2.start();
			thread3.start();
			thread4.start();
			thread5.start();
			thread6.start();
			thread7.start();
			thread8.start();
			thread9.start();
			thread10.start();
			

		}

}
