package javafx_exam01;

import javafx.application.Application;
import javafx.stage.Stage;

public class Appmain extends Application{//Application�� �߻�Ŭ���� �̴�

	public Appmain() { //������ ȣ��
		System.out.println(Thread.currentThread().getName() + ":���θ޼ҵ� ȣ��");
		
	}
	
	public void init() throws Exception{
		System.out.println(Thread.currentThread().getName() + ":init()�޼ҵ� ȣ��");
		
	}
	
	//start �޼ҵ�� �ڵ忡�� ���� ȣ��x
	@Override
	public void start(Stage primaryStage) throws Exception { //UI ���� �� ���� ���ִ� �޼ҵ�
		//Stage = ������â 
		primaryStage.show();
		
	 }

	public static void main(String[] args) {
		launch(args); //Application�� ������ �ִ� ���� �޼ҵ�(start�� ȣ��)
		
	}

}
