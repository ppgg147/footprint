package wjp.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import wjp.bean.Active;
import wjp.bean.Group;
import wjp.bean.GroupMember;
import wjp.bean.Result;
import wjp.bean.User;
import wjp.service.ActiveService;
import wjp.service.GroupMemberService;
import wjp.service.GroupService;
import wjp.service.UserService;
import wjp.util.IMDao;
import wjp.util.JsonUtils;
import wjp.util.MD5Util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class ActiveAction extends ActionSupport {
	private static final long serialVersionUID = 349912801937024810L;
	private String mobilePhone;// �ֻ��ţ���¼Id��(Ψһ)
	private String token;// Token
	private Integer id = 0;// iD����
	private String name;// �����
	private String province;// ʡ��
	private String collectionSite;// ���ϵص�
	private String activitySite;// ��ص�
	private Date beginTime;// ��ʼʱ��
	private Date endTime;// ����ʱ��
	private int personMaxNum;// �������
	private double activityLongitude;// ��ص㾭��
	private double activityLatitude;// ��ص㾭��
	private String description;// ����
	private String imagePaths;// ͼƬ·������ �� ; �� �ָ���
	private Integer userId = 0;// ������
	private Date createTime;// ����ʱ��
	private UserService userService;
	private ActiveService activeService;
	private GroupService groupService;
	private GroupMemberService groupMemberService;
	private Active active;
	private User user = null;
	private int from;// ���ݿ�ʼ�����±�
	private int pagerCount;// ���ݼ��صĳ���
	private Integer pageNum = Integer.valueOf(1);// ��ǰҳ��
	private Integer pageCount = Integer.valueOf(0);// ҳ��
	private Integer totalCount = Integer.valueOf(0);// ������
	private Integer numPerPage = Integer.valueOf(10);// ÿҳ��ʾ������
	private String serachStr = "";
	private List<Active> activeList = new ArrayList<>();
	private Result<Active> result = new Result<>();
	private Gson gson = new GsonBuilder().serializeNulls().create();

	private void page() {
		totalCount = activeService.totalCount(serachStr);
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
		List<Active> list = activeService.list(serachStr, pageNum, numPerPage);
		Active bean=new Active();
		for(int i=0;i<list.size();i++){
			bean=list.get(i);
			if(bean.getDescription()!=null&&bean.getDescription().length()>15){
				bean.setDescription(bean.getDescription().substring(0, 14)+"...");
			}
			activeList.add(bean);
		}
		return "list";
	}

	public String edit() {
		result = activeService.findById(id);
		active = result.data;
		return "edit";
	}

	public String save() {
		if (active.getId() == null || active.getId() == 0) {
			active.setUser(userService.findById(userId).data);
			user=active.getUser();
			active.setActivityLongitude(106.567514);
			active.setActivityLatitude(29.544858);
			Date createDate = new Date();
			active.setCreateTime(createDate);

			Group group = new Group();
			group = IMDao.iMDao.createGroup(active, active.getUser().getMobilePhone());
			if (group != null) {
				group = IMDao.iMDao.groupDetail(group.getId());
				group.setOwner(active.getUser().getMobilePhone());
				group.setCreateTime(new Date());
				group.setName(active.getName());
				group.setRefreshSecond(5);
				String desc = "...";
				desc=active.getDescription()==null?"":active.getDescription();
				if (desc.length() > 15) {
					desc = desc.substring(0, 14) + "...";
				}
				group.setDescription(desc);
				group.setHeadpicture("Images/Heads/" + group.getId()
						+ "_gh.png");
				group.setActiveId(0);
				this.groupService.save(group);

				Group group2 = groupService.findByUId(group.getId());
				
				// �洢Ⱥ��Ա��Ϣ(Ĭ�����Ⱥ��)
				GroupMember member=new GroupMember();
				member.setGroup(group2);
				member.setUser(user);
				member.setJoinTime(new Date());
				member.setRemark("Ⱥ��");
				member.setStates("ͨ��");
				member.setCheckTime(new Date());
				groupMemberService.save(member);
				
				active.setGroup(group2);
				activeService.save(active);
				Active bean = activeService.findActiveByModel(active);
				if (bean != null) {
					user.setCurrentlyActiveId(bean.getId());
					this.userService.update(user);
					group2.setActiveId(bean.getId());
					this.groupService.update(group2);
				}
			}
		} else {
			active.setUser(userService.findById(userId).data);
			activeService.update(active);
		}
		return "save";
	}

	public String delete() {
		activeService.delete(id);
		return "delete";
	}

	public String api_list() {
		result = activeService.apiList(this.province, this.from,
				this.pagerCount);
		JsonUtils.SendJson(gson.toJson(result));
		return SUCCESS;
	}

	public String add() {
		result = new Result<>();
		user = userService.findByToken(mobilePhone, token).data;
		if (user != null) {
			active = new Active(name, province, collectionSite, activitySite,
					beginTime, endTime, personMaxNum, activityLongitude,
					activityLatitude, description, imagePaths, createTime, user);
			if (active != null) {
				Group group = new Group();
				group = IMDao.iMDao.createGroup(active, mobilePhone);
				if (group == null) {
					result.success = false;
					result.code = 200;
					result.info = "����Ⱥ��ʧ��,�������Ƿ���!";
				} else {
					// �洢Ⱥ��
					group = IMDao.iMDao.groupDetail(group.getId());
					group.setOwner(mobilePhone);
					group.setCreateTime(new Date());
					group.setName(active.getName());
					group.setRefreshSecond(5);
					String desc = "...";
					if (description.length() > 15) {
						desc = description.substring(0, 14) + "...";
					} else {
						desc = description;
					}
					group.setDescription(desc);
					group.setHeadpicture("Images/Heads/" + group.getId()
							+ "_gh.png");
					group.setActiveId(0);
					this.groupService.save(group);

					Group group2 = groupService.findByUId(group.getId());
					
					// �洢Ⱥ��Ա��Ϣ(Ĭ�����Ⱥ��)
					GroupMember member=new GroupMember();
					member.setGroup(group2);
					member.setUser(user);
					member.setJoinTime(new Date());
					member.setRemark("Ⱥ��");
					member.setStates("ͨ��");
					member.setCheckTime(new Date());
					groupMemberService.save(member);
					
					// �洢Active
					activeService.addActive(group2, user, name, province,
							collectionSite, activitySite, beginTime, endTime,
							personMaxNum, activityLongitude, activityLatitude,
							description, imagePaths);

					Active bean = activeService.findActiveByModel(active);
					if (bean != null) {
						user.setCurrentlyActiveId(bean.getId());
						this.userService.update(user);
						group2.setActiveId(bean.getId());
						this.groupService.update(group2);
						result.success = true;
						result.code = 200;
						result.info = "������ɹ�!";
					} else {
						result.success = false;
						result.code = 200;
						result.info = "�����ʧ��!";
					}
				}
			} else {
				result.success = false;
				result.code = 200;
				result.info = "�����ʧ��,�������Ƿ���!";
			}
		} else {
			result.success = true;
			result.code = 302;
			result.info = "�����֤ʧ�ܣ������µ�¼!";
		}
		JsonUtils.SendJson(gson.toJson(result));
		return SUCCESS;
	}

	public String info() {
		if (id == null) {
			id = 0;
		}
		result = activeService.findById(id);
		JsonUtils.SendJson(gson.toJson(result));
		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProvince() {
		return province;
	}

	public String getCollectionSite() {
		return collectionSite;
	}

	public String getActivitySite() {
		return activitySite;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public int getPersonMaxNum() {
		return personMaxNum;
	}

	public double getActivityLongitude() {
		return activityLongitude;
	}

	public double getActivityLatitude() {
		return activityLatitude;
	}

	public String getDescription() {
		return description;
	}

	public String getImagePaths() {
		return imagePaths;
	}

	public Integer getUserId() {
		return userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public UserService getUserService() {
		return userService;
	}

	public ActiveService getActiveService() {
		return activeService;
	}

	public Active getActive() {
		return active;
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

	public Integer getNumPerPage() {
		return numPerPage;
	}

	public String getSerachStr() {
		return serachStr;
	}

	public List<Active> getActiveList() {
		return activeList;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCollectionSite(String collectionSite) {
		this.collectionSite = collectionSite;
	}

	public void setActivitySite(String activitySite) {
		this.activitySite = activitySite;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setPersonMaxNum(int personMaxNum) {
		this.personMaxNum = personMaxNum;
	}

	public void setActivityLongitude(double activityLongitude) {
		this.activityLongitude = activityLongitude;
	}

	public void setActivityLatitude(double activityLatitude) {
		this.activityLatitude = activityLatitude;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImagePaths(String imagePaths) {
		this.imagePaths = imagePaths;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setActiveService(ActiveService activeService) {
		this.activeService = activeService;
	}

	public void setActive(Active active) {
		this.active = active;
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

	public void setNumPerPage(Integer numPerPage) {
		this.numPerPage = numPerPage;
	}

	public void setSerachStr(String serachStr) {
		this.serachStr = serachStr;
	}

	public void setActiveList(List<Active> activeList) {
		this.activeList = activeList;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getToken() {
		return token;
	}

	public User getUser() {
		return user;
	}

	public int getFrom() {
		return from;
	}

	public int getPagerCount() {
		return pagerCount;
	}

	public Result<Active> getResult() {
		return result;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public void setPagerCount(int pagerCount) {
		this.pagerCount = pagerCount;
	}

	public GroupService getGroupService() {
		return groupService;
	}

	public GroupMemberService getGroupMemberService() {
		return groupMemberService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public void setGroupMemberService(GroupMemberService groupMemberService) {
		this.groupMemberService = groupMemberService;
	}

	public void setResult(Result<Active> result) {
		this.result = result;
	}
}
