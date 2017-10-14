package wjp.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import wjp.bean.GroupMember;
import wjp.bean.Result;
import wjp.dao.ActiveDao;
import wjp.dao.GroupMemberDao;
import wjp.service.GroupMemberService;
@Transactional
public class GroupMemberServiceImp implements GroupMemberService {
	private GroupMemberDao groupMemberDao;
	
	public GroupMemberDao getGroupMemberDao() {
		return groupMemberDao;
	}

	public void setGroupMemberDao(GroupMemberDao groupMemberDao) {
		this.groupMemberDao = groupMemberDao;
	}

	@Override
	public List<GroupMember> list(String serachStr, Integer pageNum,
			Integer numPerPage) {
		// TODO Auto-generated method stub
		return groupMemberDao.list(serachStr, pageNum, numPerPage);
	}

	@Override
	public Result<GroupMember> findById(int id) {
		// TODO Auto-generated method stub
		return groupMemberDao.findById(id);
	}

	@Override
	public Result<GroupMember> apiList(String province, int from, int pagerCount) {
		// TODO Auto-generated method stub
		return groupMemberDao.apiList(province, from, pagerCount);
	}

	@Override
	public void save(GroupMember groupMember) {
		groupMemberDao.save(groupMember);
	}

	@Override
	public void update(GroupMember groupMember) {
		groupMemberDao.update(groupMember);
	}

	@Override
	public void delete(GroupMember groupMember) {
		groupMemberDao.delete(groupMember);
	}

	@Override
	public void delete(int id) {
		groupMemberDao.delete(id);
	}

	@Override
	public Integer totalCount(String serachStr) {
		return groupMemberDao.totalCount(serachStr);
	}

}
