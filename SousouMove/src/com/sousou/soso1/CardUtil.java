package com.sousou.soso1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.sousou.jicheng.NetPackage;
import com.sousou.jicheng.ServicePackage;
import com.sousou.jicheng.SuperPackage;
import com.sousou.jicheng.TalkPackage;
import com.sousou.jiekou.CallService;
import com.sousou.jiekou.NetService;
import com.sousou.jiekou.SendService;

/**
 * 工具类
 * 
 * @author Administrator
 * 
 */
public class CardUtil {
	Scanner input = new Scanner(System.in);
	Document doc = null;
	// String cardNumbertStr = "";
	/**
	 * 初始用户集合
	 */
	// 已注册嗖嗖移动用户列表
	protected static Map<String, MobileCard> cards = new HashMap<String, MobileCard>();

	// 所有卡号的消费记录列表
	protected Map<String, List<ConsumInfo>> consumInfos = new HashMap<String, List<ConsumInfo>>();
	// 使用场景列表
	protected Map<Integer, Scene> scenes = new HashMap<Integer, Scene>();// 使用场景列表
	protected Scene scene0 = new Scene("通话", 90, "问候客户，谁知其如此难缠，通话90分钟\n");
	protected Scene scene1 = new Scene("通话", 30, "询问妈妈身体状况，本地通话30分钟\n");
	protected Scene scene2 = new Scene("短信", 5, "参与环境保护实施方案问卷调查，发送短信5条\n");
	protected Scene scene3 = new Scene("短信", 50, "通知朋友手机换号，发送短信50条\n");
	protected Scene scene4 = new Scene("上网", 1024, "和女朋友用微信视频聊天，使用流量1GB\n");
	protected Scene scene5 = new Scene("上网", 2 * 1024,
			"晚上手机在线看韩剧，不留神睡着啦！使用2GB\n");

	/**
	 * 生成随机卡号
	 */
	// Random random =new Random();
	// int temp = random.nextInt(100000000);

	public String createNumber() {
		Random random = new Random();
		// 记录现有用户中是否存在此卡号用户 是：true 否：false
		boolean isExist = false;
		String number = "";
		int temp = 0;
		do {
			isExist = false;// 标志位重置为false，用于控制外冲循环
			// 生成随机数是8位，不能小于100000000，否则重新生成
			do {
				temp = random.nextInt(100000000);
			} while (temp < 10000000);
			// 生成之前，前面加“139”
			number = "139" + temp;
			// 和现有用户的卡号比较，不能是重复的
			Set<String> cardNumbers = cards.keySet();
			for (String cardNumber : cardNumbers) {
				if (number.equals(cardNumber)) {
					isExist = true;
					break;
				}
			}
		} while (isExist);

		return number;

	}

	/**
	 * 生成指定个数的卡号列表
	 */
	public String[] getNewNumbers(int count) {

		String[] numbers = new String[count];
		for (int i = 0; i < count; i++) {
			numbers[i] = createNumber();

		}
		return numbers;
	}

	/**
	 * 注册新卡
	 * 
	 * @param card
	 */
	public void addCard(MobileCard card) {
		// cards.put(card.getUserName(), card);

		cards.put(card.getCardNumber(), card);

		System.out.println("\n恭喜您！注册成功！\n");
		card.showMeg();
	}

	/**
	 * 话费充值
	 */

	public void chargeMoney(String number, double money) {
		MobileCard card;// 指定的手机卡
		if (money < 50) {
			System.out.println("对不起您最低充值金额为50元");

		}
		card = cards.get(number);
		card.setMoney(card.getMoney() + money);
		System.out.println("充值后的金额为：" + card.getMoney() + "元。\n");

	}

