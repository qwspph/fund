package dao;

import bean.User;
import exception.UserExistException;

public interface IUserDao {
	public int insertUser(User user) throws UserExistException;
	public User loginUser(String name,String pwd);
}
