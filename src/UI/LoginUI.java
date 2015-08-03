package UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Bank.DateTimeThread;
import Bank.LoginInfo;
import Server.Login;
import UI.InSide.AdministrationUI;
import UI.Interface.UI;
import UI.OutSide.MainInterface;

/**
 * 打开程序的基础登录界面
 * @author overlord
 *
 */
public class LoginUI extends JFrame implements UI{
	/*
	 * 卡号输入框
	 * 密码输入框
	 * 按钮：登录，后天登录，退出
	 * 登录次数计数器
	 */
	JTextField accountF;
	JPasswordField passwordF;
	JButton login,admin,exit;
	byte count=1;
	/**
	 * 构造调用：
	 * 创建界面
	 * 添加监听器
	 * 添加关闭窗口方法
	 */
	public LoginUI(){
		create();
		listen();
		closeWindow();
	}
	/**
	 * 创建登录界面
	 */
	@Override
	public void create() {
		setTitle("登录ATM_Rebuild");
		setRootPaneCheckingEnabled(true);
		setLayout(null);
		setBounds(300, 200, 500, 300);
		getContentPane().setBackground(c);
		setResizable(false);
		
		JLabel welcome=new JLabel("欢迎来到银行登录系统！");
		welcome.setFont(new Font("华文琥珀", 0, 24));
		welcome.setBounds(120, 20, 300, 50);
		add(welcome);
		
		JLabel accountL=new JLabel("账号：");
		JLabel passwordL=new JLabel("密码：");
		accountL.setBounds(100, 80, 60, 20);
		passwordL.setBounds(100, 120, 60, 20);
		add(accountL);
		add(passwordL);
		
		accountF=new JTextField();
		passwordF=new JPasswordField();
		accountF.setBounds(160, 80, 180, 20);
		passwordF.setBounds(160, 120, 180, 20);
		add(accountF);
		add(passwordF);
		
		login=new JButton("登录");
		admin=new JButton("管理后台");
		exit=new JButton("退出");
		login.setBounds(100, 160, 90, 20);
		admin.setBounds(190, 160, 90, 20);
		exit.setBounds(280, 160, 100, 20);
		add(login);
		add(admin);
		add(exit);
		
		setVisible(true);
	}
	/**
	 * 添加界面元素监听器
	 */
	@Override
	public void listen() {
		
		/**
		 * 添加登录按钮监听器：
		 * 点击则弹出提示框，显示登录情况
		 * 成功则建立卡号相应的主界面，否则清空项目要求重新输入
		 * 若3次登录失败，则退出程序
		 */
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Login log=new Login(accountF.getText(), passwordF.getPassword(), count);
				JOptionPane.showMessageDialog(getContentPane(), log.showMessage());
				if(JOptionPane.OK_OPTION==0){
					switch(log.getSituation()){
					case 1:{
						dispose();
						new DateTimeThread(new MainInterface(new LoginInfo(accountF.getText()).getInfo()));
						return;
					}
					case 2:{
						System.exit(0);
					}
					default:{
						count++;
						clear();
					}
					}
				}
			}
		});
		
		/**
		 * 点击管理员登录
		 */
		admin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ac=accountF.getText();
				String pw=new String(passwordF.getPassword());
				String hint="管理员登录失败！";
				byte judge=0;
				if(ac.equals("admin")&&pw.equals("admin")){
					hint="管理员登录成功";
					judge=1;
				}
				JOptionPane.showMessageDialog(getContentPane(), hint);
				if(JOptionPane.OK_OPTION==0){
					if(judge==1){
						dispose();
						new DateTimeThread(new AdministrationUI());
					} else clear();
				}
			}
		});
		
		/**
		 * 点击exit退出程序
		 */
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * 添加窗口关闭退出程序监听器
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
	 * 清空填写项目
	 */
	private void clear(){
		accountF.setText("");
		passwordF.setText("");
	}
	/**
	 * 接口方法，不实现
	 */
	public void openMainUI(){}
}
