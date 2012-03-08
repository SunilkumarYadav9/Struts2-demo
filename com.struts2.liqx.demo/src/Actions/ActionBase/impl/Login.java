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

	public String[] getBooks() {
		return books;
	}

	public void setBooks(String[] books) {
		this.books = books;
	}

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

	public String execute() throws Exception {
		log.debug(getPassword());
		log.debug(getUsername());
		HibernateUtil hbUtil = new HibernateUtil();
		Session sn =hbUtil.getSession();

		User user = UserDao.getUser(1);
		try {
			if (user.getUserName().equals("admin")
					&& user.getPwd().equals("admin")) {
				// put user name to the view
				ActionContext.getContext().getSession().put("user",
						getUsername());
				ActionContext.getContext().getSession()
						.put("books", getBooks());
				log.info("login");
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
