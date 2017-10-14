package wjp.bean;

import java.io.Serializable;

public class Notice implements Serializable{
	private static final long serialVersionUID = -5458997795607641891L;
	private int id;//
	private Group group;//��ӦȺ��
	private String name;//��������
	private String content;//��������
	private String createTime;//����ʱ��
	
	@Override
	public String toString() {
		return "Notice [id=" + id + ", group=" + group + ", name=" + name
				+ ", content=" + content + ", createTime=" + createTime + "]";
	}

	public Notice() {
		this.id=0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
}
