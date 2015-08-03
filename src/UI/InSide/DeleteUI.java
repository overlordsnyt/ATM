package UI.InSide;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Server.Interior.Delete;
import UI.Interface.SmallAdmin_UI;

/**
 * 后台销户界面
 * @author overlord
 *
 */
public final class DeleteUI extends SmallAdmin_UI{
	//卡号1，卡号2
	JTextField account1,account2;
	
	/**
	 * 调用父类构造方法
	 */
	public DeleteUI(){
		super();
	}
	
	/**
	 * 创建销户界面
	 */
	public void create(){
		super.create();
		String ti="销      户";
		setTitle(ti);
		title.setText(ti);
		
		JLabel acl1=new JLabel("请输入要注销的账户：");
		JLabel acl2=new JLabel("请再次输入注销账户：");
		acl1.setBounds(80, 150, 130, 20);
		acl2.setBounds(80, 190, 130, 20);
		add(acl1);
		add(acl2);
		
		account1=new JTextField();
		account2=new JTextField();
		account1.setBounds(220, 150, 200, 20);
		account2.setBounds(220, 190, 200, 20);
		add(account1);
		add(account2);
	}
	
	/**
	 * 添加确认按钮监听器
	 */
	public void listen(){
		submit.addActionListener(new ActionListener() {
			/**
			 * 建立后台删除对象
			 * 弹出对话框，调用删除对象的方法获得提示信息
			 * 点击确认按钮：成功则返回后台管理主界面，否则清空填写项
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				Delete delete=new Delete(account1.getText(), account2.getText());
				JOptionPane.showMessageDialog(getContentPane(), delete.delete());
				if(JOptionPane.OK_OPTION==0){
					if(delete.getSituation()==4)
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
	}
}
