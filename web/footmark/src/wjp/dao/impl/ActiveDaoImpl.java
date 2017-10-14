package wjp.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import wjp.bean.Active;
import wjp.bean.Result;
import wjp.bean.User;
import wjp.dao.ActiveDao;

public class ActiveDaoImpl extends HibernateDaoSupport implements ActiveDao {

	@Override
	public List<Active> list(String serachStr, Integer pageNum,
			Integer numPerPage) {
		List myList = null;
		int firstResult = (pageNum.intValue() - 1) * numPerPage.intValue();
		int maxResults = numPerPage.intValue();
		DetachedCriteria criteria = DetachedCriteria.forClass(Active.class);
		criteria.add(Restrictions.like("name", serachStr,
				MatchMode.ANYWHERE));
		myList = this.getHibernateTemplate().findByCriteria(criteria,
				firstResult, maxResults);
		return myList;
	}

	@Override
	public Result<Active> findById(int id) {
		Result<Active> result = new Result<>();
		Session session = super.getSessionFactory().openSession();
		Active active = (Active) session.get(Active.class, id);
		if (active == null) {
			active = new Active();
		}
		result.success = true;
		result.data = active;
		result.info = "获取成功!";
		return result;
	}

	@Override
	public void save(Active active) {
		super.getHibernateTemplate().save(active);
	}

	@Override
	public void update(Active active) {
		super.getHibernateTemplate().update(active);
	}

	@Override
	public void delete(Active active) {
		super.getHibernateTemplate().delete(active);
	}

	@Override
	public void delete(int id) {
		Session session = super.getSessionFactory().openSession();
		session.beginTransaction();
		Active active = (Active) session.get(Active.class, id);
		session.delete(active);
		session.getTransaction().commit();
	}

	@Override
	public Integer totalCount(String serachStr) {
		int totalCount = 0;
		String hql = "select count(*) from Active where name like '%"+serachStr+"%'";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			totalCount = list.get(0).intValue();
		}
		return totalCount;
	}

	@Override
	public Result<Active> apiList(String province, int from, int pagerCount) {
		Result<Active> result=new Result<>();
		List<Active> myList = new ArrayList<>();
		int firstResult = (from - 1) * pagerCount;
		int maxResults = pagerCount;
		DetachedCriteria criteria = DetachedCriteria.forClass(Active.class);
		if (province != null && !province.equals(""))
			criteria.add(Restrictions.eq("province", province));
		myList = this.getHibernateTemplate().findByCriteria(criteria,
				firstResult, maxResults);
		Active active=new Active();
		SimpleDateFormat formatter; 
		formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss"); 
		List<Active> list = new ArrayList<>();
		for(int i=0;i<myList.size();i++){
			active=myList.get(i);
			Date beginTime=active.getBeginTime();
			Date endTime=active.getEndTime();
			String btime = formatter.format(beginTime); 
			String etime = formatter.format(endTime); 
			try {
				active.setBeginTime(formatter.parse(btime));
				active.setEndTime(formatter.parse(etime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			list.add(active);
			active=new Active();
		}		
		result.success=true;
		result.datas=list;
		result.info="获取成功!";
		return result;
	}

	@Override
	public Active findActiveByModel(Active active) {
		String hql = "from Active where name = ? and userId = ?";
		List<Active> list = this.getHibernateTemplate().find(hql,
				active.getName(), active.getUser().getId());
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

}
