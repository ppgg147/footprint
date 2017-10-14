package wjp.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 轨迹实体
 * 
 * @author Administrator
 * 
 */
public class Trail implements Serializable {
	private static final long serialVersionUID = 8617264739537925665L;
	private Integer id;// 自增ID
	private Group group;//对应群组
	private Active active;//对应活动
	private User user;//对应用户
	private String longitude;// 经度
	private String latitude;// 维度
	private Date createTime;// 创建地点的时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Active getActive() {
		return active;
	}

	public void setActive(Active active) {
		this.active = active;
	}

	public Group getGroup() {
		return group;
	}

	public User getUser() {
		return user;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Trail [id=" + id + ", group=" + group + ", active=" + active
				+ ", user=" + user + ", longitude=" + longitude + ", latitude="
				+ latitude + ", createTime=" + createTime + "]";
	}

	

}
