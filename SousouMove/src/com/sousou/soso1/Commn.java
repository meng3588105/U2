package com.sousou.soso1;

import java.text.DecimalFormat;

import com.sousou.jicheng.NetPackage;
import com.sousou.jicheng.SuperPackage;
import com.sousou.jicheng.TalkPackage;
/**
 * 这个类是存储套餐各项信息的类。之后准备拿xml代替
 * @author Administrator
 *
 */
public class Commn {
    //实例化嗖嗖移动卡
    //static MobileCard mobileCard = new MobileCard();
    //实例化话唠套餐
    static TalkPackage talkPackage = new TalkPackage(58, 500, 30);
    //实例化网虫套餐
    static NetPackage netPackage = new NetPackage(68, 3 * 1024);
    //实例化超人套餐
    static SuperPackage superPackage = new SuperPackage(78, 200, 50, 1 * 1024);

 
	public static String dataFormat(double data) {
		DecimalFormat formatData = new DecimalFormat("#0.0");
		return formatData.format(data);
	}
}
