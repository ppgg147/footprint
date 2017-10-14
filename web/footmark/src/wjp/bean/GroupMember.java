package wjp.bean;

import java.io.Serializable;
import java.util.Date;

public class GroupMember implements Serializable{
	private static final long serialVersionUID = -610105274672466836L;
	private int id;
	private Group group;// 对应群组
	private User user;//对应用户
	private Date joinTime;// 时间（加入时间）
	private String states;// 状态（未审核、通过、不通过）
	private String statesIntroduce;// 状态说明
	private Date checkTime;// 审核时间
	private String remark;// 身份说明（群主，成员）
	
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
