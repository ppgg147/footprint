package wjp.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import wjp.bean.Result;
import wjp.bean.User;
import wjp.service.UserService;
import wjp.util.IMDao;
import wjp.util.JsonUtils;
import wjp.util.MD5Util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �û�������
 * 
 * @author WJP
 * 
 */
public class UserAction extends ActionSupport {
	private UserService userService;
	private User user = new User();
	private Integer id = 0;// /����Id
	private String mobilePhone;// �ֻ��ţ���¼Id��(Ψһ)
	private String password;// ��¼����
	private String headPicture;// ͷ�񣨴洢·����
	private String nickName;// �ǳ�
	private String realName;// ��ʵ����
	private String sex;// �Ա�
	private String birthday;// ����
	private String address;// ��ַ
	private String email;// ����
	private Date lastLoginTime;// �ϴε�¼ʱ��
	private Date registerTime;// ע��ʱ��
	private String token;// Token
	private String individualSignature;// ����ǩ��
	private Integer pageNum = Integer.valueOf(1);// ��ǰҳ��
	private Integer pageCount = Integer.valueOf(0);// ҳ��
	private Integer totalCount = Integer.valueOf(0);// ������
	private Integer numPerPage = Integer.valueOf(10);// ÿҳ��ʾ������
	private String serachStr = "";
	private List<User> userList;
	private Result<User> result = new Result<>();
	private Gson gson = new GsonBuilder().serializeNulls().create();

	private void page() {
		totalCount = userService.totalCount(serachStr);
		this.pageCount = Integer.valueOf(this.totalCount.intValue()
				% this.numPerPage.intValue() == 0 ? this.totalCount.intValue()
				/ this.numPerPage.intValue() : this.totalCount.intValue()
				/ this.numPerPage.intValue() + 1);
	}

	/**
	 * ��̨�б�
	 * 
	 * @return
	 */
	public String list() {
		page();
		System.out.println("---pageCount:" + pageCount + ",totalCount:"
				+ totalCount);
		userList = userService.list(serachStr, pageNum, numPerPage);
		return "list";
	}

	public String edit() {
		result = userService.findById(id);
		user = result.data;
		return "edit";
	}

	public String save() {
		if (user.getId() == null || user.getId() == 0) {
			String uuid = IMDao.iMDao.regist(user.getMobilePhone(),
					MD5Util.md5("123456"));
			if (uuid != null && !uuid.equals("")) {
				user.setUuid(uuid);
				user.setPassword(MD5Util.md5("123456"));
				user.setRegisterTime(new Date());
				userService.save(user);
			}else{
				addActionError("���ʧ��");
			}
		} else {
			userService.update(user);
		}
		return "save";
	}

	public String delete() {
		userService.delete(id);
		return "delete";
	}

	/**
	 * ���绰�Ƿ����
	 * 
	 * @return
	 */
	public String check() {
		Result<String> res = userService.check(mobilePhone);
		JsonUtils.SendJson(gson.toJson(res));
		return SUCCESS;
	}
	/**
	 * ���Id�Ƿ����
	 * 
	 * @return
	 */
	public String checkId() {
		result = userService.findById(id);
		JsonUtils.SendJson(gson.toJson(result));
		return SUCCESS;
	}
	/**
	 * ��¼
	 * 
	 * @return
	 */
	public String login() {
		result = userService.login(mobilePhone, password);
		if (result.success) {
			ActionContext.getContext().getSession()
					.put("nickName", result.data.getNickName());
			ActionContext.getContext().getSession()
					.put("isLogin", Boolean.valueOf(true));
		}
		JsonUtils.SendJson(gson.toJson(result));
		return SUCCESS;
	}

	public String quit() {
		ActionContext.getContext().getSession().put("nickName", "");
		ActionContext.getContext().getSession()
				.put("isLogin", Boolean.valueOf(false));
		return "login";
	}

	/**
	 * ע��
	 * 
	 * @return
	 */
	public String regist() {
		result = userService.regist(mobilePhone, password);
		JsonUtils.SendJson(gson.toJson(result));
		return SUCCESS;
	}

	/**
	 * ��ȡ������Ϣ
	 * 
	 * @return
	 */
	public String info() {
		result = userService.findByToken(mobilePhone, token);
		JsonUtils.SendJson(gson.toJson(result));
		return SUCCESS;
	}

	/**
	 * ���¸�����Ϣ
	 * 
	 * @return
	 */
	public String update() {
		Result<User> result = this.userService.findByToken(mobilePhone, token);
		if (result.success) {
			User model = result.data;
			model.setNickName(nickName);
			model.setSex(sex);
			model.setRealName(realName);
			model.setBirthday(birthday);
			model.setAddress(address);
			model.setEmail(email);
			model.setIndividualSignature(individualSignature);
			this.userService.update(model);
			result.data = model;
		}
		JsonUtils.SendJson(gson.toJson(result));
		return SUCCESS;
	}

	/**
	 * ����ͷ��
	 * 
	 * @return
	 * @throws IOException
	 */
	public String updateHead() {
		JsonUtils.SendJson(gson.toJson(result));
		return SUCCESS;
	}

	/*********************** - �ֶ� get set - start *************************/
	private static final long serialVersionUID = 3546134140442304185L;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getPassword() {
		return password;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public String getHeadPicture() {
		return headPicture;
	}

	public String getNickName() {
		return nickName;
	}

	public String getRealName() {
		return realName;
	}

	public String getSex() {
		return sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public String getToken() {
		return token;
	}

	public String getIndividualSignature() {
		return individualSignature;
	}

	public void setHeadPicture(String headPicture) {
		this.headPicture = headPicture;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setIndividualSignature(String individualSignature) {
		this.individualSignature = individualSignature;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public String getSerachStr() {
		return serachStr;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public void setSerachStr(String serachStr) {
		this.serachStr = serachStr;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	/*********************** - �ֶ� get set - end *************************/
}
