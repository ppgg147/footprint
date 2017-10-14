package wjp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import wjp.bean.Group;
import wjp.bean.GroupMember;
import wjp.bean.Result;
import wjp.dao.GroupMemberDao;
import wjp.service.GroupMemberService;

public class GroupMemberDaoImpl extends HibernateDaoSupport implements GroupMemberDao {

	@Override
	public List<GroupMember> list(String serachStr, Integer pageNum,
			Integer numPerPage) {
		List myList = null;
		int firstResult = (pageNum.intValue() - 1) * numPerPage.intValue();
		int maxResults = numPerPage.intValue();
		DetachedCriteria criteria = DetachedCriteria.forClass(GroupMember.class);
//		criteria.add(Restrictions.like("name", serachStr,
//				MatchMode.ANYWHERE));
		myList = this.getHibernateTemplate().findByCriteria(criteria,
				firstResult, maxResults);
		return myList;
	}

	@Override
	public Result<GroupMember> findById(int id) {
		Result<GroupMember> result = new Result<>();
		Session session = super.getSessionFactory().openSession();
		GroupMember groupMember = (GroupMember) session.get(GroupMember.class, id);
		if (groupMember == null) {
			groupMember = new GroupMember();
		}
		result.success = true;
		result.data = groupMember;
		result.info = "获取成功!";
		return result;
	}

	@Override
	public Result<GroupMember> apiList(String province, int from, int pagerCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(GroupMember groupMember) {
		super.getHibernateTemplate().save(groupMember);
	}

	@Override
	public void update(GroupMember groupMember) {
		super.getHibernateTemplate().update(groupMember);
	}

	@Override
	public void delete(GroupMember groupMember) {
		super.getHibernateTemplate().delete(groupMember);
	}

	@Override
	public void delete(int id) {
		Session session = super.getSessionFactory().openSession();
		session.beginTransaction();
		GroupMember groupMember = (GroupMember) session.get(GroupMember.class, id);
		session.delete(groupMember);
		session.getTransaction().commit();
	}

	@Override
	public Integer totalCount(String serachStr) {
		int totalCount = 0;
		String hql = "select count(*) from GroupMember";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			totalCount = list.get(0).intValue();
		}
		return totalCount;
	}

}
