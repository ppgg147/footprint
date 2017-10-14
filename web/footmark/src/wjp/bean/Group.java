package wjp.bean;

import java.io.Serializable;
import java.util.Date;

public class Group implements Serializable{
	private static final long serialVersionUID = -991251010430204737L;
	private Integer sqlId;//自增Id	
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
	public Group() {
		this.sqlId=0;
		this.id="";
	}
	@Override
	public String toString() {
		return "Group [sqlId=" + sqlId + ", headpicture=" + headpicture
				+ ", id=" + id + ", name=" + name + ", ispublic=" + ispublic
				+ ", membersonly=" + membersonly + ", allowinvites="
				+ allowinvites + ", maxusers=" + maxusers
				+ ", affiliations_count=" + affiliations_count + ", owner="
				+ owner + ", createTime=" + createTime + ", description="
				+ description + ", invite_need_confirm=" + invite_need_confirm
				+ ", refreshSecond=" + refreshSecond
				+ "]";
	}
	
	public Integer getActiveId() {
		return activeId;
	}
	public void setActiveId(Integer activeId) {
		this.activeId = activeId;
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
}
