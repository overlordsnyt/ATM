package Server.Interior;

import java.util.regex.Pattern;

import Bank.LoginInfo;
import Database.DBUtil;
import Server.Login;

public class Delete {
	//第一次卡号，第二次卡号
	String account1,account2;
	//执行情况代号
	byte situation;

	/**
	 * 构造方法传入卡号
	 * @param account1	第一次卡号
	 * @param account2	第二次卡号
	 */
	public Delete(String account1, String account2) {
		this.account1 = account1;
		this.account2 = account2;
	}
	/**
	 * 执行删除，给执行情况代码赋值，返回弹出框内容
	 * @return	弹出框内容
	 */
	public String delete(){
		if(!Pattern.matches("^\\d+$",account1)){
			situation=1;
			return "你输入的卡号不合法，请重新输入！";
		}
		if(!account1.equals(account2)){
			situation=2;
			return "你两次输入的卡号不一致，请重新输入！";
		}
		if(!new Login().judgeSuccess(account1)){
			situation=3;
			return "你输入的卡号无此账户，请重新输入！";
		}
		String[] info=new LoginInfo(account1).getInfo();
		DBUtil db=new DBUtil();
		String sql1="delete from account where account_Id="+info[0]+";";
		String sql2="delete from person_info where account_ID="+info[0]+";";
		int upLine=db.intExecute(sql1);
		upLine=upLine+db.intExecute(sql2);
		db.close();
		if(upLine==2){
			situation=4;
			return "删除卡号为"+account1+"的账户成功！";
		}
		return "销户失败！";
	}
	/**
	 * 获取执行情况代码
	 * @return	执行情况
	 */
	public byte getSituation(){
		return situation;
	}

}
