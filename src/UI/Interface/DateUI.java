package UI.Interface;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 带日期时间界面
 * @author overlord
 *
 */
public class DateUI extends JFrame{
	//显示日期时间标签
	public JLabel date;
	
	/**
	 * 添加一个时间标签
	 */
	public void create(){
		date=new JLabel("aaaaaaaaa");
		add(date);
	}

	/**
	 * 设置date的显示内容
	 * @param s	传入显示内容
	 */
	public void setDate(String s) {
		date.setText(s);
	}
}
