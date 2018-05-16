package com.sousou.soso1;

import java.util.ArrayList;
import java.util.List;

import com.sousou.jicheng.ServicePackage;
import com.sun.xml.internal.bind.api.AccessorException;

/**
 * 嗖嗖移动卡类
 * @author Administrator
 *
 */
public class MobileCard {
	private String cardNumber;               //卡号
    private String userName;                //用户名
    private String passWord;               //密码
    private ServicePackage serPackage;    //移动卡所属套餐
    private double consumAmount;          //本月消费金额
    private double money;                 //本月余额
    private int realTalkTime;            //本月实际通话时长
    private int realSMSCount;            //本月实际发送短信条数
    private int realFlow;                //本月实际上网流量
//    private List<MobileCard> list = new ArrayList<MobileCard>();
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber=cardNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public ServicePackage getSerPackage() {
		return serPackage;
	}
	public void setSerPackage(ServicePackage serPackage) {
		this.serPackage = serPackage;
	}
	public double getConsumAmount() {
		return consumAmount;
	}
	public void setConsumAmount(double consumAmount) {
		
		this.consumAmount = consumAmount;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getRealTalkTime() {
		return realTalkTime;
	}
	public void setRealTalkTime(int realTalkTime) {
		this.realTalkTime = realTalkTime;
	}
	public int getRealSMSCount() {
		return realSMSCount;
	}
	public void setRealSMSCount(int realSMSCount) {
		this.realSMSCount = realSMSCount;
	}
	public int getRealFlow() {
		return realFlow;
	}
	public void setRealFlow(int realFlow) {
		this.realFlow = realFlow;
	}
	@Override
	public String toString() {
		return "MobileCard [cardNumber=" + cardNumber + ", userName="
				+ userName + ", passWord=" + passWord + ", serPackage="
				+ serPackage + ", consumAmount=" + consumAmount + ", money="
				+ money + ", realTalkTime=" + realTalkTime + ", realSMSCount="
				+ realSMSCount + ", realFlow=" + realFlow + "]";
	}
	
	
	
	public MobileCard(String cardNumber, String userName, String passWord,
			ServicePackage serPackage, double consumAmount, double money,
			int realTalkTime, int realSMSCount, int realFlow) {
		super();
		this.cardNumber = cardNumber;
		this.userName = userName;
		this.passWord = passWord;
		this.serPackage = serPackage;
		this.consumAmount = consumAmount;
		this.money = money;
		this.realTalkTime = realTalkTime;
		this.realSMSCount = realSMSCount;
		this.realFlow = realFlow;
//		this.list = list;

	}
	
	public MobileCard() {
		super();
		
	}
	//显示本卡信息
	public void showMeg(){
		System.out.println("——————————————————————————");
		System.out.println("卡号："+this.cardNumber+"\n用户名："+this.userName+"\n当前余额："+this.money+"元。");	
		this.serPackage.showInfo();//返回套餐类型
		System.out.println("——————————————————————————");
	}

	
	
    
    
}
