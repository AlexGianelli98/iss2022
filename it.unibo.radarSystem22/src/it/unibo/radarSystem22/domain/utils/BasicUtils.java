package it.unibo.radarSystem22.domain.utils;
 
public class BasicUtils {
 	
	public static void showSystemInfo() {
		System.out.println(
			"COMPUTER | memory="+ Runtime.getRuntime().totalMemory() +
					" num of processors=" +  Runtime.getRuntime().availableProcessors());
	}

 
	public static void delay(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void waitTheUser() {
		try {
			ColorsOut.outappl("Please hit any key to restart", ColorsOut.ANSI_PURPLE);
			System.in.read();
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	public static void aboutThreads(String msg)   { 
		String tname = Thread.currentThread().getName();
		String nThreads = ""+Thread.activeCount();
		ColorsOut.outappl(msg + " curr. thread=T \tn=N".replace("T", tname).replace("N", nThreads), ColorsOut.YELLOW );
	}

 
	
}
