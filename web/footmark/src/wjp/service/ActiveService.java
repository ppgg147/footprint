package wjp.service;

import java.util.Date;
import java.util.List;

import wjp.bean.Active;
import wjp.bean.Group;
import wjp.bean.Result;
import wjp.bean.User;

public interface ActiveService {
	public List<Active> list(String serachStr, Integer pageNum,
			Integer numPerPage);//��ҳ
	public Result<Active> findById(int id);//����id��ѯ
	public Result<Active> apiList(String province, int from, int pagerCount);//�ӿڷ�ҳ��ѯ
	public void save(Active active);//����active
	public void add(User user,String name,String province,String collectionSite,String activitySite,Date beginTime,Date endTime,int personMaxNum,double activityLongitude,double activityLatitude,String description,String imagePaths);
	public void update(Active active);//����active
	public void delete(Active active);//ɾ��active
	public void delete(int id);//ɾ��active
	public Integer totalCount(String serachStr);
	public Active findActiveByModel(Active active);//��ѯActive
	public void addActive(Group group2, User user, String name, String province,
			String collectionSite, String activitySite, Date beginTime,
			Date endTime, int personMaxNum, double activityLongitude,
			double activityLatitude, String description, String imagePaths);
}
