package DaoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pojo.House;
import Dao.IHouseDao;

public class HouseDaoQBC extends HibernateDaoSupport implements IHouseDao{
	@Override
	public List SelectAllHouse() {
		DetachedCriteria dc=DetachedCriteria.forClass(House.class);
		List list=getHibernateTemplate().findByCriteria(dc);
		return null;
	}

	@Override
	public List doSplitPage(String hql, int curPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List SelectAllTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List SelectAllDistrict() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List SelectAllStreet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List SearchList(String title, String priceList,
			String hiddendistrict, String hiddenstreet, String hiddentypes,
			String floorage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveorupdate(House u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHouse(House house) {
		// TODO Auto-generated method stub
		
	}

}
