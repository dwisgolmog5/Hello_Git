package serversocket_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample001 {

	public static void main(String[] args) {
		Socket socket = null;
		
		socket = new Socket();
		System.out.println("[연결 요쳥]");
		
		//connect 메소드가 실행이 되면 localhost라는 아이피 주소에서 5001번에서 실행되는 
		//서버에 연결을 요청함
		try {
			socket.connect(new InetSocketAddress("localhost",5001));
			System.out.println("[연결 성공]");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
