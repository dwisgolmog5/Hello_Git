package javafx_exam01;

import javafx.application.Application;
import javafx.stage.Stage;

public class Appmain extends Application{//Application은 추상클래스 이다

	public Appmain() { //생성자 호출
		System.out.println(Thread.currentThread().getName() + ":메인메소드 호출");
		
	}
	
	public void init() throws Exception{
		System.out.println(Thread.currentThread().getName() + ":init()메소드 호출");
		
	}
	
	//start 메소드는 코드에서 직접 호출x
	@Override
	public void start(Stage primaryStage) throws Exception { //UI 생성 및 실행 해주는 메소드
		//Stage = 윈도우창 
		primaryStage.show();
		
	 }

	public static void main(String[] args) {
		launch(args); //Application이 가지고 있는 정적 메소드(start를 호출)
		
	}

}
