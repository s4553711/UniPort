package Bio.Util;

import java.util.ArrayList;


public class Runner {
	public static void main(String[] args) {
		System.out.println("Start");
		PortManager manager = new PortManager(Integer.valueOf(args[0]));
		manager.receive();
	}
}
