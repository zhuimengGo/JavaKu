package DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pojo.Users;
import Dao.IUsersDao;

public class UserDao extends HibernateDaoSupport implements IUsersDao{
	Users user=new Users();
	@Override
	public void saveUser(Users u) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(u);
	}
	public Users findByName(String i) {
		List<Users> list=findByProperty("name", i);
		if (list.size()==0) {
			return user;
		}else{
			return list.get(0);
		}
	}
	public List findByProperty(String propertyName, Object value) {
			String queryString = "from Users as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
	}
	@Override
	public void saveorupdate(Users u) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(u);
	}
}
