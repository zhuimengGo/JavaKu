package ServiceImpl;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import pojo.District;
import pojo.House;
import pojo.Street;
import pojo.Types;
import Dao.IHouseDao;
import Service.IHouseService;


public class HouseService implements IHouseService {
	private IHouseDao hd;
	@Override
	public List SelectAllHouse() {
		// TODO Auto-generated method stub
		return hd.SelectAllHouse();
	}
	@Override
	public List doSplitPage(String hql, int curPage, int pageSize) {
		// TODO Auto-generated method stub
		return hd.doSplitPage(hql, curPage, pageSize);
	}

	@Override
	public List SelectAllTypes() {
		return hd.SelectAllTypes();
	}
	@Override
	public List SelectAllDistrict() {
		// TODO Auto-generated method stub
		return hd.SelectAllDistrict();
	}
	@Override
	public List SelectAllStreet() {
		return hd.SelectAllStreet();
	}
	@Override
	public List SearchList(String title, String priceList,
			String hiddendistrict, String hiddenstreet, String hiddentypes,
			String floorage) {
		String titleSql=null;
		String priceListSql=null;
		String hiddendistrictSql=null;
		String hiddenstreetSql=null;
		String hiddentypesSql=null;
		String floorageSql=null;
		if(title!=null&&!title.equals("")){
			titleSql=title;
		}
		if(priceList!=null&&!priceList.equals("0")){
			int p=(Integer.valueOf(priceList))*1000;
			priceListSql=String.valueOf(p);
		}
		if(hiddendistrict!=null&&!hiddendistrict.equals("0")){
			List<District> list=(List<District>) ServletActionContext.getRequest().getSession().getAttribute("Districts");
			District d=list.get(Integer.valueOf(hiddendistrict)-1);
			hiddendistrictSql=d.getName();
		}
		if(hiddenstreet!=null&&!hiddenstreet.equals("0")){
			List<Street> list=(List<Street>) ServletActionContext.getRequest().getSession().getAttribute("Streets");
			Street s=list.get(Integer.valueOf(hiddenstreet)-1);
			hiddenstreetSql=s.getName();
		}
		if(hiddentypes!=null&&!hiddentypes.equals("0")){
			List<Types> list=(List<Types>) ServletActionContext.getRequest().getSession().getAttribute("Types");
			Types t=list.get(Integer.valueOf(hiddentypes)-1);
			hiddentypesSql=t.getName();
		}
		if(floorage!=null&&!floorage.equals("0")){
			int s=(Integer.valueOf(floorage))*100;
			floorageSql=String.valueOf(s);
		}
		return hd.SearchList(titleSql, priceListSql, hiddendistrictSql, hiddenstreetSql, hiddentypesSql, floorageSql);
	}
	@Override
	public void saveorupdate(House u) {
		hd.saveorupdate(u);
	}
	@Override
	public void deleteHouse(House house) {
		hd.deleteHouse(house);
	}
	public IHouseDao getHd() {
		return hd;
	}
	public void setHd(IHouseDao hd) {
		this.hd = hd;
	}
}
