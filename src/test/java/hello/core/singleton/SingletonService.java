package hello.core.singleton;

public class SingletonService {

	//static으로 클래스레벨에 올라가기 때문에 딱 하나만 존재 , 자바 영역의 static
	//1. static 영역에 객체를 딱 1개만 생성해둔다.
	private static final SingletonService instance = new SingletonService();
	
	//2. public으로 열어서 객체 인스턴스가 필요하면 getInstance()를 호출해서 가져온다.
	public static SingletonService getInstance() {
		return instance;
	}
	
	//3. 생성자를 private으로 선언해 외부에서 new로 객체를 생성하는 것을 막는다.
	private SingletonService() {}
	
	public void login() {
		System.out.println("싱글톤 객체 로직 호");
	}
	
}
