package Server.Surface;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import Database.DBUtil;

/**
 * 存款功能
 * @author overlord
 *
 */
public class SaveMoney {
	/*
	 * 登录信息
	 * 存款类型，操作情况
	 * 存款金额
	 */
	private String[] info;
	private byte type,situation=0;
	private String money;
	
	/**
	 * 构造方法
	 * @param info	登录信息
	 * @param money	存款金额
	 * @param knowType	存款类型
	 */
	public SaveMoney(String[] info,String money,byte knowType){
		this.info=info;
		type=knowType;
		this.money=money;
	}

	public String save(){
		if(!judgeLegal()){
			situation=1;
			return "存款金额只能是100的整数倍！";
		}
		BigDecimal money=new BigDecimal(this.money);
		BigDecimal balance=new BigDecimal(info[typeIndex()]).add(money);
		String sql="update account set "+typeSQL()+"="+balance+" where account_Id="+info[0]+";";
		DBUtil db=new DBUtil();
		int upLine=db.intExecute(sql);
		db.close();
		if(upLine>0){
			situation=2;
			return "成功存入"+typeString()+"存款 "+this.money+" 元";
		}
		return "存款失败！";
	}
	
	
	

	/**
	 * 获取操作情况
	 * @return	操作情况
	 */
	public byte getSituation(){
		return situation;
	}
	
	/**
	 * 判断输入金额的合法性
	 * @return	判断结果
	 */
	private boolean judgeLegal(){
		String reg="^[1-9][0-9]*0{2}$";
		return Pattern.matches(reg, money);
	}
	
	/**
	 * 返回在登录信息中，存款类型的下标
	 * @return	类型下标
	 */
	private int typeIndex(){
		int index=3;
		if(type==1)
			index=4;
		return index;
	}
	/**
	 * 返回在数据库中，存款类型的列名
	 * @return	类型列名
	 */
	private String typeSQL(){
		String type="current_balance";
		if(this.type==1)
			type="fixed_balance";
		return type;
	}
	/**
	 * 返回存款类型的名称
	 * @return	类型名称
	 */
	private String typeString(){
		String type="活期";
		if(this.type==1)
			type="定期";
		return type;
	}

}
