package Dao;

import java.util.List;

import pojo.House;


public interface IHouseDao {
	List SelectAllHouse();
	List doSplitPage(final String hql,final int curPage,final int pageSize);
	List SelectAllTypes();
	List SelectAllDistrict();
	List SelectAllStreet();
	List SearchList(String title,String priceList,String hiddendistrict,String hiddenstreet,String hiddentypes,String floorage );
	void  saveorupdate(House u);
	void deleteHouse(House house);
}
