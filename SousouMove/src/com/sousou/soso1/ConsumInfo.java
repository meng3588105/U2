package com.sousou.soso1;
/**
 * 消费信息类
 * @author Administrator
 *
 */
public class ConsumInfo {
	private String cardNumber;//卡号
	private String type;//消费类型
	private int consumData;//消费数据
	
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getConsumData() {
		return consumData;
	}

	public void setConsumData(int consumData) {
		this.consumData = consumData;
	}

	@Override
	public String toString() {
		return "ConsumInfo [cardNumber=" + cardNumber + ", consumData="
				+ consumData + ", type=" + type + "]";
	}

	public ConsumInfo(String cardNumber, String type, int consumData) {
		super();
		this.cardNumber = cardNumber;
		this.type = type;
		this.consumData = consumData;
	}
	public ConsumInfo(){
		super();
	}

	
	
	
}
