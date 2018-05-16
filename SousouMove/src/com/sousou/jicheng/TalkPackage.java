package com.sousou.jicheng;

import com.sousou.jiekou.CallService;
import com.sousou.jiekou.SendService;
import com.sousou.soso1.MobileCard;

/**
 * 话痨套餐类
 * @author Administrator
 *
 */
public  class TalkPackage extends ServicePackage implements CallService, SendService{
	private int talkTime;//通话时长
	private int smsCount;//短信条数
	
	public int getTalkTime() {
		return talkTime;
	}

	public void setTalkTime(int talkTime) {
		this.talkTime = talkTime;
	}

	public int getSmsCount() {
		return smsCount;
	}

	public void setSmsCount(int smsCount) {
		this.smsCount = smsCount;
	}

	
	
	public TalkPackage(double price,int talkTime,int smsCount) {
		super(price);//月资费
		this.talkTime = talkTime;//通话时长
		this.smsCount = smsCount;//短信条数
	}
	


	@Override
	public String toString() {
		return "TalkPackage [talkTime=" + talkTime + ", smsCount=" + smsCount
				+ "]";
	}
/**
 * 重写了父类的抽象方法
 * 话痨套餐，套餐内容
 */
	@Override
	public void showInfo() {
		System.out.println("话痨套餐：通话时长为"+this.talkTime+"分钟/月,短信条数为"
	+this.smsCount+"条/月"+"");
		
	}

	/**
	 * 返回短信条数
	 */
	@Override
	public int send(int count, MobileCard card) throws Exception {
		int temp = count;
		for (int i = 0; i < count; i++) {
			// 第一种情况：套餐内剩余的短信条数只够发送一条短信
			if (this.smsCount - card.getRealSMSCount() >= 1) {
				card.setRealSMSCount(card.getRealSMSCount() + 1);// 实际短信条数加1
			} else if (card.getMoney() >= 0.1) {
				// 第二种情况：套餐内的短信条数已经用完，账户余额可以支付1条短信，使用账户余额支付
				card.setRealSMSCount(card.getRealSMSCount() + 1);
				// 账户余额消费0.1，（1条额外短信）
				card.setMoney(card.getMoney() - 0.1);
				// 当月消费金额加上余额多出来消费的短信费
				card.setConsumAmount(card.getConsumAmount() + 0.1);// 当月消费金额+0.1

			} else {
				temp = i;
				throw new Exception("本次短信已经发送" + i + "条，余额不足请充值后再使用！");

			}

		}

		return temp;
	}

	/**
	 * 返回通话时长
	 */
		@Override
		public int call(int minCount, MobileCard card) throws Exception {
		
			int temp = minCount;
			for (int i = 0; i < minCount; i++) {
				//第一种情况：套餐剩余通话时长可以支持1分钟通话
				if (this.talkTime - card.getRealTalkTime() >= 1) {
					card.setRealTalkTime(card.getRealTalkTime() + 1);// 实际通话数据加1
				}else if (card.getMoney()>=0.2) {
					//第二种情况：套餐通话时长已用完，账户余额可以支付1分钟通话，使用账户余额支付
					card.setRealTalkTime(card.getRealTalkTime()+1);
	                //账户余额消费0.2元（1分钟 额外通话）
	                card.setMoney(card.getMoney() - 0.2);
	                card.setConsumAmount(card.getConsumAmount() + 0.2);  //当月消费金额 + 0.2
				}else{
					temp=i;//记录实际通话分钟数
					 throw new Exception("本次已经通话" + i + "分钟，您的余额不足，请充值后再使用！");
				}
			}

			return temp;
		}


	
}
