package UI.OutSide;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Server.Surface.DrawMoney;
import UI.Interface.SmallWindow_UI;

/**
 * 提取现金功能的界面
 * @author overlord
 *
 */
public final class DrawUI extends SmallWindow_UI{
	/*
	 * 金额输入框
	 * 单选按钮组
	 * 类型单选按钮1、2
	 */
	JTextField drawMoney;
	ButtonGroup type;
	JRadioButton type1,type2;
	/**
	 * 读取父类构造方法
	 * @param info	登录信息
	 */
	public DrawUI(String[] info){
		super(info);
	}
	/**
	 * 创建取款界面
	 */
	public void create(){
		super.create();
		setTitle("提取现金");
		
		title.setText("提取现金");
		
		JLabel drawhint=new JLabel("请输入您要取的金额：");
		drawhint.setBounds(80, 150, 150, 20);
		add(drawhint);
		
		drawMoney=new JTextField();
		drawMoney.setBounds(230, 150, 150, 20);
		add(drawMoney);
		
		JLabel typeL=new JLabel("取款类型：");
		typeL.setBounds(80, 190, 80, 20);
		add(typeL);
		
		type=new ButtonGroup();
		type1=new JRadioButton("活期", true);
		type.add(type1);
		type2=new JRadioButton("定期", false);
		type.add(type2);
		
		type1.setBounds(230, 190, 80, 20);
		type2.setBounds(310, 190, 70, 20);
		add(type1);
		add(type2);
	}
	
	/**
	 * 提交按钮的监听器
	 */
	public void listen(){
		/**
		 * 点击之后动作：
		 * 创建DrawMoney对象
		 * 弹出对话框提示，显示取款动作的执行情况
		 * 		点击弹出对话框的确定按钮：
		 * 			若成功，则返回主界面
		 * 			否则清空填写项
		 */
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DrawMoney draw=new DrawMoney(info, drawMoney.getText(), selectedType());
				JOptionPane.showMessageDialog(getContentPane(), draw.draw());
				if(JOptionPane.OK_OPTION==0){
					if(draw.getSituation()==2)
						openMainUI();
					else clear();
				}
			}
		});
	}
	/**
	 * 以数字形式返回存款类型的选择
	 * @return	数字表示的存款类型
	 */
	private byte selectedType(){
		byte knowType=0;
		if(type2.isSelected())
			knowType=1;
		return knowType;
	}
	/**
	 * 清空填写项
	 */
	private void clear(){
		drawMoney.setText("");
		type1.setSelected(true);
	}
}
