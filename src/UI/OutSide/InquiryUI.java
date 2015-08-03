package UI.OutSide;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import UI.Interface.General_UI;

/**
 * 查询余额结果界面
 * @author overlord
 *
 */
public final class InquiryUI extends General_UI{
	JButton backup;
	public InquiryUI(String[] info) {
		super(info);
	}
	public void create(){
		super.create();
		setBounds(300, 200, 500, 400);
		setTitle("余额查询");
		JLabel title=new JLabel("余额查询");
		title.setFont(new Font("微软雅黑", 1, 24));
		title.setBounds(200, 40, 200, 30);
		add(title);
		date.setBounds(300, 0, 200, 20);
		
		Font f=new Font("微软雅黑", 0, 16);
		
		JLabel currenB=new JLabel("活期存款："+info[3]+" 元");
		currenB.setBounds(120, 120, 300, 20);
		add(currenB);
		
		JLabel fixedB=new JLabel("定期存款："+info[4]+" 元");
		fixedB.setBounds(120, 160, 300, 20);
		add(fixedB);
		
		backup=new JButton("返回主界面");
		backup.setBounds(70, 270, 350, 20);
		add(backup);
	}
	
	public void listen(){
		backup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openMainUI();
			}
		});
	}
}
