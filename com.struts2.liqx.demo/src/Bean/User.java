package Bean;
/** 
 * 文件名：User.java
 * All right Rserved liqx2012
 * @author liqx  E-mail: lqx0830@hotmail.com
 * @version 1.0,创建时间：2012-3-6 下午03:01:53 
 * @since jdk1.6
 * 类说明 
 */
public class User {
	private int ID;//用来映射数据库表的主键
	private String userName;
	private String pwd;
	private String email;
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
 
