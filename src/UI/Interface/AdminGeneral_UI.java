package UI.Interface;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;

import Bank.DateTimeThread;
import UI.InSide.AdministrationUI;

/**
 * 后台管理通用界面
 * @author overlord
 *
 */
public class AdminGeneral_UI extends DateUI implements UI {
	
	/**
	 * 界面构造方法：
	 * 创建界面
	 * 显示界面
	 * 添加界面元素监听器
	 * 添加关闭窗口退出程序方法
	 */
	public AdminGeneral_UI(){
		create();
		setVisible(true);
		listen();
		closeWindow();
	}
	
	/**
	 * 创建一个基本界面
	 */
	@Override
	public void create() {
		super.create();
		setRootPaneCheckingEnabled(true);
		setLayout(null);
		getContentPane().setBackground(c);
		setResizable(false);
		
		JLabel account=new JLabel("管理员");
		account.setBounds(10, 0, 150, 20);
		add(account);
		
	}

	/**
	 * 界面元素的监听器
	 */
	@Override
	public void listen() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 点击关闭窗口退出程序的监听器
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
	 * 关闭当前界面，创建一个管理界面
	 */
	@Override
	public void openMainUI() {
		dispose();
		new DateTimeThread(new AdministrationUI());
	}

}
