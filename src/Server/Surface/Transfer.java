package Server.Surface;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.regex.Pattern;

import Bank.LoginInfo;
import Database.DBUtil;

/**
 * 转账功能
 * @author overlord
 *
 */
public class Transfer {
	/*
	 * 当前账户信息
	 * 输入转入账户卡号1，卡号2，转账金额
	 * 执行情况
	 */
	String[] info;
	String account1,account2,money;
	byte situation=0;
	/**
	 * 带一个卡号传入的构造方法
	 * @param account1	转入的账户卡号
	 */
	public Transfer(String account1){
		this.account1=account1;
	}
	/**
	 * 完整获取输入的构造方法
	 * @param info	当前账户信息
	 * @param account1	目标卡号1
	 * @param account2	目标卡号2
	 * @param money		转账金额
	 */
	public Transfer(String[] info, String account1, String account2,String money) {
		this.info = info;
		this.account1 = account1;
		this.account2 = account2;
		this.money = money;
	}
	/**
	 * 执行转账操作，给相应情况赋值，并返回提示
	 * @return	弹出提示内容
	 */
	public String transfer(){
		if(!judgeAccountExist()){
			situation=1;
			return "你输入的卡号账户不存在，请重新输入！";
		}
		if(!account2.equals(account1)){
			situation=2;
			return "你输入的转账目标卡号不一致，请重新输入！";
		}
		if(!judgeInputMoney()){
			situation=3;
			return "你输入的金额格式错误，只允许输入两位小数以内的数字！";
		}
		BigDecimal money=new BigDecimal(this.money);
		BigDecimal balance=new BigDecimal(info[3]).subtract(money);
		if(balance.signum()==-1){
			situation=4;
			return "账户活期存款不足，请重新填写！";
		}
		if(accountOut(balance)&&accountIn(money)){
			situation=5;
			return "转账成功！";
		}
		return "转账失败！";
	}
	/**
	 * 在转出账户执行数据库变更
	 * @param balance	转出后的余额
	 * @return	是否执行
	 */
	private boolean accountOut(BigDecimal balance){
		boolean bol=false;
		DBUtil db=new DBUtil();
		String sql="update account set current_balance="+balance+" where "
				+ "account_Id="+info[0]+";";
		int upLine=db.intExecute(sql);
		db.close();
		if(upLine==1)
			bol=true;
		return bol;
	}
	/**
	 * 在转入账户执行数据库变更
	 * @param money	转入的金额
	 * @return	是否执行
	 */
	private boolean accountIn(BigDecimal money){
		boolean bol=false;
		String[] info=new LoginInfo(account1).getInfo();
		BigDecimal balance=new BigDecimal(info[3]).add(money);
		DBUtil db=new DBUtil();
		String sql="update account set current_balance="+balance+" where "
				+ "account_Id="+info[0]+";";
		int upLine=db.intExecute(sql);
		db.close();
		if(upLine==1)
			bol=true;
		return bol;
	}
	
	/**
	 * 获取执行情况
	 * @return	执行情况的数字代码
	 */
	public byte getSituation(){
		return situation;
	}
	/**
	 * 判断金钱输入是否合法
	 * @return	是否合法
	 */
	public boolean judgeInputMoney(){
		String reg="^([1-9]+\\d*)?([1-9]+\\d*\\.\\d{1,2})?(0\\.\\d{1,2})?$";
		return Pattern.matches(reg, money);
	}
	/**
	 * 判断输入的账户卡号1是否存在
	 * @return	是否存在
	 */
	public boolean judgeAccountExist(){
		boolean bol=false;
		String sql="select * from account where account='"+account1+"';";
		DBUtil db=new DBUtil();
		try {
			if(db.rsExecute(sql).next())
				bol=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close();
		return bol;
	}
}
