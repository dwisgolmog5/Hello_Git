package test01;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.*;

public class Test01 {

	public static void main(String[] args) throws IOException {
		 ServerSocket serverSocket = new ServerSocket(9000);
		
		 try {
			 Socket socket = serverSocket.accept();
		 }catch(Exception e) {}
		 Socket socket = serverSocket.accept();
		 
		 InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		 
		 serverSocket.close();
		 
		 
		 
		 try {
			 Socket socket2 = new Socket("localhost",9000);
			 //Socket socket2 = new Socket(new InetSocketAddress("localhost",9000));
		 }catch(UnknownHostException e) {
			 
		 }catch(IOException e) {
			 
		 }
		 socket = new Socket();
		 socket.connect(new  InetSocketAddress("localhost",9000));
		 
		 try {
			 socket.close();
		 }catch(IOException e) {}
	}

}
