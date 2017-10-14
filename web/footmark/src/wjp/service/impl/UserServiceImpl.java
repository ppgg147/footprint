package wjp.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import wjp.bean.Result;
import wjp.bean.User;
import wjp.dao.UserDao;
import wjp.service.UserService;
import wjp.util.IMDao;
@Transactional
public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Result<User> login(String mobilePhone, String password) {
		return userDao.login(mobilePhone, password);
	}

	@Override
	public Result<User> regist(String mobilePhone, String password) {
		Result<User> result = new Result<>();
		String uuid=IMDao.iMDao.regist(mobilePhone, password);
		if(uuid==null||uuid.equals("")){
			result.success=false;
			result.info="注册失败,该手机号已存在!";
		}else{
			result=userDao.regist(mobilePhone, password,uuid);
		}
		return result;
	}

	@Override
	public Result<User> findByToken(String mobilePhone, String token) {
		// TODO Auto-generated method stub
		return userDao.findByToken(mobilePhone, token);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public Integer totalCount(String serachStr) {
		return userDao.totalCount(serachStr);
	}

	@Override
	public List<User> list(String serachStr, Integer pageNum, Integer numPerPage) {
		// TODO Auto-generated method stub
		return userDao.list(serachStr, pageNum, numPerPage);
	}

	@Override
	public Result<User> findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public Result<String> check(String mobilePhone) {
		// TODO Auto-generated method stub
		return userDao.check(mobilePhone);
	}

}
