package Server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import Database.DBUtil;

/**
 * 登录功能
 * @author overlord
 *
 */
public class Login {
	/*
	 * 卡号，密码
	 * 登录次数的计数器，执行情况代号
	 */
	String account, password;
	byte count, situation = 0;
	public Login(String account, char[] password, byte count) {
		this.account = account;
		this.password = new String(password);
		this.count = count;
	}

	public Login() {
	}

	/**
	 * 判断登录是否成功
	 * @return	是否成功
	 */
	private boolean judgeSuccess() {
		boolean bol = false;
		if(!Pattern.matches("^\\d+$", account))
			return bol;
		String sql = "select * from account where account=" + account
				+ " and password=" + password + ";";
		DBUtil db = new DBUtil();
		ResultSet rs = db.rsExecute(sql);
		try {
			if (rs.next())
				bol = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close();
		return bol;
	}
	
	public boolean judgeSuccess(String account){
		boolean bol = false;
		if(!Pattern.matches("^\\d+$", account))
			return bol;
		String sql = "select * from account where account=" + account+";";
		DBUtil db = new DBUtil();
		ResultSet rs = db.rsExecute(sql);
		try {
			if (rs.next())
				bol = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close();
		return bol;
	}

	/**
	 * 得到弹出提示框要显示的内容
	 * @return	提示框内容
	 */
	public String showMessage() {
		if (judgeSuccess()) {
			situation = 1;
			return "登录成功";
		}
		if (count == 3) {
			situation = 2;
			return "错误3次，自动退出程序";
		}
		return "登录信息有误，请重新输入";
	}

	/**
	 * 获取执行情况代号
	 * @return	执行情况
	 */
	public byte getSituation() {
		return situation;
	}

}
