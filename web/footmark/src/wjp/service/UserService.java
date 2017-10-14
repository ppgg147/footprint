package wjp.service;

import java.util.List;

import wjp.bean.Result;
import wjp.bean.User;

public interface UserService {
	public List<User> list(String serachStr, Integer pageNum,
			Integer numPerPage);//分页
	public Result<User> login(String mobilePhone,String password);//登录
	public Result<User> regist(String mobilePhone,String password);//注册
	public Result<String> check(String mobilePhone);//检查手机号是否可用
	public Result<User> findByToken(String mobilePhone,String token);//根据token查询
	public Result<User> findById(int id);//根据id查询
	public void save(User user);//保存User
	public void update(User user);//更新User
	public void delete(User user);//删除User
	public void delete(int id);//删除User
	public Integer totalCount(String serachStr);
}