	/**
	 * 使用嗖嗖
	 */
	public void userSoso(String number) {
		scenes.put(0, scene0);// 通话
		scenes.put(1, scene1);
		scenes.put(2, scene2);// 短信
		scenes.put(3, scene3);
		scenes.put(4, scene4);// 上网
		scenes.put(5, scene5);

		MobileCard card = cards.get(number);// 获得此卡对象
		ServicePackage pack = card.getSerPackage();// 获得此卡的所属套餐
		// 生成一个随机数
		Random random = new Random();
		int ranNum = 0;
		int temp = 0;// 记录各个场景中的实际消费数据
		do {
			ranNum = random.nextInt(6);
			Scene scene = scenes.get(ranNum);// 获取该序号所对应的场景
			switch (ranNum) {
			case 0:
			case 1:
				// 序号是0或1的为通话场景
				// 判断该卡所属套餐是否支持通话功能
				if (pack instanceof CallService) {
					// 执行通话方法
					System.out.println(scene.getDescription());
					CallService callService = (CallService) pack;
					try {
						temp = callService.call(scene.getData(), card);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// 添加一条消费记录
					addConsumInfo(number,
							new ConsumInfo(number, scene.getType(), temp));
				} else {
					// 如果该卡套餐不支持通话功能，则重新生成随机数选择其他场景
					continue;
				}
				break;
			case 2:
			case 3:
				// 序号2或3的短信场景
				// 判断该卡所属套餐是否支持短信功能
				if (pack instanceof SendService) {
					System.out.println(scene.getDescription());// 场景描述
					SendService sendService = (SendService) pack;
					try {
						temp = sendService.send(scene.getData(), card);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// 添加一条消费记录
					addConsumInfo(number,
							new ConsumInfo(number, scene.getType(), temp));
				} else {
					// 如果该卡套餐不支持短信功能，则重新生成随机数选择其他场景
					continue;
				}
				break;
			case 4:
			case 5:
				// 序号4或5的流量场景
				// 判断该卡所属套餐是否支持流量功能
				if (pack instanceof NetService) {
					System.out.println(scene.getDescription());// 场景描述
					NetService netService = (NetService) pack;
					try {
						temp = netService.netPlay(scene.getData(), card);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// 添加一条消费记录
					addConsumInfo(number,
							new ConsumInfo(number, scene.getType(), temp));
				} else {
					// 如果该卡套餐不支持流量功能，则重新生成随机数选择其他场景
					continue;
				}
				break;

			}
			return;
		} while (true);

	}

	/**
	 * 资费说明
	 */
	public void showDescription() {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			// 读取
			fr = new FileReader("E:/Man/U1/SousouMove/src/explain.txt");
			br = new BufferedReader(fr);
			// 写入
			// fw = new FileWriter("E:/IO/target.txt",true);
			// bw = new BufferedWriter(fw);

			StringBuffer sb = new StringBuffer();
			String ll = null;

			while ((ll = br.readLine()) != null) {
				sb.append(ll + "\n");
			}
			System.out.println(sb);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 本月账单查询
	 */

	public void showaMountDetail(String number) {

		MobileCard card;// 要查询的卡
		StringBuffer meg = new StringBuffer();
		card = cards.get(number);// 获取集合中一个元素、
		System.out.println("您的卡号：" + card.getCardNumber() + ",当月账单：\n");
		meg.append("套餐资费：" + card.getSerPackage().getPrice() + "元\n");

		meg.append("合计：" + Commn.dataFormat(card.getConsumAmount()) + "元\n");
		meg.append("账户余额：" + Commn.dataFormat(card.getMoney()) + "元");
		System.out.println(meg);

	}

	/**
	 * 套餐余量查询
	 */
	public void showRemainDetail(String number) {
		MobileCard card;// 要查询的卡
		int remainTalkTime;
		int remainSmsCount;
		int remainFlow;
		StringBuffer meg = new StringBuffer();
		card = cards.get(number);
		meg.append("您的卡号是：" + number + "\n套餐内剩余：\n");
		ServicePackage pack = card.getSerPackage();
		if (pack instanceof TalkPackage) {
			// 向下转型为话痨套餐对象
			TalkPackage cardPack = (TalkPackage) pack;
			// 话痨套餐，查询套餐内剩余的通话时长
			remainTalkTime = cardPack.getTalkTime() > card.getRealTalkTime() ? cardPack
					.getTalkTime() - card.getRealTalkTime()
					: 0;
			meg.append("通话时长剩余：" + remainTalkTime + "分钟\n");
			// 话痨套餐，查询套餐内剩余的短信条数
			remainSmsCount = cardPack.getSmsCount() > card.getRealSMSCount() ? cardPack
					.getSmsCount() - card.getRealSMSCount()
					: 0;
			meg.append("短信条数剩余：" + remainSmsCount + "条");
		} else if (pack instanceof NetPackage) {
			// 向下转型为网虫套餐
			NetPackage cardPack = (NetPackage) pack;
			// 网虫套餐，查询套餐内剩余的上网流量
			remainFlow = cardPack.getFlow() > card.getRealFlow() ? cardPack
					.getFlow() - card.getRealFlow() : 0;
			meg.append("上网流量剩余：" + remainFlow + "MB");
		} else if (pack instanceof SuperPackage) {
			// 向下转型为超人套餐对象
			SuperPackage cardPack = (SuperPackage) pack;
			// 超人套餐，查询套餐内剩余的通话时长
			remainTalkTime = cardPack.getTalkTime() > card.getRealTalkTime() ? cardPack
					.getTalkTime() - card.getRealTalkTime()
					: 0;
			meg.append("通话时长剩余：" + remainTalkTime + "分钟\n");
			// 超人套餐，查询套餐内剩余的短信条数
			remainSmsCount = cardPack.getSmsCout() > card.getRealSMSCount() ? cardPack
					.getSmsCout() - card.getRealSMSCount()
					: 0;
			meg.append("短信条数剩余：" + remainSmsCount + "条\n");
			// 超人套餐，查询套餐内剩余的上网流量
			remainFlow = cardPack.getFlow() > card.getRealFlow() ? cardPack
					.getFlow() - card.getRealFlow() : 0;
			meg.append("上网流量剩余：" + remainFlow + "MB");
		}
		System.out.println(meg);

	}

	/**
	 * 打印消费详单
	 */
	public void printAmountDetail(String number) {
		Writer fileWriter = null;
		try {
			fileWriter = new FileWriter("E:/xfxd.txt", true);
			Set<String> numbers = consumInfos.keySet();
			Iterator<String> it = numbers.iterator();
			List<ConsumInfo> infos = new ArrayList<ConsumInfo>();
			// 存储指定卡的所有消费记录
			// 现有消费列表中是否存在此卡号消费记录,是：true 否：false
			boolean isExist = false;
			// 循环判断是否存在可访问元素
			while (it.hasNext()) {
				String numberKey = it.next();
				if (number.equals(numberKey)) {
					isExist = true;
				}
			}
			if (isExist) {
				StringBuffer content = new StringBuffer("******" + number
						+ "消费记录******\n");
				content.append("序号\t类型\t数据(通话(分钟)/上网(MB)/短信(条))\n");
				for (int i = 0; i < infos.size(); i++) {
					ConsumInfo info = infos.get(i);
					content.append((i + 1) + ".\t" + info.getType() + ""
							+ info.getConsumData() + "\n");
				}

				fileWriter.write(content.toString() + "\n");// 写入
				fileWriter.flush();// 刷新缓冲区
				System.out.println("消费记录打印完毕！");
			} else {
				System.out.println("对不起，不存在此号码的消费记录，不能打印");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();// 关闭流
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 套餐变更
	 */
	public void changingPack(String number) {

		int biangeng = 0;
		System.out.println("请选择你要变更的套餐：1、话痨套餐，2、网虫套餐，3、超人套餐");
		biangeng = input.nextInt();
		switch (biangeng) {
		case 1:
			// 如果当前套餐向下转型为话痨套餐，当前套餐为话痨套餐，提示变更失败
			if (cards.get(number).getSerPackage() instanceof TalkPackage) {
				System.out.println("变更套餐失败，您已经是话痨套餐的用户。");
				// 如果当前套餐不是话痨套餐，变更套餐时候月资费不够支付话痨套餐月资费则 提示余额不足
			} else if (cards.get(number).getMoney() < cards.get(number)
					.getSerPackage().getPrice()) {
				System.out.println("话痨套餐的月资费你的余额不够付的，充值后再来变更吧！");
			} else {
				cards.get(number).getRealSMSCount();// 短信
				cards.get(number).getRealTalkTime();// 通话
				cards.get(number).getRealFlow();// 上网流量
				cards.get(number).setSerPackage(Commn.talkPackage);// 变更为话痨套餐
				System.out.println("恭喜你，变更套餐成功！当前套餐为：");
				Commn.talkPackage.showInfo();// 输出话痨套餐资费
			}
			break;
		case 2:
			// 如果当前套餐向下转型为网虫套餐，当前套餐为网虫套餐，提示变更失败！
			if (cards.get(number).getSerPackage() instanceof NetPackage) {
				System.out.println("变更套餐失败，您已经是网虫套餐的用户。");
			} else if (cards.get(number).getMoney() < cards.get(number)
					.getSerPackage().getPrice()) {
				System.out.println("网虫套餐的月资费您的余额不够支付，充值后再来变更吧！");
			} else {
				cards.get(number).getRealSMSCount();// 短信
				cards.get(number).getRealTalkTime();// 通话
				cards.get(number).getRealFlow();// 上网流量
				cards.get(number).setSerPackage(Commn.netPackage);
				System.out.println("恭喜你，变更套餐成功！当前套餐为：");// 变更为网虫套餐
				Commn.netPackage.showInfo();// 输出网虫套餐资费
			}
			break;
		case 3:
			// 如果当前套餐向下转型为超人套餐，当前套餐为超人套餐，提示变更失败！
			if (cards.get(number).getSerPackage() instanceof SuperPackage) {
				System.out.println("变更套餐失败，您已经是网虫套餐的用户。");
			} else if (cards.get(number).getMoney() < cards.get(number)
					.getSerPackage().getPrice()) {
				System.out.println("网虫套餐的月资费您的余额不够支付，充值后再来变更吧！");
			} else {
				cards.get(number).getRealSMSCount();// 短信
				cards.get(number).getRealTalkTime();// 通话
				cards.get(number).getRealFlow();// 上网流量
				cards.get(number).setSerPackage(Commn.superPackage);
				System.out.println("恭喜你，变更套餐成功！当前套餐为：");// 变更为超人套餐
				Commn.superPackage.showInfo();// 输出超人套餐资费
			}
			break;

		}

	}

	/**
	 * 办理退网
	 */
	public void delCard(String number) {

		Set<String> numberkeys = cards.keySet();// 取出key 的值
		// 用Iterator 遍历
		Iterator<String> it = numberkeys.iterator();

		while (it.hasNext()) {
			String numberKey = it.next();
			// 如果在集合中找到此号码，则删除他，完成退网
			if (numberKey.equals(number)) {
				// 删除
				System.out.println("确定要退网吗？");
				System.out.println("1、坚持退网，2、不退了！");
				int xu = input.nextInt();
				if (xu == 1) {
					cards.remove(numberKey);
					System.out.println("您退网的卡号是:" + number
							+ "\n拜拜嘞您嘞！！\n***********");
				} else if (xu == 2) {
					System.out.println("请您继续使用。");
				}

			} else {
				System.out.println("没有找到您的卡号或者手机号");
			}
		}
	}

	/**
	 * 加载DOM树
	 */
	public void loadDociment() {
		/*
		 * SAXReader saxReader = new SAXReader(); try { doc
		 * =saxReader.read("ceshi.xml"); } catch (DocumentException e)
		 * 
		 * { Auto-generated catch block e.printStackTrace(); }
		 */
	}

	/**
	 * 根据卡号和密码验证该卡是否注册
	 * 
	 * @return
	 */
	public boolean isExistCard(String cardNumber, String passWord) {
		newMAP(cards);
		if (cards.size() != 0) {
			if (cards.get(cardNumber) != null
					&& cards.get(cardNumber).getPassWord().equals(passWord)) {
				System.out.println("—————————————————————————————————————————");
				System.out.println("恭喜您！登录成功请按相应的序号进行操作！");
				System.out.println("—————————————————————————————————————————");

			} else if (cards.get(cardNumber) == null) {
				System.out.println("—————————————————————————————————————————");
				System.out.println("大哥，随机卡号都能记住，密码还记不住吗？重新输入密码！！");
				System.out.println("—————————————————————————————————————————");
				return false;
			}
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 根据卡号验证该卡是否注册（从xml）
	 */
	public void isExistCard() {
		/*
		 * b Element root = doc.getRootElement();// 得到dom树根节点 Iterator itsousou
		 * = root.elementIterator(); while (itsousou.hasNext()) { Element
		 * cardNumbertEle = (Element) itsousou.next();//意思是根节点下的本级节点
		 * studentEle用于后面. String cardNumbertStr =
		 * cardNumbertEle.attributeValue("id1");//本级节点的目录 id 赋值给 studentStr 输出即可
		 * Iterator itUesr = cardNumbertEle.elementIterator();//找到下一级节点
		 * itUesr用于下一级菜单引用 System.out.println(cardNumbertStr);
		 * 
		 * }
		 */
	}

	/**
	 * 添加指定卡号的消费记录
	 */
	public void addConsumInfo(String number, ConsumInfo info) {
		Set<String> number1 = consumInfos.keySet();
		Iterator<String> it = number1.iterator();
		List<ConsumInfo> infos = new ArrayList<ConsumInfo>();
		boolean isExist = false;
		while (it.hasNext()) {
			if (it.next().equals(number)) {
				infos = consumInfos.get(number);
				infos.add(info);
				isExist = true;
				System.out.println("已经添加一条消费记录。");
				break;
			}
		}

		if (!isExist) {
			infos.add(info);
			consumInfos.put(number, infos);
			System.out.println("不存在此卡的消费记录，已经添加一条消费记录");

		}
	}

	/**
	 * 把Map集合里面的数据保存到xml
	 * 
	 * @throws ClassNotFoundException
	 */
	public void newXML(Map<String, MobileCard> cards)
			throws ClassNotFoundException {
		// 创建Document 实例
		Document document = DocumentHelper.createDocument();
		// 创建一个根节点
		Element gen = document.addElement("GEN");

		// 使用反射得到MobileCard类里面的所有属性、方法（包括私有的属性和方法）

		Class<?> clazz = Class.forName("com.sousou.soso1.MobileCard");

		Field[] field = clazz.getDeclaredFields();

		for (MobileCard card : cards.values()) {
			// 创建子节点
			Element mobileCard = gen.addElement("mobileCard");
			mobileCard.addAttribute("id", card.getCardNumber());
			
			for (Field item : field) {
				String name = item.getName();
				Element element = gen.addElement(name);

				if (name.equals("cardNumber")) {
					element.setText(card.getCardNumber());
				}
				if (name.equals("userName")) {
					element.setText(card.getUserName());
				}
				if (name.equals("passWord")) {
					element.setText(card.getPassWord());
				}
				if (name.equals("serPackage")) {
					element.setText(String.valueOf(card.getSerPackage()));
				}
				if (name.equals("consumAmount")) {
					element.setText(String.valueOf(card.getConsumAmount()));
				}
				if (name.equals("money")) {
					element.setText(String.valueOf(card.getMoney()));
				}
				if (name.equals("realTalkTime")) {
					element.setText(String.valueOf(card.getRealTalkTime()));
				}
				if (name.equals("realSMSCount")) {
					element.setText(String.valueOf(card.getRealSMSCount()));
				}
				if (name.equals("realFlow")) {
					element.setText(String.valueOf(card.getRealFlow()));
				}

			}
		}

		OutputFormat format = OutputFormat.createPrettyPrint();
		File file = new File("XMLxml.xml");
		XMLWriter writer = null;
		// format.setSuppressDeclaration(true);//每次都不生成xml抬头声明字段
		try {

			writer = new XMLWriter(new FileOutputStream(file), format);

			writer.write(document);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 把xml保存到Map集合中 解析xml文件
	 * 
	 * @throws ClassNotFoundException
	 */
	public void newMAP(Map<String, MobileCard> cards) {
		MobileCard card = null;
		SAXReader reader = new SAXReader();

		try {
			File file = new File("XMLxml.xml");
			if (!file.exists()) {
				file.createNewFile();
			}
			// 加载MobileCards.xml文件
			Document document = reader.read(file);
			// 获得根节点
			Element gen = document.getRootElement();
			// 获取迭代器
			Iterator it = gen.elementIterator();
			while (it.hasNext()) {
				// 获取子节点
				Element childNodes = (Element) it.next();
				System.out.println(childNodes.getName());
				// 获取子节点下的所有集合
				card = new MobileCard();

				if (childNodes.getName().equals("cardNumber")) {
					card.setCardNumber(childNodes.getStringValue());
				}
				if (childNodes.getName().equals("consumAmount"))
					card.setConsumAmount(Double.parseDouble(childNodes
							.getStringValue()));
				if (childNodes.getName().equals("money"))
					card.setMoney(Double.parseDouble(childNodes
							.getStringValue()));
				if (childNodes.getName().equals("passWord"))

					card.setPassWord(childNodes.getStringValue());
				if (childNodes.getName().equals("realFlow"))
					card.setRealFlow(Integer.parseInt(childNodes
							.getStringValue()));
				if (childNodes.getName().equals("realSMSCount"))
					card.setRealSMSCount(Integer.parseInt(childNodes
							.getStringValue()));
				if (childNodes.getName().equals("realTalkTime"))
					card.setRealTalkTime(Integer.parseInt(childNodes
							.getStringValue()));
				if (childNodes.getName().equals("userName"))
					card.setUserName(childNodes.getStringValue());
				if (childNodes.getName().equals("serPackage")) {

					/*System.out.println(childNodes.getStringValue());
					String value = childNodes.getStringValue();
					String mo = value.substring(0, value.indexOf(" "));
					System.out.println(mo);
					if (mo.equals("SuperPackage")) {
						String str1 = value.substring(
								value.indexOf("talkTime="), value.indexOf(","));

						System.out.println(value);

						String str3 = value.substring(value.indexOf("flow="),
								value.indexOf("]"));
						System.out.println(str3);

						Class<?> clazz = Class.forName("com.sousou.jicheng."
								+ mo);
						Constructor<?> constructor = clazz
								.getDeclaredConstructor(new Class[] {});
						SuperPackage object = (SuperPackage) constructor
								.newInstance(new Object[] {});
						object.setFlow(new Integer(str3));
						object.setTalkTime(new Integer(str1));

						card.setSerPackage(object);
*/
					}
				}

				//Iterator itt = mobileCard.elementIterator();
				

			
			cards.put(card.getCardNumber(), card);

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
