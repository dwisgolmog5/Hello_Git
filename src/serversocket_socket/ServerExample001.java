package serversocket_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample001 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(); //소캣 생성
			serverSocket.bind(new InetSocketAddress("localhost",5001)); //소캣 바인딩
			while(true) { //서버는 클라이언트를 기다려야 하기 때문에 무한 루프 생성
				System.out.println("[연결 기다림]");
				Socket socket = serverSocket.accept(); //클라이언트의 연결요청을 리턴함
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				//InetSocketAddress로 타입을 변환시킴 즉 저 객체로 리턴함
				System.out.println("[연결 수락함] " + isa.getHostName());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//서버를 종료하는 코드
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
