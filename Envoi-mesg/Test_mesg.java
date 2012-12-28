import org.silvertunnel.netlib.adapter.socket.SocketGlobalUtil;
import java.net.*;
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

	    // redirect to the selected NetLayer
	    SocketGlobalUtil.setNetLayerUsedBySocketImplFactory(netLayer);
		
		// -----------------------------------------------------------------------------------------------
		
		
	    // create a socket
	    Socket s = new Socket();

	    // connect - will be redirected to and tunneled by Tor anonymous network instead of direct TCP/IP connection
	    InetSocketAddress address = new InetSocketAddress(/*hostname*/"silvertunnel.org", /*port*/80);
	    s.connect(address);

	    // transfer data
	    OutputStream os = s.getOutputStream();
	    InputStream is = s.getInputStream();
	    os.write(20);
	    is.read();

	    // close connection
	    s.close;
		
		
	}

}