package singleton;

public class SingletonTest {
	public static void main(String[] args) {

		// SingleObj obj1 = new SingleObj; // 오류 : private 생성자로 다른 클래스에서 new를 막음
		SingleObj obj1 = SingleObj.getInstance();
		obj1.print();
		
	} // main end
}
