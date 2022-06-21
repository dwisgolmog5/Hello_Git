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
			serverSocket = new ServerSocket(); //��Ĺ ����
			serverSocket.bind(new InetSocketAddress("localhost",5001)); //��Ĺ ���ε�
			while(true) { //������ Ŭ���̾�Ʈ�� ��ٷ��� �ϱ� ������ ���� ���� ����
				System.out.println("[���� ��ٸ�]");
				Socket socket = serverSocket.accept(); //Ŭ���̾�Ʈ�� �����û�� ������
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				//InetSocketAddress�� Ÿ���� ��ȯ��Ŵ �� �� ��ü�� ������
				System.out.println("[���� ������] " + isa.getHostName());
				
				byte[] bytes = null;
				String message = null;
				
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readByteCount = is.read(bytes); //���� �����ʹ� bytes�� ����ǰ� ����Ʈ�� ���� readByteCount�� �����
				message = new String(bytes,0,readByteCount, "UTF-8");
				System.out.println("[������ �ޱ� ����]: "+ message);
				
				System.out.printf("������ �޼��� �Է�:");
				String ms = sc.nextLine();
				
				OutputStream os = socket.getOutputStream();
				message = ms;
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[������ ������ ����]");
				
				is.close();
				os.close();
				socket.close();
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
