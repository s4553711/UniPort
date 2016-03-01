package Bio.Util;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.LinkedBlockingQueue;

public class PortManager {
	private ServerSocket server;

	public PortManager(int port) {
		try {
			server = new ServerSocket(port);
		} catch(Exception e) {
			System.out.println("Server Error");
		}
	}

	public void receive() {
		Socket s1;
		while(true) {
			try {
				s1 = server.accept();
				DataInputStream in = new DataInputStream(s1.getInputStream());
				int bytesRead = 0;
				byte[] receiveData = new byte[8192];
				boolean end = false;
				String receive = "";
				while(!end) {
					bytesRead = in.read(receiveData);
					if (bytesRead == -1) {
						end = true;
					} else {
						byte[] realPack = Arrays.copyOfRange(receiveData, 0, bytesRead);
						receive = new String(realPack).trim();
					}
				}
				//System.out.println("GET> "+receive);
				if(receive.equals("shutdown")) {
					break;
				} else if (receive.equals("new")) {
					PrintWriter out = new PrintWriter(s1.getOutputStream());
					out.println("You get 778899");
					System.out.println("778899");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		closeManager();
	}

	private void closeManager() {
		try {
			server.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
