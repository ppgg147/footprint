package wjp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import wjp.bean.Active;
import wjp.bean.Group;
import wjp.bean.Result;
import wjp.bean.User;
import wjp.dao.ActiveDao;
import wjp.service.ActiveService;
@Transactional
public class ActiveServiceImpl implements ActiveService {
	private ActiveDao activeDao;
	
	public ActiveDao getActiveDao() {
		return activeDao;
	}

	public void setActiveDao(ActiveDao activeDao) {
		this.activeDao = activeDao;
	}

	@Override
	public List<Active> list(String serachStr, Integer pageNum,
			Integer numPerPage) {
		// TODO Auto-generated method stub
		return activeDao.list(serachStr, pageNum, numPerPage);
	}

	@Override
	public Result<Active> findById(int id) {
		// TODO Auto-generated method stub
		return activeDao.findById(id);
	}

	@Override
	public void save(Active active) {
		activeDao.save(active);
	}

	@Override
	public void update(Active active) {
		activeDao.update(active);
	}

	@Override
	public void delete(Active active) {
		activeDao.delete(active);
	}

	@Override
	public void delete(int id) {
		activeDao.delete(id);
	}

	@Override
	public Integer totalCount(String serachStr) {
		return activeDao.totalCount(serachStr);
	}

	@Override
	public Result<Active> apiList(String province, int from, int pagerCount) {
		// TODO Auto-generated method stub
		return activeDao.apiList(province, from, pagerCount);
	}

	@Override
	public Active findActiveByModel(Active active) {
		return activeDao.findActiveByModel(active);
	}

	@Override
	public void add(User user, String name, String province,
			String collectionSite, String activitySite, Date beginTime,
			Date endTime, int personMaxNum, double activityLongitude,
			double activityLatitude, String description, String imagePaths) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addActive(Group group, User user, String name,
			String province, String collectionSite, String activitySite,
			Date beginTime, Date endTime, int personMaxNum,
			double activityLongitude, double activityLatitude,
			String description, String imagePaths) {
		Active active=new Active();
		active.setActivityLatitude(activityLatitude);
		active.setActivityLongitude(activityLongitude);
		active.setActivitySite(activitySite);
		active.setBeginTime(beginTime);
		active.setCollectionSite(collectionSite);
		active.setCreateTime(new Date());
		active.setDescription(description);
		active.setEndTime(endTime);
		active.setImagePaths(imagePaths);
		active.setName(name);
		active.setPersonMaxNum(personMaxNum);
		active.setProvince(province);
		active.setUser(user);
		active.setGroup(group);
		activeDao.save(active);
	}
}
