package wjp.bean;

import java.io.Serializable;
import java.util.Date;

public class Group implements Serializable{
	private static final long serialVersionUID = -991251010430204737L;
	private Integer sqlId;//����Id	
	private String headpicture;//Ⱥͷ�񣨴洢·����
	private String id;//Ⱥ�� ID��Ⱥ��Ψһ��ʶ�����ɻ��ŷ���������
	private String name;//Ⱥ����	
	private boolean ispublic;//Ⱥ�����ͣ�true������Ⱥ��false��˽��Ⱥ��	
	private boolean membersonly;//�Ƿ�ֻ��Ⱥ��Ա���Խ������ԡ�true���ǣ�false����
	private boolean allowinvites;//�Ƿ�����Ⱥ��Ա������˼����Ⱥ
	private Integer maxusers;//Ⱥ��Ա����
	private Integer affiliations_count;//���г�Ա����
	private String owner;//Ⱥ���Ļ��� Id
	private Date createTime;//����
	private String description;//Ⱥ����
	private boolean invite_need_confirm;//�����Ⱥ�����������Ƿ���Ҫȷ��
	private Integer refreshSecond;//ˢ��ʱ�������룩
	private Integer activeId;//��Ӧ�ĻId
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
