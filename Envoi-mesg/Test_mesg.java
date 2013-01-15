import org.silvertunnel.netlib.adapter.socket.SocketGlobalUtil;
import java.net.*;
import java.util.Scanner;

import org.silvertunnel.netlib.api.*;

import java.io.*;


public class Test_mesg extends Object
{
	public static void main (String args[])
	{
	
		
		// enable redirection (globally for the complete JVM)
	    SocketGlobalUtil.initSocketImplFactory();

	    // select the NetLayer implementation that should be used by java.net.Socket;
	    //   default is TcpipNetLayer with NetLayerIDs.TCPIP;
	    //   here we set TorNetLayer with NetLayerIDs.TOR:
	    NetLayer netLayer = NetFactory.getInstance().getNetLayerById(NetLayerIDs.TOR); 

	    //  wait (block the current thread) until this netLayer instance is up and ready
	    netLayer.waitUntilReady();
	    System.out.println("READY");

	    // redirect to the selected NetLayer
	    SocketGlobalUtil.setNetLayerUsedBySocketImplFactory(netLayer);
		
		// -----------------------------------------------------------------------------------------------
		
	    
	    // create a socket
	    Socket s = new Socket();
	    
	    // connect - will be redirected to and tunneled by Tor anonymous network instead of direct TCP/IP connection
	    InetSocketAddress address = new InetSocketAddress(/*hostname*/"chbb7uc6wh2rvpfk.onion", /*port*/2340);
	    try {
			s.connect(address);
			System.out.println("CONNECTED");

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
