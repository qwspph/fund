package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.User;
import dao.IUserDao;
import exception.UserExistException;
import util.DBHelper;

public class UserDaoImpl implements IUserDao {

	@Override
	public int insertUser(User user) throws UserExistException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int row = 0;
		try {
			connection = DBHelper.getConnection();
			String sql = "select * from tb_user where account=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getAccount());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				throw new UserExistException("注册的用户名已存在");
			}else {
				String sql2 = "insert into tb_user(account,password,email) values(?,?,?)";
				preparedStatement = connection.prepareStatement(sql2);
				preparedStatement.setString(1, user.getAccount());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.setString(3, user.getEmail());
				row = preparedStatement.executeUpdate();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeALL(connection, preparedStatement);
		}
		return row;
	}

	@Override
	public User loginUser(String name, String pwd) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = new User();
		try {
			connection = DBHelper.getConnection();
			String sql = "select * from tb_user where account=? and password=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,name);
			preparedStatement.setString(2, pwd);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setAccount(resultSet.getString("account"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeALL(connection,preparedStatement);
		}
		return user;
	}
}
