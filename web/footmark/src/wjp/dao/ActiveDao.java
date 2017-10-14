package wjp.dao;

import java.util.List;

import wjp.bean.Active;
import wjp.bean.Result;

public interface ActiveDao {
	public List<Active> list(String serachStr, Integer pageNum,
			Integer numPerPage);//��ҳ
	public Result<Active> findById(int id);//����id��ѯ
	public Result<Active> apiList(String province, int from, int pagerCount);//�ӿڷ�ҳ��ѯ
	public void save(Active active);//����active
	public void update(Active active);//����active
	public void delete(Active active);//ɾ��active
	public void delete(int id);//ɾ��active
	public Integer totalCount(String serachStr);
	public Active findActiveByModel(Active active);//��ѯActive
}
