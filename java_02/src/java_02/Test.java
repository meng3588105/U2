package java_02;

public class Test {

	public static void main(String[] args) {
		
		int num =5;
		for (int i = 0; i < num; i++) {
			if (i%2==0) {
				continue;
			}
			System.out.println(i);
		}
	}

}
