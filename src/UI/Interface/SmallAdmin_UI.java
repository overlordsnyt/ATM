package UI.Interface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * 通用后台小型窗口
 * 需要设置的项目：
 * setTitle();Title.setText();date.setBounds();
 * @author overlord
 *
 */
public class SmallAdmin_UI extends AdminGeneral_UI {
	/*
	 * 按钮：确认，返回主界面
	 * 功能名称
	 */
	public JButton submit,backup;
	public JLabel title;

	/**
	 * 调用父类构造方法
	 * 添加返回主界面按钮事件
	 */
	public SmallAdmin_UI(){
		super();
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
