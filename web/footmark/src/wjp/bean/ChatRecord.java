package wjp.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 聊天记录
 * @author WJP
 *
 */
public class ChatRecord implements Serializable {
	private static final long serialVersionUID = -7113831707251798737L;
	private int id;
	private int type;//1：文字 2：表情 3：语音  4:图片  5:视频
	private User fromUser;//发送人
	private Group group;//所属群组
	private Date sendTime;
	private String content;//消息内容
	private String filePath;//媒体消息路径
	public int getId() {
		return id;
	}
	public int getType() {
		return type;
	}
	public User getFromUser() {
		return fromUser;
	}
	public Group getGroup() {
		return group;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public String getContent() {
		return content;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public String toString() {
		return "ChatRecord [id=" + id + ", type=" + type + ", fromUser="
				+ fromUser + ", group=" + group + ", sendTime=" + sendTime
				+ ", content=" + content + ", filePath=" + filePath + "]";
	}
}
