package thread;

public class Counter {
	protected static long count = 0;

	public static void add(long value) {
		count = count + value;
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<2;i++){
					add(1);
				}
				System.out.println("t1 count:"+count);
			}
		},"T1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
					add(1000);
					System.out.println("t2 count:"+count);
			}
		},"T2");
		
		t1.start();
		t2.start();
		Thread.sleep(1000);
		System.out.println(count);
	}
}

//class Thread1 implements Runnable{
//
//	@Override
//	public void run() {
//		
//	}
//	
//}