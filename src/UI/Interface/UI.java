package UI.Interface;

import java.awt.Color;

/**
 * UI界面的接口
 * 标准：
 * 常量颜色c
 * 创建界面的方法，界面元素的监听器，关闭窗口按钮的监听器
 * @author overlord
 *
 */
public interface UI{
	Color c=new Color(0xF6F7EB);
	void create();
	void listen();
	void closeWindow();
	void openMainUI();
}
