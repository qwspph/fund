/**
 * 
 */
package service.impl;

import bean.User;
import dao.IUserDao;
import dao.impl.UserDaoImpl;
import exception.UserExistException;
import service.IUserService;

/**
 * @author qwspph
 *
 */
public class UserServiceImpl implements IUserService {
	
	private IUserDao UserDao = new UserDaoImpl();
	/* (non-Javadoc)
	 * @see service.IUserService#insertUser(bean.User)
	 */
	@Override
	public int insertUser(User user) throws UserExistException {
		// TODO Auto-generated method stub
		try {
			return UserDao.insertUser(user);
		}catch (UserExistException e) {
			throw new UserExistException("注册的用户已存在！");
		}
//		return UserDao.insertUser(user);
	}

	/* (non-Javadoc)
	 * @see service.IUserService#loginUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User loginUser(String name, String password) {
		// TODO Auto-generated method stub
		return UserDao.loginUser(name, password);
	}

}
