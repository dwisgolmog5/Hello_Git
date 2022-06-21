package serversocket_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample001 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(); //��Ĺ ����
			serverSocket.bind(new InetSocketAddress("localhost",5001)); //��Ĺ ���ε�
			while(true) { //������ Ŭ���̾�Ʈ�� ��ٷ��� �ϱ� ������ ���� ���� ����
				System.out.println("[���� ��ٸ�]");
				Socket socket = serverSocket.accept(); //Ŭ���̾�Ʈ�� �����û�� ������
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				//InetSocketAddress�� Ÿ���� ��ȯ��Ŵ �� �� ��ü�� ������
				System.out.println("[���� ������] " + isa.getHostName());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//������ �����ϴ� �ڵ�
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
