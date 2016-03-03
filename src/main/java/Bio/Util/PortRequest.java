package Bio.Util;

import java.io.*;
import java.net.Socket;

public class PortRequest {
	private Socket socket;
	private PrintWriter	out;

	public PortRequest(String host, int port) {
		 initTcpClient(host, port);
	}

	private void initTcpClient(String host, int port) {
		try {
			socket = new Socket(host, port);
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (Exception e) {
			System.out.println("TCP client inicate falied! "+e);
		}
	}

	public int push(String line) {
		int result = 0;
		try {
		    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out.println(line);
			result = Integer.valueOf(in.readLine());
			//System.out.println("client get : " + in.readLine());
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void closePusher() {
		try {
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
