package wjp.action;

import java.util.Date;
import java.util.List;

import wjp.bean.Active;
import wjp.bean.Group;
import wjp.bean.Result;
import wjp.bean.User;
import wjp.service.ActiveService;
import wjp.service.GroupMemberService;
import wjp.service.GroupService;
import wjp.service.UserService;
import wjp.util.IMDao;
import wjp.util.JsonUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户控制器
 * 
 * @author WJP
 * 
 */
public class GroupAction extends ActionSupport {
	private UserService userService;
	private ActiveService activeService;
	private GroupService groupService;
	private GroupMemberService groupMemberService;
	private User user = new User();
	private Group group = new Group();
	private String mobilePhone;// 手机号（登录Id）(唯一)
	private String token;// Token
	
	private Integer sqlId=0;//自增Id	
	private String headpicture;//群头像（存储路径）
	private String id;//群组 ID，群组唯一标识符，由环信服务器生成
	private String name;//群名称	
	private boolean ispublic;//群组类型：true：公开群，false：私有群。	
	private boolean membersonly;//是否只有群成员可以进来发言。true：是，false：否
	private boolean allowinvites;//是否允许群成员邀请别人加入此群
	private Integer maxusers;//群成员上限
	private Integer affiliations_count;//现有成员总数
	private String owner;//群主的环信 Id
	private Date createTime;//创建
	private String description;//群描述
	private boolean invite_need_confirm;//邀请加群，被邀请人是否需要确认
	private Integer refreshSecond;//刷新时间间隔（秒）
	private Integer activeId;//对应的活动Id
	
	private Integer pageNum = Integer.valueOf(1);// 当前页数
	private Integer pageCount = Integer.valueOf(0);// 页数
	private Integer totalCount = Integer.valueOf(0);// 总条数
	private Integer numPerPage = Integer.valueOf(10);// 每页显示多少条
	private String serachStr = "";
	private List<Group> groupList;
	private Result<Group> result = new Result<>();
	private Gson gson = new GsonBuilder().serializeNulls().create();

	private void page() {
		totalCount = groupService.totalCount(serachStr);
		this.pageCount = Integer.valueOf(this.totalCount.intValue()
				% this.numPerPage.intValue() == 0 ? this.totalCount.intValue()
				/ this.numPerPage.intValue() : this.totalCount.intValue()
				/ this.numPerPage.intValue() + 1);
	}

	/**
	 * 后台列表
	 * 
	 * @return
	 */
	public String list() {
		page();
		groupList = groupService.list(serachStr, pageNum, numPerPage);
		return "list";
	}

	public String edit() {
		result = groupService.findById(sqlId);
		group = result.data;
		return "edit";
	}

	public String save() {
		if (group.getSqlId() == null || group.getSqlId() == 0) {
			Group newGroup = IMDao.iMDao.createGroup(new Active(), mobilePhone);
			if (newGroup != null) {
				groupService.save(group);
			}else{
				addActionError("添加失败");
			}
		} else {
			groupService.update(group);
		}
		return "save";
	}

	public String delete() {
		groupService.delete(sqlId);
		return "delete";
	}
	
	public String api_list(){
		Result<User> userResult = userService.findByToken(mobilePhone, token);
		if(!userResult.success){
			result.success=false;
			result.info="身份验证失败!";
		}else{
			result = groupService.apiList(userResult.data);
		}		
		JsonUtils.SendJson(gson.toJson(result));
		return SUCCESS;
	}
	
	/*********************** - 字段 get set - start *************************/
	private static final long serialVersionUID = 4039736161033290904L;
	public GroupService getGroupService() {
		return groupService;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public Group getGroup() {
		return group;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getToken() {
		return token;
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

	public List<Group> getGroupList() {
		return groupList;
	}

	public Result<Group> getResult() {
		return result;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setToken(String token) {
		this.token = token;
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

	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}

	public void setResult(Result<Group> result) {
		this.result = result;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ActiveService getActiveService() {
		return activeService;
	}

	public GroupMemberService getGroupMemberService() {
		return groupMemberService;
	}

	public void setActiveService(ActiveService activeService) {
		this.activeService = activeService;
	}

	public void setGroupMemberService(GroupMemberService groupMemberService) {
		this.groupMemberService = groupMemberService;
	}

	public Integer getSqlId() {
		return sqlId;
	}

	public String getHeadpicture() {
		return headpicture;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isIspublic() {
		return ispublic;
	}

	public boolean isMembersonly() {
		return membersonly;
	}

	public boolean isAllowinvites() {
		return allowinvites;
	}

	public Integer getMaxusers() {
		return maxusers;
	}

	public Integer getAffiliations_count() {
		return affiliations_count;
	}

	public String getOwner() {
		return owner;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public String getDescription() {
		return description;
	}

	public boolean isInvite_need_confirm() {
		return invite_need_confirm;
	}

	public Integer getRefreshSecond() {
		return refreshSecond;
	}

	public Integer getActiveId() {
		return activeId;
	}

	public void setSqlId(Integer sqlId) {
		this.sqlId = sqlId;
	}

	public void setHeadpicture(String headpicture) {
		this.headpicture = headpicture;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIspublic(boolean ispublic) {
		this.ispublic = ispublic;
	}

	public void setMembersonly(boolean membersonly) {
		this.membersonly = membersonly;
	}

	public void setAllowinvites(boolean allowinvites) {
		this.allowinvites = allowinvites;
	}

	public void setMaxusers(Integer maxusers) {
		this.maxusers = maxusers;
	}

	public void setAffiliations_count(Integer affiliations_count) {
		this.affiliations_count = affiliations_count;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setInvite_need_confirm(boolean invite_need_confirm) {
		this.invite_need_confirm = invite_need_confirm;
	}

	public void setRefreshSecond(Integer refreshSecond) {
		this.refreshSecond = refreshSecond;
	}

	public void setActiveId(Integer activeId) {
		this.activeId = activeId;
	}
	
	/*********************** - 字段 get set - end *************************/
}
