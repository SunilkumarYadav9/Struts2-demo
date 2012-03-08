package Bean.UserDao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Bean.UserDao.HibernateUtil;
import Bean.User;

/**
 * 文件名：UserDao.java All right Rserved liqx2012
 * 
 * @author 李青鑫 E-mail: lqx0830@hotmail.com
 * @version 1.0,创建时间：2012-3-7 上午11:17:44
 * @since jdk1.6 类说明
 */
public class UserDao {
    static HibernateUtil hbUtil = new HibernateUtil();
	public void addUser(User u) {
		Session s;
		Transaction t;
		s = hbUtil.getSession();
		t = s.getTransaction();
		try {
			s.save(u);
			t.commit();
		} catch (HibernateException e) {
			if (t != null)
				t.rollback();
		} finally {
			s.close();
		}
	}
	public static User getUser(int id){
		Session s = null;
		try{
			s = hbUtil.getSession();
			return (User)s.get(User.class, id);
		}finally{
			if(s!=null)
				s.close();
		}
	}
}
