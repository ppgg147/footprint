package wjp.service;

import java.util.List;

import wjp.bean.GroupMember;
import wjp.bean.Result;

public interface GroupMemberService {
	public List<GroupMember> list(String serachStr, Integer pageNum,
			Integer numPerPage);// ��ҳ

	public Result<GroupMember> findById(int id);// ����id��ѯ

	public Result<GroupMember> apiList(String province, int from, int pagerCount);// �ӿڷ�ҳ��ѯ

	public void save(GroupMember groupMember);// ����groupMember

	public void update(GroupMember groupMember);// ����groupMember

	public void delete(GroupMember groupMember);// ɾ��groupMember

	public void delete(int id);// ɾ��groupMember

	public Integer totalCount(String serachStr);
}
