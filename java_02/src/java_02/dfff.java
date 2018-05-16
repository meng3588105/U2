package java_02;

public class dfff {

	public static void main(String[] args) {

		int [] add={12,15,48,59,32,1,4,5,6,9,8,7,0,-1};
		int temp = 0;
		for (int i = 0; i < add.length-1; i++) {
			for (int j = 0; j < add.length-1-i; j++) {
				if (add[j+1]>add[j]) {
					temp=add[j];
					add[j]=add[j+1];
					add[j+1]=temp;
				}
			}
		}
		for (int i = 0; i < add.length; i++) {
			System.out.println(add[i]);
			
		}

	}

}
