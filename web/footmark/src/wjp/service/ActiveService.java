package wjp.service;

import java.util.Date;
import java.util.List;

import wjp.bean.Active;
import wjp.bean.Group;
import wjp.bean.Result;
import wjp.bean.User;

public interface ActiveService {
	public List<Active> list(String serachStr, Integer pageNum,
			Integer numPerPage);//分页
	public Result<Active> findById(int id);//根据id查询
	public Result<Active> apiList(String province, int from, int pagerCount);//接口分页查询
	public void save(Active active);//保存active
	public void add(User user,String name,String province,String collectionSite,String activitySite,Date beginTime,Date endTime,int personMaxNum,double activityLongitude,double activityLatitude,String description,String imagePaths);
	public void update(Active active);//更新active
	public void delete(Active active);//删除active
	public void delete(int id);//删除active
	public Integer totalCount(String serachStr);
	public Active findActiveByModel(Active active);//查询Active
	public void addActive(Group group2, User user, String name, String province,
			String collectionSite, String activitySite, Date beginTime,
			Date endTime, int personMaxNum, double activityLongitude,
			double activityLatitude, String description, String imagePaths);
}
