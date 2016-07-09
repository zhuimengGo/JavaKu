package DaoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pojo.House;
import Dao.IHouseDao;

public class HouseDao extends HibernateDaoSupport implements IHouseDao {

	@Override
	public List SelectAllHouse() {
		return getHibernateTemplate().find("from House");
	}
	 public List doSplitPage(final String hql,final int curPage,final int pageSize){
	        //调用模板的execute方法，参数是实现了HibernateCallback接口的匿名类，
	        return (List) super.getHibernateTemplate().execute(new HibernateCallback<Object>(){
	            //重写其doInHibernate方法返回一个object对象，
	            public Object doInHibernate(Session session)
	                    throws HibernateException, SQLException {
	                //创建query对象
	                Query query=session.createQuery(hql);
	                //返回其执行了分布方法的list
	                return query.setFirstResult((curPage-1)*pageSize).setMaxResults(pageSize).list();
	                 
	            }
	             
	        });
	         
	    }
	 @Override
		public List SelectAllStreet() {
			return getHibernateTemplate().find("from Street");
		}
	@Override
	public List SelectAllTypes() {
		return getHibernateTemplate().find("from Types");
	}
	@Override
	public List SelectAllDistrict() {
		return getHibernateTemplate().find("from District");
	}
	@Override
	public List SearchList(String title, String priceList,
			String hiddendistrict, String hiddenstreet, String hiddentypes,
			String floorage) {
		String Sql="from House h where 1=1";
		if (title!=null) {
			Sql+=" and h.title like '%"+title+"%'";
		}
		if (priceList!=null) {
			Sql+=" and h.price<"+priceList;
		}
		if (hiddendistrict!=null) {
			Sql+=" and h.street.district.name='"+hiddendistrict+"'";
		}
		if (hiddenstreet!=null) {
			Sql+=" and h.street.name='"+hiddenstreet+"'";
		}
		if (hiddentypes!=null) {
			Sql+=" and h.types.name='"+hiddentypes+"'";
		}
		if (floorage!=null) {
			Sql+=" and h.floorage<"+floorage;
		}
		return getHibernateTemplate().find(Sql);
	}
	@Override
	public void saveorupdate(House u) {
		getHibernateTemplate().saveOrUpdate(u);
	}
	@Override
	public void deleteHouse(House house) {
		getHibernateTemplate().delete(house);
	}
	
}
