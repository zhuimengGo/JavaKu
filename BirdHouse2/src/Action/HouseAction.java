package Action;



import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import pojo.District;
import pojo.House;
import pojo.Street;
import pojo.Types;
import pojo.Users;
import DaoImpl.HouseDaoQBC;
import Service.IHouseService;

import com.opensymphony.xwork2.ActionSupport;

public class HouseAction extends ActionSupport{
	private IHouseService houseService;
	private String priceList;
	private String hiddendistrict;
	private String hiddenstreet;
	private String hiddentypes;
	private String floorage;
	private String title;
	private String search;
	private String fabu_di;
	private String type_id;
	private String price;
	private String houseDate;
	private String street_id;
	private String contact;
	private String description;
	private String delhouseid;
	private String updhouseid;
	private String hid;
	@Override
	public String execute() throws Exception {
		return "SUCCESS";
	}
	public String fabu(){
		String moshi=null;
		moshi=ServletActionContext.getRequest().getParameter("moshi");
		int ms=0;
		if (moshi!=null) {
			ms=Integer.valueOf(moshi);
		}
		if (ms==0) {
			ServletActionContext.getRequest().getSession().removeAttribute("hid");
		}
		List<District> Districts=houseService.SelectAllDistrict();
		List<Types> Types=houseService.SelectAllTypes();
		ServletActionContext.getRequest().getSession().setAttribute("Types", Types);
		ServletActionContext.getRequest().getSession().setAttribute("Districts", Districts);
		return "SUCCESS";
	}
	public String showFang(){
		List<Types> Types=houseService.SelectAllTypes();
		List<District> Districts=houseService.SelectAllDistrict();
		ServletActionContext.getRequest().getSession().setAttribute("Districts", Districts);
		String string=ServletActionContext.getRequest().getParameter("curPage");
		Integer curPage=null;
		if (string!=null) {
			curPage=Integer.valueOf(string);
		}
		
		List<House> list=(List<House>) ServletActionContext.getRequest().getSession().getAttribute("listShow");
		List<House> listShow=null;
		List<House> listAll=null;
		int count=0;
		if (list==null) {
			if (curPage==null) {
				curPage=1;
			}
			listShow=houseService.doSplitPage("from House", curPage, 5);
			ServletActionContext.getRequest().getSession().setAttribute("listShow", listShow);
			listAll=houseService.SelectAllHouse();
			count=listAll.size()/5+1;
			if (curPage==null||curPage<1) {
				curPage=1;
			}else if(curPage>count){
				curPage=count;
			}
		}else{
			if (ServletActionContext.getRequest().getSession().getAttribute("showtype")!=null) {
				if (curPage==null||curPage<1) {
					curPage=1;
				}else if(curPage>count){
					curPage=count;
				}
				listAll=(List<House>) ServletActionContext.getRequest().getSession().getAttribute("listShow");
				count=listAll.size()/5+1;
				ServletActionContext.getRequest().getSession().setAttribute("listShow", listAll);
				ServletActionContext.getRequest().getSession().removeAttribute("showtype");
			}else{
				listAll=houseService.SelectAllHouse();
				count=listAll.size()/5+1;
				if (curPage==null||curPage<1) {
					curPage=1;
				}else if(curPage>count){
					curPage=count;
				}
				listShow=houseService.doSplitPage("from House", curPage, 5);
				ServletActionContext.getRequest().getSession().setAttribute("listShow", listShow);
				count=list.size()/5+1;
			}
			
		}
		ServletActionContext.getRequest().getSession().setAttribute("Types", Types);
		ServletActionContext.getRequest().getSession().setAttribute("Districts", Districts);
		ServletActionContext.getRequest().getSession().setAttribute("count",count);
		ServletActionContext.getRequest().getSession().setAttribute("curPage", curPage);
		return "SUCCESS";
	}
	public String search(){
		ServletActionContext.getRequest().getSession().setAttribute("showtype",1 );
		ServletActionContext.getRequest().getSession().setAttribute("title",title );
		ServletActionContext.getRequest().getSession().setAttribute("priceIndex",priceList );
		ServletActionContext.getRequest().getSession().setAttribute("hiddendistrict", hiddendistrict);
		ServletActionContext.getRequest().getSession().setAttribute("hiddenstreet", hiddenstreet);
		ServletActionContext.getRequest().getSession().setAttribute("hiddentypes", hiddentypes);
		ServletActionContext.getRequest().getSession().setAttribute("floorage", floorage);
		List<District> Districts=(List<District>) ServletActionContext.getRequest().getSession().getAttribute("Districts");
		List<Street> Streets=new ArrayList<Street>();
		if (hiddendistrict.equals("0")) {
			
		}else{
		District d=Districts.get(Integer.valueOf(hiddendistrict)-1);
		List<Street> list=houseService.SelectAllStreet();
		for (Street street : list) {
			if (street.getDistrict().getId().toString().equals(d.getId().toString())) {
				Streets.add(street);
			}
		}}
		ServletActionContext.getRequest().getSession().setAttribute("Streets", Streets);
		List<House> listShow=houseService.SearchList(title, priceList, hiddendistrict, hiddenstreet, hiddentypes, floorage);
		ServletActionContext.getRequest().getSession().setAttribute("listShow", listShow);
		return "SUCCESS";
	}
	public String guanli(){
		House hs=new House();
		ServletActionContext.getRequest().getSession().setAttribute("hs", hs);
		List<House> list=houseService.SelectAllHouse();
		int uid=(Integer) ServletActionContext.getRequest().getSession().getAttribute("UserId");
		List<House> listShow=new ArrayList<House>();
		for (House house : list) {
			if (house.getUsers().getId()==uid) {
				listShow.add(house);
			}
		}
		ServletActionContext.getRequest().getSession().setAttribute("listShow", listShow);
		return "SUCCESS";
	}
	public String getstreet() throws IOException{
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		List<District> Districts=(List<District>) ServletActionContext.getRequest().getSession().getAttribute("Districts");
		District d=Districts.get(Integer.valueOf(fabu_di)-1);
		List<Street> list=houseService.SelectAllStreet();
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		for (Street street : list) {
			if (street.getDistrict().getId().toString().equals(d.getId().toString())) {
				out.print("<OPTION selected value="+street.getId()+">"+street.getName()+"</OPTION>");
			}
		}
		return null;
	}
	public String addorupdateHouse() throws ParseException{
		Integer uid=(Integer) ServletActionContext.getRequest().getSession().getAttribute("UserId");
		House h=new House();
		String hid=null;
		Object o=ServletActionContext.getRequest().getSession().getAttribute("hid");
		if (o!=null&&!o.equals("")) {
			h.setId((Integer)o);
		}
		Users u=new Users();
		u.setId(uid);
		h.setUsers(u);
		h.setTitle(title);
		Types t=new Types();
		t.setId(Integer.valueOf(type_id));
		h.setTypes(t);
		h.setFloorage(Integer.valueOf(floorage));
		h.setPrice(Integer.valueOf(price));
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		Date d=sim.parse(houseDate);
		h.setPubdate(d);
		Street s=new Street();
		s.setId(Integer.valueOf(street_id));
		h.setStreet(s);
		h.setContact(contact);
		h.setDescription(description);
		houseService.saveorupdate(h);
		return "SUCCESS";
	}
	public String delHouse(){
		House h=new House();
		h.setId(Integer.valueOf(delhouseid));
		houseService.deleteHouse(h);
		return null;
	}
	public String updHouse(){
		List<House> list=(List<House>) ServletActionContext.getRequest().getSession().getAttribute("listShow");
		House hs=new House();
		String typeindex=null;
		House house=new House();
		for (int i=0;i<list.size();i++) {
			house=list.get(i);
			if(house.getId().toString().equals(Integer.valueOf(updhouseid).toString())){
				hs=house;
				ServletActionContext.getRequest().getSession().setAttribute("typeid", i);
			}
		}
		List<District> Districts=houseService.SelectAllDistrict();
		for (int i = 0; i < Districts.size(); i++) {
			District s=Districts.get(i);
			if(s.getId().toString().equals(hs.getStreet().getDistrict().getId().toString())){
				System.out.println(i);
				ServletActionContext.getRequest().getSession().setAttribute("districtid", (i+1));
			}
		}
		List<Street> Streets=houseService.SelectAllStreet();
		for (int i = 0; i < Streets.size(); i++) {
			Street s=Streets.get(i);
			if(s.getId().toString().equals(hs.getStreet().getId().toString())){
				ServletActionContext.getRequest().getSession().setAttribute("streetsid", i);
			}
		}
		ServletActionContext.getRequest().getSession().setAttribute("hs", hs);
		ServletActionContext.getRequest().getSession().setAttribute("hid", hs.getId());
		return null;
	}
	public String detailsFang(){
		List<House> list=(List<House>) ServletActionContext.getRequest().getSession().getAttribute("listShow");
		House hs=new House();
		String typeindex=null;
		for (House house : list) {
			if(house.getId().toString().equals(Integer.valueOf(hid).toString())){
				hs=house;
			}
		}
		ServletActionContext.getRequest().getSession().setAttribute("hs", hs);
		return "SUCCESS";
	}
	public IHouseService getHouseService() {
		return houseService;
	}
	public void setHouseService(IHouseService houseService) {
		this.houseService = houseService;
	}
	public String getPriceList() {
		return priceList;
	}
	public void setPriceList(String priceList) {
		this.priceList = priceList;
	}
	public String getHiddendistrict() {
		return hiddendistrict;
	}
	public void setHiddendistrict(String hiddendistrict) {
		this.hiddendistrict = hiddendistrict;
	}
	public String getHiddenstreet() {
		return hiddenstreet;
	}
	public void setHiddenstreet(String hiddenstreet) {
		this.hiddenstreet = hiddenstreet;
	}
	public String getHiddentypes() {
		return hiddentypes;
	}
	public void setHiddentypes(String hiddentypes) {
		this.hiddentypes = hiddentypes;
	}
	public String getFloorage() {
		return floorage;
	}
	public void setFloorage(String floorage) {
		this.floorage = floorage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getFabu_di() {
		return fabu_di;
	}
	public void setFabu_di(String fabu_di) {
		this.fabu_di = fabu_di;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getHouseDate() {
		return houseDate;
	}
	public void setHouseDate(String houseDate) {
		this.houseDate = houseDate;
	}
	public String getStreet_id() {
		return street_id;
	}
	public void setStreet_id(String street_id) {
		this.street_id = street_id;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDelhouseid() {
		return delhouseid;
	}
	public void setDelhouseid(String delhouseid) {
		this.delhouseid = delhouseid;
	}
	public String getUpdhouseid() {
		return updhouseid;
	}
	public void setUpdhouseid(String updhouseid) {
		this.updhouseid = updhouseid;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	
}
