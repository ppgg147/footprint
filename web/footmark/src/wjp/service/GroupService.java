package wjp.service;

import java.util.List;

import wjp.bean.Group;
import wjp.bean.Result;
import wjp.bean.User;

public interface GroupService {
	public List<Group> list(String serachStr, Integer pageNum,
			Integer numPerPage);//分页
	public Result<Group> findById(int id);//根据id查询
	public Group findByUId(String uid);//根据环信id查询
	public void save(Group group);//保存group
	public void update(Group group);//更新group
	public void delete(Group group);//删除group
	public void delete(int id);//删除group
	public Integer totalCount(String serachStr);
	public Result<Group> apiList(User user);
}
