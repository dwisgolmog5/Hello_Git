package serversocket_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample001 {

	public static void main(String[] args) {
		Socket socket = null;
		
		socket = new Socket();
		System.out.println("[���� �䫊]");
		
		//connect �޼ҵ尡 ������ �Ǹ� localhost��� ������ �ּҿ��� 5001������ ����Ǵ� 
		//������ ������ ��û��
		try {
			socket.connect(new InetSocketAddress("localhost",5001));
			System.out.println("[���� ����]");
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
