package Bank;

import java.text.SimpleDateFormat;
import java.util.Date;

import UI.Interface.DateUI;

/**
 * 日期时间线程
 * @author overlord
 *
 */
public class DateTimeThread implements Runnable{
	/*
	 * 线程
	 * 带时间标签界面
	 * 日期时间读取格式
	 */
	Thread t;
	DateUI ui;
	private SimpleDateFormat ft=new SimpleDateFormat("yyyy'年'MM'月'dd'日' HH'时'mm'分'ss'秒'");

	/**
	 * 构造方法传入界面，新建并开始运行此线程
	 * @param ui	带时间标签界面
	 */
	public DateTimeThread(DateUI ui){
		this.ui=ui;
		t=new Thread(this,"Datetime");
		t.start();
	}
	/**
	 * 获取时间并传回界面，1秒执行一次
	 */
	@Override
	public void run() {
		try {
			while(true){
				String datetime=ft.format(new Date());
				ui.setDate(datetime);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
