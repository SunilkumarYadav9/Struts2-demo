package Actions.ActionBase.impl;

import helloworld.LoginAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Actions.ActionBase.ActionBase;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Login  implements ActionBase  {

	private String username="";
	private String password="";
	private static Logger log = LoggerFactory.getLogger(Login.class);
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
   public String execute() throws Exception{
	   log.debug(getPassword());
	   log.debug(getUsername());
	   if(getUsername().equals("admin") && getPassword().equals("admin")){
		   //put user name to the view
		   ActionContext.getContext().getSession().put("user",getUsername());
		   return SUCCESS;
	   }else{
		   return ERROR;
	   }
   }

}
