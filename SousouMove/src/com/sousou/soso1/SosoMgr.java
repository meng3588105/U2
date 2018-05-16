package com.sousou.soso1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.sousou.jicheng.ServicePackage;

public class SosoMgr {

	/**
	 * 业务类
	 * 
	 * @param args
	 */

	Scanner input = new Scanner(System.in);
	
	MobileCard mobilecard = new MobileCard();
	CardUtil cardUtil = new CardUtil();

	// protected MobileCard mobilecard1;

	public void mainMenu() {
		Scanner input = new Scanner(System.in);

		int num = 0;// 输入的编号
		String cardNumber = "";// 手机卡号
		String passWord = "";// 密码
		String yanzheng = "";//验证码
		double money = 0;//充值金额
		boolean flag = true;
		
		
		do {
			System.out.println("※※※※※※※※※欢迎使用嗖嗖移动业务大厅※※※※※※※※※※");
			System.out.println("/n※※※※※※※1、用户登录※※※※※※※");
			System.out.println("/n※※※※※※※2、用户注册※※※※※※※");
			System.out.println("/n※※※※※※※3、使用嗖嗖※※※※※※※");
			System.out.println("/n※※※※※※※4、花费充值※※※※※※※");
			System.out.println("/n※※※※※※※5、资费说明※※※※※※※");
			System.out.println("/n※※※※※※※6、退出系统※※※※※※※");
			System.out.println("请输入序号：");
			num = input.nextInt();

			switch (num) {
			case 1:
				System.out.println("------欢迎进入【用户登录】界面------");
//				panduan();
				
				if(cardUtil.cards.get(cardNumber)==null){
				System.out.print("请输入手机卡号：");
				cardNumber = input.next();
				System.out.print("请输入登录密码：");
				passWord = input.next();
	
					if(cardUtil.isExistCard(cardNumber, passWord)){
                    cardMenu(cardNumber);
					}
				}else if(cardUtil.cards.get(cardNumber)!=null){
					if(cardUtil.isExistCard(cardNumber, passWord)){
	                    cardMenu(cardNumber);
						}
				
//				System.out.println("请输入验证码：");
//				yanzheng= input.next();


				}
				flag = true;
				break;
			case 2:
				System.out.println("------欢迎进入【用户注册】界面------");
				registCard();
				flag = true;
				break;
			case 3:
				System.out.println("------欢迎进入【使用嗖嗖】界面------");
				System.out.print("请输入手机卡号：");
				cardNumber = input.next();
//				System.out.print("请输入登录密码：");
//				passWord = input.next();
				if (cardUtil.cards.containsKey(cardNumber)
//						&& cardUtil.cards.get(cardNumber).getPassWord().equals(passWord)
						) {
					cardUtil.userSoso(cardNumber);

				}else{
					System.out.println("卡号输入错误，或者不存在");
				}
				
				flag = true;
				break;
			case 4:
				System.out.println("------欢迎进入【话费充值】界面------");
				System.out.print("请输入手机卡号：");
				cardNumber = input.next();

				
				if (cardUtil.cards.containsKey(cardNumber)) {
					System.out.println("请输入要充值的金额");
					money = input.nextDouble();
					cardUtil.chargeMoney(cardNumber,money);

				}else{
					System.out.println("卡号输入错误，或者不存在");
				}
				flag = true;
				break;
			case 5:
				System.out.println("------欢迎进入【资费说明】界面------");
				cardUtil.showDescription();
				flag = true;
				break;
			case 6:
				System.out.println("…………………………退出系统，谢谢使用…………………………");
				try {
					cardUtil.newXML(cardUtil.cards);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//把map里面的数据放入xml
				return;

			default:
				System.out.println("输入错误,请重新输入！");
				flag = true;
				break;
			}

		} while (flag);

	}

	/**
	 * 用户登录判断(暂时不用！！已经在工具类搞了)
	 */
	public void panduan() {
		cardUtil.newMAP(cardUtil.cards);
		String cardNumber = "";// 手机卡号
		String passWord = "";// 密码

		System.out.print("请输入手机卡号：");
		cardNumber = input.next();
		System.out.print("请输入登录密码：");
		passWord = input.next();
		if (cardUtil.cards.containsKey(cardNumber)
				&& cardUtil.cards.get(cardNumber).getPassWord()
						.equals(passWord)) {
			cardMenu(cardNumber);// 进入二级菜单

		}else {
			System.out.println("—————————————————————————————————————————");
			System.out.println("您输入的手机号或者卡号没有注册，请先注册再登录。");
			System.out.println("—————————————————————————————————————————");
		}

	}

	/**
	 * 用户登录二级菜单
	 * 
	 * @param a
	 */

	public void cardMenu(String number) {

		int num1 = 0;
		boolean flag = true;
		while (flag) {
			System.out.println("＊＊＊＊＊嗖嗖移动用户菜单＊＊＊＊＊＊");
			System.out.println("1、本月账单查询,2、套餐余量查询,3、打印消费详单,4、套餐变更,5、办理退网");
			System.out.println("请选择(输入1-5选择功能，其他键返回上一级)");
			num1 = input.nextInt();
			switch (num1) {
			case 1:
				System.out.println("☆☆本月账单查询☆☆");
				cardUtil.showaMountDetail(number);
				flag = true;
				break;
			case 2:
				System.out.println("☆☆套餐余量查询☆☆");
				cardUtil.showRemainDetail(number);
				flag = true;
				break;
			case 3:
				System.out.println("☆☆打印消费详单☆☆");
				cardUtil.printAmountDetail(number);
				break;
			case 4:
				System.out.println("☆☆套餐变更☆☆");
				cardUtil.changingPack(number);
				break;
			case 5:
				System.out.println("☆☆办理退网☆☆");
				cardUtil.delCard(number);
				break;
			default:
				flag = false;
				break;

			}

		}
	}

	/**
	 * 用户注册
	 */
	public void registCard() {
		//String number = "";// 输入的序号
		String userName = "";// 姓名
		String password = "";// 密码
		double money = 0;// 预存金额

		// 创建一个存储手机卡的数组，生成9个新卡列表
		String[] cardNumbers = cardUtil.getNewNumbers(9);
		System.out.println("可以选择的卡号：");
		for (int i = 0; i < cardNumbers.length; i++) {
			System.out.print((i + 1) + "." + cardNumbers[i] + "\t");
			if ((i + 1) % 3 == 0) {
				System.out.println();
			}
		}
		System.out.print("请选择卡号(输入1-9序号)");
		// number = cardNumbers[input.nextInt() - 1];
		mobilecard.setCardNumber(cardNumbers[input.nextInt() - 1]);
		System.out.print("1.话痨套餐 2.网虫套餐 3.超人套餐（输入序号）");
		boolean bol = true;
		while (bol) {
			String packageNumStr = input.next();

			switch (packageNumStr) {
			case "1":
				//话痨套餐
				mobilecard.setSerPackage(Commn.talkPackage);

				bol = false;
				break;
			case "2":
				//网虫套餐
				mobilecard.setSerPackage(Commn.netPackage);
				bol = false;
				break;
			case "3":
				//超人套餐
				mobilecard.setSerPackage(Commn.superPackage);
				bol = false;
				break;
			default:
				System.out.println("输入错误，请重新选择：");
				bol = true;
				break;
			}
		}
		// 输入姓名
		System.out.print("请输入姓名：");
		userName = input.next();
		mobilecard.setUserName(userName);
		// 输入密码
		System.out.print("请输入密码：");
		password = input.next();
		mobilecard.setPassWord(password);
		// 输入预存话费金额
		System.out.print("输入预存话费金额：");

		boolean flag = false;// 控制循环以及控制if语句
		do {
			if (flag == true) {
				System.out.println("您预存的话费金额不足以支付本月固定套餐资费("
						+ mobilecard.getSerPackage().getPrice() + "元)，请重新充值:");
			}

			while (true) {

				if (input.hasNextDouble() == true) {
					money = input.nextDouble();
					break;
				} else {
					System.out.println("输入错误！请重新输入");
				}
			}
		} while (flag);
		
		mobilecard.setMoney(money - mobilecard.getSerPackage().getPrice());// 余额
		mobilecard.setConsumAmount(mobilecard.getSerPackage().getPrice());
		cardUtil.addCard(mobilecard);// 注册后信息,加套餐类型x
		
		System.out.println("\n");
		// money=(mobilecard.getSerPackage().getPrice())-money;

		// cardUtil.cards.put(mobilecard.getCardNumber(), mobilecard);//存到map

		/*
		 * System.out.println("注册成功！卡号：" + mobilecard.getCardNumber() + ",用户名："
		 * + mobilecard.getUserName() + ",当前余额为：" + mobilecard.getMoney() +
		 * "元"); mobilecard.getSerPackage().showInfo();
		 */



	}
}
