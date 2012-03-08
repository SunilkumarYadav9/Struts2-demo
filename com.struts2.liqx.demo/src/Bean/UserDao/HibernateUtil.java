/**
 * 
 *Copyright {year} whut,All right Reservered
 *@version 1.0,2012-2012-3-7
 *@author  ÀîÇàöÎ
 *@since jdk1.6
 */
package Bean.UserDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Bean.User;

/**
 * 文件名：UserDao.java All right Rserved liqx2012
 * 
 * @author 李青鑫 E-mail: lqx0830@hotmail.com
 * @version 1.0,创建时间：2012-3-7 上午10:42:58
 * @since jdk1.6 类说明
 */

public class HibernateUtil {
	private static Configuration cf;
	private static SessionFactory sf;

	public HibernateUtil() {
		cf = new Configuration();
		sf = cf.configure().buildSessionFactory();
	}

	public SessionFactory getSessionFactory() {
		return sf;
	}

	public Session getSession() {
		return sf.openSession();
	}

	public void save(User user) {
	}
}
