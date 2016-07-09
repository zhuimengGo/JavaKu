package ServiceImpl;

import pojo.Users;
import Dao.IUsersDao;
import Service.IUsersService;

public class UsersService implements IUsersService{
	private IUsersDao ud;
	@Override
	public void saveUser(Users u) {
		// TODO Auto-generated method stub
		ud.saveUser(u);
	}

	@Override
	public Users findByName(String i) {
		return ud.findByName(i);
	}
	@Override
	public void saveorupdate(Users u) {
		ud.saveorupdate(u);
	}
	public IUsersDao getUd() {
		return ud;
	}

	public void setUd(IUsersDao ud) {
		this.ud = ud;
	}

	



	
	
}
