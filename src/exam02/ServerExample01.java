package exam02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample01 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Scanner sc = new Scanner(System.in);
		
		
		try {
			serverSocket = new ServerSocket(); //소캣 생성
			serverSocket.bind(new InetSocketAddress("localhost",5001)); //소캣 바인딩
			while(true) { //서버는 클라이언트를 기다려야 하기 때문에 무한 루프 생성
				System.out.println("[연결 기다림]");
				Socket socket = serverSocket.accept(); //클라이언트의 연결요청을 리턴함
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				//InetSocketAddress로 타입을 변환시킴 즉 저 객체로 리턴함
				System.out.println("[연결 수락함] " + isa.getHostName());
				
				byte[] bytes = null;
				String message = null;
				
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readByteCount = is.read(bytes); //읽은 데이터는 bytes에 저장되고 바이트의 수는 readByteCount에 저장됌
				message = new String(bytes,0,readByteCount, "UTF-8");
				System.out.println("[데이터 받기 성공]: "+ message);
				
				System.out.printf("답장할 메세지 입력:");
				String ms = sc.nextLine();
				
				OutputStream os = socket.getOutputStream();
				message = ms;
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[데이터 보내기 성공]");
				
				is.close();
				os.close();
				socket.close();
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
