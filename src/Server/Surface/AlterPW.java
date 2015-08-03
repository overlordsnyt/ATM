package Server.Surface;

import java.util.regex.Pattern;

import Database.DBUtil;

/**
 * 修改密码功能
 * @author overlord
 *
 */
public class AlterPW {
	/*
	 * 登录信息
	 * 原密码，新密码1，新密码2
	 * 执行情况
	 */
	private String[] info;
	private String old,new1,new2;
	private byte situation=0;
	/**
	 * 无参构造方法
	 */
	public AlterPW(){
	}
	/**
	 * 构造方法获取输入，并保存为属性
	 * @param info	登录信息
	 * @param old	原密码
	 * @param new1	新密码1
	 * @param new2	新密码2
	 */
	public AlterPW(String[] info, char[] old, char[] new1, char[] new2) {
		this.info = info;
		this.old = new String(old);
		this.new1 = new String(new1);
		this.new2 = new String(new2);
	}

	/**
	 * 执行修改密码操作，给执行情况赋值，并返回提示内容
	 * @return	弹出提示内容
	 */
	public String alter(){
		if(!old.equals(info[2])){
			situation=1;
			return "原密码输入错误，请重新输入！";
		}
		if(!judgeLegal(new1)){
			situation=2;
			return "只允许3到16位的纯数字密码，请重新输入！";
		}
		if(!new1.equals(new2)){
			situation=3;
			return "你输入的两次新密码不一致，请重新输入！";
		}
		String sql="update account set password='"+new1+"' where account_Id="+info[0]+";";
		DBUtil db=new DBUtil();
		int upLine=db.intExecute(sql);
		db.close();
		if(upLine==1){
			situation=4;
			return "密码修改成功！";
		}
		return "密码修改失败";
	}


	/**
	 * 判断密码的合法性
	 * @param pw	输入的密码
	 * @return	是否合法
	 */
	public boolean judgeLegal(String pw){
		String reg="^\\d{3,16}$";
		return Pattern.matches(reg, pw);
	}
	/**
	 * 获取操作情况
	 * @return	操作情况
	 */
	public byte getSituation(){
		return situation;
	}
}
