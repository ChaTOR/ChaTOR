package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.util.Scanner;

import java.sql.Timestamp;
import java.util.Date;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    //Socket s = new Socket();
		Long timestart = null;
	    
	    // connect - will be redirected to and tunneled by Tor anonymous network instead of direct TCP/IP connection
	    //InetSocketAddress address = new InetSocketAddress(/*hostname*/"chbb7uc6wh2rvpfk.onion", /*port*/2340);
	    
	    
		Socket s = new Socket(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 9050)));
		try {
			java.util.Date date= new java.util.Date();
			timestart = date.getTime();
			System.out.println(timestart+" CONNECTING");
			s.connect(InetSocketAddress.createUnresolved("fxtlpc5acjskurse.onion", 2340));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    try {
			java.util.Date date= new java.util.Date();
			Long timeend = date.getTime();
			System.out.println(timeend+" CONNECTED ("+(timeend-timestart)+" sec)");

		    // transfer data
		    OutputStream os = s.getOutputStream();
		    InputStream is = s.getInputStream();
		    PrintWriter pos = new PrintWriter(os, true);
		    Scanner sin = new Scanner(is);

		    pos.println("GET / HTTP1.1\n");
		    System.out.println("GET / HTTP1.1 SENT");
		    
		    while (true) {
		    	if (sin.hasNext()) {
		    		System.out.println("RECEIVED : "+sin.nextLine());
		    	} else {
		    		System.out.println("CLOSED");
		    		break;
		    	}
		    }
		    
		    System.out.println("CLOSED 2");

		    // close connection
		    s.close();
		    sin.close();
		    System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}	    
	}

	}
