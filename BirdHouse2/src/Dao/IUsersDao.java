package Dao;

import pojo.Users;

public interface IUsersDao {
	void saveUser(Users u); 
	Users findByName(String i);
	void  saveorupdate(Users u); 
}
