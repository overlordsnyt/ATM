package UI.OutSide;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Server.Surface.Transfer;
import UI.Interface.SmallWindow_UI;

/**
 * 转账业务界面
 * @author overlord
 *
 */
public final class TransferUI extends SmallWindow_UI{
	/*
	 * 输入框：卡号1，卡号2，金额
	 * 提示标签1、2
	 */
	JTextField account1,account2,money;
	JLabel alert1,alert2;
	
	/**
	 * 调用父类构造方法
	 * @param info	账户信息
	 */
	public TransferUI(String[] info) {
		super(info);
	}
	/**
	 * 创建转账界面
	 */
	public void create(){
		super.create();
		setTitle("转账业务");
		title.setText("转账业务");
		
		JLabel hint1=new JLabel("请输入要转入的卡号：");
		JLabel hint2=new JLabel("请再次确认转入卡号：");
		JLabel hint3=new JLabel("请输入您要转账的金额：");
		hint1.setBounds(80, 130, 130, 20);
		hint2.setBounds(80, 170, 130, 20);
		hint3.setBounds(66, 210, 150, 20);
		add(hint1);
		add(hint2);
		add(hint3);
		
		account1=new JTextField();
		account2=new JTextField();
		money=new JTextField();
		account1.setBounds(210, 130, 210, 20);
		account2.setBounds(210, 170, 210, 20);
		money.setBounds(210, 210, 210, 20);
		add(account1);
		add(account2);
		add(money);
		
		alert1=new JLabel();
		alert1.setForeground(Color.red);
		alert1.setBounds(430, 130, 70, 20);
		add(alert1);
		
		alert2=new JLabel();
		alert2.setForeground(Color.red);
		alert2.setBounds(430, 170, 70, 20);
		add(alert2);
	}
	/**
	 * 添加界面元素监听器
	 */
	public void listen(){
		/**
		 * 对输入框卡号1添加焦点监听器：
		 * 失焦则判断是否存在卡号1的账户；聚焦则清除标签提示
		 */
		account1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(!new Transfer(account1.getText()).judgeAccountExist())
					alert1.setText("账户不存在");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				alert1.setText("");
			}
		});

		/**
		 * 对输入框卡号2添加焦点监听器：
		 * 失焦则判断两次卡号输入是否相同；聚焦则清除标签提示
		 */
		account2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(!account2.getText().equals(account1.getText()))
					alert2.setText("输入不一致");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				alert2.setText("");
			}
		});
		/**
		 * 添加确认按钮监听器：
		 * 点击则弹出提示框，告知操作执行情况：
		 * 成功则打开主界面，否则清空填写
		 */
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Transfer trans=new Transfer(info, account1.getText(), account2.getText(), money.getText());
				JOptionPane.showMessageDialog(getContentPane(), trans.transfer());
				if(JOptionPane.OK_OPTION==0){
					if(trans.getSituation()==5)
						openMainUI();
					else clear();
				}
			}
		});
	}
	
	/**
	 * 清空填写项
	 */
	private void clear(){
		account1.setText("");
		account2.setText("");
		money.setText("");
		alert1.setText("");
		alert2.setText("");
	}

}
