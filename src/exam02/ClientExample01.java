package exam02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientExample01 {

	public static void main(String[] args) {
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		
		//connect 메소드가 실행이 되면 localhost라는 아이피 주소에서 5001번에서 실행되는 
		//서버에 연결을 요청함
		try {
			socket = new Socket();
			System.out.println("[연결 요쳥]");
			socket.connect(new InetSocketAddress("localhost",5001));
			System.out.println("[연결 성공]");
			
			byte[] bytes = null;
			String message = null;
			
			System.out.printf("보낼 메세지 입력:");
			String ms = sc.nextLine();
			
			OutputStream os = socket.getOutputStream();
			message = ms;
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[데이터 보내기 성공]");
			
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByteCount = is.read(bytes);
			message = new String(bytes,0,readByteCount, "UTF-8");
			System.out.println("[데이터 받기 성공]: "+message);
			
			os.close();
			is.close();
			
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
