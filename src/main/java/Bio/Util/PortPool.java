package Bio.Util;

import java.util.LinkedList;

public class PortPool {
	private LinkedList<Integer> ports;
	//private LinkedList<> userPorts;

	//class PortInfo {
	//	private int port;
	//	private String host;
	//	public PortInfo(host, port) {
	//	}
	//}

	public PortPool() {
		init();
	}

	public synchronized int getPort() {
		return ports.poll();
	}

	private void init() {
		ports = new LinkedList<Integer>();
		for(int i = 30000; i <= 50000; i++) {
			ports.add(i);
		}
	}
}
