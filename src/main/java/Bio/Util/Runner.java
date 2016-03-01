package Bio.Util;

import java.util.ArrayList;


public class Runner {
	static private ArrayList<Integer> ports;
	public static void main(String[] args) {
		System.out.println("Start");
		init();
		PortManager manager = new PortManager(12345);
		manager.receive();
	}

	public static void init() {
		ports = new ArrayList<Integer>();
		for(int i = 30000; i <= 40000; i++) {
			ports.add(i);
		}	
	}
}
