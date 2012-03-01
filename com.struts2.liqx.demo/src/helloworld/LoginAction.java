package helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String username="";
	private String password="";
	private static Logger log = LoggerFactory.getLogger(LoginAction.class);
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
   public String execute(){
	   log.debug(getPassword());
	   log.debug(getUsername());
	   if(getUsername().equals("admin") && getPassword().equals("admin")){
		   return SUCCESS;
	   }else{
		   return ERROR;
	   }
   }
}
