package wjp.service;

import java.util.List;

import wjp.bean.Group;
import wjp.bean.Result;
import wjp.bean.User;

public interface GroupService {
	public List<Group> list(String serachStr, Integer pageNum,
			Integer numPerPage);//��ҳ
	public Result<Group> findById(int id);//����id��ѯ
	public Group findByUId(String uid);//���ݻ���id��ѯ
	public void save(Group group);//����group
	public void update(Group group);//����group
	public void delete(Group group);//ɾ��group
	public void delete(int id);//ɾ��group
	public Integer totalCount(String serachStr);
	public Result<Group> apiList(User user);
}
