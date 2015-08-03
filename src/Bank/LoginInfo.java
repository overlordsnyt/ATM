package Bank;

import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DBUtil;

/**
 * 根据登录输入，获取账户信息
 * @author overlord
 *
 */
public class LoginInfo {
	/*
	 * 查询结果类型的账户信息
	 * 保存账户信息的字符串数组
	 */
	private ResultSet rs;
	private String[] s;
	
	/**
	 * 无参构造方法
	 */
	public LoginInfo(){
	}
	/**
	 * 构造方法连接数据库并得到账户基本信息保存为字符串数组，之后关闭数据库连接
	 * @param account	卡号
	 */
	public LoginInfo(String account){
		DBUtil db=new DBUtil();
		String sql="select a.account_Id,account,password,current_balance,fixed_balance,name,sex from account as a inner join person_info as p"
				+ " on a.account_Id=p.account_ID where a.account="+account+";";
		rs=db.rsExecute(sql);
		s=new String[7];
		try {
			rs.next();
			for(int i=0;i<7;i++)
				s[i]=rs.getString(i+1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		s=knowSex(s);
		db.close();
	}
	/**
	 * 获取账户信息
	 * @param account_ID	账户的内部ID
	 * @return info		账户信息
	 */
	public String[] getInfo(String account_ID){
		String[] info=new String[7];
		DBUtil db=new DBUtil();
		String sql="select a.account_Id,account,password,current_balance,fixed_balance,name,sex from account as a inner join person_info as p"
				+ " on a.account_Id=p.account_ID where a.account_Id="+account_ID+";";
		rs=db.rsExecute(sql);
		try {
			rs.next();
			for(int i=0;i<7;i++)
				info[i]=rs.getString(i+1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		info=knowSex(info);
		db.close();
		return info;
	}
	/**
	 * 信息分别为：
	 * [账户ID，卡号，密码，活期存款，定期存款，姓名，性别]
	 * @return	保存信息的字符串数组
	 */
	public String[] getInfo(){
		return s;
	}
	/**
	 * 识别用数字储存的性别信息
	 */
	private String[] knowSex(String[] info){
		if(info[6].equals("1"))
			info[6]="先生";
		else info[6]="女士";
		return info;
	}
}
