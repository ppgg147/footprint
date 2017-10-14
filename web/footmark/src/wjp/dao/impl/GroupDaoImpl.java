package wjp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import wjp.bean.Active;
import wjp.bean.Group;
import wjp.bean.Result;
import wjp.bean.User;
import wjp.dao.GroupDao;

public class GroupDaoImpl extends HibernateDaoSupport implements GroupDao{

	@Override
	public List<Group> list(String serachStr, Integer pageNum,
			Integer numPerPage) {
		List myList = null;
		int firstResult = (pageNum.intValue() - 1) * numPerPage.intValue();
		int maxResults = numPerPage.intValue();
		DetachedCriteria criteria = DetachedCriteria.forClass(Group.class);
		criteria.add(Restrictions.like("name", serachStr,
				MatchMode.ANYWHERE));
		myList = this.getHibernateTemplate().findByCriteria(criteria,
				firstResult, maxResults);
		return myList;
	}

	@Override
	public Result<Group> findById(int id) {
		Result<Group> result = new Result<>();
		Session session = super.getSessionFactory().openSession();
		Group group = (Group) session.get(Group.class, id);
		if (group == null) {
			group = new Group();
		}
		result.success = true;
		result.data = group;
		result.info = "获取成功!";
		return result;
	}
	
	@Override
	public void save(Group group) {
		super.getHibernateTemplate().save(group);
	}

	@Override
	public void update(Group group) {
		super.getHibernateTemplate().update(group);
	}

	@Override
	public void delete(Group group) {
		super.getHibernateTemplate().delete(group);
	}

	@Override
	public void delete(int id) {
		Session session = super.getSessionFactory().openSession();
		session.beginTransaction();
		Group group = (Group) session.get(Group.class, id);
		session.delete(group);
		session.getTransaction().commit();
	}

	@Override
	public Integer totalCount(String serachStr) {
		int totalCount = 0;
		String hql = "select count(*) from Group where name like '%"+serachStr+"%'";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			totalCount = list.get(0).intValue();
		}
		return totalCount;
	}

	@Override
	public Group findByUId(String uid) {
		Group group=new Group();
		String sql = "from Group where id = ?";
		List<Group> list = super.getHibernateTemplate().find(sql, uid);
		if (list == null || list.size() <= 0) {
			group=new Group();
		} else {
			group=list.get(0);
		}
		return group;
	}

	@Override
	public Result<Group> apiList(User user) {
		
		return null;
	}

}
