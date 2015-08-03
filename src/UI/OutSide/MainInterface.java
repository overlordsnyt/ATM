package UI.OutSide;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import Bank.DateTimeThread;
import UI.Interface.General_UI;

/**
 * 登录后操作主界面
 * @author overlord
 *
 */
public final class MainInterface extends General_UI{
	/*
	 * 添加按钮：提取现金，存款，转账业务，查询余额，修改密码，退出程序
	 */
	private JButton draw,save,transfer,inquiry,alterPW,exit;

	/**
	 * 读取父类的构造方法
	 * @param info	登录信息
	 */
	public MainInterface(String[] info) {
		super(info);
	}
	/**
	 * 创建主界面
	 */
	public void create(){
		super.create();
		setTitle("主界面");
		setBounds(300, 200, 800, 600);
		
		JLabel title=new JLabel("请选择您需要的服务");
		title.setFont(new Font("华文琥珀", 0, 24));
		title.setBounds(290, 30, 300, 60);
		add(title);
		
		date.setBounds(600, 0, 200, 20);
		
		JLabel name=new JLabel(info[5]+info[6]+"您好！");
		name.setFont(new Font("黑体", 1, 16));
		name.setBounds(320, 15, 200, 20);
		add(name);
		
		
		draw=new JButton("提取现金");
		save=new JButton("存        款");
		transfer=new JButton("转账业务");
		inquiry=new JButton("查询余额");
		alterPW=new JButton("修改密码");
		exit=new JButton("退出程序");
		
		draw.setBounds(0, 100, 250, 60);
		save.setBounds(0, 270, 250, 60);
		transfer.setBounds(0, 450, 250, 60);
		inquiry.setBounds(550, 100, 250, 60);
		alterPW.setBounds(550, 270, 250, 60);
		exit.setBounds(550, 450, 250, 60);
		
		add(draw);
		add(save);
		add(transfer);
		add(inquiry);
		add(alterPW);
		add(exit);
	}
	
	/**
	 * 添加6个功能按钮的监听器：打开功能界面、退出程序
	 */
	public void listen(){
		draw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DateTimeThread(new DrawUI(info));
			}
		});
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DateTimeThread(new SaveUI(info));
			}
		});
		transfer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DateTimeThread(new TransferUI(info));
			}
		});
		alterPW.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DateTimeThread(new AlterPasswordUI(info));
			}
		});

		inquiry.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DateTimeThread(new InquiryUI(info));
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}

}
