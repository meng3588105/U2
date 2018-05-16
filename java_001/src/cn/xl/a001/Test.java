package cn.xl.a001;

import java.util.Scanner;

public class Test {
/**
 * 简单计算器
 * @param args
 */
	public static void main(String[] args) {
		int num;
		int num1;
		String abb="";
		Scanner input=new Scanner(System.in);  
		System.out.println("输入一个数");
		num =input.nextInt();
		System.out.println("再输入一个数");
		num1 =input.nextInt();
		System.out.println("输入运算符号");
		abb=input.next();
		switch (abb) {
		case "+":
			int a=num+num1;
			System.out.println(a);break;
		case "-":
			int b=num-num1;
			System.out.println(b);break;
		case "*":
			int c=num*num1;
			System.out.println(c);break;
		case "/":
			int d=num/num1;
			System.out.println(d);break;
		default:
			break;
		}

		

	}

}
