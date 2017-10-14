package wjp.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * �����¼
 * @author WJP
 *
 */
public class ChatRecord implements Serializable {
	private static final long serialVersionUID = -7113831707251798737L;
	private int id;
	private int type;//1������ 2������ 3������  4:ͼƬ  5:��Ƶ
	private User fromUser;//������
	private Group group;//����Ⱥ��
	private Date sendTime;
	private String content;//��Ϣ����
	private String filePath;//ý����Ϣ·��
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
