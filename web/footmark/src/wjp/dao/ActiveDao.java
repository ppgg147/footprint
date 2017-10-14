package wjp.dao;

import java.util.List;

import wjp.bean.Active;
import wjp.bean.Result;

public interface ActiveDao {
	public List<Active> list(String serachStr, Integer pageNum,
			Integer numPerPage);//分页
	public Result<Active> findById(int id);//根据id查询
	public Result<Active> apiList(String province, int from, int pagerCount);//接口分页查询
	public void save(Active active);//保存active
	public void update(Active active);//更新active
	public void delete(Active active);//删除active
	public void delete(int id);//删除active
	public Integer totalCount(String serachStr);
	public Active findActiveByModel(Active active);//查询Active
}
