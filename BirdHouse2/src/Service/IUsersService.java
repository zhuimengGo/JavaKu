package Service;

import pojo.Users;

public interface IUsersService {
	void saveUser(Users u); 
	Users findByName(String i);
	void  saveorupdate(Users u); 
}
