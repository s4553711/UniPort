package Bio.Util;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.LinkedBlockingQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PortManager {
	private ServerSocket server;
	private PortPool pool;

	public PortManager(int port) {
		try {
			server = new ServerSocket(port);
			pool = new PortPool();
		} catch(Exception e) {
			System.out.println("Server Error");
		}
	}

	public void receive() {
		Socket s1;
		boolean stop = false;
		while(true) {
			try {
				s1 = server.accept();
				String receive = "";
				BufferedReader in = new BufferedReader(new InputStreamReader(s1.getInputStream()));
				PrintWriter out = new PrintWriter(s1.getOutputStream(), true);
	
				while ((receive = in.readLine()) != null) {
					System.out.println("Server > receive: "+receive);
					if(receive.equals("shutdown")) {
						stop = true;
						break;
					} else if (receive.equals("new")) {
						out.println(pool.getPort());
					}
				}
			} catch (IOException e) {
				System.out.println("Connection failed");
				e.printStackTrace();
			}
			if (stop) break;
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
