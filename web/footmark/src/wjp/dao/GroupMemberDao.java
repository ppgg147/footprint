package wjp.dao;

import java.util.List;

import wjp.bean.Active;
import wjp.bean.Group;
import wjp.bean.GroupMember;
import wjp.bean.Result;

public interface GroupMemberDao {
	public List<GroupMember> list(String serachStr, Integer pageNum,
			Integer numPerPage);// 分页

	public Result<GroupMember> findById(int id);// 根据id查询

	public Result<GroupMember> apiList(String province, int from, int pagerCount);// 接口分页查询

	public void save(GroupMember groupMember);// 保存groupMember

	public void update(GroupMember groupMember);// 更新groupMember

	public void delete(GroupMember groupMember);// 删除groupMember

	public void delete(int id);// 删除groupMember

	public Integer totalCount(String serachStr);
}
