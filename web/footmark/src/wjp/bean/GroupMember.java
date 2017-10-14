package wjp.bean;

import java.io.Serializable;
import java.util.Date;

public class GroupMember implements Serializable{
	private static final long serialVersionUID = -610105274672466836L;
	private int id;
	private Group group;// ��ӦȺ��
	private User user;//��Ӧ�û�
	private Date joinTime;// ʱ�䣨����ʱ�䣩
	private String states;// ״̬��δ��ˡ�ͨ������ͨ����
	private String statesIntroduce;// ״̬˵��
	private Date checkTime;// ���ʱ��
	private String remark;// ���˵����Ⱥ������Ա��
	
	@Override
	public String toString() {
		return "GroupMember [id=" + id + ", group=" + group + ", user=" + user
				+ ", joinTime=" + joinTime + ", states="
				+ states + ", statesIntroduce=" + statesIntroduce
				+ ", checkTime=" + checkTime + ", remark=" + remark + "]";
	}
	public int getId() {
		return id;
	}
	public Group getGroup() {
		return group;
	}
	public User getUser() {
		return user;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public String getStates() {
		return states;
	}
	public String getStatesIntroduce() {
		return statesIntroduce;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public void setStatesIntroduce(String statesIntroduce) {
		this.statesIntroduce = statesIntroduce;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
