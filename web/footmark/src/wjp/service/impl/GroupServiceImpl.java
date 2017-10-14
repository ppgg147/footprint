package wjp.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import wjp.bean.Group;
import wjp.bean.Result;
import wjp.bean.User;
import wjp.dao.GroupDao;
import wjp.service.GroupService;
@Transactional
public class GroupServiceImpl implements GroupService {
	private GroupDao groupDao;
	
	public GroupDao getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	@Override
	public List<Group> list(String serachStr, Integer pageNum,
			Integer numPerPage) {
		// TODO Auto-generated method stub
		return groupDao.list(serachStr, pageNum, numPerPage);
	}

	@Override
	public Result<Group> findById(int id) {
		// TODO Auto-generated method stub
		return groupDao.findById(id);
	}

	@Override
	public void save(Group group) {
		groupDao.save(group);
	}

	@Override
	public void update(Group group) {
		groupDao.update(group);
	}

	@Override
	public void delete(Group group) {
		groupDao.delete(group);
	}

	@Override
	public void delete(int id) {
		groupDao.delete(id);
	}

	@Override
	public Integer totalCount(String serachStr) {
		// TODO Auto-generated method stub
		return groupDao.totalCount(serachStr);
	}

	@Override
	public Group findByUId(String uid) {
		// TODO Auto-generated method stub
		return groupDao.findByUId(uid);
	}

	@Override
	public Result<Group> apiList(User user) {
		return groupDao.apiList(user);
	}

}
