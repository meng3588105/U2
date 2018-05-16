package com.sousou.jicheng;

import com.sousou.jiekou.NetService;
import com.sousou.soso1.MobileCard;

/**
 * 网虫套餐类
 * @author Administrator
 *
 */
public  class NetPackage extends ServicePackage implements NetService{
	
	private int flow;//上网流量
	
	
	public NetPackage(double price,int flow) {
		super(price);//月资费
		this.flow = flow;//上网流量
	}


	@Override
	public String toString() {
		return "NetPackage [flow=" + flow + "]";
	}


	public int getFlow() {
		return flow;
	}


	public void setFlow(int flow) {
		this.flow = flow;
	}

	@Override
	public void showInfo() {
		System.out.println("网虫套餐："+"上网流量为"+this.flow/1024+"GB/月。");
		
	}


	/**
	 * 返回上网流量
	 */
	@Override
	public int netPlay(int flow, MobileCard card) throws Exception {
		int temp=flow;
		for (int i = 0; i < flow; i++) {
			//第一种情况：套餐内剩余的流量只有1MB
			if (this.flow-card.getRealFlow()>=1) {
				card.setRealFlow(card.getRealFlow()+1);//实际流量增加了1mb
				
			}else if (card.getMoney()>=0.1) {
				//第二种情况：套餐内的上网流量已经用完，账户余额可以支付1mb流量，使用账户余额支付
				card.setRealFlow(card.getRealFlow()+1);
				//账户余额消费0.1元，（1mb额外短信）
				card.setMoney(card.getMoney()-0.1);
				//当月消费金额加上金额多出来消费的流量费
				card.setConsumAmount(card.getConsumAmount() + 0.1);// 当月消费金额+0.1
			}else{
				temp = i;
				throw new Exception("本次流量已经使用" + i + "mb，余额不足请充值后再使用！");
			}
		}
		return temp;
	}
}
