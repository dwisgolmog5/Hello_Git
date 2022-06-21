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
		
		//connect �޼ҵ尡 ������ �Ǹ� localhost��� ������ �ּҿ��� 5001������ ����Ǵ� 
		//������ ������ ��û��
		try {
			socket = new Socket();
			System.out.println("[���� �䫊]");
			socket.connect(new InetSocketAddress("localhost",5001));
			System.out.println("[���� ����]");
			
			byte[] bytes = null;
			String message = null;
			
			System.out.printf("���� �޼��� �Է�:");
			String ms = sc.nextLine();
			
			OutputStream os = socket.getOutputStream();
			message = ms;
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[������ ������ ����]");
			
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByteCount = is.read(bytes);
			message = new String(bytes,0,readByteCount, "UTF-8");
			System.out.println("[������ �ޱ� ����]: "+message);
			
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
