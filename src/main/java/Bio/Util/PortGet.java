package Bio.Util;

import java.util.ArrayList;


public class PortGet {
	public static void main(String[] args) {
		PortRequest host = new PortRequest("127.0.0.1", 12345);
		int response = host.push(args[0]);
		System.out.println(response);
		host.closePusher();
	}
}
