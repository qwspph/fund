package service;

import bean.User;
import exception.UserExistException;

public interface IUserService {
	public int insertUser(User user) throws UserExistException;
	public User loginUser(String name,String password);
}
