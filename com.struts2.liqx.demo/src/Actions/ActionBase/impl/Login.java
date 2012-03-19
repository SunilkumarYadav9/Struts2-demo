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
/**
 * 用户登录验证：采用hibernate 与数据库交互，当用户输入信息正确（数据库中存在该用户）则返回SUCCESS，否则返回ERROR。
 */
	public String execute() throws Exception {
		HibernateUtil hbUtil = new HibernateUtil();
		Session sn = hbUtil.getSession();
		log.debug("*************************************************");
		User user = null;
		try {
			user = UserDao.getUser(1);
		} catch (HibernateException he) {
			log.info(he.getMessage());
		} finally {
			sn.close();
		}
		if (user.getUserName().equals("admin") && user.getPwd().equals("admin")) {
			// put user name to the view
			ActionContext.getContext().getSession().put("user",
					user.getUserName());
			ActionContext.getContext().getSession().put("books", getBooks());
			log.debug("username={},pwd={}", user.getUserName(), user.getPwd());
			System.out.println("username=" + user.getUserName() + " pwd="
					+ user.getPwd());
			return SUCCESS;
		} else {
			log.debug("illegal account or password.\n");
			return ERROR;
		}
	}

}
