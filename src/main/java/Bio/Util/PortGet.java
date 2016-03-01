package Bio.Util;

import java.util.ArrayList;


public class PortGet {
	public static void main(String[] args) {
		System.out.println("Start to get port");
		PortRequest host = new PortRequest("127.0.0.1", 12345);
		byte[] data = args[0].getBytes();
		host.push(data, data.length);
		host.closePusher();
	}
}
