package wjp.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import wjp.bean.Result;
import wjp.bean.User;
import wjp.dao.UserDao;
import wjp.util.SecurityUtil;

/**
 * 
 * @author WJP
 * 
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");

	/**
	 * 登录
	 */
	@Override
	public Result<User> login(String mobilePhone, String password) {
		Result<User> result = new Result<User>();
		String sql = "from User where mobilePhone = ?";
		List<User> list = super.getHibernateTemplate().find(sql, mobilePhone);
		if (list == null || list.size() <= 0) {
			result.success = false;
			result.info = "用户不存在";
		} else {
			if (list.get(0).getPassword().equals(password)) {
				User user = list.get(0);
				user.setLastLoginTime(new Date());
				Map<String, Object> srcData = new HashMap<String, Object>();
				srcData.put("ModelPhone", user.getMobilePhone());
				srcData.put("nowtime", format.format(new Date()));
				String token = SecurityUtil.authentication(srcData);
				user.setToken(token);
				super.getHibernateTemplate().update(user);
				result.success = true;
				result.data = user;
				result.info = "登录成功";
			} else {
				result.success = false;
				result.info = "密码错误";
			}
		}
		return result;
	}

	/**
	 * 注冊
	 */
	@Override
	public Result<User> regist(String mobilePhone, String password,String uuid) {
		Result<User> result = new Result<User>();
		String sql = "from User where mobilePhone = ?";
		List<User> list = super.getHibernateTemplate().find(sql, mobilePhone);
		if (list == null || list.size() <= 0) {
			User u = new User(mobilePhone, password);
			u.setUuid(uuid);
			u.setRegisterTime(new Date());
			super.getHibernateTemplate().save(u);
			result.success = true;
			result.data = u;
			result.info = "注册成功";
		} else {
			result.success = false;
			result.info = "该用户已存在!";
		}
		return result;
	}

	@Override
	public Result<User> findByToken(String mobilePhone, String token) {
		Result<User> result = new Result<User>();
		String sql = "from User where mobilePhone = ? and token = ?";
		List<User> list = super.getHibernateTemplate().find(sql,
				new String[] { mobilePhone, token });
		if (list == null || list.size() <= 0) {
			result.success = false;
			result.code=302;
			result.info = "身份验证失败";
		} else {
			result.success = true;
			result.data = list.get(0);
			result.info = "获取个人信息成功!";
		}
		return result;
	}

	@Override
	public void update(User user) {
		super.getHibernateTemplate().update(user);
	}

	@Override
	public void delete(User user) {
		super.getHibernateTemplate().delete(user);
	}

	@Override
	public Integer totalCount(String serachStr) {
		int totalCount = 0;
		String hql = "select count(*) from User where mobilePhone like '%"+serachStr+"%' and flag != 66";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			totalCount = list.get(0).intValue();
		}
		return totalCount;
	}

	@Override
	public List<User> list(String serachStr, Integer pageNum, Integer numPerPage) {
		List myList = null;
		int firstResult = (pageNum.intValue() - 1) * numPerPage.intValue();
		int maxResults = numPerPage.intValue();
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.ne("flag", 66));
		criteria.add(Restrictions.like("mobilePhone", serachStr,
				MatchMode.ANYWHERE));
		myList = this.getHibernateTemplate().findByCriteria(criteria,
				firstResult, maxResults);
		return myList;
	}

	/**
	 * 通过Id查询用户
	 */
	@Override
	public Result<User> findById(int id) {
		Result<User> result = new Result<>();
		Session session = super.getSessionFactory().openSession();
		User user = (User) session.get(User.class, id);
		if (user == null) {
			user = new User();
			result.success = false;
		}else{
			result.success = true;
		}
		result.data = user;
		result.code=200;
		result.info = "获取成功!";
		return result;
	}

	@Override
	public void save(User user) {
		super.getHibernateTemplate().save(user);
	}

	@Override
	public void delete(int id) {
		Session session = super.getSessionFactory().openSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, id);
		session.delete(user);
		session.getTransaction().commit();
	}

	@Override
	public Result<String> check(String mobilePhone) {
		Result<String> result = new Result<String>();
		String sql = "from User where mobilePhone = ?";	
		List<User> list = super.getHibernateTemplate().find(sql, mobilePhone);
		if (list == null || list.size() <= 0) {
			result.success = true;
			result.data = mobilePhone;
			result.code=200;
			result.info = "该手机号可用";
		} else {
			result.success = false;
			result.code=200;
			result.info = "该手机号已被注册!";
		}
		return result;
	}

}
