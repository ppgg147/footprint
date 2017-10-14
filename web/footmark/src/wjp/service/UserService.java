package wjp.service;

import java.util.List;

import wjp.bean.Result;
import wjp.bean.User;

public interface UserService {
	public List<User> list(String serachStr, Integer pageNum,
			Integer numPerPage);//��ҳ
	public Result<User> login(String mobilePhone,String password);//��¼
	public Result<User> regist(String mobilePhone,String password);//ע��
	public Result<String> check(String mobilePhone);//����ֻ����Ƿ����
	public Result<User> findByToken(String mobilePhone,String token);//����token��ѯ
	public Result<User> findById(int id);//����id��ѯ
	public void save(User user);//����User
	public void update(User user);//����User
	public void delete(User user);//ɾ��User
	public void delete(int id);//ɾ��User
	public Integer totalCount(String serachStr);
}
