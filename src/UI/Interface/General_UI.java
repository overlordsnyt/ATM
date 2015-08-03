package UI.Interface;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;

import Bank.DateTimeThread;
import Bank.LoginInfo;
import UI.OutSide.MainInterface;

/**
 * 通用标准界面，一个UI接口的实现类
 * 需要重写的项目：
 * setTitle;setBounds
 * 自带方法：
 * @author overlord
 *
 */
public class General_UI extends DateUI implements UI{
	/*
	 * 登录的用户信息
	 */
	public String[] info;
	
	/**
	 * 创建一个界面的构造方法
	 * 执行操作：
	 * 获取登录信息保存为info属性
	 * 创建一个界面
	 * 添加界面元素的监听器
	 * 添加关闭窗口按钮监听器
	 * @param info	登录的账户信息
	 */
	public General_UI(String[] info){
		this.info=new LoginInfo().getInfo(info[0]);
		create();
		setVisible(true);
		listen();
		closeWindow();
	}
	
	/**
	 * 创建一个带“卡号”和“日期时间”的界面
	 * 需要在继承类中设置:
	 * setTitle,setBounds,date.setBounds
	 */
	@Override
	public void create() {
		super.create();
		setRootPaneCheckingEnabled(true);
		setLayout(null);
		getContentPane().setBackground(c);
		setResizable(false);
		
		JLabel account=new JLabel("卡号："+info[1]);
		account.setBounds(10, 0, 150, 20);
		add(account);
	}

	/**
	 * 界面元素的监听器
	 */
	@Override
	public void listen() {
		
	}

	/**
	 * 关闭窗口按钮退出程序
	 */
	@Override
	public void closeWindow() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	/**
	 * 关闭当前界面，创建一个主界面
	 */
	public void openMainUI(){
		dispose();
		new DateTimeThread(new MainInterface(info));
	}

}
