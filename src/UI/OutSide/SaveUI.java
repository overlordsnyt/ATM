package UI.OutSide;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Server.Surface.SaveMoney;
import UI.Interface.SmallWindow_UI;

/**
 * 存款界面
 * @author overlord
 *
 */
public final class SaveUI extends SmallWindow_UI{
	JTextField saveMoney;
	ButtonGroup type;
	JRadioButton type1,type2;

	/**
	 * 调用父类构造方法
	 * @param info	登录信息
	 */
	public SaveUI(String[] info) {
		super(info);
	}
	/**
	 * 创建存款界面
	 */
	public void create(){
		super.create();
		setTitle("存       款");
		title.setText("存       款");
		
		JLabel saveHint=new JLabel("请输入您要存的金额：");
		saveHint.setBounds(80, 150, 150, 20);
		add(saveHint);
		
		saveMoney=new JTextField();
		saveMoney.setBounds(230, 150, 150, 20);
		add(saveMoney);
		
		JLabel typeL=new JLabel("存款类型：");
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
		submit.addActionListener(new ActionListener() {
			/**
			 * 点击之后动作：
			 * 创建SaveMoney对象
			 * 弹出对话框提示，显示存款动作的执行情况
			 * 		点击弹出对话框的确定按钮：
			 * 			若成功，则返回主界面
			 * 			否则清空填写项
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SaveMoney save=new SaveMoney(info, saveMoney.getText(), selectedType());
				JOptionPane.showMessageDialog(getContentPane(), save.save());
				if(JOptionPane.OK_OPTION==0){
					if(save.getSituation()==2)
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
		saveMoney.setText("");
		type1.setSelected(true);
	}

}
