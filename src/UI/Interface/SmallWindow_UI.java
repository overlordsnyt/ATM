package UI.Interface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * 需要重写的项目：
 * title.setText
 * submit的监听器:listen();
 * 已设置的项目：
 * 卡号显示，界面标题，时间显示，提交、返回按钮，返回主界面
 * @author overlord
 *
 */
public class SmallWindow_UI extends General_UI{
	/*
	 * 按钮：确认，返回主界面
	 * 功能名称
	 */
	public JButton submit,backup;
	public JLabel title;
	
	/**
	 * 调用父类构造方法
	 * 添加返回主界面按钮事件
	 * @param info	登录信息
	 */
	public SmallWindow_UI(String[] info){
		super(info);
		backupButton();
	}
	/**
	 * 创建一个小窗界面
	 * 设置小窗长宽位置
	 * 添加本功能名称标签
	 * 设置日期时间显示位置
	 * 添加 提交，返回 按钮
	 */
	public void create(){
		super.create();
		setBounds(300, 200, 500, 400);
		
		title=new JLabel("");
		title.setFont(new Font("微软雅黑", 1, 24));
		title.setBounds(200, 40, 200, 30);
		add(title);
		
		date.setBounds(300, 0, 200, 20);
		
		submit=new JButton("确认");
		backup=new JButton("返回主界面");
		submit.setBounds(70, 270, 170, 20);
		backup.setBounds(240, 270, 180, 20);
		add(submit);
		add(backup);
	}
	
	/**
	 * 添加返回按钮监听器
	 * 动作：调用openMainUI()方法
	 */
	public void backupButton(){
		backup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openMainUI();
			}
		});
	}
}
