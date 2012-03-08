package Actions.ActionBase.impl;

import helloworld.LoginAction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Actions.ActionBase.ActionBase;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Bean.User;
import Bean.UserDao.*;

@SuppressWarnings("serial")
public class Login implements ActionBase {

	private String username = "";
	private String password = "";
	private String[] books = new String[] { "1111", "2222", "3333" };
	private static Logger log = LoggerFactory.getLogger(Login.class);

	public String[] getBooks() {
		return books;
	}

	public void setBooks(String[] books) {
		this.books = books;
	}


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

	public String execute() throws Exception {
		log.debug(getPassword());
		log.debug(getUsername());
		HibernateUtil hbUtil = new HibernateUtil();
		Session sn =hbUtil.getSession();
		log.info("login");
		User user = UserDao.getUser(1);
		if(null != user){
			log.info("username{0},pwd={1}",user.getUserName(),user.getPwd());
		}else{log.info("no user.");System.out.println("null");}
		try {
			if (user.getUserName().equals("1")
					&& user.getPwd().equals("1")) {
				// put user name to the view
				ActionContext.getContext().getSession().put("user",
						getUsername());
				ActionContext.getContext().getSession()
						.put("books", getBooks());
				log.info("login");
				log.info("username{0},pwd={1}",user.getUserName(),user.getPwd());
				System.out.println("username="+user.getUserName()+"pwd="+user.getPwd());
				return SUCCESS;
			}
		} catch (HibernateException he) {
			log.info(he.getMessage());
			return ERROR;
		} finally {
			sn.close();
			return ERROR;
		}
	}

}
