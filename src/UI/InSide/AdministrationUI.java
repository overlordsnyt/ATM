package UI.InSide;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import Bank.DateTimeThread;
import UI.LoginUI;
import UI.Interface.AdminGeneral_UI;

/**
 * 后台管理主界面
 * @author overlord
 *
 */
public final class AdministrationUI extends AdminGeneral_UI {
	//明细，帐户管理，存款类型转换，开户，销户，返回登录界面
	JButton detail,manage,typeChange,open,delete,backup;
	/**
	 * 调用创建界面的父类构造方法
	 */
	public AdministrationUI(){
		super();
	}
	/**
	 * 创建一个管理界面
	 */
	public void create(){
		super.create();
		setBounds(300, 200, 800, 600);
		
		date.setBounds(600, 0, 200, 20);
		
		detail=new JButton("明       细");
		manage=new JButton("帐户管理");
		typeChange=new JButton("存款类型转换");
		open=new JButton("开       户");
		delete=new JButton("销       户");
		backup=new JButton("返回登录");
		
		JLabel title=new JLabel("要进行什么后台操作?");
		title.setFont(new Font("华文琥珀", 0, 24));
		title.setBounds(290, 30, 300, 60);
		add(title);
		
		detail.setBounds(0, 100, 250, 60);
		manage.setBounds(0, 270, 250, 60);
		typeChange.setBounds(0, 450, 250, 60);
		open.setBounds(550, 100, 250, 60);
		delete.setBounds(550, 270, 250, 60);
		backup.setBounds(550, 450, 250, 60);
		
		add(detail);
		add(manage);
		add(typeChange);
		add(open);
		add(delete);
		add(backup);
	}
	
	public void listen(){
		
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DateTimeThread(new DeleteUI());
			}
		});
		backup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new LoginUI();
			}
		});
	}
}
